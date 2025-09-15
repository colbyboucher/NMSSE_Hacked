/*
 * Decompiled with CFR 0.152.
 */
package com.formdev.flatlaf.ui;

import com.formdev.flatlaf.ui.FlatDropShadowBorder;
import com.formdev.flatlaf.ui.FlatEmptyBorder;
import com.formdev.flatlaf.ui.FlatStylingSupport;
import com.formdev.flatlaf.ui.FlatUIUtils;
import com.formdev.flatlaf.util.UIScale;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.util.Map;
import javax.swing.JInternalFrame;
import javax.swing.UIManager;

public static class FlatInternalFrameUI.FlatInternalFrameBorder
extends FlatEmptyBorder
implements FlatStylingSupport.StyleableBorder {
    @FlatStylingSupport.Styleable
    protected Color activeBorderColor = UIManager.getColor("InternalFrame.activeBorderColor");
    @FlatStylingSupport.Styleable
    protected Color inactiveBorderColor = UIManager.getColor("InternalFrame.inactiveBorderColor");
    @FlatStylingSupport.Styleable
    protected int borderLineWidth = FlatUIUtils.getUIInt("InternalFrame.borderLineWidth", 1);
    @FlatStylingSupport.Styleable
    protected boolean dropShadowPainted = UIManager.getBoolean("InternalFrame.dropShadowPainted");
    private final FlatDropShadowBorder activeDropShadowBorder = new FlatDropShadowBorder(UIManager.getColor("InternalFrame.activeDropShadowColor"), UIManager.getInsets("InternalFrame.activeDropShadowInsets"), FlatUIUtils.getUIFloat("InternalFrame.activeDropShadowOpacity", 0.5f));
    private final FlatDropShadowBorder inactiveDropShadowBorder = new FlatDropShadowBorder(UIManager.getColor("InternalFrame.inactiveDropShadowColor"), UIManager.getInsets("InternalFrame.inactiveDropShadowInsets"), FlatUIUtils.getUIFloat("InternalFrame.inactiveDropShadowOpacity", 0.5f));

    public FlatInternalFrameUI.FlatInternalFrameBorder() {
        super(UIManager.getInsets("InternalFrame.borderMargins"));
    }

    @Override
    public Object applyStyleProperty(String key, Object value) {
        switch (key) {
            case "borderMargins": {
                return this.applyStyleProperty((Insets)value);
            }
            case "activeDropShadowColor": {
                return this.activeDropShadowBorder.applyStyleProperty("shadowColor", value);
            }
            case "activeDropShadowInsets": {
                return this.activeDropShadowBorder.applyStyleProperty("shadowInsets", value);
            }
            case "activeDropShadowOpacity": {
                return this.activeDropShadowBorder.applyStyleProperty("shadowOpacity", value);
            }
            case "inactiveDropShadowColor": {
                return this.inactiveDropShadowBorder.applyStyleProperty("shadowColor", value);
            }
            case "inactiveDropShadowInsets": {
                return this.inactiveDropShadowBorder.applyStyleProperty("shadowInsets", value);
            }
            case "inactiveDropShadowOpacity": {
                return this.inactiveDropShadowBorder.applyStyleProperty("shadowOpacity", value);
            }
        }
        return FlatStylingSupport.applyToAnnotatedObject(this, key, value);
    }

    @Override
    public Map<String, Class<?>> getStyleableInfos() {
        FlatStylingSupport.StyleableInfosMap infos = new FlatStylingSupport.StyleableInfosMap();
        FlatStylingSupport.collectAnnotatedStyleableInfos(this, infos);
        infos.put("borderMargins", Insets.class);
        infos.put("activeDropShadowColor", Color.class);
        infos.put("activeDropShadowInsets", Insets.class);
        infos.put("activeDropShadowOpacity", Float.TYPE);
        infos.put("inactiveDropShadowColor", Color.class);
        infos.put("inactiveDropShadowInsets", Insets.class);
        infos.put("inactiveDropShadowOpacity", Float.TYPE);
        return infos;
    }

    @Override
    public Object getStyleableValue(String key) {
        switch (key) {
            case "borderMargins": {
                return this.getStyleableValue();
            }
            case "activeDropShadowColor": {
                return this.activeDropShadowBorder.getStyleableValue("shadowColor");
            }
            case "activeDropShadowInsets": {
                return this.activeDropShadowBorder.getStyleableValue("shadowInsets");
            }
            case "activeDropShadowOpacity": {
                return this.activeDropShadowBorder.getStyleableValue("shadowOpacity");
            }
            case "inactiveDropShadowColor": {
                return this.inactiveDropShadowBorder.getStyleableValue("shadowColor");
            }
            case "inactiveDropShadowInsets": {
                return this.inactiveDropShadowBorder.getStyleableValue("shadowInsets");
            }
            case "inactiveDropShadowOpacity": {
                return this.inactiveDropShadowBorder.getStyleableValue("shadowOpacity");
            }
        }
        return FlatStylingSupport.getAnnotatedStyleableValue(this, key);
    }

    @Override
    public Insets getBorderInsets(Component c, Insets insets) {
        if (c instanceof JInternalFrame && ((JInternalFrame)c).isMaximum()) {
            insets.left = UIScale.scale(Math.min(this.borderLineWidth, this.left));
            insets.top = UIScale.scale(Math.min(this.borderLineWidth, this.top));
            insets.right = UIScale.scale(Math.min(this.borderLineWidth, this.right));
            insets.bottom = UIScale.scale(Math.min(this.borderLineWidth, this.bottom));
            return insets;
        }
        return super.getBorderInsets(c, insets);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        JInternalFrame f = (JInternalFrame)c;
        Insets insets = this.getBorderInsets(c);
        float lineWidth = UIScale.scale((float)this.borderLineWidth);
        float rx = (float)(x + insets.left) - lineWidth;
        float ry = (float)(y + insets.top) - lineWidth;
        float rwidth = (float)(width - insets.left - insets.right) + lineWidth * 2.0f;
        float rheight = (float)(height - insets.top - insets.bottom) + lineWidth * 2.0f;
        Graphics2D g2 = (Graphics2D)g.create();
        try {
            FlatUIUtils.setRenderingHints(g2);
            g2.setColor(f.isSelected() ? this.activeBorderColor : this.inactiveBorderColor);
            if (this.dropShadowPainted) {
                FlatDropShadowBorder dropShadowBorder = f.isSelected() ? this.activeDropShadowBorder : this.inactiveDropShadowBorder;
                Insets dropShadowInsets = dropShadowBorder.getBorderInsets();
                dropShadowBorder.paintBorder(c, g2, (int)rx - dropShadowInsets.left, (int)ry - dropShadowInsets.top, (int)rwidth + dropShadowInsets.left + dropShadowInsets.right, (int)rheight + dropShadowInsets.top + dropShadowInsets.bottom);
            }
            g2.fill(FlatUIUtils.createRectangle(rx, ry, rwidth, rheight, lineWidth));
        }
        finally {
            g2.dispose();
        }
    }
}
