# Development

Requires Python 3.10+ only for the packs. Run `python tools/validate.py` for JSON, ID, namespace, shape, and 26.3 metadata checks. Run `python tools/build.py` to create the deterministic data-pack ZIP, optional resource-pack ZIP, and checksum. If the Paper plugin was built first, its JAR is also copied to `dist/`.

Build the Paper plugin with JDK 25 and `cd plugin && ./gradlew build`; it targets `paper-api:26.3.build.242-stable`.

Manual game verification remains required: restart a clean Java/Paper 26.3 world (do not use Paper's deprecated `/reload` with plugins), inspect logs, craft recipes of every type, smelt each furnace input, and place a Chicken Spawner as a non-OP player with the plugin installed. CI does not claim a Paper integration test: this repository has no reproducible player harness.
