/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import nomanssave.G;
import nomanssave.cg;
import nomanssave.hf;

class ci
extends G {
    final /* synthetic */ cg fF;

    ci(cg cg2) {
        this.fF = cg2;
    }

    @Override
    protected String g(String string) {
        if (cg.d(this.fF) == null) {
            return "";
        }
        try {
            int n = hf.b(string, 1, cg.b(this.fF).dB());
            if (cg.d(this.fF) != n) {
                cg.b(this.fF).aA(n);
                cg.b(this.fF, new Integer(n));
            }
        }
        catch (RuntimeException runtimeException) {
            // empty catch block
        }
        return cg.d(this.fF).toString();
    }
}
