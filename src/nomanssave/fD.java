/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import java.io.IOException;
import nomanssave.eG;
import nomanssave.eY;
import nomanssave.fA;
import nomanssave.fH;
import nomanssave.fn;
import nomanssave.fs;
import nomanssave.hc;

class fD
extends fH
implements fs {
    final int lO;
    fn me;
    final /* synthetic */ fA ma;

    fD(fA fA2, int n) {
        this.ma = fA2;
        super(fA2, "savedata" + (n < 8 ? "0" : "") + Integer.toString(n + 2) + ".hg", true);
        this.lO = n;
        try {
            String string = new String(this.ah(65536));
            this.me = fn.T(string);
        }
        catch (IOException iOException) {
            hc.a("Could not read game mode from " + this.mh.getName(), iOException);
        }
    }

    fD(fA fA2, int n, byte[] byArray, eY eY2) {
        this.ma = fA2;
        super(fA2, "savedata" + (n < 8 ? "0" : "") + Integer.toString(n + 2) + ".hg", false);
        this.lO = n;
        this.lK = byArray;
        this.me = fn.i(eY2);
        this.writeBytes(fA.l(eY2));
    }

    @Override
    public fn L() {
        return this.me;
    }

    @Override
    public eY M() {
        return fA.b(this.readBytes(), eG.jV);
    }

    @Override
    public String b(eY eY2) {
        this.a(this.lO == 0 ? "ps4_backup" : "ps4_backup" + (this.lO + 1), this.me, this.getName(), this.getDescription());
        this.writeBytes(fA.l(eY2));
        return this.K();
    }

    @Override
    public long lastModified() {
        return this.mh.lastModified();
    }

    public String toString() {
        return this.K();
    }
}
