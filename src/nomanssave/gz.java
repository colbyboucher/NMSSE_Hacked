/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import nomanssave.Application;
import nomanssave.eS;
import nomanssave.eU;
import nomanssave.eV;
import nomanssave.eY;
import nomanssave.gA;
import nomanssave.gs;
import nomanssave.gt;
import nomanssave.hc;

public class gz {
    private final eY oI;
    private final eV rb;
    private final eV rc;
    private final List gT;

    public static gz w(eY eY2) {
        eV eV2 = null;
        eV eV3 = eY2.d("Stats");
        if (eV3 != null) {
            int n = 0;
            while (n < eV3.size()) {
                eY eY3 = eV3.V(n);
                if ("^GLOBAL_STATS".equals(eY3.getValueAsString("GroupId"))) {
                    eV2 = eY3.d("Stats");
                    break;
                }
                ++n;
            }
        }
        return new gz(eY2, eV2, eY2.H("Inventory"), eY2.H("Inventory_TechOnly"), eY2.H("Inventory_Cargo"));
    }

    private static Function au(String string) {
        return gt2 -> new String[]{"Exosuit", string};
    }

    private gz(eY eY2, eV eV2, eY eY3, eY eY4, eY eY5) {
        String string;
        Object object;
        this.oI = eY2;
        this.rb = eV2;
        eV eV3 = eY2.d("KnownWords");
        eV eV4 = eY2.d("KnownWordGroups");
        if (eV4 == null) {
            eV4 = new eV();
            eY2.b("KnownWordGroups", eV4);
        }
        if (eV3.size() > 0) {
            int n = 0;
            while (n < eV3.size()) {
                object = eV3.V(n);
                eS eS2 = eS.A(((eY)object).getValueAsString("id"));
                if (eS2 == null) {
                    hc.warn("Could not build word groups: " + ((eY)object).getValueAsString("id"));
                    ++n;
                    continue;
                }
                for (String string2 : eS2.bw()) {
                    eU eU2 = eS2.z(string2);
                    if (eU2 == null) continue;
                    eY eY6 = new eY();
                    eY6.b("Group", string2);
                    eV eV5 = new eV(Boolean.FALSE, Boolean.FALSE, Boolean.FALSE, Boolean.FALSE, Boolean.FALSE, Boolean.FALSE, Boolean.FALSE, Boolean.FALSE);
                    eV5.a(eU2.ordinal(), Boolean.TRUE);
                    eY6.b("Races", eV5);
                    eV4.f(eY6);
                    hc.debug("Creating word: " + string2 + "[" + eU2.ordinal() + "] = true");
                }
                eV3.ac(n);
                hc.debug("Removed old word: " + ((eY)object).getValueAsString("id"));
            }
        }
        this.rc = eV4;
        int n = 0;
        int n2 = 0;
        int n3 = 0;
        int n4 = 8;
        int n5 = 6;
        int n6 = 7;
        int n7 = 2;
        if (Application.e().D()) {
            n = 3584;
            n2 = 1;
            n4 = 10;
            n5 = 12;
            n6 = 10;
            n7 = 6;
            string = "Cargo";
            object = "Unused";
            eY5 = null;
        } else {
            n = 3585;
            n2 = 1;
            n3 = 3584;
            string = "General";
            object = "Cargo";
        }
        ArrayList<gt> arrayList = new ArrayList<gt>();
        arrayList.add(new gt(gz.au(string), eY3, n, n4, n5, false, true));
        if (eY4 != null) {
            arrayList.add(new gt(gz.au("Technology"), eY4, n2, n6, n7, true, true));
        }
        if (eY5 != null) {
            arrayList.add(new gt(gz.au((String)object), eY5, n3, 8, 6, false, true));
        }
        this.gT = Collections.unmodifiableList(arrayList);
    }

    public long dJ() {
        return this.oI.K("Units") & 0xFFFFFFFFL;
    }

    public void e(long l) {
        this.oI.b("Units", new Integer((int)l));
    }

    public long dK() {
        return this.oI.K("Nanites") & 0xFFFFFFFFL;
    }

    public void f(long l) {
        this.oI.b("Nanites", new Integer((int)l));
    }

    public long dL() {
        return this.oI.K("Specials") & 0xFFFFFFFFL;
    }

    public void g(long l) {
        this.oI.b("Specials", new Integer((int)l));
    }

    public int dM() {
        return this.oI.J("Health");
    }

    public void aB(int n) {
        this.oI.b("Health", new Integer(n));
    }

    public int dN() {
        return this.oI.J("Shield");
    }

    public void aC(int n) {
        this.oI.b("Shield", new Integer(n));
    }

    public int dO() {
        return this.oI.J("Energy");
    }

    public void aD(int n) {
        this.oI.b("Energy", new Integer(n));
    }

    public List cC() {
        return this.gT;
    }

    public int dP() {
        return this.oI.J("KnownPortalRunes");
    }

    public void aE(int n) {
        this.oI.b("KnownPortalRunes", new Integer(n));
    }

    public eV dQ() {
        return this.oI.d("KnownTech");
    }

    public eV dR() {
        return this.oI.d("KnownProducts");
    }

    public eV dS() {
        return this.oI.d("KnownSpecials");
    }

