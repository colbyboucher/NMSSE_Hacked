/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import java.awt.Component;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Rectangle;
import java.awt.Window;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.security.GeneralSecurityException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;
import nomanssave.A;
import nomanssave.B;
import nomanssave.C;
import nomanssave.D;
import nomanssave.E;
import nomanssave.F;
import nomanssave.G;
import nomanssave.I;
import nomanssave.X;
import nomanssave.a;
import nomanssave.aD;
import nomanssave.aH;
import nomanssave.aJ;
import nomanssave.aj;
import nomanssave.ap;
import nomanssave.bE;
import nomanssave.ba;
import nomanssave.bd;
import nomanssave.bl;
import nomanssave.c;
import nomanssave.cK;
import nomanssave.cT;
import nomanssave.cl;
import nomanssave.cp;
import nomanssave.cs;
import nomanssave.cv;
import nomanssave.cy;
import nomanssave.dE;
import nomanssave.dN;
import nomanssave.dj;
import nomanssave.dz;
import nomanssave.eV;
import nomanssave.eX;
import nomanssave.eY;
import nomanssave.eb;
import nomanssave.ej;
import nomanssave.en;
import nomanssave.ep;
import nomanssave.fR;
import nomanssave.fe;
import nomanssave.fh;
import nomanssave.fn;
import nomanssave.fq;
import nomanssave.fr;
import nomanssave.fs;
import nomanssave.ft;
import nomanssave.gB;
import nomanssave.gC;
import nomanssave.gE;
import nomanssave.gH;
import nomanssave.gM;
import nomanssave.gO;
import nomanssave.gR;
import nomanssave.gS;
import nomanssave.ge;
import nomanssave.gf;
import nomanssave.gj;
import nomanssave.gl;
import nomanssave.gm;
import nomanssave.gn;
import nomanssave.go;
import nomanssave.gp;
import nomanssave.gt;
import nomanssave.gv;
import nomanssave.gz;
import nomanssave.hc;
import nomanssave.hl;
import nomanssave.u;
import nomanssave.v;
import nomanssave.w;
import nomanssave.x;
import nomanssave.z;

public class Application {
    public static final String VERSION = "1.19.0";
    public static final String RELEASE = "VOYAGERS";
    private static final String J = "https://github.com/goatfungus/NMSSaveEditor";
    private static final String K = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789-_";
    private static Application L;
    private static HashMap M;
    private JFrame N;
    private JTabbedPane O;
    private JLabel P;
    private JLabel Q;
    private JComboBox R;
    private JComboBox S;
    private JLabel T;
    private JLabel U;
    private JLabel V;
    private JButton W;
    private JButton X;
    private JButton Y;
    private JMenuItem Z;
    private JMenuItem aa;
    private JMenuItem ab;
    private List ac;
    private JMenuItem ad;
    private static final int ae = 0;
    private static final int af = 1;
    private static final int ag = 2;
    private static final int ah = 3;
    private static final int ai = 4;
    private static final int aj = 5;
    private static final int ak = 6;
    private static final int al = 7;
    private static final int am = 8;
    private static final int an = 9;
    private static final int ao = 10;
    private static final int ap = 11;
    private static final int aq = 12;
    private static final int ar = 13;
    private aJ as;
    private dj at;
    private dN au;
    private eb av;
    private bd aw;
    private bl ax;
    private ep ay;
    private X az;
    private I aA;
    private dE aB;
    private ap aC;
    private bE aD;
    private c aE;
    private fq aF;
    private ft[] aG;
    private int aH;
    private fs[] aI;
    private int aJ;
    private eY aK;
    private boolean aL;
    private fr aM;
    private eY aN;
    private boolean aO;
    private boolean aP;
    private boolean aQ = false;
    private boolean aR = false;
    private boolean aS = false;
    private boolean aT = false;
    private boolean aU = false;
    private fe aV = (string, object, object2) -> {
        this.aO = true;
        this.aP = true;
        if (object2 == null) {
            hc.info("Removing " + string);
            return;
        }
        String string2 = object2 instanceof eY ? "[OBJECT]" : (object2 instanceof eV ? "[ARRAY]" : object2.toString());
        hc.info("Setting " + string + ": " + string2);
    };
    private fe aW = (string, object, object2) -> {
        this.aL = true;
        if (string.startsWith("PlayerStateData.Multitools")) {
            int n = this.aK.J("PlayerStateData.ActiveMultioolIndex");
            if (string.startsWith("PlayerStateData.Multitools[" + n + "].Store.")) {
                eY eY2 = this.aK.H("PlayerStateData.Multitools[" + n + "].Store");
                this.aK.b("PlayerStateData.WeaponInventory", (Object)eY2.bE());
            } else if (string.equals("PlayerStateData.Multitools[" + n + "].Seed[1]")) {
                this.aK.b("PlayerStateData.CurrentWeapon.GenerationSeed[1]", object2);
            } else if (string.equals("PlayerStateData.Multitools[" + n + "].Resource.Filename")) {
                this.aK.b("PlayerStateData.CurrentWeapon.Filename", object2);
            }
        }
        if (object2 == null) {
            hc.info("Removing " + string);
            return;
        }
        String string2 = object2 instanceof eY ? "OBJECT" : (object2 instanceof eV ? "ARRAY[" + ((eV)object2).size() + "]" : fh.b(object2, false));
        hc.info("Setting " + string + ": " + string2);
    };
    private fR aX = new u(this);

    static {
        M = new HashMap();
    }

