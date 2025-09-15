/*
 * Decompiled with CFR 0.152.
 */
package net.jpountz.lz4;

static class LZ4ByteBufferUtils.Match {
    int start;
    int ref;
    int len;

    LZ4ByteBufferUtils.Match() {
    }

    void fix(int correction) {
        this.start += correction;
        this.ref += correction;
        this.len -= correction;
    }

    int end() {
        return this.start + this.len;
    }
}
