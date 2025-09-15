/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import nomanssave.eY;
import nomanssave.fK;
import nomanssave.fM;
import nomanssave.fN;
import nomanssave.fR;
import nomanssave.fl;
import nomanssave.fq;
import nomanssave.fr;
import nomanssave.ft;
import nomanssave.hc;
import nomanssave.hh;

public class fJ
implements fq {
    private static final Pattern lV = Pattern.compile("save(\\d*)\\.hg");
    private static final Pattern lW = Pattern.compile("backup(\\d*)\\.\\d*\\.zip");
    private final File lX;
    private final fR lE;
    private fK mr;
    private fM[] ms;

    fJ(File file, fR fR2) {
        this.lX = file;
        this.lE = fR2;
        try {
            this.mr = new fK(this);
        }
        catch (FileNotFoundException fileNotFoundException) {
        }
        catch (IOException iOException) {
            hc.a("cannot read file metadata: mf_accountdata.hg", iOException);
        }
        this.ms = new fM[30];
        int n = 0;
        while (n < this.ms.length) {
            try {
                this.ms[n] = new fM(this, n);
            }
            catch (FileNotFoundException fileNotFoundException) {
            }
            catch (IOException iOException) {
                hc.a("cannot read file metadata: mf_save" + (n == 0 ? "" : Integer.toString(n + 1)) + ".hg", iOException);
            }
            ++n;
        }
        fl.a(this, file);
    }

    protected void finalize() {
        fl.b(this);
    }

    @Override
    public void X(String string) {
        Matcher matcher;
        if (string.equals("accountdata.hg")) {
            try {
                this.mr = new fK(this);
                hc.info("Account data reloaded from storage.");
            }
            catch (FileNotFoundException fileNotFoundException) {
                this.mr = null;
                hc.info("Account data deleted from storage.");
            }
            catch (IOException iOException) {
                this.mr = null;
                hc.a("cannot read file metadata: mf_accountdata.hg", iOException);
            }
            this.lE.a(this);
        }
        if ((matcher = lV.matcher(string)).matches()) {
            int n = matcher.group(1).length() == 0 ? 0 : Integer.parseInt(matcher.group(1)) - 1;
            try {
                this.ms[n] = new fM(this, n);
                hc.info("Save file reloaded from storage: " + string);
            }
            catch (FileNotFoundException fileNotFoundException) {
                this.ms[n] = null;
                hc.info("Save file deleted from storage: " + string);
            }
            catch (IOException iOException) {
                this.ms[n] = null;
                hc.a("cannot read file metadata: mf_save" + (n == 0 ? "" : Integer.toString(n + 1)) + ".hg", iOException);
            }
            this.lE.a(this, n / 2, string);
        }
    }

    @Override
    public File bS() {
        return this.lX;
    }

    @Override
    public fr bT() {
        return this.mr;
    }

    @Override
    public ft[] bU() {
        ft[] ftArray = new ft[15];
        int n = 0;
        while (n < 15) {
            ftArray[n] = new fN(this, n);
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
        int n = matcher.group(1).length() == 0 ? 0 : Integer.parseInt(matcher.group(1)) - 1;
        return n / 2;
    }

    @Override
    public boolean bW() {
        return true;
    }

    @Override
    public String a(int n, eY eY2) {
        if (this.ms[n * 2] != null) {
            this.ms[n * 2].cm();
            this.ms[n * 2] = null;
        }
        if (this.ms[n * 2 + 1] != null) {
            this.ms[n * 2 + 1].cm();
            this.ms[n * 2 + 1] = null;
        }
        this.ms[n * 2] = new fM(this, n * 2, eY2);
        return this.ms[n * 2].filename;
    }

    private static byte[] a(long[] lArray, int n, int n2) {
        byte[] byArray = new byte[n2 * 4];
        int n3 = 0;
        while (n3 < n2) {
            byArray[n3 * 4] = (byte)(lArray[n + n3] & 0xFFL);
            byArray[n3 * 4 + 1] = (byte)(lArray[n + n3] >> 8 & 0xFFL);
            byArray[n3 * 4 + 2] = (byte)(lArray[n + n3] >> 16 & 0xFFL);
            byArray[n3 * 4 + 3] = (byte)(lArray[n + n3] >> 24 & 0xFFL);
            ++n3;
        }
        return byArray;
    }

    private static byte[] c(byte[] byArray, byte[] byArray2) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byteArrayOutputStream.write(byArray, 0, byArray.length);
        byteArrayOutputStream.write(byArray2, 0, byArray2.length);
        long[] lArray = new long[]{96176015842230784L, -8446744073709551617L};
        hh.a(byteArrayOutputStream.toByteArray(), lArray);
        long[] lArray2 = new long[]{lArray[0] & 0xFFFFFFFFL, lArray[0] >>> 32 & 0xFFFFFFFFL, lArray[1] & 0xFFFFFFFFL, lArray[1] >>> 32 & 0xFFFFFFFFL};
        return fJ.a(lArray2, 0, 4);
    }

    static /* synthetic */ File a(fJ fJ2) {
        return fJ2.lX;
    }

    static /* synthetic */ byte[] d(byte[] byArray, byte[] byArray2) {
        return fJ.c(byArray, byArray2);
    }

    static /* synthetic */ fM[] b(fJ fJ2) {
        return fJ2.ms;
    }

    static /* synthetic */ Pattern cl() {
        return lW;
    }
}
