/*
 * Decompiled with CFR 0.152.
 */
package com.formdev.flatlaf.ui;

import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.ui.FlatTabbedPaneUI;
import java.awt.Component;
import java.awt.KeyboardFocusManager;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.JTabbedPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.plaf.TabbedPaneUI;

private static class FlatTabbedPaneUI.FlatSelectedTabRepainter
implements PropertyChangeListener {
    private static FlatTabbedPaneUI.FlatSelectedTabRepainter instance;
    private KeyboardFocusManager keyboardFocusManager = KeyboardFocusManager.getCurrentKeyboardFocusManager();

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    static void install() {
        Class<FlatTabbedPaneUI.FlatSelectedTabRepainter> clazz = FlatTabbedPaneUI.FlatSelectedTabRepainter.class;
        synchronized (FlatTabbedPaneUI.FlatSelectedTabRepainter.class) {
            if (instance != null) {
                // ** MonitorExit[var0] (shouldn't be in output)
                return;
            }
            instance = new FlatTabbedPaneUI.FlatSelectedTabRepainter();
            // ** MonitorExit[var0] (shouldn't be in output)
            return;
        }
    }

    FlatTabbedPaneUI.FlatSelectedTabRepainter() {
        this.keyboardFocusManager.addPropertyChangeListener(this);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void uninstall() {
        Class<FlatTabbedPaneUI.FlatSelectedTabRepainter> clazz = FlatTabbedPaneUI.FlatSelectedTabRepainter.class;
        synchronized (FlatTabbedPaneUI.FlatSelectedTabRepainter.class) {
            if (instance == null) {
                // ** MonitorExit[var1_1] (shouldn't be in output)
                return;
            }
            this.keyboardFocusManager.removePropertyChangeListener(this);
            this.keyboardFocusManager = null;
            instance = null;
            // ** MonitorExit[var1_1] (shouldn't be in output)
            return;
        }
    }

    @Override
    public void propertyChange(PropertyChangeEvent e) {
        if (!(UIManager.getLookAndFeel() instanceof FlatLaf)) {
            this.uninstall();
            return;
        }
        switch (e.getPropertyName()) {
            case "permanentFocusOwner": {
                Object oldValue = e.getOldValue();
                Object newValue = e.getNewValue();
                if (oldValue instanceof Component) {
                    this.repaintSelectedTabs((Component)oldValue);
                }
                if (!(newValue instanceof Component)) break;
                this.repaintSelectedTabs((Component)newValue);
                break;
            }
            case "activeWindow": {
                this.repaintSelectedTabs(this.keyboardFocusManager.getPermanentFocusOwner());
            }
        }
    }

    private void repaintSelectedTabs(Component c) {
        if (c instanceof JTabbedPane) {
            this.repaintSelectedTab((JTabbedPane)c);
        }
        while ((c = SwingUtilities.getAncestorOfClass(JTabbedPane.class, c)) != null) {
            this.repaintSelectedTab((JTabbedPane)c);
        }
    }

    private void repaintSelectedTab(JTabbedPane tabbedPane) {
        TabbedPaneUI ui = tabbedPane.getUI();
        if (ui instanceof FlatTabbedPaneUI) {
            ((FlatTabbedPaneUI)ui).repaintTab(tabbedPane.getSelectedIndex());
        }
    }
}
