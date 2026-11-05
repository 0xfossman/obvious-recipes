#!/usr/bin/env python3
"""Structural validation for the Obvious Recipes data pack (no dependencies)."""
from __future__ import annotations

import json
import re
import sys
from pathlib import Path

ROOT = Path(__file__).resolve().parents[1]
PACK = ROOT / "datapack"
RECIPES = PACK / "data" / "obviousrecipes" / "recipe"
ID = re.compile(r"^[a-z0-9_.-]+:[a-z0-9_./-]+$")
TYPES = {"minecraft:crafting_shaped", "minecraft:crafting_shapeless", "minecraft:smelting"}


def fail(message: str) -> None:
    print(f"error: {message}", file=sys.stderr)
    raise SystemExit(1)


def item_id(value: object, where: Path) -> None:
    if not isinstance(value, str):
        fail(f"{where}: ingredient must use the Minecraft 26.3 string format")
    identifier = value[1:] if value.startswith("#") else value
    if not ID.fullmatch(identifier):
        fail(f"{where}: invalid namespaced item/tag identifier: {value!r}")


def validate_recipe(path: Path) -> None:
    try:
        recipe = json.loads(path.read_text(encoding="utf-8"))
    except json.JSONDecodeError as exc:
        fail(f"{path}: invalid JSON: {exc}")
    if recipe.get("type") not in TYPES:
        fail(f"{path}: unsupported or missing recipe type")
    result = recipe.get("result")
    if not isinstance(result, dict):
        fail(f"{path}: result must be an object")
    item_id(result.get("id") or result.get("item"), path)
    if recipe["type"] == "minecraft:crafting_shaped":
        pattern, key = recipe.get("pattern"), recipe.get("key")
        if not isinstance(pattern, list) or not 1 <= len(pattern) <= 3 or not all(isinstance(x, str) for x in pattern):
            fail(f"{path}: shaped recipe needs one to three string pattern rows")
        if len({len(row) for row in pattern}) != 1 or len(pattern[0]) > 3:
            fail(f"{path}: pattern rows must have equal width of at most three")
        if not isinstance(key, dict):
            fail(f"{path}: shaped recipe needs a key")
        used = set("".join(pattern)) - {" "}
        if used != set(key):
            fail(f"{path}: pattern and key symbols do not match")
        for ingredient in key.values():
            item_id(ingredient, path)
    else:
        ingredient = recipe.get("ingredients") if recipe["type"] == "minecraft:crafting_shapeless" else recipe.get("ingredient")
        if recipe["type"] == "minecraft:crafting_shapeless":
            if not isinstance(ingredient, list) or not ingredient:
                fail(f"{path}: shapeless recipe needs ingredients")
            for entry in ingredient:
                item_id(entry, path)
        else:
            item_id(ingredient, path)
            if not isinstance(recipe.get("experience"), (int, float)) or not isinstance(recipe.get("cookingtime"), int):
                fail(f"{path}: smelting recipe needs numeric experience and cookingtime")


def main() -> None:
    if not (PACK / "pack.mcmeta").is_file() or not RECIPES.is_dir():
        fail("datapack root, pack.mcmeta, or recipe directory is missing")
    try:
        meta = json.loads((PACK / "pack.mcmeta").read_text(encoding="utf-8"))
    except json.JSONDecodeError as exc:
        fail(f"pack.mcmeta: invalid JSON: {exc}")
    pack = meta.get("pack", {})
    if pack.get("min_format") != [121, 0] or pack.get("max_format") != [121, 0]:
        fail("pack.mcmeta must target data-pack format 121.0 (Minecraft 26.3)")
    paths = sorted(RECIPES.rglob("*.json"))
    if not paths:
        fail("no recipes found")
    ids: set[str] = set()
    for path in paths:
        recipe_id = f"obviousrecipes:{path.relative_to(RECIPES).with_suffix('').as_posix()}"
        if recipe_id in ids:
            fail(f"duplicate recipe ID: {recipe_id}")
        ids.add(recipe_id)
        validate_recipe(path)
    print(f"validated {len(paths)} recipes for Minecraft 26.3")


if __name__ == "__main__":
    main()
