/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import nomanssave.fR;
import nomanssave.fl;
import nomanssave.fn;
import nomanssave.fq;
import nomanssave.fr;
import nomanssave.ft;
import nomanssave.fv;
import nomanssave.fw;
import nomanssave.fx;
import nomanssave.fy;
import nomanssave.hk;

public class fu
implements fq {
    private static final byte[] lA = "NOMANSKY".getBytes();
    private static final byte[] lB;
    private static final Pattern lC;
    private final File lD;
    private fR lE;
    private fw[] lF;
    private fv lG;
    private fx[] lH;

    static {
        byte[] byArray = new byte[8];
        byArray[0] = 126;
        byArray[1] = -25;
        byArray[2] = 85;
        byArray[3] = -54;
        byArray[4] = -47;
        byArray[5] = 7;
        lB = byArray;
        lC = Pattern.compile("\\{\"Version\":(\\d*),.*");
    }

    public static fn ag(int n) {
        int n2 = (0xE00 & n) >> 9;
        if (n2 > 0 || n2 <= fn.values().length) {
            return fn.values()[n2 - 1];
        }
        throw new RuntimeException("Unsupported version: " + n);
    }

    fu(File file, fR fR2) {
        this.lD = file.isFile() ? file : new File(file, "memory.dat");
        this.lE = fR2;
        System.out.println(this.lD.getAbsolutePath());
        try (FileInputStream fileInputStream = new FileInputStream(this.lD);){
            long l = 0L;
            System.out.println("Reading header");
            byte[] byArray = new byte[8];
            hk.readFully(fileInputStream, byArray);
            l += (long)byArray.length;
            if (!fu.a(byArray, lA)) {
                throw new IOException("Invalid header");
            }
            int[] nArray = new int[14];
            int n = 0;
            while (n < nArray.length) {
                nArray[n] = hk.readInt(fileInputStream);
                l += 4L;
                if (nArray[n] != 0) {
                    System.out.println("  ints[" + n + "] = " + nArray[n] + " 0x" + Integer.toHexString(nArray[n]) + " " + Integer.toBinaryString(nArray[n]));
                }
                ++n;
            }
            System.out.println("Reading files");
            this.lF = new fw[32];
            n = 0;
            while (n < this.lF.length) {
                this.lF[n] = new fw(this, fileInputStream);
                if (this.lF[n].isValid()) {
                    System.out.println("file[" + n + "]");
                    this.lF[n].bZ();
                }
                l += 48L;
                ++n;
            }
            n = 0;
            while (n < this.lF.length) {
                if (this.lF[n].isValid()) {
                    fileInputStream.skip(this.lF[n].lP - l);
                    l = this.lF[n].lP;
                    byte[] byArray2 = new byte[20];
                    int n2 = fileInputStream.read(byArray2);
                    String string = new String(byArray2, 0, n2, "ISO-8859-1");
                    Matcher matcher = lC.matcher(string);
                    if (matcher.matches()) {
                        try {
                            this.lF[n].be = fu.ag(Integer.parseInt(matcher.group(1)));
                        }
                        catch (RuntimeException runtimeException) {
                            // empty catch block
                        }
                    }
                    l += (long)n2;
                }
                ++n;
            }
        }
        this.lG = null;
        this.lH = new fx[30];
        int n = 0;
        while (n < this.lF.length) {
            if (this.lF[n].isValid()) {
                if (this.lF[n].lN == 262144 && this.lG == null) {
                    this.lG = new fv(this, this.lF[n]);
                }
                if (this.lF[n].lN == 0x300000 && this.lF[n].lO >= 2) {
                    this.lH[this.lF[n].lO - 2] = new fx(this, this.lF[n]);
                }
            }
            ++n;
        }
        fl.a(this, this.lD.getParentFile());
    }

    @Override
    public File bS() {
        return this.lD;
    }

    @Override
    public fr bT() {
        return this.lG;
    }

    @Override
    public ft[] bU() {
        ft[] ftArray = new ft[15];
        int n = 0;
        while (n < 15) {
            ftArray[n] = new fy(this, n);
            ++n;
        }
        return ftArray;
    }

    @Override
    public int W(String string) {
        return -1;
    }

    @Override
    public void X(String string) {
        string.equals(this.lD.getName());
    }

    public static void main(String[] stringArray) {
        fu fu2 = new fu(new File("D:\\Temp\\PS4_NEW"), null);
    }

    private static boolean a(byte[] byArray, byte[] byArray2) {
        int n = 0;
        while (n < byArray.length) {
            if (byArray[n] != byArray2[n]) {
                return false;
            }
            ++n;
        }
        return true;
    }

    static /* synthetic */ fx[] a(fu fu2) {
        return fu2.lH;
    }

    static /* synthetic */ byte[] bY() {
        return lB;
    }

    static /* synthetic */ boolean b(byte[] byArray, byte[] byArray2) {
        return fu.a(byArray, byArray2);
    }

    static /* synthetic */ File b(fu fu2) {
        return fu2.lD;
    }

    static /* synthetic */ fw[] c(fu fu2) {
        return fu2.lF;
    }
}
