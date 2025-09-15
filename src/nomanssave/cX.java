/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import java.awt.Rectangle;
import javax.swing.text.BadLocationException;
import nomanssave.cW;

class cX
implements Runnable {
    final /* synthetic */ cW gL;

    cX(cW cW2) {
        this.gL = cW2;
    }

    @Override
    public void run() {
        try {
            int n = cW.a(this.gL).getDocument().getLength();
            Rectangle rectangle = cW.a(this.gL).modelToView(n);
            if (rectangle != null && rectangle.y != cW.b(this.gL)) {
                cW.c(this.gL);
                this.gL.repaint();
                cW.a(this.gL, rectangle.y);
            }
        }
        catch (BadLocationException badLocationException) {
            // empty catch block
        }
    }
}
