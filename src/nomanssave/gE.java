/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import nomanssave.eV;
import nomanssave.eY;
import nomanssave.gF;
import nomanssave.gG;
import nomanssave.hl;

public class gE {
    private final int index;
    private final eY bf;

    public static gE[] z(eY eY3) {
        eV eV2 = eY3.d("TeleportEndpoints");
        List list = eV2.bB().filter(eY2 -> "Settlement".equals(eY2.getValueAsString("TeleporterType"))).map(eY2 -> hl.n(eY2.H("UniverseAddress"))).collect(Collectors.toList());
        eV eV3 = eY3.d("SettlementStatesV2");
        if (eV3 == null || eV3.size() == 0) {
            return new gE[0];
        }
        ArrayList<gE> arrayList = new ArrayList<gE>();
        int n = 0;
        while (n < eV3.size()) {
            eY eY4 = eV3.V(n);
            hl hl2 = hl.n(eY4.getValue("UniverseAddress"));
            if (list.contains(hl2)) {
                arrayList.add(new gE(n, eY4));
            }
            ++n;
        }
        return arrayList.toArray(new gE[0]);
    }

    private gE(int n, eY eY2) {
        this.index = n;
        this.bf = eY2;
    }

    public int getIndex() {
        return this.index;
    }

    public String getName() {
        return this.bf.getValueAsString("Name");
    }

    public void setName(String string) {
        this.bf.b("Name", string);
    }

    public int aq(int n) {
        return this.bf.d("Stats").Y(n);
    }

    public void e(int n, int n2) {
        this.bf.d("Stats").a(n, n2);
    }

    public int a(gG gG2) {
        return this.bf.d("Stats").Y(gG2.ordinal());
    }

    public void a(gG gG2, int n) {
        this.bf.d("Stats").a(gG2.ordinal(), n);
    }

    public int dW() {
        return this.bf.d("Perks").size();
    }

    public String aH(int n) {
        return this.bf.d("Perks").X(n);
    }

    public void c(int n, String string) {
        this.bf.d("Perks").a(n, string);
    }

    public String cK() {
        return this.bf.I("SeedValue");
    }

    public void aa(String string) {
        this.bf.b("SeedValue", string);
    }

    public gF[] dX() {
        eV eV2 = this.bf.d("ProductionState");
        if (eV2 == null) {
            return new gF[0];
        }
        ArrayList<gF> arrayList = new ArrayList<gF>();
        int n = 0;
        while (n < eV2.size()) {
            eY eY2 = eV2.V(n);
            arrayList.add(new gF(this, eY2, null));
            ++n;
        }
        return arrayList.toArray(new gF[0]);
    }

    public String toString() {
        return this.getName();
    }
}
