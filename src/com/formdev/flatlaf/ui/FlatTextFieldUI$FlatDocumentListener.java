/*
 * Decompiled with CFR 0.152.
 */
package com.formdev.flatlaf.ui;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

private class FlatTextFieldUI.FlatDocumentListener
implements DocumentListener {
    private FlatTextFieldUI.FlatDocumentListener() {
    }

    @Override
    public void insertUpdate(DocumentEvent e) {
        FlatTextFieldUI.this.documentChanged(e);
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        FlatTextFieldUI.this.documentChanged(e);
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        FlatTextFieldUI.this.documentChanged(e);
    }
}
