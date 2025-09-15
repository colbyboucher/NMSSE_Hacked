/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import nomanssave.Application;
import nomanssave.cw;
import nomanssave.cx;

public class cv
extends JFileChooser {
    private static cv fQ = null;
    private static final String name = "Weapon Export File";
    private static final ImageIcon fH = Application.a("UI-WEAPONICON.PNG", 16, 16);

    public static cv ax() {
        if (fQ == null) {
            fQ = new cv();
        }
        return fQ;
    }

    private cv() {
        this.setFileSelectionMode(0);
        this.setAcceptAllFileFilterUsed(false);
        this.setFileView(new cw(this));
        this.setFileFilter(new cx(this));
        this.setDialogTitle("Choose Weapon Export File");
        UIManager.addPropertyChangeListener(propertyChangeEvent -> {
            if ("lookAndFeel".equals(propertyChangeEvent.getPropertyName())) {
                SwingUtilities.updateComponentTreeUI(this);
            }
        });
    }

    static /* synthetic */ ImageIcon as() {
        return fH;
    }
}
