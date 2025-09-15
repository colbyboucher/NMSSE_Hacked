/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import nomanssave.G;
import nomanssave.bl;
import nomanssave.hf;

class bo
extends G {
    final /* synthetic */ bl er;

    bo(bl bl2) {
        this.er = bl2;
    }

    @Override
    protected String g(String string) {
        if (bl.b(this.er) < 0) {
            return "";
        }
        int n = bl.c(this.er)[bl.b(this.er)].dd();
        try {
            int n2 = hf.b(string, 0, Integer.MAX_VALUE);
            if (n2 != n) {
                bl.c(this.er)[bl.b(this.er)].at(n2);
            }
            return Integer.toString(n2);
        }
        catch (RuntimeException runtimeException) {
            return Integer.toString(n);
        }
    }
}
