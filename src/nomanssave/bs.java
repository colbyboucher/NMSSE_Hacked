/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import nomanssave.bl;
import nomanssave.gr;

class bs
implements TableModel {
    final /* synthetic */ bl er;

    bs(bl bl2) {
        this.er = bl2;
    }

    @Override
    public void addTableModelListener(TableModelListener tableModelListener) {
    }

    public Class getColumnClass(int n) {
        return String.class;
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public String getColumnName(int n) {
        switch (n) {
            case 0: {
                return "Name";
            }
            case 1: {
                return "Type";
            }
            case 2: {
                return "Class";
            }
        }
        return null;
    }

    @Override
    public int getRowCount() {
        return bl.c(this.er) == null ? 0 : bl.c(this.er).length;
    }

    @Override
    public Object getValueAt(int n, int n2) {
        switch (n2) {
            case 0: {
                return bl.c(this.er) == null ? null : bl.c(this.er)[n].toString();
            }
            case 1: {
                gr gr2 = bl.c(this.er) == null ? null : bl.c(this.er)[n].da();
                return gr2 == null ? "Unknown" : gr2.toString();
            }
            case 2: {
                return bl.c(this.er) == null ? null : bl.c(this.er)[n].cW().toString();
            }
        }
        return null;
    }

    @Override
    public boolean isCellEditable(int n, int n2) {
        return false;
    }

    @Override
    public void removeTableModelListener(TableModelListener tableModelListener) {
    }

    @Override
    public void setValueAt(Object object, int n, int n2) {
    }
}
