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
import java.util.List;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.KeyStroke;
import nomanssave.de;
import nomanssave.df;
import nomanssave.dg;
import nomanssave.dh;
import nomanssave.di;

public class dd
extends JDialog {
    private final JList gS;
    private List gT;
    private int gU;
    private static dd gV = null;

    private dd(Frame frame) {
        super(frame);
        this.setSize(300, 300);
        this.setResizable(false);
        this.setModalExclusionType(Dialog.ModalExclusionType.APPLICATION_EXCLUDE);
        this.setTitle("Move Item");
        this.setModal(true);
        JPanel jPanel = new JPanel();
        this.setContentPane(jPanel);
        jPanel.setLayout(new BorderLayout(0, 0));
        JScrollPane jScrollPane = new JScrollPane();
        this.gS = new JList();
        this.gS.setSelectionMode(0);
        this.gS.setModel(new de(this));
        this.gS.addMouseListener(new df(this));
        jScrollPane.setViewportView(this.gS);
        jPanel.add(jScrollPane);
        JPanel jPanel2 = new JPanel();
        jPanel2.setLayout(new FlowLayout(2));
        jPanel.add((Component)jPanel2, "South");
        JButton jButton = new JButton("Move");
        jButton.addActionListener(new dg(this));
        jPanel2.add(jButton);
        this.getRootPane().setDefaultButton(jButton);
        JButton jButton2 = new JButton("Cancel");
        jButton2.addActionListener(new dh(this));
        jPanel2.add(jButton2);
        this.getRootPane().registerKeyboardAction(new di(this), KeyStroke.getKeyStroke(27, 0), 2);
    }

    private int a(List list, int n) {
        this.gT = list;
        this.gS.updateUI();
        this.gS.setSelectedIndex(this.gU);
        this.gU = n;
        this.setLocationRelativeTo(this.getParent());
        this.setVisible(true);
        return this.gU;
    }

    public static int a(Container container, List list, int n) {
        if (gV == null) {
            Frame frame = JOptionPane.getFrameForComponent(container);
            gV = new dd(frame);
        }
        return gV.a(list, n);
    }

    static /* synthetic */ List a(dd dd2) {
        return dd2.gT;
    }

    static /* synthetic */ JList b(dd dd2) {
        return dd2.gS;
    }

    static /* synthetic */ void a(dd dd2, int n) {
        dd2.gU = n;
    }
}
