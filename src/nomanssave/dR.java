/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import nomanssave.Application;
import nomanssave.dN;

class dR
implements ActionListener {
    final /* synthetic */ dN ia;
    private final /* synthetic */ Application bv;

    dR(dN dN2, Application application) {
        this.ia = dN2;
        this.bv = application;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        int n = dN.p(this.ia).getSelectedIndex();
        if (n < 0 || n >= dN.a(this.ia).length) {
            return;
        }
        this.bv.a(dN.a(this.ia)[n]);
    }
}
