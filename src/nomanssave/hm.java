/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import java.io.FilterInputStream;
import java.io.InputStream;
import nomanssave.ha;
import nomanssave.hk;
import nomanssave.hn;

public class hm
extends FilterInputStream {
    private ha sa;
    private int sb;

    public hm(InputStream inputStream) {
        super(inputStream);
        byte[] byArray = new byte[8];
        hk.readFully(inputStream, byArray);
        int n = 0xFF & byArray[0] | (0xFF & byArray[1]) << 8 | (0xFF & byArray[2]) << 16 | (0xFF & byArray[3]) << 24;
        int n2 = 0xFF & byArray[4] | (0xFF & byArray[5]) << 8 | (0xFF & byArray[6]) << 16 | (0xFF & byArray[7]) << 24;
        this.sa = new ha(new hn(this, n2, null), n);
        this.sb = 1;
    }

    public int getFrameCount() {
        return this.sb;
    }

    private boolean ej() {
        byte[] byArray = new byte[8];
        hk.readFully(this.in, byArray);
        int n = 0xFF & byArray[0] | (0xFF & byArray[1]) << 8 | (0xFF & byArray[2]) << 16 | (0xFF & byArray[3]) << 24;
        int n2 = 0xFF & byArray[4] | (0xFF & byArray[5]) << 8 | (0xFF & byArray[6]) << 16 | (0xFF & byArray[7]) << 24;
        this.sa = new ha(new hn(this, n2, null), n);
        ++this.sb;
        return true;
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

    static /* synthetic */ InputStream a(hm hm2) {
        return hm2.in;
    }
}
