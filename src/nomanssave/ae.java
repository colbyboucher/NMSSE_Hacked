/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import nomanssave.G;
import nomanssave.X;
import nomanssave.gj;

class ae
extends G {
    final /* synthetic */ X bV;

    ae(X x) {
        this.bV = x;
    }

    @Override
    protected String g(String string) {
        gj gj2 = (gj)X.k(this.bV).getSelectedItem();
        if (gj2 == null) {
            return "";
        }
        if (!(string = string.trim()).equals(gj2.cN())) {
            gj2.ab(string);
            X.e(this.bV).setText(string);
        }
        return string;
    }
}
