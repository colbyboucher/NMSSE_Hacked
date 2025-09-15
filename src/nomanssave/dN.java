/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import nomanssave.Application;
import nomanssave.G;
import nomanssave.bO;
import nomanssave.cN;
import nomanssave.dO;
import nomanssave.dP;
import nomanssave.dQ;
import nomanssave.dR;
import nomanssave.dS;
import nomanssave.dT;
import nomanssave.dU;
import nomanssave.dV;
import nomanssave.dW;
import nomanssave.dX;
import nomanssave.dY;
import nomanssave.dZ;
import nomanssave.ea;
import nomanssave.em;
import nomanssave.gC;
import nomanssave.gH;
import nomanssave.gL;
import nomanssave.gN;
import nomanssave.gt;
import nomanssave.hc;

public class dN
extends em {
    private static final int cV = 500;
    private static final int cW = 200;
    private static final double gX = 1000.0;
    private static final double hI = 1000.0;
    private static final double dE = 1000.0;
    private static final double hJ = 1000.0;
    private JComboBox hK = new JComboBox();
    private G hL;
    private cN hM;
    private cN hN;
    private G hO;
    private JCheckBox hP;
    private JButton bQ;
    private JButton bR;
    private JButton bS;
    private G hQ;
    private G hR;
    private G hS;
    private G hT;
    private G hU;
    private G hV;
    private bO hW;
    private gH[] hX;
    private gC hY;

    dN(Application application) {
        this.hK.setModel(new dO(this, application));
        this.a("Ship", true, this.hK);
        this.hL = new dT(this);
        this.a("Name", (JComponent)this.hL);
        this.hM = new cN(gL.class);
        this.hM.a((String string) -> {
            gH gH2 = (gH)this.hK.getModel().getSelectedItem();
            if (gH2 != null) {
                gL gL2 = gL.aw(string);
                int n = JOptionPane.showConfirmDialog(application.g(), "You are about to change a ship type to " + (gL2 == null ? "Unknown" : gL2.toString()) + ". Are you sure?\nNOTE: Any incompatible technology installed on the ship will be deleted.", "Change Ship Type", 0);
                if (n != 0) {
                    this.hM.m(gH2.cT());
                    return;
                }
                gH2.ag(string);
                this.hW.a(gH2.cC());
                this.hK.updateUI();
            }
        });
        this.a("Type", this.hM);
        this.hN = new cN(gN.class);
        this.hN.a((String string) -> {
            gH gH2 = (gH)this.hK.getModel().getSelectedItem();
            if (gH2 != null) {
                gH2.aj(string);
            }
        });
        this.a("Class", this.hN);
        this.hO = new dU(this);
        this.a("Seed", this.hO);
        this.hP = new JCheckBox("Use Old Colours");
        this.hP.setEnabled(false);
        this.hP.addActionListener(new dV(this, application));
        this.a(null, this.hP);
        this.k("Base Stats");
        this.hQ = new dW(this);
        this.a("Health", (JComponent)this.hQ);
        this.hR = new dX(this);
        this.a("Shield", (JComponent)this.hR);
        this.hS = new dY(this);
        this.a("Damage", (JComponent)this.hS);
        this.hT = new dZ(this);
        this.a("Shields", (JComponent)this.hT);
        this.hU = new ea(this);
        this.a("Hyperdrive", (JComponent)this.hU);
        this.hV = new dP(this);
        this.a("Maneuverability", (JComponent)this.hV);
        this.Y();
        JPanel jPanel = new JPanel();
        this.bQ = new JButton("Delete Ship");
        this.bQ.addActionListener(new dQ(this, application));
        jPanel.add(this.bQ);
        this.bR = new JButton("Export");
        this.bR.addActionListener(new dR(this, application));
        jPanel.add(this.bR);
        this.bS = new JButton("Import");
        this.bS.addActionListener(new dS(this, application));
        jPanel.add(this.bS);
        this.a(jPanel);
        this.hW = new bO(application);
        this.b(this.hW);
    }

    void w() {
        int n = 0;
        while (n < this.hX.length) {
            this.hX[n].cC().stream().forEach(gt2 -> {
                if (gt2.dt()) {
                    hc.info(gt2 + ": technology recharged");
                }
                this.hW.a((gt)gt2);
            });
            ++n;
        }
    }

    void x() {
        int n = 0;
        while (n < this.hX.length) {
            this.hX[n].cC().stream().forEach(gt2 -> {
                if (gt2.du()) {
                    hc.info(gt2 + ": items refilled");
                }
                this.hW.a((gt)gt2);
            });
            ++n;
        }
    }

    void y() {
        int n = 0;
        while (n < this.hX.length) {
            this.hX[n].cC().stream().forEach(gt2 -> {
                if (gt2.dv()) {
                    hc.info(gt2 + ": all slots enabled");
                }
                this.hW.a((gt)gt2);
            });
            ++n;
        }
    }

    void z() {
        int n = 0;
        while (n < this.hX.length) {
            this.hX[n].cC().stream().forEach(gt2 -> {
                if (gt2.ds()) {
                    hc.info(gt2 + ": all slots repaired");
                }
                this.hW.a((gt)gt2);
            });
            ++n;
        }
    }

    void A() {
        int n = 0;
        while (n < this.hX.length) {
            this.hX[n].cC().stream().forEach(gt2 -> {
                if (gt2.dl()) {
                    hc.info(gt2 + ": inventory expanded");
                }
                this.hW.a((gt)gt2);
            });
            ++n;
        }
    }

    void a(gt gt2) {
        this.hW.a(gt2);
    }

    gH[] aO() {
        return this.hX;
    }

    void a(gH[] gHArray, gC gC2) {
        this.hX = gHArray;
        this.hY = gC2;
        if (gHArray.length == 0) {
            this.hK.setSelectedIndex(-1);
        } else {
            int n;
            int n2 = n = gC2 == null ? 0 : gC2.dV();
            if (n >= gHArray.length) {
                n = 0;
            }
            this.hK.setSelectedIndex(n);
        }
        if (gC2 == null) {
            this.hQ.setText("");
            this.hR.setText("");
        } else {
            this.hQ.setText(Long.toString(gC2.dM()));
            this.hR.setText(Long.toString(gC2.dN()));
        }
        this.hK.updateUI();
    }

    static /* synthetic */ gH[] a(dN dN2) {
        return dN2.hX;
    }

    static /* synthetic */ G b(dN dN2) {
        return dN2.hL;
    }

    static /* synthetic */ cN c(dN dN2) {
        return dN2.hM;
    }

    static /* synthetic */ cN d(dN dN2) {
        return dN2.hN;
    }

    static /* synthetic */ G e(dN dN2) {
        return dN2.hO;
    }

    static /* synthetic */ JCheckBox f(dN dN2) {
        return dN2.hP;
    }

    static /* synthetic */ JButton g(dN dN2) {
        return dN2.bQ;
    }

    static /* synthetic */ G h(dN dN2) {
        return dN2.hS;
    }

    static /* synthetic */ G i(dN dN2) {
        return dN2.hT;
    }

    static /* synthetic */ G j(dN dN2) {
        return dN2.hU;
    }

    static /* synthetic */ G k(dN dN2) {
        return dN2.hV;
    }

    static /* synthetic */ bO l(dN dN2) {
        return dN2.hW;
    }

    static /* synthetic */ G m(dN dN2) {
        return dN2.hQ;
    }

    static /* synthetic */ G n(dN dN2) {
        return dN2.hR;
    }

    static /* synthetic */ gC o(dN dN2) {
        return dN2.hY;
    }

    static /* synthetic */ JComboBox p(dN dN2) {
        return dN2.hK;
    }

    static /* synthetic */ void a(dN dN2, gH[] gHArray) {
        dN2.hX = gHArray;
    }
}
