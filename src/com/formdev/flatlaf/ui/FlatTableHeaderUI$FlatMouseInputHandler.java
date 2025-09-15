/*
 * Decompiled with CFR 0.152.
 */
package com.formdev.flatlaf.ui;

import java.awt.Cursor;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import javax.swing.JTable;
import javax.swing.plaf.basic.BasicTableHeaderUI;

protected class FlatTableHeaderUI.FlatMouseInputHandler
extends BasicTableHeaderUI.MouseInputHandler {
    Cursor oldCursor;

    protected FlatTableHeaderUI.FlatMouseInputHandler() {
        super(FlatTableHeaderUI.this);
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        int column;
        JTable table;
        if (this.oldCursor != null) {
            FlatTableHeaderUI.this.header.setCursor(this.oldCursor);
            this.oldCursor = null;
        }
        super.mouseMoved(e);
        if (FlatTableHeaderUI.this.header.isEnabled() && (table = FlatTableHeaderUI.this.header.getTable()) != null && table.getAutoResizeMode() != 0 && FlatTableHeaderUI.this.header.getCursor() == Cursor.getPredefinedCursor(11) && (column = FlatTableHeaderUI.this.header.columnAtPoint(e.getPoint())) >= 0 && column == FlatTableHeaderUI.this.header.getColumnModel().getColumnCount() - 1) {
            Rectangle r = FlatTableHeaderUI.this.header.getHeaderRect(column);
            r.grow(-3, 0);
            if (!r.contains(e.getX(), e.getY())) {
                boolean isResizeLastColumn;
                boolean bl = isResizeLastColumn = e.getX() >= r.x + r.width / 2;
                if (!FlatTableHeaderUI.this.header.getComponentOrientation().isLeftToRight()) {
                    boolean bl2 = isResizeLastColumn = !isResizeLastColumn;
                }
                if (isResizeLastColumn) {
                    this.oldCursor = FlatTableHeaderUI.this.header.getCursor();
                    FlatTableHeaderUI.this.header.setCursor(Cursor.getDefaultCursor());
                }
            }
        }
    }
}
