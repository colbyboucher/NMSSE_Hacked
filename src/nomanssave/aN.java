/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import nomanssave.Application;
import nomanssave.G;
import nomanssave.aJ;
import nomanssave.hf;

class aN
extends G {
    final /* synthetic */ aJ dj;
    private final /* synthetic */ Application bv;

    aN(aJ aJ2, Application application) {
        this.dj = aJ2;
        this.bv = application;
    }

    @Override
    protected String g(String string) {
        if (aJ.a(this.dj) == null) {
            return "";
        }
        long l = aJ.a(this.dj).dJ();
        try {
            long l2 = hf.a(string, 0L, 0xFFFFFFFFL);
            if (l2 != l) {
                aJ.a(this.dj).e(l2);
                this.bv.C();
            }
            return Long.toString(l2);
        }
        catch (RuntimeException runtimeException) {
            return Long.toString(l);
        }
    }
}
