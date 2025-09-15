/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import nomanssave.Application;
import nomanssave.eV;
import nomanssave.eY;
import nomanssave.gP;
import nomanssave.gt;

public class gO {
    private final int index;
    private final eY rO;
    private final List gT;

    public static gO[] E(eY eY2) {
        eY eY3;
        eV eV2 = eY2.d("VehicleOwnership");
        if (eV2 == null || eV2.size() == 0) {
            return new gO[0];
        }
        ArrayList<gO> arrayList = new ArrayList<gO>();
        int n = 0;
        while (n < eV2.size()) {
            eY3 = eV2.V(n);
            if (n != 4) {
                arrayList.add(new gO(n, eY3, eY3.H("Inventory"), eY3.H("Inventory_TechOnly")));
            }
            ++n;
        }
        eY eY4 = eY2.H("FishPlatformLayout");
        eY3 = eY2.H("FishPlatformInventory");
        if (eY4 != null && eY3 != null) {
            arrayList.add(new gO(eY4, eY3));
        }
        return arrayList.toArray(new gO[0]);
    }

    private static Function a(gO gO2, String string) {
        return gt2 -> new String[]{gO2.getType(), string};
    }

    private gO(int n, eY eY2, eY eY3, eY eY4) {
        String string;
        this.index = n;
        this.rO = eY2;
        int n2 = n == 5 ? 32 : (n == 6 ? 128 : 16);
        boolean bl = Application.e().D();
        int n3 = 8;
        int n4 = 6;
        int n5 = 8;
        int n6 = 6;
        if (bl) {
            n3 = 10;
            n4 = 5;
            n5 = 10;
            n6 = 3;
            string = "Cargo";
        } else {
            string = "General";
        }
        ArrayList<gt> arrayList = new ArrayList<gt>();
        arrayList.add(new gP(this, gO.a(this, string), eY3, 0, n3, n4, false, false, false, false, bl, n2));
        if (eY4 != null) {
            arrayList.add(new gt(gO.a(this, "Technology"), eY4, n2, n5, n6, true, false, false, false));
        }
        this.gT = Collections.unmodifiableList(arrayList);
    }

    private gO(eY eY2, eY eY3) {
        this.index = 1000;
        this.rO = eY2;
        eY3.a((string, object, object2) -> {
            if ("ValidSlotIndices".equals(string) && object2 instanceof eV) {
                int n = ((eV)object2).size();
                eY2.b("Slots", n);
            }
        });
        int n = 8;
        int n2 = 6;
        ArrayList<gt> arrayList = new ArrayList<gt>();
        arrayList.add(new gt(gO.a(this, "Cold Storage"), eY3, 2048, n, n2, false, false, true, false));
        this.gT = Collections.unmodifiableList(arrayList);
    }

    public String getType() {
        if (this.index == 0) {
            return "Roamer";
        }
        if (this.index == 1) {
            return "Nomad";
        }
        if (this.index == 2) {
            return "Colossus";
        }
        if (this.index == 3) {
            return "Pilgrim";
        }
        if (this.index == 5) {
            return "Nautilon";
        }
        if (this.index == 6) {
            return "Minotaur";
        }
        if (this.index == 1000) {
            return "Skiff";
        }
        return "Vehicle " + this.index;
    }

    public List cC() {
        return this.gT;
    }

    public String toString() {
        return this.getType();
    }
}
