/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import java.io.FilterOutputStream;
import java.io.OutputStream;
import net.jpountz.lz4.LZ4Compressor;
import net.jpountz.lz4.LZ4Factory;

public class ho
extends FilterOutputStream {
    private static final LZ4Factory se = LZ4Factory.safeInstance();
    private final LZ4Compressor sf = se.fastCompressor();
    private byte[] buffer = new byte[0x100000];
    private int sg = 0;
    private int sh = 0;
    private int si = 0;

    public ho(OutputStream outputStream) {
        super(outputStream);
    }

    @Override
    public void write(int n) {
        if (this.sg == this.buffer.length) {
            this.ek();
        }
        this.buffer[this.sg++] = (byte)n;
    }

    @Override
    public void write(byte[] byArray) {
        this.write(byArray, 0, byArray.length);
    }

    @Override
    public void write(byte[] byArray, int n, int n2) {
        if (n2 == this.buffer.length) {
            this.ek();
        }
        while (n2 >= this.buffer.length - this.sg) {
            int n3 = this.buffer.length - this.sg;
            System.arraycopy(byArray, n, this.buffer, this.sg, n3);
            this.sg = this.buffer.length;
            this.ek();
            n += n3;
            n2 -= n3;
        }
        if (n2 > 0) {
            System.arraycopy(byArray, n, this.buffer, this.sg, n2);
            this.sg += n2;
        }
    }

    private void ek() {
        int n = this.sf.maxCompressedLength(this.sg);
        byte[] byArray = new byte[n];
        int n2 = this.sf.compress(this.buffer, 0, this.sg, byArray, 0, n);
        byte[] byArray2 = new byte[]{(byte)(0xFF & this.sg), (byte)(0xFF & this.sg >> 8), (byte)(0xFF & this.sg >> 16), (byte)(0xFF & this.sg >> 24), (byte)(0xFF & n2), (byte)(0xFF & n2 >> 8), (byte)(0xFF & n2 >> 16), (byte)(0xFF & n2 >> 24)};
        this.out.write(byArray2);
        this.out.write(byArray, 0, n2);
        this.sh += this.sg;
        this.sg = 0;
        this.si += n2 + 8;
    }

    public int ch() {
        return this.sh;
    }

    public int ci() {
        return this.si;
    }

    @Override
    public void flush() {
        if (this.sg > 0) {
            this.ek();
        }
        this.out.flush();
    }

    @Override
    public void close() {
        try {
            if (this.sg > 0) {
                this.ek();
            }
        }
        finally {
            this.out.close();
        }
    }
}
