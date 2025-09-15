/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import javax.swing.ComboBoxModel;
import javax.swing.event.ListDataListener;
import nomanssave.X;
import nomanssave.gl;

class ab
implements ComboBoxModel {
    final /* synthetic */ X bV;

    ab(X x) {
        this.bV = x;
    }

    @Override
    public int getSize() {
        return gl.values().length;
    }

    public gl r(int n) {
        return gl.values()[n];
    }

    @Override
    public void addListDataListener(ListDataListener listDataListener) {
    }

    @Override
    public void removeListDataListener(ListDataListener listDataListener) {
    }

    @Override
    public void setSelectedItem(Object object) {
    }

    @Override
    public Object getSelectedItem() {
        return gl.oF;
    }

    @Override
    public /* synthetic */ Object getElementAt(int n) {
        return this.r(n);
    }
}
