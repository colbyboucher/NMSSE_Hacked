/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JPanel;
import nomanssave.Application;
import nomanssave.G;
import nomanssave.Y;
import nomanssave.Z;
import nomanssave.aH;
import nomanssave.aa;
import nomanssave.ab;
import nomanssave.ac;
import nomanssave.ad;
import nomanssave.ae;
import nomanssave.af;
import nomanssave.ag;
import nomanssave.ah;
import nomanssave.ai;
import nomanssave.ba;
import nomanssave.cN;
import nomanssave.gi;
import nomanssave.gj;
import nomanssave.gk;

public class X
extends JPanel {
    private JComboBox bG;
    private JComboBox bH;
    private G bI;
    private G bJ;
    private G bK;
    private G bL;
    private G bM;
    private JCheckBox bN;
    private cN bO;
    private cN bP;
    private JButton bQ;
    private JButton bR;
    private JButton bS;
    private gj[] bT;

    X(Application application) {
        GridLayout gridLayout = new GridLayout(1, 3);
        this.setLayout(gridLayout);
        ba ba2 = new ba(aH.cJ, 0);
        this.add(ba2);
        this.add(new JPanel());
        this.add(new JPanel());
        this.bG = new JComboBox();
        this.bG.setModel(new Y(this));
        ba2.a("Companion", true, this.bG);
        this.bH = new JComboBox();
        this.bH.setModel(new ab(this));
        this.bH.setEnabled(false);
        ba2.a("Type", this.bH);
        this.bI = new ac(this);
        ba2.a("Name", (JComponent)this.bI);
        this.bJ = new ad(this);
        ba2.a("Creature Seed", this.bJ);
        this.bK = new ae(this);
        ba2.a("Secondary Seed", (JComponent)this.bK);
        this.bL = new af(this);
        ba2.a("Species Seed", (JComponent)this.bL);
        this.bM = new ag(this);
        ba2.a("Genus Seed", (JComponent)this.bM);
        this.bN = new JCheckBox("Predator");
        this.bN.setEnabled(false);
        this.bN.addActionListener(new ah(this));
        ba2.a(null, this.bN);
        this.bO = new cN(gi.class);
        this.bO.a(string -> {
            gj gj2 = (gj)this.bG.getSelectedItem();
            if (gj2 != null) {
                gj2.ae(string);
            }
        });
        ba2.a("Biome", this.bO);
        this.bP = new cN(gk.class);
        this.bP.a(string -> {
            gj gj2 = (gj)this.bG.getSelectedItem();
            if (gj2 != null) {
                gj2.af(string);
            }
        });
        ba2.a("Type", this.bP);
        ba2.Y();
        JPanel jPanel = new JPanel();
        this.bQ = new JButton("Delete");
        this.bQ.addActionListener(new ai(this, application));
        jPanel.add(this.bQ);
        this.bR = new JButton("Export");
        this.bR.addActionListener(new Z(this, application));
        jPanel.add(this.bR);
        this.bS = new JButton("Import");
        this.bS.addActionListener(new aa(this, application));
        jPanel.add(this.bS);
        ba2.a(jPanel);
    }

    void a(gj[] gjArray) {
        this.bT = gjArray;
        if (gjArray.length == 0) {
            this.bG.setSelectedIndex(-1);
        } else {
            this.bG.setSelectedIndex(0);
        }
        this.bG.updateUI();
    }

    static /* synthetic */ gj[] a(X x) {
        return x.bT;
    }

    static /* synthetic */ JComboBox b(X x) {
        return x.bH;
    }

    static /* synthetic */ G c(X x) {
        return x.bI;
    }

    static /* synthetic */ G d(X x) {
        return x.bJ;
    }

    static /* synthetic */ G e(X x) {
        return x.bK;
    }

    static /* synthetic */ G f(X x) {
        return x.bL;
    }

    static /* synthetic */ G g(X x) {
        return x.bM;
    }

    static /* synthetic */ JCheckBox h(X x) {
        return x.bN;
    }

    static /* synthetic */ cN i(X x) {
        return x.bO;
    }

    static /* synthetic */ cN j(X x) {
        return x.bP;
    }

    static /* synthetic */ JComboBox k(X x) {
        return x.bG;
    }

    static /* synthetic */ void a(X x, gj[] gjArray) {
        x.bT = gjArray;
    }
}
