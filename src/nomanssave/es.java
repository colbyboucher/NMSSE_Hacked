/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import java.util.Comparator;
import nomanssave.er;

class es
implements Comparator {
    es() {
    }

    public int a(er er2, er er3) {
        return er2.name.compareTo(er3.name);
    }

    public /* synthetic */ int compare(Object object, Object object2) {
        return this.a((er)object, (er)object2);
    }
}
