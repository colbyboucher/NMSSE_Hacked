/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import nomanssave.Application;
import nomanssave.eV;
import nomanssave.eY;
import nomanssave.ff;
import nomanssave.fj;
import nomanssave.gI;
import nomanssave.gJ;
import nomanssave.gK;
import nomanssave.gL;
import nomanssave.gR;
import nomanssave.gt;

public class gH {
    private final int index;
    private final eY rp;
    private final List gT;

    public static gH[] C(eY eY2) {
        eV eV2 = eY2.d("ShipOwnership");
        if (eV2 == null || eV2.size() == 0) {
            return new gH[0];
        }
        ArrayList<gH> arrayList = new ArrayList<gH>();
        int n = 0;
        while (n < eV2.size()) {
            eY eY3 = eV2.V(n);
            if (eY3.d("Resource.Seed").ab(0)) {
                arrayList.add(new gH(n, eY3, eY3.H("Inventory"), eY3.H("Inventory_TechOnly"), eY3.H("Inventory_Cargo")));
            }
            ++n;
        }
        return arrayList.toArray(new gH[0]);
    }

    public static gH c(eY eY2, File file) {
        Object object;
        eV eV2 = eY2.d("ShipOwnership");
        if (eV2 == null || eV2.size() == 0) {
            throw new RuntimeException("Ship cannot be imported to current file!");
        }
        int n = -1;
        int n2 = 0;
        while (n2 < eV2.size()) {
            object = eV2.V(n2);
            if (!((eY)object).d("Resource.Seed").ab(0)) {
                n = n2;
                break;
            }
            ++n2;
        }
        if (n < 0) {
            throw new RuntimeException("Ship cannot be imported to current file!");
        }
        eY eY3 = gR.az("ship");
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
        object = eY3.H("Inventory");
        if (object == null) {
            throw new RuntimeException("Invalid ship data");
        }
        eV3 = eY3.d("Resource.Seed");
        if (eV3 == null || !eV3.ab(0)) {
            throw new RuntimeException("Invalid ship data");
        }
        eV2.a(n, eY3);
        return new gH(n, eY3, (eY)object, eY3.H("Inventory_TechOnly"), eY3.H("Inventory_Cargo"));
    }

    private static Function a(gH gH2, String[] stringArray) {
        return gt2 -> {
            String string = gH2.getName();
            if (string == null || string.length() == 0) {
                string = "Ship [" + gH2.index + "]";
            }
            return new String[]{string, stringArray[gH2.dZ() ? 1 : 0]};
        };
    }

    private gH(int n, eY eY2, eY eY3, eY eY4, eY eY5) {
        String[] stringArray;
        String[] stringArray2;
        this.index = n;
        this.rp = eY2;
        String[] stringArray3 = new String[]{"Technology", "Organ Chamber"};
        int n2 = 0;
        int n3 = 8;
        int n4 = 6;
        int n5 = 8;
        int n6 = 6;
        boolean bl = Application.e().D();
        if (bl) {
            n3 = 10;
            n4 = 12;
            n5 = 10;
            n6 = 6;
            stringArray2 = new String[]{"Cargo", "Storage Sacs"};
            stringArray = new String[]{"Unused", "Unused"};
            eY5 = null;
        } else {
            n2 = 3584;
            stringArray2 = new String[]{"General", "Storage Sacs"};
            stringArray = new String[]{"Cargo", "Inflated Sacs"};
        }
        ArrayList<gt> arrayList = new ArrayList<gt>();
        arrayList.add(new gI(this, gH.a(this, stringArray2), eY3, 0, n3, n4, false, true, bl, n));
        if (eY4 != null) {
            arrayList.add(new gJ(this, gH.a(this, stringArray3), eY4, 0, n5, n6, true, true, n));
        }
        if (eY5 != null) {
            arrayList.add(new gK(this, gH.a(this, stringArray), eY5, n2, 8, 6, false, true, n));
        }
        this.gT = Collections.unmodifiableList(arrayList);
    }

