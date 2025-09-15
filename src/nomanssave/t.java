/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import nomanssave.p;

class t
implements ActionListener {
    final /* synthetic */ p I;

    t(p p2) {
        this.I = p2;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        this.I.setVisible(false);
    }
}
