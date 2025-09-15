/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import nomanssave.Application;
import nomanssave.G;
import nomanssave.aH;
import nomanssave.ba;
import nomanssave.dF;
import nomanssave.dG;
import nomanssave.dH;
import nomanssave.dI;
import nomanssave.dJ;
import nomanssave.dM;
import nomanssave.dt;
import nomanssave.gE;
import nomanssave.gG;

public class dE
extends JPanel {
    private ba hv;
    private ba hw;
    private JComboBox hx;
    private G hy;
    private G hz;
    private G[] ea;
    private JTable hA;
    private dt hB;
    private gE[] hC;

    dE(Application application) {
        GridBagLayout gridBagLayout = new GridBagLayout();
        int[] nArray = new int[3];
        nArray[0] = aH.cI;
        gridBagLayout.columnWidths = nArray;
        gridBagLayout.rowHeights = new int[1];
        gridBagLayout.columnWeights = new double[]{0.0, 0.0, 1.0};
        gridBagLayout.rowWeights = new double[]{1.0};
        this.setLayout(gridBagLayout);
        this.hv = new ba();
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.insets = new Insets(0, 0, 0, 0);
        gridBagConstraints.fill = 1;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        this.add((Component)this.hv, gridBagConstraints);
        this.hx = new JComboBox();
        this.hx.setModel(new dF(this));
        this.hv.a("Settlement", true, this.hx);
        this.hy = new dG(this);
        this.hv.a("Name", (JComponent)this.hy);
        this.hz = new dH(this);
        this.hv.a("Seed", this.hz);
        this.hv.Y();
        this.hv.k("Stats");
        this.ea = new G[gG.values().length];
        int n = 0;
        while (n < this.ea.length) {
            this.ea[n] = new dM(this, gG.values()[n], null);
            this.hv.a(gG.values()[n].toString(), (JComponent)this.ea[n]);
            ++n;
        }
        this.hw = new ba();
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.insets = new Insets(0, 0, 0, 0);
        gridBagConstraints.fill = 1;
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        this.add((Component)this.hw, gridBagConstraints);
        this.hw.k("Perks");
        JScrollPane jScrollPane = new JScrollPane();
        this.hw.a(jScrollPane);
        this.hA = new JTable();
        this.hA.setCellSelectionEnabled(false);
        this.hA.setModel(new dI(this));
        this.hA.getColumnModel().getColumn(1).setCellEditor(new DefaultCellEditor(new dJ(this)));
        jScrollPane.setViewportView(this.hA);
        this.hB = new dt(application);
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.insets = new Insets(0, 0, 0, 0);
        gridBagConstraints.fill = 1;
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        this.add((Component)this.hB, gridBagConstraints);
    }

    gE[] aN() {
        return this.hC;
    }

    void a(gE[] gEArray) {
        if (gEArray.length == 0) {
            this.hC = new gE[0];
            this.hx.setSelectedIndex(-1);
        } else {
            this.hC = gEArray;
            this.hx.setSelectedIndex(0);
        }
        this.hx.updateUI();
    }

    static /* synthetic */ JComboBox a(dE dE2) {
        return dE2.hx;
    }

    static /* synthetic */ gE[] b(dE dE2) {
        return dE2.hC;
    }

    static /* synthetic */ G c(dE dE2) {
        return dE2.hy;
    }

    static /* synthetic */ G d(dE dE2) {
        return dE2.hz;
    }

    static /* synthetic */ G[] e(dE dE2) {
        return dE2.ea;
    }

    static /* synthetic */ dt f(dE dE2) {
        return dE2.hB;
    }

    static /* synthetic */ JTable g(dE dE2) {
        return dE2.hA;
    }
}
