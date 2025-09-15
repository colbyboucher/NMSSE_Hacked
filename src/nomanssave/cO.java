/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import javax.swing.ComboBoxModel;
import javax.swing.SwingUtilities;
import javax.swing.event.ListDataListener;
import nomanssave.cN;
import nomanssave.gD;

class cO
implements ComboBoxModel {
    final /* synthetic */ cN gt;
    private final /* synthetic */ Class gu;

    cO(cN cN2, Class clazz) {
        this.gt = cN2;
        this.gu = clazz;
    }

    @Override
    public int getSize() {
        return ((Enum[])this.gu.getEnumConstants()).length + cN.a(this.gt).size();
    }

    @Override
    public Object getElementAt(int n) {
        if (n < ((Enum[])this.gu.getEnumConstants()).length) {
            return ((Enum[])this.gu.getEnumConstants())[n];
        }
        return cN.a(this.gt).get(n - ((Enum[])this.gu.getEnumConstants()).length);
    }

    @Override
    public void addListDataListener(ListDataListener listDataListener) {
    }

    @Override
    public void removeListDataListener(ListDataListener listDataListener) {
    }

    @Override
    public void setSelectedItem(Object object) {
        Object object2 = cN.b(this.gt);
        cN.a(this.gt, object);
        if (cN.c(this.gt) != null) {
            SwingUtilities.invokeLater(() -> {
                if (cN.b(this.gt) == null) {
                    if (object2 != null) {
                        cN.c(this.gt).setSelectedValue(null);
                    }
                } else if (object2 == null || !cN.b(this.gt).equals(object2)) {
                    if (cN.d(this.gt)) {
                        cN.c(this.gt).setSelectedValue(((gD)cN.b(this.gt)).K());
                    } else if (cN.b(this.gt) instanceof Enum) {
                        cN.c(this.gt).setSelectedValue(((Enum)cN.b(this.gt)).name());
                    } else {
                        cN.c(this.gt).setSelectedValue(cN.b(this.gt).toString());
                    }
                }
            });
        }
    }

    @Override
    public Object getSelectedItem() {
        return cN.b(this.gt);
    }
}
