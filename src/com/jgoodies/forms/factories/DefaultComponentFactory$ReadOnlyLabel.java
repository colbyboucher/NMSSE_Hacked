/*
 * Decompiled with CFR 0.152.
 */
package com.jgoodies.forms.factories;

import com.jgoodies.forms.factories.DefaultComponentFactory;
import java.awt.Color;
import javax.swing.UIManager;

private static final class DefaultComponentFactory.ReadOnlyLabel
extends DefaultComponentFactory.FormsLabel {
    private static final String[] UIMANAGER_KEYS = new String[]{"Label.disabledForeground", "Label.disabledText", "Label[Disabled].textForeground", "textInactiveText"};

    private DefaultComponentFactory.ReadOnlyLabel() {
        super((DefaultComponentFactory.1)null);
    }

    public void updateUI() {
        super.updateUI();
        this.setForeground(this.getDisabledForeground());
    }

    private Color getDisabledForeground() {
        for (int i = 0; i < UIMANAGER_KEYS.length; ++i) {
            String key = UIMANAGER_KEYS[i];
            Color foreground = UIManager.getColor(key);
            if (foreground == null) continue;
            return foreground;
        }
        return null;
    }
}
