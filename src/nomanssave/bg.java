/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import nomanssave.G;
import nomanssave.bd;
import nomanssave.hg;

class bg
extends G {
    final /* synthetic */ bd dP;

    bg(bd bd2) {
        this.dP = bd2;
    }

    @Override
    protected String g(String string) {
        if (bd.a(this.dP) == null) {
            return "";
        }
        try {
            string = hg.aB(string).toString();
            if (!string.equals(bd.a(this.dP).cV())) {
                bd.a(this.dP).ai(string);
            }
            return string;
        }
        catch (RuntimeException runtimeException) {
            return bd.a(this.dP).cV();
        }
    }
}
