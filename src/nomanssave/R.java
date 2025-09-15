/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import nomanssave.Q;

class R
implements FocusListener {
    final /* synthetic */ Q bD;

    R(Q q) {
        this.bD = q;
    }

    @Override
    public void focusGained(FocusEvent focusEvent) {
    }

    @Override
    public void focusLost(FocusEvent focusEvent) {
        int n;
        try {
            n = Integer.parseInt(Q.a(this.bD).getText());
            if (n % 250 != 0) {
                n = (int)Math.round((double)n / 250.0);
            }
            if (n < Q.b(this.bD)) {
                n = Q.b(this.bD);
            }
        }
        catch (RuntimeException runtimeException) {
            n = Q.c((Q)this.bD).bE;
        }
        Q.a(this.bD).setText(Integer.toString(n));
    }
}
