/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import nomanssave.fR;
import nomanssave.fU;
import nomanssave.fW;
import nomanssave.fY;
import nomanssave.fZ;
import nomanssave.fl;
import nomanssave.fq;
import nomanssave.fr;
import nomanssave.ft;
import nomanssave.gX;
import nomanssave.gc;
import nomanssave.ha;
import nomanssave.hc;
import nomanssave.hk;
import nomanssave.hm;

public class fT
implements fq {
    private static final byte[] lA = "HGSAVEV2\u0000".getBytes();
    private static final Pattern lV = Pattern.compile("Slot(\\d+)((Auto)|(Manual))");
    private static final Pattern lW = Pattern.compile("wgsbackup(\\d*)\\.\\d*\\.zip");
    static final String mC = "containers.index";
    private final File lX;
    private final fR lE;
    private fU mD;
    private fY[] mE;
    private int header;
    private int lL;
    private String name;
    private int lM;
    private int lR;
    private int lS;
    private String mF;
    private int mG;
    private int mH;
    private List mI;
    private static final Pattern mJ = Pattern.compile("\"((?:<h0)|(?:CommonStateData))\":\\{\"((?:Pk4)|(?:SaveName))\":\"([^\"]+)\"");
    private static int mK = 1;
    private static int mL = 2;
    private static int mM = 3;

    fT(File file, fR fR2) {
        this.lX = file.isDirectory() ? file : file.getParentFile();
        this.lE = fR2;
        this.cr();
        try {
            this.mD = new fU(this);
        }
        catch (FileNotFoundException fileNotFoundException) {
        }
        catch (IOException iOException) {
            hc.a("Cannot read account data", iOException);
        }
        this.mE = new fY[30];
        int n = 0;
        while (n < this.mE.length) {
            try {
                this.mE[n] = new fY(this, n);
            }
            catch (FileNotFoundException fileNotFoundException) {
            }
            catch (IOException iOException) {
                hc.a("Cannot read file data", iOException);
            }
            ++n;
        }
        fl.a(this, this.lX);
    }

    protected void finalize() {
        fl.b(this);
    }

    @Override
    public void X(String string) {
        string.equals(mC);
    }

    @Override
    public File bS() {
        return this.lX;
    }

    private void cr() {
        hc.info("Reading Container Index");
        try (FileInputStream fileInputStream = new FileInputStream(new File(this.lX, mC));){
            this.header = hk.readInt(fileInputStream);
            hc.debug("  header: " + this.header);
            int n = hk.readInt(fileInputStream);
            hc.debug("  count: " + n);
            this.lL = hk.readInt(fileInputStream);
            if (this.lL != 0) {
                hc.debug("  unknown1: " + this.lL);
            }
            this.name = gc.c(fileInputStream);
            hc.debug("  name: " + this.name);
            this.lM = hk.readInt(fileInputStream);
            if (this.lM != 0) {
                hc.debug("  unknown2: " + this.lM);
            }
            this.lR = hk.readInt(fileInputStream);
            if (this.lR != 0) {
                hc.debug("  unknown3: " + this.lR);
            }
            this.lS = hk.readInt(fileInputStream);
            if (this.lS != 0) {
                hc.debug("  unknown4: " + this.lS);
            }
            this.mF = gc.c(fileInputStream);
            hc.debug("  appid: " + this.mF);
            this.mG = hk.readInt(fileInputStream);
            if (this.mG != 0) {
                hc.debug("  unknown5: " + this.mG);
            }
            this.mH = hk.readInt(fileInputStream);
            if (this.mH != 0) {
                hc.debug("  unknown6: " + this.mH);
            }
            this.mI = new ArrayList();
            int n2 = 0;
            while (n2 < n) {
                this.mI.add(new fW(this, fileInputStream));
                ++n2;
            }
            if (fileInputStream.read() >= 0) {
                throw new IOException("Invalid footer");
            }
        }
    }

    private void cs() {
        try (FileOutputStream fileOutputStream = new FileOutputStream(new File(this.lX, mC));){
            hk.a(fileOutputStream, this.header);
            hk.a(fileOutputStream, this.mI.size());
            hk.a(fileOutputStream, this.lL);
            gc.b(fileOutputStream, this.name);
            hk.a(fileOutputStream, this.lM);
            hk.a(fileOutputStream, this.lR);
            hk.a(fileOutputStream, this.lS);
            gc.b(fileOutputStream, this.mF);
            hk.a(fileOutputStream, this.mG);
            hk.a(fileOutputStream, this.mH);
            for (fW fW2 : this.mI) {
                fW2.write(fileOutputStream);
            }
        }
    }

    private fW Z(String string) {
        for (fW fW2 : this.mI) {
            if (!fW2.name.equals(string)) continue;
            return fW2;
        }
        throw new FileNotFoundException(string);
    }

    private String ct() {
        String string;
        File file;
        do {
            boolean bl = true;
            string = gc.cA();
            for (fW fW2 : this.mI) {
                bl &= fW2.mU.equals(string);
            }
        } while (!(bl &= (file = new File(this.lX, string)).exists()));
        if (!file.mkdir()) {
            throw new FileNotFoundException(string);
        }
        return string;
    }

    @Override
    public fr bT() {
        return this.mD;
    }

    @Override
    public ft[] bU() {
        ft[] ftArray = new ft[15];
        int n = 0;
        while (n < 15) {
            ftArray[n] = new fZ(this, n);
            ++n;
        }
        return ftArray;
    }

    @Override
    public int W(String string) {
        Matcher matcher = lV.matcher(string);
        if (!matcher.matches()) {
            return -1;
        }
        return Integer.parseInt(matcher.group(1));
    }

    private static int an(int n) {
        return 0x7FFF0000 & n | (0xE00 & n) >> 9;
    }

    private static boolean h(File file) {
        File[] fileArray = file.listFiles();
        if (fileArray != null) {
            File[] fileArray2 = fileArray;
            int n = fileArray.length;
            int n2 = 0;
            while (n2 < n) {
                File file2 = fileArray2[n2];
                fT.h(file2);
                ++n2;
            }
        }
        return file.delete();
    }

    private static InputStream a(InputStream inputStream, int n) {
        try {
            boolean bl = true;
            if (!inputStream.markSupported()) {
                inputStream = new BufferedInputStream(inputStream);
            }
            inputStream.mark(lA.length);
            byte[] byArray = new byte[lA.length];
            hk.readFully(inputStream, byArray);
            int n2 = 0;
            while (n2 < lA.length) {
                if (byArray[n2] != lA[n2]) {
                    bl = false;
                    break;
                }
                ++n2;
            }
            if (bl) {
                return new hm(inputStream);
            }
            inputStream.reset();
            byte[] byArray2 = new byte[16];
            inputStream.mark(byArray2.length);
            hk.readFully(inputStream, byArray2);
            if ((0xFF & byArray2[0]) == 229 && (0xFF & byArray2[1]) == 161 && (0xFF & byArray2[2]) == 237 && (0xFF & byArray2[3]) == 254) {
                return new gX(inputStream, byArray2);
            }
            inputStream.reset();
            return new ha(inputStream, n);
        }
        catch (IOException iOException) {
            try {
                inputStream.close();
            }
            catch (IOException iOException2) {
                // empty catch block
            }
            throw iOException;
        }
    }

    static /* synthetic */ String a(fT fT2) {
        return fT2.ct();
    }

    static /* synthetic */ fY[] b(fT fT2) {
        return fT2.mE;
    }

    static /* synthetic */ Pattern cu() {
        return lW;
    }

    static /* synthetic */ Pattern cl() {
        return mJ;
    }

    static /* synthetic */ int ao(int n) {
        return fT.an(n);
    }

    static /* synthetic */ List c(fT fT2) {
        return fT2.mI;
    }

    static /* synthetic */ File d(fT fT2) {
        return fT2.lX;
    }

    static /* synthetic */ boolean i(File file) {
        return fT.h(file);
    }

    static /* synthetic */ fW a(fT fT2, String string) {
        return fT2.Z(string);
    }

    static /* synthetic */ InputStream b(InputStream inputStream, int n) {
        return fT.a(inputStream, n);
    }

    static /* synthetic */ int cv() {
        return mM;
    }

    static /* synthetic */ int cw() {
        return mL;
    }

    static /* synthetic */ int cx() {
        return mK;
    }

    static /* synthetic */ byte[] cy() {
        return lA;
    }

    static /* synthetic */ void e(fT fT2) {
        fT2.cs();
    }
}
