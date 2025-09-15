/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import javax.swing.ImageIcon;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import nomanssave.ap;
import nomanssave.ey;

class aq
implements TableModel {
    final /* synthetic */ ap cu;

    aq(ap ap2) {
        this.cu = ap2;
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
        return ap.a(this.cu) == null ? 0 : ap.a(this.cu).size();
    }

    @Override
    public Object getValueAt(int n, int n2) {
        String string = ap.a(this.cu).X(n);
        ey ey2 = ey.d(string);
        switch (n2) {
            case 0: {
                return ey2 == null ? null : ey2.N(3);
            }
            case 1: {
                return ey2 == null ? "" : ey2.getName();
            }
            case 2: {
                return ey2 == null ? "" : ey2.bc().toString();
            }
            case 3: {
                return string;
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
