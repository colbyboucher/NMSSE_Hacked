/*
 * Decompiled with CFR 0.152.
 */
package net.jpountz.xxhash;

import java.util.zip.Checksum;

class StreamingXXHash32.1
implements Checksum {
    StreamingXXHash32.1() {
    }

    @Override
    public long getValue() {
        return (long)StreamingXXHash32.this.getValue() & 0xFFFFFFFL;
    }

    @Override
    public void reset() {
        StreamingXXHash32.this.reset();
    }

    @Override
    public void update(int b) {
        StreamingXXHash32.this.update(new byte[]{(byte)b}, 0, 1);
    }

    @Override
    public void update(byte[] b, int off, int len) {
        StreamingXXHash32.this.update(b, off, len);
    }

    public String toString() {
        return StreamingXXHash32.this.toString();
    }
}
