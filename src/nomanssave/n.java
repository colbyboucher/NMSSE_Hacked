/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import nomanssave.h;

class n
implements ActionListener {
    final /* synthetic */ h z;

    n(h h2) {
        this.z = h2;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        this.z.setVisible(false);
    }
}
