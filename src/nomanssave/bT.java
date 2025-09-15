/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import nomanssave.bO;
import nomanssave.bS;
import nomanssave.en;

class bT
implements ActionListener {
    final /* synthetic */ bS fk;
    private final /* synthetic */ int fl;
    private final /* synthetic */ int fm;

    bT(bS bS2, int n, int n2) {
        this.fk = bS2;
        this.fl = n;
        this.fm = n2;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (!bO.a(bS.j(this.fk)).dp() && !en.aS()) {
            return;
        }
        if (bS.b(this.fk).isSelected()) {
            bO.a(bS.j(this.fk)).i(this.fl, this.fm);
        } else {
            if (bO.a(bS.j(this.fk)).f(this.fl, this.fm) != null) {
                bS.b(this.fk).setSelected(true);
                bO.b(bS.j(this.fk)).c("Cannot disable slots that are in use!");
                return;
            }
            bO.a(bS.j(this.fk)).j(this.fl, this.fm);
        }
        bS.c(this.fk);
    }
}
