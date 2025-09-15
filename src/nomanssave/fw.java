/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;
import nomanssave.fn;
import nomanssave.fu;
import nomanssave.hk;

class fw {
    public fn be;
    final byte[] lK = new byte[8];
    final int lL;
    final int lM;
    final int lN;
    final int lO;
    long bd;
    long length;
    long lP;
    final int lQ;
    final int lR;
    final int lS;
    final /* synthetic */ fu lJ;

    fw(fu fu2, InputStream inputStream) {
        this.lJ = fu2;
        hk.readFully(inputStream, this.lK);
        this.lL = hk.readInt(inputStream);
        this.lM = hk.readInt(inputStream);
        this.lN = hk.readInt(inputStream);
        this.lO = hk.readInt(inputStream);
        this.bd = 1000L * (long)hk.readInt(inputStream);
        this.length = 0xFFFFFFFFL & (long)hk.readInt(inputStream);
        this.lP = 0xFFFFFFFFL & (long)hk.readInt(inputStream);
        this.lQ = hk.readInt(inputStream);
        this.lR = hk.readInt(inputStream);
        this.lS = hk.readInt(inputStream);
    }

    boolean isValid() {
        return fu.b(this.lK, fu.bY()) && this.lO >= 0;
    }

    int a(OutputStream outputStream) {
        outputStream.write(this.lK);
        hk.a(outputStream, this.lL);
        hk.a(outputStream, this.lM);
        hk.a(outputStream, this.lN);
        hk.a(outputStream, this.lO);
        hk.a(outputStream, (int)(this.bd / 1000L));
        hk.a(outputStream, (int)this.length);
        hk.a(outputStream, (int)this.lP);
        hk.a(outputStream, this.lQ);
        hk.a(outputStream, this.lR);
        hk.a(outputStream, this.lS);
        return 48;
    }

    void bZ() {
        System.out.println("  unknown1 = " + this.lL + " 0x" + Integer.toHexString(this.lL) + " " + Integer.toBinaryString(this.lL));
        System.out.println("  unknown2 = " + this.lM + " 0x" + Integer.toHexString(this.lM) + " " + Integer.toBinaryString(this.lM));
        System.out.println("  fileType = " + this.lN + " 0x" + Integer.toHexString(this.lN) + " " + Integer.toBinaryString(this.lN));
        System.out.println("  archiveNumber = " + this.lO + " 0x" + Integer.toHexString(this.lO) + " " + Integer.toBinaryString(this.lO));
        System.out.println("  modified = " + new Date(this.bd));
        System.out.println("  length = " + this.length);
        System.out.println("  startPos = 0x" + Long.toHexString(this.lP));
        System.out.println("  valid = " + this.lQ);
        if (this.lR != 0) {
            System.out.println("  unknown3 = " + this.lR + " 0x" + Integer.toHexString(this.lR) + " " + Integer.toBinaryString(this.lR) + " date:" + new Date(1000L * (long)this.lR));
        }
        if (this.lS != 0) {
            System.out.println("  unknown4 = " + this.lS + " 0x" + Integer.toHexString(this.lS) + " " + Integer.toBinaryString(this.lS) + " len:" + (0xFFFFFFFFL & (long)this.lS));
        }
    }

    byte[] ca() {
        if (!this.isValid()) {
            return null;
        }
        try (FileInputStream fileInputStream = new FileInputStream(fu.b(this.lJ));){
            int n;
            fileInputStream.skip(this.lP);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] byArray = new byte[4096];
            long l = this.length;
            while (l > 0L && (n = fileInputStream.read(byArray, 0, (int)Math.min((long)byArray.length, l))) > 0) {
                l -= (long)n;
                byteArrayOutputStream.write(byArray, 0, n);
            }
            if (l > 0L) {
                throw new IOException("short read");
            }
            byte[] byArray2 = byteArrayOutputStream.toByteArray();
            return byArray2;
        }
    }

    /*
     * Unable to fully structure code
     */
    void d(byte[] var1_1) {
        if (!this.isValid()) {
            throw new IOException("header not valid");
        }
        var2_2 = -1;
        var3_3 = 0;
        while (var3_3 < fu.c(this.lJ).length) {
            if (fu.c(this.lJ)[var3_3] == this) {
                var2_2 = var3_3;
                break;
            }
            ++var3_3;
        }
        if (var2_2 < 0) {
            throw new IOException("header not valid");
        }
        var3_4 = System.currentTimeMillis();
        var5_5 = new File(fu.b(this.lJ).getParentFile(), "~" + fu.b(this.lJ).getName());
        var6_6 = new FileOutputStream(var5_5);
        try {
            var7_7 = new FileInputStream(fu.b(this.lJ));
            try {
                System.out.println("Reading header");
                var8_8 = new byte[64];
                hk.readFully(var7_7, var8_8);
                var6_6.write(var8_8);
                var9_9 = (long)var1_1.length - fu.c((fu)this.lJ)[var2_2].length;
                var11_10 = 64L;
                var13_11 = 0;
                while (var13_11 < var2_2) {
                    if (fu.c((fu)this.lJ)[var13_11].lP < fu.c((fu)this.lJ)[var2_2].lP) {
                        fu.c((fu)this.lJ)[var13_11].lP += var9_9;
                    }
                    var11_10 += (long)fu.c(this.lJ)[var13_11].a(var6_6);
                    ++var13_11;
                }
                var6_6.write(fu.bY());
                fu.c((fu)this.lJ)[var2_2].length = var1_1.length;
                fu.c((fu)this.lJ)[var2_2].bd = var3_4;
                var11_10 += (long)fu.c(this.lJ)[var2_2].a(var6_6);
                var13_11 = var2_2 + 1;
                while (var13_11 < fu.c(this.lJ).length) {
                    if (fu.c((fu)this.lJ)[var13_11].lP < fu.c((fu)this.lJ)[var2_2].lP) {
                        fu.c((fu)this.lJ)[var13_11].lP += var9_9;
                    }
                    var11_10 += (long)fu.c(this.lJ)[var13_11].a(var6_6);
                    ++var13_11;
                }
                var13_12 = fu.c((fu)this.lJ)[var2_2].lP - var11_10;
                var15_13 = new byte[4096];
                while (var13_12 > 0L && (var16_14 = var7_7.read(var15_13, 0, (int)Math.min((long)var15_13.length, var13_12))) > 0) {
                    var6_6.write(var15_13, 0, var16_14);
                    var11_10 += (long)var16_14;
                    var13_12 -= (long)var16_14;
                }
                if (var13_12 > 0L) {
                    throw new IOException("short read");
                }
                var6_6.write(var1_1);
                var11_10 += (long)var1_1.length;
                var13_12 = (long)var1_1.length - var9_9;
                while (var13_12 > 0L && (var16_14 = var7_7.read(var15_13, 0, (int)Math.min((long)var15_13.length, var13_12))) > 0) {
                    var13_12 -= (long)var16_14;
                }
                if (var13_12 <= 0L) ** GOTO lbl61
                throw new IOException("short read");
lbl-1000:
                // 1 sources

                {
                    var6_6.write(var15_13, 0, var16_14);
lbl61:
                    // 2 sources

                    ** while ((var16_14 = var7_7.read((byte[])var15_13)) > 0)
                }
lbl62:
                // 1 sources

            }
            finally {
                var7_7.close();
            }
        }
        finally {
            var6_6.close();
        }
    }
}
