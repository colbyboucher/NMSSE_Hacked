/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import javax.swing.ComboBoxModel;
import javax.swing.event.ListDataListener;
import nomanssave.dE;
import nomanssave.gE;
import nomanssave.gF;

class dF
implements ComboBoxModel {
    private gE hD = null;
    final /* synthetic */ dE hE;

    dF(dE dE2) {
        this.hE = dE2;
    }

    @Override
    public int getSize() {
        return dE.b(this.hE) == null ? 0 : dE.b(this.hE).length;
    }

    public gE E(int n) {
        return dE.b(this.hE)[n];
    }

    @Override
    public void addListDataListener(ListDataListener listDataListener) {
    }

    @Override
    public void removeListDataListener(ListDataListener listDataListener) {
    }

    @Override
    public void setSelectedItem(Object object) {
        this.hD = (gE)object;
        if (this.hD == null) {
            dE.c(this.hE).setText("");
            dE.d(this.hE).setText("");
            int n = 0;
            while (n < dE.e(this.hE).length) {
                dE.e(this.hE)[n].setText("");
                ++n;
            }
            dE.f(this.hE).a(new gF[0]);
        } else {
            dE.c(this.hE).setText(this.hD.getName());
            dE.d(this.hE).setText(this.hD.cK());
            int n = 0;
            while (n < dE.e(this.hE).length) {
                dE.e(this.hE)[n].setText(Integer.toString(this.hD.aq(n)));
                ++n;
            }
            dE.f(this.hE).a(this.hD.dX());
        }
        dE.g(this.hE).revalidate();
    }

    @Override
    public Object getSelectedItem() {
        return this.hD;
    }

    @Override
    public /* synthetic */ Object getElementAt(int n) {
        return this.E(n);
    }
}
