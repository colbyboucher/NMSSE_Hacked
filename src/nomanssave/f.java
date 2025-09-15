/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import java.util.function.Function;
import java.util.function.Supplier;
import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JTable;
import javax.swing.table.TableRowSorter;
import nomanssave.Application;
import nomanssave.c;
import nomanssave.d;
import nomanssave.e;
import nomanssave.eV;
import nomanssave.g;

class f
extends JTable {
    eV g = null;
    final /* synthetic */ c h;

    f(c c2, Application application, Supplier supplier, Function function) {
        this.h = c2;
        g g2 = new g(this, supplier, function);
        this.setCellSelectionEnabled(false);
        this.getColumnModel().setColumnMargin(2);
        this.setModel(g2);
        TableRowSorter<g> tableRowSorter = new TableRowSorter<g>(g2);
        tableRowSorter.setSortable(2, false);
        this.setRowSorter(tableRowSorter);
        this.getTableHeader().getColumnModel().getColumn(0).setHeaderRenderer(new e(2));
        this.getTableHeader().getColumnModel().getColumn(1).setHeaderRenderer(new e(2));
        JCheckBox jCheckBox = new JCheckBox();
        jCheckBox.setHorizontalAlignment(0);
        this.getColumnModel().getColumn(2).setMaxWidth(80);
        this.getTableHeader().getColumnModel().getColumn(2).setHeaderRenderer(new e(0));
        this.getColumnModel().getColumn(2).setCellEditor(new DefaultCellEditor(jCheckBox));
        this.getColumnModel().getColumn(2).setCellRenderer(new d(null));
    }

    void a(eV eV2) {
        this.g = eV2;
    }
}
