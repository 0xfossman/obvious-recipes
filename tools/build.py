#!/usr/bin/env python3
"""Create a reproducible, directly installable Obvious Recipes ZIP."""
from __future__ import annotations

import hashlib
import shutil
import subprocess
import sys
import zipfile
from pathlib import Path

ROOT = Path(__file__).resolve().parents[1]
PACK = ROOT / "datapack"
RESOURCE_PACK = ROOT / "resourcepack"
DIST = ROOT / "dist"
ARCHIVE = DIST / "obvious-recipes-26.3.zip"
RESOURCE_ARCHIVE = DIST / "obvious-recipes-resources-26.3.zip"
PLUGIN_JAR = ROOT / "plugin" / "build" / "libs" / "obvious-recipes-spawners-26.3.jar"
CHECKSUM = DIST / "SHA256SUMS"
STAMP = (2026, 9, 15, 0, 0, 0)


def main() -> None:
    subprocess.run([sys.executable, str(ROOT / "tools" / "validate.py")], check=True)
    if DIST.exists():
        shutil.rmtree(DIST)
    DIST.mkdir()
    for source, archive_path in ((PACK, ARCHIVE), (RESOURCE_PACK, RESOURCE_ARCHIVE)):
        files = sorted(path for path in source.rglob("*") if path.is_file())
        if not files or not (source / "pack.mcmeta").is_file():
            raise SystemExit(f"missing files or pack.mcmeta in {source}")
        with zipfile.ZipFile(archive_path, "w", compression=zipfile.ZIP_DEFLATED, compresslevel=9) as archive:
            for path in files:
                info = zipfile.ZipInfo(path.relative_to(source).as_posix(), STAMP)
                info.compress_type = zipfile.ZIP_DEFLATED
                info.external_attr = 0o100644 << 16
                archive.writestr(info, path.read_bytes(), compress_type=zipfile.ZIP_DEFLATED, compresslevel=9)
    plugin_output = DIST / PLUGIN_JAR.name
    if PLUGIN_JAR.is_file():
        shutil.copyfile(PLUGIN_JAR, plugin_output)
    checksums = []
    for archive in (ARCHIVE, RESOURCE_ARCHIVE, plugin_output):
        if not archive.is_file():
            continue
        checksums.append(f"{hashlib.sha256(archive.read_bytes()).hexdigest()}  {archive.name}")
    CHECKSUM.write_text("\n".join(checksums) + "\n", encoding="utf-8")
    print(f"built {ARCHIVE.relative_to(ROOT)}")
    print(f"built {RESOURCE_ARCHIVE.relative_to(ROOT)}")
    if plugin_output.is_file():
        print(f"copied {plugin_output.relative_to(ROOT)}")


if __name__ == "__main__":
    main()
