/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import nomanssave.eY;

public class gC {
    private final eY oI;

    public static gC y(eY eY2) {
        return new gC(eY2);
    }

    private gC(eY eY2) {
        this.oI = eY2;
    }

    public int dV() {
        return this.oI.J("PrimaryShip");
    }

    public void aG(int n) {
        this.oI.b("PrimaryShip", n);
    }

    public int dM() {
        return this.oI.J("ShipHealth");
    }

    public void aB(int n) {
        this.oI.b("ShipHealth", new Integer(n));
    }

    public int dN() {
        return this.oI.J("ShipShield");
    }

    public void aC(int n) {
        this.oI.b("ShipShield", new Integer(n));
    }
}
