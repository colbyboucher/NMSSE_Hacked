/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import java.util.ArrayList;
import java.util.List;
import nomanssave.eY;
import nomanssave.gV;
import nomanssave.ge;
import nomanssave.gg;

public class gf {
    final eY nj;
    final /* synthetic */ ge nk;

    private gf(ge ge2, eY eY2) {
        this.nk = ge2;
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

    public List cI() {
        ArrayList<gg> arrayList = new ArrayList<gg>();
        for (eY eY2 : gV.G(this.nj)) {
            arrayList.add(new gg(this, eY2));
        }
        return arrayList;
    }

    public boolean a(gg gg2) {
        return gV.a(this.nj, gg2.nl);
    }

    public String toString() {
        return this.nj.getValueAsString("Name");
    }

    /* synthetic */ gf(ge ge2, eY eY2, gf gf2) {
        this(ge2, eY2);
    }
}
