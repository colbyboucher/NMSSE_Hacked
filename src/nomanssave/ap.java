/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.DefaultCellEditor;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import nomanssave.Application;
import nomanssave.aA;
import nomanssave.aB;
import nomanssave.aC;
import nomanssave.aq;
import nomanssave.ar;
import nomanssave.as;
import nomanssave.at;
import nomanssave.au;
import nomanssave.av;
import nomanssave.aw;
import nomanssave.ax;
import nomanssave.ay;
import nomanssave.az;
import nomanssave.eV;
import nomanssave.gz;

public class ap
extends JPanel {
    private final JTable ci;
    private final TableRowSorter cj;
    private final JTable ck;
    private final TableRowSorter cl;
    private final JCheckBox[] cm;
    private final JTable cn;
    private final TableRowSorter co;
    private gz cp;
    private eV cq;
    private eV cr;
    private eV cs;
    private ArrayList ct = new ArrayList();

    ap(Application application) {
        GridLayout gridLayout = new GridLayout(2, 2);
        this.setLayout(gridLayout);
        JPanel jPanel = new JPanel();
        this.add(jPanel);
        jPanel.setLayout(new FormLayout(new ColumnSpec[]{FormFactory.LABEL_COMPONENT_GAP_COLSPEC, ColumnSpec.decode("default:grow"), FormFactory.LABEL_COMPONENT_GAP_COLSPEC}, new RowSpec[]{FormFactory.LINE_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC, FormFactory.LINE_GAP_ROWSPEC, RowSpec.decode("200px:grow"), FormFactory.LINE_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC, FormFactory.LINE_GAP_ROWSPEC}));
        JLabel jLabel = new JLabel("Known Technology");
        jLabel.putClientProperty("FlatLaf.styleClass", "semibold");
        jPanel.add((Component)jLabel, "2, 2");
        JScrollPane jScrollPane = new JScrollPane();
        jPanel.add((Component)jScrollPane, "2, 4, fill, fill");
        this.ci = new JTable();
        this.ci.setSelectionMode(2);
        this.ci.setModel(new aq(this));
        this.ci.getColumnModel().getColumn(0).setMaxWidth(24);
        this.ci.getColumnModel().getColumn(0).setCellRenderer(new aB(this, null));
        this.cj = new TableRowSorter<TableModel>(this.ci.getModel());
        this.cj.setSortable(0, false);
        this.ci.setRowSorter(this.cj);
        jScrollPane.setViewportView(this.ci);
        JPanel jPanel2 = new JPanel();
        jPanel2.setLayout(new FlowLayout());
        jPanel.add((Component)jPanel2, "2, 6, fill, default");
        JButton jButton = new JButton();
        jButton.setText("Add Technology");
        jButton.addActionListener(new as(this));
        jPanel2.add(jButton);
        JButton jButton2 = new JButton();
        jButton2.setText("Remove Selected");
        jButton2.addActionListener(new at(this));
        jPanel2.add(jButton2);
        JPanel jPanel3 = new JPanel();
        this.add(jPanel3);
        jPanel3.setLayout(new FormLayout(new ColumnSpec[]{FormFactory.LABEL_COMPONENT_GAP_COLSPEC, ColumnSpec.decode("default:grow"), FormFactory.LABEL_COMPONENT_GAP_COLSPEC}, new RowSpec[]{FormFactory.LINE_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC, FormFactory.LINE_GAP_ROWSPEC, RowSpec.decode("200px:grow"), FormFactory.LINE_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC, FormFactory.LINE_GAP_ROWSPEC}));
        jLabel = new JLabel("Known Products");
        jLabel.putClientProperty("FlatLaf.styleClass", "semibold");
        jPanel3.add((Component)jLabel, "2, 2");
        JScrollPane jScrollPane2 = new JScrollPane();
        jPanel3.add((Component)jScrollPane2, "2, 4, fill, fill");
        this.ck = new JTable();
        this.ck.setSelectionMode(2);
        this.ck.setModel(new au(this));
        this.ck.getColumnModel().getColumn(0).setMaxWidth(24);
        this.ck.getColumnModel().getColumn(0).setCellRenderer(new aB(this, null));
        this.cl = new TableRowSorter<TableModel>(this.ck.getModel());
        this.cl.setSortable(0, false);
        this.ck.setRowSorter(this.cl);
        jScrollPane2.setViewportView(this.ck);
        jPanel2 = new JPanel();
        jPanel2.setLayout(new FlowLayout());
        jPanel3.add((Component)jPanel2, "2, 6, fill, default");
        JButton jButton3 = new JButton();
        jButton3.setText("Add Product");
        jButton3.addActionListener(new av(this));
        jPanel2.add(jButton3);
        JButton jButton4 = new JButton();
        jButton4.setText("Remove Selected");
        jButton4.addActionListener(new aw(this));
        jPanel2.add(jButton4);
        JPanel jPanel4 = new JPanel();
        this.add(jPanel4);
        jPanel4.setLayout(new FormLayout(new ColumnSpec[]{FormFactory.LABEL_COMPONENT_GAP_COLSPEC, ColumnSpec.decode("default:grow"), FormFactory.LABEL_COMPONENT_GAP_COLSPEC}, new RowSpec[]{FormFactory.LINE_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC, FormFactory.LINE_GAP_ROWSPEC, RowSpec.decode("200px:grow"), FormFactory.LINE_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC, FormFactory.LINE_GAP_ROWSPEC}));
        jLabel = new JLabel("Known Words");
        jLabel.putClientProperty("FlatLaf.styleClass", "semibold");
        jPanel4.add((Component)jLabel, "2, 2");
        JScrollPane jScrollPane3 = new JScrollPane();
        jPanel4.add((Component)jScrollPane3, "2, 4, fill, fill");
        this.cn = new JTable();
        this.cn.setCellSelectionEnabled(false);
        this.cn.getColumnModel().setColumnMargin(2);
        this.cn.setModel(new ax(this));
        this.cn.getTableHeader().getColumnModel().getColumn(0).setHeaderRenderer(new aA(this.cn, 2));
        this.cn.getTableHeader().getColumnModel().getColumn(1).setHeaderRenderer(new aA(this.cn, 2));
        JCheckBox jCheckBox = new JCheckBox();
        jCheckBox.setHorizontalAlignment(0);
        int n = 2;
        while (n < this.cn.getColumnCount()) {
            this.cn.getColumnModel().getColumn(n).setMaxWidth(80);
            this.cn.getTableHeader().getColumnModel().getColumn(n).setHeaderRenderer(new aA(this.cn, 0));
            this.cn.getColumnModel().getColumn(n).setCellEditor(new DefaultCellEditor(jCheckBox));
            this.cn.getColumnModel().getColumn(n).setCellRenderer(new aC());
            ++n;
        }
        this.co = new TableRowSorter<TableModel>(this.cn.getModel());
        n = 2;
        while (n < this.cn.getModel().getColumnCount()) {
            this.co.setSortable(n, false);
            ++n;
        }
        this.cn.setRowSorter(this.co);
        jScrollPane3.setViewportView(this.cn);
        jPanel2 = new JPanel();
        jPanel2.setLayout(new FlowLayout());
        jPanel4.add((Component)jPanel2, "2, 6, fill, default");
        JButton jButton5 = new JButton();
        jButton5.setText("Learn All");
        jButton5.addActionListener(new ay(this));
        jPanel2.add(jButton5);
        JButton jButton6 = new JButton();
        jButton6.setText("Unlearn All");
        jButton6.addActionListener(new az(this));
        jPanel2.add(jButton6);
        JPanel jPanel5 = new JPanel();
        this.add(jPanel5);
        jPanel5.setLayout(new FormLayout(new ColumnSpec[]{FormFactory.LABEL_COMPONENT_GAP_COLSPEC, ColumnSpec.decode("default:grow"), FormFactory.LABEL_COMPONENT_GAP_COLSPEC}, new RowSpec[]{FormFactory.LINE_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC, FormFactory.LINE_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC, FormFactory.LINE_GAP_ROWSPEC}));
        jLabel = new JLabel("Known Glyphs");
        jLabel.putClientProperty("FlatLaf.styleClass", "semibold");
        jPanel5.add((Component)jLabel, "2, 2");
        JPanel jPanel6 = new JPanel();
        jPanel6.putClientProperty("FlatLaf.styleClass", "glyphs");
        jPanel5.add((Component)jPanel6, "2, 4, fill, fill");
        jPanel6.setLayout(new FormLayout(new ColumnSpec[]{FormFactory.LABEL_COMPONENT_GAP_COLSPEC, FormFactory.DEFAULT_COLSPEC, FormFactory.DEFAULT_COLSPEC, FormFactory.LABEL_COMPONENT_GAP_COLSPEC, FormFactory.DEFAULT_COLSPEC, FormFactory.DEFAULT_COLSPEC, FormFactory.LABEL_COMPONENT_GAP_COLSPEC, FormFactory.DEFAULT_COLSPEC, FormFactory.DEFAULT_COLSPEC, FormFactory.LABEL_COMPONENT_GAP_COLSPEC, FormFactory.DEFAULT_COLSPEC, FormFactory.DEFAULT_COLSPEC}, new RowSpec[]{FormFactory.LINE_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC, FormFactory.LINE_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC, FormFactory.LINE_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC, FormFactory.LINE_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC}));
        this.cm = new JCheckBox[16];
        int n2 = 0;
        while (n2 < 16) {
            int n3 = n2 % 4 * 3 + 2;
            int n4 = n2 / 4 * 2 + 2;
            this.cm[n2] = new JCheckBox();
            this.cm[n2].setBackground(jPanel6.getBackground());
            this.cm[n2].addActionListener(new ar(this));
            ImageIcon imageIcon = Application.a("UI-GLYPH" + (n2 + 1) + ".PNG");
            jLabel = imageIcon == null ? new JLabel(Integer.toString(n2 + 1)) : new JLabel(imageIcon);
            jPanel6.add((Component)this.cm[n2], String.valueOf(n3) + ", " + n4);
            jPanel6.add((Component)jLabel, String.valueOf(n3 + 1) + ", " + n4);
            ++n2;
        }
    }

    private void R() {
        if (this.cp == null) {
            return;
        }
        int n = 0;
        int n2 = 0;
        while (n2 < 16) {
            if (this.cm[n2].isSelected()) {
                n |= 1 << n2;
            }
            ++n2;
        }
        this.cp.aE(n);
    }

    public void a(gz gz2) {
        String string;
        int n;
        this.cp = gz2;
        this.cq = gz2 == null ? null : gz2.dQ();
        this.cr = gz2 == null ? null : gz2.dR();
        this.cs = gz2 == null ? null : gz2.dS();
        this.ct = new ArrayList();
        if (this.cr != null) {
            n = 0;
            while (n < this.cr.size()) {
                string = this.cr.X(n);
                if (!this.ct.contains(string)) {
                    this.ct.add(string);
                }
                ++n;
            }
        }
        if (this.cs != null) {
            n = 0;
            while (n < this.cs.size()) {
                string = this.cs.X(n);
                if (!this.ct.contains(string)) {
                    this.ct.add(string);
                }
                ++n;
            }
        }
        this.ci.clearSelection();
        this.cj.allRowsChanged();
        this.ci.updateUI();
        this.ck.clearSelection();
        this.cl.allRowsChanged();
        this.ck.updateUI();
        n = gz2 == null ? 0 : gz2.dP();
        int n2 = 0;
        while (n2 < 16) {
            int n3 = 1 << n2;
            this.cm[n2].setSelected((n & n3) == n3);
            ++n2;
        }
        this.co.allRowsChanged();
        this.cn.updateUI();
    }

    static /* synthetic */ eV a(ap ap2) {
        return ap2.cq;
    }

    static /* synthetic */ TableRowSorter b(ap ap2) {
        return ap2.cj;
    }

    static /* synthetic */ JTable c(ap ap2) {
        return ap2.ci;
    }

    static /* synthetic */ ArrayList d(ap ap2) {
        return ap2.ct;
    }

    static /* synthetic */ eV e(ap ap2) {
        return ap2.cs;
    }

    static /* synthetic */ eV f(ap ap2) {
        return ap2.cr;
    }

    static /* synthetic */ TableRowSorter g(ap ap2) {
        return ap2.cl;
    }

    static /* synthetic */ JTable h(ap ap2) {
        return ap2.ck;
    }

    static /* synthetic */ gz i(ap ap2) {
        return ap2.cp;
    }

    static /* synthetic */ JTable j(ap ap2) {
        return ap2.cn;
    }

    static /* synthetic */ void k(ap ap2) {
        ap2.R();
    }
}
