/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import nomanssave.cg;
import nomanssave.du;
import nomanssave.gF;

class dy
extends MouseAdapter {
    final /* synthetic */ du hp;
    private final /* synthetic */ gF hq;

    dy(du du2, gF gF2) {
        this.hp = du2;
        this.hq = gF2;
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        if (mouseEvent.getClickCount() == 2 && this.hq != null) {
            cg.a(du.d(this.hp), this.hq);
            du.c(this.hp);
        }
    }
}
