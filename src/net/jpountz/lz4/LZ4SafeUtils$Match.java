/*
 * Decompiled with CFR 0.152.
 */
package net.jpountz.lz4;

static class LZ4SafeUtils.Match {
    int start;
    int ref;
    int len;

    LZ4SafeUtils.Match() {
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
