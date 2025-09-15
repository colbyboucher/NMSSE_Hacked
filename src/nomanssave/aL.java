/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import nomanssave.G;
import nomanssave.aJ;
import nomanssave.hf;

class aL
extends G {
    final /* synthetic */ aJ dj;

    aL(aJ aJ2) {
        this.dj = aJ2;
    }

    @Override
    protected String g(String string) {
        if (aJ.a(this.dj) == null) {
            return "";
        }
        int n = aJ.a(this.dj).dN();
        try {
            int n2 = hf.b(string, 0, 100);
            if (n2 != n) {
                aJ.a(this.dj).aC(n2);
            }
            return Integer.toString(n2);
        }
        catch (RuntimeException runtimeException) {
            return Integer.toString(n);
        }
    }
}
