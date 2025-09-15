/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import nomanssave.dz;

class dB
implements ActionListener {
    final /* synthetic */ dz hu;

    dB(dz dz2) {
        this.hu = dz2;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        int n = dz.b(this.hu).getSelectedIndex();
        if (n >= 0 && !dz.a(this.hu)[n].isEmpty() && JOptionPane.showConfirmDialog(this.hu, "You are about to overwrite this save slot, are you sure you want to do this?", "Warning", 2) != 0) {
            return;
        }
        dz.a(this.hu, n);
        this.hu.setVisible(false);
    }
}
