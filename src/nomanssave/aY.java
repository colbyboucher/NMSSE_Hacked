/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import nomanssave.aW;

class aY
implements ActionListener {
    final /* synthetic */ aW dy;

    aY(aW aW2) {
        this.dy = aW2;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        this.dy.setVisible(false);
    }
}
