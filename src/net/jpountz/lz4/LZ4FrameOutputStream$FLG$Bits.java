/*
 * Decompiled with CFR 0.152.
 */
package net.jpountz.lz4;

public static enum LZ4FrameOutputStream.FLG.Bits {
    RESERVED_0(0),
    RESERVED_1(1),
    CONTENT_CHECKSUM(2),
    CONTENT_SIZE(3),
    BLOCK_CHECKSUM(4),
    BLOCK_INDEPENDENCE(5);

    private final int position;

    private LZ4FrameOutputStream.FLG.Bits(int position) {
        this.position = position;
    }

    static /* synthetic */ int access$100(LZ4FrameOutputStream.FLG.Bits x0) {
        return x0.position;
    }
}
