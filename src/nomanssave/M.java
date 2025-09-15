/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import nomanssave.G;
import nomanssave.I;
import nomanssave.gf;

class M
extends G {
    final /* synthetic */ I bt;

    M(I i) {
        this.bt = i;
    }

    @Override
    protected String g(String string) {
        gf gf2 = (gf)I.j(this.bt).getSelectedItem();
        if (gf2 == null) {
            return "";
        }
        if (!(string = string.trim()).equals(gf2.getName())) {
            gf2.setName(string);
            I.f(this.bt).setText(string);
        }
        return string;
    }
}
