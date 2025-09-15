/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import nomanssave.eS;
import nomanssave.eU;
import nomanssave.gz;

public class gA {
    private final eS rd;
    final /* synthetic */ gz re;

    private gA(gz gz2, eS eS2) {
        this.re = gz2;
        this.rd = eS2;
    }

    public String getID() {
        return this.rd.getID();
    }

    public boolean c(eU eU2) {
        for (String string : this.rd.bw()) {
            if (this.rd.z(string) != eU2) continue;
            return gz.a(this.re, string, eU2.ordinal());
        }
        return false;
    }

    public void a(eU eU2, boolean bl) {
        for (String string : this.rd.bw()) {
            if (this.rd.z(string) != eU2) continue;
            gz.a(this.re, string, eU2.ordinal(), bl);
        }
    }

    /* synthetic */ gA(gz gz2, eS eS2, gA gA2) {
        this(gz2, eS2);
    }
}
