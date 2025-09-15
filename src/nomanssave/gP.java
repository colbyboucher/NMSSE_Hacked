/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import java.util.function.Function;
import nomanssave.eY;
import nomanssave.gO;
import nomanssave.gt;

class gP
extends gt {
    final /* synthetic */ gO rP;
    private final /* synthetic */ boolean rr;
    private final /* synthetic */ int rQ;

    gP(gO gO2, Function function, eY eY2, int n, int n2, int n3, boolean bl, boolean bl2, boolean bl3, boolean bl4, boolean bl5, int n4) {
        this.rP = gO2;
        this.rr = bl5;
        this.rQ = n4;
        super(function, eY2, n, n2, n3, bl, bl2, bl3, bl4);
    }

    @Override
    public int dj() {
        if (this.rr) {
            return 3584;
        }
        return 0xE00 | this.rQ;
    }
}
