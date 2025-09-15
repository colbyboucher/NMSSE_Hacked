/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import javax.swing.ListModel;
import javax.swing.event.ListDataListener;
import nomanssave.dz;
import nomanssave.ft;

class dA
implements ListModel {
    final /* synthetic */ dz hu;

    dA(dz dz2) {
        this.hu = dz2;
    }

    @Override
    public int getSize() {
        return dz.a(this.hu).length;
    }

    public ft m(int n) {
        return dz.a(this.hu)[n];
    }

    @Override
    public void addListDataListener(ListDataListener listDataListener) {
    }

    @Override
    public void removeListDataListener(ListDataListener listDataListener) {
    }

    public /* synthetic */ Object getElementAt(int n) {
        return this.m(n);
    }
}
