/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import nomanssave.eV;
import nomanssave.fh;

public class eW {
    final eV kE = new eV();

    public eW h(Object object) {
        if (object != null && !fh.a(object.getClass())) {
            throw new RuntimeException("Unsupported type: " + object.getClass().getSimpleName());
        }
        this.kE.e(object);
        return this;
    }

    public eV bC() {
        return this.kE;
    }
}
