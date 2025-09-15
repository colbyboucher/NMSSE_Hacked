/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import java.util.Comparator;
import nomanssave.eI;

class eJ
implements Comparator {
    eJ() {
    }

    public int a(eI eI2, eI eI3) {
        return eI2.name.compareTo(eI3.name);
    }

    public /* synthetic */ int compare(Object object, Object object2) {
        return this.a((eI)object, (eI)object2);
    }
}
