/*
 * Decompiled with CFR 0.152.
 */
package com.jgoodies.forms.factories;

import javax.accessibility.AccessibleContext;
import javax.swing.JLabel;

private static class DefaultComponentFactory.FormsLabel
extends JLabel {
    private DefaultComponentFactory.FormsLabel() {
    }

    public AccessibleContext getAccessibleContext() {
        if (this.accessibleContext == null) {
            this.accessibleContext = new AccessibleFormsLabel();
        }
        return this.accessibleContext;
    }

    private final class AccessibleFormsLabel
    extends JLabel.AccessibleJLabel {
        private AccessibleFormsLabel() {
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
}
