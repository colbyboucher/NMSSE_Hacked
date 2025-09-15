/*
 * Decompiled with CFR 0.152.
 */
package com.formdev.flatlaf.ui;

import java.beans.PropertyChangeEvent;
import javax.swing.AbstractButton;
import javax.swing.plaf.basic.BasicButtonListener;

protected class FlatRadioButtonUI.FlatRadioButtonListener
extends BasicButtonListener {
    private final AbstractButton b;

    protected FlatRadioButtonUI.FlatRadioButtonListener(AbstractButton b) {
        super(b);
        this.b = b;
    }

    @Override
    public void propertyChange(PropertyChangeEvent e) {
        super.propertyChange(e);
        FlatRadioButtonUI.this.propertyChange(this.b, e);
    }
}
