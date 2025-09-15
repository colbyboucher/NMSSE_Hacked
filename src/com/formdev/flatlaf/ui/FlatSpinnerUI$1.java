/*
 * Decompiled with CFR 0.152.
 */
package com.formdev.flatlaf.ui;

import com.formdev.flatlaf.ui.FlatArrowButton;
import java.awt.Color;

class FlatSpinnerUI.1
extends FlatArrowButton {
    FlatSpinnerUI.1(int direction, String type, Color foreground, Color disabledForeground, Color hoverForeground, Color hoverBackground, Color pressedForeground, Color pressedBackground) {
        super(direction, type, foreground, disabledForeground, hoverForeground, hoverBackground, pressedForeground, pressedBackground);
    }

    @Override
    public int getArrowWidth() {
        return FlatSpinnerUI.this.isMacStyle() ? 7 : super.getArrowWidth();
    }

    @Override
    public float getArrowThickness() {
        return FlatSpinnerUI.this.isMacStyle() ? 1.5f : super.getArrowThickness();
    }

    @Override
    public float getYOffset() {
        return FlatSpinnerUI.this.isMacStyle() ? 0.0f : super.getYOffset();
    }

    @Override
    public boolean isRoundBorderAutoXOffset() {
        return FlatSpinnerUI.this.isMacStyle() ? false : super.isRoundBorderAutoXOffset();
    }
}
