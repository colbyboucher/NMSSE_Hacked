/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import nomanssave.aQ;
import nomanssave.en;

class aR
implements FocusListener {
    final /* synthetic */ aQ dr;

    aR(aQ aQ2) {
        this.dr = aQ2;
    }

    @Override
    public void focusGained(FocusEvent focusEvent) {
    }

    @Override
    public void focusLost(FocusEvent focusEvent) {
        int n;
        try {
            n = Integer.parseInt(aQ.a(this.dr).getText());
            if (n != aQ.b((aQ)this.dr).width) {
                if (n < aQ.c((aQ)this.dr).width) {
                    n = aQ.c((aQ)this.dr).width;
                } else if (n > aQ.d((aQ)this.dr).width && !en.aS()) {
                    n = aQ.d((aQ)this.dr).width;
                }
            }
        }
        catch (RuntimeException runtimeException) {
            n = aQ.b((aQ)this.dr).width;
        }
        aQ.a(this.dr).setText(Integer.toString(n));
    }
}
