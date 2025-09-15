/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import nomanssave.bE;
import nomanssave.bK;

class bF
implements bK {
    final /* synthetic */ bE ey;

    bF(bE bE2) {
        this.ey = bE2;
    }

    @Override
    public String getID() {
        return "ExtremeSurvival";
    }

    @Override
    public boolean isSpecial() {
        return false;
    }

    @Override
    public String ab() {
        return Double.toString(bE.a(this.ey).dT());
    }

    @Override
    public void l(String string) {
        double d = Double.parseDouble(string);
        bE.a(this.ey).g(d);
    }
}
