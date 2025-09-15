/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import nomanssave.aH;
import nomanssave.eG;
import nomanssave.eY;
import nomanssave.fJ;
import nomanssave.fM;
import nomanssave.ff;
import nomanssave.fn;
import nomanssave.fs;
import nomanssave.gX;
import nomanssave.hc;
import nomanssave.hk;

class fL
implements fs {
    final int mb;
    final File mc;
    final String mu;
    final String md;
    final fn be;
    final String mv;
    final String description;
    final /* synthetic */ fJ mt;

    fL(fJ fJ2, String string, int n) {
        this.mt = fJ2;
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
                this.mu = properties.getProperty("ManifestFile");
                this.md = properties.getProperty("StorageFile");
                if (this.mu == null || this.md == null) {
                    throw new IOException("Invalid backup file");
                }
                String string2 = properties.getProperty("GameMode");
                this.be = string2 == null ? null : fn.valueOf(string2);
                this.mv = properties.getProperty("SaveName");
                this.description = properties.getProperty("Description");
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
    public String getName() {
        return this.mv;
    }

    @Override
    public String getDescription() {
        return this.description;
    }

    @Override
    public eY M() {
        Throwable throwable = null;
        Object var2_3 = null;
        try {
            ZipFile zipFile = new ZipFile(this.mc);
            try {
                ZipEntry zipEntry = zipFile.getEntry(this.md);
                if (zipEntry == null) {
                    throw new IOException("Invalid backup file");
                }
                FilterInputStream filterInputStream = new BufferedInputStream(zipFile.getInputStream(zipEntry));
                try {
                    byte[] byArray = new byte[16];
                    ((InputStream)filterInputStream).mark(byArray.length);
                    hk.readFully(filterInputStream, byArray);
                    if ((0xFF & byArray[0]) == 229 && (0xFF & byArray[1]) == 161 && (0xFF & byArray[2]) == 237 && (0xFF & byArray[3]) == 254) {
                        filterInputStream = new gX(filterInputStream, byArray);
                    } else {
                        ((InputStream)filterInputStream).reset();
                    }
                    Throwable throwable2 = null;
                    Object var8_11 = null;
                    try (ff ff2 = new ff(filterInputStream, 6);){
                        eY eY2 = ff2.a(eG.jV);
                        ((InputStream)filterInputStream).close();
                        if (zipFile != null) {
                            zipFile.close();
                        }
                        return eY2;
                    }
                    catch (Throwable throwable3) {
                        if (throwable2 == null) {
                            throwable2 = throwable3;
                        } else if (throwable2 != throwable3) {
                            throwable2.addSuppressed(throwable3);
                        }
                        throw throwable2;
                    }
                }
                catch (Throwable throwable4) {
                    ((InputStream)filterInputStream).close();
                    throw throwable4;
                }
            }
            catch (Throwable throwable5) {
                if (zipFile != null) {
                    zipFile.close();
                }
                throw throwable5;
            }
        }
        catch (Throwable throwable6) {
            if (throwable == null) {
                throwable = throwable6;
            } else if (throwable != throwable6) {
                throwable.addSuppressed(throwable6);
            }
            throw throwable;
        }
    }

    @Override
    public String b(eY eY2) {
        String string;
        hc.info("Writing new save file...");
        if (fJ.b(this.mt)[this.mb] != null) {
            string = fJ.b(this.mt)[this.mb].b(eY2);
        } else {
            fJ.b((fJ)this.mt)[this.mb] = new fM(this.mt, this.mb, eY2);
            string = fJ.b((fJ)this.mt)[this.mb].filename;
        }
        hc.info("Finished.");
        return string;
    }

    public String toString() {
        return this.mc.getName();
    }
}
