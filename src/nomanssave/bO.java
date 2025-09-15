/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.Collections;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import nomanssave.Application;
import nomanssave.bP;
import nomanssave.bQ;
import nomanssave.bR;
import nomanssave.bS;
import nomanssave.dd;
import nomanssave.en;
import nomanssave.eo;
import nomanssave.ey;
import nomanssave.fg;
import nomanssave.gt;
import nomanssave.gu;
import nomanssave.h;

public class bO
extends JPanel
implements eo {
    private static final Color eE = Color.GRAY;
    private static final Color eF = new Color(255, 240, 240);
    private static final Color eG = new Color(255, 255, 240);
    private static final Color eH = new Color(240, 255, 250);
    private static final Color eI = new Color(240, 250, 255);
    private static final Color eJ = new Color(240, 255, 255);
    public static final Color eK = Color.WHITE;
    private static final Color eL = Color.BLACK;
    private static final Color eM = Color.YELLOW;
    private static final Color eN = Color.RED;
    public static final Color eO = Color.BLACK;
    public static final Border eP = BorderFactory.createLineBorder(eL, 1);
    private static final Border eQ = BorderFactory.createCompoundBorder(eP, BorderFactory.createLineBorder(eM, 2));
    private final Application eR;
    private final JPanel eS;
    private final JComboBox eT;
    private final JButton eU;
    private List eV;
    private gt eW;

    bO(Application application) {
        this.eR = application;
        this.setLayout(new BorderLayout());
        JPanel jPanel = new JPanel();
        jPanel.setLayout(new FlowLayout());
        this.eS = new JPanel();
        this.eS.setLayout(new GridBagLayout());
        int n = UIManager.getInt("Inventory.gridSize");
        this.setPreferredSize(new Dimension(n * 10 + 20, n * 8 + 50));
        this.add((Component)jPanel, "North");
        JScrollPane jScrollPane = new JScrollPane();
        jScrollPane.setViewportView(this.eS);
        jScrollPane.setBorder(new LineBorder(eL));
        this.add((Component)jScrollPane, "Center");
        this.eV = Collections.emptyList();
        this.eT = new JComboBox();
        this.eT.setVisible(false);
        this.eT.setModel(new bP(this));
        this.eT.setRenderer(new bQ(this));
        jPanel.add(this.eT);
        this.eU = new JButton("Resize Inventory");
        this.eU.setVisible(false);
        this.eU.addActionListener(new bR(this));
        jPanel.add(this.eU);
        en.a(this);
        UIManager.addPropertyChangeListener(propertyChangeEvent -> {
            if ("lookAndFeel".equals(propertyChangeEvent.getPropertyName())) {
                EventQueue.invokeLater(this::af);
            }
        });
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void a(boolean bl) {
        this.eU.setVisible(this.eW == null ? false : bl || this.eW.dk());
        boolean bl2 = this.eW == null ? false : bl || this.eW.dp();
        Object object = this.eS.getTreeLock();
        synchronized (object) {
            int n = 0;
            while (n < this.eS.getComponentCount()) {
                Component component = this.eS.getComponent(n);
                if (component instanceof bS) {
                    bS bS2 = (bS)component;
                    bS.b(bS2).setEnabled(bl2);
                    bS.g(bS2).setEnabled(bl2);
                }
                ++n;
            }
        }
    }

    void a(gt gt2) {
        if (this.eW == gt2) {
            this.af();
        }
    }

    void w() {
        this.eV.stream().forEach(gt2 -> {
            if (gt2.dt() && this.eW == gt2) {
                this.af();
            }
        });
    }

    void x() {
        this.eV.stream().forEach(gt2 -> {
            if (gt2.du() && this.eW == gt2) {
                this.af();
            }
        });
    }

    void y() {
        this.eV.stream().forEach(gt2 -> {
            if (gt2.dp() && gt2.dv() && this.eW == gt2) {
                this.af();
            }
        });
    }

    void z() {
        this.eV.stream().forEach(gt2 -> {
            if (gt2.dq() && gt2.ds() && this.eW == gt2) {
                this.af();
            }
        });
    }

    void A() {
        this.eV.stream().forEach(gt2 -> {
            if (gt2.dk() && gt2.dl() && this.eW == gt2) {
                this.af();
            }
        });
    }

    void ae() {
        int n = this.eT.getSelectedIndex();
        if (n >= 0) {
            this.eW = (gt)this.eV.get(n);
            this.af();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void af() {
        Object object = this.eS.getTreeLock();
        synchronized (object) {
            this.eS.removeAll();
            if (this.eW != null) {
                int n = UIManager.getInt("Inventory.gridSize");
                Dimension dimension = new Dimension(n, n);
                int n2 = 0;
                while (n2 < this.eW.getHeight()) {
                    int n3 = 0;
                    while (n3 < this.eW.getWidth()) {
                        bS bS2 = new bS(this, n3, n2, null);
                        bS2.setMinimumSize(dimension);
                        bS2.setMaximumSize(dimension);
                        bS2.setPreferredSize(dimension);
                        GridBagConstraints gridBagConstraints = new GridBagConstraints();
                        gridBagConstraints.fill = 1;
                        gridBagConstraints.insets = new Insets(-1, -1, 0, 0);
                        gridBagConstraints.gridx = n3++;
                        gridBagConstraints.gridy = n2;
                        this.eS.add((Component)bS2, gridBagConstraints);
                    }
                    ++n2;
                }
            }
        }
        this.eS.revalidate();
        this.eS.updateUI();
    }

    void a(List list) {
        this.eV = list;
        this.eW = null;
        this.eT.updateUI();
        if (this.eV.size() == 0) {
            this.eT.setVisible(false);
            this.eU.setVisible(false);
            this.af();
        } else {
            this.eT.setVisible(this.eV.size() != 1);
            this.eU.setVisible(false);
            this.eT.setSelectedIndex(0);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private bS a(int n, int n2) {
        Object object = this.eS.getTreeLock();
        synchronized (object) {
            int n3 = 0;
            while (n3 < this.eS.getComponentCount()) {
                bS bS2;
                Component component = this.eS.getComponent(n3);
                if (component instanceof bS && bS.h(bS2 = (bS)component) == n && bS.i(bS2) == n2) {
                    return bS2;
                }
                ++n3;
            }
        }
        return null;
    }

    private void a(bS bS2) {
        ey ey2 = h.a(this, this.eW.dj());
        if (ey2 != null) {
            this.eW.a(bS.h(bS2), bS.i(bS2), ey2);
            bS.c(bS2);
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    private void a(gu gu2, bS bS2) {
        int n;
        ey ey2 = ey.d(gu2.dz());
        if (ey2 == null) {
            if ("Product".equals(gu2.getType())) {
                n = 512;
            } else {
                if (!"Substance".equals(gu2.getType())) {
                    this.eR.c("Item details not found!");
                    return;
                }
                n = 1024;
            }
        } else {
            n = gt.a(ey2.bc());
        }
        List list = this.eR.g(n);
        int n2 = list.indexOf(this.eW);
        int n3 = dd.a(this, list, n2);
        if (n3 != n2) {
            gt gt2 = (gt)list.get(n3);
            if (this.eW.a(bS.h(bS2), bS.i(bS2), gt2)) {
                bS.c(bS2);
                this.eR.a(gt2);
            }
        }
    }

    private static String a(Object object) {
        if (object instanceof fg) {
            return "Archived Tech";
        }
        return object.toString();
    }

    static /* synthetic */ gt a(bO bO2) {
        return bO2.eW;
    }

    static /* synthetic */ Application b(bO bO2) {
        return bO2.eR;
    }

    static /* synthetic */ void c(bO bO2) {
        bO2.af();
    }

    static /* synthetic */ void a(bO bO2, bS bS2) {
        bO2.a(bS2);
    }

    static /* synthetic */ void a(bO bO2, gu gu2, bS bS2) {
        bO2.a(gu2, bS2);
    }

    static /* synthetic */ bS a(bO bO2, int n, int n2) {
        return bO2.a(n, n2);
    }

    static /* synthetic */ Color ag() {
        return eE;
    }

    static /* synthetic */ Border ah() {
        return eQ;
    }

    static /* synthetic */ Color ai() {
        return eF;
    }

    static /* synthetic */ String b(Object object) {
        return bO.a(object);
    }

    static /* synthetic */ Color aj() {
        return eN;
    }

    static /* synthetic */ Color ak() {
        return eG;
    }

    static /* synthetic */ Color al() {
        return eH;
    }

    static /* synthetic */ Color am() {
        return eI;
    }

    static /* synthetic */ Color an() {
        return eJ;
    }

    static /* synthetic */ List d(bO bO2) {
        return bO2.eV;
    }

    static /* synthetic */ void a(bO bO2, gt gt2) {
        bO2.eW = gt2;
    }

    static /* synthetic */ JButton e(bO bO2) {
        return bO2.eU;
    }
}
