/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import javax.swing.ComboBoxModel;
import javax.swing.event.ListDataListener;
import nomanssave.eb;
import nomanssave.ec;
import nomanssave.gL;

class eg
implements ComboBoxModel {
    final /* synthetic */ ec ik;
    private final /* synthetic */ int il;

    eg(ec ec2, int n) {
        this.ik = ec2;
        this.il = n;
    }

    @Override
    public int getSize() {
        return gL.values().length;
    }

    public gL I(int n) {
        return gL.values()[n];
    }

    @Override
    public void addListDataListener(ListDataListener listDataListener) {
    }

    @Override
    public void removeListDataListener(ListDataListener listDataListener) {
    }

    @Override
    public void setSelectedItem(Object object) {
        gL gL2 = (gL)object;
        if (gL2 != null && !gL2.equals(eb.a(ec.h(this.ik))[this.il].ef())) {
            eb.a(ec.h(this.ik))[this.il].a(gL2);
        }
    }

    @Override
    public Object getSelectedItem() {
        return eb.a(ec.h(this.ik))[this.il].ef();
    }

    @Override
    public /* synthetic */ Object getElementAt(int n) {
        return this.I(n);
    }
}
