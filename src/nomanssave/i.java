/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import nomanssave.ey;
import nomanssave.h;

class i
implements ActionListener {
    final /* synthetic */ h z;

    i(h h2) {
        this.z = h2;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        String string = h.a(this.z).getText();
        h.a(this.z, ey.b(h.b(this.z), string));
        h.c(this.z);
        if (h.d(this.z).size() == 0) {
            JOptionPane.showOptionDialog(this.z, "Item not found.", "Warning", 0, 2, null, new Object[]{"OK"}, null);
        }
    }
}
