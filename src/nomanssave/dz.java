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
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.KeyStroke;
import nomanssave.dA;
import nomanssave.dB;
import nomanssave.dC;
import nomanssave.dD;
import nomanssave.ft;

public class dz
extends JDialog {
    private final JList hr;
    private ft[] hs;
    private int gU;
    private static dz ht = null;

    private dz(Frame frame) {
        super(frame);
        this.setSize(300, 400);
        this.setResizable(false);
        this.setModalExclusionType(Dialog.ModalExclusionType.APPLICATION_EXCLUDE);
        this.setTitle("Save File As");
        this.setModal(true);
        JPanel jPanel = new JPanel();
        this.setContentPane(jPanel);
        jPanel.setLayout(new BorderLayout(0, 0));
        JScrollPane jScrollPane = new JScrollPane();
        this.hr = new JList();
        this.hr.setSelectionMode(0);
        this.hr.setModel(new dA(this));
        jScrollPane.setViewportView(this.hr);
        jPanel.add(jScrollPane);
        JPanel jPanel2 = new JPanel();
        jPanel2.setLayout(new FlowLayout(2));
        jPanel.add((Component)jPanel2, "South");
        JButton jButton = new JButton("Replace/Save");
        jButton.addActionListener(new dB(this));
        jPanel2.add(jButton);
        this.getRootPane().setDefaultButton(jButton);
        JButton jButton2 = new JButton("Cancel");
        jButton2.addActionListener(new dC(this));
        jPanel2.add(jButton2);
        this.getRootPane().registerKeyboardAction(new dD(this), KeyStroke.getKeyStroke(27, 0), 2);
    }

    private int a(ft[] ftArray, int n) {
        this.hs = ftArray;
        this.hr.updateUI();
        this.hr.setSelectedIndex(n);
        this.gU = -1;
        this.setLocationRelativeTo(this.getParent());
        this.setVisible(true);
        return this.gU;
    }

    public static int a(Container container, ft[] ftArray, int n) {
        if (ht == null) {
            Frame frame = JOptionPane.getFrameForComponent(container);
            ht = new dz(frame);
        }
        return ht.a(ftArray, n);
    }

    static /* synthetic */ ft[] a(dz dz2) {
        return dz2.hs;
    }

    static /* synthetic */ JList b(dz dz2) {
        return dz2.hr;
    }

    static /* synthetic */ void a(dz dz2, int n) {
        dz2.gU = n;
    }
}
