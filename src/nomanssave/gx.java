/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import nomanssave.gD;

public enum gx implements gD
{
    qH("Standard", "MODELS/COMMON/WEAPONS/MULTITOOL/MULTITOOL.SCENE.MBIN"),
    qI("Royal", "MODELS/COMMON/WEAPONS/MULTITOOL/ROYALMULTITOOL.SCENE.MBIN"),
    qJ("Sentinel", "MODELS/COMMON/WEAPONS/MULTITOOL/SENTINELMULTITOOL.SCENE.MBIN"),
    qK("Sentinel B", "MODELS/COMMON/WEAPONS/MULTITOOL/SENTINELMULTITOOLB.SCENE.MBIN"),
    qL("Switch", "MODELS/COMMON/WEAPONS/MULTITOOL/SWITCHMULTITOOL.SCENE.MBIN"),
    qM("Staff", "MODELS/COMMON/WEAPONS/MULTITOOL/STAFFMULTITOOL.SCENE.MBIN"),
    qN("Staff NPC", "MODELS/COMMON/WEAPONS/MULTITOOL/STAFFNPCMULTITOOL.SCENE.MBIN"),
    qO("Atlas", "MODELS/COMMON/WEAPONS/MULTITOOL/ATLASMULTITOOL.SCENE.MBIN"),
    qP("Atlas Scepter", "MODELS/COMMON/WEAPONS/MULTITOOL/STAFFMULTITOOLATLAS.SCENE.MBIN");

    private String name;
    private String filename;

    /*
     * WARNING - void declaration
     */
    private gx() {
        void var4_2;
        void var3_1;
        this.name = var3_1;
        this.filename = var4_2;
    }

    @Override
    public String K() {
        return this.filename;
    }

    public String toString() {
        return this.name;
    }

    public static gx ar(String string) {
        if (string == null) {
            return null;
        }
        int n = 0;
        while (n < gx.values().length) {
            if (string.equals(gx.values()[n].filename)) {
                return gx.values()[n];
            }
            ++n;
        }
        return null;
    }
}
