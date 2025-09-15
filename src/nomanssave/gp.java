/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import java.util.ArrayList;
import nomanssave.eV;
import nomanssave.eY;
import nomanssave.er;
import nomanssave.gN;
import nomanssave.gr;

public class gp {
    private final int index;
    private final eY oR;

    public static gp[] q(eY eY2) {
        eV eV2 = eY2.d("FleetFrigates");
        if (eV2 == null) {
            return new gp[0];
        }
        return gp.d(eV2);
    }

    public static gp[] d(eV eV2) {
        if (eV2.size() == 0) {
            return new gp[0];
        }
        ArrayList<gp> arrayList = new ArrayList<gp>();
        gp[] gpArray = new gp[eV2 == null ? 0 : eV2.size()];
        int n = 0;
        while (n < gpArray.length) {
            eY eY2 = eV2.V(n);
            arrayList.add(new gp(n, eY2));
            ++n;
        }
        return arrayList.toArray(new gp[0]);
    }

    private gp(int n, eY eY2) {
        this.index = n;
        this.oR = eY2;
    }

    public int getIndex() {
        return this.index;
    }

    public String getName() {
        return this.oR.getValueAsString("CustomName");
    }

    public void setName(String string) {
        this.oR.b("CustomName", string);
    }

    public gr da() {
        return gr.an(this.oR.getValueAsString("FrigateClass.FrigateClass"));
    }

    public void c(gr gr2) {
        this.oR.b("FrigateClass.FrigateClass", gr2.toString());
    }

    public String cW() {
        int n = -2;
        eV eV2 = this.oR.d("TraitIDs");
        int n2 = 0;
        while (n2 < eV2.size()) {
            String string = eV2.X(n2);
            er er2 = er.o(string);
            if (er2 != null && er2.aW()) {
                ++n;
            }
            ++n2;
        }
        if (n < 0) {
            n = 0;
        }
        if (n > 3) {
            n = 3;
        }
        return gN.values()[n].name();
    }

    public String cU() {
        return this.oR.d("HomeSystemSeed").X(1);
    }

    public void ah(String string) {
        this.oR.d("HomeSystemSeed").a(1, string);
    }

    public String cV() {
        return this.oR.d("ResourceSeed").X(1);
    }

    public void ai(String string) {
        this.oR.d("ResourceSeed").a(1, string);
    }

    public String db() {
        return this.oR.getValueAsString("Race.AlienRace");
    }

    public void am(String string) {
        this.oR.b("Race.AlienRace", string);
    }

    public int aq(int n) {
        eV eV2 = this.oR.d("Stats");
        if (eV2.size() <= n) {
            return 0;
        }
        return eV2.Y(n);
    }

    public void e(int n, int n2) {
        eV eV2 = this.oR.d("Stats");
        while (eV2.size() <= n) {
            eV2.f(0);
        }
        eV2.a(n, new Integer(n2));
    }

    public er ar(int n) {
        eV eV2 = this.oR.d("TraitIDs");
        if (n < eV2.size()) {
            String string = eV2.X(n);
            return er.o(string);
        }
        return null;
    }

    public void a(int n, er er2) {
        eV eV2 = this.oR.d("TraitIDs");
        if (n < eV2.size()) {
            eV2.a(n, er2 == null ? "^" : er2.getID());
        }
    }

    public int dc() {
        return this.oR.J("TotalNumberOfExpeditions");
    }

    public void as(int n) {
        this.oR.b("TotalNumberOfExpeditions", new Integer(n));
    }

    public int dd() {
        return this.oR.J("TotalNumberOfSuccessfulEvents");
    }

    public void at(int n) {
        this.oR.b("TotalNumberOfSuccessfulEvents", new Integer(n));
    }

    public int de() {
        return this.oR.J("TotalNumberOfFailedEvents");
    }

    public void au(int n) {
        this.oR.b("TotalNumberOfFailedEvents", new Integer(n));
    }

    public int df() {
        return this.oR.J("NumberOfTimesDamaged");
    }

    public void av(int n) {
        this.oR.b("NumberOfTimesDamaged", new Integer(n));
    }

    public int dg() {
        return this.oR.J("RepairsMade");
    }

    public void aw(int n) {
        this.oR.b("RepairsMade", new Integer(n));
    }

    public int dh() {
        return this.oR.J("DamageTaken");
    }

    public void ax(int n) {
        this.oR.b("DamageTaken", new Integer(n));
    }

    public String toString() {
        String string = this.getName();
        if (string != null && string.length() != 0) {
            return string;
        }
        gr gr2 = this.da();
        if (gr2 == null) {
            return "Unknown [" + this.index + "]";
        }
        return (Object)((Object)gr2) + " [" + this.index + "]";
    }
}
