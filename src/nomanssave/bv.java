/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import nomanssave.G;
import nomanssave.bl;

class bv
extends G {
    final /* synthetic */ bl er;

    bv(bl bl2) {
        this.er = bl2;
    }

    @Override
    protected String g(String string) {
        if (bl.b(this.er) < 0) {
            return "";
        }
        if (!(string = string.trim()).equals(bl.c(this.er)[bl.b(this.er)].getName())) {
            bl.c(this.er)[bl.b(this.er)].setName(string);
            bl.j(this.er).setText(string);
            bl.e(this.er).updateUI();
        }
        return string;
    }
}
