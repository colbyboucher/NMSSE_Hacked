/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import java.util.Collections;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JTextField;
import nomanssave.Application;
import nomanssave.G;
import nomanssave.bO;
import nomanssave.be;
import nomanssave.bf;
import nomanssave.bg;
import nomanssave.bh;
import nomanssave.bi;
import nomanssave.bj;
import nomanssave.bk;
import nomanssave.cN;
import nomanssave.em;
import nomanssave.gN;
import nomanssave.gm;
import nomanssave.gn;
import nomanssave.go;
import nomanssave.gt;

public class bd
extends em {
    private static final double dE = 1000.0;
    private static final double dF = 1000.0;
    private G dG;
    private cN dH;
    private cN dI;
    private G dJ;
    private G dK;
    private G dL;
    private G dM;
    private JTextField bm;
    private JButton bn;
    private JButton bo;
    private bO dN;
    private gm dO;

    bd(Application application) {
        this.k("Freighter");
        this.dG = new be(this);
        this.a("Name", (JComponent)this.dG);
        this.dH = new cN(go.class);
        this.dH.a((String string) -> {
            if (this.dO != null) {
                this.dO.ag(string);
            }
        });
        this.a("Type", this.dH);
        this.dI = new cN(gN.class);
        this.dI.a((String string) -> {
            if (this.dO != null) {
                this.dO.aj(string);
            }
        });
        this.a("Class", this.dI);
        this.dJ = new bf(this);
        this.a("Home Seed", (JComponent)this.dJ);
        this.dK = new bg(this);
        this.a("Model Seed", this.dK);
        this.k("Base Stats");
        this.dL = new bh(this);
        this.a("Hyperdrive", (JComponent)this.dL);
        this.dM = new bi(this);
        this.a("Fleet Coordination", (JComponent)this.dM);
        this.Y();
        this.k("Base Info");
        this.bm = new JTextField();
        this.bm.setEnabled(false);
        this.a("Items", this.bm);
        JPanel jPanel = new JPanel();
        this.bn = new JButton("Backup");
        this.bn.addActionListener(new bj(this, application));
        jPanel.add(this.bn);
        this.bo = new JButton("Restore");
        this.bo.addActionListener(new bk(this, application));
        jPanel.add(this.bo);
        this.a(jPanel);
        this.dN = new bO(application);
        this.b(this.dN);
    }

    void w() {
        this.dN.w();
    }

    void x() {
        this.dN.x();
    }

    void y() {
        this.dN.y();
    }

    void A() {
        this.dN.A();
    }

    void a(gt gt2) {
        this.dN.a(gt2);
    }

    gm Z() {
        return this.dO;
    }

    void c(gm gm2) {
        if (gm2 == null) {
            this.dO = null;
            this.dG.setText("");
            this.dH.setSelectedIndex(-1);
            this.dH.updateUI();
            this.dI.setSelectedIndex(-1);
            this.dJ.setText("");
            this.dK.setText("");
            this.dL.setText("");
            this.dM.setText("");
            this.bm.setText("");
            this.bn.setEnabled(false);
            this.bo.setEnabled(false);
            this.dN.a(Collections.emptyList());
        } else {
            this.dO = gm2;
            this.dG.setText(gm2.getName());
            this.dH.m(gm2.cT());
            this.dI.m(gm2.cW());
            this.dJ.setText(gm2.cU());
            this.dK.setText(gm2.cV());
            this.dL.setText(Double.toString(gm2.cX()));
            this.dM.setText(Double.toString(gm2.cY()));
            gn gn2 = gm2.cZ();
            if (gn2 == null) {
                this.bm.setText("");
                this.bn.setEnabled(false);
                this.bo.setEnabled(false);
            } else {
                this.bm.setText(Integer.toString(gn2.cG()));
                this.bn.setEnabled(true);
                this.bo.setEnabled(true);
            }
            this.dN.a(gm2.cC());
        }
    }

    static /* synthetic */ gm a(bd bd2) {
        return bd2.dO;
    }

    static /* synthetic */ G b(bd bd2) {
        return bd2.dG;
    }

    static /* synthetic */ G c(bd bd2) {
        return bd2.dJ;
    }
}
