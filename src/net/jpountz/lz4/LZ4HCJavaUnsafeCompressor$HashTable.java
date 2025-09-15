/*
 * Decompiled with CFR 0.152.
 */
package net.jpountz.lz4;

import java.nio.ByteBuffer;
import java.util.Arrays;
import net.jpountz.lz4.LZ4ByteBufferUtils;
import net.jpountz.lz4.LZ4UnsafeUtils;
import net.jpountz.lz4.LZ4Utils;
import net.jpountz.util.ByteBufferUtils;
import net.jpountz.util.UnsafeUtils;

private class LZ4HCJavaUnsafeCompressor.HashTable {
    static final int MASK = 65535;
    int nextToUpdate;
    private final int base;
    private final int[] hashTable;
    private final short[] chainTable;

    LZ4HCJavaUnsafeCompressor.HashTable(int base) {
        this.base = base;
        this.nextToUpdate = base;
        this.hashTable = new int[32768];
        Arrays.fill(this.hashTable, -1);
        this.chainTable = new short[65536];
    }

    private int hashPointer(byte[] bytes, int off) {
        int v = UnsafeUtils.readInt(bytes, off);
        return this.hashPointer(v);
    }

    private int hashPointer(ByteBuffer bytes, int off) {
        int v = ByteBufferUtils.readInt(bytes, off);
        return this.hashPointer(v);
    }

    private int hashPointer(int v) {
        int h = LZ4Utils.hashHC(v);
        return this.hashTable[h];
    }

    private int next(int off) {
        return off - (this.chainTable[off & 0xFFFF] & 0xFFFF);
    }

    private void addHash(byte[] bytes, int off) {
        int v = UnsafeUtils.readInt(bytes, off);
        this.addHash(v, off);
    }

    private void addHash(ByteBuffer bytes, int off) {
        int v = ByteBufferUtils.readInt(bytes, off);
        this.addHash(v, off);
    }

    private void addHash(int v, int off) {
        int h = LZ4Utils.hashHC(v);
        int delta = off - this.hashTable[h];
        assert (delta > 0) : delta;
        if (delta >= 65536) {
            delta = 65535;
        }
        this.chainTable[off & 0xFFFF] = (short)delta;
        this.hashTable[h] = off;
    }

    void insert(int off, byte[] bytes) {
        while (this.nextToUpdate < off) {
            this.addHash(bytes, this.nextToUpdate);
            ++this.nextToUpdate;
        }
    }

    void insert(int off, ByteBuffer bytes) {
        while (this.nextToUpdate < off) {
            this.addHash(bytes, this.nextToUpdate);
            ++this.nextToUpdate;
        }
    }

    boolean insertAndFindBestMatch(byte[] buf, int off, int matchLimit, LZ4Utils.Match match) {
        match.start = off;
        match.len = 0;
        int delta = 0;
        int repl = 0;
        this.insert(off, buf);
        int ref = this.hashPointer(buf, off);
        if (ref >= off - 4 && ref <= off && ref >= this.base) {
            if (LZ4UnsafeUtils.readIntEquals(buf, ref, off)) {
                delta = off - ref;
                repl = match.len = 4 + LZ4UnsafeUtils.commonBytes(buf, ref + 4, off + 4, matchLimit);
                match.ref = ref;
            }
            ref = this.next(ref);
        }
        for (int i = 0; i < LZ4HCJavaUnsafeCompressor.this.maxAttempts && ref >= Math.max(this.base, off - 65536 + 1) && ref <= off; ++i) {
            int matchLen;
            if (LZ4UnsafeUtils.readIntEquals(buf, ref, off) && (matchLen = 4 + LZ4UnsafeUtils.commonBytes(buf, ref + 4, off + 4, matchLimit)) > match.len) {
                match.ref = ref;
                match.len = matchLen;
            }
            ref = this.next(ref);
        }
        if (repl != 0) {
            int ptr;
            int end = off + repl - 3;
            for (ptr = off; ptr < end - delta; ++ptr) {
                this.chainTable[ptr & 0xFFFF] = (short)delta;
            }
            do {
                this.chainTable[ptr & 0xFFFF] = (short)delta;
                this.hashTable[LZ4Utils.hashHC((int)UnsafeUtils.readInt((byte[])buf, (int)ptr))] = ptr;
            } while (++ptr < end);
            this.nextToUpdate = end;
        }
        return match.len != 0;
    }

