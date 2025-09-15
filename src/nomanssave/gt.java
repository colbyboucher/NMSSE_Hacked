/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import java.awt.Dimension;
import java.io.PrintStream;
import java.util.function.Function;
import nomanssave.Application;
import nomanssave.eV;
import nomanssave.eY;
import nomanssave.en;
import nomanssave.eu;
import nomanssave.ew;
import nomanssave.ex;
import nomanssave.ey;
import nomanssave.fa;
import nomanssave.fg;
import nomanssave.gR;
import nomanssave.gu;
import nomanssave.hc;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class gt {
    public static final int pW = 1;
    public static final int pX = 2;
    public static final int pY = 4;
    public static final int pZ = 8;
    public static final int qa = 16;
    public static final int qb = 32;
    public static final int qc = 64;
    public static final int qd = 128;
    public static final int qe = 256;
    public static final int qf = 324;
    public static final int qg = 176;
    public static final int qh = 260;
    public static final int qi = 511;
    public static final int qj = 512;
    public static final int qk = 1024;
    public static final int ql = 2048;
    public static final int qm = 3584;
    public static final int qn = 8192;
    public static final int qo = 16384;
    public static final int qp = 32768;
    public static final int qq = 8;
    public static final int qr = 6;
    private final Function qs;
    private final eY qt;
    private final int r;
    private final boolean qu;
    private final boolean qv;
    private final boolean qw;
    private final boolean qx;
    private int width;
    private int height;
    private int bE;
    private int bF;
    private eY[][] qy;
    private boolean[][] qz;

    public static int a(ex ex2) {
        switch (ex2) {
            case jh: 
            case ji: {
                return 1;
            }
            case je: {
                return 4;
            }
            case jq: 
            case jr: {
                return 64;
            }
            case jf: 
            case jg: {
                return 2;
            }
            case jm: 
            case jn: {
                return 16;
            }
            case jo: 
            case jp: {
                return 32;
            }
            case jx: 
            case jy: {
                return 128;
            }
            case jk: 
            case jl: {
                return 8;
            }
            case js: {
                return 324;
            }
            case ju: {
                return 256;
            }
            case jv: 
            case jw: {
                return 260;
            }
            case jt: {
                return 176;
            }
            case jc: {
                return 3584;
            }
        }
        return 1536;
    }

    gt(Function function, eY eY2, int n, int n2, int n3, boolean bl, boolean bl2) {
        this(function, eY2, n, n2, n3, bl, bl2, true, true);
    }

    gt(Function function, eY eY2, int n, int n2, int n3, boolean bl, boolean bl2, boolean bl3, boolean bl4) {
        int n4;
        this.qs = function;
        this.qt = eY2;
        this.r = n;
        this.qu = bl;
        this.qv = bl2;
        this.qw = bl3;
        this.qx = bl4;
        this.width = eY2.J("Width");
        this.height = eY2.J("Height");
        ew ew2 = eu.b(Application.e().E(), eY2.getValueAsString("StackSizeGroup.InventoryStackSizeGroup"));
        if (ew2 != null) {
            this.bE = ew2.aX();
            this.bF = ew2.aY();
        } else {
            switch (Application.e().F()) {
                case ln: 
                case lq: {
                    this.bE = 250 * eY2.c("SubstanceMaxStorageMultiplier", 2);
                    this.bF = eY2.c("ProductMaxStorageMultiplier", 10);
                    break;
                }
                default: {
                    this.bE = 9999;
                    this.bF = eY2.c("ProductMaxStorageMultiplier", 10);
                }
            }
        }
        int n5 = Math.max(this.height, n3);
        int n6 = Math.max(this.width, n2);
        this.qy = new eY[n5][];
        this.qz = new boolean[n5][];
        int n7 = 0;
        while (n7 < n5) {
            this.qy[n7] = new eY[n6];
            this.qz[n7] = new boolean[n6];
            ++n7;
        }
        eV eV2 = eY2.d("ValidSlotIndices");
        int n8 = 0;
        while (n8 < eV2.size()) {
            eY eY3 = eV2.V(n8);
            int n9 = eY3.J("X");
            n4 = eY3.J("Y");
            if (n9 >= 0 && n9 < n6 && n4 >= 0 && n4 < n5) {
                this.qz[n4][n9] = true;
            }
            ++n8;
        }
        eV eV3 = eY2.d("Slots");
        int n10 = 0;
        while (n10 < eV3.size()) {
            eY eY4 = eV3.V(n10);
            n4 = eY4.J("Index.X");
            int n11 = eY4.J("Index.Y");
            if (n4 >= 0 && n4 < n6 && n11 >= 0 && n11 < n5) {
                this.qy[n11][n4] = eY4;
            }
            ++n10;
        }
    }

    public String getSimpleName() {
        String[] stringArray = (String[])this.qs.apply(this);
        if (stringArray.length == 0) {
            return "Unknown";
        }
        return stringArray.length == 1 ? stringArray[0] : stringArray[1];
    }

    public String getFullName() {
        String[] stringArray = (String[])this.qs.apply(this);
        if (stringArray.length == 0) {
            return "Unknown";
        }
        return stringArray.length == 1 ? stringArray[0] : String.valueOf(stringArray[0]) + " - " + stringArray[1];
    }

    public String getName() {
        return this.qt.getValueAsString("Name");
    }

    public void setName(String string) {
        if (string == null) {
            string = "";
        }
        this.qt.b("Name", string);
    }

    public int dj() {
        return this.r;
    }

    public boolean ay(int n) {
        return (this.dj() & n) != 0;
    }

    public boolean dk() {
        return this.qv;
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    boolean ao(String string) {
        eV eV2 = this.qt.d("BaseStatValues");
        if (eV2 == null) {
            return false;
        }
        int n = 0;
        while (n < eV2.size()) {
            eY eY2 = eV2.V(n);
            if (eY2.getValueAsString("BaseStatID").equals(string)) {
                return true;
            }
            ++n;
        }
        return false;
    }

    double ak(String string) {
        eV eV2 = this.qt.d("BaseStatValues");
        if (eV2 == null) {
            return 0.0;
        }
        int n = 0;
        while (n < eV2.size()) {
            eY eY2 = eV2.V(n);
            if (eY2.getValueAsString("BaseStatID").equals(string)) {
                return eY2.L("Value");
            }
            ++n;
        }
        return 0.0;
    }

    void d(String string, double d) {
        eV eV2 = this.qt.d("BaseStatValues");
        if (eV2 == null) {
            throw new RuntimeException("Could not set base stat");
        }
        boolean bl = false;
        int n = 0;
        while (n < eV2.size()) {
            eY eY2 = eV2.V(n);
            if (eY2.getValueAsString("BaseStatID").equals(string)) {
                eY2.b("Value", d);
                bl = true;
                break;
            }
            ++n;
        }
        if (!bl) {
            eY eY3 = new eY();
            eY3.b("BaseStatID", string);
            eY3.b("Value", d);
            eV2.f(eY3);
            bl = true;
        }
    }

    boolean ap(String string) {
        eV eV2 = this.qt.d("BaseStatValues");
        if (eV2 == null) {
            return false;
        }
        int n = 0;
        while (n < eV2.size()) {
            eY eY2 = eV2.V(n);
            if (eY2.getValueAsString("BaseStatID").equals(string)) {
                eV2.ac(n);
                return true;
            }
            ++n;
        }
        return false;
    }

    public Dimension getSize() {
        return new Dimension(this.width, this.height);
    }

    public boolean a(Dimension dimension) {
        int n = 1;
        int n2 = 1;
        int n3 = 0;
        while (n3 < this.qy.length) {
            int n4 = 0;
            while (n4 < this.qy[n3].length) {
                if (this.qz[n3][n4]) {
                    n = Math.max(n, n4 + 1);
                    n2 = Math.max(n2, n3 + 1);
                }
                ++n4;
            }
            ++n3;
        }
        if (dimension.width < n) {
            throw new RuntimeException("Cannot resize less than min width");
        }
        if (dimension.height < n2) {
            throw new RuntimeException("Cannot resize less than min height");
        }
        if (en.aS()) {
            if (dimension.width > this.qz[0].length) {
                n3 = 0;
                while (n3 < this.qy.length) {
                    eY[] eYArray = new eY[dimension.width];
                    boolean[] blArray = new boolean[dimension.width];
                    System.arraycopy(this.qy[n3], 0, eYArray, 0, this.qz[n3].length);
                    System.arraycopy(this.qz[n3], 0, blArray, 0, this.qz[n3].length);
                    this.qy[n3] = eYArray;
                    this.qz[n3] = blArray;
                    ++n3;
                }
            }
            if (dimension.height > this.qz.length) {
                eY[][] eYArrayArray = new eY[dimension.height][];
                boolean[][] blArrayArray = new boolean[dimension.height][];
                System.arraycopy(this.qy, 0, eYArrayArray, 0, this.qz.length);
                System.arraycopy(this.qz, 0, blArrayArray, 0, this.qz.length);
                int n5 = this.qz.length;
                while (n5 < dimension.height) {
                    eYArrayArray[n5] = new eY[dimension.width];
                    blArrayArray[n5] = new boolean[dimension.width];
                    ++n5;
                }
                this.qy = eYArrayArray;
                this.qz = blArrayArray;
            }
        } else {
            if (dimension.width > this.qz[0].length) {
                throw new RuntimeException("Cannot resize width greater than " + this.qz[0].length);
            }
            if (dimension.height > this.qz.length) {
                throw new RuntimeException("Cannot resize height greater than " + this.qz.length);
            }
        }
        boolean bl = false;
        if (this.width != dimension.width) {
            this.width = dimension.width;
            this.qt.b("Width", new Integer(this.width));
            bl = true;
        }
        if (this.height != dimension.height) {
            this.height = dimension.height;
            this.qt.b("Height", new Integer(this.height));
            bl = true;
        }
        return bl;
    }

    public boolean dl() {
        boolean bl = false;
        if (this.width < this.qz[0].length) {
            this.width = this.qz[0].length;
            this.qt.b("Width", new Integer(this.width));
            bl = true;
        }
        if (this.height < this.qz.length) {
            this.height = this.qz.length;
            this.qt.b("Height", new Integer(this.height));
            bl = true;
        }
        return bl;
    }

    public Dimension dm() {
        int n = 1;
        int n2 = 1;
        int n3 = 0;
        while (n3 < this.qy.length) {
            int n4 = 0;
            while (n4 < this.qy[n3].length) {
                if (this.qz[n3][n4]) {
                    n = Math.max(n, n4 + 1);
                    n2 = Math.max(n2, n3 + 1);
                }
                ++n4;
            }
            ++n3;
        }
        return new Dimension(n, n2);
    }

    public Dimension dn() {
        return new Dimension(this.qz[0].length, this.qz.length);
    }

    public void a(int n, int n2, int n3, int n4) {
        if (!this.qz[n2][n]) {
            throw new RuntimeException("Old slot not enabled");
        }
        if (!this.qz[n4][n3]) {
            throw new RuntimeException("New slot not enabled");
        }
        eV eV2 = this.qt.d("Slots");
        if (this.qy[n4][n3] != null) {
            eV2.g(this.qy[n4][n3]);
        }
        if (this.qy[n2][n] == null) {
            this.qy[n4][n3] = null;
        } else {
            eY eY2 = this.qy[n2][n].bE();
            eY2.b("Index.X", n3);
            eY2.b("Index.Y", n4);
            eV2.f(eY2);
            this.qy[n4][n3] = eY2;
        }
    }

    public void b(int n, int n2, int n3, int n4) {
        if (!this.qz[n2][n]) {
            throw new RuntimeException("Old slot not enabled");
        }
        if (!this.qz[n4][n3]) {
            throw new RuntimeException("New slot not enabled");
        }
        eY eY2 = this.qy[n2][n];
        eY eY3 = this.qy[n4][n3];
        if (eY2 != null && eY3 != null && eY2.getValue("Id").equals(eY3.getValue("Id"))) {
            int n5 = eY3.J("MaxAmount");
            int n6 = eY2.J("Amount") + eY3.J("Amount");
            if (n6 <= n5) {
                eY3.b("Amount", n6);
                this.g(n, n2);
            } else {
                eY3.b("Amount", n5);
                eY2.b("Amount", n6 - n5);
            }
            return;
        }
        if (eY2 != null) {
            eY2.b("Index", new fa().d("X", n3).d("Y", n4).bH());
        }
        this.qy[n4][n3] = eY2;
        if (eY3 != null) {
            eY3.b("Index", new fa().d("X", n).d("Y", n2).bH());
        }
        this.qy[n2][n] = eY3;
    }

    public void c(int n, int n2, int n3, int n4) {
        if (!this.qz[n2][n]) {
            throw new RuntimeException("Old slot not enabled");
        }
        if (!this.qz[n4][n3]) {
            throw new RuntimeException("New slot not enabled");
        }
        eY eY2 = this.qy[n2][n];
        eY eY3 = this.qy[n4][n3];
        if (eY2 != null) {
            eY2.b("Index", new fa().d("X", n3).d("Y", n4).bH());
        }
        this.qy[n4][n3] = eY2;
        if (eY3 != null) {
            eY3.b("Index", new fa().d("X", n).d("Y", n2).bH());
        }
        this.qy[n2][n] = eY3;
    }

    public gu f(int n, int n2) {
        if (this.qy[n2][n] == null) {
            return null;
        }
        return new gu(this, this.qy[n2][n], null);
    }

    public void az(int n) {
        eV eV2 = this.qt.d("Slots");
        int n2 = 0;
        while (n2 < eV2.size()) {
            ey ey2;
            eY eY2 = eV2.V(n2);
            if (eY2.getValueAsString("Type.InventoryType").equals("Technology") && ((ey2 = ey.d(eY2.getValue("Id"))) == null || (gt.a(ey2.bc()) & n) == 0)) {
                int n3 = eY2.J("Index.X");
                int n4 = eY2.J("Index.Y");
                if (n4 < this.qy.length && n3 < this.qy[n4].length) {
                    this.qy[n4][n3] = null;
                }
                eV2.ac(n2--);
            }
            ++n2;
        }
    }

    public boolean g(int n, int n2) {
        if (this.qy[n2][n] == null) {
            return false;
        }
        eV eV2 = this.qt.d("Slots");
        int n3 = 0;
        while (n3 < eV2.size()) {
            eY eY2 = eV2.V(n3);
            if (n == eY2.J("Index.X") && n2 == eY2.J("Index.Y")) {
                eV2.ac(n3);
            }
            ++n3;
        }
        this.qy[n2][n] = null;
        return true;
    }

    public boolean a(int n, int n2, gt gt2) {
        int n3;
        int n4;
        int n5;
        int n6;
        int n7;
        if (this.qy[n2][n] == null) {
            return false;
        }
        String string = this.qy[n2][n].getValueAsString("Type.InventoryType");
        Object object = this.qy[n2][n].getValue("Id");
        int n8 = this.qy[n2][n].J("Amount");
        double d = this.qy[n2][n].L("DamageFactor");
        boolean bl = this.qy[n2][n].M("FullyInstalled");
        boolean bl2 = false;
        if (string.equals("Technology")) {
            n7 = this.qy[n2][n].J("MaxAmount");
            n6 = 0;
            while (n6 < gt2.qy.length) {
                n5 = 0;
                while (n5 < gt2.qy[n6].length) {
                    if (gt2.qy[n6][n5] == null && gt2.qz[n6][n5] && !gt2.l(n5, n6)) {
                        gt2.a(n5, n6, string, object, n8, n7, d, bl);
                        n8 = 0;
                        bl2 = true;
                        break;
                    }
                    ++n5;
                }
                if (n8 == 0) break;
                ++n6;
            }
        }
        if (n8 > 0 && !string.equals("Technology")) {
            n7 = 0;
            while (n7 < gt2.qy.length) {
                n6 = 0;
                while (n6 < gt2.qy[n7].length) {
                    if (gt2.qy[n7][n6] != null && string.equals(gt2.qy[n7][n6].getValueAsString("Type.InventoryType")) && object.equals(gt2.qy[n7][n6].getValue("Id")) && (n5 = gt2.qy[n7][n6].J("Amount")) < (n4 = gt2.qy[n7][n6].J("MaxAmount"))) {
                        n3 = n8 > n4 - n5 ? n4 - n5 : n8;
                        hc.info("  added to existing stack: " + n3);
                        gt2.qy[n7][n6].b("Amount", new Integer(n5 + n3));
                        bl2 = true;
                        if ((n8 -= n3) == 0) break;
                    }
                    ++n6;
                }
                if (n8 == 0) break;
                ++n7;
            }
        }
        if (n8 > 0 && !string.equals("Technology")) {
            ey ey2 = ey.d(this.qy[n2][n].getValue("Id"));
            n6 = string.equals("Technology") ? this.qy[n2][n].J("MaxAmount") : (string.equals("Substance") ? (ey2 == null ? gt2.bE : Math.max(1, gt2.bE * ey2.bj())) : (string.equals("Product") ? (ey2 == null ? gt2.bF : Math.max(1, gt2.bF * ey2.bj())) : 1));
            n5 = 0;
            while (n5 < gt2.qy.length) {
                n4 = 0;
                while (n4 < gt2.qy[n5].length) {
                    if (gt2.qy[n5][n4] == null && gt2.qz[n5][n4] && !gt2.l(n4, n5)) {
                        n3 = n8 > n6 ? n6 : n8;
                        hc.info("  new stack: " + n3);
                        gt2.a(n4, n5, string, object, n3, n6, d, bl);
                        bl2 = true;
                        if ((n8 -= n3) == 0) break;
                    }
                    ++n4;
                }
                if (n8 == 0) break;
                ++n5;
            }
        }
        if (!bl2) {
            return false;
        }
        if (n8 == 0) {
            eV eV2 = this.qt.d("Slots");
            n6 = 0;
            while (n6 < eV2.size()) {
                eY eY2 = eV2.V(n6);
                if (n == eY2.J("Index.X") && n2 == eY2.J("Index.Y")) {
                    eV2.ac(n6);
                }
                ++n6;
            }
            this.qy[n2][n] = null;
        } else {
            hc.info("  remainder: " + n8);
            this.qy[n2][n].b("Amount", new Integer(n8));
        }
        return true;
    }

    public int a(ey ey2, int n) {
        int n2;
        int n3;
        int n4;
        String string;
        int n5;
        switch (ey2.ba()) {
            case jN: {
                return n;
            }
            case jP: {
                n5 = Math.max(1, this.bE * ey2.bj());
                string = "Substance";
                break;
            }
            case jO: {
                n5 = Math.max(1, this.bF * ey2.bj());
                string = "Product";
                break;
            }
            case jQ: {
                n5 = Math.max(1, this.bF * ey2.bj());
                string = "Techbox";
                break;
            }
            default: {
                return n;
            }
        }
        if (n > 0) {
            int n6 = 0;
            while (n6 < this.qy.length) {
                n4 = 0;
                while (n4 < this.qy[n6].length) {
                    if (this.qy[n6][n4] != null && string.equals(this.qy[n6][n4].getValueAsString("Type.InventoryType")) && ey2.getID().equals(this.qy[n6][n4].getValue("Id")) && (n3 = this.qy[n6][n4].J("Amount")) < (n2 = this.qy[n6][n4].J("MaxAmount"))) {
                        int n7 = n > n2 - n3 ? n2 - n3 : n;
                        hc.info("  added to existing stack: " + n7);
                        this.qy[n6][n4].b("Amount", new Integer(n3 + n7));
                        if ((n -= n7) == 0) break;
                    }
                    ++n4;
                }
                if (n == 0) break;
                ++n6;
            }
        }
        if (n > 0) {
            Object object = ey2.aZ();
            n4 = 0;
            while (n4 < this.qy.length) {
                n3 = 0;
                while (n3 < this.qy[n4].length) {
                    if (this.qy[n4][n3] == null && this.qz[n4][n3] && !this.l(n3, n4)) {
                        n2 = n > n5 ? n5 : n;
                        hc.info("  new stack: " + n2);
                        this.a(n3, n4, string, object, n2, n5, 0.0, true);
                        if ((n -= n2) == 0) break;
                    }
                    ++n3;
                }
                if (n == 0) break;
                ++n4;
            }
        }
        return n;
    }

    public boolean a(int n, int n2, ey ey2) {
        int n3;
        int n4;
        Object object;
        if (this.qy[n2][n] != null) {
            return false;
        }
        switch (ey2.ba()) {
            case jN: {
                object = ey2.bf();
                if (object == null) {
                    n4 = -1;
                    n3 = 1;
                    break;
                }
                n4 = (Integer)object;
                n3 = (Integer)object;
                break;
            }
            case jP: {
                n4 = n3 = Math.max(1, this.bE * ey2.bj());
                break;
            }
            case jO: {
                n4 = n3 = Math.max(1, this.bF * ey2.bj());
                break;
            }
            case jQ: {
                n4 = n3 = Math.max(1, this.bF * ey2.bj());
                break;
            }
            default: {
                return false;
            }
        }
        object = ey2.aZ();
        this.a(n, n2, ey2.ba().toString(), object, n4, n3, 0.0, true);
        return true;
    }

    private void a(int n, int n2, String string, Object object, int n3, int n4, double d, boolean bl) {
        eV eV2 = this.qt.d("Slots");
        eY eY2 = gR.az("slot");
        eY2.b("Type.InventoryType", string);
        eY2.b("Id", object);
        eY2.b("Amount", new Integer(n3));
        eY2.b("MaxAmount", new Integer(n4));
        eY2.b("DamageFactor", new Double(d));
        eY2.b("FullyInstalled", new Boolean(bl));
        eY2.b("Index.X", n);
        eY2.b("Index.Y", n2);
        eV2.f(eY2);
        this.qy[n2][n] = eY2;
    }

    public boolean aq(String string) {
        int n = 0;
        while (n < this.qy.length) {
            int n2 = 0;
            while (n2 < this.qy[n].length) {
                if (this.qy[n][n2] != null && string.equals(this.qy[n][n2].getValue("Type"))) {
                    return true;
                }
                ++n2;
            }
            ++n;
        }
        return false;
    }

    public boolean h(int n, int n2) {
        return this.qz[n2][n];
    }

    public void i(int n, int n2) {
        if (!this.qz[n2][n]) {
            eY eY2 = new eY();
            eY2.b("X", n);
            eY2.b("Y", n2);
            this.qt.d("ValidSlotIndices").f(eY2);
            this.qz[n2][n] = true;
        }
    }

    public void j(int n, int n2) {
        if (this.qz[n2][n]) {
            if (this.qy[n2][n] != null) {
                throw new RuntimeException("Cannot disable slot in use");
            }
            eV eV2 = this.qt.d("ValidSlotIndices");
            int n3 = 0;
            while (n3 < eV2.size()) {
                eY eY2 = eV2.V(n3);
                if (n == eY2.J("X") && n2 == eY2.J("Y")) {
                    eV2.ac(n3);
                }
                ++n3;
            }
            this.qz[n2][n] = false;
        }
    }

    public boolean do() {
        return this.qu;
    }

    public boolean dp() {
        return this.qw;
    }

    public boolean dq() {
        return this.qx;
    }

    public boolean k(int n, int n2) {
        eV eV2 = this.qt.d("SpecialSlots");
        int n3 = 0;
        while (n3 < eV2.size()) {
            eY eY2 = eV2.V(n3);
            if (eY2.J("Index.X") == n && eY2.J("Index.Y") == n2) {
                return "TechBonus".equals(eY2.getValueAsString("Type.InventorySpecialSlotType"));
            }
            ++n3;
        }
        return false;
    }

    public void a(int n, int n2, boolean bl) {
        eV eV2 = this.qt.d("SpecialSlots");
        int n3 = 0;
        while (n3 < eV2.size()) {
            eY eY2 = eV2.V(n3);
            if (eY2.J("Index.X") == n && eY2.J("Index.Y") == n2) {
                if (!bl) {
                    eV2.ac(n3);
                } else {
                    eY2.b("Type.InventorySpecialSlotType", "TechBonus");
                }
                return;
            }
            ++n3;
        }
        if (bl) {
            eY eY3 = gR.az("specialSlot");
            eY3.b("Type.InventorySpecialSlotType", "TechBonus");
            eY3.b("Index.X", n);
            eY3.b("Index.Y", n2);
            eV2.f(eY3);
        }
    }

    public boolean dr() {
        int n;
        boolean[][] blArray = new boolean[this.height][this.width];
        eV eV2 = this.qt.d("SpecialSlots");
        int n2 = 0;
        while (n2 < eV2.size()) {
            eY eY2 = eV2.V(n2);
            n = eY2.J("Index.X");
            int n3 = eY2.J("Index.Y");
            if (n < this.width && n3 < this.height) {
                blArray[n3][n] = "TechBonus".equals(eY2.getValueAsString("Type.InventorySpecialSlotType"));
            }
            ++n2;
        }
        n2 = 0;
        int n4 = 0;
        while (n4 < this.height) {
            n = 0;
            while (n < this.width) {
                if (!blArray[n4][n]) {
                    eY eY3 = gR.az("specialSlot");
                    eY3.b("Type.InventorySpecialSlotType", "TechBonus");
                    eY3.b("Index.X", n);
                    eY3.b("Index.Y", n4);
                    eV2.f(eY3);
                    n2 = 1;
                }
                ++n;
            }
            ++n4;
        }
        return n2 != 0;
    }

    public boolean l(int n, int n2) {
        eV eV2 = this.qt.d("SpecialSlots");
        int n3 = 0;
        while (n3 < eV2.size()) {
            eY eY2 = eV2.V(n3);
            if ("Broken".equals(eY2.getValueAsString("Type.InventorySpecialSlotType")) && n == eY2.J("Index.X") && n2 == eY2.J("Index.Y")) {
                return true;
            }
            if ("BlockedByBrokenTech".equals(eY2.getValueAsString("Type.InventorySpecialSlotType")) && n == eY2.J("Index.X") && n2 == eY2.J("Index.Y")) {
                gu gu2 = this.f(n, n2);
                if (gu2 == null || gu2.dC() == 0.0) {
                    hc.info(String.valueOf(this.getFullName()) + " slot[" + n + "," + n2 + "] appears to be broken, ignoring");
                    return false;
                }
                return true;
            }
            ++n3;
        }
        return false;
    }

    public void m(int n, int n2) {
        eV eV2 = this.qt.d("SpecialSlots");
        int n3 = 0;
        while (n3 < eV2.size()) {
            eY eY2 = eV2.V(n3);
            if ("Broken".equals(eY2.getValueAsString("Type.InventorySpecialSlotType")) && n == eY2.J("Index.X") && n2 == eY2.J("Index.Y")) {
                eV2.ac(n3);
            }
            if ("BlockedByBrokenTech".equals(eY2.getValueAsString("Type.InventorySpecialSlotType")) && n == eY2.J("Index.X") && n2 == eY2.J("Index.Y")) {
                gu gu2 = this.f(n, n2);
                if (gu2 != null && gu2.dC() != 0.0) {
                    this.g(n, n2);
                }
                eV2.ac(n3);
            }
            ++n3;
        }
    }

    public boolean ds() {
        boolean bl = false;
        eV eV2 = this.qt.d("SpecialSlots");
        int n = 0;
        while (n < eV2.size()) {
            eY eY2 = eV2.V(n);
            if ("Broken".equals(eY2.getValueAsString("Type.InventorySpecialSlotType"))) {
                eV2.ac(n--);
                bl = true;
            }
            if ("BlockedByBrokenTech".equals(eY2.getValueAsString("Type.InventorySpecialSlotType"))) {
                gu gu2 = this.f(eY2.J("Index.X"), eY2.J("Index.Y"));
                if (gu2 != null && gu2.dC() != 0.0) {
                    this.g(eY2.J("Index.X"), eY2.J("Index.Y"));
                }
                eV2.ac(n--);
                bl = true;
            }
            ++n;
        }
        n = 0;
        while (n < this.qy.length) {
            int n2 = 0;
            while (n2 < this.qy[n].length) {
                if (this.qy[n][n2] != null && this.qy[n][n2].L("DamageFactor") != 0.0) {
                    this.qy[n][n2].b("DamageFactor", new Double(0.0));
                    this.qy[n][n2].b("FullyInstalled", new Boolean(true));
                    bl = true;
                }
                ++n2;
            }
            ++n;
        }
        return bl;
    }

    private static String l(Object object) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(' ');
        if (object instanceof fg) {
            stringBuffer.append(((fg)object).bP());
        } else if (object != null) {
            stringBuffer.append(object.toString());
        }
        if (stringBuffer.length() > 10) {
            stringBuffer.delete(10, stringBuffer.length());
        }
        while (stringBuffer.length() < 11) {
            stringBuffer.append(' ');
        }
        return stringBuffer.toString();
    }

    public void a(PrintStream printStream) {
        printStream.print("\t|");
        int n = 0;
        while (n < this.qy[0].length) {
            printStream.print("-----------|");
            ++n;
        }
        printStream.println();
        n = 0;
        while (n < this.qy.length) {
            printStream.print("\t|");
            int n2 = 0;
            while (n2 < this.qy[0].length) {
                if (!this.qz[n][n2]) {
                    printStream.print("###########|");
                } else if (this.qy[n][n2] != null) {
                    printStream.print(String.valueOf(gt.l(gt.r(this.qy[n][n2]))) + "|");
                } else {
                    printStream.print("           |");
                }
                ++n2;
            }
            printStream.println();
            printStream.print("\t|");
            n2 = 0;
            while (n2 < this.qy[n].length) {
                if (!this.qz[n][n2]) {
                    printStream.print("###########|");
                } else if (this.qy[n][n2] != null) {
                    printStream.print(String.valueOf(gt.l(gt.s(this.qy[n][n2]))) + "|");
                } else {
                    printStream.print("           |");
                }
                ++n2;
            }
            printStream.println();
            printStream.print("\t|");
            n2 = 0;
            while (n2 < this.qy[0].length) {
                if (!this.qz[n][n2]) {
                    printStream.print("###########|");
                } else if (this.qy[n][n2] != null) {
                    int n3 = gt.t(this.qy[n][n2]);
                    if (n3 < 0) {
                        printStream.print("           |");
                    } else {
                        printStream.print(String.valueOf(gt.l(String.valueOf(Integer.toString(n3)) + "/" + Integer.toString(gt.u(this.qy[n][n2])))) + "|");
                    }
                } else {
                    printStream.print("           |");
                }
                ++n2;
            }
            printStream.println();
            printStream.print("\t|");
            n2 = 0;
            while (n2 < this.qy[0].length) {
                printStream.print("-----------|");
                ++n2;
            }
            printStream.println();
            ++n;
        }
    }

    private static String r(eY eY2) {
        return eY2.getValueAsString("Type.InventoryType");
    }

    private static Object s(eY eY2) {
        return eY2.getValue("Id");
    }

    private static int t(eY eY2) {
        return eY2.J("Amount");
    }

    private static int u(eY eY2) {
        return eY2.J("MaxAmount");
    }

    public boolean dt() {
        boolean bl = false;
        int n = 0;
        while (n < this.qy.length) {
            int n2 = 0;
            while (n2 < this.qy[n].length) {
                int n3;
                if (this.qy[n][n2] != null && "Technology".equals(this.qy[n][n2].getValueAsString("Type.InventoryType")) && this.qy[n][n2].J("Amount") >= 0 && (n3 = this.qy[n][n2].J("MaxAmount")) > 0) {
                    this.qy[n][n2].b("Amount", new Integer(n3));
                    bl = true;
                }
                ++n2;
            }
            ++n;
        }
        return bl;
    }

    public boolean du() {
        boolean bl = false;
        int n = 0;
        while (n < this.qy.length) {
            int n2 = 0;
            while (n2 < this.qy[n].length) {
                int n3;
                if (this.qy[n][n2] != null && !"Technology".equals(this.qy[n][n2].getValueAsString("Type.InventoryType")) && (n3 = this.qy[n][n2].J("MaxAmount")) > 1) {
                    this.qy[n][n2].b("Amount", new Integer(n3));
                    bl = true;
                }
                ++n2;
            }
            ++n;
        }
        return bl;
    }

    public boolean dv() {
        boolean bl = false;
        int n = 0;
        while (n < this.height) {
            int n2 = 0;
            while (n2 < this.width) {
                if (!this.qz[n][n2]) {
                    eY eY2 = new eY();
                    eY2.b("X", n2);
                    eY2.b("Y", n);
                    this.qt.d("ValidSlotIndices").f(eY2);
                    this.qz[n][n2] = true;
                    bl = true;
                }
                ++n2;
            }
            ++n;
        }
        return bl;
    }

    public String toString() {
        return this.getFullName();
    }
}
