/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import nomanssave.ap;

class aw
implements ActionListener {
    final /* synthetic */ ap cu;

    aw(ap ap2) {
        this.cu = ap2;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        int[] nArray = ap.h(this.cu).getSelectedRows();
        boolean bl = false;
        int n = nArray.length - 1;
        while (n >= 0) {
            int n2 = ap.h(this.cu).convertRowIndexToModel(nArray[n]);
            String string = (String)ap.d(this.cu).get(n2);
            ap.d(this.cu).remove(n2);
            while ((n2 = ap.e(this.cu).indexOf(string)) >= 0) {
                ap.e(this.cu).ac(n2);
            }
            while ((n2 = ap.f(this.cu).indexOf(string)) >= 0) {
                ap.f(this.cu).ac(n2);
            }
            bl = true;
            --n;
        }
        if (bl) {
            ap.h(this.cu).clearSelection();
            ap.g(this.cu).sort();
            ap.h(this.cu).updateUI();
        }
    }
}
