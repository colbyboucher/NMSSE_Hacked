/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

class aA
extends DefaultTableCellRenderer {
    int f;

    public aA(JTable jTable, int n) {
        this.f = n;
    }

    @Override
    public Component getTableCellRendererComponent(JTable jTable, Object object, boolean bl, boolean bl2, int n, int n2) {
        JLabel jLabel = (JLabel)super.getTableCellRendererComponent(jTable, object, bl, bl2, n, n2);
        jLabel.setHorizontalAlignment(this.f);
        return jLabel;
    }
}
