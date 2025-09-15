/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import nomanssave.Application;
import nomanssave.dN;

class dQ
implements ActionListener {
    final /* synthetic */ dN ia;
    private final /* synthetic */ Application bv;

    dQ(dN dN2, Application application) {
        this.ia = dN2;
        this.bv = application;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        int n = dN.p(this.ia).getSelectedIndex();
        if (n < 0 || n >= dN.a(this.ia).length) {
            return;
        }
        if (dN.a(this.ia).length == 1) {
            this.bv.c("You cannot delete the only ship you have!");
            return;
        }
        if (JOptionPane.showConfirmDialog(this.ia, "Are you sure you want to delete this ship?\nAll items and technology in the ship inventory will be lost!", "Delete", 2) != 0) {
            return;
        }
        this.bv.i(dN.a(this.ia)[n].getIndex());
    }
}
