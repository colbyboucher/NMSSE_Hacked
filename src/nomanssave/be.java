/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import nomanssave.G;
import nomanssave.bd;

class be
extends G {
    final /* synthetic */ bd dP;

    be(bd bd2) {
        this.dP = bd2;
    }

    @Override
    protected String g(String string) {
        if (bd.a(this.dP) == null) {
            return "";
        }
        if (!(string = string.trim()).equals(bd.a(this.dP).getName())) {
            bd.a(this.dP).setName(string);
            bd.b(this.dP).setText(string);
        }
        return string;
    }
}
