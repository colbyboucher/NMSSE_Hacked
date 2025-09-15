/*
 * Decompiled with CFR 0.152.
 */
package net.jpountz.lz4;

import net.jpountz.lz4.LZ4FrameOutputStream;

public static class LZ4FrameOutputStream.BD {
    private static final int RESERVED_MASK = 143;
    private final LZ4FrameOutputStream.BLOCKSIZE blockSizeValue;

    private LZ4FrameOutputStream.BD(LZ4FrameOutputStream.BLOCKSIZE blockSizeValue) {
        this.blockSizeValue = blockSizeValue;
    }

    public static LZ4FrameOutputStream.BD fromByte(byte bd) {
        int blockMaximumSize = bd >>> 4 & 7;
        if ((bd & 0x8F) > 0) {
            throw new RuntimeException("Reserved fields must be 0");
        }
        return new LZ4FrameOutputStream.BD(LZ4FrameOutputStream.BLOCKSIZE.valueOf(blockMaximumSize));
    }

    public int getBlockMaximumSize() {
        return 1 << 2 * this.blockSizeValue.getIndicator() + 8;
    }

    public byte toByte() {
        return (byte)((this.blockSizeValue.getIndicator() & 7) << 4);
    }
}
