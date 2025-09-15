/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import nomanssave.aQ;

class aV
implements ActionListener {
    final /* synthetic */ aQ dr;

    aV(aQ aQ2) {
        this.dr = aQ2;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        this.dr.setVisible(false);
    }
}
