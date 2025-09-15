/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import nomanssave.G;
import nomanssave.dN;
import nomanssave.gH;

class dT
extends G {
    final /* synthetic */ dN ia;

    dT(dN dN2) {
        this.ia = dN2;
    }

    @Override
    protected String g(String string) {
        gH gH2 = (gH)dN.p(this.ia).getSelectedItem();
        if (gH2 == null) {
            return "";
        }
        if (!(string = string.trim()).equals(gH2.getName())) {
            gH2.setName(string);
            dN.b(this.ia).setText(string);
        }
        return string;
    }
}
