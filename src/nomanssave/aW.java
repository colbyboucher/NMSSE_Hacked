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
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import nomanssave.aX;
import nomanssave.aY;
import nomanssave.aZ;
import nomanssave.cy;

public class aW
extends JDialog {
    private JTextField ds;
    private JCheckBox dt;
    private JCheckBox du;
    private JRadioButton dv;
    private JRadioButton dw;
    private static aW dx;

    private aW(cy cy2) {
        super(cy2);
        this.setSize(400, 250);
        this.setResizable(false);
        this.setModalExclusionType(Dialog.ModalExclusionType.APPLICATION_EXCLUDE);
        this.setTitle("Find");
        this.setModal(true);
        JPanel jPanel = new JPanel();
        this.setContentPane(jPanel);
        jPanel.setLayout(new BorderLayout(0, 0));
        JPanel jPanel2 = new JPanel();
        jPanel2.setLayout(new FormLayout(new ColumnSpec[]{FormFactory.LABEL_COMPONENT_GAP_COLSPEC, ColumnSpec.decode("100px"), FormFactory.LABEL_COMPONENT_GAP_COLSPEC, ColumnSpec.decode("250px"), FormFactory.LABEL_COMPONENT_GAP_COLSPEC}, new RowSpec[]{FormFactory.LINE_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC, FormFactory.LINE_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC, FormFactory.LINE_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC, FormFactory.LINE_GAP_ROWSPEC}));
        JLabel jLabel = new JLabel("Find:");
        jPanel2.add((Component)jLabel, "2, 2, left, center");
        this.ds = new JTextField();
        jPanel2.add((Component)this.ds, "4, 2, fill, default");
        jPanel.add(jPanel2);
        JPanel jPanel3 = new JPanel();
        jPanel3.setLayout(new GridLayout(1, 2));
        jPanel3.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createTitledBorder("Direction"), BorderFactory.createEmptyBorder(5, 5, 5, 5)));
        this.dv = new JRadioButton("Forward");
        this.dv.setSelected(true);
        jPanel3.add(this.dv);
        this.dw = new JRadioButton("Backward");
        jPanel3.add(this.dw);
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(this.dv);
        buttonGroup.add(this.dw);
        jPanel2.add((Component)jPanel3, "2, 4, 3, 1");
        JPanel jPanel4 = new JPanel();
        jPanel4.setLayout(new GridLayout(1, 2));
        jPanel4.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createTitledBorder("Options"), BorderFactory.createEmptyBorder(5, 5, 5, 5)));
        this.dt = new JCheckBox("Case Sensitive");
        this.dt.setSelected(true);
        jPanel4.add(this.dt);
        this.du = new JCheckBox("Wrap Search");
        jPanel4.add(this.du);
        jPanel2.add((Component)jPanel4, "2, 6, 3, 1");
        JPanel jPanel5 = new JPanel();
        jPanel5.setLayout(new FlowLayout(2));
        jPanel.add((Component)jPanel5, "South");
        JButton jButton = new JButton("Find");
        jButton.setMnemonic(10);
        jButton.addActionListener(new aX(this, cy2));
        jPanel5.add(jButton);
        this.getRootPane().setDefaultButton(jButton);
        JButton jButton2 = new JButton("Cancel");
        jButton2.setMnemonic(27);
        jButton2.addActionListener(new aY(this));
        jPanel5.add(jButton2);
        this.getRootPane().registerKeyboardAction(new aZ(this), KeyStroke.getKeyStroke(27, 0), 2);
        this.pack();
    }

    public static void a(cy cy2, String string) {
        if (dx == null) {
            dx = new aW(cy2);
        }
        dx.setLocationRelativeTo(cy2);
        if (string != null) {
            aW.dx.ds.setText(string);
        }
        aW.dx.ds.setSelectionStart(0);
        aW.dx.ds.setSelectionEnd(aW.dx.ds.getText().length());
        aW.dx.ds.requestFocus();
        dx.setVisible(true);
    }

    static /* synthetic */ JTextField a(aW aW2) {
        return aW2.ds;
    }

    static /* synthetic */ JRadioButton b(aW aW2) {
        return aW2.dw;
    }

    static /* synthetic */ JCheckBox c(aW aW2) {
        return aW2.dt;
    }

    static /* synthetic */ JCheckBox d(aW aW2) {
        return aW2.du;
    }
}
