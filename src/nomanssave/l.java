/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import javax.swing.ComboBoxModel;
import javax.swing.event.ListDataListener;
import nomanssave.ey;
import nomanssave.h;

class l
implements ComboBoxModel {
    private ey C = null;
    final /* synthetic */ h z;

    l(h h2) {
        this.z = h2;
    }

    @Override
    public int getSize() {
        return h.i(this.z).size();
    }

    public ey d(int n) {
        return (ey)h.i(this.z).get(n);
    }

    @Override
    public void addListDataListener(ListDataListener listDataListener) {
    }

    @Override
    public void removeListDataListener(ListDataListener listDataListener) {
    }

    @Override
    public void setSelectedItem(Object object) {
        this.C = (ey)object;
    }

    @Override
    public Object getSelectedItem() {
        return this.C;
    }

    @Override
    public /* synthetic */ Object getElementAt(int n) {
        return this.d(n);
    }
}
