/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import nomanssave.dd;

class dh
implements ActionListener {
    final /* synthetic */ dd gW;

    dh(dd dd2) {
        this.gW = dd2;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        this.gW.setVisible(false);
    }
}
