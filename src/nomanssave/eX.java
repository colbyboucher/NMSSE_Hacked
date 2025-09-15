/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import java.io.IOException;

public class eX
extends IOException {
    final int kF;
    final int kG;

    eX(String string) {
        this(string, 1, 0);
    }

    eX(String string, int n, int n2) {
        super(string);
        this.kF = n;
        this.kG = n2;
    }

    eX(String string, IOException iOException, int n, int n2) {
        super(string, iOException);
        this.kF = n;
        this.kG = n2;
    }

    public int getLineNumber() {
        return this.kF;
    }

    public int bD() {
        return this.kG;
    }
}
