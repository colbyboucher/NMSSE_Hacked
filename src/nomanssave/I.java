/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import java.util.Collections;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JTextField;
import nomanssave.Application;
import nomanssave.G;
import nomanssave.J;
import nomanssave.K;
import nomanssave.L;
import nomanssave.M;
import nomanssave.N;
import nomanssave.O;
import nomanssave.P;
import nomanssave.bO;
import nomanssave.em;
import nomanssave.ge;
import nomanssave.gt;

public class I
extends em {
    private JComboBox bh = new JComboBox();
    private JTextField bi;
    private G bj;
    private JComboBox bk;
    private G bl;
    private JTextField bm;
    private JButton bn;
    private JButton bo;
    private JButton bp;
    private bO bq;
    private ge br;

    I(Application application) {
        this.bh.setModel(new J(this));
        this.a("Base NPC", true, this.bh);
        this.bi = new JTextField();
        this.bi.setEnabled(false);
        this.a("Race", this.bi);
        this.bj = new K(this);
        this.bj.setEnabled(false);
        this.a("Seed", this.bj);
        this.Y();
        this.bk = new JComboBox();
        this.bk.setModel(new L(this));
        this.a("Base Info", true, this.bk);
        this.bl = new M(this);
        this.a("Name", (JComponent)this.bl);
        this.bm = new JTextField();
        this.bm.setEnabled(false);
        this.a("Items", this.bm);
        JPanel jPanel = new JPanel();
        this.bn = new JButton("Backup");
        this.bn.addActionListener(new N(this, application));
        jPanel.add(this.bn);
        this.bo = new JButton("Restore");
        this.bo.addActionListener(new O(this, application));
        jPanel.add(this.bo);
        this.bp = new JButton("Move Base Computer");
        this.bp.addActionListener(new P(this, application));
        jPanel.add(this.bp);
        this.a(jPanel);
        this.bq = new bO(application);
        this.b(this.bq);
    }

    void w() {
        this.bq.w();
    }

    void x() {
        this.bq.x();
    }

    void y() {
        this.bq.y();
    }

    void A() {
        this.bq.A();
    }

    void a(gt gt2) {
        this.bq.a(gt2);
    }

    ge O() {
        return this.br;
    }

    void a(ge ge2) {
        List list;
        this.br = ge2;
        if (ge2 == null) {
            list = Collections.emptyList();
            this.bh.setSelectedIndex(-1);
            this.bk.setSelectedIndex(-1);
        } else {
            list = ge2.cC();
            this.bh.setSelectedIndex(ge2.cD().size() == 0 ? -1 : 0);
            this.bk.setSelectedIndex(ge2.cE().size() == 0 ? -1 : 0);
        }
        this.bh.updateUI();
        this.bk.updateUI();
        this.bq.a(list);
    }

    static /* synthetic */ ge a(I i) {
        return i.br;
    }

    static /* synthetic */ JTextField b(I i) {
        return i.bi;
    }

    static /* synthetic */ G c(I i) {
        return i.bj;
    }

    static /* synthetic */ JComboBox d(I i) {
        return i.bh;
    }

    static /* synthetic */ JTextField e(I i) {
        return i.bm;
    }

    static /* synthetic */ G f(I i) {
        return i.bl;
    }

    static /* synthetic */ JButton g(I i) {
        return i.bn;
    }

    static /* synthetic */ JButton h(I i) {
        return i.bo;
    }

    static /* synthetic */ JButton i(I i) {
        return i.bp;
    }

    static /* synthetic */ JComboBox j(I i) {
        return i.bk;
    }
}
