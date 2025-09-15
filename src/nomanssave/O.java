/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import nomanssave.Application;
import nomanssave.I;
import nomanssave.gf;

class O
implements ActionListener {
    final /* synthetic */ I bt;
    private final /* synthetic */ Application bv;

    O(I i, Application application) {
        this.bt = i;
        this.bv = application;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        gf gf2 = (gf)I.j(this.bt).getSelectedItem();
        if (gf2 != null && this.bv.b(gf2)) {
            I.e(this.bt).setText(Integer.toString(gf2.cG()));
        }
    }
}
