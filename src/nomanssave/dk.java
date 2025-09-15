/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import java.util.Collections;
import javax.swing.ComboBoxModel;
import javax.swing.event.ListDataListener;
import nomanssave.dj;
import nomanssave.gv;

class dk
implements ComboBoxModel {
    private gv hk = null;
    final /* synthetic */ dj hl;

    dk(dj dj2) {
        this.hl = dj2;
    }

    @Override
    public int getSize() {
        return dj.a(this.hl) == null ? 0 : dj.a(this.hl).length;
    }

    public gv D(int n) {
        return dj.a(this.hl)[n];
    }

    @Override
    public void addListDataListener(ListDataListener listDataListener) {
    }

    @Override
    public void removeListDataListener(ListDataListener listDataListener) {
    }

    @Override
    public void setSelectedItem(Object object) {
        this.hk = (gv)object;
        if (this.hk == null) {
            dj.b(this.hl).setText("");
            dj.c(this.hl).setSelectedIndex(-1);
            dj.d(this.hl).setSelectedIndex(-1);
            dj.e(this.hl).setText("");
            dj.f(this.hl).setText("");
            dj.g(this.hl).setText("");
            dj.h(this.hl).setText("");
            dj.i(this.hl).a(Collections.emptyList());
            return;
        }
        dj.b(this.hl).setText(this.hk.getName());
        dj.c(this.hl).m(this.hk.cT());
        dj.d(this.hl).m(this.hk.cW());
        dj.e(this.hl).setText(this.hk.cK());
        dj.f(this.hl).setText(Double.toString(this.hk.dF()));
        dj.g(this.hl).setText(Double.toString(this.hk.dG()));
        dj.h(this.hl).setText(Double.toString(this.hk.dH()));
        dj.i(this.hl).a(Collections.singletonList(this.hk.dE()));
    }

    @Override
    public Object getSelectedItem() {
        return this.hk;
    }

    @Override
    public /* synthetic */ Object getElementAt(int n) {
        return this.D(n);
    }
}
