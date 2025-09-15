/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import nomanssave.bO;
import nomanssave.bS;

class cb
implements ActionListener {
    final /* synthetic */ bS fk;
    private final /* synthetic */ int fl;
    private final /* synthetic */ int fm;

    cb(bS bS2, int n, int n2) {
        this.fk = bS2;
        this.fl = n;
        this.fm = n2;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        boolean bl = bS.d(this.fk).getState();
        bO.a(bS.j(this.fk)).a(this.fl, this.fm, bl);
        bS.c(this.fk);
    }
}
