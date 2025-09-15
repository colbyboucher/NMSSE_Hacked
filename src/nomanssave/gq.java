/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

public enum gq {
    oS("Combat"),
    oT("Exploration"),
    oU("Industry"),
    oV("Trading"),
    oW("Cost Per Warp"),
    oX("Expedition Fuel Cost", -1),
    oY("Expedition Duration", -1),
    oZ("Loot"),
    pa("Repair"),
    pb("Damage Reduction"),
    pc("Stealth");

    private String name;
    private int pd;

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private gq() {
        this((String)var1_-1, (int)var2_-1, (String)var3_1, 1);
        void var3_1;
        void var2_-1;
        void var1_-1;
    }

    /*
     * WARNING - void declaration
     */
    private gq() {
        void var4_2;
        void var3_1;
        this.name = var3_1;
        this.pd = var4_2;
    }

    public int di() {
        return this.pd;
    }

    public String toString() {
        return this.name;
    }
}
