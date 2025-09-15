/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import nomanssave.G;
import nomanssave.dN;
import nomanssave.gH;
import nomanssave.hf;

class ea
extends G {
    final /* synthetic */ dN ia;

    ea(dN dN2) {
        this.ia = dN2;
    }

    @Override
    protected String g(String string) {
        gH gH2 = (gH)dN.p(this.ia).getSelectedItem();
        if (gH2 == null) {
            return "";
        }
        double d = gH2.cX();
        try {
            double d2 = hf.a(string, 0.0, 1000.0);
            if (d2 != d) {
                gH2.a(d2);
            }
            return Double.toString(d2);
        }
        catch (RuntimeException runtimeException) {
            return Double.toString(d);
        }
    }
}
