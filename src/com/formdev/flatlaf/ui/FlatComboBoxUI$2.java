/*
 * Decompiled with CFR 0.152.
 */
package com.formdev.flatlaf.ui;

import com.formdev.flatlaf.ui.FlatComboBoxUI;
import com.formdev.flatlaf.util.UIScale;
import java.awt.Container;
import java.awt.FontMetrics;
import java.awt.Insets;
import javax.swing.plaf.basic.BasicComboBoxUI;

class FlatComboBoxUI.2
extends BasicComboBoxUI.ComboBoxLayoutManager {
    FlatComboBoxUI.2() {
        super(FlatComboBoxUI.this);
    }

    @Override
    public void layoutContainer(Container parent) {
        super.layoutContainer(parent);
        if (FlatComboBoxUI.this.arrowButton != null && FlatComboBoxUI.this.comboBox.getFont() != null) {
            FontMetrics fm = FlatComboBoxUI.this.comboBox.getFontMetrics(FlatComboBoxUI.this.comboBox.getFont());
            int maxButtonWidth = fm.getHeight() + UIScale.scale(((FlatComboBoxUI)FlatComboBoxUI.this).padding.top) + UIScale.scale(((FlatComboBoxUI)FlatComboBoxUI.this).padding.bottom);
            int minButtonWidth = maxButtonWidth * 3 / 4;
            Insets insets = FlatComboBoxUI.this.getInsets();
            int buttonWidth = Math.min(Math.max(parent.getHeight() - insets.top - insets.bottom, minButtonWidth), maxButtonWidth);
            if (buttonWidth != FlatComboBoxUI.this.arrowButton.getWidth()) {
                int xOffset = FlatComboBoxUI.this.comboBox.getComponentOrientation().isLeftToRight() ? FlatComboBoxUI.this.arrowButton.getWidth() - buttonWidth : 0;
                FlatComboBoxUI.this.arrowButton.setBounds(FlatComboBoxUI.this.arrowButton.getX() + xOffset, FlatComboBoxUI.this.arrowButton.getY(), buttonWidth, FlatComboBoxUI.this.arrowButton.getHeight());
                if (FlatComboBoxUI.this.editor != null) {
                    FlatComboBoxUI.this.editor.setBounds(FlatComboBoxUI.this.rectangleForCurrentValue());
                }
            }
        }
    }
}
