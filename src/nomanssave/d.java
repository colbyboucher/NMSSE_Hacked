/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import java.awt.Component;
import javax.swing.JCheckBox;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

class d
extends JCheckBox
implements TableCellRenderer {
    private d() {
    }

    @Override
    public Component getTableCellRendererComponent(JTable jTable, Object object, boolean bl, boolean bl2, int n, int n2) {
        this.setBackground(jTable.getBackground());
        this.setHorizontalAlignment(0);
        this.setSelected(Boolean.TRUE == object);
        return this;
    }

    /* synthetic */ d(d d2) {
        this();
    }
}
