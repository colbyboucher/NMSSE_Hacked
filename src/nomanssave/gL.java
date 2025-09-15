/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import nomanssave.gD;

public enum gL implements gD
{
    rs("Hauler", "MODELS/COMMON/SPACECRAFT/DROPSHIPS/DROPSHIP_PROC.SCENE.MBIN", 4),
    rt("Explorer", "MODELS/COMMON/SPACECRAFT/SCIENTIFIC/SCIENTIFIC_PROC.SCENE.MBIN", 4),
    ru("Shuttle", "MODELS/COMMON/SPACECRAFT/SHUTTLE/SHUTTLE_PROC.SCENE.MBIN", 4),
    rv("Fighter", "MODELS/COMMON/SPACECRAFT/FIGHTERS/FIGHTER_PROC.SCENE.MBIN", 4),
    rw("Exotic", "MODELS/COMMON/SPACECRAFT/S-CLASS/S-CLASS_PROC.SCENE.MBIN", 4),
    rx("Living", "MODELS/COMMON/SPACECRAFT/S-CLASS/BIOPARTS/BIOSHIP_PROC.SCENE.MBIN", 64),
    ry("Solar", "MODELS/COMMON/SPACECRAFT/SAILSHIP/SAILSHIP_PROC.SCENE.MBIN", 4),
    rz("Utopia Speeder", "MODELS/COMMON/SPACECRAFT/FIGHTERS/VRSPEEDER.SCENE.MBIN", 4),
    rA("Golden Vector", "MODELS/COMMON/SPACECRAFT/FIGHTERS/FIGHTERCLASSICGOLD.SCENE.MBIN", 4),
    rB("Horizon Vector NX (Switch)", "MODELS/COMMON/SPACECRAFT/FIGHTERS/FIGHTERSPECIALSWITCH.SCENE.MBIN", 4),
    rC("Robot", "MODELS/COMMON/SPACECRAFT/SENTINELSHIP/SENTINELSHIP_PROC.SCENE.MBIN", 256),
    rD("Starborn Runner", "MODELS/COMMON/SPACECRAFT/FIGHTERS/WRACER.SCENE.MBIN", 4),
    rE("Corvette", "MODELS/COMMON/SPACECRAFT/BIGGS/BIGGS.SCENE.MBIN", 4);

    private String name;
    private String filename;
    private int rF;

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private gL(int n) {
        void var5_3;
        void var4_2;
        this.name = (String)n;
        this.filename = var4_2;
        this.rF = var5_3;
    }

    @Override
    public String K() {
        return this.filename;
    }

    public int ea() {
        return this.rF;
    }

    public String toString() {
        return this.name;
    }

    public static gL aw(String string) {
        int n = 0;
        while (n < gL.values().length) {
            if (string.equals(gL.values()[n].filename)) {
                return gL.values()[n];
            }
            ++n;
        }
        return null;
    }
}
