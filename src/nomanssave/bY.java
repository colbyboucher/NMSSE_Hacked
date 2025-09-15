/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import nomanssave.bO;
import nomanssave.bS;
import nomanssave.en;

class bY
implements ActionListener {
    final /* synthetic */ bS fk;

    bY(bS bS2) {
        this.fk = bS2;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (!bO.a(bS.j(this.fk)).dp() && !en.aS()) {
            return;
        }
        if (bO.a(bS.j(this.fk)).dv()) {
            bO.c(bS.j(this.fk));
        }
    }
}
