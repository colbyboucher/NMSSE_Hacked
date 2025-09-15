/*
 * Decompiled with CFR 0.152.
 */
package com.formdev.flatlaf.ui;

import com.formdev.flatlaf.util.UIScale;
import java.awt.Container;
import javax.swing.plaf.basic.BasicSplitPaneDivider;

protected class FlatSplitPaneUI.FlatSplitPaneDivider.FlatDividerLayout
extends BasicSplitPaneDivider.DividerLayout {
    protected FlatSplitPaneUI.FlatSplitPaneDivider.FlatDividerLayout() {
        super(FlatSplitPaneDivider.this);
    }

    @Override
    public void layoutContainer(Container c) {
        super.layoutContainer(c);
        if (FlatSplitPaneDivider.this.leftButton == null || FlatSplitPaneDivider.this.rightButton == null || !FlatSplitPaneDivider.this.splitPane.isOneTouchExpandable()) {
            return;
        }
        int extraSize = UIScale.scale(4);
        if (FlatSplitPaneDivider.this.orientation == 0) {
            FlatSplitPaneDivider.this.leftButton.setSize(FlatSplitPaneDivider.this.leftButton.getWidth() + extraSize, FlatSplitPaneDivider.this.leftButton.getHeight());
            FlatSplitPaneDivider.this.rightButton.setBounds(FlatSplitPaneDivider.this.leftButton.getX() + FlatSplitPaneDivider.this.leftButton.getWidth(), FlatSplitPaneDivider.this.rightButton.getY(), FlatSplitPaneDivider.this.rightButton.getWidth() + extraSize, FlatSplitPaneDivider.this.rightButton.getHeight());
        } else {
            FlatSplitPaneDivider.this.leftButton.setSize(FlatSplitPaneDivider.this.leftButton.getWidth(), FlatSplitPaneDivider.this.leftButton.getHeight() + extraSize);
            FlatSplitPaneDivider.this.rightButton.setBounds(FlatSplitPaneDivider.this.rightButton.getX(), FlatSplitPaneDivider.this.leftButton.getY() + FlatSplitPaneDivider.this.leftButton.getHeight(), FlatSplitPaneDivider.this.rightButton.getWidth(), FlatSplitPaneDivider.this.rightButton.getHeight() + extraSize);
        }
        boolean leftCollapsed = FlatSplitPaneDivider.this.isLeftCollapsed();
        boolean rightCollapsed = FlatSplitPaneDivider.this.isRightCollapsed();
        if (leftCollapsed || rightCollapsed) {
            FlatSplitPaneDivider.this.leftButton.setVisible(!leftCollapsed);
            FlatSplitPaneDivider.this.rightButton.setVisible(!rightCollapsed);
        } else {
            Object expandableSide = FlatSplitPaneDivider.this.splitPane.getClientProperty("JSplitPane.expandableSide");
            FlatSplitPaneDivider.this.leftButton.setVisible(expandableSide == null || !"left".equals(expandableSide));
            FlatSplitPaneDivider.this.rightButton.setVisible(expandableSide == null || !"right".equals(expandableSide));
        }
        if (!FlatSplitPaneDivider.this.leftButton.isVisible()) {
            FlatSplitPaneDivider.this.rightButton.setLocation(FlatSplitPaneDivider.this.leftButton.getLocation());
        }
    }
}
