/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.UIManager;
import nomanssave.bO;
import nomanssave.bS;
import nomanssave.cg;
import nomanssave.gu;

class bX
extends MouseAdapter {
    final /* synthetic */ bS fk;
    private final /* synthetic */ int fl;
    private final /* synthetic */ int fm;

    bX(bS bS2, int n, int n2) {
        this.fk = bS2;
        this.fl = n;
        this.fm = n2;
    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {
        if (!bO.a(bS.j(this.fk)).h(this.fl, this.fm) || bO.a(bS.j(this.fk)).l(this.fl, this.fm)) {
            return;
        }
        int n = UIManager.getInt("Inventory.gridSize");
        int n2 = this.fl + (int)Math.floor((double)mouseEvent.getX() / (double)n);
        int n3 = this.fm + (int)Math.floor((double)mouseEvent.getY() / (double)n);
        if (n2 < 0 || n2 >= bO.a(bS.j(this.fk)).getWidth()) {
            return;
        }
        if (n3 < 0 || n3 >= bO.a(bS.j(this.fk)).getHeight()) {
            return;
        }
        if (n2 == this.fl && n3 == this.fm) {
            return;
        }
        bS bS2 = bO.a(bS.j(this.fk), n2, n3);
        if (bS2 == null || !bS.e(bS2) || bS.f(bS2)) {
            return;
        }
        if (mouseEvent.isControlDown()) {
            bO.a(bS.j(this.fk)).a(this.fl, this.fm, n2, n3);
        } else {
            bO.a(bS.j(this.fk)).b(this.fl, this.fm, n2, n3);
        }
        bS.c(this.fk);
        bS.c(bS2);
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        gu gu2;
        if (mouseEvent.getClickCount() == 2 && (gu2 = bO.a(bS.j(this.fk)).f(this.fl, this.fm)) != null) {
            cg.a(bS.j(this.fk), gu2);
            bS.c(this.fk);
        }
    }
}
