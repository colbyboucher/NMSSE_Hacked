/*
 * Decompiled with CFR 0.152.
 */
package com.formdev.flatlaf.ui;

import com.formdev.flatlaf.util.UIScale;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Insets;
import java.awt.Point;
import javax.swing.Icon;
import javax.swing.JMenuBar;
import javax.swing.SwingUtilities;

class FlatTitlePane.3
extends BorderLayout {
    FlatTitlePane.3() {
    }

    @Override
    public void layoutContainer(Container target) {
        Component horizontalGlue;
        Insets insets = target.getInsets();
        int x = insets.left;
        int y = insets.top;
        int w = target.getWidth() - insets.left - insets.right;
        int h = target.getHeight() - insets.top - insets.bottom;
        int leftWidth = FlatTitlePane.this.leftPanel.getPreferredSize().width;
        int buttonsWidth = FlatTitlePane.this.buttonPanel.getPreferredSize().width;
        int titleWidth = w - leftWidth - buttonsWidth;
        int minTitleWidth = UIScale.scale(FlatTitlePane.this.titleMinimumWidth);
        Icon icon = FlatTitlePane.this.titleLabel.getIcon();
        if (icon != null) {
            Insets iconInsets = FlatTitlePane.this.iconLabel.getInsets();
            int iconTextGap = FlatTitlePane.this.titleLabel.getComponentOrientation().isLeftToRight() ? iconInsets.right : iconInsets.left;
            minTitleWidth += icon.getIconWidth() + iconTextGap;
        }
        if (titleWidth < minTitleWidth) {
            buttonsWidth = Math.max(buttonsWidth - (minTitleWidth - titleWidth), FlatTitlePane.this.buttonPanel.getMinimumSize().width);
            titleWidth = w - leftWidth - buttonsWidth;
        }
        if (titleWidth < minTitleWidth) {
            int minLeftWidth = FlatTitlePane.this.iconLabel.isVisible() ? FlatTitlePane.this.iconLabel.getWidth() - FlatTitlePane.this.iconLabel.getInsets().right : UIScale.scale(FlatTitlePane.this.noIconLeftGap);
            leftWidth = Math.max(leftWidth - (minTitleWidth - titleWidth), minLeftWidth);
            titleWidth = w - leftWidth - buttonsWidth;
        }
        if (target.getComponentOrientation().isLeftToRight()) {
            FlatTitlePane.this.leftPanel.setBounds(x, y, leftWidth, h);
            FlatTitlePane.this.titleLabel.setBounds(x + leftWidth, y, titleWidth, h);
            FlatTitlePane.this.buttonPanel.setBounds(x + leftWidth + titleWidth, y, buttonsWidth, h);
        } else {
            FlatTitlePane.this.buttonPanel.setBounds(x, y, buttonsWidth, h);
            FlatTitlePane.this.titleLabel.setBounds(x + buttonsWidth, y, titleWidth, h);
            FlatTitlePane.this.leftPanel.setBounds(x + buttonsWidth + titleWidth, y, leftWidth, h);
        }
        JMenuBar menuBar = FlatTitlePane.this.rootPane.getJMenuBar();
        if (FlatTitlePane.this.hasVisibleEmbeddedMenuBar(menuBar) && (horizontalGlue = FlatTitlePane.this.findHorizontalGlue(menuBar)) != null) {
            Point glueLocation = SwingUtilities.convertPoint(horizontalGlue, 0, 0, FlatTitlePane.this.titleLabel);
            FlatTitlePane.this.titleLabel.setBounds(FlatTitlePane.this.titleLabel.getX() + glueLocation.x, FlatTitlePane.this.titleLabel.getY(), horizontalGlue.getWidth(), FlatTitlePane.this.titleLabel.getHeight());
        }
    }
}
