/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import nomanssave.G;
import nomanssave.eb;
import nomanssave.ec;
import nomanssave.hg;

class ef
extends G {
    final /* synthetic */ ec ik;
    private final /* synthetic */ int il;

    ef(ec ec2, int n) {
        this.ik = ec2;
        this.il = n;
    }

    @Override
    protected String g(String string) {
        try {
            string = hg.aB(string).toString();
            if (!string.equals(eb.a(ec.h(this.ik))[this.il].ee())) {
                eb.a(ec.h(this.ik))[this.il].ax(string);
            }
            return string;
        }
        catch (RuntimeException runtimeException) {
            return eb.a(ec.h(this.ik))[this.il].ee();
        }
    }
}
