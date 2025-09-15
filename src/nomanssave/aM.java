/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import nomanssave.G;
import nomanssave.aJ;
import nomanssave.hf;

class aM
extends G {
    final /* synthetic */ aJ dj;

    aM(aJ aJ2) {
        this.dj = aJ2;
    }

    @Override
    protected String g(String string) {
        if (aJ.a(this.dj) == null) {
            return "";
        }
        int n = aJ.a(this.dj).dO();
        try {
            int n2 = hf.b(string, 0, 100);
            if (n2 != n) {
                aJ.a(this.dj).aD(n2);
            }
            return Integer.toString(n2);
        }
        catch (RuntimeException runtimeException) {
            return Integer.toString(n);
        }
    }
}
