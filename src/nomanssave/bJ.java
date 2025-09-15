/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import nomanssave.G;
import nomanssave.bE;
import nomanssave.gs;
import nomanssave.hf;

class bJ
extends G {
    final gs ez;
    final int type;
    final /* synthetic */ bE ey;

    bJ(bE bE2, gs gs2, boolean bl) {
        this.ey = bE2;
        this.ez = gs2;
        switch (gs2) {
            case pN: {
                this.type = 1;
                break;
            }
            default: {
                this.type = 0;
            }
        }
        this.setEnabled(bl);
    }

    @Override
    protected String g(String string) {
        String string2;
        if (bE.a(this.ey) == null) {
            return "";
        }
        switch (this.type) {
            case 0: {
                string2 = Integer.toString(bE.a(this.ey).a(this.ez));
                break;
            }
            case 1: {
                string2 = Double.toString(bE.a(this.ey).b(this.ez));
                break;
            }
            default: {
                return "";
            }
        }
        if (string.equals(string2)) {
            return string;
        }
        try {
            int n;
            switch (this.type) {
                case 0: {
                    n = hf.b(string, 0, Integer.MAX_VALUE);
                    bE.a(this.ey).a(this.ez, n);
                    string = Integer.toString(n);
                    break;
                }
                case 1: {
                    double d = Double.parseDouble(string);
                    bE.a(this.ey).a(this.ez, d);
                    string = Double.toString(d);
                }
            }
            bE.a(this.ey, this.ez, string);
            if (this.ez == gs.pL || this.ez == gs.pM) {
                n = bE.a(this.ey).a(gs.pL) + bE.a(this.ey).a(gs.pM);
                bE.a(this.ey).a(gs.pR, n);
                bE.a(this.ey, gs.pR, Integer.toString(n));
            }
            if (this.ez == gs.pI || this.ez == gs.pK || this.ez == gs.pJ) {
                n = bE.a(this.ey).a(gs.pI) + bE.a(this.ey).a(gs.pK) + bE.a(this.ey).a(gs.pJ);
                bE.a(this.ey).a(gs.pS, n);
                bE.a(this.ey, gs.pS, Integer.toString(n));
            }
            return string;
        }
        catch (RuntimeException runtimeException) {
            return string2;
        }
    }

    void ac() {
        String string;
        if (bE.a(this.ey) == null) {
            string = "";
        } else {
            switch (this.type) {
                case 0: {
                    string = Integer.toString(bE.a(this.ey).a(this.ez));
                    break;
                }
                case 1: {
                    string = Double.toString(bE.a(this.ey).b(this.ez));
                    break;
                }
                default: {
                    string = "";
                }
            }
        }
        this.setText(string);
    }
}
