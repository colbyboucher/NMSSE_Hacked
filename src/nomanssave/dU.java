/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import nomanssave.G;
import nomanssave.dN;
import nomanssave.gH;
import nomanssave.hg;

class dU
extends G {
    final /* synthetic */ dN ia;

    dU(dN dN2) {
        this.ia = dN2;
    }

    @Override
    protected String g(String string) {
        gH gH2 = (gH)dN.p(this.ia).getSelectedItem();
        if (gH2 == null) {
            return "";
        }
        try {
            string = hg.aB(string).toString();
            if (!string.equals(gH2.cK())) {
                gH2.aa(string);
            }
            return string;
        }
        catch (RuntimeException runtimeException) {
            return gH2.cK();
        }
    }
}
