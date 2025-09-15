/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import nomanssave.eG;
import nomanssave.eY;
import nomanssave.fJ;
import nomanssave.fQ;
import nomanssave.fr;

class fK
extends fQ
implements fr {
    final /* synthetic */ fJ mt;

    fK(fJ fJ2) {
        this.mt = fJ2;
        super(fJ2, "accountdata.hg", -1, true);
    }

    @Override
    public eY M() {
        return this.a(eG.jW);
    }

    @Override
    public void k(eY eY2) {
        this.a("accountdata", null, null, null);
        this.a(eY2, false);
    }
}
