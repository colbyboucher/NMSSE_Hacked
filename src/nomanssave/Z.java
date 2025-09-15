/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import nomanssave.Application;
import nomanssave.X;
import nomanssave.gj;

class Z
implements ActionListener {
    final /* synthetic */ X bV;
    private final /* synthetic */ Application bv;

    Z(X x, Application application) {
        this.bV = x;
        this.bv = application;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        gj gj2 = (gj)X.k(this.bV).getSelectedItem();
        if (gj2 != null) {
            this.bv.a(gj2);
        }
    }
}
