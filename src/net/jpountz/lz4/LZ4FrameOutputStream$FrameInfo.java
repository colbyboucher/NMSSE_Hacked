/*
 * Decompiled with CFR 0.152.
 */
package net.jpountz.lz4;

import net.jpountz.lz4.LZ4FrameOutputStream;
import net.jpountz.xxhash.StreamingXXHash32;
import net.jpountz.xxhash.XXHashFactory;

static class LZ4FrameOutputStream.FrameInfo {
    private final LZ4FrameOutputStream.FLG flg;
    private final LZ4FrameOutputStream.BD bd;
    private final StreamingXXHash32 streamHash;
    private boolean finished = false;

    public LZ4FrameOutputStream.FrameInfo(LZ4FrameOutputStream.FLG flg, LZ4FrameOutputStream.BD bd) {
        this.flg = flg;
        this.bd = bd;
        this.streamHash = flg.isEnabled(LZ4FrameOutputStream.FLG.Bits.CONTENT_CHECKSUM) ? XXHashFactory.fastestInstance().newStreamingHash32(0) : null;
    }

    public boolean isEnabled(LZ4FrameOutputStream.FLG.Bits bit) {
        return this.flg.isEnabled(bit);
    }

    public LZ4FrameOutputStream.FLG getFLG() {
        return this.flg;
    }

    public LZ4FrameOutputStream.BD getBD() {
        return this.bd;
    }

    public void updateStreamHash(byte[] buff, int off, int len) {
        this.streamHash.update(buff, off, len);
    }

    public int currentStreamHash() {
        return this.streamHash.getValue();
    }

    public void finish() {
        this.finished = true;
    }

    public boolean isFinished() {
        return this.finished;
    }
}
