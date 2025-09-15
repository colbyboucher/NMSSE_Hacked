/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import java.awt.Component;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import nomanssave.ap;

class aB
extends DefaultTableCellRenderer {
    final /* synthetic */ ap cu;

    private aB(ap ap2) {
        this.cu = ap2;
    }

    @Override
    public Component getTableCellRendererComponent(JTable jTable, Object object, boolean bl, boolean bl2, int n, int n2) {
        JLabel jLabel = (JLabel)super.getTableCellRendererComponent(jTable, "", bl, bl2, n, n2);
        jLabel.setIcon((ImageIcon)object);
        return jLabel;
    }

    /* synthetic */ aB(ap ap2, aB aB2) {
        this(ap2);
    }
}
