/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import nomanssave.G;
import nomanssave.bl;

class bx
extends G {
    final /* synthetic */ bl er;

    bx(bl bl2) {
        this.er = bl2;
    }

    @Override
    protected String g(String string) {
        if (bl.b(this.er) < 0) {
            return "";
        }
        try {
            string = string.trim();
            if (!string.equals(bl.c(this.er)[bl.b(this.er)].cU())) {
                bl.c(this.er)[bl.b(this.er)].ah(string);
                bl.n(this.er).setText(string);
            }
            return string;
        }
        catch (RuntimeException runtimeException) {
            return bl.c(this.er)[bl.b(this.er)].cU();
        }
    }
}
