/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import java.util.Collections;
import javax.swing.JComponent;
import nomanssave.Application;
import nomanssave.G;
import nomanssave.aK;
import nomanssave.aL;
import nomanssave.aM;
import nomanssave.aN;
import nomanssave.aO;
import nomanssave.aP;
import nomanssave.bO;
import nomanssave.em;
import nomanssave.gt;
import nomanssave.gz;

public class aJ
extends em {
    private static final int cV = 200;
    private static final int cW = 100;
    private static final int cX = 100;
    private static final long cY = 0xFFFFFFFFL;
    private static final long cZ = 0xFFFFFFFFL;
    private static final long da = 0xFFFFFFFFL;
    private G db;
    private G dc;
    private G dd;
    private G de;
    private G df;
    private G dg;
    private bO dh;
    private gz di;

    aJ(Application application) {
        this.k("Main Stats");
        this.de = new aK(this);
        this.a("Health", (JComponent)this.de);
        this.df = new aL(this);
        this.a("Shield", (JComponent)this.df);
        this.dg = new aM(this);
        this.a("Energy", (JComponent)this.dg);
        this.db = new aN(this, application);
        this.a("Units", (JComponent)this.db);
        this.dc = new aO(this);
        this.a("Nanites", (JComponent)this.dc);
        this.dd = new aP(this);
        this.a("Quicksilver", (JComponent)this.dd);
        this.dh = new bO(application);
        this.b(this.dh);
    }

    void w() {
        this.dh.w();
    }

    void x() {
        this.dh.x();
    }

    void y() {
        this.dh.y();
    }

    void A() {
        this.dh.A();
    }

    void a(gt gt2) {
        this.dh.a(gt2);
    }

    gz X() {
        return this.di;
    }

    void a(gz gz2) {
        if (gz2 == null) {
            this.di = null;
            this.db.setText("");
            this.dc.setText("");
            this.dd.setText("");
            this.de.setText("");
            this.df.setText("");
            this.dg.setText("");
            this.dh.a(Collections.emptyList());
        } else {
            this.di = gz2;
            this.db.setText(Long.toString(gz2.dJ()));
            this.dc.setText(Long.toString(gz2.dK()));
            this.dd.setText(Long.toString(gz2.dL()));
            this.de.setText(Integer.toString(gz2.dM()));
            this.df.setText(Integer.toString(gz2.dN()));
            this.dg.setText(Integer.toString(gz2.dO()));
            this.dh.a(gz2.cC());
        }
    }

    static /* synthetic */ gz a(aJ aJ2) {
        return aJ2.di;
    }
}
