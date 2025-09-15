/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import nomanssave.G;
import nomanssave.I;
import nomanssave.gh;
import nomanssave.hg;

class K
extends G {
    final /* synthetic */ I bt;

    K(I i) {
        this.bt = i;
    }

    @Override
    protected String g(String string) {
        gh gh2 = (gh)I.d(this.bt).getSelectedItem();
        if (gh2 == null) {
            return "";
        }
        try {
            string = hg.aB(string).toString();
            if (!string.equals(gh2.cK())) {
                gh2.aa(string);
            }
            return string;
        }
        catch (RuntimeException runtimeException) {
            return gh2.cK();
        }
    }
}
