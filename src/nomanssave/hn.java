/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import java.io.IOException;
import java.io.InputStream;
import nomanssave.hm;

class hn
extends InputStream {
    private int sc;
    final /* synthetic */ hm sW;

    private hn(hm hm2, int n) {
        this.sW = hm2;
        this.sc = n;
    }

    @Override
    public int read() {
        if (this.sc == 0) {
            return -1;
        }
        int n = hm.a(this.sW).read();
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
        if ((n2 = hm.a(this.sW).read(byArray, n, n2)) <= 0) {
            throw new IOException("short read");
        }
        this.sc -= n2;
        return n2;
    }

    /* synthetic */ hn(hm hm2, int n, hn hn2) {
        this(hm2, n);
    }
}
