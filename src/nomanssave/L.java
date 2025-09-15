/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import javax.swing.ComboBoxModel;
import javax.swing.event.ListDataListener;
import nomanssave.I;
import nomanssave.gf;

class L
implements ComboBoxModel {
    gf bu = null;
    final /* synthetic */ I bt;

    L(I i) {
        this.bt = i;
    }

    @Override
    public int getSize() {
        return I.a(this.bt) == null ? 0 : I.a(this.bt).cE().size();
    }

    public gf p(int n) {
        return I.a(this.bt) == null ? null : (gf)I.a(this.bt).cE().get(n);
    }

    @Override
    public void addListDataListener(ListDataListener listDataListener) {
    }

    @Override
    public void removeListDataListener(ListDataListener listDataListener) {
    }

    @Override
    public void setSelectedItem(Object object) {
        this.bu = (gf)object;
        if (this.bu == null) {
            I.e(this.bt).setText("");
            I.f(this.bt).setText("");
            I.f(this.bt).setEnabled(false);
            I.g(this.bt).setEnabled(false);
            I.h(this.bt).setEnabled(false);
            I.i(this.bt).setEnabled(false);
        } else {
            I.e(this.bt).setText(Integer.toString(this.bu.cG()));
            I.f(this.bt).setText(this.bu.getName());
            I.f(this.bt).setEnabled(true);
            I.g(this.bt).setEnabled(true);
            I.h(this.bt).setEnabled(true);
            I.i(this.bt).setEnabled(true);
        }
    }

    @Override
    public Object getSelectedItem() {
        return this.bu;
    }

    @Override
    public /* synthetic */ Object getElementAt(int n) {
        return this.p(n);
    }
}
