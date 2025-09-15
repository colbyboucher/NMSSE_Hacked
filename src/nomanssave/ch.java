/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import nomanssave.G;
import nomanssave.cg;
import nomanssave.hf;

class ch
extends G {
    final /* synthetic */ cg fF;

    ch(cg cg2) {
        this.fF = cg2;
    }

    @Override
    protected String g(String string) {
        if (cg.a(this.fF) == null) {
            return "";
        }
        try {
            int n = hf.b(string, 0, 99999);
            if (cg.a(this.fF) != n) {
                cg.b(this.fF).m(cg.c(this.fF).M(n));
                cg.a(this.fF, new Integer(n));
            }
        }
        catch (RuntimeException runtimeException) {
            // empty catch block
        }
        return cg.a(this.fF).toString();
    }
}
