/*
 * Decompiled with CFR 0.152.
 */
package com.formdev.flatlaf.util;

import com.formdev.flatlaf.util.ColorFunctions;

public static class ColorFunctions.HSLChange
implements ColorFunctions.ColorFunction {
    public final int hslIndex;
    public final float value;

    public ColorFunctions.HSLChange(int hslIndex, float value) {
        this.hslIndex = hslIndex;
        this.value = value;
    }

    @Override
    public void apply(float[] hsla) {
        hsla[this.hslIndex] = this.hslIndex == 0 ? this.value % 360.0f : ColorFunctions.clamp(this.value);
    }

    public String toString() {
        String name;
        switch (this.hslIndex) {
            case 0: {
                name = "changeHue";
                break;
            }
            case 1: {
                name = "changeSaturation";
                break;
            }
            case 2: {
                name = "changeLightness";
                break;
            }
            case 3: {
                name = "changeAlpha";
                break;
            }
            default: {
                throw new IllegalArgumentException();
            }
        }
        return String.format("%s(%.0f%s)", name, Float.valueOf(this.value), this.hslIndex == 0 ? "" : "%");
    }
}
