/*
 * Decompiled with CFR 0.152.
 */
package com.formdev.flatlaf.ui;

import java.awt.event.ContainerEvent;
import javax.swing.plaf.basic.BasicToolBarUI;

class FlatToolBarUI.1
extends BasicToolBarUI.ToolBarContListener {
    FlatToolBarUI.1() {
        super(FlatToolBarUI.this);
    }

    @Override
    public void componentAdded(ContainerEvent e) {
        super.componentAdded(e);
        if (!FlatToolBarUI.this.focusableButtons) {
            FlatToolBarUI.this.setButtonFocusable(e.getChild(), false);
        }
    }

    @Override
    public void componentRemoved(ContainerEvent e) {
        super.componentRemoved(e);
        if (!FlatToolBarUI.this.focusableButtons) {
            FlatToolBarUI.this.setButtonFocusable(e.getChild(), true);
        }
    }
}
