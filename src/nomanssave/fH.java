/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import nomanssave.aH;
import nomanssave.fA;
import nomanssave.fn;
import nomanssave.hk;

class fH {
    final File mh;
    byte[] lK;
    final /* synthetic */ fA ma;

    fH(fA fA2, String string, boolean bl) {
        this.ma = fA2;
        this.mh = new File(fA.a(fA2), string);
        if (bl) {
            try (FileInputStream fileInputStream = new FileInputStream(this.mh);){
                this.lK = new byte[112];
                hk.readFully(fileInputStream, this.lK);
                int n = 0;
                while (n < fA.bY().length) {
                    if (this.lK[n] != fA.bY()[n]) {
                        throw new IOException("Invalid header");
                    }
                    ++n;
                }
            }
        }
    }

    byte[] readBytes() {
        long l = (0xFFL & (long)this.lK[95]) << 24 | (0xFFL & (long)this.lK[94]) << 16 | (0xFFL & (long)this.lK[93]) << 8 | 0xFFL & (long)this.lK[92];
        try (FileInputStream fileInputStream = new FileInputStream(new File(fA.a(this.ma), this.K()));){
            byte[] byArray = new byte[(int)l];
            fileInputStream.skip(112L);
            hk.readFully(fileInputStream, byArray);
            byte[] byArray2 = byArray;
            return byArray2;
        }
    }

    byte[] ah(int n) {
        long l = (0xFFL & (long)this.lK[95]) << 24 | (0xFFL & (long)this.lK[94]) << 16 | (0xFFL & (long)this.lK[93]) << 8 | 0xFFL & (long)this.lK[92];
        try (FileInputStream fileInputStream = new FileInputStream(new File(fA.a(this.ma), this.K()));){
            n = (int)Math.min((long)n, l);
            byte[] byArray = new byte[n];
            fileInputStream.skip(112L);
            hk.readFully(fileInputStream, byArray);
            byte[] byArray2 = byArray;
            return byArray2;
        }
    }

    void writeBytes(byte[] byArray) {
        this.lK[92] = (byte)byArray.length;
        this.lK[93] = (byte)(byArray.length >> 8);
        this.lK[94] = (byte)(byArray.length >> 16);
        this.lK[95] = (byte)(byArray.length >> 24);
        try (FileOutputStream fileOutputStream = new FileOutputStream(new File(fA.a(this.ma), this.K()));){
            fileOutputStream.write(this.lK);
            fileOutputStream.write(byArray);
        }
    }

    void a(String string, fn fn2, String string2, String string3) {
        Properties properties = new Properties();
        properties.setProperty("StorageFile", this.mh.getName());
        properties.setProperty("LastModified", Long.toString(this.mh.lastModified()));
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
        File file = new File(aH.cG, string4);
        try (ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream(file));){
            byte[] byArray = new byte[4096];
            ZipEntry zipEntry = new ZipEntry(this.mh.getName());
            zipOutputStream.putNextEntry(zipEntry);
            try (FileInputStream fileInputStream = new FileInputStream(this.mh);){
                int n;
                while ((n = fileInputStream.read(byArray)) >= 0) {
                    zipOutputStream.write(byArray, 0, n);
                }
            }
            zipEntry = new ZipEntry("saveinfo.txt");
            zipOutputStream.putNextEntry(zipEntry);
            properties.store(zipOutputStream, "");
        }
        file.setLastModified(this.mh.lastModified());
    }

    public String K() {
        return this.mh.getName();
    }
}
