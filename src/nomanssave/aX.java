/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import nomanssave.aW;
import nomanssave.cy;

class aX
implements ActionListener {
    final /* synthetic */ aW dy;
    private final /* synthetic */ cy dz;

    aX(aW aW2, cy cy2) {
        this.dy = aW2;
        this.dz = cy2;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        String string = aW.a(this.dy).getText();
        if (string.length() > 0) {
            this.dz.a(string, aW.b(this.dy).isSelected(), aW.c(this.dy).isSelected(), aW.d(this.dy).isSelected());
        }
    }
}
