/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import nomanssave.aQ;

class aU
implements ActionListener {
    final /* synthetic */ aQ dr;

    aU(aQ aQ2) {
        this.dr = aQ2;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        this.dr.setVisible(false);
    }
}
