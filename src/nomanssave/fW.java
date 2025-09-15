/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;
import nomanssave.fT;
import nomanssave.gc;
import nomanssave.hc;
import nomanssave.hk;

class fW {
    final String name;
    final String filename;
    final String id;
    int mT;
    final int lL;
    String mU;
    long timestamp;
    final long mV;
    long mW;
    final /* synthetic */ fT mN;

    fW(fT fT2, InputStream inputStream) {
        this.mN = fT2;
        this.name = gc.c(inputStream);
        hc.info("  " + this.name);
        this.filename = gc.c(inputStream);
        hc.debug("    filename: " + this.filename);
        this.id = gc.c(inputStream);
        hc.debug("    id: " + this.id);
        this.mT = inputStream.read();
        if (this.mT < 0) {
            throw new IOException("short read");
        }
        hc.debug("    suffix: " + this.mT);
        this.lL = hk.readInt(inputStream);
        if (this.lL != 0) {
            hc.debug("    unknown1: " + Integer.toHexString(this.lL));
        }
        this.mU = gc.a(inputStream);
        hc.debug("    containerPath: " + this.mU);
        this.timestamp = gc.b(inputStream);
        hc.debug("    timestamp: " + new Date(this.timestamp));
        this.mV = hk.f(inputStream);
        if (this.mV != 0L) {
            hc.debug("    unknown2: " + Long.toHexString(this.mV));
        }
        this.mW = hk.f(inputStream);
        hc.debug("    totalSize: " + this.mW);
    }

    fW(fT fT2, String string) {
        this(fT2, new ByteArrayInputStream(hk.aD(string)));
    }

    fW(fT fT2, fW fW2) {
        this.mN = fT2;
        this.name = fW2.name;
        this.filename = fW2.filename;
        this.id = fW2.id;
        this.mT = fW2.mT;
        this.lL = fW2.lL;
        this.mU = fT.a(fT2);
        this.timestamp = fW2.timestamp;
        this.mV = fW2.mV;
        this.mW = fW2.mW;
    }

    void write(OutputStream outputStream) {
        gc.b(outputStream, this.name);
        gc.b(outputStream, this.filename);
        gc.b(outputStream, this.id);
        outputStream.write(this.mT);
        hk.a(outputStream, this.lL);
        gc.a(outputStream, this.mU);
        gc.a(outputStream, this.timestamp);
        hk.b(outputStream, this.mV);
        hk.b(outputStream, this.mW);
    }

    String cz() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        this.write(byteArrayOutputStream);
        return hk.k(byteArrayOutputStream.toByteArray());
    }
}
