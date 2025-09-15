/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import nomanssave.cy;

class cB
implements DocumentListener {
    final /* synthetic */ cy gg;

    cB(cy cy2) {
        this.gg = cy2;
    }

    @Override
    public void insertUpdate(DocumentEvent documentEvent) {
        cy.a(this.gg, true);
    }

    @Override
    public void removeUpdate(DocumentEvent documentEvent) {
        cy.a(this.gg, true);
    }

    @Override
    public void changedUpdate(DocumentEvent documentEvent) {
    }
}
