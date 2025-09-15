/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import nomanssave.eG;
import nomanssave.eY;
import nomanssave.fA;
import nomanssave.fH;
import nomanssave.fr;

class fB
extends fH
implements fr {
    final /* synthetic */ fA ma;

    fB(fA fA2) {
        this.ma = fA2;
        super(fA2, "savedata00.hg", true);
    }

    @Override
    public eY M() {
        return fA.b(this.readBytes(), eG.jW);
    }

    @Override
    public void k(eY eY2) {
        this.a("ps4_accountdata", null, null, null);
        this.writeBytes(fA.l(eY2));
    }
}
