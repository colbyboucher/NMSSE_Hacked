/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import java.awt.Component;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.UIManager;
import nomanssave.Application;
import nomanssave.aH;
import nomanssave.ba;
import nomanssave.dd;
import nomanssave.du;
import nomanssave.ey;
import nomanssave.gF;
import nomanssave.gt;
import nomanssave.h;

public class dt
extends ba {
    private final Application eR;
    private final JPanel eS;

    dt(Application application) {
        super(aH.cJ, 0);
        this.eR = application;
        this.k("Production");
        this.eS = new JPanel();
        this.eS.setLayout(new GridBagLayout());
        this.a(this.eS);
        UIManager.addPropertyChangeListener(propertyChangeEvent -> {
            if ("lookAndFeel".equals(propertyChangeEvent.getPropertyName())) {
                EventQueue.invokeLater(this::aL);
            }
        });
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void aL() {
        Object object = this.eS.getTreeLock();
        synchronized (object) {
            Component[] componentArray = this.eS.getComponents();
            int n = componentArray.length;
            int n2 = 0;
            while (n2 < n) {
                Component component = componentArray[n2];
                du du2 = (du)component;
                du.c(du2);
                ++n2;
            }
        }
        this.eS.revalidate();
        this.eS.updateUI();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void a(gF[] gFArray) {
        Object object = this.eS.getTreeLock();
        synchronized (object) {
            this.eS.removeAll();
            int n = 0;
            while (n < gFArray.length) {
                du du2 = new du(this, gFArray[n], null);
                GridBagConstraints gridBagConstraints = new GridBagConstraints();
                gridBagConstraints.fill = 1;
                gridBagConstraints.insets = new Insets(10, 10, 10, 10);
                gridBagConstraints.gridx = n % 3;
                gridBagConstraints.gridy = n / 3;
                this.eS.add((Component)du2, gridBagConstraints);
                ++n;
            }
        }
        this.eS.revalidate();
        this.eS.updateUI();
    }

    private void a(du du2) {
        ey ey2 = h.a(this, 28160);
        if (ey2 != null) {
            du2.hm.m(ey2.aZ());
            du2.hm.aA(0);
            du.c(du2);
        }
    }

    private void b(du du2) {
        ey ey2 = ey.d(du2.hm.dz());
        if (ey2 == null) {
            this.eR.c("Item details not found!");
            return;
        }
        List list = this.eR.g(3584);
        int n = dd.a(this, list, -1);
        if (n != -1) {
            gt gt2 = (gt)list.get(n);
            int n2 = du2.hm.dA();
            ey ey3 = ey.d(du2.hm.dz());
            n2 = gt2.a(ey3, n2);
            du2.hm.aA(n2);
            du.c(du2);
            this.eR.a(gt2);
        }
    }

    static /* synthetic */ void a(dt dt2, du du2) {
        dt2.a(du2);
    }

    static /* synthetic */ void b(dt dt2, du du2) {
        dt2.b(du2);
    }
}
