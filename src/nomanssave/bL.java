/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import javax.swing.JTextField;
import nomanssave.bE;
import nomanssave.bK;
import nomanssave.bM;

class bL
extends JTextField {
    final bK eB;
    final /* synthetic */ bE ey;

    bL(bE bE2, bK bK2, boolean bl) {
        this.ey = bE2;
        this.eB = bK2;
        this.setEnabled(bl);
        this.addFocusListener(new bM(this, bK2));
    }

    void ac() {
        String string = bE.a(this.ey) == null ? "" : this.eB.ab();
        this.setText(string);
    }

    static /* synthetic */ bE a(bL bL2) {
        return bL2.ey;
    }
}
