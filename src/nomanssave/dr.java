/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import nomanssave.Application;
import nomanssave.dj;

class dr
implements ActionListener {
    final /* synthetic */ dj hl;
    private final /* synthetic */ Application bv;

    dr(dj dj2, Application application) {
        this.hl = dj2;
        this.bv = application;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        int n = dj.j(this.hl).getSelectedIndex();
        if (n < 0 || n >= dj.a(this.hl).length) {
            return;
        }
        this.bv.a(dj.a(this.hl)[n]);
    }
}
