/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import javax.swing.JComboBox;
import nomanssave.dE;
import nomanssave.dK;
import nomanssave.dL;

class dJ
extends JComboBox {
    final /* synthetic */ dE hE;

    dJ(dE dE2) {
        this.hE = dE2;
        this.setModel(new dK(this));
        this.setRenderer(new dL(this));
    }
}
