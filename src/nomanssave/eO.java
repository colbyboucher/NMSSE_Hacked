/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import nomanssave.eM;

class eO {
    final String id;

    eO(String string) {
        this.id = string;
    }

    public boolean equals(Object object) {
        eM eM2 = (eM)object;
        if (eM2.jY) {
            return this.id.startsWith(String.valueOf(eM2.id) + "#");
        }
        return this.id.equals(eM2.id);
    }
}
