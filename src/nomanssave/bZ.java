/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import nomanssave.bO;
import nomanssave.bS;

class bZ
implements ActionListener {
    final /* synthetic */ bS fk;
    private final /* synthetic */ int fl;
    private final /* synthetic */ int fm;

    bZ(bS bS2, int n, int n2) {
        this.fk = bS2;
        this.fl = n;
        this.fm = n2;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (!bO.a(bS.j(this.fk)).dq()) {
            return;
        }
        if (!bO.a(bS.j(this.fk)).l(this.fl, this.fm)) {
            return;
        }
        bO.a(bS.j(this.fk)).m(this.fl, this.fm);
        bS.c(this.fk);
    }
}
