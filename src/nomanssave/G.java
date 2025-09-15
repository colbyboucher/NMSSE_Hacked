/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import javax.swing.JTextField;
import nomanssave.H;

public abstract class G
extends JTextField {
    public G() {
        this.addFocusListener(new H(this));
    }

    public void N() {
        this.setText(this.g(this.getText()));
    }

    public void f(String string) {
        this.setText(this.g(string));
    }

    protected abstract String g(String var1);
}
