/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import nomanssave.G;
import nomanssave.bl;
import nomanssave.hg;

class by
extends G {
    final /* synthetic */ bl er;

    by(bl bl2) {
        this.er = bl2;
    }

    @Override
    protected String g(String string) {
        if (bl.b(this.er) < 0) {
            return "";
        }
        try {
            string = hg.aB(string).toString();
            if (!string.equals(bl.c(this.er)[bl.b(this.er)].cV())) {
                bl.c(this.er)[bl.b(this.er)].ai(string);
            }
            return string;
        }
        catch (RuntimeException runtimeException) {
            return bl.c(this.er)[bl.b(this.er)].cV();
        }
    }
}
