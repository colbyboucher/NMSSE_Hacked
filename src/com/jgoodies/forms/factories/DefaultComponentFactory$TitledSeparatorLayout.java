/*
 * Decompiled with CFR 0.152.
 */
package com.jgoodies.forms.factories;

import com.jgoodies.forms.layout.Sizes;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Insets;
import java.awt.LayoutManager;
import javax.swing.JLabel;

private static final class DefaultComponentFactory.TitledSeparatorLayout
implements LayoutManager {
    private final boolean centerSeparators;

    private DefaultComponentFactory.TitledSeparatorLayout(boolean centerSeparators) {
        this.centerSeparators = centerSeparators;
    }

    public void addLayoutComponent(String name, Component comp) {
    }

    public void removeLayoutComponent(Component comp) {
    }

    public Dimension minimumLayoutSize(Container parent) {
        return this.preferredLayoutSize(parent);
    }

    public Dimension preferredLayoutSize(Container parent) {
        JLabel label = this.getLabel(parent);
        Dimension labelSize = ((Component)label).getPreferredSize();
        Insets insets = parent.getInsets();
        int width = labelSize.width + insets.left + insets.right;
        int height = labelSize.height + insets.top + insets.bottom;
        return new Dimension(width, height);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void layoutContainer(Container parent) {
        Object object = parent.getTreeLock();
        synchronized (object) {
            Dimension size = parent.getSize();
            Insets insets = parent.getInsets();
            int width = size.width - insets.left - insets.right;
            JLabel label = this.getLabel(parent);
            Dimension labelSize = label.getPreferredSize();
            int labelWidth = labelSize.width;
            int labelHeight = labelSize.height;
            Component separator1 = parent.getComponent(1);
            int separatorHeight = separator1.getPreferredSize().height;
            FontMetrics metrics = label.getFontMetrics(label.getFont());
            int ascent = metrics.getMaxAscent();
            int hGapDlu = this.centerSeparators ? 3 : 1;
            int hGap = Sizes.dialogUnitXAsPixel(hGapDlu, label);
            int vOffset = this.centerSeparators ? 1 + (labelHeight - separatorHeight) / 2 : ascent - separatorHeight / 2;
            int alignment = label.getHorizontalAlignment();
            int y = insets.top;
            if (alignment == 2) {
                int x = insets.left;
                label.setBounds(x, y, labelWidth, labelHeight);
                x += labelWidth;
                int separatorWidth = size.width - insets.right - (x += hGap);
                separator1.setBounds(x, y + vOffset, separatorWidth, separatorHeight);
            } else if (alignment == 4) {
                int x = insets.left + width - labelWidth;
                label.setBounds(x, y, labelWidth, labelHeight);
                x -= hGap;
                int separatorWidth = --x - insets.left;
                separator1.setBounds(insets.left, y + vOffset, separatorWidth, separatorHeight);
            } else {
                int xOffset = (width - labelWidth - 2 * hGap) / 2;
                int x = insets.left;
                separator1.setBounds(x, y + vOffset, xOffset - 1, separatorHeight);
                x += xOffset;
                label.setBounds(x += hGap, y, labelWidth, labelHeight);
                x += labelWidth;
                Component separator2 = parent.getComponent(2);
                int separatorWidth = size.width - insets.right - (x += hGap);
                separator2.setBounds(x, y + vOffset, separatorWidth, separatorHeight);
            }
        }
    }

    private JLabel getLabel(Container parent) {
        return (JLabel)parent.getComponent(0);
    }
}
