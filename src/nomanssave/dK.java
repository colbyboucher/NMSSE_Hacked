/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import javax.swing.ComboBoxModel;
import javax.swing.event.ListDataListener;
import nomanssave.dJ;
import nomanssave.eM;

class dK
implements ComboBoxModel {
    eM hF;
    final /* synthetic */ dJ hG;

    dK(dJ dJ2) {
        this.hG = dJ2;
    }

    @Override
    public int getSize() {
        return 1 + eM.getCount();
    }

    public eM F(int n) {
        if (n == 0) {
            return null;
        }
        return eM.S(n - 1);
    }

    @Override
    public void addListDataListener(ListDataListener listDataListener) {
    }

    @Override
    public void removeListDataListener(ListDataListener listDataListener) {
    }

    @Override
    public void setSelectedItem(Object object) {
        this.hF = (eM)object;
    }

    @Override
    public Object getSelectedItem() {
        return this.hF;
    }

    @Override
    public /* synthetic */ Object getElementAt(int n) {
        return this.F(n);
    }
}
