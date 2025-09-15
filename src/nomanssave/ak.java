/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import nomanssave.aj;
import nomanssave.hl;

class ak
implements ActionListener {
    final /* synthetic */ aj cg;

    ak(aj aj2) {
        this.cg = aj2;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        try {
            aj.a(this.cg, hl.e(aj.a(this.cg).getText().trim(), aj.b(this.cg).getSelectedIndex()));
            aj.c(this.cg);
        }
        catch (RuntimeException runtimeException) {
            JOptionPane.showOptionDialog(this.cg, "Invalid address value, please try again.", "Error", 0, 0, null, new Object[]{"Cancel"}, null);
            return;
        }
    }
}
