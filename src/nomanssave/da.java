/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import nomanssave.cY;

class da
implements ActionListener {
    final /* synthetic */ cY gR;

    da(cY cY2) {
        this.gR = cY2;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        cY.a(this.gR, cY.b(this.gR).getSelectedIndex());
        this.gR.setVisible(false);
    }
}
