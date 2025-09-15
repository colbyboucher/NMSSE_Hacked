/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import java.util.ArrayList;
import nomanssave.eF;

class eE
extends ArrayList {
    private eE() {
    }

    public boolean add(String string, String string2) {
        return this.add(new eF(string, string2));
    }

    public boolean s(String string) {
        if (this.size() == 0) {
            return false;
        }
        eF eF2 = (eF)this.get(0);
        return eF2.key.equals(string) || eF2.name.equals(string);
    }

    public eF t(String string) {
        for (eF eF2 : this) {
            if (!eF2.key.equals(string)) continue;
            return eF2;
        }
        return null;
    }

    public eF u(String string) {
        for (eF eF2 : this) {
            if (!eF2.name.equals(string)) continue;
            return eF2;
        }
        return null;
    }

    public eF v(String string) {
        for (eF eF2 : this) {
            if (!eF2.name.equalsIgnoreCase(string)) continue;
            return eF2;
        }
        return null;
    }

    /* synthetic */ eE(eE eE2) {
        this();
    }

    /* synthetic */ eE(eE eE2, eE eE3) {
        this();
    }
}
