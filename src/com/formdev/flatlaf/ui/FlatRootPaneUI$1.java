/*
 * Decompiled with CFR 0.152.
 */
package com.formdev.flatlaf.ui;

import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import javax.swing.JRootPane;

class FlatRootPaneUI.1
extends ComponentAdapter {
    final /* synthetic */ JRootPane val$root;

    FlatRootPaneUI.1(JRootPane jRootPane) {
        this.val$root = jRootPane;
    }

    @Override
    public void componentShown(ComponentEvent e) {
        this.val$root.getParent().repaint(this.val$root.getX(), this.val$root.getY(), this.val$root.getWidth(), this.val$root.getHeight());
    }
}
