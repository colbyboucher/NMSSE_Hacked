/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import javax.swing.ComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.event.ListDataListener;
import nomanssave.Application;
import nomanssave.ft;

class D
implements ComboBoxModel {
    final /* synthetic */ Application aZ;

    D(Application application) {
        this.aZ = application;
    }

    @Override
    public int getSize() {
        return Application.d(this.aZ).length;
    }

    public ft m(int n) {
        return Application.d(this.aZ)[n];
    }

    @Override
    public void addListDataListener(ListDataListener listDataListener) {
    }

    @Override
    public void removeListDataListener(ListDataListener listDataListener) {
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void setSelectedItem(Object object) {
        int n;
        if (Application.i(this.aZ)) {
            Application.n(this.aZ).hidePopup();
            n = JOptionPane.showConfirmDialog(Application.h(this.aZ), "Save data before switching slots?", "Save", 1);
            if (n == 0) {
                Application.k(this.aZ);
            } else {
                if (n == 2) {
                    return;
                }
                Application.f(this.aZ, false);
            }
        }
        n = -1;
        JComboBox jComboBox = Application.n(this.aZ);
        synchronized (jComboBox) {
            int n2 = 0;
            while (n2 < Application.d(this.aZ).length) {
                if (Application.d(this.aZ)[n2] == object) {
                    n = n2;
                    break;
                }
                ++n2;
            }
        }
        Application.a(this.aZ, n);
    }

    @Override
    public Object getSelectedItem() {
        return Application.c(this.aZ) < 0 ? null : Application.d(this.aZ)[Application.c(this.aZ)];
    }

    @Override
    public /* synthetic */ Object getElementAt(int n) {
        return this.m(n);
    }
}
