/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import nomanssave.hc;

class he
extends OutputStream {
    final PrintStream ss;
    final String st;
    final ByteArrayOutputStream su;

    he(PrintStream printStream, String string) {
        this.ss = printStream;
        this.st = string;
        this.su = new ByteArrayOutputStream();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void write(int n) {
        this.ss.write(n);
        this.su.write(n);
        if (n == 10) {
            if (hc.en() != null) {
                PrintStream printStream = hc.en();
                synchronized (printStream) {
                    hc.en().write(this.st.getBytes());
                    hc.en().write(this.su.toByteArray());
                }
            }
            this.su.reset();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void write(byte[] byArray, int n, int n2) {
        if (this.ss != null) {
            this.ss.write(byArray, n, n2);
        }
        int n3 = 0;
        while (n3 < n2) {
            if (byArray[n + n3] == 10) {
                this.su.write(byArray, n, n3 + 1);
                if (hc.en() != null) {
                    PrintStream printStream = hc.en();
                    synchronized (printStream) {
                        hc.en().write(this.st.getBytes());
                        hc.en().write(this.su.toByteArray());
                    }
                }
                this.su.reset();
                n2 -= n3 + 1;
                n = n3 + 1;
                n3 = -1;
            }
            ++n3;
        }
        this.su.write(byArray, n, n2);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void flush() {
        if (this.su.size() > 0) {
            this.su.write(System.lineSeparator().getBytes());
            if (hc.en() != null) {
                PrintStream printStream = hc.en();
                synchronized (printStream) {
                    hc.en().write(this.st.getBytes());
                    hc.en().write(this.su.toByteArray());
                }
            }
            this.su.reset();
        }
    }
}
