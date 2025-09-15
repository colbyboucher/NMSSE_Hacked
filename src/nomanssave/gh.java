/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import nomanssave.eY;
import nomanssave.ge;
import nomanssave.gy;

public class gh {
    final String name;
    final eY nn;
    final /* synthetic */ ge nk;

    private gh(ge ge2, String string, eY eY2) {
        this.nk = ge2;
        this.name = string;
        this.nn = eY2;
    }

    public gy cJ() {
        return gy.as(this.nn.getValueAsString("ResourceElement.Filename"));
    }

    public String cK() {
        return this.nn.d("ResourceElement.Seed").X(1);
    }

    public void aa(String string) {
        this.nn.d("ResourceElement.Seed").a(1, string);
    }

    public String toString() {
        return this.name;
    }

    /* synthetic */ gh(ge ge2, String string, eY eY2, gh gh2) {
        this(ge2, string, eY2);
    }
}
