/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.stream.Stream;
import nomanssave.aD;
import nomanssave.aH;
import nomanssave.aI;

class aF
implements ActionListener {
    final /* synthetic */ aD cB;

    aF(aD aD2) {
        this.cB = aD2;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        double d;
        String string = aH.getProperty("LookAndFeel");
        aI aI3 = Stream.of(aI.values()).filter(aI2 -> aI2.name().equalsIgnoreCase(string)).findFirst().orElse(aI.cN);
        aI aI4 = (aI)((Object)aD.a(this.cB).getSelectedItem());
        aD.a(this.cB, false);
        if (aI4 == null) {
            if (aI3 != null) {
                aH.setProperty("LookAndFeel", null);
                aD.a(this.cB, true);
            }
        } else if (aI3 == null || aI3 != aI4) {
            aH.setProperty("LookAndFeel", aI4.name());
            aD.a(this.cB, true);
        }
        if ((d = Double.parseDouble(aD.b(this.cB).getText())) != aH.a("InventoryScaling", 1.0)) {
            aH.b("InventoryScaling", d);
            aD.a(this.cB, true);
        }
        this.cB.setVisible(false);
    }
}
