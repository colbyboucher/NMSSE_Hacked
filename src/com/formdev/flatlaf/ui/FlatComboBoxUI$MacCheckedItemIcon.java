/*
 * Decompiled with CFR 0.152.
 */
package com.formdev.flatlaf.ui;

import com.formdev.flatlaf.icons.FlatCheckBoxMenuItemIcon;
import java.awt.Component;
import java.awt.Graphics2D;

private static class FlatComboBoxUI.MacCheckedItemIcon
extends FlatCheckBoxMenuItemIcon {
    static FlatComboBoxUI.MacCheckedItemIcon INSTANCE = new FlatComboBoxUI.MacCheckedItemIcon();

    private FlatComboBoxUI.MacCheckedItemIcon() {
    }

    @Override
    protected void paintIcon(Component c, Graphics2D g2) {
        g2.setColor(c.getForeground());
        this.paintCheckmark(g2);
    }
}
