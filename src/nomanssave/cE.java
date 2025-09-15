/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JOptionPane;
import nomanssave.cy;
import nomanssave.eX;

class cE
extends WindowAdapter {
    final /* synthetic */ cy gg;

    cE(cy cy2) {
        this.gg = cy2;
    }

    @Override
    public void windowClosing(WindowEvent windowEvent) {
        boolean bl = true;
        if (cy.g(this.gg) && cy.d(this.gg) != null) {
            try {
                String string = cy.c(this.gg).getText().trim();
                if (string.length() == 0 && JOptionPane.showConfirmDialog(this.gg, "The JSON data has been deleted, do you wish to apply these changes to the save file?", this.gg.getTitle(), 0) == 0) {
                    cy.d(this.gg).remove();
                } else if (JOptionPane.showConfirmDialog(this.gg, "The JSON data has changed, do you wish to apply these changes to the save file?", this.gg.getTitle(), 0) == 0) {
                    cy.d(this.gg).setText(string);
                }
            }
            catch (eX eX2) {
                JOptionPane.showOptionDialog(this.gg, "Error on line #" + eX2.getLineNumber() + ": " + eX2.getMessage(), "Error", 0, 0, null, new Object[]{"Cancel"}, null);
                cy.c(this.gg).setCaretPosition(eX2.bD());
                cy.c(this.gg).requestFocus();
                bl = false;
            }
        }
        if (bl) {
            this.gg.setVisible(false);
        }
    }
}
