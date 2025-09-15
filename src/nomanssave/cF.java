/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import nomanssave.aW;
import nomanssave.cy;

class cF
extends AbstractAction {
    final /* synthetic */ cy gg;

    cF(cy cy2) {
        this.gg = cy2;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        int n = cy.c(this.gg).getSelectionStart();
        int n2 = cy.c(this.gg).getSelectionEnd();
        String string = n2 > n ? cy.c(this.gg).getText().substring(n, n2) : null;
        aW.a(this.gg, string);
    }
}
