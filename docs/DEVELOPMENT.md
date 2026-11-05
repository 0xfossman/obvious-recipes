# Development

Requires Python 3.10+ only. Run `python tools/validate.py` for JSON, ID, namespace, shape, and 26.3 metadata checks. Run `python tools/build.py` to create the deterministic ZIP and checksum.

Manual game verification remains required: install the archive in a clean Java/Paper 26.3 world, run `/reload`, inspect logs, craft recipes of every type, and smelt each furnace input. CI does not claim a Paper integration test: this repository has no reproducible licensed 26.3 server/player harness.
