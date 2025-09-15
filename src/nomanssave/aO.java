/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import nomanssave.G;
import nomanssave.aJ;
import nomanssave.hf;

class aO
extends G {
    final /* synthetic */ aJ dj;

    aO(aJ aJ2) {
        this.dj = aJ2;
    }

    @Override
    protected String g(String string) {
        if (aJ.a(this.dj) == null) {
            return "";
        }
        long l = aJ.a(this.dj).dK();
        try {
            long l2 = hf.a(string, 0L, 0xFFFFFFFFL);
            if (l2 != l) {
                aJ.a(this.dj).f(l2);
            }
            return Long.toString(l2);
        }
        catch (RuntimeException runtimeException) {
            return Long.toString(l);
        }
    }
}
