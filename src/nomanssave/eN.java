/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import java.util.Comparator;
import nomanssave.eM;

class eN
implements Comparator {
    eN() {
    }

    public int a(eM eM2, eM eM3) {
        return eM2.name.compareTo(eM3.name);
    }

    public /* synthetic */ int compare(Object object, Object object2) {
        return this.a((eM)object, (eM)object2);
    }
}
