/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import java.util.function.Function;
import nomanssave.eY;
import nomanssave.gH;
import nomanssave.gt;

class gI
extends gt {
    final /* synthetic */ gH rq;
    private final /* synthetic */ boolean rr;
    private final /* synthetic */ int il;

    gI(gH gH2, Function function, eY eY2, int n, int n2, int n3, boolean bl, boolean bl2, boolean bl3, int n4) {
        this.rq = gH2;
        this.rr = bl3;
        this.il = n4;
        super(function, eY2, n, n2, n3, bl, bl2);
    }

    @Override
    public int dj() {
        if (this.rr) {
            return 3584;
        }
        return 0xE00 | gH.b(this.rq);
    }

    @Override
    public String toString() {
        return this.rq.dZ() ? "Ship " + this.il + " - Storage Sacs" : super.toString();
    }
}
