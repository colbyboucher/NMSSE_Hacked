/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import nomanssave.Application;
import nomanssave.X;

class ai
implements ActionListener {
    final /* synthetic */ X bV;
    private final /* synthetic */ Application bv;

    ai(X x, Application application) {
        this.bV = x;
        this.bv = application;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        int n = X.k(this.bV).getSelectedIndex();
        if (n < 0 || n >= X.a(this.bV).length) {
            return;
        }
        if (JOptionPane.showConfirmDialog(this.bV, "Are you sure you want to delete this companion?", "Delete", 2) != 0) {
            return;
        }
        this.bv.a(X.a(this.bV)[n].cL(), X.a(this.bV)[n].getIndex());
    }
}
