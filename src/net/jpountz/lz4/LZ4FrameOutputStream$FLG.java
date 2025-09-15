/*
 * Decompiled with CFR 0.152.
 */
package net.jpountz.lz4;

import java.util.BitSet;
import java.util.Locale;

public static class LZ4FrameOutputStream.FLG {
    private static final int DEFAULT_VERSION = 1;
    private final BitSet bitSet;
    private final int version;

    public LZ4FrameOutputStream.FLG(int version, Bits ... bits) {
        this.bitSet = new BitSet(8);
        this.version = version;
        if (bits != null) {
            for (Bits bit : bits) {
                this.bitSet.set(bit.position);
            }
        }
        this.validate();
    }

    private LZ4FrameOutputStream.FLG(int version, byte b) {
        this.bitSet = BitSet.valueOf(new byte[]{b});
        this.version = version;
        this.validate();
    }

    public static LZ4FrameOutputStream.FLG fromByte(byte flg) {
        byte versionMask = (byte)(flg & 0xC0);
        return new LZ4FrameOutputStream.FLG(versionMask >>> 6, (byte)(flg ^ versionMask));
    }

    public byte toByte() {
        return (byte)(this.bitSet.toByteArray()[0] | (this.version & 3) << 6);
    }

    private void validate() {
        if (this.bitSet.get(Bits.RESERVED_0.position)) {
            throw new RuntimeException("Reserved0 field must be 0");
        }
        if (this.bitSet.get(Bits.RESERVED_1.position)) {
            throw new RuntimeException("Reserved1 field must be 0");
        }
        if (!this.bitSet.get(Bits.BLOCK_INDEPENDENCE.position)) {
            throw new RuntimeException("Dependent block stream is unsupported (BLOCK_INDEPENDENCE must be set)");
        }
        if (this.version != 1) {
            throw new RuntimeException(String.format(Locale.ROOT, "Version %d is unsupported", this.version));
        }
    }

    public boolean isEnabled(Bits bit) {
        return this.bitSet.get(bit.position);
    }

    public int getVersion() {
        return this.version;
    }

    public static enum Bits {
        RESERVED_0(0),
        RESERVED_1(1),
        CONTENT_CHECKSUM(2),
        CONTENT_SIZE(3),
        BLOCK_CHECKSUM(4),
        BLOCK_INDEPENDENCE(5);

        private final int position;

        private Bits(int position) {
            this.position = position;
        }
    }
}
