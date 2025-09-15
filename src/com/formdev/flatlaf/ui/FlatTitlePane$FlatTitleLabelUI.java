/*
 * Decompiled with CFR 0.152.
 */
package com.formdev.flatlaf.ui;

import com.formdev.flatlaf.ui.FlatLabelUI;
import com.formdev.flatlaf.util.UIScale;
import java.awt.Component;
import java.awt.Container;
import java.awt.FontMetrics;
import java.awt.Insets;
import java.awt.Rectangle;
import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.SwingUtilities;

protected class FlatTitlePane.FlatTitleLabelUI
extends FlatLabelUI {
    protected FlatTitlePane.FlatTitleLabelUI() {
        super(false);
    }

    @Override
    protected void installDefaults(JLabel c) {
        super.installDefaults(c);
        if (FlatTitlePane.this.titleFont != null) {
            c.setFont(FlatTitlePane.this.titleFont);
        }
    }

    @Override
    protected String layoutCL(JLabel label, FontMetrics fontMetrics, String text, Icon icon, Rectangle viewR, Rectangle iconR, Rectangle textR) {
        String clippedText;
        JMenuBar menuBar = FlatTitlePane.this.rootPane.getJMenuBar();
        boolean hasEmbeddedMenuBar = FlatTitlePane.this.hasVisibleEmbeddedMenuBar(menuBar);
        boolean hasEmbeddedLeadingMenus = hasEmbeddedMenuBar && this.hasLeadingMenus(menuBar);
        boolean leftToRight = FlatTitlePane.this.getComponentOrientation().isLeftToRight();
        if (hasEmbeddedMenuBar) {
            Component horizontalGlue;
            int minGap = UIScale.scale(FlatTitlePane.this.menuBarTitleMinimumGap);
            if (hasEmbeddedLeadingMenus) {
                if (leftToRight) {
                    viewR.x += minGap;
                }
                viewR.width -= minGap;
            }
            if ((horizontalGlue = FlatTitlePane.this.findHorizontalGlue(menuBar)) != null && menuBar.getComponent(menuBar.getComponentCount() - 1) != horizontalGlue) {
                if (!leftToRight) {
                    viewR.x += minGap;
                }
                viewR.width -= minGap;
            }
        }
        int iconTextGap = 0;
        int iconWidthAndGap = 0;
        if (icon != null) {
            Insets iconInsets = FlatTitlePane.this.iconLabel.getInsets();
            iconTextGap = leftToRight ? iconInsets.right : iconInsets.left;
            iconWidthAndGap = icon.getIconWidth() + iconTextGap;
        }
        if (!(clippedText = SwingUtilities.layoutCompoundLabel(label, fontMetrics, text, icon, label.getVerticalAlignment(), label.getHorizontalAlignment(), label.getVerticalTextPosition(), label.getHorizontalTextPosition(), viewR, iconR, textR, iconTextGap)).equals(text)) {
            textR.x = leftToRight ? viewR.x + iconWidthAndGap : viewR.x + viewR.width - iconWidthAndGap - textR.width;
        } else {
            boolean center;
            int leadingGap = hasEmbeddedLeadingMenus ? UIScale.scale(FlatTitlePane.this.menuBarTitleGap - FlatTitlePane.this.menuBarTitleMinimumGap) : 0;
            boolean bl = center = hasEmbeddedLeadingMenus ? FlatTitlePane.this.centerTitleIfMenuBarEmbedded : FlatTitlePane.this.centerTitle;
            if (center) {
                Container parent = label.getParent();
                int centeredTextX = parent != null ? (parent.getWidth() - textR.width - iconWidthAndGap) / 2 + iconWidthAndGap - label.getX() : -1;
                textR.x = centeredTextX >= viewR.x + leadingGap && centeredTextX + textR.width <= viewR.x + viewR.width - leadingGap ? centeredTextX : viewR.x + (viewR.width - textR.width - iconWidthAndGap) / 2 + iconWidthAndGap;
            } else {
                int n = textR.x = leftToRight ? Math.min(viewR.x + leadingGap + iconWidthAndGap, viewR.x + viewR.width - textR.width) : Math.max(viewR.x + viewR.width - leadingGap - iconWidthAndGap - textR.width, viewR.x);
            }
        }
        if (icon != null) {
            iconR.x = leftToRight ? textR.x - iconWidthAndGap : textR.x + textR.width + iconTextGap;
        }
        return clippedText;
    }

    private boolean hasLeadingMenus(JMenuBar menuBar) {
        boolean leftToRight;
        if (menuBar.getComponentCount() == 0 || menuBar.getWidth() == 0) {
            return false;
        }
        Component horizontalGlue = FlatTitlePane.this.findHorizontalGlue(menuBar);
        return horizontalGlue == null || (!(leftToRight = FlatTitlePane.this.getComponentOrientation().isLeftToRight()) || horizontalGlue.getX() != 0) && (leftToRight || horizontalGlue.getX() + horizontalGlue.getWidth() != menuBar.getWidth());
    }
}
