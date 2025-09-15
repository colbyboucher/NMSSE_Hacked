/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import nomanssave.cg;
import nomanssave.du;
import nomanssave.gF;

class dv
implements ActionListener {
    final /* synthetic */ du hp;
    private final /* synthetic */ gF hq;

    dv(du du2, gF gF2) {
        this.hp = du2;
        this.hq = gF2;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (this.hq != null) {
            cg.a(du.d(this.hp), this.hq);
            du.c(this.hp);
        }
    }
}
