/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import nomanssave.Application;
import nomanssave.G;
import nomanssave.aH;
import nomanssave.bA;
import nomanssave.bB;
import nomanssave.bC;
import nomanssave.bD;
import nomanssave.ba;
import nomanssave.bm;
import nomanssave.bn;
import nomanssave.bo;
import nomanssave.bp;
import nomanssave.bq;
import nomanssave.br;
import nomanssave.bs;
import nomanssave.bt;
import nomanssave.bv;
import nomanssave.bw;
import nomanssave.bx;
import nomanssave.by;
import nomanssave.bz;
import nomanssave.cN;
import nomanssave.en;
import nomanssave.eo;
import nomanssave.er;
import nomanssave.gd;
import nomanssave.gp;
import nomanssave.gq;

public class bl
extends JPanel
implements eo {
    private static final int dQ = 50;
    private JTable dR;
    private JButton bQ;
    private JButton dS;
    private ba dT;
    private G dU;
    private JComboBox dV;
    private JTextField dW;
    private cN dX;
    private G dY;
    private G dZ;
    private G[] ea;
    private ba eb;
    private JComboBox ec;
    private JComboBox ed;
    private JComboBox ee;
    private JComboBox ef;
    private JComboBox eg;
    private G eh;
    private G ei;
    private G ej;
    private G ek;
    private JLabel el;
    private JButton em;
    private er[] en;
    private er[] eo;
    private gp[] ep;
    private int eq;

    bl(Application application) {
        GridLayout gridLayout = new GridLayout(1, 3);
        this.setLayout(gridLayout);
        JScrollPane jScrollPane = new JScrollPane();
        jScrollPane.setMinimumSize(new Dimension(300, 0));
        jScrollPane.setMaximumSize(new Dimension(300, Integer.MAX_VALUE));
        jScrollPane.setPreferredSize(new Dimension(300, 0));
        JPanel jPanel = new JPanel();
        jPanel.setLayout(new BorderLayout());
        jPanel.add((Component)jScrollPane, "Center");
        JPanel jPanel2 = new JPanel();
        this.bQ = new JButton("Delete");
        this.bQ.setEnabled(false);
        this.bQ.addActionListener(new bm(this, application));
        jPanel2.add(this.bQ);
        this.dS = new JButton("Copy");
        this.dS.setEnabled(false);
        this.dS.addActionListener(new br(this, application));
        jPanel2.add(this.dS);
        jPanel.add((Component)jPanel2, "South");
        this.add(jPanel);
        this.dR = new JTable();
        this.dR.setSelectionMode(0);
        this.dR.setModel(new bs(this));
        this.dR.getColumnModel().getColumn(2).setMaxWidth(60);
        this.dR.getSelectionModel().addListSelectionListener(new bt(this, application));
        jScrollPane.setViewportView(this.dR);
        this.dT = new ba(aH.cJ, 0);
        this.dT.setVisible(false);
        this.add(this.dT);
        this.dT.k("Frigate Info");
        this.dU = new bv(this);
        this.dT.a("Name", (JComponent)this.dU);
        this.dV = new JComboBox();
        this.dV.setModel(new bw(this));
        this.dT.a("Type", this.dV);
        this.dW = new JTextField();
        this.dW.setEditable(false);
        this.dT.a("Class", this.dW);
        this.dX = new cN(gd.class);
        this.dX.a(string -> {
            if (this.eq >= 0) {
                this.ep[this.eq].am(string);
            }
        });
        this.dT.a("NPC Race", this.dX);
        this.dY = new bx(this);
        this.dT.a("Home Seed", (JComponent)this.dY);
        this.dZ = new by(this);
        this.dT.a("Model Seed", this.dZ);
        this.dT.k("Traits");
        bD bD2 = new bD(this, null);
        this.ec = new JComboBox();
        this.ec.setModel(new bB(this, null));
        this.ec.setRenderer(bD2);
        this.dT.a(this.ec);
        this.ed = new JComboBox();
        this.ed.setModel(new bC(this, 1));
        this.ed.setRenderer(bD2);
        this.dT.a(this.ed);
        this.ee = new JComboBox();
        this.ee.setModel(new bC(this, 2));
        this.ee.setRenderer(bD2);
        this.dT.a(this.ee);
        this.ef = new JComboBox();
        this.ef.setModel(new bC(this, 3));
        this.ef.setRenderer(bD2);
        this.dT.a(this.ef);
        this.eg = new JComboBox();
        this.eg.setModel(new bC(this, 4));
        this.eg.setRenderer(bD2);
        this.dT.a(this.eg);
        this.dT.Y();
        JPanel jPanel3 = new JPanel();
        jPanel3.setLayout(new FormLayout(new ColumnSpec[]{FormFactory.GLUE_COLSPEC, FormFactory.DEFAULT_COLSPEC, FormFactory.GLUE_COLSPEC}, new RowSpec[]{FormFactory.DEFAULT_ROWSPEC, FormFactory.DEFAULT_ROWSPEC}));
        this.el = new JLabel("");
        jPanel3.add((Component)this.el, "2,1");
        this.em = new JButton("Repair");
        this.em.addActionListener(new bz(this));
        JPanel jPanel4 = new JPanel();
        jPanel4.add(this.em);
        jPanel3.add((Component)jPanel4, "2,2");
        this.dT.a(jPanel3);
        this.eb = new ba(aH.cJ, 0);
        this.eb.setVisible(false);
        this.add(this.eb);
        this.eb.k("Stats");
        this.ea = new G[gq.values().length];
        int n = 0;
        while (n < this.ea.length) {
            this.ea[n] = new bA(this, n, null);
            this.eb.a(gq.values()[n].toString(), (JComponent)this.ea[n]);
            ++n;
        }
        this.eb.Y();
        this.eb.k("Totals");
        this.eh = new bn(this);
        this.eb.a("Expeditions", (JComponent)this.eh);
        this.ei = new bo(this);
        this.eb.a("Successful", (JComponent)this.ei);
        this.ej = new bp(this);
        this.eb.a("Failed", (JComponent)this.ej);
        this.ek = new bq(this);
        this.eb.a("Damaged", (JComponent)this.ek);
        nomanssave.en.a(this);
    }

    @Override
    public void a(boolean bl2) {
        if (this.dR.getSelectedRow() >= 0) {
            this.dS.setEnabled(this.ep.length < 30 || nomanssave.en.aS());
        }
    }

    void a(gp[] gpArray) {
        this.ep = gpArray;
        this.en = null;
        this.eo = null;
        this.dR.clearSelection();
        if (gpArray.length > 0) {
            this.dR.setRowSelectionInterval(0, 0);
        }
        this.dR.updateUI();
    }

    static /* synthetic */ er[] a(bl bl2) {
        return bl2.en;
    }

    static /* synthetic */ int b(bl bl2) {
        return bl2.eq;
    }

    static /* synthetic */ gp[] c(bl bl2) {
        return bl2.ep;
    }

    static /* synthetic */ G[] d(bl bl2) {
        return bl2.ea;
    }

    static /* synthetic */ JTable e(bl bl2) {
        return bl2.dR;
    }

    static /* synthetic */ er[] f(bl bl2) {
        return bl2.eo;
    }

    static /* synthetic */ void a(bl bl2, gp[] gpArray) {
        bl2.ep = gpArray;
    }

    static /* synthetic */ JButton g(bl bl2) {
        return bl2.dS;
    }

    static /* synthetic */ void a(bl bl2, int n) {
        bl2.eq = n;
    }

    static /* synthetic */ void a(bl bl2, er[] erArray) {
        bl2.en = erArray;
    }

    static /* synthetic */ void b(bl bl2, er[] erArray) {
        bl2.eo = erArray;
    }

    static /* synthetic */ ba h(bl bl2) {
        return bl2.dT;
    }

    static /* synthetic */ ba i(bl bl2) {
        return bl2.eb;
    }

    static /* synthetic */ G j(bl bl2) {
        return bl2.dU;
    }

    static /* synthetic */ JComboBox k(bl bl2) {
        return bl2.dV;
    }

    static /* synthetic */ JTextField l(bl bl2) {
        return bl2.dW;
    }

    static /* synthetic */ cN m(bl bl2) {
        return bl2.dX;
    }

    static /* synthetic */ G n(bl bl2) {
        return bl2.dY;
    }

    static /* synthetic */ G o(bl bl2) {
        return bl2.dZ;
    }

    static /* synthetic */ JComboBox p(bl bl2) {
        return bl2.ec;
    }

    static /* synthetic */ JComboBox q(bl bl2) {
        return bl2.ed;
    }

    static /* synthetic */ JComboBox r(bl bl2) {
        return bl2.ee;
    }

    static /* synthetic */ JComboBox s(bl bl2) {
        return bl2.ef;
    }

    static /* synthetic */ JComboBox t(bl bl2) {
        return bl2.eg;
    }

    static /* synthetic */ G u(bl bl2) {
        return bl2.eh;
    }

    static /* synthetic */ G v(bl bl2) {
        return bl2.ei;
    }

    static /* synthetic */ G w(bl bl2) {
        return bl2.ej;
    }

    static /* synthetic */ G x(bl bl2) {
        return bl2.ek;
    }

    static /* synthetic */ JLabel y(bl bl2) {
        return bl2.el;
    }

    static /* synthetic */ JButton z(bl bl2) {
        return bl2.em;
    }

    static /* synthetic */ JButton A(bl bl2) {
        return bl2.bQ;
    }
}