    public static String a(long l) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("h:mm a, E MMM d, yyyy");
        return simpleDateFormat.format(new Date(l));
    }

    public static String b(long l) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MMM d, HH:mm");
        return simpleDateFormat.format(new Date(l));
    }

    private static String a(String string, String string2) {
        if (string == null) {
            return string2;
        }
        StringBuffer stringBuffer = new StringBuffer();
        int n = 0;
        while (n < string.length()) {
            char c2 = string.charAt(n);
            if (K.indexOf(c2) >= 0) {
                stringBuffer.append(c2);
            } else if (Character.isWhitespace(c2)) {
                stringBuffer.append('_');
            }
            ++n;
        }
        return stringBuffer.length() != 0 ? stringBuffer.toString() : string2;
    }

    public static Application e() {
        return L;
    }

    public static void main(String[] stringArray) {
        boolean bl2;
        int n = 0;
        if (stringArray.length > n && stringArray[n].equals("-autoupdate")) {
            ++n;
            bl2 = true;
        } else {
            bl2 = false;
        }
        nomanssave.aH.init(!bl2);
        hc.info("Starting Editor...");
        new Thread(() -> cK.aA()).start();
        EventQueue.invokeLater(new w(bl2));
    }

    public static ImageIcon a(String string) {
        InputStream inputStream;
        BufferedImage bufferedImage = (BufferedImage)M.get(string);
        if (bufferedImage == null && (inputStream = Application.class.getResourceAsStream("icons/" + string)) != null) {
            try {
                bufferedImage = ImageIO.read(inputStream);
                M.put(string, bufferedImage);
            }
            catch (IOException iOException) {
                hc.info("Error loading icon: " + string);
            }
            catch (RuntimeException runtimeException) {
                hc.info("Error loading icon: " + string);
            }
        }
        return bufferedImage == null ? null : new ImageIcon(bufferedImage);
    }

    public static ImageIcon a(String string, int n, int n2) {
        InputStream inputStream;
        BufferedImage bufferedImage = (BufferedImage)M.get(string);
        if (bufferedImage == null && (inputStream = Application.class.getResourceAsStream("icons/" + string)) != null) {
            try {
                bufferedImage = ImageIO.read(inputStream);
                M.put(string, bufferedImage);
            }
            catch (IOException iOException) {
                hc.info("Error loading icon: " + string);
            }
            catch (RuntimeException runtimeException) {
                hc.info("Error loading icon: " + string);
            }
        }
        return bufferedImage == null ? null : new ImageIcon(bufferedImage.getScaledInstance(n, n2, 4));
    }

    private void f() {
        int n;
        if (this.aR) {
            this.aR = false;
        }
        if (this.aS) {
            this.aS = false;
            n = this.aH < 0 ? -1 : this.aG[this.aH].getIndex();
            this.aG = (ft[])Arrays.asList(this.aF.bU()).stream().filter(ft2 -> ft2.getIndex() == n || !ft2.isEmpty()).toArray(ft[]::new);
            this.aH = -1;
            int n2 = 0;
            while (n2 < this.aG.length) {
                if (this.aG[n2].getIndex() == n) {
                    this.aH = n2;
                    break;
                }
                ++n2;
            }
            if (n >= 0 && this.aH < 0) {
                hc.warn("Slot " + (n + 1) + " was not reloaded!");
                this.aI = new fs[0];
                this.aJ = -1;
            }
            this.R.updateUI();
        }
        this.aT &= this.aH >= 0;
        if (this.aT) {
            this.aT = false;
            String string = this.aJ < 0 ? null : this.aI[this.aJ].K();
            long l = this.aJ < 0 ? Long.MIN_VALUE : this.aI[this.aJ].lastModified();
            fn fn2 = this.aJ < 0 ? null : this.aI[this.aJ].L();
            this.aI = this.aG[this.aH].bX();
            this.aJ = -1;
            int n3 = 0;
            while (n3 < this.aI.length) {
                if (this.aI[n3].K().equals(string)) {
                    this.aJ = n3;
                    break;
                }
                ++n3;
            }
            if (string != null && this.aJ < 0) {
                this.aU = false;
                n3 = JOptionPane.showConfirmDialog(this.N, "Save file has been deleted externally. Would you like to reload?\nNOTE: All changes made in the editor will be lost.", "Reload File", 0);
                if (n3 == 0) {
                    this.aJ = 0;
                    this.l();
                } else {
                    fs[] fsArray = new fs[this.aI.length + 1];
                    fsArray[0] = new F(this, string, l, fn2, this.aK);
                    System.arraycopy(this.aI, 0, fsArray, 1, this.aI.length);
                    this.aI = fsArray;
                    this.aJ = 0;
                }
            }
            this.S.updateUI();
        }
        this.aU &= this.aJ >= 0;
        if (this.aU) {
            this.aU = false;
            n = JOptionPane.showConfirmDialog(this.N, "Save file has been modified externally. Would you like to reload?\nNOTE: All changes made in the editor will be lost.", "Reload File", 0);
            if (n == 0) {
                this.l();
            } else {
                this.aL = true;
            }
        }
    }

    private Application(boolean bl2) {
        String string2 = nomanssave.aH.getProperty("GameStorage");
        String string3 = nomanssave.aH.getProperty("GameSaveDir");
        fq fq2 = this.aF = string3 == null ? null : fq.a(string2, new File(string3), this.aX);
        if (this.aF == null) {
            this.aG = new ft[0];
            this.aH = -1;
            this.aI = new fs[0];
            this.aJ = -1;
            this.aM = null;
            this.aN = null;
        } else {
            this.aG = this.aF.bV();
            this.aH = -1;
            this.aI = new fs[0];
            this.aJ = -1;
            if (string2 == null) {
                string2 = fq.c(this.aF);
                nomanssave.aH.setProperty("GameStorage", string2);
            }
            hc.debug("Storage: " + string2);
            hc.debug("Save Path: " + this.aF.bS().getAbsolutePath());
            this.aM = null;
            this.aN = null;
            try {
                hc.info("Reading account data...");
                this.aM = this.aF.bT();
                eY eY2 = this.aN = this.aM == null ? null : this.aM.M();
                if (this.aN != null) {
                    this.aN.a(this.aV);
                }
            }
            catch (IOException iOException) {
                hc.a("Error reading account data", iOException);
            }
        }
        this.initialize();
        new x(this, bl2).start();
    }

    public JFrame g() {
        return this.N;
    }

    public void a(gH gH2) {
        File file = nomanssave.aH.cF;
        if (!file.exists() && !file.mkdir()) {
            file = nomanssave.aH.cD;
        }
        cT cT2 = cT.aC();
        String string = Application.a(gH2.getName(), "Ship");
        cT2.setCurrentDirectory(file);
        cT2.setSelectedFile(new File(file, string));
        if (cT2.showSaveDialog(this.N) == 0) {
            try {
                File file2 = cT2.getSelectedFile();
                if (!file2.getName().endsWith(".sh0")) {
                    file2 = new File(file2.getParentFile(), String.valueOf(file2.getName()) + ".sh0");
                }
                gH2.a(file2, cT2.aw());
            }
            catch (RuntimeException runtimeException) {
                hc.a("Ship export error", runtimeException);
                this.c("An error occured during export.");
            }
            catch (IOException iOException) {
                hc.a("Ship export error", iOException);
                this.c("An error occured during export.");
            }
        }
    }

    public void a(gv gv2) {
        File file = nomanssave.aH.cF;
        if (!file.exists() && !file.mkdir()) {
            file = nomanssave.aH.cD;
        }
        cv cv2 = cv.ax();
        String string = Application.a(gv2.getName(), "Weapon");
        cv2.setCurrentDirectory(file);
        cv2.setSelectedFile(new File(file, string));
        if (cv2.showSaveDialog(this.N) == 0) {
            try {
                File file2 = cv2.getSelectedFile();
                if (!file2.getName().endsWith(".wp0")) {
                    file2 = new File(file2.getParentFile(), String.valueOf(file2.getName()) + ".wp0");
                }
                gv2.j(file2);
            }
            catch (RuntimeException runtimeException) {
                hc.a("Weapon export error", runtimeException);
                this.c("An error occured during export.");
            }
            catch (IOException iOException) {
                hc.a("Weapon export error", iOException);
                this.c("An error occured during export.");
            }
        }
    }

    public void a(gj gj2) {
        File file = nomanssave.aH.cF;
        if (!file.exists() && !file.mkdir()) {
            file = nomanssave.aH.cD;
        }
        String string = "." + gj2.cL().name().toLowerCase();
        cp cp2 = cp.at();
        String string2 = Application.a(gj2.getName(), gj2.cL().name());
        cp2.setCurrentDirectory(file);
        cp2.setSelectedFile(new File(file, string2));
        if (cp2.showSaveDialog(this.N) == 0) {
            try {
                File file2 = cp2.getSelectedFile();
                if (!file2.getName().endsWith(string)) {
                    file2 = new File(file2.getParentFile(), String.valueOf(file2.getName()) + string);
                }
                gj2.j(file2);
            }
            catch (RuntimeException runtimeException) {
                hc.a("Companion export error", runtimeException);
                this.c("An error occured during export.");
            }
            catch (IOException iOException) {
                hc.a("Companion export error", iOException);
                this.c("An error occured during export.");
            }
        }
    }

    public gH h() {
        eY eY2;
        if (this.aK == null || (eY2 = this.aK.H("PlayerStateData")) == null) {
            return null;
        }
        File file = nomanssave.aH.cF.exists() ? nomanssave.aH.cF : nomanssave.aH.cD;
        cT cT2 = cT.aC();
        cT2.setCurrentDirectory(file);
        if (cT2.showOpenDialog(this.N) == 0) {
            try {
                File file2 = cT2.getSelectedFile();
                gH gH2 = gH.c(eY2, file2);
                this.aL = true;
                return gH2;
            }
            catch (RuntimeException runtimeException) {
                hc.a("Ship import error", runtimeException);
                this.c("An error occured during import.");
            }
            catch (IOException iOException) {
                hc.a("Ship import error", iOException);
                this.c("An error occured during import.");
            }
        }
        return null;
    }

    public gv i() {
        eY eY2;
        if (this.aK == null || (eY2 = this.aK.H("PlayerStateData")) == null) {
            return null;
        }
        File file = nomanssave.aH.cF.exists() ? nomanssave.aH.cF : nomanssave.aH.cD;
        cv cv2 = cv.ax();
        cv2.setCurrentDirectory(file);
        if (cv2.showOpenDialog(this.N) == 0) {
            try {
                File file2 = cv2.getSelectedFile();
                gv gv2 = gv.b(eY2, file2);
                this.aL = true;
                return gv2;
            }
            catch (RuntimeException runtimeException) {
                hc.a("Weapon import error", runtimeException);
                this.c("An error occured during import.");
            }
            catch (IOException iOException) {
                hc.a("Weapon import error", iOException);
                this.c("An error occured during import.");
            }
        }
        return null;
    }

    public gj j() {
        eY eY2;
        if (this.aK == null || (eY2 = this.aK.H("PlayerStateData")) == null) {
            return null;
        }
        File file = nomanssave.aH.cF.exists() ? nomanssave.aH.cF : nomanssave.aH.cD;
        cp cp2 = cp.at();
        cp2.setCurrentDirectory(file);
        if (cp2.showOpenDialog(this.N) == 0) {
            try {
                File file2 = cp2.getSelectedFile();
                gj gj2 = gj.a(eY2, file2);
                this.aL = true;
                return gj2;
            }
            catch (RuntimeException runtimeException) {
                hc.a("Companion import error", runtimeException);
                this.c("An error occured during import.");
            }
            catch (IOException iOException) {
                hc.a("Companion import error", iOException);
                this.c("An error occured during import.");
            }
        }
        return null;
    }

    public void a(gf gf2) {
        File file = nomanssave.aH.cE;
        if (!file.exists() && !file.mkdir()) {
            file = nomanssave.aH.cD;
        }
        cl cl2 = cl.ar();
        String string = Application.a(gf2.getName(), "Base");
        cl2.setCurrentDirectory(file);
        cl2.setSelectedFile(new File(file, string));
        if (cl2.showSaveDialog(this.N) == 0) {
            try {
                File file2 = cl2.getSelectedFile();
                if (!file2.getName().endsWith(".pb3")) {
                    file2 = new File(file2.getParentFile(), String.valueOf(file2.getName()) + ".pb3");
                }
                if (file2.exists() && JOptionPane.showConfirmDialog(this.N, "Are you sure you want to overwrite this existing backup file?", "Confirm", 2) != 0) {
                    return;
                }
                gS.d(gf2.cH(), file2);
            }
            catch (RuntimeException runtimeException) {
                hc.a("Base backup error", runtimeException);
                this.c("An error occured during backup.");
            }
            catch (IOException iOException) {
                hc.a("Base backup error", iOException);
                this.c("An error occured during backup.");
            }
            catch (GeneralSecurityException generalSecurityException) {
                hc.a("Base backup error", generalSecurityException);
                this.c("An error occured during backup.");
            }
        }
    }

    public boolean b(gf gf2) {
        File file = nomanssave.aH.cE.exists() ? nomanssave.aH.cE : nomanssave.aH.cD;
        cl cl2 = cl.ar();
        cl2.setCurrentDirectory(file);
        if (cl2.showOpenDialog(this.N) == 0) {
            block5: {
                if (JOptionPane.showConfirmDialog(this.N, "Are you sure you want to overwrite your existing base?", "Confirm", 2) == 0) break block5;
                return false;
            }
            try {
                File file2 = cl2.getSelectedFile();
                gS.e(gf2.cH(), file2);
                this.aL = true;
                return true;
            }
            catch (IOException iOException) {
                hc.a("Base restore error", iOException);
                this.c("An error occured during backup.");
            }
            catch (GeneralSecurityException generalSecurityException) {
                hc.a("Base restore error", generalSecurityException);
                this.c("An error occured during backup.");
            }
        }
        return false;
    }

    public void a(gm gm2) {
        gn gn2 = gm2.cZ();
        if (gn2 == null) {
            return;
        }
        File file = nomanssave.aH.cE;
        if (!file.exists() && !file.mkdir()) {
            file = nomanssave.aH.cD;
        }
        cs cs2 = cs.av();
        String string = Application.a(gn2.getName(), "Freighter");
        cs2.setCurrentDirectory(file);
        cs2.setSelectedFile(new File(file, string));
        if (cs2.showSaveDialog(this.N) == 0) {
            try {
                File file2 = cs2.getSelectedFile();
                if (!file2.getName().endsWith(".fb3")) {
                    file2 = new File(file2.getParentFile(), String.valueOf(file2.getName()) + ".fb3");
                }
                if (file2.exists() && JOptionPane.showConfirmDialog(this.N, "Are you sure you want to overwrite this existing backup file?", "Confirm", 2) != 0) {
                    return;
                }
                HashMap<String, Object> hashMap = new HashMap<String, Object>();
                hashMap.put("HomeSeed", gm2.cU());
                hashMap.put("ResourceSeed", gm2.cV());
                hashMap.put("Name", gm2.getName());
                hashMap.put("TypeClass", gm2.cW());
                hashMap.put("Resource", gm2.cT());
                hashMap.put("FleetCoordination", gm2.cY());
                hashMap.put("Hyperdrive", gm2.cX());
                eY eY2 = this.aK.H("PlayerStateData");
                eY eY3 = eY2.H("FreighterInventory").bE();
                eY eY4 = eY2.H("FreighterInventory_TechOnly").bE();
                eY eY5 = eY2.H("FreighterInventory_Cargo").bE();
                if (!cs2.aw()) {
                    eY eY6;
                    eV eV2 = eY3.d("Slots");
                    int n = 0;
                    while (n < eV2.size()) {
                        eY6 = eV2.V(n);
                        if (!eY6.getValueAsString("Type.InventoryType").equals("Technology")) {
                            eV2.ac(n--);
                        }
                        ++n;
                    }
                    eV2 = eY5.d("Slots");
                    n = 0;
                    while (n < eV2.size()) {
                        eY6 = eV2.V(n);
                        if (!eY6.getValueAsString("Type.InventoryType").equals("Technology")) {
                            eV2.ac(n--);
                        }
                        ++n;
                    }
                }
                hashMap.put("Inventory", eY3);
                hashMap.put("InventoryTech", eY4);
                hashMap.put("InventoryCargo", eY5);
                gS.a(gn2.cH(), hashMap, file2);
            }
            catch (RuntimeException runtimeException) {
                hc.a("Freighter backup error", runtimeException);
                this.c("An error occured during backup.");
            }
            catch (IOException iOException) {
                hc.a("Freighter backup error", iOException);
                this.c("An error occured during backup.");
            }
            catch (GeneralSecurityException generalSecurityException) {
                hc.a("Freighter backup error", generalSecurityException);
                this.c("An error occured during backup.");
            }
        }
    }

    public boolean b(gm gm2) {
        gn gn2 = gm2.cZ();
        if (gn2 == null) {
            return false;
        }
        File file = nomanssave.aH.cE.exists() ? nomanssave.aH.cE : nomanssave.aH.cD;
        cs cs2 = cs.av();
        cs2.setCurrentDirectory(file);
        if (cs2.showOpenDialog(this.N) == 0) {
            block18: {
                if (JOptionPane.showConfirmDialog(this.N, "Are you sure you want to overwrite your existing freighter?", "Confirm", 2) == 0) break block18;
                return false;
            }
            try {
                File file2 = cs2.getSelectedFile();
                HashMap hashMap = new HashMap();
                gS.b(gn2.cH(), hashMap, file2);
                eY eY2 = this.aK.H("PlayerStateData");
                boolean bl2 = false;
                for (Map.Entry entry : hashMap.entrySet()) {
                    if (((String)entry.getKey()).equals("HomeSeed")) {
                        gm2.ah((String)entry.getValue());
                    }
                    if (((String)entry.getKey()).equals("ResourceSeed")) {
                        gm2.ai((String)entry.getValue());
                    }
                    if (((String)entry.getKey()).equals("Name")) {
                        gm2.setName((String)entry.getValue());
                    }
                    if (((String)entry.getKey()).equals("TypeClass")) {
                        gm2.aj((String)entry.getValue());
                    }
                    if (((String)entry.getKey()).equals("Type")) {
                        gm2.ag(go.valueOf((String)entry.getValue()).K());
                    }
                    if (((String)entry.getKey()).equals("Resource")) {
                        gm2.ag((String)entry.getValue());
                    }
                    if (((String)entry.getKey()).equals("FleetCoordination")) {
                        gm2.b(((Number)entry.getValue()).doubleValue());
                    }
                    if (((String)entry.getKey()).equals("Hyperdrive")) {
                        gm2.a(((Number)entry.getValue()).doubleValue());
                    }
                    if (((String)entry.getKey()).equals("Inventory")) {
                        eY2.b("FreighterInventory", (Object)((eY)entry.getValue()));
                        bl2 = true;
                    }
                    if (((String)entry.getKey()).equals("InventoryTech")) {
                        eY2.b("FreighterInventory_TechOnly", (Object)((eY)entry.getValue()));
                        bl2 = true;
                    }
                    if (!((String)entry.getKey()).equals("InventoryCargo")) continue;
                    eY2.b("FreighterInventory_Cargo", (Object)((eY)entry.getValue()));
                    bl2 = true;
                }
                if (bl2) {
                    gm2 = gm.p(eY2);
                }
                this.aw.c(gm2);
                this.aL = true;
                return true;
            }
            catch (IOException iOException) {
                hc.a("Freighter restore error", iOException);
                this.c("An error occured during restore.");
            }
            catch (GeneralSecurityException generalSecurityException) {
                hc.a("Freighter restore error", generalSecurityException);
                this.c("An error occured during restore.");
            }
        }
        return false;
    }

    private void k() {
        File file = ej.b(this.aF == null ? null : this.aF.bS());
        if (file != null) {
            String string;
            File file2;
            if (file.isDirectory()) {
                file2 = file;
                string = null;
            } else {
                file2 = file.getParentFile();
                string = file.getName();
            }
            if (this.aF != null) {
                if (this.aF.bS().isDirectory() && !this.aF.bS().equals(file2)) {
                    this.aF = null;
                } else if (this.aF.bS().isFile() && !this.aF.bS().equals(file)) {
                    this.aF = null;
                }
            }
            if (this.aF == null) {
                hc.info("Loading storage: " + file2.getAbsolutePath());
                this.aF = fq.a(file2, this.aX);
            }
            if (this.aF == null) {
                this.aG = new ft[0];
                this.aH = -1;
                this.aI = new fs[0];
                this.aJ = -1;
                this.aK = null;
                this.aM = null;
                this.aN = null;
                this.ad.setEnabled(false);
                this.O.setEnabledAt(13, false);
                this.aE.a(null);
                this.aO = false;
                this.P.setText("(none)");
                this.Q.setText("(none)");
            } else {
                String string2 = fq.c(this.aF);
                nomanssave.aH.setProperty("GameStorage", string2);
                nomanssave.aH.setProperty("GameSaveDir", this.aF.bS().getAbsolutePath());
                hc.debug("Storage: " + string2);
                hc.debug("Save Path: " + this.aF.bS().getAbsolutePath());
                this.aG = this.aF.bV();
                this.aH = -1;
                this.aI = new fs[0];
                this.aJ = -1;
                if (string != null) {
                    int n = 0;
                    block2: while (n < this.aG.length) {
                        if (this.aF.W(string) == this.aG[n].getIndex()) {
                            this.aH = n;
                            this.aI = this.aG[n].bX();
                            int n2 = 0;
                            while (n2 < this.aI.length) {
                                if (string.equals(this.aI[n2].K())) {
                                    this.aJ = n2;
                                    break block2;
                                }
                                ++n2;
                            }
                            break;
                        }
                        ++n;
                    }
                }
                this.aM = null;
                this.aN = null;
                try {
                    this.aM = this.aF.bT();
                    eY eY2 = this.aN = this.aM == null ? null : this.aM.M();
                    if (this.aN != null) {
                        this.aN.a(this.aV);
                    }
                }
                catch (IOException iOException) {
                    hc.a("Error reading account data", iOException);
                }
                this.ad.setEnabled(this.aN != null);
                this.O.setEnabledAt(13, this.aN != null);
                this.aE.a(this.aN);
                this.aO = false;
                this.P.setText(string2);
                this.Q.setText(this.aF.bS().getAbsolutePath());
            }
            this.R.setEnabled(true);
            this.S.setEnabled(true);
            if (this.aJ > 0) {
                this.c("The save file you have selected is not the most recent.");
            }
            this.l();
        }
    }

    private void e(int n) {
        this.aH = n;
        if (this.aH < 0) {
            this.aI = new fs[0];
            this.aJ = -1;
        } else {
            this.aI = this.aG[this.aH].bX();
            this.aJ = this.aI.length > 0 ? 0 : -1;
        }
        this.l();
    }

    private void f(int n) {
        this.aJ = n;
        this.l();
    }

    public void b(String string) {
        EventQueue.invokeLater(new z(this, string));
    }

    public void c(String string) {
        EventQueue.invokeLater(new A(this, string));
    }

    private void l() {
        eY eY2;
        this.R.updateUI();
        this.S.updateUI();
        this.aL = false;
        this.aK = null;
        if (this.aJ < 0) {
            this.T.setText("(no file selected)");
            this.U.setText("(no file selected)");
            this.V.setText("(no file selected)");
            if (this.aH >= 0) {
                hc.info("No current save file found for " + this.aG[this.aH]);
                this.b("Save file not found for " + this.aG[this.aH]);
            }
        } else {
            try {
                this.T.setText(Application.a(this.aI[this.aJ].lastModified()));
                this.U.setText(Application.e(this.aI[this.aJ].getName()));
                this.V.setText(Application.e(this.aI[this.aJ].getDescription()));
                hc.info("Reading save file...");
                hc.info("  Slot: " + this.aG[this.aH]);
                hc.info("  Filename: " + this.aI[this.aJ].K());
                try {
                    this.aK = this.aI[this.aJ].M();
                    this.aK.a(this.aW);
                }
                catch (eX eX2) {
                    hc.info("  Error parsing JSON: " + eX2.getMessage());
                }
                hc.info("Finished.");
                this.aL = this.aI[this.aJ] instanceof F;
            }
            catch (IOException iOException) {
                hc.error("Could not load save file: " + this.aI[this.aJ].K(), iOException);
                this.aK = null;
            }
        }
        this.O.setSelectedIndex(0);
        if (this.aK == null || (eY2 = this.aK.H("PlayerStateData")) == null) {
            this.W.setEnabled(false);
            this.X.setEnabled(false);
            this.Y.setEnabled(false);
            this.Z.setEnabled(false);
            this.aa.setEnabled(false);
            this.ab.setEnabled(false);
            for (JMenuItem jMenuItem : this.ac) {
                jMenuItem.setEnabled(false);
            }
            this.as.a((gz)null);
            this.at.a(new gv[0], null);
            this.au.a(new gH[0], null);
            this.av.a(new gM[0]);
            this.aw.c(null);
            this.ax.a(new gp[0]);
            this.ay.a(new gO[0]);
            this.az.a(new gj[0]);
            this.aA.a((ge)null);
            this.aB.a(new gE[0]);
            this.aC.a(null);
            this.aD.a(null);
            this.O.setEnabledAt(1, false);
            this.O.setEnabledAt(2, false);
            this.O.setEnabledAt(3, false);
            this.O.setEnabledAt(4, false);
            this.O.setEnabledAt(5, false);
            this.O.setEnabledAt(6, false);
            this.O.setEnabledAt(7, false);
            this.O.setEnabledAt(8, false);
            this.O.setEnabledAt(9, false);
            this.O.setEnabledAt(11, false);
            this.O.setEnabledAt(12, false);
            if (this.aJ >= 0) {
                if (this.aK == null) {
                    this.b("There was an error loading the file.");
                } else {
                    this.b("Save file corrupted");
                }
            }
        } else {
            boolean bl2 = this.aF.bW();
            gz gz2 = gz.w(eY2);
            gv[] gvArray = gv.v(eY2);
            gB gB2 = gB.x(eY2);
            gH[] gHArray = gH.C(eY2);
            gC gC2 = gC.y(eY2);
            gM[] gMArray = gM.D(eY2);
            gm gm2 = gm.p(eY2);
            gp[] gpArray = gp.q(eY2);
            gO[] gOArray = gO.E(eY2);
            gE[] gEArray = gE.z(eY2);
            boolean bl3 = gj.n(eY2);
            gj[] gjArray = gj.o(eY2);
            ge ge2 = ge.m(eY2);
            this.O.setEnabledAt(1, gz2 != null);
            this.as.a(gz2);
            this.O.setEnabledAt(2, gvArray.length > 0);
            this.at.a(gvArray, gB2);
            this.O.setEnabledAt(3, gHArray.length > 0);
            this.au.a(gHArray, gC2);
            this.O.setEnabledAt(4, gMArray.length > 0);
            this.av.a(gMArray);
            this.O.setEnabledAt(5, gm2 != null);
            this.aw.c(gm2);
            this.O.setEnabledAt(6, gm2 != null);
            this.ax.a(gpArray);
            this.O.setEnabledAt(7, gOArray.length > 0);
            this.ay.a(gOArray);
            this.O.setEnabledAt(8, bl3);
            this.az.a(gjArray);
            this.O.setEnabledAt(9, ge2 != null);
            this.aA.a(ge2);
            this.O.setEnabledAt(10, gEArray.length > 0);
            this.aB.a(gEArray);
            this.O.setEnabledAt(11, gz2 != null);
            this.aC.a(gz2);
            this.O.setEnabledAt(12, gz2 != null);
            this.aD.a(gz2);
            this.W.setEnabled(!(this.aI[this.aJ] instanceof F));
            this.X.setEnabled(true);
            this.Y.setEnabled(bl2);
            this.Z.setEnabled(true);
            this.aa.setEnabled(true);
            this.ab.setEnabled(bl2);
            for (JMenuItem jMenuItem : this.ac) {
                jMenuItem.setEnabled(true);
            }
        }
    }

    private void m() {
        try {
            this.aM.k(this.aN);
            this.aO = false;
        }
        catch (Exception exception) {
            hc.a("Error saving account data", exception);
            this.c("An error occured saving the account data.");
        }
    }

    private void n() {
        if (this.aJ < 0) {
            this.b("No save file selected.");
            return;
        }
        try {
            hc.info("Formatting JSON...");
            String string = this.aI[this.aJ].b(this.aK);
            this.aI = this.aG[this.aH].bX();
            this.aJ = -1;
            int n = 0;
            while (n < this.aI.length) {
                if (string.equals(this.aI[n].K())) {
                    this.aJ = n;
                    break;
                }
                ++n;
            }
            this.aL = false;
            this.R.updateUI();
            this.S.updateUI();
            if (this.aJ < 0) {
                this.T.setText("(no file selected)");
                this.U.setText("(no file selected)");
                this.V.setText("(no file selected)");
            } else {
                this.T.setText(Application.a(this.aI[this.aJ].lastModified()));
                this.U.setText(Application.e(this.aI[this.aJ].getName()));
                this.V.setText(Application.e(this.aI[this.aJ].getDescription()));
            }
            hc.info("Finished.");
        }
        catch (IOException iOException) {
            hc.error("Could not write save file: " + this.aI[this.aJ].K(), iOException);
            this.b("There was an error saving the file.");
        }
    }

    private void o() {
        int n = this.aG[this.aH].getIndex();
        int n2 = dz.a(this.N, this.aF.bU(), n);
        if (n2 >= 0 && n2 != n) {
            try {
                hc.info("Formatting JSON...");
                hc.info("Creating game slot...");
                String string = this.aF.a(n2, this.aK);
                this.aG = this.aF.bV();
                this.aH = -1;
                this.aI = new fs[0];
                this.aJ = -1;
                int n3 = 0;
                block2: while (n3 < this.aG.length) {
                    if (this.aF.W(string) == this.aG[n3].getIndex()) {
                        this.aH = n3;
                        this.aI = this.aG[n3].bX();
                        int n4 = 0;
                        while (n4 < this.aI.length) {
                            if (string.equals(this.aI[n4].K())) {
                                this.aJ = n4;
                                break block2;
                            }
                            ++n4;
                        }
                        break;
                    }
                    ++n3;
                }
                this.aL = false;
                this.R.updateUI();
                this.S.updateUI();
                if (this.aJ < 0) {
                    this.T.setText("(no file selected)");
                    this.U.setText("(no file selected)");
                    this.V.setText("(no file selected)");
                } else {
                    this.T.setText(Application.a(this.aI[this.aJ].lastModified()));
                    this.U.setText(Application.e(this.aI[this.aJ].getName()));
                    this.V.setText(Application.e(this.aI[this.aJ].getDescription()));
                }
                hc.info("Finished.");
            }
            catch (IOException iOException) {
                hc.error("Could not write save file", iOException);
                this.b("There was an error saving the file.");
                return;
            }
        }
    }

    public List g(int n) {
        ArrayList<gt> arrayList = new ArrayList<gt>();
        gz gz2 = this.as.X();
        if (gz2 != null) {
            arrayList.addAll(gz2.cC().stream().filter(gt2 -> gt2.ay(n)).collect(Collectors.toList()));
        }
        gv[] gvArray = this.at.aK();
        int n2 = 0;
        while (n2 < gvArray.length) {
            gt gt3 = gvArray[n2].dE();
            if (gt3 != null && gt3.ay(n)) {
                arrayList.add(gt3);
            }
            ++n2;
        }
        gH[] gHArray = this.au.aO();
        int n3 = 0;
        while (n3 < gHArray.length) {
            arrayList.addAll(gHArray[n3].cC().stream().filter(gt2 -> gt2.ay(n)).collect(Collectors.toList()));
            ++n3;
        }
        gm gm2 = this.aw.Z();
        if (gm2 != null) {
            arrayList.addAll(gm2.cC().stream().filter(gt2 -> gt2.ay(n)).collect(Collectors.toList()));
        }
        gO[] gOArray = this.ay.aT();
        int n4 = 0;
        while (n4 < gOArray.length) {
            arrayList.addAll(gOArray[n4].cC().stream().filter(gt2 -> gt2.ay(n)).collect(Collectors.toList()));
            ++n4;
        }
        ge ge2 = this.aA.O();
        if (ge2 != null) {
            arrayList.addAll(ge2.cC().stream().filter(gt2 -> gt2.ay(n)).collect(Collectors.toList()));
        }
        return arrayList;
    }

    private void p() {
        eY eY2 = this.aK.H("PlayerStateData.UniverseAddress");
        hl hl2 = hl.n(eY2);
        if ((hl2 = nomanssave.aj.a(this.N, hl2)) != null) {
            hl2.aL(0);
            this.aK.b("PlayerStateData.UniverseAddress", (Object)hl2.ew());
            this.aK.b("PlayerStateData.PreviousUniverseAddress", (Object)eY2);
            this.aK.b("SpawnStateData.LastKnownPlayerState", "InShip");
            this.aL = true;
        }
    }

    private void q() {
        hc.info("Starting JSON Editor...");
        if (cy.a(this, this.aI[this.aJ].K(), this.aK)) {
            this.t();
        }
    }

    private void r() {
        hc.info("Starting JSON Editor...");
        if (cy.a(this, this.aM.K(), this.aN)) {
            try {
                this.aM.k(this.aN);
            }
            catch (IOException iOException) {
                hc.a("JSON Save error", iOException);
                this.c("An error occured saving the account data.");
            }
        }
    }

    private static void a(Window window) {
        SwingUtilities.updateComponentTreeUI(window);
        Window[] windowArray = window.getOwnedWindows();
        int n = windowArray.length;
        int n2 = 0;
        while (n2 < n) {
            Window window2 = windowArray[n2];
            Application.a(window2);
            ++n2;
        }
    }

    private void s() {
        if (nomanssave.aD.d(this.N)) {
            nomanssave.aH.V();
            Application.a(this.N);
        }
    }

    private void t() {
        this.aL = true;
        eY eY2 = this.aK.H("PlayerStateData");
        gz gz2 = gz.w(eY2);
        gv[] gvArray = gv.v(eY2);
        gB gB2 = gB.x(eY2);
        gH[] gHArray = gH.C(eY2);
        gM[] gMArray = gM.D(eY2);
        gC gC2 = gC.y(eY2);
        gm gm2 = gm.p(eY2);
        gp[] gpArray = gp.q(eY2);
        gO[] gOArray = gO.E(eY2);
        gE[] gEArray = gE.z(eY2);
        boolean bl2 = gj.n(eY2);
        gj[] gjArray = gj.o(eY2);
        ge ge2 = ge.m(eY2);
        this.O.setEnabledAt(1, gz2 != null);
        this.as.a(gz2);
        this.O.setEnabledAt(2, gvArray.length > 0);
        this.at.a(gvArray, gB2);
        this.O.setEnabledAt(3, gHArray.length > 0);
        this.au.a(gHArray, gC2);
        this.O.setEnabledAt(4, gMArray.length > 0);
        this.av.a(gMArray);
        this.O.setEnabledAt(5, gm2 != null);
        this.aw.c(gm2);
        this.O.setEnabledAt(6, gm2 != null);
        this.ax.a(gpArray);
        this.O.setEnabledAt(7, gOArray.length > 0);
        this.ay.a(gOArray);
        this.O.setEnabledAt(8, bl2);
        this.az.a(gjArray);
        this.O.setEnabledAt(9, ge2 != null);
        this.aA.a(ge2);
        this.O.setEnabledAt(10, gEArray.length > 0);
        this.aB.a(gEArray);
        this.O.setEnabledAt(11, gz2 != null);
        this.aC.a(gz2);
        this.O.setEnabledAt(12, gz2 != null);
        this.aD.a(gz2);
    }

    private void u() {
        hc.info("Exporting JSON...");
        cK cK2 = cK.aA();
        String string = String.valueOf(this.aI[this.aJ].K()) + ".json";
        cK2.setCurrentDirectory(nomanssave.aH.cF);
        cK2.setSelectedFile(new File(nomanssave.aH.cF, string));
        if (cK2.showSaveDialog(this.N) == 0) {
            try {
                File file = cK2.getSelectedFile();
                if (!file.getName().endsWith(".json")) {
                    file = new File(file.getParentFile(), String.valueOf(file.getName()) + ".json");
                }
                if (file.exists() && JOptionPane.showConfirmDialog(this.N, "Are you sure you want to overwrite this existing JSON file?", "Confirm", 2) != 0) {
                    return;
                }
                this.aK.c(file);
            }
            catch (IOException iOException) {
                hc.a("JSON Export error", iOException);
                this.c("An error occured exporting the save data.");
            }
        }
    }

    private void v() {
        hc.info("Importing JSON...");
        cK cK2 = cK.aA();
        cK2.setCurrentDirectory(nomanssave.aH.cF);
        if (cK2.showOpenDialog(this.N) == 0) {
            try {
                if (JOptionPane.showConfirmDialog(this.N, "Are you sure you want to update your current save data?", "Confirm", 2) != 0) {
                    return;
                }
                File file = cK2.getSelectedFile();
                this.aK.d(file);
                this.t();
            }
            catch (IOException iOException) {
                hc.a("JSON Import error", iOException);
                this.c("An error occured importing the save data.");
            }
        }
    }

    private void w() {
        this.as.w();
        this.at.w();
        this.au.w();
        this.aw.w();
        this.ay.w();
        this.aA.w();
    }

    private void x() {
        this.as.x();
        this.at.x();
        this.au.x();
        this.aw.x();
        this.ay.x();
        this.aA.x();
    }

    private void y() {
        this.as.y();
        this.at.y();
        this.au.y();
        this.aw.y();
        this.ay.y();
        this.aA.y();
    }

    private void z() {
        this.at.z();
        this.au.z();
    }

    private void A() {
        this.as.A();
        this.at.A();
        this.au.A();
        this.aw.A();
        this.ay.A();
        this.aA.A();
    }

    public void a(gt gt2) {
        this.as.a(gt2);
        this.at.a(gt2);
        this.au.a(gt2);
        this.aw.a(gt2);
        this.ay.a(gt2);
        this.aA.a(gt2);
    }

    public void B() {
        this.aD.B();
    }

    public void C() {
        this.aD.C();
    }

    public eV d(String string) {
        return this.aK.d(string);
    }

    public boolean D() {
        return this.aK.getValue("PlayerStateData.DifficultyState") != null;
    }

    public String E() {
        return this.aK.getValueAsString("PlayerStateData.DifficultyState.Settings.InventoryStackLimits.InventoryStackLimitsDifficulty");
    }

    public fn F() {
        fn fn2;
        String string = this.aK.getValueAsString("PlayerStateData.DifficultyState.Preset.DifficultyPresetType");
        if (string != null) {
            fn[] fnArray = fn.values();
            int n = fnArray.length;
            int n2 = 0;
            while (n2 < n) {
                fn2 = fnArray[n2];
                if (string.equalsIgnoreCase(fn2.name())) {
                    return fn2;
                }
                ++n2;
            }
        }
        if ((fn2 = this.aI[this.aJ].L()) == fn.lr) {
            String string2 = this.aK.getValueAsString("PlayerStateData.SeasonData.GameMode.PresetGameMode");
            if ("Normal".equals(string2)) {
                fn2 = fn.lm;
            }
            if ("Creative".equals(string2)) {
                fn2 = fn.lo;
            }
            if ("Survival".equals(string2)) {
                fn2 = fn.ln;
            }
            if ("Ambient".equals(string2)) {
                fn2 = fn.lp;
            }
            if ("Permadeath".equals(string2)) {
                fn2 = fn.lq;
            }
        }
        return fn2;
    }

    public void h(int n) {
        eY eY2 = this.aK.H("PlayerStateData");
        eV eV2 = eY2.d("Multitools");
        if (eV2 == null || eV2.size() == 0) {
            return;
        }
        eY eY3 = gR.az("multitool");
        if (n < 0 || n >= eV2.size() || eY3 == null) {
            return;
        }
        eV2.remove(n);
        eV2.add(eY3);
        gB gB2 = gB.x(eY2);
        int n2 = gB2.dU();
        if (n2 > 0 && n2 >= n) {
            gB2.aF(--n2);
        }
        this.at.a(gv.v(eY2), gB2);
    }

    public void i(int n) {
        eY eY2 = this.aK.H("PlayerStateData");
        eV eV2 = eY2.d("ShipOwnership");
        if (eV2 == null || eV2.size() == 0) {
            return;
        }
        eY eY3 = gR.az("ship");
        if (n < 0 || n >= eV2.size() || eY3 == null) {
            return;
        }
        eV2.remove(n);
        eV2.add(eY3);
        gC gC2 = gC.y(eY2);
        int n2 = gC2.dV();
        if (n2 > 0 && n2 >= n) {
            gC2.aG(--n2);
        }
        this.au.a(gH.C(eY2), gC2);
    }

    public void a(gl gl2, int n) {
        eV eV2;
        eY eY2 = this.aK.H("PlayerStateData");
        switch (gl2) {
            case oG: {
                eV2 = eY2.d("Eggs");
                break;
            }
            case oF: {
                eV2 = eY2.d("Pets");
                break;
            }
            default: {
                return;
            }
        }
        if (eV2 == null || eV2.size() == 0) {
            return;
        }
        eY eY3 = gR.az("companion");
        if (n < 0 || n >= eV2.size() || eY3 == null) {
            return;
        }
        eV2.remove(n);
        eV2.add(eY3);
        this.az.a(gj.o(eY2));
    }

    public boolean j(int n) {
        eV eV2 = this.aK.d("PlayerStateData.FleetExpeditions");
        int n2 = 0;
        while (n2 < eV2.size()) {
            eV eV3 = eV2.V(n2).d("AllFrigateIndices");
            if (eV3.hasValue(new Integer(n))) {
                return true;
            }
            ++n2;
        }
        return false;
    }

    public gp[] k(int n) {
        Object object;
        eV eV2 = this.aK.d("PlayerStateData.FleetFrigates");
        eV eV3 = this.aK.d("PlayerStateData.FleetExpeditions");
        int n2 = 0;
        while (n2 < eV3.size()) {
            object = eV3.V(n2).d("AllFrigateIndices");
            if (((eV)object).hasValue(new Integer(n))) {
                this.c("This frigate is currently on a mission and cannot be deleted!");
                return gp.d(eV2);
            }
            ++n2;
        }
        if (eV2 != null && n < eV2.size()) {
            eV2.ac(n);
            int n3 = 0;
            while (n3 < eV3.size()) {
                object = eV3.V(n3);
                eV eV4 = ((eY)object).d("ActiveFrigateIndices");
                int n4 = 0;
                while (n4 < eV4.size()) {
                    n2 = eV4.Y(n4);
                    if (n2 > n) {
                        eV4.a(n4, n2 - 1);
                    }
                    ++n4;
                }
                eV4 = ((eY)object).d("DamagedFrigateIndices");
                n4 = 0;
                while (n4 < eV4.size()) {
                    n2 = eV4.Y(n4);
                    if (n2 > n) {
                        eV4.a(n4, n2 - 1);
                    }
                    ++n4;
                }
                eV4 = ((eY)object).d("DestroyedFrigateIndices");
                n4 = 0;
                while (n4 < eV4.size()) {
                    n2 = eV4.Y(n4);
                    if (n2 > n) {
                        eV4.a(n4, n2 - 1);
                    }
                    ++n4;
                }
                eV4 = ((eY)object).d("AllFrigateIndices");
                n4 = 0;
                while (n4 < eV4.size()) {
                    n2 = eV4.Y(n4);
                    if (n2 > n) {
                        eV4.a(n4, n2 - 1);
                    }
                    ++n4;
                }
                eV eV5 = ((eY)object).d("Events");
                n4 = 0;
                while (n4 < eV4.size()) {
                    eY eY2 = eV5.V(n4);
                    eV4 = eY2.d("AffectedFrigateIndices");
                    int n5 = 0;
                    while (n5 < eV4.size()) {
                        n2 = eV4.Y(n5);
                        if (n2 > n) {
                            eV4.a(n5, n2 - 1);
                        }
                        ++n5;
                    }
                    eV4 = eY2.d("RepairingFrigateIndices");
                    n5 = 0;
                    while (n5 < eV4.size()) {
                        n2 = eV4.Y(n5);
                        if (n2 > n) {
                            eV4.a(n5, n2 - 1);
                        }
                        ++n5;
                    }
                    eV4 = eY2.d("AffectedFrigateResponses");
                    n5 = 0;
                    while (n5 < eV4.size()) {
                        n2 = eV4.Y(n5);
                        if (n2 > n) {
                            eV4.a(n5, n2 - 1);
                        }
                        ++n5;
                    }
                    ++n4;
                }
                ++n3;
            }
            this.aL = true;
        }
        return gp.d(eV2);
    }

    public gp[] a(int n, String string) {
        eV eV2 = this.aK.d("PlayerStateData.FleetFrigates");
        if (eV2 != null && n < eV2.size()) {
            eY eY2 = eV2.V(n).bE();
            eY2.d("ResourceSeed").a(1, string);
            eY2.b("CustomName", "");
            eV2.f(eY2);
            this.aL = true;
        }
        return gp.d(eV2);
    }

    private void G() {
        Object object;
        int n;
        eV eV2;
        int n2 = this.aK.J("PlayerStateData.TotalPlayTime");
        int n3 = 0;
        eV eV3 = this.aK.d("PlayerStateData.PersistentPlayerBases");
        int n4 = 0;
        while (n4 < eV3.size()) {
            eV2 = eV3.V(n4).d("Objects");
            n = 0;
            while (n < eV2.size()) {
                object = eV2.V(n).getValueAsString("ObjectID");
                if ("^PLANTER".equals(object)) {
                    ++n3;
                } else if ("^PLANTERMEGA".equals(object)) {
                    ++n3;
                }
                ++n;
            }
            ++n4;
        }
        eV2 = this.aK.d("PlayerStateData.MaintenanceInteractions");
        n = 0;
        while (n < eV2.size()) {
            object = eV2.V(n);
            eV eV4 = ((eY)object).d("InventoryContainer.Slots");
            int n5 = 0;
            while (n5 < eV4.size()) {
                eY eY2 = eV4.V(n5);
                if ("^MAINT_FARM5".equals(eY2.getValueAsString("Id"))) {
                    n4 = eY2.J("MaxAmount");
                    if (n4 > 0 && eY2.J("Amount") < n4) {
                        eY2.b("Amount", new Integer(n4));
                    }
                    ((eY)object).b("LastUpdateTimestamp", new Integer(n2));
                    this.aL = true;
                    --n3;
                }
                ++n5;
            }
            ++n;
        }
    }

    private void initialize() {
        JMenuItem jMenuItem14;
        this.N = new JFrame();
        ImageIcon imageIcon = Application.a("UI-FILEICON.PNG");
        if (imageIcon != null) {
            this.N.setIconImage(imageIcon.getImage());
        }
        this.N.setTitle("No Man's Sky Save Editor - 1.19.0 (VOYAGERS)");
        Rectangle rectangle = new Rectangle(100, 100, 1100, 720);
        rectangle.x = nomanssave.aH.a("MainFrame.X", 100);
        rectangle.y = nomanssave.aH.a("MainFrame.Y", 100);
        rectangle.width = nomanssave.aH.a("MainFrame.Width", 1000);
        rectangle.height = nomanssave.aH.a("MainFrame.Height", 700);
        this.N.setBounds(rectangle);
        this.N.setDefaultCloseOperation(3);
        this.N.addWindowListener(new B(this));
        this.N.addComponentListener(new C(this));
        this.O = new JTabbedPane(1);
        this.N.getContentPane().add((Component)this.O, "Center");
        ba ba2 = new ba(nomanssave.aH.cH, nomanssave.aH.cI, 0);
        this.O.addTab("Main", null, ba2, null);
        ba2.k("File Details");
        this.P = new JLabel();
        this.P.setText(this.aF == null ? "" : fq.c(this.aF));
        ba2.a("Storage", this.P, 2);
        this.Q = new JLabel();
        this.Q.setText(this.aF == null ? "(no path selected)" : this.aF.bS().getAbsolutePath());
        ba2.a("Save Path", this.Q, 2);
        this.R = new JComboBox();
        this.R.setModel(new D(this));
        this.R.setEnabled(this.aF != null);
        ba2.a("Game Slot", this.R);
        this.S = new JComboBox();
        this.S.setEditable(false);
        this.S.setModel(new E(this));
        this.S.setEnabled(this.aF != null);
        ba2.a("Save File", this.S);
        this.T = new JLabel();
        this.T.setText("(no file selected)");
        ba2.a("Modified", this.T, 2);
        this.U = new JLabel();
        this.U.setText("(no file selected)");
        ba2.a("Save Name", this.U, 2);
        this.V = new JLabel();
        this.V.setText("(no file selected)");
        ba2.a("Description", this.V, 2);
        ba2.Y();
        JPanel jPanel = new JPanel();
        jPanel.setLayout(new FlowLayout(0, 0, 0));
        this.W = new JButton("Reload");
        this.W.setEnabled(false);
        this.W.addActionListener(actionEvent -> this.l());
        jPanel.add(this.W);
        this.X = new JButton("Save Changes");
        this.X.setEnabled(false);
        this.X.addActionListener(actionEvent -> this.n());
        jPanel.add(this.X);
        this.Y = new JButton("Save As");
        this.Y.setEnabled(false);
        this.Y.addActionListener(actionEvent -> this.o());
        jPanel.add(this.Y);
        ba2.a(null, jPanel, 2);
        this.as = new aJ(this);
        this.O.addTab("Exosuit", null, this.as, null);
        this.O.setEnabledAt(1, false);
        this.at = new dj(this);
        this.O.addTab("Multitool", null, this.at, null);
        this.O.setEnabledAt(2, false);
        this.au = new dN(this);
        this.O.addTab("Ships", null, this.au, null);
        this.O.setEnabledAt(3, false);
        this.av = new eb(this);
        this.O.addTab("Squadron", null, this.av, null);
        this.O.setEnabledAt(4, false);
        this.aw = new bd(this);
        this.O.addTab("Freighter", null, this.aw, null);
        this.O.setEnabledAt(5, false);
        this.ax = new bl(this);
        this.O.addTab("Frigates", null, this.ax, null);
        this.O.setEnabledAt(6, false);
        this.ay = new ep(this);
        this.O.addTab("Vehicles", null, this.ay, null);
        this.O.setEnabledAt(7, false);
        this.az = new X(this);
        this.O.addTab("Companions", null, this.az, null);
        this.O.setEnabledAt(8, false);
        this.aA = new I(this);
        this.O.addTab("Bases & Storage", null, this.aA, null);
        this.O.setEnabledAt(9, false);
        this.aB = new dE(this);
        this.O.addTab("Settlements", null, this.aB, null);
        this.O.setEnabledAt(10, false);
        this.aC = new ap(this);
        this.O.addTab("Discovery", null, this.aC, null);
        this.O.setEnabledAt(11, false);
        this.aD = new bE(this);
        this.O.addTab("Milestones / Reputation", null, this.aD, null);
        this.O.setEnabledAt(12, false);
        this.aE = new c(this);
        this.O.addTab("Account", null, this.aE, null);
        this.O.setEnabledAt(13, false);
        this.O.addChangeListener(changeEvent -> {
            if (this.O.getSelectedIndex() == 12) {
                this.aD.aa();
            }
            if (this.aF != null && this.aO && this.aP) {
                int n = JOptionPane.showConfirmDialog(this.N, "Save account data?", "Save", 0);
                boolean bl2 = this.aP = n == 0;
                if (this.aP) {
                    this.m();
                }
            }
        });
        JMenuBar jMenuBar = new JMenuBar();
        this.N.setJMenuBar(jMenuBar);
        JMenu jMenu = new JMenu("File");
        jMenuBar.add(jMenu);
        JMenuItem jMenuItem2 = new JMenuItem("Open File/Path");
        jMenuItem2.setAccelerator(KeyStroke.getKeyStroke(79, 2));
        jMenuItem2.addActionListener(actionEvent -> this.k());
        jMenu.add(jMenuItem2);
        this.Z = new JMenuItem("Reload File");
        this.Z.setEnabled(false);
        this.Z.setAccelerator(KeyStroke.getKeyStroke(82, 2));
        this.Z.addActionListener(actionEvent -> this.l());
        jMenu.add(this.Z);
        this.aa = new JMenuItem("Save File");
        this.aa.setEnabled(false);
        this.aa.setAccelerator(KeyStroke.getKeyStroke(83, 2));
        this.aa.addActionListener(actionEvent -> {
            Component component = this.N.getFocusOwner();
            if (component instanceof G) {
                ((G)component).N();
            }
            this.n();
        });
        jMenu.add(this.aa);
        this.ab = new JMenuItem("Save File As");
        this.ab.setEnabled(false);
        this.ab.addActionListener(actionEvent -> {
            Component component = this.N.getFocusOwner();
            if (component instanceof G) {
                ((G)component).N();
            }
            this.o();
        });
        jMenu.add(this.ab);
        jMenu.addSeparator();
        JMenuItem jMenuItem3 = new JMenuItem("Exit");
        jMenuItem3.addActionListener(actionEvent -> {
            int n;
            if ((this.aL || this.aO) && (n = JOptionPane.showConfirmDialog(this.N, "Save data before closing?", "Save", 0)) == 0) {
                if (this.aL) {
                    this.n();
                }
                if (this.aO) {
                    this.m();
                }
            }
            this.N.dispose();
        });
        jMenu.add(jMenuItem3);
        JMenu jMenu2 = new JMenu("Edit");
        jMenuBar.add(jMenu2);
        this.ac = new ArrayList();
        JMenuItem jMenuItem4 = new JMenuItem("Edit Raw JSON");
        jMenuItem4.addActionListener(actionEvent -> this.q());
        jMenu2.add(jMenuItem4);
        this.ac.add(jMenuItem4);
        JMenuItem jMenuItem5 = new JMenuItem("Export JSON");
        jMenuItem5.addActionListener(actionEvent -> this.u());
        jMenu2.add(jMenuItem5);
        this.ac.add(jMenuItem5);
        JMenuItem jMenuItem6 = new JMenuItem("Import JSON");
        jMenuItem6.addActionListener(actionEvent -> this.v());
        jMenu2.add(jMenuItem6);
        this.ac.add(jMenuItem6);
        JMenuItem jMenuItem7 = new JMenuItem("Coordinate Viewer");
        jMenuItem7.addActionListener(actionEvent -> this.p());
        jMenu2.add(jMenuItem7);
        this.ac.add(jMenuItem7);
        JCheckBoxMenuItem jCheckBoxMenuItem = new JCheckBoxMenuItem("Test Mode");
        jCheckBoxMenuItem.setSelected(en.aS());
        jCheckBoxMenuItem.addActionListener(actionEvent -> {
            int n;
            boolean bl2 = jCheckBoxMenuItem.isSelected();
            if (bl2 && (n = JOptionPane.showConfirmDialog(this.N, "This mode removes any restrictions imposed by the editor.\nUSE WITH CAUTION: Changes made in test mode may not work in game.", "Test Mode", 2)) == 2) {
                jCheckBoxMenuItem.setSelected(false);
                return;
            }
            en.c(bl2);
        });
        jMenu2.add(jCheckBoxMenuItem);
        jMenu2.addSeparator();
        JMenuItem jMenuItem8 = new JMenuItem("Recharge All Technology");
        jMenuItem8.addActionListener(actionEvent -> this.w());
        jMenu2.add(jMenuItem8);
        this.ac.add(jMenuItem8);
        JMenuItem jMenuItem9 = new JMenuItem("Refill All Stacks");
        jMenuItem9.addActionListener(actionEvent -> this.x());
        jMenu2.add(jMenuItem9);
        this.ac.add(jMenuItem9);
        JMenuItem jMenuItem10 = new JMenuItem("Recharge Base Planters");
        jMenuItem10.addActionListener(actionEvent -> this.G());
        jMenu2.add(jMenuItem10);
        this.ac.add(jMenuItem10);
        JMenuItem jMenuItem11 = new JMenuItem("Expand All Inventories");
        jMenuItem11.addActionListener(actionEvent -> this.A());
        jMenu2.add(jMenuItem11);
        this.ac.add(jMenuItem11);
        JMenuItem jMenuItem12 = new JMenuItem("Enable All Slots");
        jMenuItem12.addActionListener(actionEvent -> this.y());
        jMenu2.add(jMenuItem12);
        this.ac.add(jMenuItem12);
        JMenuItem jMenuItem13 = new JMenuItem("Repair All Slots / Technology");
        jMenuItem13.addActionListener(actionEvent -> this.z());
        jMenu2.add(jMenuItem13);
        this.ac.add(jMenuItem13);
        jMenu2.addSeparator();
        this.ad = new JMenuItem("Edit Account JSON");
        this.ad.addActionListener(actionEvent -> this.r());
        jMenu2.add(this.ad);
        for (JMenuItem jMenuItem14 : this.ac) {
            jMenuItem14.setEnabled(false);
        }
        this.ad.setEnabled(false);
        jMenuItem14 = new JMenu("View");
        jMenuBar.add((JMenu)jMenuItem14);
        JMenuItem jMenuItem15 = new JMenuItem("Settings");
        jMenuItem15.addActionListener(actionEvent -> this.s());
        ((JMenu)jMenuItem14).add(jMenuItem15);
        jMenuBar.add(Box.createHorizontalGlue());
        JMenu jMenu3 = new JMenu("Help");
        jMenuBar.add(jMenu3);
        JMenuItem jMenuItem16 = new JMenuItem("About");
        jMenuItem16.addActionListener(actionEvent -> a.a(this.N));
        jMenu3.add(jMenuItem16);
        if (this.aF == null) {
            EventQueue.invokeLater(new v(this));
        } else if (this.aN != null) {
            this.ad.setEnabled(true);
            this.O.setEnabledAt(13, true);
            this.aE.a(this.aN);
            this.aO = false;
        }
        this.N.pack();
    }

    private static String e(String string) {
        return string == null ? "(unknown)" : string;
    }

    static /* synthetic */ boolean a(Application application) {
        return application.aQ;
    }

    static /* synthetic */ fq b(Application application) {
        return application.aF;
    }

    static /* synthetic */ void a(Application application, boolean bl2) {
        application.aR = bl2;
    }

    static /* synthetic */ void b(Application application, boolean bl2) {
        application.aS = bl2;
    }

    static /* synthetic */ int c(Application application) {
        return application.aH;
    }

    static /* synthetic */ ft[] d(Application application) {
        return application.aG;
    }

    static /* synthetic */ void c(Application application, boolean bl2) {
        application.aT = bl2;
    }

    static /* synthetic */ int e(Application application) {
        return application.aJ;
    }

    static /* synthetic */ fs[] f(Application application) {
        return application.aI;
    }

    static /* synthetic */ void d(Application application, boolean bl2) {
        application.aU = bl2;
    }

    /* synthetic */ Application(boolean bl2, Application application) {
        this(bl2);
    }

    static /* synthetic */ void g(Application application) {
        L = application;
    }

    static /* synthetic */ Application H() {
        return L;
    }

    static /* synthetic */ JFrame h(Application application) {
        return application.N;
    }

    static /* synthetic */ boolean i(Application application) {
        return application.aL;
    }

    static /* synthetic */ boolean j(Application application) {
        return application.aO;
    }

    static /* synthetic */ void k(Application application) {
        application.n();
    }

    static /* synthetic */ void l(Application application) {
        application.m();
    }

    static /* synthetic */ void e(Application application, boolean bl2) {
        application.aQ = bl2;
    }

    static /* synthetic */ void m(Application application) {
        application.f();
    }

    static /* synthetic */ JComboBox n(Application application) {
        return application.R;
    }

    static /* synthetic */ void f(Application application, boolean bl2) {
        application.aL = bl2;
    }

    static /* synthetic */ void a(Application application, int n) {
        application.e(n);
    }

    static /* synthetic */ JComboBox o(Application application) {
        return application.S;
    }

    static /* synthetic */ void a(Application application, fs[] fsArray) {
        application.aI = fsArray;
    }

    static /* synthetic */ void b(Application application, int n) {
        application.f(n);
    }

    static /* synthetic */ void p(Application application) {
        application.k();
    }
}
