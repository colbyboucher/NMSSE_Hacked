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
import nomanssave.gn;
import nomanssave.gt;

public class gm {
    private final eY oI;
    private final List gT;
    private final gn oJ;

    public static gm p(eY eY2) {
        if (eY2.d("CurrentFreighter.Seed").ab(0) && !gm.isEmpty(eY2.getValueAsString("CurrentFreighter.Filename"))) {
            return new gm(eY2, eY2.H("FreighterInventory"), eY2.H("FreighterInventory_TechOnly"), eY2.H("FreighterInventory_Cargo"));
        }
        return null;
    }

    private static boolean isEmpty(String string) {
        return string == null || string.length() == 0;
    }

    private static Function a(gm gm2, String string) {
        return gt2 -> new String[]{"Freighter", string};
    }

    private gm(eY eY2, eY eY3, eY eY4, eY eY5) {
        String string;
        String string2;
        this.oI = eY2;
        int n = 0;
        int n2 = 0;
        int n3 = 0;
        int n4 = 8;
        int n5 = 6;
        int n6 = 7;
        int n7 = 2;
        if (Application.e().D()) {
            n = 3584;
            n2 = 8;
            n4 = 10;
            n5 = 12;
            n6 = 10;
            n7 = 6;
            string2 = "Cargo";
            string = "Unused";
            eY5 = null;
        } else {
            n = 3592;
            n2 = 8;
            n3 = 3584;
            string2 = "General";
            string = "Cargo";
        }
        ArrayList<gt> arrayList = new ArrayList<gt>();
        arrayList.add(new gt(gm.a(this, string2), eY3, n, n4, n5, false, true));
        if (eY4 != null) {
            arrayList.add(new gt(gm.a(this, "Technology"), eY4, n2, n6, n7, true, true));
        }
        if (eY5 != null) {
            arrayList.add(new gt(gm.a(this, string), eY5, n3, 8, 6, false, true));
        }
        this.gT = Collections.unmodifiableList(arrayList);
        eV eV2 = eY2.d("PersistentPlayerBases");
        eY eY6 = null;
        int n8 = 0;
        while (n8 < eV2.size()) {
            eY eY7 = eV2.V(n8);
            if ("FreighterBase".equals(eY7.getValueAsString("BaseType.PersistentBaseTypes")) && eY7.J("BaseVersion") >= 3) {
                eY6 = eY7;
                break;
            }
            ++n8;
        }
        this.oJ = eY6 == null ? null : new gn(this, eY6, null);
    }

    public String getName() {
        return this.oI.getValueAsString("PlayerFreighterName");
    }

    public void setName(String string) {
        this.oI.b("PlayerFreighterName", string);
    }

    public String cT() {
        return this.oI.getValueAsString("CurrentFreighter.Filename");
    }

    public void ag(String string) {
        this.oI.b("CurrentFreighter.Filename", string);
    }

    public String cU() {
        eV eV2 = this.oI.d("CurrentFreighterHomeSystemSeed");
        if (eV2 == null || !eV2.ab(0)) {
            return "";
        }
        String string = eV2.X(1);
        return "0x0".equals(string) ? "" : string;
    }

    public void ah(String string) {
        eV eV2 = this.oI.d("CurrentFreighterHomeSystemSeed");
        if (eV2 == null) {
            eV2 = new eV(Boolean.FALSE, "0x0");
            this.oI.b("CurrentFreighterHomeSystemSeed", eV2);
        }
        eV2.a(0, Boolean.TRUE);
        eV2.a(1, string.length() == 0 ? "0x0" : string);
    }

    public String cV() {
        return this.oI.d("CurrentFreighter.Seed").X(1);
    }

    public void ai(String string) {
        this.oI.d("CurrentFreighter.Seed").a(1, string);
    }

    public String cW() {
        return this.oI.getValueAsString("FreighterInventory.Class.InventoryClass");
    }

    public void aj(String string) {
        this.oI.b("FreighterInventory.Class.InventoryClass", string);
        eY eY2 = this.oI.H("FreighterInventory_TechOnly.Class");
        if (eY2 != null) {
            eY2.b("InventoryClass", string);
        }
        if ((eY2 = this.oI.H("FreighterInventory_Cargo.Class")) != null) {
            eY2.b("InventoryClass", string);
        }
    }

    public List cC() {
        return this.gT;
    }

    private double ak(String string) {
        return ((gt)this.gT.get(0)).ak(string);
    }

    private void d(String string, double d) {
        this.gT.stream().forEach(gt2 -> gt2.d(string, d));
    }

    public double cX() {
        return this.ak("^FREI_HYPERDRIVE");
    }

    public void a(double d) {
        this.d("^FREI_HYPERDRIVE", d);
    }

    public double cY() {
        return this.ak("^FREI_FLEET");
    }

    public void b(double d) {
        this.d("^FREI_FLEET", d);
    }

    public gn cZ() {
        return this.oJ;
    }

    public String toString() {
        String string = this.getName();
        if (string != null && string.length() != 0) {
            return string;
        }
        return "Freighter";
    }
}
