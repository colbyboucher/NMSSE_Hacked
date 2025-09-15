/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import nomanssave.cg;

class ck
extends WindowAdapter {
    final /* synthetic */ cg fF;

    ck(cg cg2) {
        this.fF = cg2;
    }

    @Override
    public void windowClosing(WindowEvent windowEvent) {
        cg.e(this.fF).N();
        cg.f(this.fF).N();
    }
}
