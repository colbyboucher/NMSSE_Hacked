/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import nomanssave.Application;
import nomanssave.dj;

class dq
implements ActionListener {
    final /* synthetic */ dj hl;
    private final /* synthetic */ Application bv;

    dq(dj dj2, Application application) {
        this.hl = dj2;
        this.bv = application;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        int n = dj.j(this.hl).getSelectedIndex();
        if (n < 0 || n >= dj.a(this.hl).length) {
            return;
        }
        if (dj.a(this.hl).length == 1) {
            this.bv.c("You cannot delete the only multitool you have!");
            return;
        }
        if (JOptionPane.showConfirmDialog(this.hl, "Are you sure you want to delete this multitool?\nAll technology in the multitool will be lost!", "Delete", 2) != 0) {
            return;
        }
        this.bv.h(dj.a(this.hl)[n].getIndex());
    }
}
