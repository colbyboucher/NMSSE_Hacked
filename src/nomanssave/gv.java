/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.function.Function;
import nomanssave.Application;
import nomanssave.eV;
import nomanssave.eY;
import nomanssave.ff;
import nomanssave.fj;
import nomanssave.gR;
import nomanssave.gt;
import nomanssave.gw;

public class gv {
    private final int index;
    private final eY qF;
    private final gt qG;

    public static gv[] v(eY eY2) {
        eV eV2 = eY2.d("Multitools");
        if (eV2 == null || eV2.size() == 0) {
            return new gv[]{new gw(eY2, eY2.H("WeaponInventory"))};
        }
        ArrayList<gv> arrayList = new ArrayList<gv>();
        int n = 0;
        while (n < eV2.size()) {
            eY eY3 = eV2.V(n);
            if (eY3.d("Seed").ab(0)) {
                arrayList.add(new gv(n, eY3, eY3.H("Store")));
            }
            ++n;
        }
        return arrayList.toArray(new gv[0]);
    }

    public static gv b(eY eY2, File file) {
        Object object;
        eV eV2 = eY2.d("Multitools");
        if (eV2 == null || eV2.size() == 0) {
            throw new RuntimeException("Weapon cannot be imported to current file!");
        }
        int n = -1;
        int n2 = 0;
        while (n2 < eV2.size()) {
            object = eV2.V(n2);
            if (!((eY)object).d("Seed").ab(0)) {
                n = n2;
                break;
            }
            ++n2;
        }
        if (n < 0) {
            throw new RuntimeException("Weapon cannot be imported to current file!");
        }
        eY eY3 = gR.az("multitool");
        object = null;
        eV eV3 = null;
        try (ff ff2 = new ff(new FileInputStream(file));){
            if (eY3 == null) {
                eY3 = ff2.bK();
            } else {
                eY3.c(ff2.bK());
            }
        }
        catch (Throwable throwable) {
            if (object == null) {
                object = throwable;
            } else if (object != throwable) {
                ((Throwable)object).addSuppressed(throwable);
            }
            throw object;
        }
        eV2.a(n, eY3);
        object = eY3.H("Store");
        if (object == null) {
            throw new RuntimeException("Invalid weapon data");
        }
        eV3 = eY3.d("Seed");
        if (eV3 == null || !eV3.ab(0)) {
            throw new RuntimeException("Invalid weapon data");
        }
        return new gv(n, eY3, (eY)object);
    }

    private static Function b(gv gv2) {
        return gt2 -> {
            String string = gv2.getName();
            if (string == null || string.length() == 0) {
                string = "Multitool [" + gv2.index + "]";
            }
            return new String[]{string};
        };
    }

    gv(int n, eY eY2, eY eY3) {
        this.index = n;
        this.qF = eY2;
        int n2 = 8;
        int n3 = 6;
        if (Application.e().D()) {
            n2 = 10;
            n3 = 10;
        }
        this.qG = new gt(gv.b(this), eY3, 2, n2, n3, true, true);
    }

    public void j(File file) {
        Throwable throwable = null;
        Object var3_4 = null;
        try (fj fj2 = new fj(new FileOutputStream(file));){
            eY eY2 = this.qF.bE();
            fj2.h(eY2);
        }
        catch (Throwable throwable2) {
            if (throwable == null) {
                throwable = throwable2;
            } else if (throwable != throwable2) {
                throwable.addSuppressed(throwable2);
            }
            throw throwable;
        }
    }

    public int getIndex() {
        return this.index;
    }

    public String getName() {
        return this.qF.getValueAsString("Name");
    }

    public void setName(String string) {
        this.qF.b("Name", string);
    }

    public String cT() {
        return this.qF.getValueAsString("Resource.Filename");
    }

    public void ag(String string) {
        this.qF.b("Resource.Filename", string);
    }

    public String cK() {
        return this.qF.d("Seed").X(1);
    }

    public void aa(String string) {
        this.qF.d("Seed").a(1, string);
    }

    public String cW() {
        return this.qF.getValueAsString("Store.Class.InventoryClass");
    }

    public void aj(String string) {
        this.qF.b("Store.Class.InventoryClass", string);
    }

    public gt dE() {
        return this.qG;
    }

    private double ak(String string) {
        return this.qG.ak(string);
    }

    private void d(String string, double d) {
        this.qG.d(string, d);
    }

    public double dF() {
        return this.ak("^WEAPON_DAMAGE");
    }

    public void d(double d) {
        this.d("^WEAPON_DAMAGE", d);
    }

    public double dG() {
        return this.ak("^WEAPON_MINING");
    }

    public void e(double d) {
        this.d("^WEAPON_MINING", d);
    }

    public double dH() {
        return this.ak("^WEAPON_SCAN");
    }

    public void f(double d) {
        this.d("^WEAPON_SCAN", d);
    }

    public void cm() {
        this.qF.b("Seed", new eV(Boolean.FALSE, "0x0"));
    }

    public String toString() {
        String string = this.getName();
        if (string != null && string.length() != 0) {
            return string;
        }
        return "Multitool [" + this.index + "]";
    }
}
