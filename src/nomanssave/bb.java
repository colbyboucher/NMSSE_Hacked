/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import nomanssave.G;
import nomanssave.ba;
import nomanssave.hg;

class bb
implements ActionListener {
    final /* synthetic */ ba dB;
    private final /* synthetic */ G dC;

    bb(ba ba2, G g) {
        this.dB = ba2;
        this.dC = g;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        this.dC.f(hg.eo().toString());
    }
}
