/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import nomanssave.eG;
import nomanssave.eY;
import nomanssave.fT;
import nomanssave.fX;
import nomanssave.fr;

class fU
extends fX
implements fr {
    final /* synthetic */ fT mN;

    fU(fT fT2) {
        this.mN = fT2;
        super(fT2, "AccountData");
    }

    @Override
    public eY M() {
        return this.a(eG.jW);
    }

    @Override
    public void k(eY eY2) {
        this.a("msaccountdata", null);
        this.h(eY2);
    }
}
