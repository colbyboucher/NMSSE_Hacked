/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import javax.swing.ListModel;
import javax.swing.event.ListDataListener;
import nomanssave.dd;
import nomanssave.gt;

class de
implements ListModel {
    final /* synthetic */ dd gW;

    de(dd dd2) {
        this.gW = dd2;
    }

    @Override
    public int getSize() {
        return dd.a(this.gW).size();
    }

    public gt w(int n) {
        return (gt)dd.a(this.gW).get(n);
    }

    @Override
    public void addListDataListener(ListDataListener listDataListener) {
    }

    @Override
    public void removeListDataListener(ListDataListener listDataListener) {
    }

    public /* synthetic */ Object getElementAt(int n) {
        return this.w(n);
    }
}
