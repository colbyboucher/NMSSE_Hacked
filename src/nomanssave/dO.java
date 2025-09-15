/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import java.util.Collections;
import javax.swing.ComboBoxModel;
import javax.swing.event.ListDataListener;
import nomanssave.Application;
import nomanssave.dN;
import nomanssave.eV;
import nomanssave.gH;

class dO
implements ComboBoxModel {
    private gH hZ = null;
    final /* synthetic */ dN ia;
    private final /* synthetic */ Application bv;

    dO(dN dN2, Application application) {
        this.ia = dN2;
        this.bv = application;
    }

    @Override
    public int getSize() {
        return dN.a(this.ia) == null ? 0 : dN.a(this.ia).length;
    }

    public gH G(int n) {
        return dN.a(this.ia)[n];
    }

    @Override
    public void addListDataListener(ListDataListener listDataListener) {
    }

    @Override
    public void removeListDataListener(ListDataListener listDataListener) {
    }

    @Override
    public void setSelectedItem(Object object) {
        this.hZ = (gH)object;
        if (this.hZ == null) {
            dN.b(this.ia).setText("");
            dN.c(this.ia).setSelectedIndex(-1);
            dN.d(this.ia).setSelectedIndex(-1);
            dN.e(this.ia).setText("");
            dN.f(this.ia).setSelected(false);
            dN.f(this.ia).setEnabled(false);
            dN.g(this.ia).setEnabled(false);
            dN.h(this.ia).setText("");
            dN.i(this.ia).setText("");
            dN.j(this.ia).setText("");
            dN.k(this.ia).setText("");
            dN.l(this.ia).a(Collections.emptyList());
            return;
        }
        dN.b(this.ia).setText(this.hZ.getName());
        dN.c(this.ia).m(this.hZ.cT());
        dN.d(this.ia).m(this.hZ.cW());
        dN.e(this.ia).setText(this.hZ.cK());
        eV eV2 = this.bv.d("PlayerStateData.ShipUsesLegacyColours");
        dN.f(this.ia).setSelected(eV2 != null && eV2.ab(this.hZ.getIndex()));
        dN.f(this.ia).setEnabled(true);
        dN.g(this.ia).setEnabled(true);
        dN.h(this.ia).setText(Double.toString(this.hZ.dF()));
        dN.i(this.ia).setText(Double.toString(this.hZ.eb()));
        dN.j(this.ia).setText(Double.toString(this.hZ.cX()));
        dN.k(this.ia).setText(Double.toString(this.hZ.ec()));
        dN.l(this.ia).a(this.hZ.cC());
        dN.m(this.ia).setEnabled(false);
        dN.n(this.ia).setEnabled(false);
        if (dN.o(this.ia) != null) {
            int n = 0;
            while (n < dN.a(this.ia).length) {
                if (this.hZ == dN.a(this.ia)[n] && n == dN.o(this.ia).dV()) {
                    dN.m(this.ia).setEnabled(true);
                    dN.n(this.ia).setEnabled(true);
                }
                ++n;
            }
        }
    }

    @Override
    public Object getSelectedItem() {
        return this.hZ;
    }

    @Override
    public /* synthetic */ Object getElementAt(int n) {
        return this.G(n);
    }
}
