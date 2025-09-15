/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JPanel;
import nomanssave.Application;
import nomanssave.G;
import nomanssave.bO;
import nomanssave.cN;
import nomanssave.dk;
import nomanssave.dl;
import nomanssave.dm;
import nomanssave.dn;
import nomanssave.do;
import nomanssave.dp;
import nomanssave.dq;
import nomanssave.dr;
import nomanssave.ds;
import nomanssave.em;
import nomanssave.gB;
import nomanssave.gN;
import nomanssave.gt;
import nomanssave.gv;
import nomanssave.gx;

public class dj
extends em {
    private static final double gX = 1000.0;
    private static final double gY = 1000.0;
    private static final double gZ = 1000.0;
    private JComboBox ha = new JComboBox();
    private G hb;
    private cN hc;
    private cN hd;
    private G he;
    private G hf;
    private G hg;
    private G hh;
    private JButton bQ;
    private JButton bR;
    private JButton bS;
    private bO hi;
    private gv[] hj;

    dj(Application application) {
        this.ha.setModel(new dk(this));
        this.a("Multitool", true, this.ha);
        this.hb = new dl(this);
        this.a("Name", (JComponent)this.hb);
        this.hc = new cN(gx.class);
        this.hc.a((String string) -> {
            gv gv2 = (gv)this.ha.getSelectedItem();
            if (gv2 != null) {
                gv2.ag(string);
            }
        });
        this.a("Type", this.hc);
        this.hd = new cN(gN.class);
        this.hd.a((String string) -> {
            gv gv2 = (gv)this.ha.getSelectedItem();
            if (gv2 != null) {
                gv2.aj(string);
            }
        });
        this.a("Class", this.hd);
        this.he = new dm(this);
        this.a("Seed", this.he);
        this.k("Base Stats");
        this.hf = new dn(this);
        this.a("Damage", (JComponent)this.hf);
        this.hg = new do(this);
        this.a("Mining", (JComponent)this.hg);
        this.hh = new dp(this);
        this.a("Scan", (JComponent)this.hh);
        this.Y();
        JPanel jPanel = new JPanel();
        this.bQ = new JButton("Delete Multitool");
        this.bQ.addActionListener(new dq(this, application));
        jPanel.add(this.bQ);
        this.bR = new JButton("Export");
        this.bR.addActionListener(new dr(this, application));
        jPanel.add(this.bR);
        this.bS = new JButton("Import");
        this.bS.addActionListener(new ds(this, application));
        jPanel.add(this.bS);
        this.a(jPanel);
        this.hi = new bO(application);
        this.b(this.hi);
    }

    void w() {
        this.hi.w();
    }

    void x() {
        this.hi.x();
    }

    void y() {
        this.hi.y();
    }

    void z() {
        this.hi.z();
    }

    void A() {
        this.hi.A();
    }

    void a(gt gt2) {
        this.hi.a(gt2);
    }

    gv[] aK() {
        return this.hj;
    }

    void a(gv[] gvArray, gB gB2) {
        this.hj = gvArray;
        if (gvArray.length == 0) {
            this.ha.setSelectedIndex(-1);
        } else {
            int n;
            int n2 = n = gB2 == null ? 0 : gB2.dU();
            if (n >= gvArray.length) {
                n = 0;
            }
            this.ha.setSelectedIndex(n);
        }
        this.ha.updateUI();
    }

    static /* synthetic */ gv[] a(dj dj2) {
        return dj2.hj;
    }

    static /* synthetic */ G b(dj dj2) {
        return dj2.hb;
    }

    static /* synthetic */ cN c(dj dj2) {
        return dj2.hc;
    }

    static /* synthetic */ cN d(dj dj2) {
        return dj2.hd;
    }

    static /* synthetic */ G e(dj dj2) {
        return dj2.he;
    }

    static /* synthetic */ G f(dj dj2) {
        return dj2.hf;
    }

    static /* synthetic */ G g(dj dj2) {
        return dj2.hg;
    }

    static /* synthetic */ G h(dj dj2) {
        return dj2.hh;
    }

    static /* synthetic */ bO i(dj dj2) {
        return dj2.hi;
    }

    static /* synthetic */ JComboBox j(dj dj2) {
        return dj2.ha;
    }

    static /* synthetic */ void a(dj dj2, gv[] gvArray) {
        dj2.hj = gvArray;
    }
}
