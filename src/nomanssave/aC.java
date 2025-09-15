/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import java.awt.Component;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

class aC
extends JCheckBox
implements TableCellRenderer {
    final JLabel cv = new JLabel();

    aC() {
    }

    @Override
    public Component getTableCellRendererComponent(JTable jTable, Object object, boolean bl, boolean bl2, int n, int n2) {
        n = jTable.convertRowIndexToModel(n);
        if (!jTable.getModel().isCellEditable(n, n2)) {
            return this.cv;
        }
        this.setBackground(jTable.getBackground());
        this.setHorizontalAlignment(0);
        this.setSelected(Boolean.TRUE == object);
        return this;
    }
}
