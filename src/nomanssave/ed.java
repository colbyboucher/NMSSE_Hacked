/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import nomanssave.eb;
import nomanssave.ec;

class ed
implements ActionListener {
    final /* synthetic */ ec ik;
    private final /* synthetic */ int il;

    ed(ec ec2, int n) {
        this.ik = ec2;
        this.il = n;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (ec.a(this.ik).isSelected() ^ eb.a(ec.h(this.ik))[this.il].isEnabled()) {
            boolean bl = ec.a(this.ik).isSelected();
            eb.a(ec.h(this.ik))[this.il].setEnabled(bl);
            ec.b(this.ik).setEnabled(bl);
            ec.c(this.ik).setEnabled(bl);
            ec.d(this.ik).setEnabled(bl);
            ec.e(this.ik).setEnabled(bl);
            ec.f(this.ik).setEnabled(bl);
        }
    }
}
