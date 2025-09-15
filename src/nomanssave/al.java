/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import javax.swing.ComboBoxModel;
import javax.swing.event.ListDataListener;
import nomanssave.aj;

class al
implements ComboBoxModel {
    String ch = null;
    final /* synthetic */ aj cg;

    al(aj aj2) {
        this.cg = aj2;
    }

    @Override
    public int getSize() {
        return aj.Q().size();
    }

    public String s(int n) {
        return (String)aj.Q().get(n);
    }

    @Override
    public void addListDataListener(ListDataListener listDataListener) {
    }

    @Override
    public void removeListDataListener(ListDataListener listDataListener) {
    }

    @Override
    public void setSelectedItem(Object object) {
        this.ch = (String)object;
    }

    @Override
    public Object getSelectedItem() {
        return this.ch;
    }

    @Override
    public /* synthetic */ Object getElementAt(int n) {
        return this.s(n);
    }
}
