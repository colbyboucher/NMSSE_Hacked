/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

public enum gy {
    qR("Vy\u2019keen", "Warriors", "MODELS/COMMON/PLAYER/PLAYERCHARACTER/NPCVYKEEN.SCENE.MBIN"),
    qS("Korvax", "Explorers", "MODELS/COMMON/PLAYER/PLAYERCHARACTER/NPCKORVAX.SCENE.MBIN"),
    qT("Gek", "Traders", "MODELS/COMMON/PLAYER/PLAYERCHARACTER/NPCGEK.SCENE.MBIN"),
    qU("Fourth Race", null, "MODELS/COMMON/PLAYER/PLAYERCHARACTER/NPCFOURTH.SCENE.MBIN"),
    qV("Vy\u2019keen (Old)", null, "MODELS/PLANETS/NPCS/WARRIOR/WARRIOR.SCENE.MBIN"),
    qW("Korvax (Old)", null, "MODELS/PLANETS/NPCS/EXPLORER/EXPLORERIPAD.SCENE.MBIN"),
    qX("Gek (Old)", null, "MODELS/PLANETS/NPCS/LOWERORDER/LOWERORDER.SCENE.MBIN"),
    qY("Fourth Race (Old)", null, "MODELS/PLANETS/NPCS/FOURTHRACE/FOURTHRACE.SCENE.MBIN");

    private String name;
    private String qZ;
    private String filename;

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private gy(String string3) {
        void var5_3;
        void var4_2;
        this.name = string3;
        this.qZ = var4_2;
        this.filename = var5_3;
    }

    public String K() {
        return this.filename;
    }

    public String toString() {
        return this.name;
    }

    public static gy as(String string) {
        int n = 0;
        while (n < gy.values().length) {
            if (string.equals(gy.values()[n].filename)) {
                return gy.values()[n];
            }
            ++n;
        }
        return null;
    }

    public static gy at(String string) {
        int n = 0;
        while (n < gy.values().length) {
            if (string.equals(gy.values()[n].qZ)) {
                return gy.values()[n];
            }
            ++n;
        }
        return null;
    }
}
