/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import nomanssave.G;
import nomanssave.dj;
import nomanssave.gv;

class dl
extends G {
    final /* synthetic */ dj hl;

    dl(dj dj2) {
        this.hl = dj2;
    }

    @Override
    protected String g(String string) {
        gv gv2 = (gv)dj.j(this.hl).getSelectedItem();
        if (gv2 == null) {
            return "";
        }
        if (!(string = string.trim()).equals(gv2.getName())) {
            gv2.setName(string);
            dj.b(this.hl).setText(string);
        }
        return string;
    }
}
