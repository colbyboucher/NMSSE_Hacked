/*
 * Decompiled with CFR 0.152.
 */
package com.formdev.flatlaf.ui;

import com.formdev.flatlaf.ui.FlatArrowButton;
import com.formdev.flatlaf.ui.FlatUIUtils;
import com.formdev.flatlaf.util.UIScale;
import java.awt.Color;
import java.awt.Dimension;

protected class FlatScrollBarUI.FlatScrollBarButton
extends FlatArrowButton {
    protected FlatScrollBarUI.FlatScrollBarButton(int direction) {
        this(direction, this$0.arrowType, this$0.buttonArrowColor, this$0.buttonDisabledArrowColor, null, this$0.hoverButtonBackground, null, this$0.pressedButtonBackground);
    }

    protected FlatScrollBarUI.FlatScrollBarButton(int direction, String type, Color foreground, Color disabledForeground, Color hoverForeground, Color hoverBackground, Color pressedForeground, Color pressedBackground) {
        super(direction, type, foreground, disabledForeground, hoverForeground, hoverBackground, pressedForeground, pressedBackground);
        this.setFocusable(false);
        this.setRequestFocusEnabled(false);
    }

    protected void updateStyle() {
        this.updateStyle(FlatScrollBarUI.this.arrowType, FlatScrollBarUI.this.buttonArrowColor, FlatScrollBarUI.this.buttonDisabledArrowColor, null, FlatScrollBarUI.this.hoverButtonBackground, null, FlatScrollBarUI.this.pressedButtonBackground);
    }

    @Override
    public int getArrowWidth() {
        int arrowWidth = Math.round(6.0f * ((float)FlatScrollBarUI.this.scrollBarWidth / 10.0f));
        arrowWidth = FlatScrollBarUI.this.scrollBarWidth - (FlatScrollBarUI.this.scrollBarWidth - arrowWidth) / 2 * 2;
        return arrowWidth;
    }

    @Override
    protected Color deriveBackground(Color background) {
        return FlatUIUtils.deriveColor(background, FlatScrollBarUI.this.scrollbar.getBackground());
    }

    @Override
    public Dimension getPreferredSize() {
        if (FlatScrollBarUI.this.isShowButtons()) {
            int w = UIScale.scale(Math.max(FlatScrollBarUI.this.scrollBarWidth, FlatScrollBarUI.this.minimumButtonSize != null ? FlatScrollBarUI.this.minimumButtonSize.width : 0));
            int h = UIScale.scale(Math.max(FlatScrollBarUI.this.scrollBarWidth, FlatScrollBarUI.this.minimumButtonSize != null ? FlatScrollBarUI.this.minimumButtonSize.height : 0));
            return new Dimension(w, h);
        }
        return new Dimension();
    }

    @Override
    public Dimension getMinimumSize() {
        return FlatScrollBarUI.this.isShowButtons() ? super.getMinimumSize() : new Dimension();
    }

    @Override
    public Dimension getMaximumSize() {
        return FlatScrollBarUI.this.isShowButtons() ? super.getMaximumSize() : new Dimension();
    }
}
