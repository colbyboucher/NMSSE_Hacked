/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import nomanssave.Application;
import nomanssave.X;
import nomanssave.gj;
import nomanssave.hc;

class aa
implements ActionListener {
    final /* synthetic */ X bV;
    private final /* synthetic */ Application bv;

    aa(X x, Application application) {
        this.bV = x;
        this.bv = application;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        gj gj2 = this.bv.j();
        if (gj2 != null) {
            int n = -1;
            gj[] gjArray = new gj[X.a(this.bV).length + 1];
            int n2 = 0;
            while (n2 < X.a(this.bV).length) {
                if (X.a(this.bV)[n2].getIndex() < gj2.getIndex()) {
                    gjArray[n2] = X.a(this.bV)[n2];
                } else {
                    gjArray[n2 + 1] = X.a(this.bV)[n2];
                    if (n < 0) {
                        n = n2;
                    }
                }
                ++n2;
            }
            if (n < 0) {
                n = X.a(this.bV).length;
            }
            gjArray[n] = gj2;
            X.a(this.bV, gjArray);
            hc.info("Imported " + gj2.cL().name().toLowerCase() + ": " + gj2.getIndex());
            X.k(this.bV).setSelectedIndex(n);
            X.k(this.bV).updateUI();
        }
    }
}
