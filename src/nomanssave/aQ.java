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
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import nomanssave.aR;
import nomanssave.aS;
import nomanssave.aT;
import nomanssave.aU;
import nomanssave.aV;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public class aQ
extends JDialog {
    private Dimension dk;
    private Dimension dl;
    private Dimension dm;
    private Dimension dn = null;
    private JTextField do;
    private JTextField dp;
    private static aQ dq;

    private aQ(Frame frame) {
        super(frame);
        this.setResizable(false);
        this.setModalExclusionType(Dialog.ModalExclusionType.APPLICATION_EXCLUDE);
        this.setTitle("Expand Inventory");
        this.setModal(true);
        JPanel jPanel = new JPanel();
        this.setContentPane(jPanel);
        jPanel.setLayout(new BorderLayout(0, 0));
        JPanel jPanel2 = new JPanel();
        jPanel2.setLayout(new FormLayout(new ColumnSpec[]{FormFactory.LABEL_COMPONENT_GAP_COLSPEC, ColumnSpec.decode("100px"), FormFactory.LABEL_COMPONENT_GAP_COLSPEC, ColumnSpec.decode("250px"), FormFactory.LABEL_COMPONENT_GAP_COLSPEC}, new RowSpec[]{FormFactory.LINE_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC, FormFactory.LINE_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC, FormFactory.LINE_GAP_ROWSPEC}));
        JLabel jLabel = new JLabel("Width:");
        jPanel2.add((Component)jLabel, "2, 2, left, center");
        this.do = new JTextField();
        this.do.addFocusListener(new aR(this));
        jPanel2.add((Component)this.do, "4, 2, fill, default");
        JLabel jLabel2 = new JLabel("Height:");
        jPanel2.add((Component)jLabel2, "2, 4, left, center");
        this.dp = new JTextField();
        this.dp.addFocusListener(new aS(this));
        jPanel2.add((Component)this.dp, "4, 4, fill, default");
        jPanel.add(jPanel2);
        JPanel jPanel3 = new JPanel();
        jPanel3.setLayout(new FlowLayout(2));
        jPanel.add((Component)jPanel3, "South");
        JButton jButton = new JButton("Save");
        jButton.addActionListener(new aT(this));
        jPanel3.add(jButton);
        this.getRootPane().setDefaultButton(jButton);
        JButton jButton2 = new JButton("Cancel");
        jButton2.addActionListener(new aU(this));
        jPanel3.add(jButton2);
        this.getRootPane().registerKeyboardAction(new aV(this), KeyStroke.getKeyStroke(27, 0), 2);
        this.pack();
    }

    private Dimension a(Dimension dimension, Dimension dimension2, Dimension dimension3) {
        this.dk = dimension;
        this.dl = dimension2;
        this.dm = dimension3;
        this.do.setText(Integer.toString(dimension.width));
        this.dp.setText(Integer.toString(dimension.height));
        this.dn = null;
        this.setLocationRelativeTo(this.getParent());
        this.setVisible(true);
        return this.dn;
    }

    public static Dimension a(Container container, Dimension dimension, Dimension dimension2, Dimension dimension3) {
        if (dq == null) {
            Frame frame = JOptionPane.getFrameForComponent(container);
            dq = new aQ(frame);
        }
        return dq.a(dimension, dimension2, dimension3);
    }

    static /* synthetic */ JTextField a(aQ aQ2) {
        return aQ2.do;
    }

    static /* synthetic */ Dimension b(aQ aQ2) {
        return aQ2.dk;
    }

    static /* synthetic */ Dimension c(aQ aQ2) {
        return aQ2.dl;
    }

    static /* synthetic */ Dimension d(aQ aQ2) {
        return aQ2.dm;
    }

    static /* synthetic */ JTextField e(aQ aQ2) {
        return aQ2.dp;
    }

    static /* synthetic */ void a(aQ aQ2, Dimension dimension) {
        aQ2.dn = dimension;
    }
}
