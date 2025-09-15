/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import nomanssave.bl;
import nomanssave.hc;

class bz
implements ActionListener {
    final /* synthetic */ bl er;

    bz(bl bl2) {
        this.er = bl2;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (bl.b(this.er) < 0) {
            return;
        }
        hc.info("Repairing frigate damage");
        bl.c(this.er)[bl.b(this.er)].aw(0);
        bl.c(this.er)[bl.b(this.er)].ax(0);
        bl.y(this.er).setText("");
        bl.z(this.er).setVisible(false);
    }
}
