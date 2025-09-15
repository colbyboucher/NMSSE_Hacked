/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import nomanssave.eY;

public class gB {
    private final eY oI;

    public static gB x(eY eY2) {
        return new gB(eY2);
    }

    private gB(eY eY2) {
        this.oI = eY2;
    }

    public int dU() {
        return this.oI.J("ActiveMultioolIndex");
    }

    public void aF(int n) {
        eY eY2 = this.oI.H("Multitools[" + n + "]");
        if (eY2 == null || !eY2.M("Seed[0]")) {
            throw new RuntimeException("Cannot set current multitool");
        }
        this.oI.b("ActiveMultioolIndex", n);
        this.oI.b("WeaponInventory", (Object)eY2.H("Store").bE());
        this.oI.b("CurrentWeapon.GenerationSeed[1]", eY2.I("Seed[1]"));
        this.oI.b("CurrentWeapon.Filename", eY2.getValueAsString("Resource.Filename"));
    }
}
