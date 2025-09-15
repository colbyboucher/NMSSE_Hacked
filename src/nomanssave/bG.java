/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import nomanssave.bE;
import nomanssave.bK;
import nomanssave.eU;

class bG
implements bK {
    final /* synthetic */ bE ey;

    bG(bE bE2) {
        this.ey = bE2;
    }

    @Override
    public String getID() {
        return "TWordsLearnt";
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

    @Override
    public String ab() {
        return Integer.toString(bE.a(this.ey).b(eU.kr));
    }

    @Override
    public void l(String string) {
        throw new RuntimeException("Cannot set words learnt");
    }
}
