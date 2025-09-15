/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import nomanssave.dt;
import nomanssave.du;
import nomanssave.gF;

class dx
implements ActionListener {
    final /* synthetic */ du hp;
    private final /* synthetic */ gF hq;

    dx(du du2, gF gF2) {
        this.hp = du2;
        this.hq = gF2;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (this.hq != null) {
            dt.b(du.d(this.hp), this.hp);
        }
    }
}
