/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import java.util.ArrayList;
import nomanssave.Application;
import nomanssave.aH;
import nomanssave.fT;
import nomanssave.fY;
import nomanssave.fn;
import nomanssave.fs;
import nomanssave.ft;
import nomanssave.ga;
import nomanssave.gb;
import nomanssave.hc;

class fZ
implements ft {
    final int lT;
    final /* synthetic */ fT mN;

    fZ(fT fT2, int n) {
        this.mN = fT2;
        this.lT = n;
    }

    @Override
    public int getIndex() {
        return this.lT;
    }

    @Override
    public boolean isEmpty() {
        return fT.b(this.mN)[this.lT * 2] == null && fT.b(this.mN)[this.lT * 2 + 1] == null;
    }

    @Override
    public fs[] bX() {
        hc.info("Loading saves for Slot " + (this.lT + 1) + "...");
        ArrayList<fY> arrayList = new ArrayList<fY>();
        if (fT.b(this.mN)[this.lT * 2] != null) {
            arrayList.add(fT.b(this.mN)[this.lT * 2]);
        }
        if (fT.b(this.mN)[this.lT * 2 + 1] != null) {
            arrayList.add(fT.b(this.mN)[this.lT * 2 + 1]);
        }
        aH.cG.listFiles(new ga(this, arrayList));
        arrayList.sort(new gb(this));
        return arrayList.toArray(new fs[0]);
    }

    @Override
    public fn L() {
        long l;
        long l2 = Long.MIN_VALUE;
        fn fn2 = null;
        if (fT.b(this.mN)[this.lT * 2] != null) {
            fn2 = fT.b(this.mN)[this.lT * 2].L();
            l2 = fT.b(this.mN)[this.lT * 2].lastModified();
        }
        if (fT.b(this.mN)[this.lT * 2 + 1] != null && (l = fT.b(this.mN)[this.lT * 2 + 1].lastModified()) > l2) {
            fn2 = fT.b(this.mN)[this.lT * 2 + 1].L();
            l2 = l;
        }
        return fn2;
    }

    public String toString() {
        long l;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Slot " + (this.lT + 1) + " - ");
        long l2 = Long.MIN_VALUE;
        fn fn2 = null;
        if (fT.b(this.mN)[this.lT * 2] != null) {
            fn2 = fT.b(this.mN)[this.lT * 2].L();
            l2 = fT.b(this.mN)[this.lT * 2].lastModified();
        }
        if (fT.b(this.mN)[this.lT * 2 + 1] != null && (l = fT.b(this.mN)[this.lT * 2 + 1].lastModified()) > l2) {
            fn2 = fT.b(this.mN)[this.lT * 2 + 1].L();
            l2 = l;
        }
        if (fn2 != null) {
            stringBuilder.append(fn2.toString());
            stringBuilder.append(" - " + Application.b(l2));
        } else {
            stringBuilder.append("[EMPTY]");
        }
        return stringBuilder.toString();
    }

    static /* synthetic */ fT a(fZ fZ2) {
        return fZ2.mN;
    }
}
