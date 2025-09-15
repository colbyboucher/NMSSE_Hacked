/*
 * Decompiled with CFR 0.152.
 */
package com.formdev.flatlaf.ui;

import com.formdev.flatlaf.ui.FlatNativeWindowBorder;
import com.formdev.flatlaf.ui.FlatUIUtils;
import com.formdev.flatlaf.util.SystemInfo;
import com.formdev.flatlaf.util.UIScale;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Insets;
import javax.swing.JMenuBar;
import javax.swing.border.AbstractBorder;
import javax.swing.border.Border;

protected class FlatTitlePane.FlatTitlePaneBorder
extends AbstractBorder {
    protected FlatTitlePane.FlatTitlePaneBorder() {
    }

    @Override
    public Insets getBorderInsets(Component c, Insets insets) {
        super.getBorderInsets(c, insets);
        Border menuBarBorder = this.getMenuBarBorder();
        if (menuBarBorder != null) {
            Insets menuBarInsets = menuBarBorder.getBorderInsets(c);
            insets.bottom += menuBarInsets.bottom;
        } else if (!(FlatTitlePane.this.borderColor == null || FlatTitlePane.this.rootPane.getJMenuBar() != null && FlatTitlePane.this.rootPane.getJMenuBar().isVisible())) {
            insets.bottom += UIScale.scale(1);
        }
        if (!SystemInfo.isWindows_11_orLater && FlatTitlePane.this.hasNativeCustomDecoration() && !FlatTitlePane.this.isWindowMaximized()) {
            insets = FlatUIUtils.addInsets(insets, FlatNativeWindowBorder.WindowTopBorder.getInstance().getBorderInsets());
        }
        return insets;
    }

    @Override
    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        Border menuBarBorder = this.getMenuBarBorder();
        if (menuBarBorder != null) {
            menuBarBorder.paintBorder(FlatTitlePane.this.rootPane.getJMenuBar(), g, x, y, width, height);
        } else if (!(FlatTitlePane.this.borderColor == null || FlatTitlePane.this.rootPane.getJMenuBar() != null && FlatTitlePane.this.rootPane.getJMenuBar().isVisible())) {
            float lineHeight = UIScale.scale(1.0f);
            FlatUIUtils.paintFilledRectangle(g, FlatTitlePane.this.borderColor, x, (float)(y + height) - lineHeight, width, lineHeight);
        }
        if (!SystemInfo.isWindows_11_orLater && FlatTitlePane.this.hasNativeCustomDecoration() && !FlatTitlePane.this.isWindowMaximized()) {
            FlatNativeWindowBorder.WindowTopBorder.getInstance().paintBorder(c, g, x, y, width, height);
        }
    }

    protected Border getMenuBarBorder() {
        JMenuBar menuBar = FlatTitlePane.this.rootPane.getJMenuBar();
        return FlatTitlePane.this.hasVisibleEmbeddedMenuBar(menuBar) ? menuBar.getBorder() : null;
    }
}
