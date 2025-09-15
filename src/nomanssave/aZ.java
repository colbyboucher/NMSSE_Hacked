/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import nomanssave.aW;

class aZ
implements ActionListener {
    final /* synthetic */ aW dy;

    aZ(aW aW2) {
        this.dy = aW2;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        this.dy.setVisible(false);
    }
}
