<h1 align="center">Obvious Recipes</h1>
<p align="center"><img src="logo.png" width="220" alt="Obvious Recipes logo" /></p>

<p align="center">
  <img alt="Minecraft" src="https://img.shields.io/badge/Minecraft-1.21.4-2ea043" />
  <img alt="Loader" src="https://img.shields.io/badge/Loader-Fabric-db4c3f" />
  <img alt="Java" src="https://img.shields.io/badge/Java-21-blue" />
  <a href="https://github.com/0xFOSSMan/obvious-recipes/actions/workflows/gradle.yml"><img alt="Build" src="https://github.com/0xFOSSMan/obvious-recipes/actions/workflows/gradle.yml/badge.svg?branch=main" /></a>
  <a href="https://github.com/0xFOSSMan/obvious-recipes/actions/workflows/super-linter.yml"><img alt="Lint" src="https://github.com/0xFOSSMan/obvious-recipes/actions/workflows/super-linter.yml/badge.svg?branch=main" /></a>
</p>

Obvious Recipes ist jetzt ein **Fabric-Mod für Minecraft 1.21.4** und bringt weiterhin "offensichtliche" Crafting- und Smelting-Rezepte ins Spiel.

## Features

- Zusätzliche Crafting-Rezepte (z. B. Sattel, Pferderüstungen, Nametag).
- Recycling-Rezepte für Leder- und Holz-Items.
- Zusätzliche Ofenrezepte (z. B. Rotten Flesh -> Leather, Metall-Recycling).

## Entwicklung

### Voraussetzungen

- JDK 21
- Gradle (Wrapper enthalten)

### Build

```bash
./gradlew build
```

### Linting & Formatierung

```bash
./gradlew spotlessCheck
./gradlew spotlessApply
```

## Lizenz

GPL-3.0
