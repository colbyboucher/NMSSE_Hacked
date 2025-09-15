/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.ImageIcon;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.UIManager;
import nomanssave.bO;
import nomanssave.bT;
import nomanssave.bU;
import nomanssave.bV;
import nomanssave.bW;
import nomanssave.bX;
import nomanssave.bY;
import nomanssave.bZ;
import nomanssave.ca;
import nomanssave.cb;
import nomanssave.cc;
import nomanssave.cd;
import nomanssave.ce;
import nomanssave.cf;
import nomanssave.eQ;
import nomanssave.en;
import nomanssave.ey;
import nomanssave.gu;

class bS
extends JPanel {
    private final int x;
    private final int y;
    private JCheckBoxMenuItem eY;
    private JMenuItem eZ;
    private JMenuItem fa;
    private JMenuItem fb;
    private JCheckBoxMenuItem fc;
    private JMenuItem fd;
    private JMenuItem fe;
    private JMenuItem ff;
    private JMenuItem fg;
    private JMenuItem fh;
    private JMenuItem fi;
    private JMenuItem fj;
    final /* synthetic */ bO eX;

    private bS(bO bO2, int n, int n2) {
        this.eX = bO2;
        this.x = n;
        this.y = n2;
        this.setLayout(new GridBagLayout());
        JPopupMenu jPopupMenu = new JPopupMenu();
        this.eY = new JCheckBoxMenuItem("Enabled");
        this.eY.addActionListener(new bT(this, n, n2));
        this.eY.setEnabled(bO.a(bO2).dp() || en.aS());
        jPopupMenu.add(this.eY);
        this.eZ = new JMenuItem("Enable All Slots");
        this.eZ.addActionListener(new bY(this));
        this.eZ.setEnabled(bO.a(bO2).dp() || en.aS());
        jPopupMenu.add(this.eZ);
        this.fa = new JMenuItem("Repair Slot");
        this.fa.addActionListener(new bZ(this, n, n2));
        this.fa.setVisible(bO.a(bO2).dq());
        jPopupMenu.add(this.fa);
        this.fb = new JMenuItem("Repair All Slots");
        this.fb.addActionListener(new ca(this));
        this.fb.setVisible(bO.a(bO2).dq());
        jPopupMenu.add(this.fb);
        this.fc = new JCheckBoxMenuItem("Supercharged");
        this.fc.addActionListener(new cb(this, n, n2));
        this.fc.setVisible(bO.a(bO2).do());
        jPopupMenu.add(this.fc);
        this.fd = new JMenuItem("Supercharge All Slots");
        this.fd.addActionListener(new cc(this));
        this.fd.setVisible(bO.a(bO2).do());
        jPopupMenu.add(this.fd);
        jPopupMenu.addSeparator();
        this.fe = new JMenuItem("Item Details");
        this.fe.addActionListener(new cd(this, n, n2));
        jPopupMenu.add(this.fe);
        this.ff = new JMenuItem("Add Item");
        this.ff.addActionListener(new ce(this, n, n2));
        jPopupMenu.add(this.ff);
        this.fg = new JMenuItem("Repair Item");
        this.fg.addActionListener(new cf(this, n, n2));
        jPopupMenu.add(this.fg);
        this.fh = new JMenuItem("Move Item");
        this.fh.addActionListener(new bU(this, n, n2));
        jPopupMenu.add(this.fh);
        this.fi = new JMenuItem("Fill Stack");
        this.fi.addActionListener(new bV(this, n, n2));
        jPopupMenu.add(this.fi);
        this.fj = new JMenuItem("Delete Item");
        this.fj.addActionListener(new bW(this, n, n2));
        jPopupMenu.add(this.fj);
        this.setComponentPopupMenu(jPopupMenu);
        this.setBorder(bO.eP);
        this.addMouseListener(new bX(this, n, n2));
        this.aq();
    }

    private boolean ao() {
        return bO.a(this.eX).h(this.x, this.y);
    }

    private boolean ap() {
        return bO.a(this.eX).l(this.x, this.y);
    }

    private void aq() {
        this.removeAll();
        this.eY.setEnabled(bO.a(this.eX).dp() || en.aS());
        this.eZ.setEnabled(bO.a(this.eX).dp() || en.aS());
        this.fa.setVisible(bO.a(this.eX).dq());
        this.fb.setVisible(bO.a(this.eX).dq());
        if (!bO.a(this.eX).h(this.x, this.y)) {
            this.eY.setSelected(false);
            this.fa.setEnabled(false);
            this.fe.setVisible(false);
            this.fg.setVisible(false);
            this.ff.setVisible(true);
            this.ff.setEnabled(false);
            this.fh.setVisible(false);
            this.fi.setVisible(false);
            this.fj.setVisible(false);
            this.fc.setVisible(false);
            this.setBorder(bO.eP);
            this.setBackground(bO.ag());
            this.setToolTipText(null);
        } else if (bO.a(this.eX).l(this.x, this.y)) {
            this.eY.setSelected(true);
            this.fa.setEnabled(true);
            this.fe.setVisible(false);
            this.fg.setVisible(false);
            this.ff.setVisible(true);
            this.ff.setEnabled(false);
            this.fh.setVisible(false);
            this.fi.setVisible(false);
            this.fj.setVisible(false);
            this.fc.setVisible(bO.a(this.eX).do());
            if (bO.a(this.eX).k(this.x, this.y)) {
                this.setBorder(bO.ah());
                this.fc.setState(true);
            } else {
                this.setBorder(bO.eP);
                this.fc.setState(false);
            }
            this.setBackground(bO.ai());
            gu gu2 = bO.a(this.eX).f(this.x, this.y);
            if (gu2 == null) {
                this.setToolTipText(null);
            } else {
                ey ey2 = ey.d(gu2.dz());
                boolean bl = ey2 instanceof eQ && gu2.dC() != 0.0;
                String string = ey2 == null ? bO.b(gu2.dz()) : ey2.getName();
                int n = UIManager.getInt("Inventory.iconSize");
                ImageIcon imageIcon = ey2 == null ? null : ey2.c(n, n);
                int n2 = 0;
                if (imageIcon != null) {
                    this.a(imageIcon, n, n2++);
                }
                Color color = bl ? bO.aj() : bO.eO;
                this.a(string, n2++, color);
                this.a(gu2.dA() < 0 ? "" : String.valueOf(gu2.dA()) + "/" + gu2.dB(), n2++, color);
                this.setToolTipText(string);
            }
        } else {
            this.eY.setSelected(true);
            this.fa.setEnabled(false);
            this.fc.setVisible(bO.a(this.eX).do());
            if (bO.a(this.eX).k(this.x, this.y)) {
                this.setBorder(bO.ah());
                this.fc.setState(true);
            } else {
                this.setBorder(bO.eP);
                this.fc.setState(false);
            }
            gu gu3 = bO.a(this.eX).f(this.x, this.y);
            if (gu3 == null) {
                this.fe.setVisible(false);
                this.fg.setVisible(false);
                this.ff.setVisible(true);
                this.ff.setEnabled(true);
                this.fh.setVisible(false);
                this.fi.setVisible(false);
                this.fj.setVisible(false);
                this.setBackground(bO.eK);
                this.setToolTipText(null);
            } else {
                ey ey3 = ey.d(gu3.dz());
                boolean bl = ey3 instanceof eQ && gu3.dC() != 0.0;
                this.fe.setVisible(true);
                this.fg.setVisible(bl);
                this.ff.setVisible(false);
                this.ff.setEnabled(false);
                this.fh.setVisible(true);
                this.fi.setVisible(false);
                this.fj.setVisible(true);
                String string = gu3.getType();
                if (string.equals("Technology")) {
                    this.setBackground(bO.ak());
                    if (gu3.dA() >= 0 && gu3.dA() < gu3.dB()) {
                        this.fi.setText("Recharge");
                        this.fi.setVisible(true);
                    }
                } else if (string.equals("Product")) {
                    this.setBackground(bO.al());
                    if (gu3.dB() > 1) {
                        this.fi.setText("Fill Stack");
                        this.fi.setVisible(true);
                    }
                } else if (string.equals("Substance")) {
                    this.setBackground(bO.am());
                    if (gu3.dB() > 1) {
                        this.fi.setText("Fill Stack");
                        this.fi.setVisible(true);
                    }
                } else {
                    this.setBackground(bO.an());
                }
                this.fe.setEnabled(ey3 != null);
                String string2 = ey3 == null ? bO.b(gu3.dz()) : ey3.getName();
                int n = UIManager.getInt("Inventory.iconSize");
                ImageIcon imageIcon = ey3 == null ? null : ey3.c(n, n);
                int n3 = 0;
                if (imageIcon != null) {
                    this.a(imageIcon, n, n3++);
                }
                Color color = bl ? bO.aj() : bO.eO;
                this.a(string2, n3++, color);
                this.a(gu3.dA() < 0 ? " " : String.valueOf(gu3.dA()) + "/" + gu3.dB(), n3++, color);
                this.setToolTipText(string2);
            }
        }
        this.revalidate();
        this.updateUI();
    }

    private void a(ImageIcon imageIcon, int n, int n2) {
        JLabel jLabel = new JLabel(imageIcon);
        jLabel.setPreferredSize(new Dimension(n, n));
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.anchor = 10;
        gridBagConstraints.fill = 0;
        gridBagConstraints.insets = new Insets(5, 0, 5, 0);
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = n2;
        this.add((Component)jLabel, gridBagConstraints);
    }

    private void a(String string, int n, Color color) {
        JLabel jLabel = new JLabel();
        jLabel.setFont(UIManager.getFont("Inventory.font"));
        jLabel.setBackground(null);
        jLabel.setBorder(null);
        jLabel.setText(string);
        jLabel.setForeground(color);
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.anchor = 10;
        gridBagConstraints.fill = 0;
        int n2 = UIManager.getInt("Inventory.iconSize");
        gridBagConstraints.insets = new Insets(n == 0 ? n2 + 10 : 0, 0, 0, 0);
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = n;
        this.add((Component)jLabel, gridBagConstraints);
    }

    static /* synthetic */ JCheckBoxMenuItem b(bS bS2) {
        return bS2.eY;
    }

    static /* synthetic */ void c(bS bS2) {
        bS2.aq();
    }

    static /* synthetic */ JCheckBoxMenuItem d(bS bS2) {
        return bS2.fc;
    }

    static /* synthetic */ boolean e(bS bS2) {
        return bS2.ao();
    }

    static /* synthetic */ boolean f(bS bS2) {
        return bS2.ap();
    }

    static /* synthetic */ JMenuItem g(bS bS2) {
        return bS2.eZ;
    }

    /* synthetic */ bS(bO bO2, int n, int n2, bS bS2) {
        this(bO2, n, n2);
    }

    static /* synthetic */ int h(bS bS2) {
        return bS2.x;
    }

    static /* synthetic */ int i(bS bS2) {
        return bS2.y;
    }

    static /* synthetic */ bO j(bS bS2) {
        return bS2.eX;
    }
}
