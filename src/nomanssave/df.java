/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import nomanssave.dd;

class df
extends MouseAdapter {
    final /* synthetic */ dd gW;

    df(dd dd2) {
        this.gW = dd2;
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        if (mouseEvent.getClickCount() == 2) {
            dd.a(this.gW, dd.b(this.gW).getSelectedIndex());
            this.gW.setVisible(false);
        }
    }
}
