/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

public enum eU {
    kr("Gek"),
    ks("Vy'keen"),
    kt("Korvax"),
    ku("Robot"),
    kv("Atlas"),
    kw("Diplomats"),
    kx("Exotics"),
    ky("None"),
    kz("Autophage");

    private String name;

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private eU() {
        void var3_1;
        this.name = var3_1;
    }

    public String toString() {
        return this.name;
    }

    public static eU C(String string) {
        eU[] eUArray = eU.values();
        int n = eUArray.length;
        int n2 = 0;
        while (n2 < n) {
            eU eU2 = eUArray[n2];
            if (eU2.name().equals(string)) {
                return eU2;
            }
            ++n2;
        }
        return null;
    }
}
