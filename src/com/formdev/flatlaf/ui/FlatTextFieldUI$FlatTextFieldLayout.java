/*
 * Decompiled with CFR 0.152.
 */
package com.formdev.flatlaf.ui;

import com.formdev.flatlaf.ui.FlatUIUtils;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.LayoutManager;
import java.awt.LayoutManager2;
import javax.swing.JComponent;
import javax.swing.plaf.UIResource;

private class FlatTextFieldUI.FlatTextFieldLayout
implements LayoutManager2,
UIResource {
    private final LayoutManager delegate;

    FlatTextFieldUI.FlatTextFieldLayout(LayoutManager delegate) {
        this.delegate = delegate;
    }

    @Override
    public void addLayoutComponent(String name, Component comp) {
        if (this.delegate != null) {
            this.delegate.addLayoutComponent(name, comp);
        }
    }

    @Override
    public void removeLayoutComponent(Component comp) {
        if (this.delegate != null) {
            this.delegate.removeLayoutComponent(comp);
        }
    }

    @Override
    public Dimension preferredLayoutSize(Container parent) {
        return this.delegate != null ? this.delegate.preferredLayoutSize(parent) : null;
    }

    @Override
    public Dimension minimumLayoutSize(Container parent) {
        return this.delegate != null ? this.delegate.minimumLayoutSize(parent) : null;
    }

    @Override
    public void layoutContainer(Container parent) {
        int cw;
        if (this.delegate != null) {
            this.delegate.layoutContainer(parent);
        }
        int ow = FlatUIUtils.getBorderFocusAndLineWidth(FlatTextFieldUI.this.getComponent());
        int h = parent.getHeight() - ow - ow;
        boolean ltr = FlatTextFieldUI.this.isLeftToRight();
        JComponent[] leftComponents = ltr ? FlatTextFieldUI.this.getLeadingComponents() : FlatTextFieldUI.this.getTrailingComponents();
        JComponent[] rightComponents = ltr ? FlatTextFieldUI.this.getTrailingComponents() : FlatTextFieldUI.this.getLeadingComponents();
        int x = ow;
        for (JComponent leftComponent : leftComponents) {
            if (leftComponent == null || !leftComponent.isVisible()) continue;
            cw = leftComponent.getPreferredSize().width;
            leftComponent.setBounds(x, ow, cw, h);
            x += cw;
        }
        x = parent.getWidth() - ow;
        for (JComponent rightComponent : rightComponents) {
            if (rightComponent == null || !rightComponent.isVisible()) continue;
            cw = rightComponent.getPreferredSize().width;
            rightComponent.setBounds(x -= cw, ow, cw, h);
        }
    }

    @Override
    public void addLayoutComponent(Component comp, Object constraints) {
        if (this.delegate instanceof LayoutManager2) {
            ((LayoutManager2)this.delegate).addLayoutComponent(comp, constraints);
        }
    }

    @Override
    public Dimension maximumLayoutSize(Container target) {
        return this.delegate instanceof LayoutManager2 ? ((LayoutManager2)this.delegate).maximumLayoutSize(target) : null;
    }

    @Override
    public float getLayoutAlignmentX(Container target) {
        return this.delegate instanceof LayoutManager2 ? ((LayoutManager2)this.delegate).getLayoutAlignmentX(target) : 0.5f;
    }

    @Override
    public float getLayoutAlignmentY(Container target) {
        return this.delegate instanceof LayoutManager2 ? ((LayoutManager2)this.delegate).getLayoutAlignmentY(target) : 0.5f;
    }

    @Override
    public void invalidateLayout(Container target) {
        if (this.delegate instanceof LayoutManager2) {
            ((LayoutManager2)this.delegate).invalidateLayout(target);
        }
    }
}
