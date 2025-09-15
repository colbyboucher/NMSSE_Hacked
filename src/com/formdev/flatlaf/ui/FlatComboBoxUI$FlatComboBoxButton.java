/*
 * Decompiled with CFR 0.152.
 */
package com.formdev.flatlaf.ui;

import com.formdev.flatlaf.ui.FlatArrowButton;
import com.formdev.flatlaf.ui.FlatUIUtils;
import java.awt.Color;
import java.awt.Graphics2D;

protected class FlatComboBoxUI.FlatComboBoxButton
extends FlatArrowButton {
    protected FlatComboBoxUI.FlatComboBoxButton() {
        this(5, this$0.arrowType, this$0.buttonArrowColor, this$0.buttonDisabledArrowColor, this$0.buttonHoverArrowColor, null, this$0.buttonPressedArrowColor, null);
    }

    protected FlatComboBoxUI.FlatComboBoxButton(int direction, String type, Color foreground, Color disabledForeground, Color hoverForeground, Color hoverBackground, Color pressedForeground, Color pressedBackground) {
        super(direction, type, foreground, disabledForeground, hoverForeground, hoverBackground, pressedForeground, pressedBackground);
    }

    protected void updateStyle() {
        this.updateStyle(FlatComboBoxUI.this.arrowType, FlatComboBoxUI.this.buttonArrowColor, FlatComboBoxUI.this.buttonDisabledArrowColor, FlatComboBoxUI.this.buttonHoverArrowColor, null, FlatComboBoxUI.this.buttonPressedArrowColor, null);
    }

    @Override
    public int getArrowWidth() {
        return FlatComboBoxUI.this.isMacStyle() ? (this.getWidth() % 2 == 0 ? 6 : 7) : super.getArrowWidth();
    }

    @Override
    public float getArrowThickness() {
        return FlatComboBoxUI.this.isMacStyle() ? 1.5f : super.getArrowThickness();
    }

    @Override
    public boolean isRoundBorderAutoXOffset() {
        return FlatComboBoxUI.this.isMacStyle() ? false : super.isRoundBorderAutoXOffset();
    }

    @Override
    protected boolean isHover() {
        return super.isHover() || !FlatComboBoxUI.this.comboBox.isEditable() && FlatComboBoxUI.this.hover;
    }

    @Override
    protected boolean isPressed() {
        return super.isPressed() || !FlatComboBoxUI.this.comboBox.isEditable() && FlatComboBoxUI.this.pressed;
    }

    @Override
    protected Color getArrowColor() {
        if (FlatComboBoxUI.this.isCellRenderer() && FlatComboBoxUI.this.isCellRendererBackgroundChanged()) {
            return FlatComboBoxUI.this.comboBox.getForeground();
        }
        return super.getArrowColor();
    }

    @Override
    protected void paintArrow(Graphics2D g) {
        if (FlatComboBoxUI.this.isMacStyle() && !FlatComboBoxUI.this.comboBox.isEditable()) {
            int height = this.getHeight();
            int h = Math.round((float)height / 2.0f);
            FlatUIUtils.paintArrow(g, 0, 0, this.getWidth(), h, 1, this.chevron, this.getArrowWidth(), this.getArrowThickness(), this.getXOffset(), this.getYOffset() + 1.25f);
            FlatUIUtils.paintArrow(g, 0, height - h, this.getWidth(), h, 5, this.chevron, this.getArrowWidth(), this.getArrowThickness(), this.getXOffset(), this.getYOffset() - 1.25f);
        } else {
            super.paintArrow(g);
        }
    }
}
