/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import nomanssave.G;
import nomanssave.eb;
import nomanssave.ec;
import nomanssave.hg;

class eh
extends G {
    final /* synthetic */ ec ik;
    private final /* synthetic */ int il;

    eh(ec ec2, int n) {
        this.ik = ec2;
        this.il = n;
    }

    @Override
    protected String g(String string) {
        try {
            string = hg.aB(string).toString();
            if (!string.equals(eb.a(ec.h(this.ik))[this.il].eg())) {
                eb.a(ec.h(this.ik))[this.il].ay(string);
            }
            return string;
        }
        catch (RuntimeException runtimeException) {
            return eb.a(ec.h(this.ik))[this.il].eg();
        }
    }
}
