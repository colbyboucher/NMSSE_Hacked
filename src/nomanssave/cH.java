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

class cH
extends TextAction
implements ClipboardOwner {
    final /* synthetic */ cy gg;

    public cH(cy cy2) {
        this.gg = cy2;
        super("Paste From Clipboard");
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        String string = cy.az();
        ((JTextArea)actionEvent.getSource()).replaceSelection(string);
    }

    @Override
    public void lostOwnership(Clipboard clipboard, Transferable transferable) {
    }
}
