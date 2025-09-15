/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import java.util.ArrayList;
import nomanssave.Application;
import nomanssave.aH;
import nomanssave.fJ;
import nomanssave.fM;
import nomanssave.fO;
import nomanssave.fP;
import nomanssave.fn;
import nomanssave.fs;
import nomanssave.ft;
import nomanssave.hc;

class fN
implements ft {
    final int lT;
    final /* synthetic */ fJ mt;

    fN(fJ fJ2, int n) {
        this.mt = fJ2;
        this.lT = n;
    }

    @Override
    public int getIndex() {
        return this.lT;
    }

    @Override
    public boolean isEmpty() {
        return fJ.b(this.mt)[this.lT * 2] == null && fJ.b(this.mt)[this.lT * 2 + 1] == null;
    }

    @Override
    public fs[] bX() {
        hc.info("Loading saves for Slot " + (this.lT + 1) + "...");
        ArrayList<fM> arrayList = new ArrayList<fM>();
        if (fJ.b(this.mt)[this.lT * 2] != null) {
            arrayList.add(fJ.b(this.mt)[this.lT * 2]);
        }
        if (fJ.b(this.mt)[this.lT * 2 + 1] != null) {
            arrayList.add(fJ.b(this.mt)[this.lT * 2 + 1]);
        }
        aH.cG.listFiles(new fO(this, arrayList));
        arrayList.sort(new fP(this));
        return arrayList.toArray(new fs[0]);
    }

    @Override
    public fn L() {
        long l;
        long l2 = Long.MIN_VALUE;
        fn fn2 = null;
        if (fJ.b(this.mt)[this.lT * 2] != null) {
            fn2 = fJ.b(this.mt)[this.lT * 2].L();
            l2 = fJ.b(this.mt)[this.lT * 2].lastModified();
        }
        if (fJ.b(this.mt)[this.lT * 2 + 1] != null && (l = fJ.b(this.mt)[this.lT * 2 + 1].lastModified()) > l2) {
            fn2 = fJ.b(this.mt)[this.lT * 2 + 1].L();
            l2 = l;
        }
        return fn2;
    }

    public String toString() {
        long l;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Slot " + (this.lT + 1) + " - ");
        long l2 = Long.MIN_VALUE;
        String string = null;
        fn fn2 = null;
        if (fJ.b(this.mt)[this.lT * 2] != null) {
            fn2 = fJ.b(this.mt)[this.lT * 2].L();
            l2 = fJ.b(this.mt)[this.lT * 2].lastModified();
            string = fJ.b(this.mt)[this.lT * 2].getName();
        }
        if (fJ.b(this.mt)[this.lT * 2 + 1] != null && (l = fJ.b(this.mt)[this.lT * 2 + 1].lastModified()) > l2) {
            fn2 = fJ.b(this.mt)[this.lT * 2 + 1].L();
            l2 = l;
            string = fJ.b(this.mt)[this.lT * 2 + 1].getName();
        }
        if (fn2 != null) {
            stringBuilder.append(fn2.toString());
            if (string != null) {
                stringBuilder.append(" - " + string);
            } else {
                stringBuilder.append(" - " + Application.b(l2));
            }
        } else {
            stringBuilder.append("[EMPTY]");
        }
        return stringBuilder.toString();
    }

    static /* synthetic */ fJ a(fN fN2) {
        return fN2.mt;
    }
}
