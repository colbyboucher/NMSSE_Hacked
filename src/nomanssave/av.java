/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import nomanssave.ap;
import nomanssave.ey;
import nomanssave.p;

class av
implements ActionListener {
    final /* synthetic */ ap cu;

    av(ap ap2) {
        this.cu = ap2;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        String[] stringArray = p.c(this.cu);
        boolean bl = false;
        int n = 0;
        while (n < stringArray.length) {
            ey ey2 = ey.d(stringArray[n]);
            if (!ap.d(this.cu).contains(stringArray[n])) {
                if (ey2.be()) {
                    ap.e(this.cu).f(stringArray[n]);
                }
                if (ey2.bd()) {
                    ap.f(this.cu).f(stringArray[n]);
                }
                ap.d(this.cu).add(stringArray[n]);
                bl = true;
            }
            ++n;
        }
        if (bl) {
            ap.g(this.cu).sort();
            ap.h(this.cu).updateUI();
        }
    }
}
