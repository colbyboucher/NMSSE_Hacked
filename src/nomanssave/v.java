/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import nomanssave.Application;

class v
implements Runnable {
    final /* synthetic */ Application aZ;

    v(Application application) {
        this.aZ = application;
    }

    @Override
    public void run() {
        Application.p(this.aZ);
    }
}
