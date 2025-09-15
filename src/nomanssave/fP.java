/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import java.util.Comparator;
import nomanssave.fN;
import nomanssave.fs;

class fP
implements Comparator {
    final /* synthetic */ fN mw;

    fP(fN fN2) {
        this.mw = fN2;
    }

    public int a(fs fs2, fs fs3) {
        long l = fs3.lastModified() - fs2.lastModified();
        if (l < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        if (l > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        return (int)l;
    }

    public /* synthetic */ int compare(Object object, Object object2) {
        return this.a((fs)object, (fs)object2);
    }
}
