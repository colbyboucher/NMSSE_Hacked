/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import nomanssave.Application;

class w
implements Runnable {
    private final /* synthetic */ boolean ba;

    w(boolean bl) {
        this.ba = bl;
    }

    @Override
    public void run() {
        try {
            Application.g(new Application(this.ba, null));
            Application.h(Application.H()).setVisible(true);
        }
        catch (Exception exception) {
            exception.printStackTrace();
            System.exit(1);
        }
    }
}
