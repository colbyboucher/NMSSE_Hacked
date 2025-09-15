/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JTree;
import javax.swing.UIManager;
import javax.swing.tree.DefaultTreeCellRenderer;
import nomanssave.Application;
import nomanssave.cJ;
import nomanssave.cy;

class cA
extends DefaultTreeCellRenderer {
    final /* synthetic */ cy gg;

    cA(cy cy2) {
        this.gg = cy2;
    }

    @Override
    public Component getTreeCellRendererComponent(JTree jTree, Object object, boolean bl, boolean bl2, boolean bl3, int n, boolean bl4) {
        JLabel jLabel = (JLabel)super.getTreeCellRendererComponent(jTree, object, bl, bl2, bl3, n, bl4);
        if (((cJ)object).gi == null) {
            jLabel.setIcon(Application.a("UI-FILEICON.PNG", 20, 20));
        } else if (bl3) {
            jLabel.setIcon(UIManager.getIcon("Tree.leafIcon"));
        } else if (bl2) {
            jLabel.setIcon(UIManager.getIcon("Tree.openIcon"));
        } else {
            jLabel.setIcon(UIManager.getIcon("Tree.closedIcon"));
        }
        return jLabel;
    }
}
