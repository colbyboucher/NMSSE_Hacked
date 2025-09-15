/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import java.awt.Component;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JList;
import nomanssave.cN;

class cP
extends DefaultListCellRenderer {
    final /* synthetic */ cN gt;

    cP(cN cN2) {
        this.gt = cN2;
    }

    @Override
    public Component getListCellRendererComponent(JList jList, Object object, int n, boolean bl, boolean bl2) {
        Component component = super.getListCellRendererComponent((JList<?>)jList, object, n, bl, bl2);
        if (object == null && component instanceof JLabel) {
            JLabel jLabel = (JLabel)component;
            jLabel.setText(" ");
        }
        if (component instanceof JLabel) {
            Object object2;
            boolean bl3 = false;
            Enum[] enumArray = cN.e(this.gt);
            int n2 = enumArray.length;
            int n3 = 0;
            while (n3 < n2) {
                object2 = enumArray[n3];
                if (object2 == object) {
                    bl3 = true;
                    break;
                }
                ++n3;
            }
            object2 = (JLabel)component;
            if (!bl3) {
                if (bl) {
                    ((JComponent)object2).setBackground(cN.ag());
                } else {
                    ((JComponent)object2).setForeground(cN.aB());
                }
            }
        }
        return component;
    }
}
