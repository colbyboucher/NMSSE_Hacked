/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import javax.swing.ComboBoxModel;
import javax.swing.event.ListDataListener;
import nomanssave.I;
import nomanssave.gh;
import nomanssave.gy;

class J
implements ComboBoxModel {
    gh bs = null;
    final /* synthetic */ I bt;

    J(I i) {
        this.bt = i;
    }

    @Override
    public int getSize() {
        return I.a(this.bt) == null ? 0 : I.a(this.bt).cD().size();
    }

    public gh o(int n) {
        return I.a(this.bt) == null ? null : (gh)I.a(this.bt).cD().get(n);
    }

    @Override
    public void addListDataListener(ListDataListener listDataListener) {
    }

    @Override
    public void removeListDataListener(ListDataListener listDataListener) {
    }

    @Override
    public void setSelectedItem(Object object) {
        this.bs = (gh)object;
        if (this.bs == null) {
            I.b(this.bt).setText("");
            I.c(this.bt).setText("");
            I.c(this.bt).setEnabled(false);
        } else {
            gy gy2 = this.bs.cJ();
            I.b(this.bt).setText(gy2 == null ? "" : gy2.toString());
            I.c(this.bt).setText(this.bs.cK());
            I.c(this.bt).setEnabled(true);
        }
    }

    @Override
    public Object getSelectedItem() {
        return this.bs;
    }

    @Override
    public /* synthetic */ Object getElementAt(int n) {
        return this.o(n);
    }
}
