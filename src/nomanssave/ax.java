/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import nomanssave.ap;
import nomanssave.eS;
import nomanssave.eU;
import nomanssave.gA;

class ax
implements TableModel {
    final /* synthetic */ ap cu;

    ax(ap ap2) {
        this.cu = ap2;
    }

    @Override
    public int getRowCount() {
        return eS.bx();
    }

    @Override
    public int getColumnCount() {
        return 7;
    }

    @Override
    public String getColumnName(int n) {
        switch (n) {
            case 0: {
                return "Word";
            }
            case 1: {
                return "ID";
            }
            case 2: {
                return eU.kr.toString();
            }
            case 3: {
                return eU.ks.toString();
            }
            case 4: {
                return eU.kt.toString();
            }
            case 5: {
                return eU.kv.toString();
            }
            case 6: {
                return eU.kz.toString();
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
        if (n2 < 2 || n2 >= this.getColumnCount()) {
            return false;
        }
        eS eS2 = eS.T(n);
        if (eS2 == null) {
            return false;
        }
        switch (n2) {
            case 2: {
                return eS2.a(eU.kr);
            }
            case 3: {
                return eS2.a(eU.ks);
            }
            case 4: {
                return eS2.a(eU.kt);
            }
            case 5: {
                return eS2.a(eU.kv);
            }
            case 6: {
                return eS2.a(eU.kz);
            }
        }
        return false;
    }

    @Override
    public Object getValueAt(int n, int n2) {
        eS eS2 = eS.T(n);
        gA gA2 = ap.i(this.cu).a(eS2);
        switch (n2) {
            case 0: {
                return eS2 == null ? "" : eS2.getText();
            }
            case 1: {
                return gA2.getID();
            }
            case 2: {
                return gA2.c(eU.kr);
            }
            case 3: {
                return gA2.c(eU.ks);
            }
            case 4: {
                return gA2.c(eU.kt);
            }
            case 5: {
                return gA2.c(eU.kv);
            }
            case 6: {
                return gA2.c(eU.kz);
            }
        }
        return null;
    }

    @Override
    public void setValueAt(Object object, int n, int n2) {
        eS eS2 = eS.T(n);
        gA gA2 = ap.i(this.cu).a(eS2);
        switch (n2) {
            case 2: {
                gA2.a(eU.kr, Boolean.TRUE.equals(object));
                break;
            }
            case 3: {
                gA2.a(eU.ks, Boolean.TRUE.equals(object));
                break;
            }
            case 4: {
                gA2.a(eU.kt, Boolean.TRUE.equals(object));
                break;
            }
            case 5: {
                gA2.a(eU.kv, Boolean.TRUE.equals(object));
                break;
            }
            case 6: {
                gA2.a(eU.kz, Boolean.TRUE.equals(object));
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
