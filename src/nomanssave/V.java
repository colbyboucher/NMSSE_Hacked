/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import nomanssave.Q;

class V
implements ActionListener {
    final /* synthetic */ Q bD;

    V(Q q) {
        this.bD = q;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        this.bD.setVisible(false);
    }
}
