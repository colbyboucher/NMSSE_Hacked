/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import nomanssave.X;
import nomanssave.gj;

class ah
implements ActionListener {
    final /* synthetic */ X bV;

    ah(X x) {
        this.bV = x;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        gj gj2 = (gj)X.k(this.bV).getSelectedItem();
        if (gj2 == null) {
            return;
        }
        if (X.h(this.bV).isSelected() ^ gj2.cQ()) {
            gj2.d(X.h(this.bV).isSelected());
        }
    }
}
