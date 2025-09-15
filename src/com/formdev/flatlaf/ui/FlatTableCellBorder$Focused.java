/*
 * Decompiled with CFR 0.152.
 */
package com.formdev.flatlaf.ui;

import com.formdev.flatlaf.ui.FlatTableCellBorder;
import java.awt.Component;
import java.awt.Graphics;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.border.Border;

public static class FlatTableCellBorder.Focused
extends FlatTableCellBorder {
    @Override
    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        Border border;
        JTable table;
        if (c != null && c.getClass().getName().equals("javax.swing.JTable$BooleanRenderer") && (table = (JTable)SwingUtilities.getAncestorOfClass(JTable.class, c)) != null && c.getForeground() == table.getSelectionForeground() && c.getBackground() == table.getSelectionBackground() && (border = UIManager.getBorder("Table.focusSelectedCellHighlightBorder")) != null) {
            border.paintBorder(c, g, x, y, width, height);
            return;
        }
        super.paintBorder(c, g, x, y, width, height);
    }
}
