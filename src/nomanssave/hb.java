/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import java.io.FilterOutputStream;
import java.io.OutputStream;
import net.jpountz.lz4.LZ4Compressor;
import net.jpountz.lz4.LZ4Factory;

public class hb
extends FilterOutputStream {
    private static final LZ4Factory se = LZ4Factory.safeInstance();
    private static final int sm = 65536;
    private final LZ4Compressor sf = se.fastCompressor();
    private byte[] buffer = new byte[65536];
    private int sg = 0;
    private int si = 0;

    public hb(OutputStream outputStream) {
        super(outputStream);
    }

    private void aK(int n) {
        if (this.sg + n > this.buffer.length) {
            n = this.buffer.length + n;
            int n2 = (this.buffer.length + n) / 65536;
            if ((this.buffer.length + n) % 65536 > 0) {
                ++n2;
            }
            byte[] byArray = new byte[n2 *= 65536];
            System.arraycopy(this.buffer, 0, byArray, 0, this.sg);
            this.buffer = byArray;
        }
    }

    @Override
    public void write(int n) {
        this.aK(1);
        this.buffer[this.sg++] = (byte)n;
    }

    @Override
    public void write(byte[] byArray) {
        this.write(byArray, 0, byArray.length);
    }

    @Override
    public void write(byte[] byArray, int n, int n2) {
        this.aK(n2);
        System.arraycopy(byArray, n, this.buffer, this.sg, n2);
        this.sg += n2;
    }

    public int ch() {
        return this.sg;
    }

    public int ci() {
        return this.si;
    }

    @Override
    public void flush() {
        this.out.flush();
    }

    @Override
    public void close() {
        try {
            if (this.sg > 0) {
                int n = this.sf.maxCompressedLength(this.sg);
                byte[] byArray = new byte[n];
                this.si = this.sf.compress(this.buffer, 0, this.sg, byArray, 0, n);
                this.out.write(byArray, 0, this.si);
            }
        }
        finally {
            this.out.close();
        }
    }
}
