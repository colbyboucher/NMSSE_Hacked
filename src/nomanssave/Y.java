/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import javax.swing.ComboBoxModel;
import javax.swing.event.ListDataListener;
import nomanssave.X;
import nomanssave.gj;

class Y
implements ComboBoxModel {
    private gj bU = null;
    final /* synthetic */ X bV;

    Y(X x) {
        this.bV = x;
    }

    @Override
    public int getSize() {
        return X.a(this.bV) == null ? 0 : X.a(this.bV).length;
    }

    public gj q(int n) {
        return X.a(this.bV)[n];
    }

    @Override
    public void addListDataListener(ListDataListener listDataListener) {
    }

    @Override
    public void removeListDataListener(ListDataListener listDataListener) {
    }

    @Override
    public void setSelectedItem(Object object) {
        this.bU = (gj)object;
        if (this.bU == null) {
            X.b(this.bV).setSelectedIndex(-1);
            X.c(this.bV).setText("");
            X.c(this.bV).setEnabled(false);
            X.d(this.bV).setText("");
            X.d(this.bV).setEnabled(false);
            X.e(this.bV).setText("");
            X.e(this.bV).setEnabled(false);
            X.f(this.bV).setText("");
            X.f(this.bV).setEnabled(false);
            X.g(this.bV).setText("");
            X.g(this.bV).setEnabled(false);
            X.h(this.bV).setSelected(false);
            X.h(this.bV).setEnabled(false);
            X.i(this.bV).setSelectedIndex(-1);
            X.i(this.bV).setEnabled(false);
            X.j(this.bV).setSelectedIndex(-1);
            X.j(this.bV).setEnabled(false);
        } else {
            X.b(this.bV).setSelectedIndex(this.bU.cL().ordinal());
            X.c(this.bV).setText(this.bU.getName());
            X.c(this.bV).setEnabled(true);
            X.d(this.bV).setText(this.bU.cK());
            X.d(this.bV).setEnabled(true);
            X.e(this.bV).setText(this.bU.cN());
            X.e(this.bV).setEnabled(true);
            X.f(this.bV).setText(this.bU.cO());
            X.f(this.bV).setEnabled(true);
            X.g(this.bV).setText(this.bU.cP());
            X.g(this.bV).setEnabled(true);
            X.h(this.bV).setSelected(this.bU.cQ());
            X.h(this.bV).setEnabled(true);
            X.i(this.bV).m(this.bU.cR());
            X.i(this.bV).setEnabled(true);
            X.j(this.bV).m(this.bU.cS());
            X.j(this.bV).setEnabled(true);
        }
    }

    @Override
    public Object getSelectedItem() {
        return this.bU;
    }

    @Override
    public /* synthetic */ Object getElementAt(int n) {
        return this.q(n);
    }
}
