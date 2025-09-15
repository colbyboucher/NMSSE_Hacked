/*
 * Decompiled with CFR 0.152.
 */
package com.formdev.flatlaf.ui;

import java.awt.Component;
import java.awt.Container;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.JComponent;
import javax.swing.SwingUtilities;

private static class FlatRadioButtonUI.AWTPeerMouseExitedFix
extends MouseAdapter
implements PropertyChangeListener {
    private final JComponent button;

    static void install(JComponent button) {
        FlatRadioButtonUI.AWTPeerMouseExitedFix l = new FlatRadioButtonUI.AWTPeerMouseExitedFix(button);
        button.addPropertyChangeListener("ancestor", l);
        Container parent = button.getParent();
        if (parent != null) {
            parent.addMouseListener(l);
        }
    }

    static void uninstall(JComponent button) {
        for (PropertyChangeListener l : button.getPropertyChangeListeners("ancestor")) {
            if (!(l instanceof FlatRadioButtonUI.AWTPeerMouseExitedFix)) continue;
            button.removePropertyChangeListener("ancestor", l);
            Container parent = button.getParent();
            if (parent == null) break;
            parent.removeMouseListener((FlatRadioButtonUI.AWTPeerMouseExitedFix)l);
            break;
        }
    }

    FlatRadioButtonUI.AWTPeerMouseExitedFix(JComponent button) {
        this.button = button;
    }

    @Override
    public void propertyChange(PropertyChangeEvent e) {
        if (e.getOldValue() instanceof Component) {
            ((Component)e.getOldValue()).removeMouseListener(this);
        }
        if (e.getNewValue() instanceof Component) {
            ((Component)e.getNewValue()).removeMouseListener(this);
            ((Component)e.getNewValue()).addMouseListener(this);
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        this.button.dispatchEvent(SwingUtilities.convertMouseEvent(e.getComponent(), e, this.button));
    }
}
