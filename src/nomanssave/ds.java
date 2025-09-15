/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import nomanssave.Application;
import nomanssave.dj;
import nomanssave.gv;

class ds
implements ActionListener {
    final /* synthetic */ dj hl;
    private final /* synthetic */ Application bv;

    ds(dj dj2, Application application) {
        this.hl = dj2;
        this.bv = application;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        gv gv2 = this.bv.i();
        if (gv2 != null) {
            gv[] gvArray = new gv[dj.a(this.hl).length + 1];
            int n = -1;
            int n2 = 0;
            while (n2 < dj.a(this.hl).length) {
                if (dj.a(this.hl)[n2].getIndex() < gv2.getIndex()) {
                    gvArray[n2] = dj.a(this.hl)[n2];
                } else {
                    gvArray[n2 + 1] = dj.a(this.hl)[n2];
                    if (n < 0) {
                        n = n2;
                    }
                }
                ++n2;
            }
            if (n < 0) {
                n = dj.a(this.hl).length;
            }
            gvArray[n] = gv2;
            dj.a(this.hl, gvArray);
            dj.j(this.hl).setSelectedIndex(n);
            dj.j(this.hl).updateUI();
        }
    }
}
