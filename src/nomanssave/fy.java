/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import java.util.ArrayList;
import nomanssave.Application;
import nomanssave.fn;
import nomanssave.fs;
import nomanssave.ft;
import nomanssave.fu;
import nomanssave.fx;
import nomanssave.fz;
import nomanssave.hc;

class fy
implements ft {
    final int lT;
    final /* synthetic */ fu lJ;

    fy(fu fu2, int n) {
        this.lJ = fu2;
        this.lT = n;
    }

    @Override
    public int getIndex() {
        return this.lT;
    }

    @Override
    public boolean isEmpty() {
        return fu.a(this.lJ)[this.lT * 2] == null && fu.a(this.lJ)[this.lT * 2 + 1] == null;
    }

    @Override
    public fn L() {
        long l;
        long l2 = Long.MIN_VALUE;
        fn fn2 = null;
        if (fu.a(this.lJ)[this.lT * 2] != null) {
            fn2 = fu.a(this.lJ)[this.lT * 2].L();
            l2 = fu.a(this.lJ)[this.lT * 2].lastModified();
        }
        if (fu.a(this.lJ)[this.lT * 2 + 1] != null && (l = fu.a(this.lJ)[this.lT * 2 + 1].lastModified()) > l2) {
            fn2 = fu.a(this.lJ)[this.lT * 2 + 1].L();
            l2 = l;
        }
        return fn2;
    }

    @Override
    public fs[] bX() {
        hc.info("Loading saves for Slot " + (this.lT + 1) + "...");
        ArrayList<fx> arrayList = new ArrayList<fx>();
        if (fu.a(this.lJ)[this.lT * 2] != null) {
            arrayList.add(fu.a(this.lJ)[this.lT * 2]);
        }
        if (fu.a(this.lJ)[this.lT * 2 + 1] != null) {
            arrayList.add(fu.a(this.lJ)[this.lT * 2 + 1]);
        }
        arrayList.sort(new fz(this));
        return arrayList.toArray(new fs[0]);
    }

    public String toString() {
        long l;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Slot " + (this.lT + 1) + " - ");
        long l2 = Long.MIN_VALUE;
        fn fn2 = null;
        if (fu.a(this.lJ)[this.lT * 2] != null) {
            fn2 = fu.a(this.lJ)[this.lT * 2].L();
            l2 = fu.a(this.lJ)[this.lT * 2].lastModified();
        }
        if (fu.a(this.lJ)[this.lT * 2 + 1] != null && (l = fu.a(this.lJ)[this.lT * 2 + 1].lastModified()) > l2) {
            fn2 = fu.a(this.lJ)[this.lT * 2 + 1].L();
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
}
