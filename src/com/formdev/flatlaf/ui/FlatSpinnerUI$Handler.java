/*
 * Decompiled with CFR 0.152.
 */
package com.formdev.flatlaf.ui;

import com.formdev.flatlaf.ui.FlatSpinnerUI;
import com.formdev.flatlaf.ui.FlatUIUtils;
import com.formdev.flatlaf.util.UIScale;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Insets;
import java.awt.LayoutManager;
import java.awt.Rectangle;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.JTextField;

private class FlatSpinnerUI.Handler
implements LayoutManager,
FocusListener,
PropertyChangeListener {
    private Component editor = null;
    private Component nextButton;
    private Component previousButton;

    private FlatSpinnerUI.Handler() {
    }

    @Override
    public void addLayoutComponent(String name, Component c) {
        switch (name) {
            case "Editor": {
                this.editor = c;
                break;
            }
            case "Next": {
                this.nextButton = c;
                break;
            }
            case "Previous": {
                this.previousButton = c;
            }
        }
    }

    @Override
    public void removeLayoutComponent(Component c) {
        if (c == this.editor) {
            this.editor = null;
        } else if (c == this.nextButton) {
            this.nextButton = null;
        } else if (c == this.previousButton) {
            this.previousButton = null;
        }
    }

    @Override
    public Dimension preferredLayoutSize(Container parent) {
        Insets insets = parent.getInsets();
        Insets padding = UIScale.scale(FlatSpinnerUI.this.padding);
        Dimension editorSize = this.editor != null ? this.editor.getPreferredSize() : new Dimension(0, 0);
        int minimumWidth = FlatUIUtils.minimumWidth(FlatSpinnerUI.this.spinner, FlatSpinnerUI.this.minimumWidth);
        int innerHeight = editorSize.height + padding.top + padding.bottom;
        float focusWidth = FlatUIUtils.getBorderFocusWidth(FlatSpinnerUI.this.spinner);
        return new Dimension(Math.max(insets.left + insets.right + editorSize.width + padding.left + padding.right + innerHeight, UIScale.scale(minimumWidth) + Math.round(focusWidth * 2.0f)), insets.top + insets.bottom + innerHeight);
    }

    @Override
    public Dimension minimumLayoutSize(Container parent) {
        return this.preferredLayoutSize(parent);
    }

    @Override
    public void layoutContainer(Container parent) {
        int lineWidth;
        int buttonsWidth;
        Dimension size = parent.getSize();
        Insets insets = parent.getInsets();
        Rectangle r = FlatUIUtils.subtractInsets(new Rectangle(size), insets);
        if (this.nextButton == null && this.previousButton == null) {
            if (this.editor != null) {
                this.editor.setBounds(r);
            }
            return;
        }
        Rectangle editorRect = new Rectangle(r);
        Rectangle buttonsRect = new Rectangle(r);
        FontMetrics fm = FlatSpinnerUI.this.spinner.getFontMetrics(FlatSpinnerUI.this.spinner.getFont());
        int maxButtonWidth = fm.getHeight() + UIScale.scale(FlatSpinnerUI.this.padding.top) + UIScale.scale(FlatSpinnerUI.this.padding.bottom);
        int minButtonWidth = maxButtonWidth * 3 / 4;
        boolean isMacStyle = FlatSpinnerUI.this.isMacStyle();
        int buttonsGap = isMacStyle ? UIScale.scale(3) : 0;
        int prefButtonWidth = isMacStyle ? UIScale.scale(15) : buttonsRect.height;
        buttonsRect.width = buttonsWidth = Math.min(Math.max(prefButtonWidth, minButtonWidth), maxButtonWidth);
        editorRect.width -= buttonsWidth + buttonsGap;
        boolean ltr = parent.getComponentOrientation().isLeftToRight();
        if (ltr) {
            buttonsRect.x += editorRect.width + buttonsGap;
        } else {
            editorRect.x += buttonsWidth + buttonsGap;
        }
        if (isMacStyle && (lineWidth = Math.round(FlatUIUtils.getBorderLineWidth(FlatSpinnerUI.this.spinner))) > 0) {
            buttonsRect.x = buttonsRect.x + (ltr ? lineWidth : -lineWidth);
            buttonsRect.y -= lineWidth;
            buttonsRect.height += lineWidth * 2;
        }
        if (this.editor != null) {
            this.editor.setBounds(editorRect);
        }
        int nextHeight = buttonsRect.height / 2 + buttonsRect.height % 2;
        if (this.nextButton != null) {
            this.nextButton.setBounds(buttonsRect.x, buttonsRect.y, buttonsRect.width, nextHeight);
        }
        if (this.previousButton != null) {
            int previousY = buttonsRect.y + buttonsRect.height - nextHeight;
            this.previousButton.setBounds(buttonsRect.x, previousY, buttonsRect.width, nextHeight);
        }
    }

    @Override
    public void focusGained(FocusEvent e) {
        JTextField textField;
        FlatSpinnerUI.this.spinner.repaint();
        if (e.getComponent() == FlatSpinnerUI.this.spinner && (textField = FlatSpinnerUI.getEditorTextField(FlatSpinnerUI.this.spinner.getEditor())) != null) {
            textField.requestFocusInWindow();
        }
    }

    @Override
    public void focusLost(FocusEvent e) {
        FlatSpinnerUI.this.spinner.repaint();
    }

    @Override
    public void propertyChange(PropertyChangeEvent e) {
        switch (e.getPropertyName()) {
            case "foreground": 
            case "enabled": {
                FlatSpinnerUI.this.updateEditorColors();
                break;
            }
            case "JComponent.roundRect": 
            case "JComponent.outline": {
                FlatSpinnerUI.this.spinner.repaint();
                break;
            }
            case "JComponent.minimumWidth": {
                FlatSpinnerUI.this.spinner.revalidate();
                break;
            }
            case "FlatLaf.style": 
            case "FlatLaf.styleClass": {
                FlatSpinnerUI.this.installStyle();
                FlatSpinnerUI.this.spinner.revalidate();
                FlatSpinnerUI.this.spinner.repaint();
            }
        }
    }

    static /* synthetic */ Component access$100(FlatSpinnerUI.Handler x0) {
        return x0.nextButton;
    }

    static /* synthetic */ Component access$200(FlatSpinnerUI.Handler x0) {
        return x0.previousButton;
    }
}
