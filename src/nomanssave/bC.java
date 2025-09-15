/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import javax.swing.ComboBoxModel;
import javax.swing.event.ListDataListener;
import nomanssave.bl;
import nomanssave.er;

class bC
implements ComboBoxModel {
    final int ev;
    er eu;
    final /* synthetic */ bl er;

    bC(bl bl2, int n) {
        this.er = bl2;
        this.ev = n;
    }

    @Override
    public int getSize() {
        return 1 + (bl.f(this.er) == null ? 0 : bl.f(this.er).length);
    }

    public er v(int n) {
        if (n == 0) {
            return null;
        }
        return bl.f(this.er) == null ? null : bl.f(this.er)[n - 1];
    }

    @Override
    public void addListDataListener(ListDataListener listDataListener) {
    }

    @Override
    public void removeListDataListener(ListDataListener listDataListener) {
    }

    @Override
    public void setSelectedItem(Object object) {
        er er2;
        this.eu = (er)object;
        if (bl.b(this.er) >= 0 && this.eu != (er2 = bl.c(this.er)[bl.b(this.er)].ar(this.ev))) {
            int n;
            int n2;
            if (er2 != null) {
                n2 = er2.aU().ordinal();
                n = bl.c(this.er)[bl.b(this.er)].aq(n2) - er2.aV();
                if (n < 0) {
                    n = 0;
                }
                bl.c(this.er)[bl.b(this.er)].e(n2, n);
                bl.d(this.er)[n2].setText(Integer.toString(n));
            }
            if (this.eu == null) {
                bl.c(this.er)[bl.b(this.er)].a(this.ev, null);
            } else {
                bl.c(this.er)[bl.b(this.er)].a(this.ev, this.eu);
                n2 = this.eu.aU().ordinal();
                n = bl.c(this.er)[bl.b(this.er)].aq(n2) + this.eu.aV();
                if (n < 0) {
                    n = 0;
                }
                bl.c(this.er)[bl.b(this.er)].e(n2, n);
                bl.d(this.er)[n2].setText(Integer.toString(n));
            }
            bl.e(this.er).updateUI();
        }
    }

    @Override
    public Object getSelectedItem() {
        return this.eu;
    }

    @Override
    public /* synthetic */ Object getElementAt(int n) {
        return this.v(n);
    }
}
