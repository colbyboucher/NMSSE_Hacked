/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import nomanssave.G;
import nomanssave.bd;
import nomanssave.hf;

class bh
extends G {
    final /* synthetic */ bd dP;

    bh(bd bd2) {
        this.dP = bd2;
    }

    @Override
    protected String g(String string) {
        if (bd.a(this.dP) == null) {
            return "";
        }
        double d = bd.a(this.dP).cX();
        try {
            double d2 = hf.a(string, 0.0, 1000.0);
            if (d2 != d) {
                bd.a(this.dP).a(d2);
            }
            return Double.toString(d2);
        }
        catch (RuntimeException runtimeException) {
            return Double.toString(d);
        }
    }
}
