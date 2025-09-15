/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import nomanssave.gD;

public enum go implements gD
{
    oL("Tiny", "MODELS/COMMON/SPACECRAFT/INDUSTRIAL/FREIGHTERTINY_PROC.SCENE.MBIN"),
    oM("Small", "MODELS/COMMON/SPACECRAFT/INDUSTRIAL/FREIGHTERSMALL_PROC.SCENE.MBIN"),
    oN("Normal", "MODELS/COMMON/SPACECRAFT/INDUSTRIAL/FREIGHTER_PROC.SCENE.MBIN"),
    oO("Capital", "MODELS/COMMON/SPACECRAFT/INDUSTRIAL/CAPITALFREIGHTER_PROC.SCENE.MBIN"),
    oP("Pirate", "MODELS/COMMON/SPACECRAFT/INDUSTRIAL/PIRATEFREIGHTER.SCENE.MBIN");

    private String name;
    private String filename;

    /*
     * WARNING - void declaration
     */
    private go() {
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

    public static go al(String string) {
        int n = 0;
        while (n < go.values().length) {
            if (string.equals(go.values()[n].filename)) {
                return go.values()[n];
            }
            ++n;
        }
        return null;
    }
}
