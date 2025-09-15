/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import javax.swing.JComponent;
import nomanssave.aH;
import nomanssave.bE;
import nomanssave.bJ;
import nomanssave.bK;
import nomanssave.bL;
import nomanssave.ba;
import nomanssave.gs;

class bN
extends ba {
    final /* synthetic */ bE ey;

    bN(bE bE2) {
        this.ey = bE2;
        super(aH.cJ, 0);
    }

    void a(String string, gs gs2) {
        this.a(string, gs2, true, null);
    }

    void a(String string, gs gs2, boolean bl, String string2) {
        bJ bJ2 = new bJ(this.ey, gs2, bl);
        if (string2 != null) {
            bJ2.setToolTipText(string2);
        }
        this.a(string, (JComponent)bJ2);
    }

    void a(String string, bK bK2) {
        this.a(string, bK2, true, null);
    }

    void a(String string, bK bK2, boolean bl, String string2) {
        bL bL2 = new bL(this.ey, bK2, bl);
        if (string2 != null) {
            bL2.setToolTipText(string2);
        }
        this.a(string, bL2);
    }
}
