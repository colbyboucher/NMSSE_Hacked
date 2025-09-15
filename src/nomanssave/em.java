/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JComponent;
import javax.swing.JPanel;
import nomanssave.G;
import nomanssave.aH;
import nomanssave.ba;

public class em
extends JPanel {
    private final ba it;

    em() {
        GridBagLayout gridBagLayout = new GridBagLayout();
        int[] nArray = new int[3];
        nArray[0] = aH.cI;
        gridBagLayout.columnWidths = nArray;
        gridBagLayout.rowHeights = new int[1];
        gridBagLayout.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
        gridBagLayout.rowWeights = new double[]{1.0};
        this.setLayout(gridBagLayout);
        this.it = new ba();
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.insets = new Insets(0, 0, 0, 0);
        gridBagConstraints.fill = 1;
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        this.add((Component)this.it, gridBagConstraints);
    }

    void b(JComponent jComponent) {
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.fill = 1;
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        this.add((Component)jComponent, gridBagConstraints);
    }

    void k(String string) {
        this.it.k(string);
    }

    void a(String string, G g) {
        this.it.a(string, g);
    }

    void a(String string, JComponent jComponent) {
        this.it.a(string, jComponent);
    }

    void a(String string, boolean bl, JComponent jComponent) {
        this.it.a(string, bl, jComponent);
    }

    void a(JComponent jComponent) {
        this.it.a(jComponent);
    }

    void Y() {
        this.it.Y();
    }
}
