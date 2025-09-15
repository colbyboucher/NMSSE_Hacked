/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import nomanssave.aH;
import nomanssave.eG;
import nomanssave.eY;
import nomanssave.fA;
import nomanssave.fD;
import nomanssave.fn;
import nomanssave.fs;
import nomanssave.hc;
import nomanssave.hk;

class fC
implements fs {
    final int mb;
    final File mc;
    final String md;
    final byte[] lK;
    final fn be;
    final /* synthetic */ fA ma;

    fC(fA fA2, String string, int n) {
        this.ma = fA2;
        this.mb = n;
        this.mc = new File(aH.cG, string);
        try (ZipFile zipFile = new ZipFile(this.mc);){
            try {
                ZipEntry zipEntry = zipFile.getEntry("saveinfo.txt");
                if (zipEntry == null) {
                    throw new IOException("Invalid backup file");
                }
                Properties properties = new Properties();
                properties.load(zipFile.getInputStream(zipEntry));
                this.md = properties.getProperty("StorageFile");
                if (this.md == null) {
                    throw new IOException("Invalid backup file");
                }
                String string2 = properties.getProperty("GameMode");
                this.be = string2 == null ? null : fn.valueOf(string2);
                zipEntry = zipFile.getEntry(this.md);
                try (InputStream inputStream = zipFile.getInputStream(zipEntry);){
                    this.lK = new byte[112];
                    hk.readFully(inputStream, this.lK);
                    int n2 = 0;
                    while (n2 < fA.bY().length) {
                        if (this.lK[n2] != fA.bY()[n2]) {
                            throw new IOException("Invalid header");
                        }
                        ++n2;
                    }
                }
            }
            catch (NumberFormatException numberFormatException) {
                throw new IOException("Invalid backup file");
            }
        }
    }

    @Override
    public fn L() {
        return this.be;
    }

    @Override
    public String K() {
        return this.mc.getName();
    }

    @Override
    public long lastModified() {
        return this.mc.lastModified();
    }

    @Override
    public eY M() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        Throwable throwable = null;
        Object var3_4 = null;
        try (ZipFile zipFile = new ZipFile(this.mc);){
            ZipEntry zipEntry = zipFile.getEntry(this.md);
            if (zipEntry == null) {
                throw new IOException("Invalid backup file");
            }
            try (InputStream inputStream = zipFile.getInputStream(zipEntry);){
                int n;
                inputStream.skip(112L);
                byte[] byArray = new byte[4096];
                while ((n = inputStream.read(byArray)) >= 0) {
                    byteArrayOutputStream.write(byArray, 0, n);
                }
            }
        }
        catch (Throwable throwable2) {
            if (throwable == null) {
                throwable = throwable2;
            } else if (throwable != throwable2) {
                throwable.addSuppressed(throwable2);
            }
            throw throwable;
        }
        return fA.b(byteArrayOutputStream.toByteArray(), eG.jV);
    }

    @Override
    public String b(eY eY2) {
        String string;
        hc.info("Writing new save file...");
        if (fA.b(this.ma)[this.mb] != null) {
            string = fA.b(this.ma)[this.mb].b(eY2);
        } else {
            fA.b((fA)this.ma)[this.mb] = new fD(this.ma, this.mb, this.lK, eY2);
            string = fA.b(this.ma)[this.mb].K();
        }
        hc.info("Finished.");
        return string;
    }

    public String toString() {
        return this.mc.getName();
    }
}
