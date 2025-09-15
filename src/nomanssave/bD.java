/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import java.awt.Component;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.UIManager;
import nomanssave.bl;
import nomanssave.er;

class bD
extends DefaultListCellRenderer {
    final /* synthetic */ bl er;

    private bD(bl bl2) {
        this.er = bl2;
    }

    @Override
    public Component getListCellRendererComponent(JList jList, Object object, int n, boolean bl2, boolean bl3) {
        Object object2;
        Component component = super.getListCellRendererComponent((JList<?>)jList, object, n, bl2, bl3);
        if (object == null && component instanceof JLabel) {
            object2 = (JLabel)component;
            ((JLabel)object2).setText(" ");
        }
        if (object instanceof er && component instanceof JLabel) {
            object2 = (er)object;
            JLabel jLabel = (JLabel)component;
            if (((er)object2).aW()) {
                if (bl2) {
                    jLabel.setBackground(UIManager.getColor("Frigate.positiveTraitHighlight"));
                } else {
                    jLabel.setForeground(UIManager.getColor("Frigate.positiveTraitColor"));
                }
            } else if (bl2) {
                jLabel.setBackground(UIManager.getColor("Frigate.negativeTraitHighlight"));
            } else {
                jLabel.setForeground(UIManager.getColor("Frigate.negativeTraitColor"));
            }
        }
        return component;
    }

    /* synthetic */ bD(bl bl2, bD bD2) {
        this(bl2);
    }
}
