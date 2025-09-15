/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import javax.swing.ComboBoxModel;
import javax.swing.event.ListDataListener;
import nomanssave.ex;
import nomanssave.h;

class k
implements ComboBoxModel {
    private ex B = null;
    final /* synthetic */ h z;

    k(h h2) {
        this.z = h2;
    }

    @Override
    public int getSize() {
        return h.g(this.z).size();
    }

    public ex c(int n) {
        return (ex)((Object)h.g(this.z).get(n));
    }

    @Override
    public void addListDataListener(ListDataListener listDataListener) {
    }

    @Override
    public void removeListDataListener(ListDataListener listDataListener) {
    }

    @Override
    public void setSelectedItem(Object object) {
        this.B = (ex)((Object)object);
        h.h(this.z);
    }

    @Override
    public Object getSelectedItem() {
        return this.B;
    }

    @Override
    public /* synthetic */ Object getElementAt(int n) {
        return this.c(n);
    }
}
