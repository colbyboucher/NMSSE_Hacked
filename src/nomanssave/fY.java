/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import java.io.IOException;
import java.util.regex.Matcher;
import nomanssave.eG;
import nomanssave.eY;
import nomanssave.fT;
import nomanssave.fV;
import nomanssave.fX;
import nomanssave.fn;
import nomanssave.fs;
import nomanssave.hc;

class fY
extends fX
implements fs {
    final int lO;
    fn me;
    String na;
    final /* synthetic */ fT mN;

    fY(fT fT2, int n) {
        this.mN = fT2;
        super(fT2, "Slot" + (n / 2 + 1) + (n % 2 == 0 ? "Auto" : "Manual"));
        this.lO = n;
        try {
            String string = new String(this.ah(0x100000));
            Matcher matcher = fT.cl().matcher(string);
            if (matcher.find()) {
                this.na = matcher.group(3);
            }
            this.me = fn.T(string);
        }
        catch (IOException iOException) {
            hc.a("Could not read game mode from " + this.mO.name, iOException);
        }
    }

    fY(fT fT2, fV fV2, eY eY2) {
        this.mN = fT2;
        super(fT2, fV2);
        this.lO = fV2.mb;
        this.mZ.a(fV2.mQ);
        int n = fT.ao(eY2.J("Version"));
        if (n != 0) {
            this.mZ.setVersion(n);
        }
        this.na = eY2.getValueAsString("CommonStateData.SaveName");
        if (this.na != null) {
            this.mZ.Y(this.na);
        }
        this.me = fn.i(eY2);
        long l = eY2.K("PlayerStateData.TotalPlayTime");
        if (l != 0L) {
            this.mZ.d(l);
        }
        this.h(eY2);
    }

    @Override
    public fn L() {
        return this.me;
    }

    @Override
    public long lastModified() {
        return this.mO.timestamp;
    }

    @Override
    public eY M() {
        return this.a(eG.jV);
    }

    @Override
    public String b(eY eY2) {
        this.a(this.lO == 0 ? "wgsbackup" : "wgsbackup" + (this.lO + 1), this.me);
        int n = fT.ao(eY2.J("Version"));
        if (n != 0) {
            this.mZ.setVersion(n);
        }
        this.na = eY2.getValueAsString("CommonStateData.SaveName");
        if (this.na != null) {
            this.mZ.Y(this.na);
        }
        this.me = fn.i(eY2);
        long l = eY2.K("PlayerStateData.TotalPlayTime");
        if (l != 0L) {
            this.mZ.d(l);
        }
        this.h(eY2);
        return this.mO.filename;
    }

    public String toString() {
        return this.mO.name;
    }

    @Override
    public String getName() {
        return this.na;
    }

    @Override
    public String getDescription() {
        return this.mZ.getDescription();
    }
}
