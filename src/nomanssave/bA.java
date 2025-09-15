/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import nomanssave.G;
import nomanssave.bl;
import nomanssave.hf;

class bA
extends G {
    private final int index;
    final /* synthetic */ bl er;

    private bA(bl bl2, int n) {
        this.er = bl2;
        this.index = n;
    }

    @Override
    protected String g(String string) {
        if (bl.b(this.er) < 0) {
            return "";
        }
        int n = bl.c(this.er)[bl.b(this.er)].aq(this.index);
        try {
            int n2 = hf.b(string, 0, 50);
            if (n2 != n) {
                bl.c(this.er)[bl.b(this.er)].e(this.index, n2);
            }
            return Integer.toString(n2);
        }
        catch (RuntimeException runtimeException) {
            return Integer.toString(n);
        }
    }

    /* synthetic */ bA(bl bl2, int n, bA bA2) {
        this(bl2, n);
    }
}
