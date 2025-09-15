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

class ay
implements ActionListener {
    final /* synthetic */ ap cu;

    ay(ap ap2) {
        this.cu = ap2;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        for (eS eS2 : eS.by()) {
            gA gA2 = ap.i(this.cu).a(eS2);
            if (eS2.a(eU.kr)) {
                gA2.a(eU.kr, true);
            }
            if (eS2.a(eU.ks)) {
                gA2.a(eU.ks, true);
            }
            if (eS2.a(eU.kt)) {
                gA2.a(eU.kt, true);
            }
            if (eS2.a(eU.kv)) {
                gA2.a(eU.kv, true);
            }
            if (!eS2.a(eU.kz)) continue;
            gA2.a(eU.kz, true);
        }
        ap.j(this.cu).updateUI();
    }
}
