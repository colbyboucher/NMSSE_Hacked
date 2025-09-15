/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import nomanssave.Application;
import nomanssave.cq;
import nomanssave.cr;

public class cp
extends JFileChooser {
    private static cp fJ = null;
    private static final String name = "Companion Export File";
    private static final ImageIcon fK = Application.a("UI-PET.PNG", 16, 16);
    private static final ImageIcon fL = Application.a("UI-EGG.PNG", 16, 16);

    public static cp at() {
        if (fJ == null) {
            fJ = new cp();
        }
        return fJ;
    }

    private cp() {
        this.setFileSelectionMode(0);
        this.setAcceptAllFileFilterUsed(false);
        this.setFileView(new cq(this));
        this.setFileFilter(new cr(this));
        this.setDialogTitle("Choose Companion Export File");
        UIManager.addPropertyChangeListener(propertyChangeEvent -> {
            if ("lookAndFeel".equals(propertyChangeEvent.getPropertyName())) {
                SwingUtilities.updateComponentTreeUI(this);
            }
        });
    }

    static /* synthetic */ ImageIcon as() {
        return fK;
    }

    static /* synthetic */ ImageIcon au() {
        return fL;
    }
}
