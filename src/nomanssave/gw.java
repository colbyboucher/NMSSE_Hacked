/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import nomanssave.eY;
import nomanssave.gv;
import nomanssave.gx;

public class gw
extends gv {
    private final eY oI;

    gw(eY eY2, eY eY3) {
        super(0, null, eY3);
        this.oI = eY2;
    }

    @Override
    public String getName() {
        return this.oI.getValueAsString("PlayerWeaponName");
    }

    @Override
    public void setName(String string) {
        this.oI.b("PlayerWeaponName", string);
    }

    @Override
    public String cT() {
        return gx.qH.K();
    }

    @Override
    public void ag(String string) {
        if (!gx.qH.K().equals(string)) {
            throw new RuntimeException("Only standard types allowed");
        }
    }

    public gx dI() {
        return gx.qH;
    }

    public void a(gx gx2) {
        if (gx2 != gx.qH) {
            throw new RuntimeException("Only standard types allowed");
        }
    }

    @Override
    public String cK() {
        return this.oI.d("CurrentWeapon.GenerationSeed").X(1);
    }

    @Override
    public void aa(String string) {
        this.oI.d("CurrentWeapon.GenerationSeed").a(1, string);
    }

    @Override
    public String cW() {
        return this.oI.getValueAsString("WeaponInventory.Class.InventoryClass");
    }

    @Override
    public void aj(String string) {
        this.oI.b("WeaponInventory.Class.InventoryClass", string);
    }

    @Override
    public String toString() {
        String string = this.getName();
        if (string != null && string.length() != 0) {
            return string;
        }
        return "Multitool";
    }
}
