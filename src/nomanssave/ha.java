/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import java.io.EOFException;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ha
extends FilterInputStream {
    private boolean sj;
    private byte[] buffer;
    private int sk;
    private int sg;
    private int sl;
    private boolean eof;

    public ha(InputStream inputStream, int n) {
        super(inputStream);
        if (n == 0) {
            this.sj = true;
            this.buffer = new byte[0x100000];
        } else {
            this.sj = false;
            this.buffer = new byte[n];
        }
        this.sg = 0;
        this.sk = 0;
        this.eof = false;
    }

    private void aJ(int n) {
        if (this.sg + n > this.buffer.length) {
            if (!this.sj) {
                throw new IOException("buffer exceeded");
            }
            int n2 = this.buffer.length;
            while (this.sg + n > (n2 += 0x100000)) {
            }
            byte[] byArray = new byte[n2];
            System.arraycopy(this.buffer, 0, byArray, 0, this.sg);
            this.buffer = byArray;
        }
    }

    private boolean el() {
        int n;
        if (this.eof) {
            return false;
        }
        int n2 = super.read();
        if (n2 < 0) {
            if (this.sj) {
                this.eof = true;
                return false;
            }
            throw new EOFException("Unexpected end of stream");
        }
        int n3 = n2 >> 4;
        int n4 = n2 & 0xF;
        if (n3 == 15) {
            do {
                if ((n2 = super.read()) < 0) {
                    throw new EOFException("Unexpected end of literal length");
                }
                n3 += n2;
            } while (n2 == 255);
        }
        if (n3 > 0) {
            n = n3;
            this.aJ(n);
            while ((n2 = super.read(this.buffer, this.sg, n)) > 0) {
                this.sg += n2;
                if ((n -= n2) == 0) break;
            }
            if (n > 0) {
                throw new EOFException("Unexpected end of literal value");
            }
        }
        if (this.sg == this.buffer.length && !this.sj) {
            this.eof = true;
            return true;
        }
        n = super.read();
        if (n < 0) {
            if (this.sj) {
                this.eof = true;
                return true;
            }
            throw new EOFException("Unexpected end of offset");
        }
        int n5 = super.read();
        if (n5 < 0) {
            throw new EOFException("Unexpected end of offset");
        }
        n |= n5 << 8;
        if (n4 == 15) {
            do {
                if ((n2 = super.read()) < 0) {
                    throw new EOFException("Unexpected end of literal length");
                }
                n4 += n2;
            } while (n2 == 255);
        }
        n4 += 4;
        if (n == 0) {
            throw new EOFException("Offset is zero!");
        }
        if (n > this.sg) {
            throw new EOFException("Buffer too small");
        }
        this.aJ(n4);
        if (n4 > n) {
            int n6 = this.sg - n;
            do {
                System.arraycopy(this.buffer, n6, this.buffer, this.sg, n);
                this.sg += n;
            } while ((n4 -= n) > n);
            System.arraycopy(this.buffer, n6, this.buffer, this.sg, n4);
            this.sg += n4;
        } else {
            System.arraycopy(this.buffer, this.sg - n, this.buffer, this.sg, n4);
            this.sg += n4;
        }
        this.sl = Math.max(this.sl, n);
        return true;
    }

    @Override
    public int available() {
        if (this.sk == this.sg && !this.el()) {
            return 0;
        }
        return this.sg - this.sk;
    }

    @Override
    public int read() {
        if (this.sk == this.sg && !this.el()) {
            return -1;
        }
        return 0xFF & this.buffer[this.sk++];
    }

    @Override
    public int read(byte[] byArray) {
        return this.read(byArray, 0, byArray.length);
    }

    @Override
    public int read(byte[] byArray, int n, int n2) {
        if (this.sk == this.sg && !this.el()) {
            return -1;
        }
        int n3 = Math.min(n2 - n, this.sg - this.sk);
        System.arraycopy(this.buffer, this.sk, byArray, n, n3);
        this.sk += n3;
        return n3;
    }
}
