/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

public enum ex {
    iL("Fuel"),
    iM("Metal"),
    iN("Catalyst"),
    iO("Stellar"),
    iP("Flora"),
    iQ("Earth"),
    iR("Exotic"),
    iS("Special"),
    iT("Component"),
    iU("Consumable"),
    iV("Tradeable"),
    iW("Curiosity"),
    iX("Building Part"),
    iY("Procedural"),
    iZ("Customisation Part"),
    ja("Emote"),
    jb("Pet"),
    jc("Fish"),
    jd("TechBox"),
    je("Ship"),
    jf("Weapon"),
    jg("Procedural"),
    jh("Suit"),
    ji("Procedural"),
    jj("Personal"),
    jk("Freighter"),
    jl("Procedural"),
    jm("Vehicle"),
    jn("Procedural"),
    jo("Aquatic"),
    jp("Procedural"),
    jq("Living Ship"),
    jr("Procedural"),
    js("All Ships"),
    jt("All Vehicles"),
    ju("Robot Ship"),
    jv("All Ships Except Alien"),
    jw("Procedural"),
    jx("Mech"),
    jy("Procedural"),
    jz("Maintenance"),
    jA("Corvette"),
    jB("Procedural");

    private String name;

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private ex() {
        void var3_1;
        this.name = var3_1;
    }

    public String toString() {
        return this.name;
    }
}
