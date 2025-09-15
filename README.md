# NMSSE_Hacked (GoatSauce)

Decompiled Java dump of a closed-source No Man's Sky save editor.  
This repo contains decompiled `.java` files used for offline analysis and reverse engineering of the save parsing pipeline.

## Contents
- `src/` — Decompiled Java source (primary focus).
- `.gitignore` — Keeps only the source uploaded.
- `todo.txt` — Quick tasks & investigation checklist.

## Purpose
- Locate the save-file parsing and LZ4 decompression logic.
- Reimplement the parsing pipeline in Rust/C++ as a clean, auditable tool.
- Produce minimal reproducer scripts for decompressing `.hg` files.

## Current findings
- Uses `net.jpountz.lz4` (jpountz LZ4) for compression/decompression.
- Key parser: `src/nomanssave/ff.java` — in-memory JSON/EXML parser.
- Compression wrappers: `src/nomanssave/ho.java`, `hb.java`, `gZ.java`.
- The decompression hook appears upstream of `ff` — code path likely wraps bytes into `ByteArrayInputStream` → `ff`.

## Quick tasks (todo)
1. Inspect `ho`, `hb`, `gZ` for I/O entry points (decompress/write vs read).  
2. Trace where `.hg` bytes are read from disk and fed to jpountz.  
3. Produce a Rust reproducer using `lz4_flex` for frame/raw support.  
4. Round-trip test: read `.hg` -> decompress -> parse with `ff` logic -> modify small field -> recompress -> verify in-game.

## Notes
- This repo is a decompiler artifact. Names are mangled/obfuscated; don’t expect clarity.
- No user save files are included.
