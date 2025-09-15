/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import nomanssave.Application;
import nomanssave.I;
import nomanssave.gf;

class N
implements ActionListener {
    final /* synthetic */ I bt;
    private final /* synthetic */ Application bv;

    N(I i, Application application) {
        this.bt = i;
        this.bv = application;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        gf gf2 = (gf)I.j(this.bt).getSelectedItem();
        if (gf2 != null) {
            this.bv.a(gf2);
        }
    }
}
