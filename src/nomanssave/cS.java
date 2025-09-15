/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import nomanssave.cN;
import nomanssave.gD;

class cS
implements gD {
    final String filename;
    final int index;
    final /* synthetic */ cN gt;

    cS(cN cN2, String string) {
        this.gt = cN2;
        this.filename = string;
        this.index = cN.a(cN2).size() + 1;
    }

    @Override
    public String K() {
        return this.filename;
    }

    public String toString() {
        return "Unknown " + this.index;
    }
}
