/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import nomanssave.aQ;
import nomanssave.en;

class aS
implements FocusListener {
    final /* synthetic */ aQ dr;

    aS(aQ aQ2) {
        this.dr = aQ2;
    }

    @Override
    public void focusGained(FocusEvent focusEvent) {
    }

    @Override
    public void focusLost(FocusEvent focusEvent) {
        int n;
        try {
            n = Integer.parseInt(aQ.e(this.dr).getText());
            if (n != aQ.b((aQ)this.dr).height) {
                if (n < aQ.c((aQ)this.dr).height) {
                    n = aQ.c((aQ)this.dr).height;
                } else if (n > aQ.d((aQ)this.dr).height && !en.aS()) {
                    n = aQ.d((aQ)this.dr).height;
                }
            }
        }
        catch (RuntimeException runtimeException) {
            n = aQ.b((aQ)this.dr).height;
        }
        aQ.e(this.dr).setText(Integer.toString(n));
    }
}
