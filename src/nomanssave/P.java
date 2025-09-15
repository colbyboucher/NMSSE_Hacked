/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import nomanssave.Application;
import nomanssave.I;
import nomanssave.cY;
import nomanssave.gf;
import nomanssave.gg;
import nomanssave.hc;

class P
implements ActionListener {
    final /* synthetic */ I bt;
    private final /* synthetic */ Application bv;

    P(I i, Application application) {
        this.bt = i;
        this.bv = application;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        gf gf2 = (gf)I.j(this.bt).getSelectedItem();
        if (gf2 == null) {
            return;
        }
        List list = gf2.cI();
        if (list.size() == 0) {
            this.bv.c("Cannot move base computer.\nPlease ensure that your base has a suitable Signal Booster / Blueprint Analyser / Beacon placed where you want your base computer to be.");
            return;
        }
        int n = cY.a(this.bv.g(), list);
        if (n < 0) {
            return;
        }
        gg gg2 = (gg)list.get(n);
        hc.info("Attempting to swap base computer with " + gg2.toString() + "...");
        if (gf2.a(gg2)) {
            hc.info("Base computer relocated: " + gf2.getName());
        } else {
            hc.info("Base computer not moved.");
            this.bv.c("An error occurred while attempting to move base computer.");
        }
    }
}
