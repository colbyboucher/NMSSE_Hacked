/*
 * Decompiled with CFR 0.152.
 */
package com.jgoodies.forms.factories;

import com.jgoodies.forms.factories.DefaultComponentFactory;
import com.jgoodies.forms.util.FormUtils;
import java.awt.Color;
import java.awt.Font;
import javax.swing.UIManager;

private static final class DefaultComponentFactory.TitleLabel
extends DefaultComponentFactory.FormsLabel {
    private DefaultComponentFactory.TitleLabel() {
        super((DefaultComponentFactory.1)null);
    }

    public void updateUI() {
        super.updateUI();
        Color foreground = this.getTitleColor();
        if (foreground != null) {
            this.setForeground(foreground);
        }
        this.setFont(this.getTitleFont());
    }

    private Color getTitleColor() {
        return UIManager.getColor("TitledBorder.titleColor");
    }

    private Font getTitleFont() {
        return FormUtils.isLafAqua() ? UIManager.getFont("Label.font").deriveFont(1) : UIManager.getFont("TitledBorder.font");
    }
}
