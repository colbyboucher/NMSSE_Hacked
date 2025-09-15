/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import java.util.Comparator;
import nomanssave.fs;
import nomanssave.fy;

class fz
implements Comparator {
    final /* synthetic */ fy lU;

    fz(fy fy2) {
        this.lU = fy2;
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
