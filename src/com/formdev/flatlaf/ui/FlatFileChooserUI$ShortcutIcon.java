/*
 * Decompiled with CFR 0.152.
 */
package com.formdev.flatlaf.ui;

import com.formdev.flatlaf.util.UIScale;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.Icon;

private static class FlatFileChooserUI.ShortcutIcon
implements Icon {
    private final Icon icon;
    private final int iconWidth;
    private final int iconHeight;

    FlatFileChooserUI.ShortcutIcon(Icon icon, int iconWidth, int iconHeight) {
        this.icon = icon;
        this.iconWidth = iconWidth;
        this.iconHeight = iconHeight;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void paintIcon(Component c, Graphics g, int x, int y) {
        Graphics2D g2 = (Graphics2D)g.create();
        try {
            g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
            double scale = (double)this.getIconWidth() / (double)this.icon.getIconWidth();
            g2.translate(x, y);
            g2.scale(scale, scale);
            this.icon.paintIcon(c, g2, 0, 0);
        }
        finally {
            g2.dispose();
        }
    }

    @Override
    public int getIconWidth() {
        return UIScale.scale(this.iconWidth);
    }

    @Override
    public int getIconHeight() {
        return UIScale.scale(this.iconHeight);
    }
}
