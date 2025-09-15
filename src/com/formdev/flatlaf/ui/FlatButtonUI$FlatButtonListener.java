/*
 * Decompiled with CFR 0.152.
 */
package com.formdev.flatlaf.ui;

import com.formdev.flatlaf.ui.FlatToolBarUI;
import java.awt.Container;
import java.beans.PropertyChangeEvent;
import javax.swing.AbstractButton;
import javax.swing.JToolBar;
import javax.swing.event.ChangeEvent;
import javax.swing.plaf.ToolBarUI;
import javax.swing.plaf.basic.BasicButtonListener;

protected class FlatButtonUI.FlatButtonListener
extends BasicButtonListener {
    private final AbstractButton b;

    protected FlatButtonUI.FlatButtonListener(AbstractButton b) {
        super(b);
        this.b = b;
    }

    @Override
    public void propertyChange(PropertyChangeEvent e) {
        super.propertyChange(e);
        FlatButtonUI.this.propertyChange(this.b, e);
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        JToolBar toolBar;
        ToolBarUI ui;
        super.stateChanged(e);
        AbstractButton b = (AbstractButton)e.getSource();
        Container parent = b.getParent();
        if (parent instanceof JToolBar && (ui = (toolBar = (JToolBar)parent).getUI()) instanceof FlatToolBarUI) {
            ((FlatToolBarUI)ui).repaintButtonGroup(b);
        }
    }
}
