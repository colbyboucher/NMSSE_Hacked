/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import nomanssave.ap;
import nomanssave.p;

class as
implements ActionListener {
    final /* synthetic */ ap cu;

    as(ap ap2) {
        this.cu = ap2;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        String[] stringArray = p.b(this.cu);
        boolean bl = false;
        int n = 0;
        while (n < stringArray.length) {
            if (!ap.a(this.cu).hasValue(stringArray[n])) {
                ap.a(this.cu).f(stringArray[n]);
                bl = true;
            }
            ++n;
        }
        if (bl) {
            ap.b(this.cu).sort();
            ap.c(this.cu).updateUI();
        }
    }
}
