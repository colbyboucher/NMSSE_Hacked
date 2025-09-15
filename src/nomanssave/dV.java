/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import nomanssave.Application;
import nomanssave.dN;
import nomanssave.eV;
import nomanssave.gH;

class dV
implements ActionListener {
    final /* synthetic */ dN ia;
    private final /* synthetic */ Application bv;

    dV(dN dN2, Application application) {
        this.ia = dN2;
        this.bv = application;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        gH gH2 = (gH)dN.p(this.ia).getSelectedItem();
        if (gH2 == null) {
            return;
        }
        eV eV2 = this.bv.d("PlayerStateData.ShipUsesLegacyColours");
        if (eV2 == null) {
            return;
        }
        if (dN.f(this.ia).isSelected() ^ eV2.ab(gH2.getIndex())) {
            eV2.a(gH2.getIndex(), dN.f(this.ia).isSelected());
        }
    }
}
