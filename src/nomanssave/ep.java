/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import javax.swing.JComboBox;
import nomanssave.Application;
import nomanssave.bO;
import nomanssave.em;
import nomanssave.eq;
import nomanssave.gO;
import nomanssave.gt;

public class ep
extends em {
    private JComboBox iw = new JComboBox();
    private bO ix;
    private gO[] iy;

    ep(Application application) {
        this.iw.setModel(new eq(this));
        this.a("Vehicle", true, this.iw);
        this.ix = new bO(application);
        this.b(this.ix);
    }

    void w() {
        this.ix.w();
    }

    void x() {
        this.ix.x();
    }

    void y() {
        this.ix.y();
    }

    void A() {
        this.ix.A();
    }

    void a(gt gt2) {
        this.ix.a(gt2);
    }

    gO[] aT() {
        return this.iy;
    }

    void a(gO[] gOArray) {
        if (gOArray.length == 0) {
            this.iy = new gO[0];
            this.iw.setSelectedIndex(-1);
        } else {
            this.iy = gOArray;
            this.iw.setSelectedIndex(0);
        }
        this.iw.updateUI();
    }

    static /* synthetic */ gO[] a(ep ep2) {
        return ep2.iy;
    }

    static /* synthetic */ bO b(ep ep2) {
        return ep2.ix;
    }
}
