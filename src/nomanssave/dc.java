/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import nomanssave.cY;

class dc
implements ActionListener {
    final /* synthetic */ cY gR;

    dc(cY cY2) {
        this.gR = cY2;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        this.gR.setVisible(false);
    }
}
