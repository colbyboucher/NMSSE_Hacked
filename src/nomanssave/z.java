/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import javax.swing.JOptionPane;
import nomanssave.Application;

class z
implements Runnable {
    final /* synthetic */ Application aZ;
    private final /* synthetic */ String bc;

    z(Application application, String string) {
        this.aZ = application;
        this.bc = string;
    }

    @Override
    public void run() {
        JOptionPane.showOptionDialog(Application.h(this.aZ), this.bc, "Error", 0, 0, null, new Object[]{"Cancel"}, null);
    }
}
