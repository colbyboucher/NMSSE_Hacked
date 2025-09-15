/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import javax.swing.ComboBoxModel;
import javax.swing.event.ListDataListener;
import nomanssave.eB;
import nomanssave.h;

class j
implements ComboBoxModel {
    private eB A = null;
    final /* synthetic */ h z;

    j(h h2) {
        this.z = h2;
    }

    @Override
    public int getSize() {
        return h.e(this.z).size();
    }

    public eB b(int n) {
        return (eB)((Object)h.e(this.z).get(n));
    }

    @Override
    public void addListDataListener(ListDataListener listDataListener) {
    }

    @Override
    public void removeListDataListener(ListDataListener listDataListener) {
    }

    @Override
    public void setSelectedItem(Object object) {
        this.A = (eB)((Object)object);
        h.f(this.z);
    }

    @Override
    public Object getSelectedItem() {
        return this.A;
    }

    @Override
    public /* synthetic */ Object getElementAt(int n) {
        return this.b(n);
    }
}
