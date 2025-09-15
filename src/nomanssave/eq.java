/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import java.util.Collections;
import javax.swing.ComboBoxModel;
import javax.swing.event.ListDataListener;
import nomanssave.ep;
import nomanssave.gO;

class eq
implements ComboBoxModel {
    private gO iz = null;
    final /* synthetic */ ep iA;

    eq(ep ep2) {
        this.iA = ep2;
    }

    @Override
    public int getSize() {
        return ep.a(this.iA) == null ? 0 : ep.a(this.iA).length;
    }

    public gO J(int n) {
        return ep.a(this.iA)[n];
    }

    @Override
    public void addListDataListener(ListDataListener listDataListener) {
    }

    @Override
    public void removeListDataListener(ListDataListener listDataListener) {
    }

    @Override
    public void setSelectedItem(Object object) {
        this.iz = (gO)object;
        if (this.iz == null) {
            ep.b(this.iA).a(Collections.emptyList());
            return;
        }
        ep.b(this.iA).a(this.iz.cC());
    }

    @Override
    public Object getSelectedItem() {
        return this.iz;
    }

    @Override
    public /* synthetic */ Object getElementAt(int n) {
        return this.J(n);
    }
}
