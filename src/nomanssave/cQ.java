/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import nomanssave.cN;
import nomanssave.cS;

class cQ {
    final String value;
    final /* synthetic */ cN gt;

    cQ(cN cN2, String string) {
        this.gt = cN2;
        this.value = string;
    }

    public boolean equals(Object object) {
        if (object instanceof String) {
            return this.value.equals(object);
        }
        if (object instanceof cS) {
            return this.value.equals(((cS)object).filename);
        }
        return super.equals(object);
    }
}
