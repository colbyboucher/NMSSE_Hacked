/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import java.awt.Color;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.border.LineBorder;
import nomanssave.G;
import nomanssave.aH;
import nomanssave.ba;
import nomanssave.eb;
import nomanssave.ed;
import nomanssave.ee;
import nomanssave.ef;
import nomanssave.eg;
import nomanssave.eh;
import nomanssave.ei;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
class ec
extends ba {
    private final int index;
    private JCheckBox if;
    private JComboBox ig;
    private G bj;
    private JComboBox ih;
    private G hO;
    private G ii;
    final /* synthetic */ eb ij;

    ec(eb eb2, int n) {
        this.ij = eb2;
        super(aH.cH, aH.cH * 2);
        this.index = n;
        this.k("Wingman " + (n + 1));
        this.if = new JCheckBox("Enabled");
        this.if.addActionListener(new ed(this, n));
        this.a(null, this.if);
        this.setBorder(new LineBorder(Color.DARK_GRAY));
        this.ig = new JComboBox();
        this.ig.setModel(new ee(this, n));
        this.a("NPC Race", this.ig);
        this.bj = new ef(this, n);
        this.a("NPC Seed", this.bj);
        this.ih = new JComboBox();
        this.ih.setModel(new eg(this, n));
        this.a("Ship Type", this.ih);
        this.hO = new eh(this, n);
        this.a("Ship Seed", this.hO);
        this.ii = new ei(this, n);
        this.a("Pilot Rank", (JComponent)this.ii);
    }

    private void aQ() {
        this.if.setSelected(eb.a(this.ij)[this.index].isEnabled());
        this.ig.setEnabled(eb.a(this.ij)[this.index].isEnabled());
        this.ig.setSelectedItem((Object)eb.a(this.ij)[this.index].ed());
        this.bj.setEnabled(eb.a(this.ij)[this.index].isEnabled());
        this.bj.setText(eb.a(this.ij)[this.index].ee());
        this.ih.setEnabled(eb.a(this.ij)[this.index].isEnabled());
        this.ih.setSelectedItem(eb.a(this.ij)[this.index].ef());
        this.hO.setEnabled(eb.a(this.ij)[this.index].isEnabled());
        this.hO.setText(eb.a(this.ij)[this.index].eg());
        this.ii.setEnabled(eb.a(this.ij)[this.index].isEnabled());
        this.ii.setText(Integer.toString(eb.a(this.ij)[this.index].eh()));
    }

    static /* synthetic */ JCheckBox a(ec ec2) {
        return ec2.if;
    }

    static /* synthetic */ JComboBox b(ec ec2) {
        return ec2.ig;
    }

    static /* synthetic */ G c(ec ec2) {
        return ec2.bj;
    }

    static /* synthetic */ JComboBox d(ec ec2) {
        return ec2.ih;
    }

    static /* synthetic */ G e(ec ec2) {
        return ec2.hO;
    }

    static /* synthetic */ G f(ec ec2) {
        return ec2.ii;
    }

    static /* synthetic */ void g(ec ec2) {
        ec2.aQ();
    }

    static /* synthetic */ eb h(ec ec2) {
        return ec2.ij;
    }
}
