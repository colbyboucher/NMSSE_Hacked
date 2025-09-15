/*
 * Decompiled with CFR 0.152.
 */
package com.formdev.flatlaf.ui;

import com.formdev.flatlaf.ui.FlatRootPaneUI;
import com.formdev.flatlaf.ui.FlatTitlePane;
import com.formdev.flatlaf.util.UIScale;
import java.awt.Component;
import java.awt.Container;
import javax.swing.JMenuBar;
import javax.swing.JRootPane;
import javax.swing.SwingUtilities;
import javax.swing.plaf.basic.DefaultMenuLayout;

protected static class FlatMenuBarUI.FlatMenuBarLayout
extends DefaultMenuLayout {
    public FlatMenuBarUI.FlatMenuBarLayout(Container target) {
        super(target, 2);
    }

    @Override
    public void layoutContainer(Container target) {
        block14: {
            int offset;
            super.layoutContainer(target);
            JRootPane rootPane = SwingUtilities.getRootPane(target);
            if (rootPane == null || rootPane.getJMenuBar() != target) {
                return;
            }
            FlatTitlePane titlePane = FlatRootPaneUI.getTitlePane(rootPane);
            if (titlePane == null || !titlePane.isMenuBarEmbedded()) {
                return;
            }
            Component horizontalGlue = titlePane.findHorizontalGlue((JMenuBar)target);
            int minTitleWidth = UIScale.scale(titlePane.titleMinimumWidth);
            if (horizontalGlue == null || horizontalGlue.getWidth() >= minTitleWidth) break block14;
            int glueIndex = -1;
            Component[] components = target.getComponents();
            for (int i = components.length - 1; i >= 0; --i) {
                if (components[i] != horizontalGlue) continue;
                glueIndex = i;
                break;
            }
            if (glueIndex < 0) {
                return;
            }
            if (target.getComponentOrientation().isLeftToRight()) {
                Component c;
                int i;
                offset = minTitleWidth - horizontalGlue.getWidth();
                horizontalGlue.setSize(minTitleWidth, horizontalGlue.getHeight());
                int minGlueX = target.getWidth() - target.getInsets().right - minTitleWidth;
                if (minGlueX < horizontalGlue.getX()) {
                    offset -= horizontalGlue.getX() - minGlueX;
                    horizontalGlue.setLocation(minGlueX, horizontalGlue.getY());
                    for (i = glueIndex - 1; i >= 0; --i) {
                        c = components[i];
                        if (c.getX() <= minGlueX) {
                            c.setSize(minGlueX - c.getX(), c.getHeight());
                            break;
                        }
                        c.setBounds(minGlueX, c.getY(), 0, c.getHeight());
                    }
                }
                for (i = glueIndex + 1; i < components.length; ++i) {
                    c = components[i];
                    c.setLocation(c.getX() + offset, c.getY());
                }
            } else {
                offset = minTitleWidth - horizontalGlue.getWidth();
                horizontalGlue.setBounds(horizontalGlue.getX() - offset, horizontalGlue.getY(), minTitleWidth, horizontalGlue.getHeight());
                int minGlueX = target.getInsets().left;
                if (minGlueX > horizontalGlue.getX()) {
                    offset -= horizontalGlue.getX() - minGlueX;
                    horizontalGlue.setLocation(minGlueX, horizontalGlue.getY());
                    int x = horizontalGlue.getX() + horizontalGlue.getWidth();
                    for (int i = glueIndex - 1; i >= 0; --i) {
                        Component c = components[i];
                        if (c.getX() + c.getWidth() >= x) {
                            c.setBounds(x, c.getY(), c.getWidth() - (x - c.getX()), c.getHeight());
                            break;
                        }
                        c.setBounds(x, c.getY(), 0, c.getHeight());
                    }
                }
                for (int i = glueIndex + 1; i < components.length; ++i) {
                    Component c = components[i];
                    c.setLocation(c.getX() - offset, c.getY());
                }
            }
        }
    }
}
