/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import nomanssave.dE;
import nomanssave.eM;
import nomanssave.gE;

class dI
implements TableModel {
    final /* synthetic */ dE hE;

    dI(dE dE2) {
        this.hE = dE2;
    }

    @Override
    public void addTableModelListener(TableModelListener tableModelListener) {
    }

    public Class getColumnClass(int n) {
        if (n == 1) {
            return eM.class;
        }
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
                return "ID";
            }
            case 1: {
                return "Name";
            }
            case 2: {
                return "Description";
            }
        }
        return null;
    }

    @Override
    public int getRowCount() {
        gE gE2 = (gE)dE.a(this.hE).getSelectedItem();
        if (gE2 == null) {
            return 0;
        }
        return gE2.dW();
    }

    @Override
    public Object getValueAt(int n, int n2) {
        gE gE2 = (gE)dE.a(this.hE).getSelectedItem();
        String string = gE2 == null ? null : gE2.aH(n);
        eM eM2 = eM.x(string);
        switch (n2) {
            case 0: {
                return string;
            }
            case 1: {
                return eM2;
            }
            case 2: {
                return eM2 == null ? "" : eM2.getDescription();
            }
        }
        return null;
    }

    @Override
    public boolean isCellEditable(int n, int n2) {
        return n2 == 1;
    }

    @Override
    public void removeTableModelListener(TableModelListener tableModelListener) {
    }

    @Override
    public void setValueAt(Object object, int n, int n2) {
        gE gE2 = (gE)dE.a(this.hE).getSelectedItem();
        if (gE2 == null || n2 != 1) {
            return;
        }
        eM eM2 = (eM)object;
        String string = gE2.aH(n);
        if (eM2.bb()) {
            int n3 = string.indexOf("#");
            if (n3 >= 0 && string.substring(0, n3).equals(eM2.getID())) {
                return;
            }
            String string2 = "#" + (int)Math.floor(Math.random() * 100000.0);
            gE2.c(n, String.valueOf(eM2.getID()) + string2);
        } else {
            if (string.endsWith(eM2.getID())) {
                return;
            }
            gE2.c(n, eM2.getID());
        }
    }
}
