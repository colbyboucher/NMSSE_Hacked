/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import javax.swing.ComboBoxModel;
import javax.swing.event.ListDataListener;
import nomanssave.aD;
import nomanssave.aI;

class aE
implements ComboBoxModel {
    aI cA = null;
    final /* synthetic */ aD cB;

    aE(aD aD2) {
        this.cB = aD2;
    }

    @Override
    public int getSize() {
        return aI.values().length;
    }

    public aI t(int n) {
        return aI.values()[n];
    }

    @Override
    public void addListDataListener(ListDataListener listDataListener) {
    }

    @Override
    public void removeListDataListener(ListDataListener listDataListener) {
    }

    @Override
    public void setSelectedItem(Object object) {
        this.cA = (aI)((Object)object);
    }

    @Override
    public Object getSelectedItem() {
        return this.cA;
    }

    @Override
    public /* synthetic */ Object getElementAt(int n) {
        return this.t(n);
    }
}
