/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import javax.swing.ComboBoxModel;
import javax.swing.event.ListDataListener;
import nomanssave.cY;
import nomanssave.gg;

class cZ
implements ComboBoxModel {
    private gg gQ = null;
    final /* synthetic */ cY gR;

    cZ(cY cY2) {
        this.gR = cY2;
    }

    @Override
    public int getSize() {
        return cY.a(this.gR).size();
    }

    public gg C(int n) {
        return (gg)cY.a(this.gR).get(n);
    }

    @Override
    public void addListDataListener(ListDataListener listDataListener) {
    }

    @Override
    public void removeListDataListener(ListDataListener listDataListener) {
    }

    @Override
    public void setSelectedItem(Object object) {
        this.gQ = (gg)object;
    }

    @Override
    public Object getSelectedItem() {
        return this.gQ;
    }

    @Override
    public /* synthetic */ Object getElementAt(int n) {
        return this.C(n);
    }
}
