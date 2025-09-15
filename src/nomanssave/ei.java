/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import nomanssave.G;
import nomanssave.eb;
import nomanssave.ec;

class ei
extends G {
    final /* synthetic */ ec ik;
    private final /* synthetic */ int il;

    ei(ec ec2, int n) {
        this.ik = ec2;
        this.il = n;
    }

    @Override
    protected String g(String string) {
        try {
            int n = Integer.parseInt(string);
            if (n != eb.a(ec.h(this.ik))[this.il].eh()) {
                eb.a(ec.h(this.ik))[this.il].aI(n);
            }
            return string;
        }
        catch (RuntimeException runtimeException) {
            return Integer.toString(eb.a(ec.h(this.ik))[this.il].eh());
        }
    }
}
