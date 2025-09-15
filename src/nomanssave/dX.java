/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import nomanssave.G;
import nomanssave.dN;
import nomanssave.hf;

class dX
extends G {
    final /* synthetic */ dN ia;

    dX(dN dN2) {
        this.ia = dN2;
    }

    @Override
    protected String g(String string) {
        if (dN.o(this.ia) == null) {
            return "";
        }
        int n = dN.o(this.ia).dN();
        try {
            int n2 = hf.b(string, 1, 200);
            if (n2 != n) {
                dN.o(this.ia).aC(n2);
            }
            return Integer.toString(n2);
        }
        catch (RuntimeException runtimeException) {
            return Integer.toString(n);
        }
    }
}
