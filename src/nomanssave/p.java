/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.util.Collections;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.KeyStroke;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import nomanssave.aH;
import nomanssave.ey;
import nomanssave.q;
import nomanssave.r;
import nomanssave.s;
import nomanssave.t;

public class p
extends JDialog {
    private final JTable D;
    private final TableRowSorter E;
    private List F;
    private List G = null;
    private static p H = null;

    private p(Frame frame) {
        super(frame);
        this.setSize(aH.cI * 2, aH.cI + aH.cH);
        this.setResizable(false);
        this.setModalExclusionType(Dialog.ModalExclusionType.APPLICATION_EXCLUDE);
        this.setModal(true);
        JPanel jPanel = new JPanel();
        this.setContentPane(jPanel);
        jPanel.setLayout(new BorderLayout(0, 0));
        JScrollPane jScrollPane = new JScrollPane();
        this.D = new JTable();
        this.D.setSelectionMode(2);
        this.D.setModel(new q(this));
        this.D.getColumnModel().getColumn(0).setMaxWidth(24);
        this.E = new TableRowSorter<TableModel>(this.D.getModel());
        this.E.setSortable(0, false);
        this.D.setRowSorter(this.E);
        jScrollPane.setViewportView(this.D);
        jPanel.add(jScrollPane);
        JPanel jPanel2 = new JPanel();
        jPanel2.setLayout(new FlowLayout(2));
        jPanel.add((Component)jPanel2, "South");
        JButton jButton = new JButton("Add");
        jButton.addActionListener(new r(this));
        jPanel2.add(jButton);
        this.getRootPane().setDefaultButton(jButton);
        JButton jButton2 = new JButton("Cancel");
        jButton2.addActionListener(new s(this));
        jPanel2.add(jButton2);
        this.getRootPane().registerKeyboardAction(new t(this), KeyStroke.getKeyStroke(27, 0), 2);
    }

    private String[] d() {
        this.D.clearSelection();
        this.E.setSortKeys(Collections.emptyList());
        this.E.sort();
        this.D.updateUI();
        this.G = null;
        this.setLocationRelativeTo(this.getParent());
        this.setVisible(true);
        return this.G == null ? new String[]{} : this.G.toArray(new String[0]);
    }

    public static String[] b(Container container) {
        if (H == null) {
            Frame frame = JOptionPane.getFrameForComponent(container);
            H = new p(frame);
        }
        p.H.F = ey.bl();
        H.setTitle("Add Known Technologies");
        return H.d();
    }

    public static String[] c(Container container) {
        if (H == null) {
            Frame frame = JOptionPane.getFrameForComponent(container);
            H = new p(frame);
        }
        p.H.F = ey.bm();
        H.setTitle("Add Known Products");
        return H.d();
    }

    static /* synthetic */ List a(p p2) {
        return p2.F;
    }

    static /* synthetic */ JTable b(p p2) {
        return p2.D;
    }

    static /* synthetic */ void a(p p2, List list) {
        p2.G = list;
    }

    static /* synthetic */ List c(p p2) {
        return p2.G;
    }
}
