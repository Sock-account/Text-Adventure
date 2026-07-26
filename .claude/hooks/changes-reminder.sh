#!/usr/bin/env bash
# Stop hook: blocks Claude from ending a turn in which .java files were touched
# but CLAUDE_CHANGES.md was not.
#
# "Was CLAUDE_CHANGES.md updated?" is answered by mtime, not by git, because
# CLAUDE_CHANGES.md is often untracked or already dirty - git status can't tell
# "changed this turn" from "changed three turns ago".
#
# Loop safety: the marker file records the last time this hook fired. A reminder
# only fires for .java files newer than BOTH the changelog and the marker, so a
# turn that ends without appending gets nagged once, not forever.

set -u

dir="${CLAUDE_PROJECT_DIR:-.}"
changelog="$dir/CLAUDE_CHANGES.md"
marker="$dir/.claude/.changes-reminded"

# No changelog means nothing to keep in sync - stay quiet rather than nag about
# a file the user may have deliberately deleted.
[ -f "$changelog" ] || exit 0

stale=$(find "$dir" -name '*.java' -newer "$changelog" -print -quit 2>/dev/null)
[ -n "$stale" ] || exit 0

if [ -f "$marker" ]; then
    unreported=$(find "$dir" -name '*.java' -newer "$marker" -print -quit 2>/dev/null)
    [ -n "$unreported" ] || exit 0
fi

touch "$marker"

# Static JSON - no filenames interpolated, so there is nothing to escape.
cat <<'JSON'
{"decision":"block","reason":"You edited .java files but did not append to CLAUDE_CHANGES.md. Add an entry describing what changed and why, following the format already in that file, then finish your turn. If the edits genuinely do not warrant an entry (a revert, or a change you already logged), say so in one line and stop - this reminder will not fire again for these same edits."}
JSON
