/*
 * Decompiled with CFR 0.152.
 */
package com.formdev.flatlaf.ui;

import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.ui.FlatComboBoxUI;
import com.formdev.flatlaf.ui.FlatEmptyBorder;
import com.formdev.flatlaf.ui.FlatListUI;
import com.formdev.flatlaf.ui.FlatUIUtils;
import com.formdev.flatlaf.util.SystemInfo;
import com.formdev.flatlaf.util.UIScale;
import java.awt.Component;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GraphicsConfiguration;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.beans.PropertyChangeListener;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JList;
import javax.swing.JScrollBar;
import javax.swing.ListCellRenderer;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.plaf.basic.BasicComboPopup;

protected class FlatComboBoxUI.FlatComboPopup
extends BasicComboPopup {
    protected FlatComboBoxUI.FlatComboPopup(JComboBox combo) {
        super(combo);
        ComponentOrientation o = this.comboBox.getComponentOrientation();
        this.list.setComponentOrientation(o);
        this.scroller.setComponentOrientation(o);
        this.setComponentOrientation(o);
    }

    @Override
    protected Rectangle computePopupBounds(int px, int py, int pw, int ph) {
        Rectangle cellBounds;
        JScrollBar verticalScrollBar;
        int displayWidth = FlatComboBoxUI.this.getDisplaySize().width;
        for (Border border : new Border[]{this.scroller.getViewportBorder(), this.scroller.getBorder()}) {
            if (border == null) continue;
            Insets borderInsets = border.getBorderInsets(null);
            displayWidth += borderInsets.left + borderInsets.right;
        }
        boolean isPopupOverComboBox = this.isPopupOverComboBox();
        int selectedIndex = -1;
        if (isPopupOverComboBox && (selectedIndex = this.comboBox.getSelectedIndex()) >= 0) {
            displayWidth += FlatComboBoxUI.MacCheckedItemIcon.INSTANCE.getIconWidth() + UIScale.scale(4);
        }
        if ((verticalScrollBar = this.scroller.getVerticalScrollBar()) != null) {
            displayWidth += verticalScrollBar.getPreferredSize().width;
        }
        int pw0 = pw;
        if (displayWidth > pw) {
            GraphicsConfiguration gc = this.comboBox.getGraphicsConfiguration();
            if (gc != null) {
                Rectangle screenBounds = gc.getBounds();
                Insets screenInsets = Toolkit.getDefaultToolkit().getScreenInsets(gc);
                displayWidth = Math.min(displayWidth, screenBounds.width - screenInsets.left - screenInsets.right);
            } else {
                Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
                displayWidth = Math.min(displayWidth, screenSize.width);
            }
            int diff = displayWidth - pw;
            pw = displayWidth;
            if (!this.comboBox.getComponentOrientation().isLeftToRight()) {
                px -= diff;
            }
        }
        if (isPopupOverComboBox && selectedIndex >= 0 && (cellBounds = this.list.getCellBounds(0, 0)) != null) {
            Insets comboBoxInsets = this.comboBox.getInsets();
            Insets listInsets = this.list.getInsets();
            Insets popupInsets = this.getInsets();
            int offset = Math.min(pw - pw0, FlatComboBoxUI.MacCheckedItemIcon.INSTANCE.getIconWidth()) + UIScale.scale(4);
            px = this.comboBox.getComponentOrientation().isLeftToRight() ? (px -= offset + comboBoxInsets.right + listInsets.right) : (px += offset + comboBoxInsets.left + listInsets.left);
            return new Rectangle(px, py -= cellBounds.height * (selectedIndex + 1) + comboBoxInsets.top + listInsets.top + popupInsets.top, pw, ph);
        }
        return super.computePopupBounds(px, py, pw, ph);
    }

    @Override
    protected void configurePopup() {
        super.configurePopup();
        this.setOpaque(true);
        Border border = UIManager.getBorder("PopupMenu.border");
        if (border != null) {
            this.setBorder(FlatUIUtils.nonUIResource(border));
        }
        this.list.setCellRenderer(new PopupListCellRenderer());
        this.updateStyle();
    }

    void updateStyle() {
        if (FlatComboBoxUI.this.popupBackground != null) {
            this.list.setBackground(FlatComboBoxUI.this.popupBackground);
        }
        this.setBackground(FlatUIUtils.nonUIResource(this.list.getBackground()));
        this.scroller.setViewportBorder(FlatComboBoxUI.this.popupInsets != null ? new FlatEmptyBorder(FlatComboBoxUI.this.popupInsets) : null);
        this.scroller.setOpaque(false);
        if (this.list.getUI() instanceof FlatListUI) {
            FlatListUI ui = (FlatListUI)this.list.getUI();
            ui.selectionInsets = FlatComboBoxUI.this.selectionInsets;
            ui.selectionArc = FlatComboBoxUI.this.selectionArc;
        }
    }

    @Override
    protected PropertyChangeListener createPropertyChangeListener() {
        PropertyChangeListener superListener = super.createPropertyChangeListener();
        return e -> {
            superListener.propertyChange(e);
            if (e.getPropertyName() == "renderer") {
                this.list.setCellRenderer(new PopupListCellRenderer());
            }
        };
    }

    @Override
    protected int getPopupHeightForRowCount(int maxRowCount) {
        int height = super.getPopupHeightForRowCount(maxRowCount);
        FlatComboBoxUI.this.paddingBorder.uninstall();
        return height;
    }

    @Override
    public void show(Component invoker, int x, int y) {
        Border popupBorder;
        if (y < 0 && !SystemInfo.isJava_9_orLater && (popupBorder = this.getBorder()) != null) {
            Insets insets = popupBorder.getBorderInsets(this);
            y -= insets.top + insets.bottom;
        }
        super.show(invoker, x, y);
    }

    @Override
    protected void paintChildren(Graphics g) {
        super.paintChildren(g);
        FlatComboBoxUI.this.paddingBorder.uninstall();
    }

    private boolean isPopupOverComboBox() {
        return FlatComboBoxUI.this.isMacStyle() && !this.comboBox.isEditable() && this.comboBox.getItemCount() > 0 && this.comboBox.getItemCount() <= this.comboBox.getMaximumRowCount() && !FlatClientProperties.clientPropertyBoolean(this.comboBox, "JComboBox.isPopDown", false);
    }

    private class PopupListCellRenderer
    implements ListCellRenderer {
        private PopupListCellRenderer() {
        }

        public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
            FlatComboBoxUI.this.paddingBorder.uninstall();
            DefaultListCellRenderer renderer = FlatComboPopup.this.comboBox.getRenderer();
            if (renderer == null) {
                renderer = new DefaultListCellRenderer();
            }
            Component c = renderer.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
            c.applyComponentOrientation(FlatComboPopup.this.comboBox.getComponentOrientation());
            if (FlatComboPopup.this.isPopupOverComboBox() && c instanceof JComponent) {
                int selectedIndex = FlatComboPopup.this.comboBox.getSelectedIndex();
                ((JComponent)c).putClientProperty("FlatLaf.internal.FlatComboBoxUI.macStyleHint", selectedIndex >= 0 ? Boolean.valueOf(index == selectedIndex) : null);
            }
            FlatComboBoxUI.this.paddingBorder.install(c, Math.round(FlatUIUtils.getBorderFocusWidth(FlatComboPopup.this.comboBox)));
            return c;
        }
    }
}
