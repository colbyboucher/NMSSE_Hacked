/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import nomanssave.eY;
import nomanssave.fh;

public class fa {
    final eY kM = new eY();

    public fa d(String string, Object object) {
        if (string == null) {
            throw new NullPointerException();
        }
        if (!eY.bF().matcher(string).matches()) {
            throw new RuntimeException("Invalid name: " + string);
        }
        if (object != null && !fh.a(object.getClass())) {
            throw new RuntimeException("Unsupported type: " + object.getClass().getSimpleName());
        }
        this.kM.a(string, object);
        return this;
    }

    public eY bH() {
        return this.kM;
    }
}
