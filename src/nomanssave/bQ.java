/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import java.awt.Component;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;
import nomanssave.bO;
import nomanssave.gt;

class bQ
extends DefaultListCellRenderer {
    final /* synthetic */ bO eX;

    bQ(bO bO2) {
        this.eX = bO2;
    }

    @Override
    public Component getListCellRendererComponent(JList jList, Object object, int n, boolean bl, boolean bl2) {
        if (object instanceof gt) {
            object = ((gt)object).getSimpleName();
        }
        return super.getListCellRendererComponent((JList<?>)jList, object, n, bl, bl2);
    }
}
