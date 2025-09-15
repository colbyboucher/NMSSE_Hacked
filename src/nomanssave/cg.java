/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dialog;
import java.awt.Frame;
import java.util.stream.Collectors;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import nomanssave.G;
import nomanssave.ch;
import nomanssave.ci;
import nomanssave.cj;
import nomanssave.ck;
import nomanssave.ey;
import nomanssave.fg;
import nomanssave.gQ;
import nomanssave.hc;
import nomanssave.hf;

public class cg
extends JDialog {
    private JTextField fn;
    private JLabel fo;
    private JTextField fp;
    private JTextField fq;
    private JLabel fr;
    private JTextField fs;
    private G ft;
    private JLabel fu;
    private G fv;
    private JTextField fw;
    private JTextField fx;
    private JTextArea fy;
    private JTextArea fz;
    private ey fA;
    private gQ fB;
    private Integer fC;
    private Integer fD;
    public static cg fE = null;

    private cg(Frame frame) {
        super(frame);
        this.setSize(600, 480);
        this.setModalExclusionType(Dialog.ModalExclusionType.APPLICATION_EXCLUDE);
        this.setTitle("Item Details");
        this.setModal(true);
        JPanel jPanel = new JPanel();
        jPanel.setLayout(new FormLayout(new ColumnSpec[]{FormFactory.LABEL_COMPONENT_GAP_COLSPEC, ColumnSpec.decode("100px"), FormFactory.LABEL_COMPONENT_GAP_COLSPEC, ColumnSpec.decode("default:grow"), FormFactory.LABEL_COMPONENT_GAP_COLSPEC, ColumnSpec.decode("100px"), FormFactory.LABEL_COMPONENT_GAP_COLSPEC}, new RowSpec[]{FormFactory.LINE_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC, FormFactory.LINE_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC, FormFactory.LINE_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC, FormFactory.LINE_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC, FormFactory.LINE_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC, FormFactory.LINE_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC, FormFactory.LINE_GAP_ROWSPEC, RowSpec.decode("64px"), FormFactory.LINE_GAP_ROWSPEC, RowSpec.decode("default:grow"), FormFactory.LINE_GAP_ROWSPEC}));
        jPanel.add((Component)new JLabel("Type:"), "2, 2, left, center");
        this.fn = new JTextField();
        this.fn.setEditable(false);
        jPanel.add((Component)this.fn, "4, 2, fill, default");
        this.fo = new JLabel("");
        jPanel.add((Component)this.fo, "6, 2, 1, 7, center, fill");
        jPanel.add((Component)new JLabel("Category:"), "2, 4, left, center");
        this.fp = new JTextField();
        this.fp.setEditable(false);
        jPanel.add((Component)this.fp, "4, 4, fill, default");
        jPanel.add((Component)new JLabel("Name:"), "2, 6, left, center");
        this.fq = new JTextField();
        this.fq.setEditable(false);
        jPanel.add((Component)this.fq, "4, 6, fill, default");
        jPanel.add((Component)new JLabel("ID:"), "2, 8, left, center");
        JPanel jPanel2 = new JPanel();
        jPanel2.setLayout(new FormLayout(new ColumnSpec[]{ColumnSpec.decode("default:grow"), FormFactory.DEFAULT_COLSPEC, ColumnSpec.decode("100px")}, new RowSpec[]{FormFactory.DEFAULT_ROWSPEC}));
        this.fs = new JTextField();
        this.fs.setEditable(false);
        jPanel2.add((Component)this.fs, "1, 1");
        this.fr = new JLabel("#");
        jPanel2.add((Component)this.fr, "2, 1");
        this.ft = new ch(this);
        this.ft.setEditable(false);
        jPanel2.add((Component)this.ft, "3, 1");
        jPanel.add((Component)jPanel2, "4, 8, fill, default");
        this.fu = new JLabel("Quantity:");
        jPanel.add((Component)this.fu, "2, 10, left, center");
        jPanel2 = new JPanel();
        jPanel2.setLayout(new FormLayout(new ColumnSpec[]{ColumnSpec.decode("100px"), FormFactory.DEFAULT_COLSPEC, ColumnSpec.decode("100px")}, new RowSpec[]{FormFactory.DEFAULT_ROWSPEC}));
        this.fv = new ci(this);
        this.fv.setEditable(false);
        jPanel2.add((Component)this.fv, "1, 1");
        jPanel2.add((Component)new JLabel("/"), "2, 1");
        this.fw = new JTextField();
        this.fw.setEditable(false);
        jPanel2.add((Component)this.fw, "3, 1");
        jPanel.add((Component)jPanel2, "4, 10, fill, default");
        jPanel.add((Component)new JLabel("Subtitle:"), "2, 12, left, center");
        this.fx = new JTextField();
        this.fx.setEditable(false);
        jPanel.add((Component)this.fx, "4, 12, 3, 1, fill, default");
        jPanel.add((Component)new JLabel("Build Cost:"), "2, 14, left, top");
        JScrollPane jScrollPane = new JScrollPane();
        jScrollPane.setBorder(this.fx.getBorder());
        jScrollPane.setBackground(this.fx.getBackground());
        this.fy = new JTextArea();
        this.fy.setEditable(false);
        this.fy.setBorder(null);
        this.fy.setBackground(null);
        this.fy.setFont(this.fx.getFont());
        jScrollPane.setViewportView(this.fy);
        jPanel.add((Component)jScrollPane, "4, 14, 3, 1, fill, fill");
        jPanel.add((Component)new JLabel("Description:"), "2, 16, left, top");
        this.fz = new JTextArea();
        this.fz.setEditable(false);
        this.fz.setWrapStyleWord(true);
        this.fz.setLineWrap(true);
        this.fz.setBorder(this.fx.getBorder());
        this.fz.setBackground(this.fx.getBackground());
        this.fz.setFont(this.fx.getFont());
        jPanel.add((Component)this.fz, "4, 16, 3, 1, fill, fill");
        this.setContentPane(jPanel);
        this.getRootPane().registerKeyboardAction(new cj(this), KeyStroke.getKeyStroke(27, 0), 2);
        this.addWindowListener(new ck(this));
    }

    private void a(gQ gQ2) {
        String string;
        this.fB = gQ2;
        Object object = gQ2.dz();
        this.fA = ey.d(object);
        this.fC = null;
        this.fD = null;
        String string2 = this.fA == null ? gQ2.getType() : this.fA.ba().toString();
        this.fn.setText(string2);
        this.fo.setIcon(this.fA == null ? null : this.fA.N(2));
        if (this.fA != null && this.fA.bb()) {
            Object object2;
            string = "";
            if (object instanceof fg) {
                object2 = (fg)object;
                int n = ((fg)object2).indexOf(35);
                if (n >= 0) {
                    string = ((fg)object2).substring(n + 1);
                }
            } else {
                object2 = object.toString();
                int n = ((String)object2).indexOf(35);
                if (n >= 0) {
                    string = ((String)object2).substring(n + 1);
                }
            }
            this.fs.setText(this.fA.getID());
            this.ft.setText(string);
            this.fr.setVisible(true);
            this.ft.setVisible(true);
            try {
                int n = hf.b(string, 0, 99999);
                this.fC = new Integer(n);
                this.ft.setEditable(true);
            }
            catch (RuntimeException runtimeException) {
                hc.warn("Error detected in item id: " + object);
                this.fC = null;
                this.ft.setEditable(false);
            }
        } else {
            this.fs.setText(gQ2.ei());
            this.ft.setText("");
            this.fr.setVisible(false);
            this.ft.setVisible(false);
        }
        if (string2.equals("Technology") && gQ2.dA() >= 0 && gQ2.dA() < gQ2.dB()) {
            this.fu.setText("Charge:");
            this.fD = gQ2.dA();
            this.fv.setText(Integer.toString(gQ2.dA()));
            this.fw.setText(Integer.toString(gQ2.dB()));
            this.fv.setEditable(true);
        } else if ((string2.equals("Product") || string2.equals("Substance")) && gQ2.dB() > 1) {
            this.fu.setText("Quantity:");
            this.fD = gQ2.dA();
            this.fv.setText(Integer.toString(gQ2.dA()));
            this.fw.setText(Integer.toString(gQ2.dB()));
            this.fv.setEditable(true);
        } else {
            this.fu.setText("Quantity:");
            this.fv.setText("1");
            this.fw.setText("1");
            this.fv.setEditable(false);
        }
        this.fq.setText(this.fA == null ? "[Unknown]" : this.fA.getName());
        this.fp.setText(this.fA == null ? "[Unknown]" : this.fA.bc().toString());
        this.fx.setText(this.fA == null ? "" : this.fA.bg());
        String string3 = string = this.fA == null ? "" : this.fA.bk().stream().map(ez2 -> {
            ey ey2 = ey.d(ez2.getID());
            if (ey2 != null) {
                return String.valueOf(ey2.getName()) + " (x" + ez2.bo() + ")";
            }
            return String.valueOf(ez2.getID()) + " (x" + ez2.bo() + ")";
        }).collect(Collectors.joining("\n"));
        if (string.length() == 0) {
            string = "N/A";
        }
        this.fy.setText(string);
        this.fy.setCaretPosition(0);
        this.fz.setText(this.fA == null ? "" : this.fA.getDescription());
        this.setLocationRelativeTo(this.getParent());
        this.setVisible(true);
    }

    public static void a(Container container, gQ gQ2) {
        if (fE == null) {
            Frame frame = JOptionPane.getFrameForComponent(container);
            fE = new cg(frame);
        }
        fE.a(gQ2);
    }

    static /* synthetic */ Integer a(cg cg2) {
        return cg2.fC;
    }

    static /* synthetic */ gQ b(cg cg2) {
        return cg2.fB;
    }

    static /* synthetic */ ey c(cg cg2) {
        return cg2.fA;
    }

    static /* synthetic */ void a(cg cg2, Integer n) {
        cg2.fC = n;
    }

    static /* synthetic */ Integer d(cg cg2) {
        return cg2.fD;
    }

    static /* synthetic */ void b(cg cg2, Integer n) {
        cg2.fD = n;
    }

    static /* synthetic */ G e(cg cg2) {
        return cg2.ft;
    }

    static /* synthetic */ G f(cg cg2) {
        return cg2.fv;
    }
}
