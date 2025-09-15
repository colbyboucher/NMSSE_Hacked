/*
 * Decompiled with CFR 0.152.
 */
package net.jpountz.xxhash;

import net.jpountz.xxhash.StreamingXXHash32;
import net.jpountz.xxhash.StreamingXXHash32JavaUnsafe;

static class StreamingXXHash32JavaUnsafe.Factory
implements StreamingXXHash32.Factory {
    public static final StreamingXXHash32.Factory INSTANCE = new StreamingXXHash32JavaUnsafe.Factory();

    StreamingXXHash32JavaUnsafe.Factory() {
    }

    @Override
    public StreamingXXHash32 newStreamingHash(int seed) {
        return new StreamingXXHash32JavaUnsafe(seed);
    }
}
