/*
 * Decompiled with CFR 0.152.
 */
package com.formdev.flatlaf.ui;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Insets;
import javax.swing.border.Border;

private static class FlatUIUtils.NonUIResourceBorder
implements Border {
    private final Border delegate;

    FlatUIUtils.NonUIResourceBorder(Border delegate) {
        this.delegate = delegate;
    }

    @Override
    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        this.delegate.paintBorder(c, g, x, y, width, height);
    }

    @Override
    public Insets getBorderInsets(Component c) {
        return this.delegate.getBorderInsets(c);
    }

    @Override
    public boolean isBorderOpaque() {
        return this.delegate.isBorderOpaque();
    }

    static /* synthetic */ Border access$000(FlatUIUtils.NonUIResourceBorder x0) {
        return x0.delegate;
    }
}
