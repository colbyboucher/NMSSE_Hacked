/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import nomanssave.aH;
import nomanssave.cy;

class cD
implements PropertyChangeListener {
    final /* synthetic */ cy gg;

    cD(cy cy2) {
        this.gg = cy2;
    }

    @Override
    public void propertyChange(PropertyChangeEvent propertyChangeEvent) {
        aH.b("JSONEditor.Divider", (Integer)propertyChangeEvent.getNewValue());
    }
}
