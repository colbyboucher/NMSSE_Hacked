/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import javax.swing.ComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.event.ListDataListener;
import nomanssave.Application;
import nomanssave.F;
import nomanssave.fs;

class E
implements ComboBoxModel {
    final /* synthetic */ Application aZ;

    E(Application application) {
        this.aZ = application;
    }

    @Override
    public int getSize() {
        return Application.f(this.aZ).length;
    }

    public fs n(int n) {
        return Application.f(this.aZ)[n];
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
            Application.o(this.aZ).hidePopup();
            n = JOptionPane.showConfirmDialog(Application.h(this.aZ), "Are you sure you want to load a different file and lose current changes?", "Save", 2);
            if (n != 0) {
                return;
            }
            Application.f(this.aZ, false);
        }
        n = -1;
        JComboBox jComboBox = Application.n(this.aZ);
        synchronized (jComboBox) {
            int n2 = 0;
            int n3 = 0;
            while (n3 < Application.f(this.aZ).length) {
                if (Application.f(this.aZ)[n3] == object) {
                    n = n2;
                    Application.f((Application)this.aZ)[n2++] = Application.f(this.aZ)[n3];
                } else if (!(Application.f(this.aZ)[n3] instanceof F)) {
                    Application.f((Application)this.aZ)[n2++] = Application.f(this.aZ)[n3];
                }
                ++n3;
            }
            if (n2 < Application.f(this.aZ).length) {
                fs[] fsArray = new fs[n2];
                System.arraycopy(Application.f(this.aZ), 0, fsArray, 0, n2);
                Application.a(this.aZ, fsArray);
            }
        }
        Application.b(this.aZ, n);
    }

    @Override
    public Object getSelectedItem() {
        if (Application.e(this.aZ) < 0) {
            return null;
        }
        return Application.f(this.aZ)[Application.e(this.aZ)];
    }

    @Override
    public /* synthetic */ Object getElementAt(int n) {
        return this.n(n);
    }
}
