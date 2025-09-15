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
import java.awt.FlowLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import nomanssave.G;
import nomanssave.aH;
import nomanssave.bb;
import nomanssave.bc;

public class ba
extends JPanel {
    private final FormLayout dA = new FormLayout(new ColumnSpec[]{FormFactory.LABEL_COMPONENT_GAP_COLSPEC}, new RowSpec[]{FormFactory.LINE_GAP_ROWSPEC});

    ba() {
        this(aH.cH, 0);
    }

    ba(int ... nArray) {
        int n = 0;
        while (n < nArray.length) {
            if (nArray[n] > 0) {
                this.dA.appendColumn(ColumnSpec.decode(String.valueOf(nArray[n]) + "px"));
            } else {
                this.dA.appendColumn(ColumnSpec.decode("default:grow"));
            }
            this.dA.appendColumn(FormFactory.LABEL_COMPONENT_GAP_COLSPEC);
            ++n;
        }
        this.setLayout(this.dA);
    }

    void k(String string) {
        this.a(string, (ImageIcon)null);
    }

    void a(String string, ImageIcon imageIcon) {
        int n;
        if (this.dA.getRowCount() == 1) {
            this.dA.appendRow(FormFactory.DEFAULT_ROWSPEC);
            this.dA.appendRow(FormFactory.LINE_GAP_ROWSPEC);
        } else {
            n = this.dA.getRowCount();
            this.dA.insertRow(n, FormFactory.DEFAULT_ROWSPEC);
            this.dA.insertRow(n, RowSpec.decode("bottom:25px"));
        }
        n = this.dA.getColumnCount() - 2;
        JLabel jLabel = new JLabel(string);
        jLabel.putClientProperty("FlatLaf.styleClass", "semibold");
        if (imageIcon == null) {
            this.add((Component)jLabel, "2, " + (this.dA.getRowCount() - 1) + ", " + n + ", 1, left, default");
        } else {
            JPanel jPanel = new JPanel();
            jPanel.setLayout(new FlowLayout(0, 0, 0));
            jPanel.add(new JLabel(imageIcon));
            jPanel.add(jLabel);
            this.add((Component)jPanel, "2, " + (this.dA.getRowCount() - 1) + ", " + n + ", 1, left, default");
        }
    }

    void addText(String string) {
        int n;
        if (this.dA.getRowCount() == 1) {
            this.dA.appendRow(FormFactory.DEFAULT_ROWSPEC);
            this.dA.appendRow(FormFactory.LINE_GAP_ROWSPEC);
        } else {
            n = this.dA.getRowCount();
            this.dA.insertRow(n, FormFactory.DEFAULT_ROWSPEC);
            this.dA.insertRow(n, RowSpec.decode("bottom:25px"));
        }
        n = this.dA.getColumnCount() - 2;
        JLabel jLabel = new JLabel(string);
        this.add((Component)jLabel, "2, " + (this.dA.getRowCount() - 1) + ", " + n + ", 1, left, default");
    }

    void Y() {
        this.dA.appendRow(RowSpec.decode("bottom:10px"));
        this.dA.appendRow(FormFactory.LINE_GAP_ROWSPEC);
    }

    void a(String string, JComponent jComponent) {
        this.a(string, false, jComponent, 1);
    }

    void a(String string, JComponent jComponent, int n) {
        this.a(string, false, jComponent, n);
    }

    void a(String string, boolean bl, JComponent jComponent) {
        this.a(string, bl, jComponent, 1);
    }

    void a(String string, boolean bl, JComponent jComponent, int n) {
        n = n * 2 - 1;
        this.dA.appendRow(FormFactory.DEFAULT_ROWSPEC);
        this.dA.appendRow(FormFactory.LINE_GAP_ROWSPEC);
        int n2 = this.dA.getRowCount() - 1;
        if (string != null) {
            JLabel jLabel = new JLabel(String.valueOf(string) + ":");
            if (bl) {
                jLabel.putClientProperty("FlatLaf.styleClass", "semibold");
            }
            this.add((Component)jLabel, "2, " + n2 + ", left, default");
        }
        this.add((Component)jComponent, "4, " + n2 + ", " + n + ", 1, fill, default");
    }

    void a(String string, G g) {
        JPanel jPanel = new JPanel();
        jPanel.setLayout(new BorderLayout(0, 0));
        JPanel jPanel2 = new JPanel();
        jPanel2.setLayout(new FlowLayout(2, 0, 0));
        JButton jButton = new JButton("Generate");
        jButton.setEnabled(g.isEnabled());
        jButton.addActionListener(new bb(this, g));
        g.addPropertyChangeListener("enabled", new bc(this, jButton, g));
        jPanel2.add(jButton);
        jPanel.add((Component)g, "Center");
        jPanel.add((Component)jPanel2, "South");
        this.a(string, jPanel);
    }

    void a(JComponent jComponent) {
        this.dA.appendRow(FormFactory.DEFAULT_ROWSPEC);
        this.dA.appendRow(FormFactory.LINE_GAP_ROWSPEC);
        int n = this.dA.getColumnCount() - 2;
        int n2 = this.dA.getRowCount() - 1;
        this.add((Component)jComponent, "2, " + n2 + ", " + n + ", 1, fill, default");
    }
}
