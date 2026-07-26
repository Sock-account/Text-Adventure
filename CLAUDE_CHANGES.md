# Changes

Summary of the uncommitted work in the tree (everything since commit `0855038 Game start has been made`).

Files touched:

| File | Change |
| --- | --- |
| `Text Adventure/TextAdvent/src/Window.java` | Layout rewrite, quirks screen fixes, working game start screen with typewriter text |
| `Text Adventure/TextAdvent/src/Character.java` | Added `getName()` |
| `Text Adventure/TextAdvent/bin/*.class` | Recompiled output (build artifacts, not source) |

---

## 1. Every screen now scales with the window

The old code added panels to a default `FlowLayout` panel and then re-assigned fixed
grid layouts (`GridLayout(6, 3)`, `GridLayout(3, 3)`) after the fact, so the contents
stayed at their preferred size and clumped into the top-left when the frame was resized.

Each screen was moved to a `BorderLayout` root panel:

- The main `window` panel is `BorderLayout`, and every screen is added to `CENTER`, so
  the active screen stretches to fill the frame.
- **Start screen** — `GridBagLayout` with a single column (`gridx = 0`) and 10px insets,
  which keeps the title and Start button centred at any window size.
- **Character creator** — name row in `NORTH`, Create Character button in `SOUTH`, and the
  four stat rows in a `GridLayout(0, 1)` in `CENTER`, so the stat rows absorb the leftover
  space and split it evenly.
- **Quirks screen** — heading in `NORTH`, submit in `SOUTH`, quirk buttons in a
  `GridLayout(0, 2, 6, 6)` in `CENTER`.

The Create Character and Submit buttons are each wrapped in a plain `FlowLayout` panel
before going into `SOUTH`. A button added straight to a `BorderLayout` region gets
stretched across the whole region; the wrapper keeps it at its natural size.

## 2. Frame setup

- Removed the stray second `JFrame Game` that was being built, packed and given a
  `GridLayout(4, 4)` but never actually shown — all setup goes through `this` now.
- Removed the `@SuppressWarnings("deprecation")` annotation and the
  "figure out how to change elements dynamically" TODO, both now obsolete.
- Title changed from "Text Adventure" to **"Sand Pit"** (frame title and on-screen label).
- Title label bumped to bold 28pt.
- Size 600x500 with a 380x340 minimum, and `setLocationRelativeTo(null)` so the window
  opens centred on screen.

## 3. Screen transitions actually remove the old screen

- Start button previously removed the title and button from `start` but left the empty
  `start` panel in place. It now removes `start` from `window` outright.
- Submit on the quirks screen now removes `quirkscreen` before calling `Game_start`,
  so the game screen isn't drawn underneath the quirk buttons.
- The Start button was a `JButton` with a `JLabel("Start")` added inside it; it is now
  just `new JButton("Start")`.

## 4. Quirks screen cleanup

- The "Quirks" heading was inside the button grid, taking up a grid cell — it's now a
  centred label in `NORTH`.
- The submit button was being added twice: once bare into `quirk_panel` and once via
  `submit_space`. Only the wrapped `submit_space` version remains.

## 5. `Game_start` implemented

It was an empty method body. It now builds the game screen:

- A read-only `JTextArea` (10x34) with word wrap, monospaced 14pt, green-on-black,
  and an 8px margin, inside a `JScrollPane` in `CENTER`.
- The opening line — `"You wake to a impregnable darkness."` — is typed out through the
  new `typeText` helper.

## 6. New `typeText(JTextArea, String, int)` helper

Reveals a string one character at a time using a `javax.swing.Timer` at the given
delay (35ms for the opening line). The cursor position is held in a one-element `int[]`
so the timer and mouse listeners can both update it.

Clicking the text area skips the animation: the timer stops, the rest of the string is
appended at once, and the listener removes itself.

Added imports: `java.awt.event.MouseAdapter`, `java.awt.event.MouseEvent`.

## 7. `Character.getName()`

Added the getter alongside the existing `setQuirks`, so the game screen can address the
player by name.

---

## Not done / still open

- The stat +/- buttons and the create-character wiring are unchanged — the existing TODO
  in `Chara_Creator` still stands.
- The commented-out quirk panel block inside `Chara_Creator` was left as-is (the live
  quirks UI is in `Quirkwin`).
- `Main.java` is unchanged; `bin/Main.class` differs only because the project was recompiled.
- The `bin/` class files are tracked in git. They're build output and would normally be
  gitignored rather than committed.

---

## 8. Quirk buttons made smaller

The six quirk buttons in `Quirkwin` filled almost the entire window. `quirk_panel` is a
`GridLayout` sitting in the `CENTER` of a `BorderLayout`, so it received every pixel left
over after the "Quirks" heading and the Submit button, then divided that area into six
equal cells and stretched a button across each one.

The obvious fix — `setPreferredSize` on each button — does nothing here, because
`GridLayout` computes cell size from the container's area and ignores the preferred size
of its children entirely. The space had to be taken away from the cells instead:

- The `GridLayout` hgap and vgap went from 6 to 20, widening the channels between cells.
- `quirk_panel` gained an `EmptyBorder(20, 60, 20, 60)`, which insets the whole grid from
  the edges of the `CENTER` region before the cells are measured. The left/right inset is
  larger than the top/bottom one because the buttons were far wider than they were tall.

The buttons still grow and shrink with the frame, matching how the rest of the screens
behave — they just start from a smaller share of it.

