/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import nomanssave.aD;

class aG
implements ActionListener {
    final /* synthetic */ aD cB;

    aG(aD aD2) {
        this.cB = aD2;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        this.cB.setVisible(false);
    }
}
