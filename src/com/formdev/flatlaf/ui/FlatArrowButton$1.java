/*
 * Decompiled with CFR 0.152.
 */
package com.formdev.flatlaf.ui;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingUtilities;

class FlatArrowButton.1
extends MouseAdapter {
    FlatArrowButton.1() {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        FlatArrowButton.this.hover = true;
        FlatArrowButton.this.repaint();
    }

    @Override
    public void mouseExited(MouseEvent e) {
        FlatArrowButton.this.hover = false;
        FlatArrowButton.this.repaint();
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (SwingUtilities.isLeftMouseButton(e)) {
            FlatArrowButton.this.pressed = true;
            FlatArrowButton.this.repaint();
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (SwingUtilities.isLeftMouseButton(e)) {
            FlatArrowButton.this.pressed = false;
            FlatArrowButton.this.repaint();
        }
    }
}
