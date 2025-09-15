/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import nomanssave.aQ;
import nomanssave.bO;

class bR
implements ActionListener {
    final /* synthetic */ bO eX;

    bR(bO bO2) {
        this.eX = bO2;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (bO.a(this.eX) != null) {
            Dimension dimension = aQ.a(this.eX, bO.a(this.eX).getSize(), bO.a(this.eX).dm(), bO.a(this.eX).dn());
            if (dimension != null && bO.a(this.eX).a(dimension)) {
                bO.c(this.eX);
            }
            return;
        }
    }
}
