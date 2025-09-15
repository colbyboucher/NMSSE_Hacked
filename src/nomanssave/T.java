/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import nomanssave.Q;
import nomanssave.W;

class T
implements ActionListener {
    final /* synthetic */ Q bD;

    T(Q q) {
        this.bD = q;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        Q.a(this.bD, new W(Integer.parseInt(Q.a(this.bD).getText()), Integer.parseInt(Q.d(this.bD).getText())));
        this.bD.setVisible(false);
    }
}
