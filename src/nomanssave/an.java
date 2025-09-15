/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import nomanssave.aj;

class an
implements ActionListener {
    final /* synthetic */ aj cg;

    an(aj aj2) {
        this.cg = aj2;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        this.cg.setVisible(false);
    }
}
