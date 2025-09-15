/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import nomanssave.Application;
import nomanssave.aH;
import nomanssave.ec;
import nomanssave.em;
import nomanssave.gM;
import nomanssave.gy;

public class eb
extends em {
    private ec[] ib;
    private gM[] ic;
    private static final gy[] ie = new gy[]{gy.qR, gy.qS, gy.qT};

    eb(Application application) {
        GridBagLayout gridBagLayout = new GridBagLayout();
        int[] nArray = new int[5];
        nArray[0] = aH.cI;
        nArray[1] = aH.cI;
        nArray[2] = aH.cI;
        nArray[3] = aH.cI;
        gridBagLayout.columnWidths = nArray;
        gridBagLayout.rowHeights = new int[3];
        gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        gridBagLayout.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
        this.setLayout(gridBagLayout);
        this.ic = new gM[0];
        this.ib = new ec[0];
    }

    void a(gM[] gMArray) {
        this.ic = gMArray;
        int n = gMArray.length;
        while (n < this.ib.length) {
            this.remove(this.ib[n]);
            ++n;
        }
        n = gMArray.length <= 4 ? 2 : (gMArray.length <= 6 ? 3 : 4);
        ec[] ecArray = new ec[gMArray.length];
        System.arraycopy(this.ib, 0, ecArray, 0, Math.min(gMArray.length, this.ib.length));
        int n2 = this.ib.length;
        while (n2 < gMArray.length) {
            ecArray[n2] = new ec(this, n2);
            GridBagConstraints gridBagConstraints = new GridBagConstraints();
            gridBagConstraints.insets = new Insets(10, 10, 0, 0);
            gridBagConstraints.fill = 2;
            gridBagConstraints.anchor = 11;
            gridBagConstraints.gridx = n2 % n;
            gridBagConstraints.gridy = n2 / n;
            this.add((Component)ecArray[n2], gridBagConstraints);
            ++n2;
        }
        this.ib = ecArray;
        n2 = 0;
        while (n2 < gMArray.length) {
            ec.g(this.ib[n2]);
            ++n2;
        }
        this.updateUI();
    }

    static /* synthetic */ gM[] a(eb eb2) {
        return eb2.ic;
    }

    static /* synthetic */ gy[] aP() {
        return ie;
    }
}
