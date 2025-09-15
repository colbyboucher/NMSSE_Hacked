/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import nomanssave.p;

class r
implements ActionListener {
    final /* synthetic */ p I;

    r(p p2) {
        this.I = p2;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        int[] nArray = p.b(this.I).getSelectedRows();
        p.a(this.I, new ArrayList());
        int n = 0;
        while (n < nArray.length) {
            int n2 = p.b(this.I).convertRowIndexToModel(nArray[n]);
            p.c(this.I).add((String)p.b(this.I).getModel().getValueAt(n2, 3));
            ++n;
        }
        this.I.setVisible(false);
    }
}
