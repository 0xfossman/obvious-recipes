# Obvious Recipes

Obvious Recipes is a GPL-3.0, dependency-free data pack for **Minecraft Java 26.3**. It runs on vanilla servers, Paper 26.3, and singleplayer—no client installation, mod loader, or plugin required.

It adds sensible crafting, recycling, and furnace recipes: saddle, name tag, cobweb, iron/golden/diamond horse armor, golden and enchanted golden apples, a Totem of Undying, a Chicken Spawner, and a Copper Bucket; leather, wool, nether-wart-block, and wooden-tool recycling; and rotten-flesh plus metal recovery smelting recipes.

The exact ingredients, yields, IDs, and migration status of every source recipe are in [docs/RECIPE_INVENTORY.md](docs/RECIPE_INVENTORY.md). This is the authoritative recipe list.

## Install

Build locally:

```sh
python tools/build.py
```

Place `dist/obvious-recipes-26.3.zip` directly in the world’s `datapacks` directory, then restart or run `/reload`. The complete German Paper and singleplayer guide is [docs/INSTALLATION.md](docs/INSTALLATION.md).

## Spawners

The legacy iron-bars-and-egg recipe is restored as a **Chicken Spawner** recipe. Install `obvious-recipes-spawners-26.3.jar` in the Paper server's `plugins/` directory and restart: the plugin consumes the specifically marked crafted item, places the block, and configures it as a chicken spawner without granting players OP. The item alone remains intentionally unplaceable on vanilla, because Java protects spawner block-entity data.

## Copper Bucket and visuals

Three copper ingots craft a **Copper Bucket**. It is a real vanilla `minecraft:bucket`, so it picks up and empties fluids exactly like a normal iron bucket. Its custom empty-bucket appearance requires the optional `obvious-recipes-resources-26.3.zip` resource pack on each client; data packs cannot send textures to clients. Filling it produces the appropriate vanilla filled bucket, which is the expected bucket behaviour.

## Development and release

`python tools/validate.py` validates the pack; `python tools/build.py` additionally creates a reproducible ZIP and SHA-256 checksum. GitHub Actions validates every push/PR and includes a tag/manual GitHub-release workflow. A future Modrinth **Data Pack** upload can consume the `MODRINTH_TOKEN` secret; no secret is committed.

See [docs/DEVELOPMENT.md](docs/DEVELOPMENT.md) for manual Minecraft/Paper verification.

## License

[GPL-3.0](LICENSE). Source: <https://github.com/0xFOSSMan/obvious-recipes>.
