/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import nomanssave.G;
import nomanssave.dE;
import nomanssave.gE;

class dG
extends G {
    final /* synthetic */ dE hE;

    dG(dE dE2) {
        this.hE = dE2;
    }

    @Override
    protected String g(String string) {
        gE gE2 = (gE)dE.a(this.hE).getSelectedItem();
        if (gE2 == null) {
            return "";
        }
        if (!(string = string.trim()).equals(gE2.getName())) {
            gE2.setName(string);
            dE.c(this.hE).setText(string);
        }
        return string;
    }
}
