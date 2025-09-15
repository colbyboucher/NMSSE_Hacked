/*
 * Decompiled with CFR 0.152.
 */
package com.formdev.flatlaf.ui;

import com.formdev.flatlaf.ui.FlatMenuBarUI;
import com.formdev.flatlaf.ui.FlatMenuItemRenderer;
import com.formdev.flatlaf.ui.FlatRootPaneUI;
import com.formdev.flatlaf.ui.FlatUIUtils;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.Window;
import java.util.function.Function;
import javax.swing.ButtonModel;
import javax.swing.Icon;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JRootPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.plaf.MenuBarUI;

protected class FlatMenuUI.FlatMenuRenderer
extends FlatMenuItemRenderer {
    protected Insets menuBarSelectionInsets;
    protected Insets menuBarSelectionEmbeddedInsets;
    protected int menuBarSelectionArc;
    protected Color hoverBackground;
    protected Color menuBarSelectionBackground;
    protected Color menuBarSelectionForeground;
    protected Color menuBarUnderlineSelectionBackground;
    protected Color menuBarUnderlineSelectionColor;
    protected int menuBarUnderlineSelectionHeight;

    protected FlatMenuUI.FlatMenuRenderer(JMenuItem menuItem, Icon checkIcon, Icon arrowIcon, Font acceleratorFont, String acceleratorDelimiter) {
        super(menuItem, checkIcon, arrowIcon, acceleratorFont, acceleratorDelimiter);
        this.menuBarSelectionInsets = UIManager.getInsets("MenuBar.selectionInsets");
        this.menuBarSelectionEmbeddedInsets = UIManager.getInsets("MenuBar.selectionEmbeddedInsets");
        this.menuBarSelectionArc = UIManager.getInt("MenuBar.selectionArc");
        this.hoverBackground = UIManager.getColor("MenuBar.hoverBackground");
        this.menuBarSelectionBackground = UIManager.getColor("MenuBar.selectionBackground");
        this.menuBarSelectionForeground = UIManager.getColor("MenuBar.selectionForeground");
        this.menuBarUnderlineSelectionBackground = UIManager.getColor("MenuBar.underlineSelectionBackground");
        this.menuBarUnderlineSelectionColor = UIManager.getColor("MenuBar.underlineSelectionColor");
        this.menuBarUnderlineSelectionHeight = FlatUIUtils.getUIInt("MenuBar.underlineSelectionHeight", -1);
    }

    @Override
    protected void paintBackground(Graphics g) {
        super.paintBackground(g);
        if (((JMenu)this.menuItem).isTopLevelMenu() && this.isHover()) {
            Color color = this.deriveBackground(this.getStyleFromMenuBarUI(ui -> ui.hoverBackground, this.hoverBackground));
            if (this.isUnderlineSelection()) {
                g.setColor(color);
                g.fillRect(0, 0, this.menuItem.getWidth(), this.menuItem.getHeight());
            } else {
                this.paintSelection(g, color, this.selectionInsets, this.selectionArc);
            }
        }
    }

    @Override
    protected void paintSelection(Graphics g, Color selectionBackground, Insets selectionInsets, int selectionArc) {
        if (((JMenu)this.menuItem).isTopLevelMenu()) {
            JMenuBar menuBar;
            JRootPane rootPane;
            if (!this.isHover()) {
                selectionBackground = this.getStyleFromMenuBarUI(ui -> ui.selectionBackground, this.menuBarSelectionBackground, selectionBackground);
            }
            selectionInsets = (rootPane = SwingUtilities.getRootPane(menuBar = (JMenuBar)this.menuItem.getParent())) != null && rootPane.getParent() instanceof Window && rootPane.getJMenuBar() == menuBar && FlatRootPaneUI.isMenuBarEmbedded(rootPane) ? this.getStyleFromMenuBarUI(ui -> ui.selectionEmbeddedInsets, this.menuBarSelectionEmbeddedInsets) : this.getStyleFromMenuBarUI(ui -> ui.selectionInsets, this.menuBarSelectionInsets);
            selectionArc = this.getStyleFromMenuBarUI(ui -> ui.selectionArc != -1 ? Integer.valueOf(ui.selectionArc) : null, this.menuBarSelectionArc);
        }
        super.paintSelection(g, selectionBackground, selectionInsets, selectionArc);
    }

    @Override
    protected void paintUnderlineSelection(Graphics g, Color underlineSelectionBackground, Color underlineSelectionColor, int underlineSelectionHeight) {
        if (((JMenu)this.menuItem).isTopLevelMenu()) {
            underlineSelectionBackground = this.getStyleFromMenuBarUI(ui -> ui.underlineSelectionBackground, this.menuBarUnderlineSelectionBackground, underlineSelectionBackground);
            underlineSelectionColor = this.getStyleFromMenuBarUI(ui -> ui.underlineSelectionColor, this.menuBarUnderlineSelectionColor, underlineSelectionColor);
            underlineSelectionHeight = this.getStyleFromMenuBarUI(ui -> ui.underlineSelectionHeight != -1 ? Integer.valueOf(ui.underlineSelectionHeight) : null, this.menuBarUnderlineSelectionHeight != -1 ? this.menuBarUnderlineSelectionHeight : underlineSelectionHeight);
        }
        super.paintUnderlineSelection(g, underlineSelectionBackground, underlineSelectionColor, underlineSelectionHeight);
    }

    @Override
    protected void paintText(Graphics g, Rectangle textRect, String text, Color selectionForeground, Color disabledForeground) {
        if (((JMenu)this.menuItem).isTopLevelMenu() && !this.isUnderlineSelection()) {
            selectionForeground = this.getStyleFromMenuBarUI(ui -> ui.selectionForeground, this.menuBarSelectionForeground, selectionForeground);
        }
        super.paintText(g, textRect, text, selectionForeground, disabledForeground);
    }

    private boolean isHover() {
        ButtonModel model = this.menuItem.getModel();
        return model.isRollover() && !model.isArmed() && !model.isSelected() && model.isEnabled();
    }

    private <T> T getStyleFromMenuBarUI(Function<FlatMenuBarUI, T> f, T defaultValue, T defaultValue2) {
        return this.getStyleFromMenuBarUI(f, defaultValue != null ? defaultValue : defaultValue2);
    }

    private <T> T getStyleFromMenuBarUI(Function<FlatMenuBarUI, T> f, T defaultValue) {
        MenuBarUI ui = ((JMenuBar)this.menuItem.getParent()).getUI();
        if (!(ui instanceof FlatMenuBarUI)) {
            return defaultValue;
        }
        T value = f.apply((FlatMenuBarUI)ui);
        return value != null ? value : defaultValue;
    }
}
