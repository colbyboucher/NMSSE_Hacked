/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import nomanssave.bO;
import nomanssave.bS;
import nomanssave.gu;

class bV
implements ActionListener {
    final /* synthetic */ bS fk;
    private final /* synthetic */ int fl;
    private final /* synthetic */ int fm;

    bV(bS bS2, int n, int n2) {
        this.fk = bS2;
        this.fl = n;
        this.fm = n2;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        gu gu2 = bO.a(bS.j(this.fk)).f(this.fl, this.fm);
        if (gu2 != null && gu2.dA() >= 0 && gu2.dB() > 0) {
            gu2.aA(gu2.dB());
            bS.c(this.fk);
        }
    }
}
