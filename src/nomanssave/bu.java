/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import java.awt.Color;
import nomanssave.Application;
import nomanssave.bl;
import nomanssave.bt;
import nomanssave.en;
import nomanssave.er;

class bu
implements Runnable {
    final /* synthetic */ bt es;
    private final /* synthetic */ Application bv;

    bu(bt bt2, Application application) {
        this.es = bt2;
        this.bv = application;
    }

    @Override
    public void run() {
        bl.a(bt.a(this.es), bl.e(bt.a(this.es)).getSelectedRow());
        if (bl.b(bt.a(this.es)) < 0) {
            bl.a(bt.a(this.es), new er[0]);
            bl.b(bt.a(this.es), new er[0]);
            bl.h(bt.a(this.es)).setVisible(false);
            bl.i(bt.a(this.es)).setVisible(false);
            bl.j(bt.a(this.es)).setText("");
            bl.k(bt.a(this.es)).setSelectedIndex(-1);
            bl.l(bt.a(this.es)).setText("");
            bl.m(bt.a(this.es)).setSelectedIndex(-1);
            bl.n(bt.a(this.es)).setText("");
            bl.o(bt.a(this.es)).setText("");
            int n = 0;
            while (n < bl.d(bt.a(this.es)).length) {
                bl.d(bt.a(this.es))[n].setText("");
                ++n;
            }
            bl.p(bt.a(this.es)).setSelectedIndex(-1);
            bl.q(bt.a(this.es)).setSelectedIndex(-1);
            bl.r(bt.a(this.es)).setSelectedIndex(-1);
            bl.s(bt.a(this.es)).setSelectedIndex(-1);
            bl.t(bt.a(this.es)).setSelectedIndex(-1);
            bl.u(bt.a(this.es)).setText("");
            bl.v(bt.a(this.es)).setText("");
            bl.w(bt.a(this.es)).setText("");
            bl.x(bt.a(this.es)).setText("");
            bl.h(bt.a(this.es)).updateUI();
            bl.i(bt.a(this.es)).updateUI();
            bl.y(bt.a(this.es)).setText("");
            bl.z(bt.a(this.es)).setVisible(false);
            bl.A(bt.a(this.es)).setEnabled(false);
            bl.g(bt.a(this.es)).setEnabled(false);
            return;
        }
        bl.a(bt.a(this.es), er.a(bl.c(bt.a(this.es))[bl.b(bt.a(this.es))].da()));
        bl.b(bt.a(this.es), er.b(bl.c(bt.a(this.es))[bl.b(bt.a(this.es))].da()));
        bl.h(bt.a(this.es)).setVisible(true);
        bl.i(bt.a(this.es)).setVisible(true);
        bl.j(bt.a(this.es)).setText(bl.c(bt.a(this.es))[bl.b(bt.a(this.es))].getName());
        bl.k(bt.a(this.es)).setSelectedItem((Object)bl.c(bt.a(this.es))[bl.b(bt.a(this.es))].da());
        bl.l(bt.a(this.es)).setText(bl.c(bt.a(this.es))[bl.b(bt.a(this.es))].cW().toString());
        bl.m(bt.a(this.es)).m(bl.c(bt.a(this.es))[bl.b(bt.a(this.es))].db());
        bl.n(bt.a(this.es)).setText(bl.c(bt.a(this.es))[bl.b(bt.a(this.es))].cU());
        bl.o(bt.a(this.es)).setText(bl.c(bt.a(this.es))[bl.b(bt.a(this.es))].cV());
        int n = 0;
        while (n < bl.d(bt.a(this.es)).length) {
            bl.d(bt.a(this.es))[n].setText(Integer.toString(bl.c(bt.a(this.es))[bl.b(bt.a(this.es))].aq(n)));
            ++n;
        }
        bl.p(bt.a(this.es)).setSelectedItem(bl.c(bt.a(this.es))[bl.b(bt.a(this.es))].ar(0));
        bl.q(bt.a(this.es)).setSelectedItem(bl.c(bt.a(this.es))[bl.b(bt.a(this.es))].ar(1));
        bl.r(bt.a(this.es)).setSelectedItem(bl.c(bt.a(this.es))[bl.b(bt.a(this.es))].ar(2));
        bl.s(bt.a(this.es)).setSelectedItem(bl.c(bt.a(this.es))[bl.b(bt.a(this.es))].ar(3));
        bl.t(bt.a(this.es)).setSelectedItem(bl.c(bt.a(this.es))[bl.b(bt.a(this.es))].ar(4));
        bl.u(bt.a(this.es)).setText(Integer.toString(bl.c(bt.a(this.es))[bl.b(bt.a(this.es))].dc()));
        bl.v(bt.a(this.es)).setText(Integer.toString(bl.c(bt.a(this.es))[bl.b(bt.a(this.es))].dd()));
        bl.w(bt.a(this.es)).setText(Integer.toString(bl.c(bt.a(this.es))[bl.b(bt.a(this.es))].de()));
        bl.x(bt.a(this.es)).setText(Integer.toString(bl.c(bt.a(this.es))[bl.b(bt.a(this.es))].df()));
        if (this.bv.j(bl.c(bt.a(this.es))[bl.b(bt.a(this.es))].getIndex())) {
            bl.y(bt.a(this.es)).setText("Status: On Mission");
            bl.y(bt.a(this.es)).setForeground(Color.BLUE);
            bl.z(bt.a(this.es)).setVisible(false);
        } else if (bl.c(bt.a(this.es))[bl.b(bt.a(this.es))].dh() > 0) {
            bl.y(bt.a(this.es)).setText("Status: Damaged!");
            bl.y(bt.a(this.es)).setForeground(Color.RED);
            bl.z(bt.a(this.es)).setVisible(true);
        } else {
            bl.y(bt.a(this.es)).setText("");
            bl.z(bt.a(this.es)).setVisible(false);
        }
        bl.h(bt.a(this.es)).updateUI();
        bl.i(bt.a(this.es)).updateUI();
        bl.p(bt.a(this.es)).updateUI();
        bl.q(bt.a(this.es)).updateUI();
        bl.r(bt.a(this.es)).updateUI();
        bl.s(bt.a(this.es)).updateUI();
        bl.t(bt.a(this.es)).updateUI();
        bl.A(bt.a(this.es)).setEnabled(bl.c(bt.a(this.es)).length > 1);
        bl.g(bt.a(this.es)).setEnabled(bl.c(bt.a(this.es)).length < 30 || en.aS());
    }
}
