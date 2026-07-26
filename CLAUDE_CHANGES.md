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
