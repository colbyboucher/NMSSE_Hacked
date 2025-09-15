/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import nomanssave.ey;
import nomanssave.h;

class m
implements ActionListener {
    final /* synthetic */ h z;

    m(h h2) {
        this.z = h2;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        h.a(this.z, (ey)h.j(this.z).getSelectedItem());
        this.z.setVisible(false);
    }
}
