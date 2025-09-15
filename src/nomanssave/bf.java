/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import nomanssave.G;
import nomanssave.bd;

class bf
extends G {
    final /* synthetic */ bd dP;

    bf(bd bd2) {
        this.dP = bd2;
    }

    @Override
    protected String g(String string) {
        if (bd.a(this.dP) == null) {
            return "";
        }
        try {
            string = string.trim();
            if (!string.equals(bd.a(this.dP).cU())) {
                bd.a(this.dP).ah(string);
                bd.c(this.dP).setText(string);
            }
            return string;
        }
        catch (RuntimeException runtimeException) {
            return bd.a(this.dP).cU();
        }
    }
}
