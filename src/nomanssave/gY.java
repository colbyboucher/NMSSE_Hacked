/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import java.io.IOException;
import java.io.InputStream;
import nomanssave.gX;

class gY
extends InputStream {
    private int sc;
    final /* synthetic */ gX sd;

    private gY(gX gX2, int n) {
        this.sd = gX2;
        this.sc = n;
    }

    @Override
    public int read() {
        if (this.sc == 0) {
            return -1;
        }
        int n = gX.a(this.sd).read();
        if (n < 0) {
            throw new IOException("short read");
        }
        --this.sc;
        return n;
    }

    @Override
    public int read(byte[] byArray) {
        return this.read(byArray, 0, byArray.length);
    }

    @Override
    public int read(byte[] byArray, int n, int n2) {
        if (this.sc == 0) {
            return -1;
        }
        if (n2 > this.sc) {
            n2 = this.sc;
        }
        if ((n2 = gX.a(this.sd).read(byArray, n, n2)) <= 0) {
            throw new IOException("short read");
        }
        this.sc -= n2;
        return n2;
    }

    /* synthetic */ gY(gX gX2, int n, gY gY2) {
        this(gX2, n);
    }
}
