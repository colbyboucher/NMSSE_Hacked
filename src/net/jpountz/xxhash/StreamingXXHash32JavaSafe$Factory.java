/*
 * Decompiled with CFR 0.152.
 */
package net.jpountz.xxhash;

import net.jpountz.xxhash.StreamingXXHash32;
import net.jpountz.xxhash.StreamingXXHash32JavaSafe;

static class StreamingXXHash32JavaSafe.Factory
implements StreamingXXHash32.Factory {
    public static final StreamingXXHash32.Factory INSTANCE = new StreamingXXHash32JavaSafe.Factory();

    StreamingXXHash32JavaSafe.Factory() {
    }

    @Override
    public StreamingXXHash32 newStreamingHash(int seed) {
        return new StreamingXXHash32JavaSafe(seed);
    }
}
