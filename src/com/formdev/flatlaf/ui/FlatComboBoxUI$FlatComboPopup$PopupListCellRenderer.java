/*
 * Decompiled with CFR 0.152.
 */
package com.formdev.flatlaf.ui;

import com.formdev.flatlaf.ui.FlatUIUtils;
import java.awt.Component;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JComponent;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

private class FlatComboBoxUI.FlatComboPopup.PopupListCellRenderer
implements ListCellRenderer {
    private FlatComboBoxUI.FlatComboPopup.PopupListCellRenderer() {
    }

    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        FlatComboPopup.this.this$0.paddingBorder.uninstall();
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
        FlatComboPopup.this.this$0.paddingBorder.install(c, Math.round(FlatUIUtils.getBorderFocusWidth(FlatComboPopup.this.comboBox)));
        return c;
    }
}
