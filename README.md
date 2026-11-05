# Obvious Recipes

Obvious Recipes is a GPL-3.0, dependency-free data pack for **Minecraft Java 26.3**. It runs on vanilla servers, Paper 26.3, and singleplayer—no client installation, mod loader, or plugin required.

It adds sensible crafting, recycling, and furnace recipes: saddle, name tag, cobweb, iron/golden/diamond horse armor, golden and enchanted golden apples, and a Totem of Undying; leather, wool, nether-wart-block, and wooden-tool recycling; and rotten-flesh plus metal recovery smelting recipes.

The exact ingredients, yields, IDs, and migration status of every source recipe are in [docs/RECIPE_INVENTORY.md](docs/RECIPE_INVENTORY.md). This is the authoritative recipe list.

## Install

Build locally:

```sh
python tools/build.py
```

Place `dist/obvious-recipes-26.3.zip` directly in the world’s `datapacks` directory, then restart or run `/reload`. The complete German Paper and singleplayer guide is [docs/INSTALLATION.md](docs/INSTALLATION.md).

## Spawners

The legacy repository once contained a generic spawner recipe. It is not included: Java 26.3 requires operator permission for a player to place a spawner that contains block-entity data, so a configurable survival-spawner recipe cannot be implemented reliably by a vanilla data pack. The limitation is documented in the inventory rather than hidden behind a nonfunctional recipe.

## Development and release

`python tools/validate.py` validates the pack; `python tools/build.py` additionally creates a reproducible ZIP and SHA-256 checksum. GitHub Actions validates every push/PR and includes a tag/manual GitHub-release workflow. A future Modrinth **Data Pack** upload can consume the `MODRINTH_TOKEN` secret; no secret is committed.

See [docs/DEVELOPMENT.md](docs/DEVELOPMENT.md) for manual Minecraft/Paper verification.

## License

[GPL-3.0](LICENSE). Source: <https://github.com/0xFOSSMan/obvious-recipes>.
