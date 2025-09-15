/*
 * Decompiled with CFR 0.152.
 */
package net.jpountz.xxhash;

import net.jpountz.xxhash.StreamingXXHash64;
import net.jpountz.xxhash.StreamingXXHash64JavaUnsafe;

static class StreamingXXHash64JavaUnsafe.Factory
implements StreamingXXHash64.Factory {
    public static final StreamingXXHash64.Factory INSTANCE = new StreamingXXHash64JavaUnsafe.Factory();

    StreamingXXHash64JavaUnsafe.Factory() {
    }

    @Override
    public StreamingXXHash64 newStreamingHash(long seed) {
        return new StreamingXXHash64JavaUnsafe(seed);
    }
}
