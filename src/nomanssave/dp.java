/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import nomanssave.G;
import nomanssave.dj;
import nomanssave.gv;
import nomanssave.hf;

class dp
extends G {
    final /* synthetic */ dj hl;

    dp(dj dj2) {
        this.hl = dj2;
    }

    @Override
    protected String g(String string) {
        gv gv2 = (gv)dj.j(this.hl).getSelectedItem();
        if (gv2 == null) {
            return "";
        }
        double d = gv2.dH();
        try {
            double d2 = hf.a(string, 0.0, 1000.0);
            if (d2 != d) {
                gv2.f(d2);
            }
            return Double.toString(d2);
        }
        catch (RuntimeException runtimeException) {
            return Double.toString(d);
        }
    }
}
