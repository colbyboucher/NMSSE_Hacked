/*
 * Decompiled with CFR 0.152.
 */
package net.jpountz.xxhash;

import net.jpountz.xxhash.StreamingXXHash32;
import net.jpountz.xxhash.StreamingXXHash32JNI;

static class StreamingXXHash32JNI.Factory
implements StreamingXXHash32.Factory {
    public static final StreamingXXHash32.Factory INSTANCE = new StreamingXXHash32JNI.Factory();

    StreamingXXHash32JNI.Factory() {
    }

    @Override
    public StreamingXXHash32 newStreamingHash(int seed) {
        return new StreamingXXHash32JNI(seed);
    }
}
