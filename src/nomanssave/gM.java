/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import nomanssave.eV;
import nomanssave.eY;
import nomanssave.gL;
import nomanssave.gy;

public class gM {
    private final eV rH;
    private final eY rI;
    private final int index;

    public static gM[] D(eY eY2) {
        eV eV2 = eY2.d("SquadronUnlockedPilotSlots");
        eV eV3 = eY2.d("SquadronPilots");
        if (eV2 == null || eV3 == null) {
            return new gM[0];
        }
        gM[] gMArray = new gM[Math.min(eV2.size(), eV3.size())];
        int n = 0;
        while (n < gMArray.length) {
            gMArray[n] = new gM(eV2, eV3.V(n), n);
            ++n;
        }
        return gMArray;
    }

    private gM(eV eV2, eY eY2, int n) {
        this.rH = eV2;
        this.rI = eY2;
        this.index = n;
    }

    public boolean isEnabled() {
        return this.rH.ab(this.index);
    }

    public void setEnabled(boolean bl) {
        this.rH.a(this.index, bl);
    }

    public boolean isValid() {
        return this.rI.d("NPCResource.Seed").ab(0) && this.rI.d("ShipResource.Seed").ab(0);
    }

    public gy ed() {
        return gy.as(this.rI.getValueAsString("NPCResource.Filename"));
    }

    public void a(gy gy2) {
        this.rI.b("NPCResource.Filename", gy2.K());
    }

    public String ee() {
        eV eV2 = this.rI.d("NPCResource.Seed");
        return eV2.ab(0) ? eV2.X(1) : "";
    }

    public void ax(String string) {
        eV eV2 = this.rI.d("NPCResource.Seed");
        if (string == null || string.length() == 0) {
            eV2.a(0, false);
            eV2.a(1, "0x0");
        } else {
            eV2.a(0, true);
            eV2.a(1, string);
        }
    }

    public gL ef() {
        return gL.aw(this.rI.getValueAsString("ShipResource.Filename"));
    }

    public void a(gL gL2) {
        this.rI.b("ShipResource.Filename", gL2.K());
    }

    public String eg() {
        eV eV2 = this.rI.d("ShipResource.Seed");
        return eV2.ab(0) ? eV2.X(1) : "";
    }

    public void ay(String string) {
        eV eV2 = this.rI.d("ShipResource.Seed");
        if (string == null || string.length() == 0) {
            eV2.a(0, false);
            eV2.a(1, "0x0");
        } else {
            eV2.a(0, true);
            eV2.a(1, string);
        }
    }

    public int eh() {
        return this.rI.J("PilotRank");
    }

    public void aI(int n) {
        this.rI.b("PilotRank", n);
    }

    public String toString() {
        return this.isEnabled() ? (this.isValid() ? "Wingman " + this.index : "EMPTY") : "LOCKED";
    }
}
