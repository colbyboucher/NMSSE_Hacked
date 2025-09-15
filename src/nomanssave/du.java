/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.UIManager;
import nomanssave.bO;
import nomanssave.dt;
import nomanssave.dv;
import nomanssave.dw;
import nomanssave.dx;
import nomanssave.dy;
import nomanssave.ey;
import nomanssave.gF;

class du
extends JPanel {
    final gF hm;
    private JMenuItem fh;
    private JMenuItem hn;
    private JMenuItem fe;
    final /* synthetic */ dt ho;

    private du(dt dt2, gF gF2) {
        this.ho = dt2;
        this.hm = gF2;
        int n = UIManager.getInt("Inventory.gridSize");
        Dimension dimension = new Dimension(n, n);
        this.setBackground(bO.eK);
        this.setMinimumSize(dimension);
        this.setMaximumSize(dimension);
        this.setPreferredSize(dimension);
        this.setLayout(new GridBagLayout());
        this.setBorder(bO.eP);
        JPopupMenu jPopupMenu = new JPopupMenu();
        this.fe = new JMenuItem("Item Details");
        this.fe.addActionListener(new dv(this, gF2));
        jPopupMenu.add(this.fe);
        this.hn = new JMenuItem("Change Item");
        this.hn.addActionListener(new dw(this, gF2));
        jPopupMenu.add(this.hn);
        this.fh = new JMenuItem("Move Item");
        this.fh.addActionListener(new dx(this, gF2));
        jPopupMenu.add(this.fh);
        this.setComponentPopupMenu(jPopupMenu);
        this.addMouseListener(new dy(this, gF2));
        this.aM();
    }

    private void aM() {
        this.removeAll();
        int n = UIManager.getInt("Inventory.gridSize");
        Dimension dimension = new Dimension(n, n);
        this.setBackground(bO.eK);
        this.setMinimumSize(dimension);
        this.setMaximumSize(dimension);
        this.setPreferredSize(dimension);
        if (this.hm == null || !this.hm.isValid()) {
            this.fe.setEnabled(false);
            this.hn.setEnabled(false);
            this.fh.setEnabled(false);
        } else {
            GridBagConstraints gridBagConstraints;
            JLabel jLabel;
            this.fe.setEnabled(true);
            this.hn.setEnabled(true);
            this.fh.setEnabled(this.hm.dA() > 0);
            ey ey2 = ey.d(this.hm.dz());
            String string = ey2 == null ? this.hm.ei() : ey2.getName();
            int n2 = UIManager.getInt("Inventory.iconSize");
            Font font = UIManager.getFont("Inventory.font");
            ImageIcon imageIcon = ey2 == null ? null : ey2.c(n2, n2);
            int n3 = 0;
            if (imageIcon != null) {
                jLabel = new JLabel(imageIcon);
                jLabel.setPreferredSize(new Dimension(n2, n2));
                gridBagConstraints = new GridBagConstraints();
                gridBagConstraints.anchor = 10;
                gridBagConstraints.fill = 0;
                gridBagConstraints.insets = new Insets(5, 0, 5, 0);
                gridBagConstraints.gridx = 0;
                gridBagConstraints.gridy = n3++;
                this.add((Component)jLabel, gridBagConstraints);
            }
            jLabel = new JLabel();
            jLabel.setFont(font);
            jLabel.setBackground(null);
            jLabel.setBorder(null);
            jLabel.setText(string);
            jLabel.setForeground(bO.eO);
            gridBagConstraints = new GridBagConstraints();
            gridBagConstraints.anchor = 10;
            gridBagConstraints.fill = 0;
            gridBagConstraints.insets = new Insets(n3 == 0 ? n2 + 10 : 0, 0, 0, 0);
            gridBagConstraints.gridx = 0;
            gridBagConstraints.gridy = n3++;
            this.add((Component)jLabel, gridBagConstraints);
            jLabel = new JLabel();
            jLabel.setFont(font);
            jLabel.setBackground(null);
            jLabel.setBorder(null);
            jLabel.setText(String.valueOf(Integer.toString(this.hm.dA())) + "/" + Integer.toString(this.hm.dB()));
            jLabel.setForeground(bO.eO);
            gridBagConstraints = new GridBagConstraints();
            gridBagConstraints.anchor = 10;
            gridBagConstraints.fill = 0;
            gridBagConstraints.insets = new Insets(0, 0, 0, 0);
            gridBagConstraints.gridx = 0;
            gridBagConstraints.gridy = n3++;
            this.add((Component)jLabel, gridBagConstraints);
        }
        this.revalidate();
        this.updateUI();
    }

    static /* synthetic */ void c(du du2) {
        du2.aM();
    }

    /* synthetic */ du(dt dt2, gF gF2, du du2) {
        this(dt2, gF2);
    }

    static /* synthetic */ dt d(du du2) {
        return du2.ho;
    }
}
