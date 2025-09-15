/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import nomanssave.cg;

class cj
implements ActionListener {
    final /* synthetic */ cg fF;

    cj(cg cg2) {
        this.fF = cg2;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        cg.fE.setVisible(false);
    }
}
