/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import nomanssave.Application;
import nomanssave.dN;
import nomanssave.gH;
import nomanssave.hc;

class dS
implements ActionListener {
    final /* synthetic */ dN ia;
    private final /* synthetic */ Application bv;

    dS(dN dN2, Application application) {
        this.ia = dN2;
        this.bv = application;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        gH gH2 = this.bv.h();
        if (gH2 != null) {
            gH[] gHArray = new gH[dN.a(this.ia).length + 1];
            int n = -1;
            int n2 = 0;
            while (n2 < dN.a(this.ia).length) {
                if (dN.a(this.ia)[n2].getIndex() < gH2.getIndex()) {
                    gHArray[n2] = dN.a(this.ia)[n2];
                } else {
                    gHArray[n2 + 1] = dN.a(this.ia)[n2];
                    if (n < 0) {
                        n = n2;
                    }
                }
                ++n2;
            }
            if (n < 0) {
                n = dN.a(this.ia).length;
            }
            gHArray[n] = gH2;
            dN.a(this.ia, gHArray);
            hc.info("Imported ship: " + gH2.getIndex());
            dN.p(this.ia).setSelectedIndex(n);
            dN.p(this.ia).updateUI();
        }
    }
}