Still open: this scales the buttons proportionally, so on a very large window they will
still be large. Pinning them to a fixed size would mean wrapping `quirk_panel` in a
`GridBagLayout` holder, which respects preferred sizes, and setting the same `Dimension`
on all six buttons.

## 9. Dialogue options panel on the game screen

`Game_start` built a game screen that was nothing but the story text — there was no way for
the player to answer it. It now adds an `options_panel` to `BorderLayout.SOUTH` of
`gamescreen`, alongside the existing `JScrollPane` in `CENTER`.

`SOUTH` is the right region for this rather than a split of `CENTER`: a `BorderLayout`
gives `SOUTH` the full width but only the height its contents ask for, so the story area
keeps every pixel left over and the options never squash it. Inside, a
`GridLayout(0, 1, 4, 4)` stacks one full-width button per option and grows a row at a time
as the number of options changes, with an `EmptyBorder` holding it off the frame edge.

### `setOptions(JPanel, String[], IntConsumer)`

A new helper fills the panel with one `JButton` per option, calling `removeAll()` on
whatever was there first, so advancing the story is a matter of calling it again with the
next set. Passing an empty array clears the panel.

It takes an `IntConsumer` and hands it the index of the button that was pressed, which
keeps the method ignorant of the story — the caller decides what each choice means. The
loop counter is copied into a local `int choice` before the lambda captures it, because a
lambda can only capture a variable that never changes and `i` is reassigned every pass.

The `revalidate()` at the end is load-bearing. Swing does not re-run a container's layout
for components added after it is already on screen, so without it the new buttons are
never assigned a size or position and simply do not appear.

### `typeText` overload with a completion callback

Options appearing halfway through a sentence looked broken, so `typeText` gained a fourth
parameter, `Runnable onFinished`, that fires once the whole message is on screen. The
original three-argument version remains and delegates with `null`.

Getting "once" right took some restructuring. There are two ways a message can end — the
timer reaching the last character, or the player clicking to skip — and both now funnel
through a single `finish` runnable guarded by a `boolean[] done` flag, so `onFinished`
cannot fire twice for one message. `finish` also detaches the skip listener on both paths;
previously it was only removed on click, and now that `Game_start` calls `typeText`
repeatedly, listeners from completed messages would otherwise pile up on the text area.
The listener is held in a one-element `MouseAdapter[]` because `finish` needs to reference
it and it needs to call `finish`, and neither can be written first otherwise.

The opening text now ends by showing three options — "Open your eyes.", "Stay still and
listen.", "Call out." — and picking one clears the panel and echoes the choice back into
the story.

Added import: `java.util.function.IntConsumer`.

Still open: the echo is placeholder wiring, not content. Each choice needs its own scene,
which likely means a scene type holding text plus its options rather than more nesting
inside `Game_start`. Clearing the options also collapses `SOUTH` to nothing, so the story
area jumps taller while a reply types out and shrinks back when the next set appears.

## 10. Dialogue options restyled to match the story area

The options panel was built with default Swing components, so the game screen was green
monospaced text on black with a row of grey system buttons bolted underneath. The buttons
now use the same palette as the story.

The three style values — `Monospaced` 14pt plain, black, green — were pulled out of
`Game_start` into `TERMINAL_FONT`, `TERMINAL_BG` and `TERMINAL_FG` constants on `Window`,
and the story area now reads its font and colors from them as well. The point is that the
two halves of the screen are styled from one source and cannot drift apart when one of them
is edited later.

### `terminalButton(String)`

A new factory builds a styled dialogue button, keeping `setOptions` about wiring rather
than appearance.

`setForeground` and `setBackground` alone do not work on a `JButton`. The look and feel
paints its own shaded button face across the content area, on top of the background color,
so the button stays grey. `setContentAreaFilled(false)` switches that painting off and
`setOpaque(true)` puts the plain `JComponent` background fill back, which does honor
`setBackground`. Both calls are needed — either one on its own gives a transparent button.

Losing the button face also loses the hover and pressed shading that came with it, so a
`MouseAdapter` swaps the foreground and background on `mouseEntered` and `mouseExited`.
Hovering an option now inverts it to black-on-green, which is the only click affordance
left once the chrome is gone. `setFocusPainted(false)` drops the dotted focus rectangle,
which the look and feel still drew over the flat button.

The outline is a compound border — `createLineBorder` on the outside for the green box,
`createEmptyBorder(6, 10, 6, 10)` on the inside for padding, since a line border alone
would sit tight against the text.

### Backgrounds behind the buttons

Two containers were showing grey through the gaps and had to be blacked out as well:
`options_panel` itself, whose background is visible in the 4px `GridLayout` gaps and the
`EmptyBorder` around the stack, and `gamescreen`.

The `JScrollPane` around the story got the same treatment. It draws its own etched border
and its viewport has its own background, neither inherited from the `JTextArea` inside it,
so the story was sitting in a grey frame. The border is now empty and the viewport black.

Still open: the quirk buttons in `Quirkwin` toggle selection with `setBackground(Color.GREEN)`
and read it back with `getBackground().equals(Color.GREEN)`. That is the same look and feel
problem described above — the green may never become visible, and on a look and feel that
returns a `ColorUIResource` rather than a plain `Color` the `equals` check can fail, which
would make the submitted quirks wrong rather than merely invisible. Worth switching those
to `JToggleButton` and `isSelected()`, which does not depend on color at all.
