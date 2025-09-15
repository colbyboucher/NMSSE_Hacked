/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import nomanssave.eG;
import nomanssave.eY;
import nomanssave.fB;
import nomanssave.fD;
import nomanssave.fE;
import nomanssave.fR;
import nomanssave.ff;
import nomanssave.fj;
import nomanssave.fl;
import nomanssave.fq;
import nomanssave.fr;
import nomanssave.ft;
import nomanssave.hc;

public class fA
implements fq {
    private static final byte[] lA = "NOMANSKY".getBytes();
    private static final Pattern lV = Pattern.compile("savedata(\\d{2})\\.hg", 2);
    private static final Pattern lW = Pattern.compile("ps4_backup(\\d*)\\.\\d*\\.zip", 2);
    private final File lX;
    private final fR lE;
    private fB lY;
    private fD[] lZ;

    fA(File file, fR fR2) {
        this.lX = file;
        this.lE = fR2;
        try {
            this.lY = new fB(this);
        }
        catch (FileNotFoundException fileNotFoundException) {
        }
        catch (IOException iOException) {
            hc.a("cannot read file metadata: savedata00.hg", iOException);
        }
        this.lZ = new fD[30];
        int n = 0;
        while (n < this.lZ.length) {
            try {
                this.lZ[n] = new fD(this, n);
            }
            catch (FileNotFoundException fileNotFoundException) {
            }
            catch (IOException iOException) {
                int n2 = n + 2;
                String string = "savedata" + (n2 < 10 ? "0" : "") + Integer.toString(n2) + ".hg";
                hc.a("cannot read file metadata: " + string, iOException);
            }
            ++n;
        }
        fl.a(this, file);
    }

    private static eY a(byte[] byArray, eG eG2) {
        Throwable throwable = null;
        Object var3_4 = null;
        try (ff ff2 = new ff(new ByteArrayInputStream(byArray), 2);){
            return ff2.a(eG2);
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

    private static byte[] g(eY eY2) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        Throwable throwable = null;
        Object var3_4 = null;
        try (fj fj2 = new fj(byteArrayOutputStream, 2);){
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
        return byteArrayOutputStream.toByteArray();
    }

    @Override
    public File bS() {
        return this.lX;
    }

    @Override
    public fr bT() {
        return this.lY;
    }

    @Override
    public ft[] bU() {
        ft[] ftArray = new ft[15];
        int n = 0;
        while (n < 15) {
            ftArray[n] = new fE(this, n);
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
        int n = Integer.parseInt(matcher.group(1)) - 2;
        return n >= 0 ? n / 2 : -1;
    }

    @Override
    public void X(String string) {
        Matcher matcher = lV.matcher(string);
        if (matcher.matches()) {
            int n = Integer.parseInt(matcher.group(1)) - 2;
            if (n == -2) {
                try {
                    this.lY = new fB(this);
                    hc.info("Account data reloaded from storage.");
                }
                catch (FileNotFoundException fileNotFoundException) {
                    this.lY = null;
                    hc.info("Account data deleted from storage.");
                }
                catch (IOException iOException) {
                    this.lY = null;
                    hc.a("cannot read file metadata: " + string, iOException);
                }
                this.lE.a(this);
            } else if (n >= 0) {
                try {
                    this.lZ[n] = new fD(this, n);
                    hc.info("Save file reloaded from storage: " + string);
                }
                catch (FileNotFoundException fileNotFoundException) {
                    this.lZ[n] = null;
                    hc.info("Save file deleted from storage: " + string);
                }
                catch (IOException iOException) {
                    this.lZ[n] = null;
                    hc.a("cannot read file metadata: " + string, iOException);
                }
                this.lE.a(this, n / 2, string);
            }
        }
    }

    static /* synthetic */ File a(fA fA2) {
        return fA2.lX;
    }

    static /* synthetic */ byte[] bY() {
        return lA;
    }

    static /* synthetic */ eY b(byte[] byArray, eG eG2) {
        return fA.a(byArray, eG2);
    }

    static /* synthetic */ byte[] l(eY eY2) {
        return fA.g(eY2);
    }

    static /* synthetic */ fD[] b(fA fA2) {
        return fA2.lZ;
    }

    static /* synthetic */ Pattern cb() {
        return lW;
    }
}
