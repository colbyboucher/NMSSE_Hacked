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
import java.util.Collections;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import nomanssave.cZ;
import nomanssave.da;
import nomanssave.db;
import nomanssave.dc;

public class cY
extends JDialog {
    private JComboBox gM;
    private List gN = Collections.emptyList();
    private int gO = -1;
    private static cY gP = null;

    private cY(Frame frame) {
        super(frame);
        this.setResizable(false);
        this.setModalExclusionType(Dialog.ModalExclusionType.APPLICATION_EXCLUDE);
        this.setTitle("Move Base Computer");
        this.setModal(true);
        JPanel jPanel = new JPanel();
        this.setContentPane(jPanel);
        jPanel.setLayout(new BorderLayout(0, 0));
        JPanel jPanel2 = new JPanel();
        jPanel2.setLayout(new FlowLayout(0));
        jPanel2.add(new JLabel("Please select a base part to swap your base computer with."));
        jPanel.add((Component)jPanel2, "North");
        JPanel jPanel3 = new JPanel();
        jPanel3.setLayout(new FormLayout(new ColumnSpec[]{FormFactory.LABEL_COMPONENT_GAP_COLSPEC, ColumnSpec.decode("100px"), FormFactory.LABEL_COMPONENT_GAP_COLSPEC, ColumnSpec.decode("250px"), FormFactory.LABEL_COMPONENT_GAP_COLSPEC}, new RowSpec[]{FormFactory.LINE_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC, FormFactory.LINE_GAP_ROWSPEC}));
        JLabel jLabel = new JLabel("Base Part:");
        jPanel3.add((Component)jLabel, "2, 2, left, center");
        this.gM = new JComboBox();
        this.gM.setModel(new cZ(this));
        jPanel3.add((Component)this.gM, "4, 2, fill, default");
        jPanel.add((Component)jPanel3, "Center");
        JPanel jPanel4 = new JPanel();
        jPanel4.setLayout(new FlowLayout(2));
        jPanel.add((Component)jPanel4, "South");
        JButton jButton = new JButton("Save");
        jButton.addActionListener(new da(this));
        jPanel4.add(jButton);
        this.getRootPane().setDefaultButton(jButton);
        JButton jButton2 = new JButton("Cancel");
        jButton2.addActionListener(new db(this));
        jPanel4.add(jButton2);
        this.getRootPane().registerKeyboardAction(new dc(this), KeyStroke.getKeyStroke(27, 0), 2);
        this.pack();
    }

    private int b(List list) {
        this.gN = list;
        this.setLocationRelativeTo(this.getParent());
        this.gM.setSelectedIndex(0);
        this.gM.updateUI();
        this.gO = -1;
        this.setVisible(true);
        return this.gO;
    }

    public static int a(Container container, List list) {
        if (gP == null) {
            Frame frame = JOptionPane.getFrameForComponent(container);
            gP = new cY(frame);
        }
        return gP.b(list);
    }

    static /* synthetic */ List a(cY cY2) {
        return cY2.gN;
    }

    static /* synthetic */ JComboBox b(cY cY2) {
        return cY2.gM;
    }

    static /* synthetic */ void a(cY cY2, int n) {
        cY2.gO = n;
    }
}
