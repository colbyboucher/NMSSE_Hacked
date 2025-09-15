/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import nomanssave.eY;
import nomanssave.gm;

public class gn {
    final eY nj;
    final /* synthetic */ gm oK;

    private gn(gm gm2, eY eY2) {
        this.oK = gm2;
        this.nj = eY2;
    }

    public String cF() {
        Object object = this.nj.getValue("GalacticAddress");
        if (object instanceof String) {
            return (String)object;
        }
        if (object instanceof Number) {
            return "0x" + Long.toHexString(((Number)object).longValue());
        }
        return null;
    }

    public String getName() {
        return this.nj.getValueAsString("Name");
    }

    public void setName(String string) {
        this.nj.b("Name", string);
    }

    public int cG() {
        return this.nj.d("Objects").size();
    }

    public eY cH() {
        return this.nj;
    }

    public String toString() {
        return this.nj.getValueAsString("Name");
    }

    /* synthetic */ gn(gm gm2, eY eY2, gn gn2) {
        this(gm2, eY2);
    }
}
