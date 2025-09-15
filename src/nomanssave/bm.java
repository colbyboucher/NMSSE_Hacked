/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import nomanssave.Application;
import nomanssave.bl;

class bm
implements ActionListener {
    final /* synthetic */ bl er;
    private final /* synthetic */ Application bv;

    bm(bl bl2, Application application) {
        this.er = bl2;
        this.bv = application;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (bl.b(this.er) < 0) {
            return;
        }
        if (JOptionPane.showConfirmDialog(this.er, "Are you sure you want to delete this frigate?", "Delete", 2) != 0) {
            return;
        }
        bl.a(this.er, this.bv.k(bl.c(this.er)[bl.b(this.er)].getIndex()));
        if (bl.c(this.er).length > 0) {
            bl.e(this.er).setRowSelectionInterval(0, 0);
        } else {
            bl.e(this.er).clearSelection();
        }
        bl.e(this.er).updateUI();
    }
}
