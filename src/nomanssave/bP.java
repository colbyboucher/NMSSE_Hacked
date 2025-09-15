/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import javax.swing.ComboBoxModel;
import javax.swing.event.ListDataListener;
import nomanssave.bO;
import nomanssave.en;
import nomanssave.gt;

class bP
implements ComboBoxModel {
    final /* synthetic */ bO eX;

    bP(bO bO2) {
        this.eX = bO2;
    }

    @Override
    public int getSize() {
        return bO.d(this.eX).size();
    }

    public gt w(int n) {
        return (gt)bO.d(this.eX).get(n);
    }

    @Override
    public void addListDataListener(ListDataListener listDataListener) {
    }

    @Override
    public void removeListDataListener(ListDataListener listDataListener) {
    }

    @Override
    public void setSelectedItem(Object object) {
        bO.a(this.eX, (gt)object);
        bO.e(this.eX).setVisible(bO.a(this.eX) == null ? false : en.aS() || bO.a(this.eX).dk());
        bO.c(this.eX);
    }

    @Override
    public Object getSelectedItem() {
        return bO.a(this.eX);
    }

    @Override
    public /* synthetic */ Object getElementAt(int n) {
        return this.w(n);
    }
}
