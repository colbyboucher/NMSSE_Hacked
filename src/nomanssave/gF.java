/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import nomanssave.eY;
import nomanssave.gE;
import nomanssave.gQ;

public class gF
implements gQ {
    private final eY kM;
    final /* synthetic */ gE rf;

    private gF(gE gE2, eY eY2) {
        this.rf = gE2;
        this.kM = eY2;
    }

    public boolean isValid() {
        String string = this.kM.getValueAsString("ElementId");
        return string != null && string.length() > 1;
    }

    @Override
    public String getType() {
        return "Product";
    }

    @Override
    public Object dz() {
        return this.kM.getValue("ElementId");
    }

    @Override
    public void m(Object object) {
        this.kM.b("ElementId", object);
        this.kM.b("LastChangeTimestamp", (int)(System.currentTimeMillis() / 1000L));
    }

    @Override
    public int dA() {
        return this.kM.J("Amount");
    }

    @Override
    public void aA(int n) {
        this.kM.b("Amount", n);
        this.kM.b("LastChangeTimestamp", (int)(System.currentTimeMillis() / 1000L));
    }

    @Override
    public int dB() {
        return 999;
    }

    /* synthetic */ gF(gE gE2, eY eY2, gF gF2) {
        this(gE2, eY2);
    }
}
