/*
 * Decompiled with CFR 0.152.
 */
package com.formdev.flatlaf;

import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.UIDefaultsLoader;
import com.formdev.flatlaf.util.UIScale;
import java.awt.Font;
import java.util.List;
import java.util.Locale;
import java.util.function.IntUnaryOperator;
import javax.swing.UIDefaults;
import javax.swing.UIManager;
import javax.swing.plaf.FontUIResource;

static class FlatLaf.ActiveFont
implements UIDefaults.ActiveValue {
    private final String baseFontKey;
    private final List<String> families;
    private final int style;
    private final int styleChange;
    private final int absoluteSize;
    private final int relativeSize;
    private final float scaleSize;
    private FontUIResource font;
    private Font lastBaseFont;
    private boolean inCreateValue;

    FlatLaf.ActiveFont(String baseFontKey, List<String> families, int style, int styleChange, int absoluteSize, int relativeSize, float scaleSize) {
        this.baseFontKey = baseFontKey;
        this.families = families;
        this.style = style;
        this.styleChange = styleChange;
        this.absoluteSize = absoluteSize;
        this.relativeSize = relativeSize;
        this.scaleSize = scaleSize;
    }

    @Override
    public synchronized Object createValue(UIDefaults table) {
        if (this.inCreateValue) {
            throw new IllegalStateException("FlatLaf: endless recursion in font");
        }
        Font baseFont = null;
        this.inCreateValue = true;
        try {
            if (this.baseFontKey != null) {
                baseFont = (Font)UIDefaultsLoader.lazyUIManagerGet(this.baseFontKey);
            }
            if (baseFont == null) {
                baseFont = UIManager.getFont("defaultFont");
            }
            if (baseFont == null) {
                baseFont = UIManager.getFont("Label.font");
            }
        }
        finally {
            this.inCreateValue = false;
        }
        if (this.lastBaseFont != baseFont) {
            this.lastBaseFont = baseFont;
            this.font = this.derive(baseFont, fontSize -> UIScale.scale(fontSize));
        }
        return this.font;
    }

    FontUIResource derive(Font baseFont, IntUnaryOperator scale) {
        int newSize;
        int newStyle;
        int baseStyle = baseFont.getStyle();
        int baseSize = baseFont.getSize();
        int n = this.style != -1 ? this.style : (newStyle = this.styleChange != 0 ? baseStyle & ~(this.styleChange >> 16 & 0xFFFF) | this.styleChange & 0xFFFF : baseStyle);
        int n2 = this.absoluteSize > 0 ? scale.applyAsInt(this.absoluteSize) : (this.relativeSize != 0 ? baseSize + scale.applyAsInt(this.relativeSize) : (newSize = this.scaleSize > 0.0f ? Math.round((float)baseSize * this.scaleSize) : baseSize));
        if (newSize <= 0) {
            newSize = 1;
        }
        if (this.families != null && !this.families.isEmpty()) {
            FontUIResource font;
            String preferredFamily = FlatLaf.ActiveFont.preferredFamily(this.families);
            if (preferredFamily != null && (!FlatLaf.ActiveFont.isFallbackFont(font = FlatLaf.createCompositeFont(preferredFamily, newStyle, newSize)) || FlatLaf.ActiveFont.isDialogFamily(preferredFamily))) {
                return this.toUIResource(font);
            }
            for (String family : this.families) {
                FontUIResource font2 = FlatLaf.createCompositeFont(family, newStyle, newSize);
                if (FlatLaf.ActiveFont.isFallbackFont(font2) && !FlatLaf.ActiveFont.isDialogFamily(family)) continue;
                return this.toUIResource(font2);
            }
        }
        if (newStyle != baseStyle || newSize != baseSize) {
            FontUIResource font;
            if ("Ubuntu Medium".equalsIgnoreCase(baseFont.getName()) && "Ubuntu Light".equalsIgnoreCase(baseFont.getFamily()) && !FlatLaf.ActiveFont.isFallbackFont(font = FlatLaf.createCompositeFont("Ubuntu Medium", newStyle, newSize))) {
                return this.toUIResource(font);
            }
            return this.toUIResource(baseFont.deriveFont(newStyle, newSize));
        }
        return this.toUIResource(baseFont);
    }

    private FontUIResource toUIResource(Font font) {
        return font instanceof FontUIResource ? (FontUIResource)font : new FontUIResource(font);
    }

    private static boolean isFallbackFont(Font font) {
        return "Dialog".equalsIgnoreCase(font.getFamily());
    }

    private static boolean isDialogFamily(String family) {
        return family.equalsIgnoreCase("Dialog");
    }

    private static String preferredFamily(List<String> families) {
        for (String family : families) {
            if ((family = family.toLowerCase(Locale.ENGLISH)).endsWith(" light") || family.endsWith("-thin")) {
                return preferredLightFontFamily;
            }
            if (family.endsWith(" semibold") || family.endsWith("-medium")) {
                return preferredSemiboldFontFamily;
            }
            if (!family.equals("monospaced")) continue;
            return preferredMonospacedFontFamily;
        }
        return null;
    }

    static /* synthetic */ boolean access$000(Font x0) {
        return FlatLaf.ActiveFont.isFallbackFont(x0);
    }

    static /* synthetic */ boolean access$100(String x0) {
        return FlatLaf.ActiveFont.isDialogFamily(x0);
    }
}
