/*
 * Decompiled with CFR 0.152.
 */
package com.jgoodies.forms.factories;

import javax.swing.JLabel;

private final class DefaultComponentFactory.FormsLabel.AccessibleFormsLabel
extends JLabel.AccessibleJLabel {
    private DefaultComponentFactory.FormsLabel.AccessibleFormsLabel() {
        super(FormsLabel.this);
    }

    public String getAccessibleName() {
        if (this.accessibleName != null) {
            return this.accessibleName;
        }
        String text = FormsLabel.this.getText();
        if (text == null) {
            return super.getAccessibleName();
        }
        return text.endsWith(":") ? text.substring(0, text.length() - 1) : text;
    }
}
