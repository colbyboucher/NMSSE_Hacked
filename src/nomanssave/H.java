/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import nomanssave.G;

class H
implements FocusListener {
    final /* synthetic */ G bg;

    H(G g) {
        this.bg = g;
    }

    @Override
    public void focusGained(FocusEvent focusEvent) {
    }

    @Override
    public void focusLost(FocusEvent focusEvent) {
        this.bg.N();
    }
}
