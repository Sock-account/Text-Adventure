# Text-Adventure

A Java Swing text adventure. Source lives in [Text Adventure/TextAdvent/src/](Text%20Adventure/TextAdvent/src/);
`bin/` holds compiled `.class` output.

## Changelog: CLAUDE_CHANGES.md

Whenever you change a `.java` file, append an entry to
[CLAUDE_CHANGES.md](CLAUDE_CHANGES.md) before finishing the turn. Append — never
rewrite or reorder the existing entries; the file is a running history.

Each entry gets an `## ` heading naming the change, then prose explaining:

- **what** changed, concretely (class, method, layout manager, listener)
- **why** — the reason the old code was wrong or insufficient, not just the new
  behavior. "Moved to BorderLayout so the screen scales" beats "changed layout".
- **what's still open**, when the change leaves a known gap

Match the existing tone: plain sentences, no bullet-point-only entries, and name
the Swing specifics rather than gesturing at them.

A `Stop` hook ([.claude/hooks/changes-reminder.sh](.claude/hooks/changes-reminder.sh))
reminds you if you forget. It fires once per set of edits, so it is a backstop,
not the primary mechanism — append without waiting to be asked.

## Notes

- This is a learning project. Prefer explaining a Swing concept in a comment over
  silently applying it.
- `bin/*.class` files are currently tracked in git. Leave them alone unless asked.
