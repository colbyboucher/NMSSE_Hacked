/*
 * Decompiled with CFR 0.152.
 */
package com.formdev.flatlaf.ui;

import com.formdev.flatlaf.ui.FlatTableCellBorder;
import java.awt.Component;
import java.awt.Graphics;
import javax.swing.JTable;
import javax.swing.SwingUtilities;

public static class FlatTableCellBorder.Selected
extends FlatTableCellBorder {
    public int maxCheckCellsEditable = 50;

    @Override
    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        JTable table;
        boolean showCellFocusIndicator;
        Boolean b = FlatTableCellBorder.Selected.getStyleFromTableUI(c, ui -> ui.showCellFocusIndicator);
        boolean bl = showCellFocusIndicator = b != null ? b : this.showCellFocusIndicator;
        if (!showCellFocusIndicator && (table = (JTable)SwingUtilities.getAncestorOfClass(JTable.class, c)) != null && !this.shouldShowCellFocusIndicator(table)) {
            return;
        }
        super.paintBorder(c, g, x, y, width, height);
    }

    protected boolean shouldShowCellFocusIndicator(JTable table) {
        block8: {
            boolean columnSelectionAllowed;
            block7: {
                boolean rowSelectionAllowed = table.getRowSelectionAllowed();
                columnSelectionAllowed = table.getColumnSelectionAllowed();
                if (rowSelectionAllowed && columnSelectionAllowed) {
                    return false;
                }
                if (!rowSelectionAllowed) break block7;
                if (table.getSelectedRowCount() != 1) {
                    return false;
                }
                int columnCount = table.getColumnCount();
                if (columnCount > this.maxCheckCellsEditable) {
                    return true;
                }
                int selectedRow = table.getSelectedRow();
                for (int column = 0; column < columnCount; ++column) {
                    if (!table.isCellEditable(selectedRow, column)) continue;
                    return true;
                }
                break block8;
            }
            if (!columnSelectionAllowed) break block8;
            if (table.getSelectedColumnCount() != 1) {
                return false;
            }
            int rowCount = table.getRowCount();
            if (rowCount > this.maxCheckCellsEditable) {
                return true;
            }
            int selectedColumn = table.getSelectedColumn();
            for (int row = 0; row < rowCount; ++row) {
                if (!table.isCellEditable(row, selectedColumn)) continue;
                return true;
            }
        }
        return false;
    }
}
