/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JOptionPane;
import nomanssave.Application;
import nomanssave.aH;

class B
extends WindowAdapter {
    final /* synthetic */ Application aZ;

    B(Application application) {
        this.aZ = application;
    }

    @Override
    public void windowClosing(WindowEvent windowEvent) {
        int n;
        if ((Application.i(this.aZ) || Application.j(this.aZ)) && (n = JOptionPane.showConfirmDialog(Application.h(this.aZ), "Save data before closing?", "Save", 0)) == 0) {
            if (Application.i(this.aZ)) {
                Application.k(this.aZ);
            }
            if (Application.j(this.aZ)) {
                Application.l(this.aZ);
            }
        }
        if (aH.T()) {
            aH.U();
        }
        Application.h(this.aZ).dispose();
    }

    @Override
    public void windowDeactivated(WindowEvent windowEvent) {
        Application.e(this.aZ, true);
    }

    @Override
    public void windowActivated(WindowEvent windowEvent) {
        Application.e(this.aZ, false);
        Application.m(this.aZ);
    }
}
