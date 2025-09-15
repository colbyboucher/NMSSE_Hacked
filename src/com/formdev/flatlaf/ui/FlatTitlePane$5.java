/*
 * Decompiled with CFR 0.152.
 */
package com.formdev.flatlaf.ui;

import com.formdev.flatlaf.util.UIScale;
import java.awt.Dimension;
import javax.swing.Icon;
import javax.swing.JButton;

class FlatTitlePane.5
extends JButton {
    FlatTitlePane.5(Icon arg0) {
        super(arg0);
    }

    @Override
    public Dimension getMinimumSize() {
        return new Dimension(UIScale.scale(FlatTitlePane.this.buttonMinimumWidth), super.getMinimumSize().height);
    }
}
