/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import java.util.ArrayList;
import nomanssave.Application;
import nomanssave.aH;
import nomanssave.fA;
import nomanssave.fD;
import nomanssave.fF;
import nomanssave.fG;
import nomanssave.fn;
import nomanssave.fs;
import nomanssave.ft;
import nomanssave.hc;

class fE
implements ft {
    final int lT;
    final /* synthetic */ fA ma;

    fE(fA fA2, int n) {
        this.ma = fA2;
        this.lT = n;
    }

    @Override
    public int getIndex() {
        return this.lT;
    }

    @Override
    public boolean isEmpty() {
        return fA.b(this.ma)[this.lT * 2] == null && fA.b(this.ma)[this.lT * 2 + 1] == null;
    }

    @Override
    public fs[] bX() {
        hc.info("Loading saves for Slot " + (this.lT + 1) + "...");
        ArrayList<fD> arrayList = new ArrayList<fD>();
        if (fA.b(this.ma)[this.lT * 2] != null) {
            arrayList.add(fA.b(this.ma)[this.lT * 2]);
        }
        if (fA.b(this.ma)[this.lT * 2 + 1] != null) {
            arrayList.add(fA.b(this.ma)[this.lT * 2 + 1]);
        }
        aH.cG.listFiles(new fF(this, arrayList));
        arrayList.sort(new fG(this));
        return arrayList.toArray(new fs[0]);
    }

    @Override
    public fn L() {
        long l;
        long l2 = Long.MIN_VALUE;
        fn fn2 = null;
        if (fA.b(this.ma)[this.lT * 2] != null) {
            fn2 = fA.b(this.ma)[this.lT * 2].L();
            l2 = fA.b(this.ma)[this.lT * 2].lastModified();
        }
        if (fA.b(this.ma)[this.lT * 2 + 1] != null && (l = fA.b(this.ma)[this.lT * 2 + 1].lastModified()) > l2) {
            fn2 = fA.b(this.ma)[this.lT * 2 + 1].L();
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
        if (fA.b(this.ma)[this.lT * 2] != null) {
            fn2 = fA.b(this.ma)[this.lT * 2].L();
            l2 = fA.b(this.ma)[this.lT * 2].lastModified();
        }
        if (fA.b(this.ma)[this.lT * 2 + 1] != null && (l = fA.b(this.ma)[this.lT * 2 + 1].lastModified()) > l2) {
            fn2 = fA.b(this.ma)[this.lT * 2 + 1].L();
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

    static /* synthetic */ fA a(fE fE2) {
        return fE2.ma;
    }
}
