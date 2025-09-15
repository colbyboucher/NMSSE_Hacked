/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import nomanssave.Application;
import nomanssave.bd;

class bk
implements ActionListener {
    final /* synthetic */ bd dP;
    private final /* synthetic */ Application bv;

    bk(bd bd2, Application application) {
        this.dP = bd2;
        this.bv = application;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (bd.a(this.dP) == null) {
            return;
        }
        this.bv.b(bd.a(this.dP));
    }
}
