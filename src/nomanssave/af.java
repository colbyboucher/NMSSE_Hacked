/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import nomanssave.G;
import nomanssave.X;
import nomanssave.gj;

class af
extends G {
    final /* synthetic */ X bV;

    af(X x) {
        this.bV = x;
    }

    @Override
    protected String g(String string) {
        gj gj2 = (gj)X.k(this.bV).getSelectedItem();
        if (gj2 == null) {
            return "";
        }
        if (!(string = string.trim()).equals(gj2.cO())) {
            gj2.ac(string);
            X.f(this.bV).setText(string);
        }
        return string;
    }
}
