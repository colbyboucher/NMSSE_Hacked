/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import nomanssave.dz;

class dC
implements ActionListener {
    final /* synthetic */ dz hu;

    dC(dz dz2) {
        this.hu = dz2;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        this.hu.setVisible(false);
    }
}
