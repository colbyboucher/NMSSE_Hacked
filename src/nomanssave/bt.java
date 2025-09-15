/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import java.awt.EventQueue;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import nomanssave.Application;
import nomanssave.bl;
import nomanssave.bu;

class bt
implements ListSelectionListener {
    final /* synthetic */ bl er;
    private final /* synthetic */ Application bv;

    bt(bl bl2, Application application) {
        this.er = bl2;
        this.bv = application;
    }

    @Override
    public void valueChanged(ListSelectionEvent listSelectionEvent) {
        EventQueue.invokeLater(new bu(this, this.bv));
    }

    static /* synthetic */ bl a(bt bt2) {
        return bt2.er;
    }
}
