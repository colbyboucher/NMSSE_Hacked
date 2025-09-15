/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JTextField;
import nomanssave.bE;
import nomanssave.bK;
import nomanssave.bL;

class bM
implements FocusListener {
    final /* synthetic */ bL eC;
    private final /* synthetic */ bK eD;

    bM(bL bL2, bK bK2) {
        this.eC = bL2;
        this.eD = bK2;
    }

    @Override
    public void focusGained(FocusEvent focusEvent) {
    }

    @Override
    public void focusLost(FocusEvent focusEvent) {
        if (bE.a(bL.a(this.eC)) == null) {
            return;
        }
        JTextField jTextField = (JTextField)focusEvent.getComponent();
        String string = this.eD.ab();
        String string2 = jTextField.getText();
        if (!string2.equals(string)) {
            try {
                this.eD.l(string2);
            }
            catch (RuntimeException runtimeException) {
                jTextField.setText(string);
            }
        }
    }
}
