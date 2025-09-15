/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import nomanssave.G;
import nomanssave.aJ;
import nomanssave.hf;

class aK
extends G {
    final /* synthetic */ aJ dj;

    aK(aJ aJ2) {
        this.dj = aJ2;
    }

    @Override
    protected String g(String string) {
        if (aJ.a(this.dj) == null) {
            return "";
        }
        int n = aJ.a(this.dj).dM();
        try {
            int n2 = hf.b(string, 1, 200);
            if (n2 != n) {
                aJ.a(this.dj).aB(n2);
            }
            return Integer.toString(n2);
        }
        catch (RuntimeException runtimeException) {
            return Integer.toString(n);
        }
    }
}
