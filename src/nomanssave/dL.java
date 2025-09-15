/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import java.awt.Component;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.UIManager;
import nomanssave.dJ;
import nomanssave.eM;

class dL
extends DefaultListCellRenderer {
    final /* synthetic */ dJ hG;

    dL(dJ dJ2) {
        this.hG = dJ2;
    }

    @Override
    public Component getListCellRendererComponent(JList jList, Object object, int n, boolean bl, boolean bl2) {
        JLabel jLabel = (JLabel)super.getListCellRendererComponent((JList<?>)jList, object, n, bl, bl2);
        if (object == null) {
            jLabel.setText("");
        } else {
            eM eM2 = (eM)object;
            if (eM2.aW()) {
                if (bl) {
                    jLabel.setBackground(UIManager.getColor("Settlement.positivePerkHighlight"));
                } else {
                    jLabel.setForeground(UIManager.getColor("Settlement.positivePerkColor"));
                }
            } else if (bl) {
                jLabel.setBackground(UIManager.getColor("Settlement.negativePerkHighlight"));
            } else {
                jLabel.setForeground(UIManager.getColor("Settlement.negativePerkColor"));
            }
        }
        return jLabel;
    }
}
