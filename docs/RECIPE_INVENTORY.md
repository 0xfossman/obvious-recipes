# Recipe inventory

This inventory was made from `main` at commit `7e82dbc`, its complete Git history, the current README, and repository metadata. No Modrinth project is linked by repository or author metadata, so no Modrinth-only recipe could be verified.

All IDs are `obviousrecipes:<folder>/<file>`. “Native” means an ordinary vanilla recipe JSON.

| Recipe | Ingredients → result | Type | Original | New | Status / limitation |
|---|---|---|---|---|---|
| Cobweb | 8 string + spider eye → 8 cobweb | shaped | current JSON | native | ported |
| Saddle | 7 leather + string → saddle | shaped | current JSON | native | ported |
| Name tag | leather, iron nugget, feather → name tag | shaped | current JSON | native | ported |
| Iron horse armor | 6 iron ingots + saddle → iron horse armor | shaped | current JSON | native | ported |
| Golden horse armor | 6 gold ingots + saddle → golden horse armor | shaped | current JSON | native | ported |
| Diamond horse armor | 6 diamonds + saddle → diamond horse armor | shaped | current JSON | native | ported |
| Golden apple | 8 gold nuggets + apple → golden apple | shaped | current JSON | native | ported |
| Enchanted golden apple | 8 gold blocks + apple → enchanted golden apple | shaped | current JSON | native | ported |
| Totem of Undying | golden helmet, emerald block, 3 ominous bottles → totem | shaped | current JSON | native | ported |
| Copper Bucket | 3 copper ingots → marked vanilla bucket | shaped | new recipe | native + optional resource pack | ported; behaves as a normal bucket, custom empty-bucket appearance needs the resource pack. |
| Leather boots recycle | leather boots → 4 leather | shapeless | current JSON | native | ported |
| Leather helmet recycle | leather helmet → 5 leather | shapeless | current JSON | native | ported |
| Leather leggings recycle | leather leggings → 7 leather | shapeless | current JSON | native | ported |
| Leather chestplate recycle | leather chestplate → 8 leather | shapeless | current JSON | native | ported |
| Nether wart block recycle | nether wart block → 9 nether wart | shapeless | current JSON | native | ported |
| Wool recycle | any `minecraft:wool` → 4 string | shapeless | current JSON | native | ported |
| Wooden axe recycle | wooden axe → 2 sticks | shapeless | current JSON | native | ported |
| Wooden hoe recycle | wooden hoe → 2 sticks | shapeless | current JSON | native | ported |
| Wooden pickaxe recycle | wooden pickaxe → 2 sticks | shapeless | current JSON | native | ported |
| Wooden shovel recycle | wooden shovel → 2 sticks | shapeless | current JSON | native | ported |
| Wooden sword recycle | wooden sword → 2 sticks | shapeless | current JSON | native | ported |
| Rotten flesh smelt | rotten flesh → leather | smelting | current JSON | native | ported |
| Golden horse armor smelt | golden horse armor → gold ingot | smelting | current JSON | native | ported |
| Light pressure plate smelt | light weighted pressure plate → 2 gold ingots | smelting | current JSON | native | ported |
| Bucket smelt | bucket → 3 iron ingots | smelting | current JSON | native | ported |
| Cauldron smelt | cauldron → 7 iron ingots | smelting | current JSON | native | ported |
| Heavy pressure plate smelt | heavy weighted pressure plate → 2 iron ingots | smelting | current JSON | native | ported |
| Iron door smelt | iron door → 6 iron ingots | smelting | current JSON | native | ported |
| Iron horse armor smelt | iron horse armor → iron ingot | smelting | current JSON | native | ported |
| Iron trapdoor smelt | iron trapdoor → 4 iron ingots | smelting | current JSON | native | ported |
| Iron bars smelt | iron bars → 5 iron nuggets | smelting | current JSON | native | ported |
| Chicken spawner (historical recipe) | 8 iron bars + egg → marked chicken spawner | shaped | historical `f2e4faa` asset JSON | native recipe + Paper plugin | ported. The plugin places and configures it for non-OP players; the datapack alone cannot. |

Together this table accounts for 32 recipes (30 in current `main`, one restored historical spawner, and Copper Bucket).

## Spawner feasibility (Minecraft Java 26.3)

`minecraft:block_entity_data` can express `id: "minecraft:mob_spawner"` plus `SpawnData`, but Java refuses to copy that component while a non-operator places a spawner. The data pack therefore emits a deliberately marked plain spawner and the optional Paper plugin handles placement, item consumption, and configuration. This preserves normal-survival placement without bypassing vanilla permissions.

If vanilla later removes the restriction, the historical iron-bars pattern may use exactly one centre selector and set both `SpawnData` and `SpawnPotentials`. Candidate selectors from the brief are egg/chicken, rotten flesh/zombie, bone/skeleton, spider eye/spider, gunpowder/creeper, ender pearl/enderman, blaze rod/blaze, and slime ball/slime; they are deliberately not released until normal-player placement works.
