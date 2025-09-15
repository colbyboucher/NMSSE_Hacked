/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import javax.swing.ComboBoxModel;
import javax.swing.event.ListDataListener;
import nomanssave.bl;
import nomanssave.er;
import nomanssave.gr;

class bw
implements ComboBoxModel {
    gr et;
    final /* synthetic */ bl er;

    bw(bl bl2) {
        this.er = bl2;
    }

    @Override
    public int getSize() {
        return gr.values().length;
    }

    public gr u(int n) {
        return gr.values()[n];
    }

    @Override
    public void addListDataListener(ListDataListener listDataListener) {
    }

    @Override
    public void removeListDataListener(ListDataListener listDataListener) {
    }

    @Override
    public void setSelectedItem(Object object) {
        this.et = (gr)((Object)object);
        bl.a(this.er, bl.b(this.er) < 0 ? null : nomanssave.er.a(this.et));
        bl.b(this.er, bl.b(this.er) < 0 ? null : nomanssave.er.b(this.et));
        if (bl.b(this.er) >= 0 && this.et != null && !this.et.equals((Object)bl.c(this.er)[bl.b(this.er)].da())) {
            bl.c(this.er)[bl.b(this.er)].c(this.et);
            if (bl.a(this.er) != null && bl.a(this.er).length > 0) {
                bl.c(this.er)[bl.b(this.er)].a(0, bl.a(this.er)[0]);
                bl.p(this.er).setSelectedItem(bl.a(this.er)[0]);
            } else {
                bl.p(this.er).setSelectedItem(null);
            }
            bl.q(this.er).setSelectedItem(null);
            bl.r(this.er).setSelectedItem(null);
            bl.s(this.er).setSelectedItem(null);
            bl.t(this.er).setSelectedItem(null);
        }
        bl.e(this.er).updateUI();
        bl.p(this.er).updateUI();
        bl.q(this.er).updateUI();
        bl.r(this.er).updateUI();
        bl.s(this.er).updateUI();
        bl.t(this.er).updateUI();
    }

    @Override
    public Object getSelectedItem() {
        return this.et;
    }

    @Override
    public /* synthetic */ Object getElementAt(int n) {
        return this.u(n);
    }
}
