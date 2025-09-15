/*
 * Decompiled with CFR 0.152.
 */
package com.formdev.flatlaf.ui;

import com.formdev.flatlaf.util.Graphics2DProxy;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

class FlatListUI.1RoundedSelectionGraphics
extends Graphics2DProxy {
    private boolean inPaintSelection;
    final /* synthetic */ Rectangle val$rowBounds;
    final /* synthetic */ Component val$rendererComponent;
    final /* synthetic */ int val$row;

    FlatListUI.1RoundedSelectionGraphics(Graphics delegate) {
        this.val$rowBounds = rectangle;
        this.val$rendererComponent = component;
        this.val$row = n;
        super((Graphics2D)delegate);
    }

    @Override
    public Graphics create() {
        return new FlatListUI.1RoundedSelectionGraphics(super.create());
    }

    @Override
    public Graphics create(int x, int y, int width, int height) {
        return new FlatListUI.1RoundedSelectionGraphics(super.create(x, y, width, height));
    }

    @Override
    public void fillRect(int x, int y, int width, int height) {
        if (!this.inPaintSelection && x == 0 && y == 0 && width == this.val$rowBounds.width && height == this.val$rowBounds.height && this.getColor() == this.val$rendererComponent.getBackground()) {
            this.inPaintSelection = true;
            FlatListUI.this.paintCellSelection(this, this.val$row, x, y, width, height);
            this.inPaintSelection = false;
        } else {
            super.fillRect(x, y, width, height);
        }
    }
}
