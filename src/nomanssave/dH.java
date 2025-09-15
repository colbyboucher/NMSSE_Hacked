/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import nomanssave.G;
import nomanssave.dE;
import nomanssave.gE;
import nomanssave.hg;

class dH
extends G {
    final /* synthetic */ dE hE;

    dH(dE dE2) {
        this.hE = dE2;
    }

    @Override
    protected String g(String string) {
        gE gE2 = (gE)dE.a(this.hE).getSelectedItem();
        if (gE2 == null) {
            return "";
        }
        try {
            string = hg.aB(string).toString();
            if (!string.equals(gE2.cK())) {
                gE2.aa(string);
            }
            return string;
        }
        catch (RuntimeException runtimeException) {
            return gE2.cK();
        }
    }
}
