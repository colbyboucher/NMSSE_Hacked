/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import nomanssave.aQ;

class aT
implements ActionListener {
    final /* synthetic */ aQ dr;

    aT(aQ aQ2) {
        this.dr = aQ2;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        aQ.a(this.dr, new Dimension(Integer.parseInt(aQ.a(this.dr).getText()), Integer.parseInt(aQ.e(this.dr).getText())));
        this.dr.setVisible(false);
    }
}
