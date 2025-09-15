/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import nomanssave.Application;
import nomanssave.bl;
import nomanssave.en;
import nomanssave.hg;

class br
implements ActionListener {
    final /* synthetic */ bl er;
    private final /* synthetic */ Application bv;

    br(bl bl2, Application application) {
        this.er = bl2;
        this.bv = application;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (bl.b(this.er) < 0) {
            return;
        }
        String string = hg.eo().toString();
        bl.a(this.er, this.bv.a(bl.c(this.er)[bl.b(this.er)].getIndex(), string));
        bl.g(this.er).setEnabled(bl.c(this.er).length < 30 || en.aS());
        bl.e(this.er).updateUI();
    }
}
