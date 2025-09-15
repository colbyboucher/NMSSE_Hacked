/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import javax.swing.ComboBoxModel;
import javax.swing.event.ListDataListener;
import nomanssave.eb;
import nomanssave.ec;
import nomanssave.gy;

class ee
implements ComboBoxModel {
    final /* synthetic */ ec ik;
    private final /* synthetic */ int il;

    ee(ec ec2, int n) {
        this.ik = ec2;
        this.il = n;
    }

    @Override
    public int getSize() {
        return eb.aP().length;
    }

    public gy H(int n) {
        return eb.aP()[n];
    }

    @Override
    public void addListDataListener(ListDataListener listDataListener) {
    }

    @Override
    public void removeListDataListener(ListDataListener listDataListener) {
    }

    @Override
    public void setSelectedItem(Object object) {
        gy gy2 = (gy)((Object)object);
        if (gy2 != null && !gy2.equals((Object)eb.a(ec.h(this.ik))[this.il].ed())) {
            eb.a(ec.h(this.ik))[this.il].a(gy2);
        }
    }

    @Override
    public Object getSelectedItem() {
        return eb.a(ec.h(this.ik))[this.il].ed();
    }

    @Override
    public /* synthetic */ Object getElementAt(int n) {
        return this.H(n);
    }
}
