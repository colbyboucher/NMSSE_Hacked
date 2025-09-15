/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import nomanssave.aH;
import nomanssave.eG;
import nomanssave.eY;
import nomanssave.fS;
import nomanssave.fT;
import nomanssave.fV;
import nomanssave.fW;
import nomanssave.ff;
import nomanssave.fj;
import nomanssave.fn;
import nomanssave.gX;
import nomanssave.gZ;
import nomanssave.gc;
import nomanssave.hb;
import nomanssave.hc;
import nomanssave.hk;
import nomanssave.hm;
import nomanssave.ho;

abstract class fX {
    final fW mO;
    final File mX;
    final File mY;
    final fS mZ;
    int mode;
    final /* synthetic */ fT mN;

    fX(fT fT2, fV fV2) {
        this.mN = fT2;
        int n = fT.c(fT2).size();
        int n2 = 0;
        while (n2 < fT.c(fT2).size()) {
            int n3 = ((fW)fT.c((fT)fT2).get((int)n2)).name.compareTo(fV2.mO.name);
            if (n3 == 0) {
                fW fW2 = (fW)fT.c(fT2).remove(n2);
                fT.i(new File(fT.d(fT2), fW2.mU));
            }
            if (n3 >= 0) {
                n = n2;
                break;
            }
            ++n2;
        }
        this.mO = new fW(fT2, fV2.mO);
        File file = new File(fT.d(fT2), this.mO.mU);
        if (!file.mkdir()) {
            throw new IOException("Unable to create container path");
        }
        this.mX = new File(file, "container." + this.mO.mT);
        this.mZ = new fS(new File(file, fV2.mP));
        this.mY = new File(file, fV2.mR);
        try (FileOutputStream fileOutputStream = new FileOutputStream(this.mX);){
            fV2.a(fileOutputStream);
        }
        fT.c(fT2).add(n, this.mO);
    }

    fX(fT fT2, String string) {
        this.mN = fT2;
        this.mO = fT.a(fT2, string);
        File file = new File(fT.d(fT2), this.mO.mU);
        if (!file.isDirectory()) {
            throw new FileNotFoundException(this.mO.mU);
        }
        this.mX = new File(file, "container." + this.mO.mT);
        hc.info(this.mO.filename);
        File file2 = null;
        File file3 = null;
        try (FileInputStream fileInputStream = new FileInputStream(this.mX);){
            int n = hk.readInt(fileInputStream);
            hc.debug("  header: " + Integer.toHexString(n));
            int n2 = hk.readInt(fileInputStream);
            int n3 = 0;
            while (n3 < n2) {
                String string2 = gc.d(fileInputStream);
                hc.debug("  name: " + string2);
                String string3 = gc.a(fileInputStream);
                hc.debug("  filename: " + string3);
                String string4 = gc.a(fileInputStream);
                if (!string3.equals(string4)) {
                    hc.debug("  filename2: " + string4);
                }
                if (string2.equals("data") && !(file2 = new File(file, string3)).exists()) {
                    file2 = new File(file, string4);
                }
                if (string2.equals("meta") && !(file3 = new File(file, string3)).exists()) {
                    file3 = new File(file, string4);
                }
                ++n3;
            }
        }
        if (file2 == null || file3 == null) {
            throw new FileNotFoundException("data/meta file missing");
        }
        long l = file3.length() + file2.length();
        if (this.mO.mW != l) {
            throw new IOException("data size mismatch: " + this.mO.mW);
        }
        this.mY = file2;
        this.mZ = new fS(file3);
        this.mZ.cn();
    }

    public String K() {
        return this.mO.filename;
    }

    private InputStream getInputStream() {
        InputStream inputStream = fT.b(new FileInputStream(this.mY), this.mZ.ch());
        this.mode = inputStream instanceof gX ? fT.cv() : (inputStream instanceof hm ? fT.cw() : fT.cx());
        return inputStream;
    }