    public void a(File file, boolean bl) {
        Throwable throwable = null;
        Object var4_5 = null;
        try (fj fj2 = new fj(new FileOutputStream(file));){
            eY eY2 = this.rp.bE();
            if (!bl) {
                eY eY3;
                eV eV2 = eY2.d("Inventory.Slots");
                int n = 0;
                while (n < eV2.size()) {
                    eY3 = eV2.V(n);
                    if (!eY3.getValueAsString("Type.InventoryType").equals("Technology")) {
                        eV2.ac(n--);
                    }
                    ++n;
                }
                eV2 = eY2.d("Inventory_Cargo.Slots");
                n = 0;
                while (n < eV2.size()) {
                    eY3 = eV2.V(n);
                    if (!eY3.getValueAsString("Type.InventoryType").equals("Technology")) {
                        eV2.ac(n--);
                    }
                    ++n;
                }
            }
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
        return this.rp.getValueAsString("Name");
    }

    public void setName(String string) {
        this.rp.b("Name", string);
    }

    public boolean dZ() {
        return gL.aw(this.cT()) == gL.rx;
    }

    private int ea() {
        gL gL2 = gL.aw(this.cT());
        return gL2 == null ? 4 : gL2.ea();
    }

    public String cT() {
        return this.rp.getValueAsString("Resource.Filename");
    }

    public void ag(String string) {
        this.rp.b("Resource.Filename", string);
        gL gL2 = gL.aw(string);
        this.gT.stream().forEach(gt2 -> gt2.az(gL2 == null ? 4 : gL2.ea()));
        if (gL2 == gL.rx) {
            this.d("^ALIEN_SHIP", 1.0);
            this.av("^ROBOT_SHIP");
        } else if (gL2 == gL.rC) {
            this.av("^ALIEN_SHIP");
            this.d("^ROBOT_SHIP", 1.0);
        } else {
            this.av("^ALIEN_SHIP");
            this.av("^ROBOT_SHIP");
        }
    }

    public String cK() {
        return this.rp.d("Resource.Seed").X(1);
    }

    public void aa(String string) {
        this.rp.d("Resource.Seed").a(1, string);
    }

    public void cm() {
        this.rp.b("Resource.Filename", "");
        this.rp.d("Resource.Seed").a(0, Boolean.FALSE);
        this.rp.d("Resource.Seed").a(1, "0x0");
    }

    public String cW() {
        return this.rp.getValueAsString("Inventory.Class.InventoryClass");
    }

    public void aj(String string) {
        this.rp.b("Inventory.Class.InventoryClass", string);
        eY eY2 = this.rp.H("Inventory_TechOnly.Class");
        if (eY2 != null) {
            eY2.b("InventoryClass", string);
        }
        if ((eY2 = this.rp.H("Inventory_Cargo.Class")) != null) {
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

    private void av(String string) {
        this.gT.stream().forEach(gt2 -> {
            boolean bl = gt2.ap(string);
        });
    }

    public double dF() {
        return this.ak("^SHIP_DAMAGE");
    }

    public void d(double d) {
        this.d("^SHIP_DAMAGE", d);
    }

    public double eb() {
        return this.ak("^SHIP_SHIELD");
    }

    public void h(double d) {
        this.d("^SHIP_SHIELD", d);
    }

    public double cX() {
        return this.ak("^SHIP_HYPERDRIVE");
    }

    public void a(double d) {
        this.d("^SHIP_HYPERDRIVE", d);
    }

    public double ec() {
        return this.ak("^SHIP_AGILE");
    }

    public void i(double d) {
        this.d("^SHIP_AGILE", d);
    }

    public String toString() {
        String string = this.getName();
        if (string != null && string.length() != 0) {
            return string;
        }
        gL gL2 = gL.aw(this.cT());
        if (gL2 == null) {
            return "Unknown [" + this.index + "]";
        }
        return gL2 + " [" + this.index + "]";
    }

    static /* synthetic */ int b(gH gH2) {
        return gH2.ea();
    }
}