    public int bx() {
        int n = 0;
        ArrayList<String> arrayList = new ArrayList<String>();
        int n2 = 0;
        while (n2 < this.rc.size()) {
            eY eY2 = this.rc.V(n2);
            eS eS2 = eS.B(eY2.getValueAsString("Group"));
            if (eS2 != null && !arrayList.contains(eS2.getID())) {
                arrayList.add(eS2.getID());
            }
            ++n2;
        }
        return n;
    }

    public int b(eU eU2) {
        int n = 0;
        int n2 = 0;
        while (n2 < this.rc.size()) {
            eY eY2 = this.rc.V(n2);
            if (eY2.d("Races").ab(eU2.ordinal())) {
                ++n;
            }
            ++n2;
        }
        return n;
    }

    public gA a(eS eS2) {
        return new gA(this, eS2, null);
    }

    private boolean d(String string, int n) {
        int n2 = 0;
        while (n2 < this.rc.size()) {
            eY eY2 = this.rc.V(n2);
            if (string.equals(eY2.getValueAsString("Group"))) {
                return eY2.d("Races").ab(n);
            }
            ++n2;
        }
        return false;
    }

    private void a(String string, int n, boolean bl) {
        eY eY2;
        int n2 = 0;
        while (n2 < this.rc.size()) {
            eY2 = this.rc.V(n2);
            if (string.equals(eY2.getValueAsString("Group"))) {
                hc.debug("Updating word: " + string + "[" + n + "] = " + bl);
                eV eV2 = eY2.d("Races");
                while (eV2.size() < eU.values().length) {
                    eV2.add(Boolean.FALSE);
                }
                eV2.a(n, new Boolean(bl));
                int n3 = 0;
                while (n3 < eV2.size()) {
                    bl |= eV2.ab(n3);
                    ++n3;
                }
                if (!bl) {
                    hc.debug("Removing word: " + string);
                    this.rc.ac(n2);
                }
                return;
            }
            ++n2;
        }
        if (bl) {
            hc.debug("Creating word: " + string + "[" + n + "] = " + bl);
            eY2 = new eY();
            eY2.b("Group", string);
            eV eV3 = new eV();
            while (eV3.size() < eU.values().length) {
                eV3.add(Boolean.FALSE);
            }
            eV3.a(n, new Boolean(bl));
            eY2.b("Races", eV3);
            this.rc.f(eY2);
        }
    }

    public double dT() {
        return new Double((double)Math.round((double)this.oI.J("HazardTimeAlive") / 90.0) / 10.0);
    }

    public void g(double d) {
        long l = Math.round(d * 900.0);
        if (l < 0L || l > Integer.MAX_VALUE) {
            throw new RuntimeException("Stat value out of range");
        }
        this.oI.b("HazardTimeAlive", new Integer((int)l));
    }

    public int a(gs gs2) {
        int n = 0;
        while (n < this.rb.size()) {
            eY eY2 = this.rb.V(n);
            if (eY2.getValueAsString("Id").equals(gs2.id)) {
                return eY2.J("Value.IntValue");
            }
            ++n;
        }
        return 0;
    }

    public void a(gs gs2, int n) {
        eY eY2;
        if (n < 0) {
            throw new RuntimeException("Stat value out of range");
        }
        int n2 = 0;
        while (n2 < this.rb.size()) {
            eY2 = this.rb.V(n2);
            if (eY2.getValueAsString("Id").equals(gs2.id)) {
                eY2.b("Value.IntValue", new Integer(n));
                return;
            }
            ++n2;
        }
        eY2 = new eY();
        eY2.b("Id", gs2.id);
        eY eY3 = new eY();
        eY3.b("IntValue", new Integer(n));
        eY3.b("FloatValue", new Double(0.0));
        eY3.b("Denominator", new Double(0.0));
        eY2.b("Value", (Object)eY3);
        this.rb.f(eY2);
    }

    public double b(gs gs2) {
        int n = 0;
        while (n < this.rb.size()) {
            eY eY2 = this.rb.V(n);
            if (eY2.getValueAsString("Id").equals(gs2.id)) {
                return eY2.L("Value.FloatValue");
            }
            ++n;
        }
        return 0.0;
    }

    public void a(gs gs2, double d) {
        eY eY2;
        if (d < 0.0) {
            throw new RuntimeException("Stat value out of range");
        }
        int n = 0;
        while (n < this.rb.size()) {
            eY2 = this.rb.V(n);
            if (eY2.getValueAsString("Id").equals(gs2.id)) {
                eY2.b("Value.FloatValue", new Double(d));
                return;
            }
            ++n;
        }
        eY2 = new eY();
        eY2.b("Id", gs2.id);
        eY eY3 = new eY();
        eY3.b("IntValue", new Integer(0));
        eY3.b("FloatValue", new Double(d));
        eY3.b("Denominator", new Double(0.0));
        eY2.b("Value", (Object)eY3);
        this.rb.f(eY2);
    }

    static /* synthetic */ boolean a(gz gz2, String string, int n) {
        return gz2.d(string, n);
    }

    static /* synthetic */ void a(gz gz2, String string, int n, boolean bl) {
        gz2.a(string, n, bl);
    }
}
