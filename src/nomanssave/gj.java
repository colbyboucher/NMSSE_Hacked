/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import nomanssave.eV;
import nomanssave.eY;
import nomanssave.ff;
import nomanssave.fj;
import nomanssave.gR;
import nomanssave.gl;

public class gj {
    private final gl nF;
    private final int index;
    private final eY bf;

    public static boolean n(eY eY2) {
        return eY2.d("Pets") != null && eY2.d("Eggs") != null;
    }

    public static gj[] o(eY eY2) {
        eY eY3;
        int n;
        ArrayList<gj> arrayList = new ArrayList<gj>();
        eV eV2 = eY2.d("Pets");
        if (eV2 != null) {
            n = 0;
            while (n < eV2.size()) {
                eY3 = eV2.V(n);
                if (eY3.d("CreatureSeed").ab(0)) {
                    arrayList.add(new gj(gl.oF, n, eY3));
                }
                ++n;
            }
        }
        if ((eV2 = eY2.d("Eggs")) != null) {
            n = 0;
            while (n < eV2.size()) {
                eY3 = eV2.V(n);
                if (eY3.d("CreatureSeed").ab(0)) {
                    arrayList.add(new gj(gl.oG, n, eY3));
                }
                ++n;
            }
        }
        return arrayList.toArray(new gj[0]);
    }

    public static gj a(eY eY2, File file) {
        Object object;
        eV eV2 = null;
        gl gl2 = null;
        if (file.getName().endsWith(".pet")) {
            eV2 = eY2.d("Pets");
            gl2 = gl.oF;
        }
        if (file.getName().endsWith(".egg")) {
            eV2 = eY2.d("Eggs");
            gl2 = gl.oG;
        }
        if (eV2 == null || eV2.size() == 0) {
            throw new RuntimeException("Companion cannot be imported to current file!");
        }
        int n = -1;
        int n2 = 0;
        while (n2 < eV2.size()) {
            object = eV2.V(n2);
            if (!((eY)object).d("CreatureSeed").ab(0)) {
                n = n2;
                break;
            }
            ++n2;
        }
        if (n < 0) {
            throw new RuntimeException("Companion cannot be imported to current file!");
        }
        eY eY3 = gR.az("companion");
        object = null;
        Object var7_9 = null;
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
        object = eY3.d("CreatureSeed");
        if (object == null || !((eV)object).ab(0)) {
            throw new RuntimeException("Invalid creature data");
        }
        eV2.a(n, eY3);
        return new gj(gl2, n, eY3);
    }

    private gj(gl gl2, int n, eY eY2) {
        this.nF = gl2;
        this.index = n;
        this.bf = eY2;
    }

    public int getIndex() {
        return this.index;
    }

    public void cm() {
        this.bf.d("CreatureSeed").a(0, Boolean.FALSE);
        this.bf.d("CreatureSeed").a(1, "0x0");
    }

    public void j(File file) {
        Throwable throwable = null;
        Object var3_4 = null;
        try (fj fj2 = new fj(new FileOutputStream(file));){
            eY eY2 = this.bf.bE();
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

    public gl cL() {
        return this.nF;
    }

    public String getName() {
        return this.bf.getValueAsString("CustomName");
    }

    public void setName(String string) {
        this.bf.b("CustomName", string);
    }

    public String cM() {
        return this.bf.getValueAsString("CreatureID");
    }

    public String cK() {
        return this.bf.d("CreatureSeed").X(1);
    }

    public void aa(String string) {
        this.bf.d("CreatureSeed").a(1, string);
    }

    public String cN() {
        eV eV2 = this.bf.d("CreatureSecondarySeed");
        return eV2.ab(0) ? eV2.X(1) : "";
    }

    public void ab(String string) {
        eV eV2 = this.bf.d("CreatureSecondarySeed");
        if (string == null || string.length() == 0) {
            eV2.a(0, false);
            eV2.a(1, "");
        } else {
            eV2.a(0, true);
            eV2.a(1, string);
        }
    }

    public String cO() {
        return this.bf.I("SpeciesSeed");
    }

    public void ac(String string) {
        this.bf.b("SpeciesSeed", string);
    }

    public String cP() {
        return this.bf.I("GenusSeed");
    }

    public void ad(String string) {
        this.bf.b("GenusSeed", string);
    }

    public boolean cQ() {
        return this.bf.M("Predator");
    }

    public void d(boolean bl) {
        this.bf.b("Predator", bl);
    }

    public String cR() {
        return this.bf.getValueAsString("Biome.Biome");
    }

    public void ae(String string) {
        this.bf.b("Biome.Biome", string);
    }

    public String cS() {
        return this.bf.getValueAsString("CreatureType.CreatureType");
    }

    public void af(String string) {
        this.bf.b("CreatureType.CreatureType", string);
    }

    public String toString() {
        String string = this.getName();
        if (string != null && string.length() != 0) {
            return string;
        }
        return String.valueOf(this.nF.name()) + " [" + this.index + "]";
    }
}
