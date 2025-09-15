/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import java.util.function.Function;
import java.util.function.Supplier;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import nomanssave.eI;
import nomanssave.f;

class g
implements TableModel {
    final /* synthetic */ f i;
    private final /* synthetic */ Supplier j;
    private final /* synthetic */ Function k;

    g(f f2, Supplier supplier, Function function) {
        this.i = f2;
        this.j = supplier;
        this.k = function;
    }

    @Override
    public int getRowCount() {
        return (Integer)this.j.get();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public String getColumnName(int n) {
        switch (n) {
            case 0: {
                return "ID";
            }
            case 1: {
                return "Name";
            }
            case 2: {
                return "Unlocked";
            }
        }
        return null;
    }

    public Class getColumnClass(int n) {
        switch (n) {
            case 0: 
            case 1: {
                return String.class;
            }
        }
        return Boolean.class;
    }

    @Override
    public boolean isCellEditable(int n, int n2) {
        return n2 == 2 && this.i.g != null;
    }

    @Override
    public Object getValueAt(int n, int n2) {
        eI eI2 = (eI)this.k.apply(n);
        switch (n2) {
            case 0: {
                return eI2 == null ? "" : eI2.getID();
            }
            case 1: {
                return eI2 == null ? "" : eI2.getName();
            }
            case 2: {
                return eI2 == null || this.i.g == null ? false : this.i.g.indexOf(eI2.getID()) >= 0;
            }
        }
        return null;
    }

    @Override
    public void setValueAt(Object object, int n, int n2) {
        if (this.i.g == null) {
            return;
        }
        eI eI2 = (eI)this.k.apply(n);
        if (n2 == 2) {
            int n3 = this.i.g.indexOf(eI2.getID());
            if (Boolean.TRUE.equals(object)) {
                if (n3 < 0) {
                    this.i.g.f(eI2.getID());
                }
            } else if (n3 >= 0) {
                this.i.g.ac(n3);
            }
        }
    }

    @Override
    public void addTableModelListener(TableModelListener tableModelListener) {
    }

    @Override
    public void removeTableModelListener(TableModelListener tableModelListener) {
    }
}
