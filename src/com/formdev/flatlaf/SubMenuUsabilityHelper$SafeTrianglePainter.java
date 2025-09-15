/*
 * Decompiled with CFR 0.152.
 */
package com.formdev.flatlaf;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Window;
import javax.swing.JComponent;
import javax.swing.JLayeredPane;
import javax.swing.JPopupMenu;
import javax.swing.RootPaneContainer;
import javax.swing.SwingUtilities;

private class SubMenuUsabilityHelper.SafeTrianglePainter
extends JComponent {
    SubMenuUsabilityHelper.SafeTrianglePainter(JPopupMenu popup) {
        Window window = SwingUtilities.windowForComponent(popup.getInvoker());
        if (window instanceof RootPaneContainer) {
            JLayeredPane layeredPane = ((RootPaneContainer)((Object)window)).getLayeredPane();
            this.setSize(layeredPane.getSize());
            layeredPane.add((Component)this, (Object)(JLayeredPane.POPUP_LAYER + 1));
        }
    }

    void uninstall() {
        Container parent = this.getParent();
        if (parent != null) {
            parent.remove(this);
            parent.repaint();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        Point locationOnScreen = this.getLocationOnScreen();
        g.translate(-locationOnScreen.x, -locationOnScreen.y);
        g.setColor(Color.red);
        ((Graphics2D)g).draw(SubMenuUsabilityHelper.this.createSafeTriangle());
    }
}
