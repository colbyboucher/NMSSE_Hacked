/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import nomanssave.gY;
import nomanssave.ha;

public class gX
extends FilterInputStream {
    private ha sa;
    private int sb;

    public gX(InputStream inputStream, byte[] byArray) {
        super(inputStream);
        int n = 0xFF & byArray[4] | (0xFF & byArray[5]) << 8 | (0xFF & byArray[6]) << 16 | (0xFF & byArray[7]) << 24;
        int n2 = 0xFF & byArray[8] | (0xFF & byArray[9]) << 8 | (0xFF & byArray[10]) << 16 | (0xFF & byArray[11]) << 24;
        this.sa = new ha(new gY(this, n, null), n2);
        this.sb = 1;
    }

    public int getFrameCount() {
        return this.sb;
    }

    private boolean ej() {
        byte[] byArray = new byte[16];
        int n = this.in.read(byArray, 0, 16);
        if (n < 0) {
            this.sa = null;
            return false;
        }
        if (n < 16) {
            throw new IOException("Short read " + n);
        }
        if ((0xFF & byArray[0]) == 229 && (0xFF & byArray[1]) == 161 && (0xFF & byArray[2]) == 237 && (0xFF & byArray[3]) == 254) {
            int n2 = 0xFF & byArray[4] | (0xFF & byArray[5]) << 8 | (0xFF & byArray[6]) << 16 | (0xFF & byArray[7]) << 24;
            int n3 = 0xFF & byArray[8] | (0xFF & byArray[9]) << 8 | (0xFF & byArray[10]) << 16 | (0xFF & byArray[11]) << 24;
            this.sa = new ha(new gY(this, n2, null), n3);
            ++this.sb;
            return true;
        }
        throw new IOException("Invalid header");
    }

    @Override
    public int read() {
        if (this.sa == null || this.sa.available() == 0 && !this.ej()) {
            return -1;
        }
        return this.sa.read();
    }

    @Override
    public int read(byte[] byArray) {
        return this.read(byArray, 0, byArray.length);
    }

    @Override
    public int read(byte[] byArray, int n, int n2) {
        if (this.sa == null || this.sa.available() == 0 && !this.ej()) {
            return -1;
        }
        return this.sa.read(byArray, n, n2);
    }

    static /* synthetic */ InputStream a(gX gX2) {
        return gX2.in;
    }
}
