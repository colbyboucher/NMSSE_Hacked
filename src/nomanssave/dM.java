/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import nomanssave.G;
import nomanssave.dE;
import nomanssave.gE;
import nomanssave.gG;
import nomanssave.hf;

class dM
extends G {
    private final gG hH;
    final /* synthetic */ dE hE;

    private dM(dE dE2, gG gG2) {
        this.hE = dE2;
        this.hH = gG2;
    }

    @Override
    protected String g(String string) {
        gE gE2 = (gE)dE.a(this.hE).getSelectedItem();
        if (gE2 == null) {
            return "";
        }
        int n = gE2.aq(this.hH.ordinal());
        try {
            int n2 = hf.b(string, 0, this.hH.dY());
            if (n2 != n) {
                gE2.e(this.hH.ordinal(), n2);
            }
            return Integer.toString(n2);
        }
        catch (RuntimeException runtimeException) {
            return Integer.toString(n);
        }
    }

    /* synthetic */ dM(dE dE2, gG gG2, dM dM2) {
        this(dE2, gG2);
    }
}
