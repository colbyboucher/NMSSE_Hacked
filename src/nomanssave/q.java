/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import javax.swing.ImageIcon;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import nomanssave.ey;
import nomanssave.p;

class q
implements TableModel {
    final /* synthetic */ p I;

    q(p p2) {
        this.I = p2;
    }

    @Override
    public void addTableModelListener(TableModelListener tableModelListener) {
    }

    public Class getColumnClass(int n) {
        if (n == 0) {
            return ImageIcon.class;
        }
        return String.class;
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public String getColumnName(int n) {
        switch (n) {
            case 0: {
                return "";
            }
            case 1: {
                return "Name";
            }
            case 2: {
                return "Category";
            }
            case 3: {
                return "ID";
            }
        }
        return null;
    }

    @Override
    public int getRowCount() {
        return p.a(this.I) == null ? 0 : p.a(this.I).size();
    }

    @Override
    public Object getValueAt(int n, int n2) {
        switch (n2) {
            case 0: {
                return ((ey)p.a(this.I).get(n)).N(3);
            }
            case 1: {
                return ((ey)p.a(this.I).get(n)).getName();
            }
            case 2: {
                return ((ey)p.a(this.I).get(n)).bc().toString();
            }
            case 3: {
                return ((ey)p.a(this.I).get(n)).getID();
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
