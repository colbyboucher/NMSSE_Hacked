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
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import nomanssave.R;
import nomanssave.S;
import nomanssave.T;
import nomanssave.U;
import nomanssave.V;
import nomanssave.W;

public class Q
extends JDialog {
    private W bw;
    private int bx;
    private int by;
    private W bz = null;
    private JTextField bA;
    private JTextField bB;
    private static Q bC;

    private Q(Frame frame) {
        super(frame);
        this.setResizable(false);
        this.setModalExclusionType(Dialog.ModalExclusionType.APPLICATION_EXCLUDE);
        this.setTitle("Change Stack Sizes");
        this.setModal(true);
        JPanel jPanel = new JPanel();
        this.setContentPane(jPanel);
        jPanel.setLayout(new BorderLayout(0, 0));
        JPanel jPanel2 = new JPanel();
        jPanel2.setLayout(new FormLayout(new ColumnSpec[]{FormFactory.LABEL_COMPONENT_GAP_COLSPEC, ColumnSpec.decode("100px"), FormFactory.LABEL_COMPONENT_GAP_COLSPEC, ColumnSpec.decode("250px"), FormFactory.LABEL_COMPONENT_GAP_COLSPEC}, new RowSpec[]{FormFactory.LINE_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC, FormFactory.LINE_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC, FormFactory.LINE_GAP_ROWSPEC, RowSpec.decode("20dlu"), FormFactory.LINE_GAP_ROWSPEC}));
        JLabel jLabel = new JLabel("Substances:");
        jPanel2.add((Component)jLabel, "2, 2, left, center");
        this.bA = new JTextField();
        this.bA.addFocusListener(new R(this));
        jPanel2.add((Component)this.bA, "4, 2, fill, default");
        JLabel jLabel2 = new JLabel("Products:");
        jPanel2.add((Component)jLabel2, "2, 4, left, center");
        this.bB = new JTextField();
        this.bB.addFocusListener(new S(this));
        jPanel2.add((Component)this.bB, "4, 4, fill, default");
        JLabel jLabel3 = new JLabel("<html><font color=\"red\"><b>Please Note: No Man's Sky sometimes reverts these settings back to default.</b></font></html>");
        jPanel2.add((Component)jLabel3, "2, 6, 3, 1, fill, center");
        jPanel.add(jPanel2);
        JPanel jPanel3 = new JPanel();
        jPanel3.setLayout(new FlowLayout(2));
        jPanel.add((Component)jPanel3, "South");
        JButton jButton = new JButton("Save");
        jButton.addActionListener(new T(this));
        jPanel3.add(jButton);
        this.getRootPane().setDefaultButton(jButton);
        JButton jButton2 = new JButton("Cancel");
        jButton2.addActionListener(new U(this));
        jPanel3.add(jButton2);
        this.getRootPane().registerKeyboardAction(new V(this), KeyStroke.getKeyStroke(27, 0), 2);
        this.pack();
    }

    private W a(W w, int n, int n2) {
        this.bw = w;
        this.bx = n;
        this.by = n2;
        this.bA.setText(Integer.toString(w.bE));
        this.bB.setText(Integer.toString(w.bF));
        this.bz = null;
        this.setLocationRelativeTo(this.getParent());
        this.setVisible(true);
        return this.bz;
    }

    public static W a(Container container, W w, int n, int n2) {
        if (bC == null) {
            Frame frame = JOptionPane.getFrameForComponent(container);
            bC = new Q(frame);
        }
        return bC.a(w, n, n2);
    }

    static /* synthetic */ JTextField a(Q q) {
        return q.bA;
    }

    static /* synthetic */ int b(Q q) {
        return q.bx;
    }

    static /* synthetic */ W c(Q q) {
        return q.bw;
    }

    static /* synthetic */ JTextField d(Q q) {
        return q.bB;
    }

    static /* synthetic */ int e(Q q) {
        return q.by;
    }

    static /* synthetic */ void a(Q q, W w) {
        q.bz = w;
    }
}
