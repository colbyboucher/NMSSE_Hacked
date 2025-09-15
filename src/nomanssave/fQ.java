/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilterInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Properties;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import nomanssave.aH;
import nomanssave.eG;
import nomanssave.eY;
import nomanssave.fI;
import nomanssave.fJ;
import nomanssave.ff;
import nomanssave.fj;
import nomanssave.fn;
import nomanssave.fq;
import nomanssave.gX;
import nomanssave.gZ;
import nomanssave.hc;
import nomanssave.hk;

class fQ {
    final String filename;
    final int lO;
    fI mx;
    final /* synthetic */ fJ mt;

    fQ(fJ fJ2, String string, int n, boolean bl) {
        this.mt = fJ2;
        this.filename = string;
        this.lO = n;
        if (bl) {
            int n2;
            int n3;
            try (FileInputStream fileInputStream = new FileInputStream(new File(fJ.a(fJ2), "mf_" + string));){
                hc.info("Reading metadata for " + string);
                byte[] byArray = new byte[1024];
                n3 = fileInputStream.read(byArray);
                this.mx = fI.a(n, byArray, 0, n3);
            }
            int n4 = this.mx.ch();
            if (n4 != 0) {
                hc.debug("  DecompressedSize: " + n4);
            }
            if ((n3 = this.mx.ci()) != 0) {
                hc.debug("  CompressedSize: " + n3);
            }
            if ((n2 = this.mx.cj()) != 0) {
                hc.info("  TotalPlayTime: " + fq.c(n2));
            }
        } else {
            hc.info("Creating new metadata for " + string);
            this.mx = fI.am(n);
        }
    }

    public String K() {
        return this.filename;
    }

    public long lastModified() {
        return new File(fJ.a(this.mt), "mf_" + this.filename).lastModified();
    }

    eY a(eG eG2) {
        FilterInputStream filterInputStream = new BufferedInputStream(new FileInputStream(new File(fJ.a(this.mt), this.filename)));
        try {
            byte[] byArray = new byte[16];
            ((InputStream)filterInputStream).mark(byArray.length);
            hk.readFully(filterInputStream, byArray);
            if ((0xFF & byArray[0]) == 229 && (0xFF & byArray[1]) == 161 && (0xFF & byArray[2]) == 237 && (0xFF & byArray[3]) == 254) {
                filterInputStream = new gX(filterInputStream, byArray);
            } else {
                ((InputStream)filterInputStream).reset();
            }
            Throwable throwable = null;
            Object var5_6 = null;
            try (ff ff2 = new ff(filterInputStream, 6);){
                eY eY2 = ff2.a(eG2);
                ((InputStream)filterInputStream).close();
                return eY2;
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
        catch (Throwable throwable) {
            ((InputStream)filterInputStream).close();
            throw throwable;
        }
    }

    byte[] ah(int n) {
        try (InputStream inputStream = new FileInputStream(new File(fJ.a(this.mt), this.filename));){
            int n2;
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] byArray = new byte[1024];
            hk.readFully(inputStream, byArray, 0, 16);
            if ((0xFF & byArray[0]) == 229 && (0xFF & byArray[1]) == 161 && (0xFF & byArray[2]) == 237 && (0xFF & byArray[3]) == 254) {
                inputStream = new gX(inputStream, byArray);
            } else {
                byteArrayOutputStream.write(byArray, 0, 16);
            }
            while ((n2 = ((InputStream)inputStream).read(byArray)) >= 0) {
                byteArrayOutputStream.write(byArray, 0, n2);
                if (byteArrayOutputStream.size() >= n) break;
            }
            byte[] byArray2 = byteArrayOutputStream.toByteArray();
            return byArray2;
        }
    }

    void a(String string, fn fn2, String string2, String string3) {
        File file = new File(fJ.a(this.mt), "mf_" + this.filename);
        File file2 = new File(fJ.a(this.mt), this.filename);
        Properties properties = new Properties();
        properties.setProperty("ArchiveNumber", Integer.toString(this.lO));
        properties.setProperty("ManifestFile", "mf_" + this.filename);
        properties.setProperty("StorageFile", this.filename);
        properties.setProperty("LastModified", Long.toString(file.lastModified()));
        if (fn2 != null) {
            properties.setProperty("GameMode", fn2.name());
        }
        if (string2 != null) {
            properties.setProperty("SaveName", string2);
        }
        if (string3 != null) {
            properties.setProperty("Description", string3);
        }
        String string4 = String.valueOf(string) + "." + System.currentTimeMillis() + ".zip";
        File file3 = new File(aH.cG, string4);
        try (ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream(file3));){
            int n;
            byte[] byArray = new byte[1024];
            ZipEntry zipEntry = new ZipEntry(file.getName());
            zipOutputStream.putNextEntry(zipEntry);
            try (FileInputStream fileInputStream = new FileInputStream(file);){
                while ((n = fileInputStream.read(byArray)) >= 0) {
                    zipOutputStream.write(byArray, 0, n);
                }
            }
            zipEntry = new ZipEntry(file2.getName());
            zipOutputStream.putNextEntry(zipEntry);
            try (FileInputStream fileInputStream = new FileInputStream(file2);){
                while ((n = fileInputStream.read(byArray)) >= 0) {
                    zipOutputStream.write(byArray, 0, n);
                }
            }
            zipEntry = new ZipEntry("saveinfo.txt");
            zipOutputStream.putNextEntry(zipEntry);
            properties.store(zipOutputStream, "");
        }
        file3.setLastModified(file.lastModified());
    }

    void a(eY eY2, boolean bl) {
        Closeable closeable;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        Object object = null;
        Object var5_6 = null;
        try {
            closeable = new fj(byteArrayOutputStream, 2);
            try {
                ((fj)closeable).h(eY2);
            }
            finally {
                if (closeable != null) {
                    ((fj)closeable).close();
                }
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
        object = byteArrayOutputStream.toByteArray();
        int n = 0;
        closeable = new FileOutputStream(new File(fJ.a(this.mt), this.filename));
        try {
            if (bl) {
                closeable = new gZ((OutputStream)closeable);
            }
            ((OutputStream)closeable).write((byte[])object);
            if (bl) {
                n = ((gZ)closeable).ci();
            }
        }
        finally {
            ((OutputStream)closeable).close();
        }
        if (!this.mx.ce()) {
            hc.warn("Metadata version could not be upgraded");
        }
        byte[] byArray = new byte[32];
        byte[] byArray2 = new byte[16];
        if (!bl) {
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
                byArray = messageDigest.digest((byte[])object);
                byArray2 = fJ.d(byArray, (byte[])object);
            }
            catch (NoSuchAlgorithmException noSuchAlgorithmException) {
                hc.a("Error generating SHA-256 hash", noSuchAlgorithmException);
            }
        }
        this.mx.e(byArray);
        this.mx.f(byArray2);
        this.mx.ak(n);
        this.mx.aj(((Object)object).length);
        closeable = new FileOutputStream(new File(fJ.a(this.mt), "mf_" + this.filename));
        try {
            ((OutputStream)closeable).write(this.mx.encode());
        }
        finally {
            ((OutputStream)closeable).close();
        }
    }
}
