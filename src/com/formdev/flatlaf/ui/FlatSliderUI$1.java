/*
 * Decompiled with CFR 0.152.
 */
package com.formdev.flatlaf.ui;

import com.formdev.flatlaf.util.Graphics2DProxy;
import java.awt.Color;
import java.awt.Graphics2D;

class FlatSliderUI.1
extends Graphics2DProxy {
    FlatSliderUI.1(Graphics2D delegate) {
        super(delegate);
    }

    @Override
    public void setColor(Color c) {
        super.setColor(FlatSliderUI.this.tickColor);
    }
}
