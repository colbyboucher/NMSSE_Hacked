/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import java.io.IOException;
import java.io.StringReader;
import java.util.function.Predicate;
import nomanssave.eX;

class fi
extends StringReader {
    int kF = 1;
    int kG = 0;

    fi(String string) {
        super(string);
    }

    public int bI() {
        int n;
        while ((n = this.read()) >= 0) {
            if (n == 32 || n == 13 || n == 10 || n == 9) continue;
            return n;
        }
        return -1;
    }

    @Override
    public int read() {
        int n;
        try {
            n = super.read();
        }
        catch (IOException iOException) {
            throw new eX("stream error", iOException, this.kF, this.kG);
        }
        if (n == 10) {
            ++this.kF;
        }
        ++this.kG;
        return n;
    }

    private int a(Predicate predicate) {
        try {
            this.mark(1);
            int n = super.read();
            if (n >= 0 && predicate.test(n)) {
                if (n == 10) {
                    ++this.kF;
                }
                ++this.kG;
                return n;
            }
            this.reset();
        }
        catch (IOException iOException) {
            throw new eX("stream error", iOException, this.kF, this.kG);
        }
        return -1;
    }

    static /* synthetic */ int a(fi fi2, Predicate predicate) {
        return fi2.a(predicate);
    }
}
