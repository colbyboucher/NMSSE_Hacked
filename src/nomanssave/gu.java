/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import nomanssave.eY;
import nomanssave.gQ;
import nomanssave.gt;

public class gu
implements gQ {
    private final eY qD;
    final /* synthetic */ gt qE;

    private gu(gt gt2, eY eY2) {
        this.qE = gt2;
        this.qD = eY2;
    }

    @Override
    public String getType() {
        return this.qD.getValueAsString("Type.InventoryType");
    }

    @Override
    public Object dz() {
        return this.qD.getValue("Id");
    }

    @Override
    public void m(Object object) {
        this.qD.b("Id", object);
    }

    @Override
    public int dA() {
        return this.qD.J("Amount");
    }

    @Override
    public void aA(int n) {
        this.qD.b("Amount", new Integer(n));
    }

    @Override
    public int dB() {
        return this.qD.J("MaxAmount");
    }

    public double dC() {
        return this.qD.L("DamageFactor");
    }

    public void c(double d) {
        this.qD.b("DamageFactor", new Double(d));
    }

    public boolean dD() {
        return this.qD.M("FullyInstalled");
    }

    public void e(boolean bl) {
        this.qD.b("FullyInstalled", new Boolean(bl));
    }

    /* synthetic */ gu(gt gt2, eY eY2, gu gu2) {
        this(gt2, eY2);
    }
}
