/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import nomanssave.cI;
import nomanssave.cy;
import nomanssave.eX;

class cC
implements ActionListener {
    final /* synthetic */ cy gg;

    cC(cy cy2) {
        this.gg = cy2;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        String string = cy.c(this.gg).getText().trim();
        try {
            cy.d(this.gg).setText(string);
            ((cI)cy.e(this.gg).getModel()).a(cy.d(this.gg));
            cy.e(this.gg).setSelectionRow(0);
            cy.e(this.gg).setVisible(true);
            cy.f(this.gg).setVisible(false);
        }
        catch (eX eX2) {
            JOptionPane.showOptionDialog(this.gg, "Error on line #" + eX2.getLineNumber() + ": " + eX2.getMessage(), "Error", 0, 0, null, new Object[]{"Cancel"}, null);
            cy.c(this.gg).setCaretPosition(eX2.bD());
            cy.c(this.gg).requestFocus();
        }
    }
}
