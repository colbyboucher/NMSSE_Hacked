/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.ClipboardOwner;
import java.awt.datatransfer.Transferable;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.text.TextAction;
import nomanssave.cy;

class cG
extends TextAction
implements ClipboardOwner {
    final /* synthetic */ cy gg;

    public cG(cy cy2) {
        this.gg = cy2;
        super("Copy From Clipboard");
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        String string = ((JTextArea)actionEvent.getSource()).getSelectedText();
        if (string != null) {
            cy.b(string, this);
        }
    }

    @Override
    public void lostOwnership(Clipboard clipboard, Transferable transferable) {
    }
}