    private OutputStream getOutputStream() {
        FileOutputStream fileOutputStream = new FileOutputStream(this.mY);
        try {
            if (this.mode == fT.cv()) {
                return new gZ(fileOutputStream);
            }
            if (this.mode == fT.cw()) {
                fileOutputStream.write(fT.cy());
                return new ho(fileOutputStream);
            }
            return new hb(fileOutputStream);
        }
        catch (IOException iOException) {
            try {
                fileOutputStream.close();
            }
            catch (IOException iOException2) {
                // empty catch block
            }
            throw iOException;
        }
    }

    eY a(eG eG2) {
        Throwable throwable = null;
        Object var3_4 = null;
        try (ff ff2 = new ff(this.getInputStream(), 2);){
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

    byte[] ah(int n) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        Throwable throwable = null;
        Object var4_5 = null;
        try (InputStream inputStream = this.getInputStream();){
            int n2;
            byte[] byArray = new byte[4096];
            while ((n2 = inputStream.read(byArray)) >= 0) {
                byteArrayOutputStream.write(byArray, 0, n2);
                if (byteArrayOutputStream.size() < n) continue;
                break;
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
        return byteArrayOutputStream.toByteArray();
    }

    void h(eY eY2) {
        fj fj2;
        boolean bl = this.mode == fT.cw();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        Object object = null;
        Throwable throwable = null;
        try {
            fj2 = new fj(byteArrayOutputStream, bl ? 0 : 2);
            try {
                fj2.h(eY2);
            }
            finally {
                if (fj2 != null) {
                    fj2.close();
                }
            }
        }
        catch (Throwable throwable2) {
            if (object == null) {
                object = throwable2;
            } else if (object != throwable2) {
                ((Throwable)object).addSuppressed(throwable2);
            }
            throw object;
        }
        object = byteArrayOutputStream.toByteArray();
        this.mZ.aj(((Object)object).length);
        throwable = null;
        fj2 = null;
        try (OutputStream outputStream = this.getOutputStream();){
            outputStream.write((byte[])object);
            if (bl) {
                outputStream.flush();
                outputStream.write(0);
            }
        }
        catch (Throwable throwable3) {
            if (throwable == null) {
                throwable = throwable3;
            } else if (throwable != throwable3) {
                throwable.addSuppressed(throwable3);
            }
            throw throwable;
        }
        this.mZ.ak((int)this.mY.length());
        this.mZ.write();
        this.mO.timestamp = System.currentTimeMillis();
        this.mO.mW = this.mY.length() + this.mZ.length();
        fT.e(this.mN);
    }

    void a(String string, fn fn2) {
        Properties properties = new Properties();
        properties.setProperty("MetaFile", this.mZ.getName());
        properties.setProperty("DataFile", this.mY.getName());
        properties.setProperty("ContainerFile", this.mX.getName());
        if (fn2 != null) {
            properties.setProperty("GameMode", fn2.name());
        }
        properties.setProperty("IndexData", this.mO.cz());
        String string2 = String.valueOf(string) + "." + System.currentTimeMillis() + ".zip";
        File file = new File(aH.cG, string2);
        try (ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream(file));){
            int n;
            ZipEntry zipEntry = new ZipEntry(this.mZ.getName());
            zipOutputStream.putNextEntry(zipEntry);
            zipOutputStream.write(this.mZ.co());
            zipEntry = new ZipEntry(this.mY.getName());
            zipOutputStream.putNextEntry(zipEntry);
            byte[] byArray = new byte[1024];
            try (FileInputStream fileInputStream = new FileInputStream(this.mY);){
                while ((n = fileInputStream.read(byArray)) > 0) {
                    zipOutputStream.write(byArray, 0, n);
                }
            }
            zipEntry = new ZipEntry(this.mX.getName());
            zipOutputStream.putNextEntry(zipEntry);
            fileInputStream = new FileInputStream(this.mX);
            try {
                while ((n = fileInputStream.read(byArray)) > 0) {
                    zipOutputStream.write(byArray, 0, n);
                }
            }
            finally {
                fileInputStream.close();
            }
            zipEntry = new ZipEntry("saveinfo.txt");
            zipOutputStream.putNextEntry(zipEntry);
            properties.store(zipOutputStream, "");
        }
        file.setLastModified(this.mO.timestamp);
    }
}
