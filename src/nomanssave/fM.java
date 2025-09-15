/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import java.io.File;
import java.io.IOException;
import nomanssave.eG;
import nomanssave.eY;
import nomanssave.fJ;
import nomanssave.fQ;
import nomanssave.fn;
import nomanssave.fs;
import nomanssave.hc;

class fM
extends fQ
implements fs {
    fn me;
    final /* synthetic */ fJ mt;

    fM(fJ fJ2, int n) {
        this.mt = fJ2;
        super(fJ2, n == 0 ? "save.hg" : "save" + (n + 1) + ".hg", n, true);
        try {
            String string = new String(this.ah(65536));
            this.me = fn.T(string);
        }
        catch (IOException iOException) {
            hc.a("Could not read game mode from " + this.filename, iOException);
        }
    }

    fM(fJ fJ2, int n, eY eY2) {
        this.mt = fJ2;
        super(fJ2, n == 0 ? "save.hg" : "save" + (n + 1) + ".hg", n, false);
        this.me = fn.i(eY2);
        this.a(eY2, true);
    }

    @Override
    public fn L() {
        return this.me;
    }

    @Override
    public eY M() {
        return this.a(eG.jV);
    }

    void cm() {
        this.a(this.lO == 0 ? "backup" : "backup" + (this.lO + 1), this.me, this.getName(), this.getDescription());
        new File(fJ.a(this.mt), this.filename).delete();
        new File(fJ.a(this.mt), "mf_" + this.filename).delete();
    }

    @Override
    public String b(eY eY2) {
        this.a(this.lO == 0 ? "backup" : "backup" + (this.lO + 1), this.me, this.getName(), this.getDescription());
        this.mx.Y(eY2.getValueAsString("CommonStateData.SaveName"));
        this.me = fn.i(eY2);
        this.mx.al((int)eY2.K("CommonStateData.TotalPlayTime"));
        this.a(eY2, true);
        return this.filename;
    }

    public String toString() {
        return this.filename;
    }

    @Override
    public String getName() {
        return this.mx.ck();
    }

    @Override
    public String getDescription() {
        return this.mx.getDescription();
    }
}
