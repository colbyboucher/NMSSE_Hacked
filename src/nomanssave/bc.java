/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.JButton;
import nomanssave.G;
import nomanssave.ba;

class bc
implements PropertyChangeListener {
    final /* synthetic */ ba dB;
    private final /* synthetic */ JButton dD;
    private final /* synthetic */ G dC;

    bc(ba ba2, JButton jButton, G g) {
        this.dB = ba2;
        this.dD = jButton;
        this.dC = g;
    }

    @Override
    public void propertyChange(PropertyChangeEvent propertyChangeEvent) {
        this.dD.setEnabled(this.dC.isEnabled());
    }
}
