/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import nomanssave.dd;

class dg
implements ActionListener {
    final /* synthetic */ dd gW;

    dg(dd dd2) {
        this.gW = dd2;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        dd.a(this.gW, dd.b(this.gW).getSelectedIndex());
        this.gW.setVisible(false);
    }
}
