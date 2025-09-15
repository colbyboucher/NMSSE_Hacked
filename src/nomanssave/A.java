/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import javax.swing.JOptionPane;
import nomanssave.Application;

class A
implements Runnable {
    final /* synthetic */ Application aZ;
    private final /* synthetic */ String bc;

    A(Application application, String string) {
        this.aZ = application;
        this.bc = string;
    }

    @Override
    public void run() {
        JOptionPane.showOptionDialog(Application.h(this.aZ), this.bc, "Warning", 0, 2, null, new Object[]{"OK"}, null);
    }
}
