/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import nomanssave.ap;
import nomanssave.eS;
import nomanssave.eU;
import nomanssave.gA;

class az
implements ActionListener {
    final /* synthetic */ ap cu;

    az(ap ap2) {
        this.cu = ap2;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        for (eS eS2 : eS.by()) {
            gA gA2 = ap.i(this.cu).a(eS2);
            gA2.a(eU.kr, false);
            gA2.a(eU.ks, false);
            gA2.a(eU.kt, false);
            gA2.a(eU.kv, false);
            gA2.a(eU.kz, false);
        }
        ap.j(this.cu).updateUI();
    }
}
