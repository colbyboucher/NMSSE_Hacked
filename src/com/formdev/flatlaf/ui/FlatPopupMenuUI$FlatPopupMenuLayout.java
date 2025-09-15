/*
 * Decompiled with CFR 0.152.
 */
package com.formdev.flatlaf.ui;

import com.formdev.flatlaf.ui.FlatMenuItemRenderer;
import java.awt.Container;
import java.awt.Dimension;
import javax.swing.plaf.basic.DefaultMenuLayout;

protected static class FlatPopupMenuUI.FlatPopupMenuLayout
extends DefaultMenuLayout {
    public FlatPopupMenuUI.FlatPopupMenuLayout(Container target, int axis) {
        super(target, axis);
    }

    @Override
    public Dimension preferredLayoutSize(Container target) {
        FlatMenuItemRenderer.clearClientProperties(target);
        return super.preferredLayoutSize(target);
    }
}
