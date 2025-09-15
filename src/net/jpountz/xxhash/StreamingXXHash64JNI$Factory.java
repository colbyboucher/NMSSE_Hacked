/*
 * Decompiled with CFR 0.152.
 */
package net.jpountz.xxhash;

import net.jpountz.xxhash.StreamingXXHash64;
import net.jpountz.xxhash.StreamingXXHash64JNI;

static class StreamingXXHash64JNI.Factory
implements StreamingXXHash64.Factory {
    public static final StreamingXXHash64.Factory INSTANCE = new StreamingXXHash64JNI.Factory();

    StreamingXXHash64JNI.Factory() {
    }

    @Override
    public StreamingXXHash64 newStreamingHash(long seed) {
        return new StreamingXXHash64JNI(seed);
    }
}
