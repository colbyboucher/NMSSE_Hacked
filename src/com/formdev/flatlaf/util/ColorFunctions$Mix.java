/*
 * Decompiled with CFR 0.152.
 */
package com.formdev.flatlaf.util;

import com.formdev.flatlaf.util.ColorFunctions;
import com.formdev.flatlaf.util.HSLColor;
import java.awt.Color;

public static class ColorFunctions.Mix
implements ColorFunctions.ColorFunction {
    public final Color color2;
    public final float weight;

    public ColorFunctions.Mix(Color color2, float weight) {
        this.color2 = color2;
        this.weight = weight;
    }

    @Override
    public void apply(float[] hsla) {
        Color color1 = HSLColor.toRGB(hsla[0], hsla[1], hsla[2], hsla[3] / 100.0f);
        Color color = ColorFunctions.mix(color1, this.color2, this.weight / 100.0f);
        float[] hsl = HSLColor.fromRGB(color);
        System.arraycopy(hsl, 0, hsla, 0, hsl.length);
        hsla[3] = (float)color.getAlpha() / 255.0f * 100.0f;
    }

    public String toString() {
        return String.format("mix(#%08x,%.0f%%)", this.color2.getRGB(), Float.valueOf(this.weight));
    }
}
