/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import nomanssave.eB;
import nomanssave.ex;
import nomanssave.ey;
import nomanssave.i;
import nomanssave.j;
import nomanssave.k;
import nomanssave.l;
import nomanssave.m;
import nomanssave.n;
import nomanssave.o;

public class h
extends JDialog {
    private ey l = null;
    private JTextField m;
    private JButton n;
    private JComboBox o;
    private JComboBox p;
    private JComboBox q;
    private int r;
    private List s = new ArrayList();
    private List t = new ArrayList();
    private List u = new ArrayList();
    private List v = new ArrayList();
    private static h w = null;

    private h(Frame frame) {
        super(frame);
        this.setResizable(false);
        this.setModalExclusionType(Dialog.ModalExclusionType.APPLICATION_EXCLUDE);
        this.setTitle("Add Item");
        this.setModal(true);
        JPanel jPanel = new JPanel();
        this.setContentPane(jPanel);
        jPanel.setLayout(new BorderLayout(0, 0));
        JPanel jPanel2 = new JPanel();
        jPanel2.setLayout(new FormLayout(new ColumnSpec[]{FormFactory.LABEL_COMPONENT_GAP_COLSPEC, ColumnSpec.decode("100px"), FormFactory.LABEL_COMPONENT_GAP_COLSPEC, ColumnSpec.decode("280px"), FormFactory.LABEL_COMPONENT_GAP_COLSPEC}, new RowSpec[]{FormFactory.LINE_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC, FormFactory.LINE_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC, FormFactory.LINE_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC, FormFactory.LINE_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC, FormFactory.LINE_GAP_ROWSPEC}));
        JLabel jLabel = new JLabel("Search:");
        jPanel2.add((Component)jLabel, "2, 2, left, center");
        JPanel jPanel3 = new JPanel();
        jPanel3.setLayout(new BorderLayout(0, 0));
        this.m = new JTextField();
        this.m.setText("");
        jPanel3.add((Component)this.m, "Center");
        this.n = new JButton("Search");
        this.n.addActionListener(new i(this));
        jPanel3.add((Component)this.n, "East");
        jPanel2.add((Component)jPanel3, "4, 2, fill, default");
        JLabel jLabel2 = new JLabel("Type:");
        jPanel2.add((Component)jLabel2, "2, 4, left, center");
        this.o = new JComboBox();
        this.o.setModel(new j(this));
        jPanel2.add((Component)this.o, "4, 4, fill, default");
        JLabel jLabel3 = new JLabel("Category:");
        jPanel2.add((Component)jLabel3, "2, 6, left, center");
        this.p = new JComboBox();
        this.p.setModel(new k(this));
        jPanel2.add((Component)this.p, "4, 6, fill, default");
        JLabel jLabel4 = new JLabel("Item:");
        jPanel2.add((Component)jLabel4, "2, 8, left, center");
        this.q = new JComboBox();
        this.q.setModel(new l(this));
        jPanel2.add((Component)this.q, "4, 8, fill, default");
        jPanel.add((Component)jPanel2, "Center");
        JPanel jPanel4 = new JPanel();
        jPanel4.setLayout(new FlowLayout(2));
        jPanel.add((Component)jPanel4, "South");
        JButton jButton = new JButton("Save");
        jButton.addActionListener(new m(this));
        jPanel4.add(jButton);
        this.getRootPane().setDefaultButton(jButton);
        JButton jButton2 = new JButton("Cancel");
        jButton2.addActionListener(new n(this));
        jPanel4.add(jButton2);
        this.getRootPane().registerKeyboardAction(new o(this), KeyStroke.getKeyStroke(27, 0), 2);
        this.pack();
    }

    private void a() {
        this.t = this.s.stream().map(ey::ba).distinct().sorted((eB2, eB3) -> eB2.name().compareTo(eB3.name())).collect(Collectors.toList());
        this.o.setSelectedIndex(this.t.size() == 1 ? 0 : -1);
        this.o.updateUI();
        this.b();
    }

    private void b() {
        eB eB2 = (eB)((Object)this.o.getSelectedItem());
        this.u = this.s.stream().filter(ey2 -> ey2.ba() == eB2).map(ey::bc).distinct().sorted((ex2, ex3) -> ex2.name().compareTo(ex3.name())).collect(Collectors.toList());
        this.p.setSelectedIndex(this.u.size() == 1 ? 0 : -1);
        this.p.updateUI();
        this.c();
    }

    private void c() {
        eB eB2 = (eB)((Object)this.o.getSelectedItem());
        ex ex2 = (ex)((Object)this.p.getSelectedItem());
        this.v = this.s.stream().filter(ey2 -> ey2.ba() == eB2 && ey2.bc() == ex2 && (ex2 != ex.iZ || !ey2.be())).sorted((ey2, ey3) -> ey2.getName().compareTo(ey3.getName())).collect(Collectors.toList());
        this.q.setSelectedIndex(this.v.size() == 1 ? 0 : -1);
        this.q.updateUI();
    }

    private ey a(int n2) {
        this.r = n2;
        this.s = ey.b(n2, this.m.getText());
        this.a();
        this.l = null;
        this.setLocationRelativeTo(this.getParent());
        this.setVisible(true);
        return this.l;
    }

    public static ey a(Container container, int n2) {
        if (w == null) {
            Frame frame = JOptionPane.getFrameForComponent(container);
            w = new h(frame);
        }
        return w.a(n2);
    }

    static /* synthetic */ JTextField a(h h2) {
        return h2.m;
    }

    static /* synthetic */ int b(h h2) {
        return h2.r;
    }

    static /* synthetic */ void a(h h2, List list) {
        h2.s = list;
    }

    static /* synthetic */ void c(h h2) {
        h2.a();
    }

    static /* synthetic */ List d(h h2) {
        return h2.s;
    }

    static /* synthetic */ List e(h h2) {
        return h2.t;
    }

    static /* synthetic */ void f(h h2) {
        h2.b();
    }

    static /* synthetic */ List g(h h2) {
        return h2.u;
    }

    static /* synthetic */ void h(h h2) {
        h2.c();
    }

    static /* synthetic */ List i(h h2) {
        return h2.v;
    }

    static /* synthetic */ JComboBox j(h h2) {
        return h2.q;
    }

    static /* synthetic */ void a(h h2, ey ey2) {
        h2.l = ey2;
    }
}
