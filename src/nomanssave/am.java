/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import nomanssave.aj;

class am
implements ActionListener {
    final /* synthetic */ aj cg;

    am(aj aj2) {
        this.cg = aj2;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        int n = aj.b(this.cg).getSelectedIndex();
        if (n < 0) {
            JOptionPane.showOptionDialog(this.cg, "Invalid galaxy selected, please try again.", "Error", 0, 0, null, new Object[]{"Cancel"}, null);
            return;
        }
        if (JOptionPane.showOptionDialog(this.cg, "This will warp your character and ship to the specified system (not the portal itself).", "Confirm", 2, 1, null, new String[]{"OK", "Cancel"}, null) == 0) {
            aj.a(this.cg, true);
            this.cg.setVisible(false);
        }
    }
}
