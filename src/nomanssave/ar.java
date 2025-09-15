/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import nomanssave.ap;

class ar
implements ActionListener {
    final /* synthetic */ ap cu;

    ar(ap ap2) {
        this.cu = ap2;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        ap.k(this.cu);
    }
}
