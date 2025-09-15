/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import nomanssave.ap;

class at
implements ActionListener {
    final /* synthetic */ ap cu;

    at(ap ap2) {
        this.cu = ap2;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        int[] nArray = ap.c(this.cu).getSelectedRows();
        boolean bl = false;
        int n = nArray.length - 1;
        while (n >= 0) {
            ap.a(this.cu).ac(ap.c(this.cu).convertRowIndexToModel(nArray[n]));
            bl = true;
            --n;
        }
        if (bl) {
            ap.c(this.cu).clearSelection();
            ap.b(this.cu).sort();
            ap.c(this.cu).updateUI();
        }
    }
}
