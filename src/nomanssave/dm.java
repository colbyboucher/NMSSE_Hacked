/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import nomanssave.G;
import nomanssave.dj;
import nomanssave.gv;
import nomanssave.hg;

class dm
extends G {
    final /* synthetic */ dj hl;

    dm(dj dj2) {
        this.hl = dj2;
    }

    @Override
    protected String g(String string) {
        gv gv2 = (gv)dj.j(this.hl).getSelectedItem();
        if (gv2 == null) {
            return "";
        }
        try {
            string = hg.aB(string).toString();
            if (!string.equals(gv2.cK())) {
                gv2.aa(string);
            }
            return string;
        }
        catch (RuntimeException runtimeException) {
            return gv2.cK();
        }
    }
}
