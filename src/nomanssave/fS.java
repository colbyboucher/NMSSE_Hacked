/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import nomanssave.fq;
import nomanssave.gc;
import nomanssave.hc;
import nomanssave.hk;

public class fS {
    private final File mh;
    private int lL;
    private int version;
    private long my;
    private int mz;
    private int mA;
    private byte[] mB;
    private String name;
    private String description;
    private int lM;

    fS(File file) {
        this.mh = file;
    }

    void cn() {
        Throwable throwable = null;
        Object var2_3 = null;
        try (FileInputStream fileInputStream = new FileInputStream(this.mh);){
            this.read(fileInputStream);
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

    void read(InputStream inputStream) {
        this.lL = hk.readInt(inputStream);
        if (this.lL != 0) {
            hc.debug("  unknown1: " + Integer.toHexString(this.lL));
        }
        this.version = hk.readInt(inputStream);
        if (this.version != 0) {
            hc.info("  version: " + this.version);
        }
        this.my = hk.f(inputStream);
        if (this.my != 0L) {
            hc.info("  totalPlayTime: " + fq.c(this.my));
        }
        if (this.lL == 1) {
            this.mz = hk.readInt(inputStream);
            if (this.mz != 0) {
                hc.debug("  decompressed: " + this.mz);
            }
            this.mA = 0;
            this.mB = new byte[128];
            hk.readFully(inputStream, this.mB);
        } else {
            this.mz = 0;
            this.mA = hk.readInt(inputStream);
            if (this.mA != 0) {
                hc.debug("  compressed: " + this.mA);
            }
            this.mB = null;
            this.name = gc.e(inputStream);
            if (this.name.length() != 0) {
                hc.debug("  name: " + this.name);
            }
            this.description = gc.e(inputStream);
            if (this.description.length() != 0) {
                hc.debug("  description: " + this.description);
            }
        }
        this.lM = hk.readInt(inputStream);
        if (this.lM != 0) {
            hc.debug("  unknown2: " + Integer.toHexString(this.lM));
        }
    }

    void write() {
        Throwable throwable = null;
        Object var2_3 = null;
        try (FileOutputStream fileOutputStream = new FileOutputStream(this.mh);){
            this.write(fileOutputStream);
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

    void write(OutputStream outputStream) {
        hk.a(outputStream, this.lL);
        hk.a(outputStream, this.version);
        hk.b(outputStream, this.my);
        if (this.mB != null) {
            hk.a(outputStream, this.mz);
            outputStream.write(this.mB);
        } else {
            hk.a(outputStream, this.mA);
            gc.c(outputStream, this.name);
            gc.c(outputStream, this.description);
        }
        hk.a(outputStream, this.lM);
    }

    byte[] co() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        this.write(byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    boolean cp() {
        return this.mB == null;
    }

    int getVersion() {
        return this.version;
    }

    void setVersion(int n) {
        this.version = n;
    }

    int ch() {
        return this.mz;
    }

    void aj(int n) {
        if (this.mB != null) {
            this.mz = n;
        }
    }

    int ci() {
        return this.mA;
    }

    void ak(int n) {
        if (this.mB == null) {
            this.mA = n;
        }
    }

    String ck() {
        return this.name;
    }

    void Y(String string) {
        this.name = string;
    }

    String getDescription() {
        return this.description;
    }

    long cq() {
        return this.my;
    }

    void d(long l) {
        this.my = l;
    }

    String getName() {
        return this.mh.getName();
    }

    long length() {
        return this.mh.length();
    }

    void a(fS fS2) {
        this.lL = fS2.lL;
        this.version = fS2.version;
        this.my = fS2.my;
        this.mA = fS2.mA;
        this.mz = fS2.mz;
        this.mB = fS2.mB;
        this.name = fS2.name;
        this.description = fS2.description;
        this.lM = fS2.lM;
    }
}
