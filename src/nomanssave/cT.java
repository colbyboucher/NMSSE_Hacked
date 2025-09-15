/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import java.awt.Component;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import nomanssave.Application;
import nomanssave.cU;
import nomanssave.cV;

public class cT
extends JFileChooser {
    private static cT gv = null;
    private static final String name = "Ship Export File";
    private static final ImageIcon fH = Application.a("UI-SHIPICON.PNG", 16, 16);
    private JCheckBox fO;

    public static cT aC() {
        if (gv == null) {
            gv = new cT();
        }
        return gv;
    }

    private cT() {
        this.setFileSelectionMode(0);
        this.setAcceptAllFileFilterUsed(false);
        this.setFileView(new cU(this));
        this.setFileFilter(new cV(this));
        this.setDialogTitle("Choose Ship Export File");
        JPanel jPanel = new JPanel();
        jPanel.setLayout(new BoxLayout(jPanel, 1));
        jPanel.setBorder(BorderFactory.createEmptyBorder(2, 5, 2, 2));
        jPanel.add(new JLabel("Export Options:"));
        this.fO = new JCheckBox("Products/Substances");
        jPanel.add(this.fO);
        this.setAccessory(jPanel);
        UIManager.addPropertyChangeListener(propertyChangeEvent -> {
            if ("lookAndFeel".equals(propertyChangeEvent.getPropertyName())) {
                SwingUtilities.updateComponentTreeUI(this);
            }
        });
    }

    public boolean aw() {
        return this.fO.isSelected();
    }

    @Override
    public int showSaveDialog(Component component) {
        this.getAccessory().setVisible(true);
        return super.showSaveDialog(component);
    }

    @Override
    public int showOpenDialog(Component component) {
        this.getAccessory().setVisible(false);
        return super.showOpenDialog(component);
    }

    static /* synthetic */ ImageIcon as() {
        return fH;
    }
}
