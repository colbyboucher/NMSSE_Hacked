/*
 * Decompiled with CFR 0.152.
 */
package net.jpountz.xxhash;

import java.util.zip.Checksum;

class StreamingXXHash64.1
implements Checksum {
    StreamingXXHash64.1() {
    }

    @Override
    public long getValue() {
        return StreamingXXHash64.this.getValue();
    }

    @Override
    public void reset() {
        StreamingXXHash64.this.reset();
    }

    @Override
    public void update(int b) {
        StreamingXXHash64.this.update(new byte[]{(byte)b}, 0, 1);
    }

    @Override
    public void update(byte[] b, int off, int len) {
        StreamingXXHash64.this.update(b, off, len);
    }

    public String toString() {
        return StreamingXXHash64.this.toString();
    }
}
