/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import nomanssave.G;
import nomanssave.X;
import nomanssave.gj;

class ac
extends G {
    final /* synthetic */ X bV;

    ac(X x) {
        this.bV = x;
    }

    @Override
    protected String g(String string) {
        gj gj2 = (gj)X.k(this.bV).getSelectedItem();
        if (gj2 == null) {
            return "";
        }
        if (!(string = string.trim()).equals(gj2.getName())) {
            gj2.setName(string);
            X.c(this.bV).setText(string);
        }
        return string;
    }
}
