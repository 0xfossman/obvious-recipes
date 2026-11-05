# Installation (Deutsch)

## Paper 26.3

1. Lade `obvious-recipes-26.3.zip` aus einem Release herunter oder erzeuge es mit `python tools/build.py`.
2. Kopiere die ZIP-Datei in `<server>/<welt>/datapacks/`. Nicht entpacken und nicht verschachteln.
3. Starte neu oder führe als Operator `/reload` aus.
4. Prüfe mit `/datapack list enabled`, ob Obvious Recipes aktiviert ist.

Das Pack benötigt weder Paper-Plugin noch Mod und funktioniert nach denselben Vanilla-Regeln auch auf einem normalen Java-Server.

## Einzelspieler und Deinstallation

Kopiere die ZIP nach `.minecraft/saves/<Weltname>/datapacks/`, öffne die Welt und führe `/reload` aus. Zum Entfernen die ZIP löschen und die Welt bzw. den Server neu starten. Bereits hergestellte Gegenstände bleiben erhalten.

## Hinweis zu Spawnern

Minecraft Java 26.3 erlaubt normalen Spielern nicht, einen Spawner mit vorgegebener Block-Entity-Konfiguration zu platzieren. Deshalb enthält dieses Vanilla-Pack keine Spawner-Rezepte. Details: [RECIPE_INVENTORY.md](RECIPE_INVENTORY.md).
