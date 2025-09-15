/*
 * Decompiled with CFR 0.152.
 */
package net.jpountz.xxhash;

import net.jpountz.xxhash.StreamingXXHash64;
import net.jpountz.xxhash.StreamingXXHash64JavaSafe;

static class StreamingXXHash64JavaSafe.Factory
implements StreamingXXHash64.Factory {
    public static final StreamingXXHash64.Factory INSTANCE = new StreamingXXHash64JavaSafe.Factory();

    StreamingXXHash64JavaSafe.Factory() {
    }

    @Override
    public StreamingXXHash64 newStreamingHash(long seed) {
        return new StreamingXXHash64JavaSafe(seed);
    }
}
