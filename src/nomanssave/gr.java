/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

public enum gr {
    pf("Combat", false),
    pg("Exploration", false),
    ph("Mining", false),
    pi("Diplomacy", false),
    pj("Support", false),
    pk("Normandy", true),
    pl("DeepSpace", true),
    pm("DeepSpaceCommon", true),
    pn("Pirate", false),
    po("GhostShip", true);

    private String name;
    private boolean special;

    /*
     * WARNING - void declaration
     */
    private gr() {
        void var4_2;
        void var3_1;
        this.name = var3_1;
        this.special = var4_2;
    }

    public boolean isSpecial() {
        return this.special;
    }

    public String toString() {
        return this.name;
    }

    public static gr an(String string) {
        int n = 0;
        while (n < gr.values().length) {
            if (string.equalsIgnoreCase(gr.values()[n].name)) {
                return gr.values()[n];
            }
            ++n;
        }
        return null;
    }
}
