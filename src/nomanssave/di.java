/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import nomanssave.dd;

class di
implements ActionListener {
    final /* synthetic */ dd gW;

    di(dd dd2) {
        this.gW = dd2;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        this.gW.setVisible(false);
    }
}
