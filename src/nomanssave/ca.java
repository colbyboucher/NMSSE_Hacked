/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import nomanssave.bO;
import nomanssave.bS;

class ca
implements ActionListener {
    final /* synthetic */ bS fk;

    ca(bS bS2) {
        this.fk = bS2;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (!bO.a(bS.j(this.fk)).dq()) {
            return;
        }
        if (bO.a(bS.j(this.fk)).ds()) {
            bO.c(bS.j(this.fk));
        }
    }
}
