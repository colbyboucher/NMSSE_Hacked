/*
 * Decompiled with CFR 0.152.
 */
package com.formdev.flatlaf.ui;

import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.ui.FlatComboBoxUI;
import com.formdev.flatlaf.util.UIScale;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Insets;
import javax.swing.JComponent;
import javax.swing.border.AbstractBorder;
import javax.swing.border.Border;

private static class FlatComboBoxUI.CellPaddingBorder
extends AbstractBorder {
    static final String KEY_MAC_STYLE_HINT = "FlatLaf.internal.FlatComboBoxUI.macStyleHint";
    static final int MAC_STYLE_GAP = 4;
    private Insets padding;
    private JComponent rendererComponent;
    private Border rendererBorder;
    private int focusWidth;

    FlatComboBoxUI.CellPaddingBorder(Insets padding) {
        this.padding = padding;
    }

    synchronized void install(Component c, int focusWidth) {
        if (!(c instanceof JComponent)) {
            return;
        }
        this.focusWidth = focusWidth;
        JComponent jc = (JComponent)c;
        Border oldBorder = jc.getBorder();
        if (oldBorder == this) {
            return;
        }
        if (oldBorder instanceof FlatComboBoxUI.CellPaddingBorder) {
            ((FlatComboBoxUI.CellPaddingBorder)oldBorder).uninstall();
        }
        this.uninstall();
        this.rendererComponent = jc;
        this.rendererBorder = jc.getBorder();
        jc.setBorder(this);
    }

    synchronized void uninstall() {
        if (this.rendererComponent == null) {
            return;
        }
        this.rendererComponent.putClientProperty(KEY_MAC_STYLE_HINT, null);
        if (this.rendererComponent.getBorder() == this) {
            this.rendererComponent.setBorder(this.rendererBorder);
        }
        this.rendererComponent = null;
        this.rendererBorder = null;
    }

    @Override
    public synchronized Insets getBorderInsets(Component c, Insets insets) {
        Boolean macStyleHint;
        Insets padding = UIScale.scale(this.padding);
        if (this.rendererBorder != null && !(this.rendererBorder instanceof FlatComboBoxUI.CellPaddingBorder)) {
            Insets insideInsets = this.rendererBorder.getBorderInsets(c);
            insets.top = Math.max(padding.top, insideInsets.top);
            insets.left = Math.max(padding.left, insideInsets.left);
            insets.bottom = Math.max(padding.bottom, insideInsets.bottom);
            insets.right = Math.max(padding.right, insideInsets.right);
        } else {
            insets.top = padding.top;
            insets.left = padding.left;
            insets.bottom = padding.bottom;
            insets.right = padding.right;
        }
        insets.left += this.focusWidth;
        insets.right += this.focusWidth;
        if (c instanceof JComponent && (macStyleHint = FlatClientProperties.clientPropertyBooleanStrict((JComponent)c, KEY_MAC_STYLE_HINT, null)) != null) {
            int indent = FlatComboBoxUI.MacCheckedItemIcon.INSTANCE.getIconWidth() + UIScale.scale(4);
            if (c.getComponentOrientation().isLeftToRight()) {
                insets.left += indent;
            } else {
                insets.right += indent;
            }
        }
        return insets;
    }

    @Override
    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        Boolean macStyleHint;
        if (this.rendererBorder != null) {
            this.rendererBorder.paintBorder(c, g, x, y, width, height);
        }
        if (c instanceof JComponent && (macStyleHint = FlatClientProperties.clientPropertyBooleanStrict((JComponent)c, KEY_MAC_STYLE_HINT, null)) == Boolean.TRUE) {
            int ix = c.getComponentOrientation().isLeftToRight() ? x + UIScale.scale(this.padding.left) : x + width - UIScale.scale(this.padding.right) - FlatComboBoxUI.MacCheckedItemIcon.INSTANCE.getIconWidth();
            FlatComboBoxUI.MacCheckedItemIcon.INSTANCE.paintIcon(c, g, ix, y + (height - FlatComboBoxUI.MacCheckedItemIcon.INSTANCE.getIconHeight()) / 2);
        }
    }

    static /* synthetic */ Insets access$2602(FlatComboBoxUI.CellPaddingBorder x0, Insets x1) {
        x0.padding = x1;
        return x0.padding;
    }
}
