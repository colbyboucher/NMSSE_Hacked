/*
 * Decompiled with CFR 0.152.
 */
package net.jpountz.lz4;

import java.util.Locale;

public static enum LZ4FrameOutputStream.BLOCKSIZE {
    SIZE_64KB(4),
    SIZE_256KB(5),
    SIZE_1MB(6),
    SIZE_4MB(7);

    private final int indicator;

    private LZ4FrameOutputStream.BLOCKSIZE(int indicator) {
        this.indicator = indicator;
    }

    public int getIndicator() {
        return this.indicator;
    }

    public static LZ4FrameOutputStream.BLOCKSIZE valueOf(int indicator) {
        switch (indicator) {
            case 7: {
                return SIZE_4MB;
            }
            case 6: {
                return SIZE_1MB;
            }
            case 5: {
                return SIZE_256KB;
            }
            case 4: {
                return SIZE_64KB;
            }
        }
        throw new IllegalArgumentException(String.format(Locale.ROOT, "Block size must be 4-7. Cannot use value of [%d]", indicator));
    }
}
