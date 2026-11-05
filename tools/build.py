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
DIST = ROOT / "dist"
ARCHIVE = DIST / "obvious-recipes-26.3.zip"
CHECKSUM = DIST / "SHA256SUMS"
STAMP = (2026, 9, 15, 0, 0, 0)


def main() -> None:
    subprocess.run([sys.executable, str(ROOT / "tools" / "validate.py")], check=True)
    if DIST.exists():
        shutil.rmtree(DIST)
    DIST.mkdir()
    files = sorted(path for path in PACK.rglob("*") if path.is_file())
    with zipfile.ZipFile(ARCHIVE, "w", compression=zipfile.ZIP_DEFLATED, compresslevel=9) as archive:
        for path in files:
            info = zipfile.ZipInfo(path.relative_to(PACK).as_posix(), STAMP)
            info.compress_type = zipfile.ZIP_DEFLATED
            info.external_attr = 0o100644 << 16
            archive.writestr(info, path.read_bytes(), compress_type=zipfile.ZIP_DEFLATED, compresslevel=9)
    digest = hashlib.sha256(ARCHIVE.read_bytes()).hexdigest()
    CHECKSUM.write_text(f"{digest}  {ARCHIVE.name}\n", encoding="utf-8")
    print(f"built {ARCHIVE.relative_to(ROOT)}")
    print(f"SHA256 {digest}")


if __name__ == "__main__":
    main()