    boolean insertAndFindWiderMatch(byte[] buf, int off, int startLimit, int matchLimit, int minLen, LZ4Utils.Match match) {
        match.len = minLen;
        this.insert(off, buf);
        int delta = off - startLimit;
        int ref = this.hashPointer(buf, off);
        for (int i = 0; i < LZ4HCJavaUnsafeCompressor.this.maxAttempts && ref >= Math.max(this.base, off - 65536 + 1) && ref <= off; ++i) {
            if (LZ4UnsafeUtils.readIntEquals(buf, ref, off)) {
                int matchLenForward = 4 + LZ4UnsafeUtils.commonBytes(buf, ref + 4, off + 4, matchLimit);
                int matchLenBackward = LZ4UnsafeUtils.commonBytesBackward(buf, ref, off, this.base, startLimit);
                int matchLen = matchLenBackward + matchLenForward;
                if (matchLen > match.len) {
                    match.len = matchLen;
                    match.ref = ref - matchLenBackward;
                    match.start = off - matchLenBackward;
                }
            }
            ref = this.next(ref);
        }
        return match.len > minLen;
    }

    boolean insertAndFindBestMatch(ByteBuffer buf, int off, int matchLimit, LZ4Utils.Match match) {
        match.start = off;
        match.len = 0;
        int delta = 0;
        int repl = 0;
        this.insert(off, buf);
        int ref = this.hashPointer(buf, off);
        if (ref >= off - 4 && ref <= off && ref >= this.base) {
            if (LZ4ByteBufferUtils.readIntEquals(buf, ref, off)) {
                delta = off - ref;
                repl = match.len = 4 + LZ4ByteBufferUtils.commonBytes(buf, ref + 4, off + 4, matchLimit);
                match.ref = ref;
            }
            ref = this.next(ref);
        }
        for (int i = 0; i < LZ4HCJavaUnsafeCompressor.this.maxAttempts && ref >= Math.max(this.base, off - 65536 + 1) && ref <= off; ++i) {
            int matchLen;
            if (LZ4ByteBufferUtils.readIntEquals(buf, ref, off) && (matchLen = 4 + LZ4ByteBufferUtils.commonBytes(buf, ref + 4, off + 4, matchLimit)) > match.len) {
                match.ref = ref;
                match.len = matchLen;
            }
            ref = this.next(ref);
        }
        if (repl != 0) {
            int ptr;
            int end = off + repl - 3;
            for (ptr = off; ptr < end - delta; ++ptr) {
                this.chainTable[ptr & 0xFFFF] = (short)delta;
            }
            do {
                this.chainTable[ptr & 0xFFFF] = (short)delta;
                this.hashTable[LZ4Utils.hashHC((int)ByteBufferUtils.readInt((ByteBuffer)buf, (int)ptr))] = ptr;
            } while (++ptr < end);
            this.nextToUpdate = end;
        }
        return match.len != 0;
    }

    boolean insertAndFindWiderMatch(ByteBuffer buf, int off, int startLimit, int matchLimit, int minLen, LZ4Utils.Match match) {
        match.len = minLen;
        this.insert(off, buf);
        int delta = off - startLimit;
        int ref = this.hashPointer(buf, off);
        for (int i = 0; i < LZ4HCJavaUnsafeCompressor.this.maxAttempts && ref >= Math.max(this.base, off - 65536 + 1) && ref <= off; ++i) {
            if (LZ4ByteBufferUtils.readIntEquals(buf, ref, off)) {
                int matchLenForward = 4 + LZ4ByteBufferUtils.commonBytes(buf, ref + 4, off + 4, matchLimit);
                int matchLenBackward = LZ4ByteBufferUtils.commonBytesBackward(buf, ref, off, this.base, startLimit);
                int matchLen = matchLenBackward + matchLenForward;
                if (matchLen > match.len) {
                    match.len = matchLen;
                    match.ref = ref - matchLenBackward;
                    match.start = off - matchLenBackward;
                }
            }
            ref = this.next(ref);
        }
        return match.len > minLen;
    }
}
