/*
 * Decompiled with CFR 0.152.
 */
package com.formdev.flatlaf.ui;

import java.awt.Component;
import java.awt.Container;
import javax.swing.AbstractButton;
import javax.swing.LayoutFocusTraversalPolicy;

protected class FlatToolBarUI.FlatToolBarFocusTraversalPolicy
extends LayoutFocusTraversalPolicy {
    protected FlatToolBarUI.FlatToolBarFocusTraversalPolicy() {
    }

    @Override
    public Component getComponentAfter(Container aContainer, Component aComponent) {
        if (!(aComponent instanceof AbstractButton)) {
            return super.getComponentAfter(aContainer, aComponent);
        }
        Component c = aComponent;
        while ((c = super.getComponentAfter(aContainer, c)) != null) {
            if (c instanceof AbstractButton) continue;
            return c;
        }
        return null;
    }

    @Override
    public Component getComponentBefore(Container aContainer, Component aComponent) {
        if (!(aComponent instanceof AbstractButton)) {
            return super.getComponentBefore(aContainer, aComponent);
        }
        Component c = aComponent;
        while ((c = super.getComponentBefore(aContainer, c)) != null) {
            if (c instanceof AbstractButton) continue;
            return c;
        }
        return null;
    }

    @Override
    public Component getFirstComponent(Container aContainer) {
        return this.getRecentComponent(aContainer, true);
    }

    @Override
    public Component getLastComponent(Container aContainer) {
        return this.getRecentComponent(aContainer, false);
    }

    private Component getRecentComponent(Container aContainer, boolean first) {
        if (FlatToolBarUI.this.focusedCompIndex >= 0 && FlatToolBarUI.this.focusedCompIndex < FlatToolBarUI.this.toolBar.getComponentCount()) {
            return FlatToolBarUI.this.toolBar.getComponent(FlatToolBarUI.this.focusedCompIndex);
        }
        return first ? super.getFirstComponent(aContainer) : super.getLastComponent(aContainer);
    }
}
