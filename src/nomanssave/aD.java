/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import java.awt.Container;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.Frame;
import java.util.stream.Stream;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import nomanssave.aE;
import nomanssave.aF;
import nomanssave.aG;
import nomanssave.aH;
import nomanssave.aI;
import nomanssave.ba;

public class aD
extends JDialog {
    private JComboBox cw;
    private JTextField cx;
    private boolean cy;
    public static aD cz = null;

    private aD(Frame frame) {
        super(frame);
        this.setMinimumSize(new Dimension(400, 10));
        this.setModalExclusionType(Dialog.ModalExclusionType.APPLICATION_EXCLUDE);
        this.setTitle("Editor Settings");
        this.setModal(true);
        ba ba2 = new ba();
        this.cw = new JComboBox();
        this.cw.setModel(new aE(this));
        ba2.a("Look & Feel", this.cw);
        this.cx = new JTextField();
        ba2.a("Inventory Scale", this.cx);
        ba2.Y();
        JPanel jPanel = new JPanel();
        ba2.a(jPanel);
        JButton jButton = new JButton("Apply");
        jButton.addActionListener(new aF(this));
        jPanel.add(jButton);
        JButton jButton2 = new JButton("Cancel");
        jButton2.addActionListener(new aG(this));
        jPanel.add(jButton2);
        this.setContentPane(ba2);
        this.pack();
    }

    private boolean S() {
        String string = aH.getProperty("LookAndFeel");
        aI aI3 = Stream.of(aI.values()).filter(aI2 -> aI2.name().equalsIgnoreCase(string)).findFirst().orElse(aI.cN);
        this.cw.setSelectedItem((Object)aI3);
        this.cx.setText(Double.toString(aH.a("InventoryScaling", 1.0)));
        this.setLocationRelativeTo(this.getParent());
        this.cy = false;
        this.setVisible(true);
        return this.cy;
    }

    public static boolean d(Container container) {
        if (cz == null) {
            Frame frame = JOptionPane.getFrameForComponent(container);
            cz = new aD(frame);
        }
        return cz.S();
    }

    static /* synthetic */ JComboBox a(aD aD2) {
        return aD2.cw;
    }

    static /* synthetic */ void a(aD aD2, boolean bl) {
        aD2.cy = bl;
    }

    static /* synthetic */ JTextField b(aD aD2) {
        return aD2.cx;
    }
}
