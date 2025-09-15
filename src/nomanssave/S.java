/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import nomanssave.Q;

class S
implements FocusListener {
    final /* synthetic */ Q bD;

    S(Q q) {
        this.bD = q;
    }

    @Override
    public void focusGained(FocusEvent focusEvent) {
    }

    @Override
    public void focusLost(FocusEvent focusEvent) {
        int n;
        try {
            n = Integer.parseInt(Q.d(this.bD).getText());
            if (n < Q.e(this.bD)) {
                n = Q.e(this.bD);
            }
        }
        catch (RuntimeException runtimeException) {
            n = Q.c((Q)this.bD).bF;
        }
        Q.d(this.bD).setText(Integer.toString(n));
    }
}
