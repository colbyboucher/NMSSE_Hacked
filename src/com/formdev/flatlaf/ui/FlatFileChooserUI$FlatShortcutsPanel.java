/*
 * Decompiled with CFR 0.152.
 */
package com.formdev.flatlaf.ui;

import com.formdev.flatlaf.ui.FlatFileChooserUI;
import com.formdev.flatlaf.util.LoggingFacade;
import com.formdev.flatlaf.util.ScaledImageIcon;
import com.formdev.flatlaf.util.SystemInfo;
import com.formdev.flatlaf.util.UIScale;
import java.awt.Dimension;
import java.awt.Image;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.lang.reflect.Method;
import java.util.function.Function;
import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;
import javax.swing.UIManager;
import javax.swing.filechooser.FileSystemView;

public static class FlatFileChooserUI.FlatShortcutsPanel
extends JToolBar
implements PropertyChangeListener {
    private final JFileChooser fc;
    private final Dimension buttonSize;
    private final Dimension iconSize;
    private final Function<File[], File[]> filesFunction;
    private final Function<File, String> displayNameFunction;
    private final Function<File, Icon> iconFunction;
    protected final File[] files;
    protected final JToggleButton[] buttons;
    protected final ButtonGroup buttonGroup;

    public FlatFileChooserUI.FlatShortcutsPanel(JFileChooser fc) {
        super(1);
        this.fc = fc;
        this.setFloatable(false);
        this.buttonSize = UIScale.scale(this.getUIDimension("FileChooser.shortcuts.buttonSize", 84, 64));
        this.iconSize = this.getUIDimension("FileChooser.shortcuts.iconSize", 32, 32);
        this.filesFunction = (Function)UIManager.get("FileChooser.shortcuts.filesFunction");
        this.displayNameFunction = (Function)UIManager.get("FileChooser.shortcuts.displayNameFunction");
        this.iconFunction = (Function)UIManager.get("FileChooser.shortcuts.iconFunction");
        FileSystemView fsv = fc.getFileSystemView();
        File[] files = this.getChooserShortcutPanelFiles(fsv);
        if (this.filesFunction != null) {
            files = this.filesFunction.apply(files);
        }
        this.files = files;
        this.buttons = new JToggleButton[files.length];
        this.buttonGroup = new ButtonGroup();
        for (int i = 0; i < files.length; ++i) {
            if (fsv.isFileSystemRoot(files[i])) {
                files[i] = fsv.createFileObject(files[i].getAbsolutePath());
            }
            File file = files[i];
            String name = this.getDisplayName(fsv, file);
            Icon icon = this.getIcon(fsv, file);
            int lastSepIndex = name.lastIndexOf(File.separatorChar);
            if (lastSepIndex >= 0 && lastSepIndex < name.length() - 1) {
                name = name.substring(lastSepIndex + 1);
            }
            if (icon instanceof ImageIcon) {
                icon = new ScaledImageIcon((ImageIcon)icon, this.iconSize.width, this.iconSize.height);
            } else if (icon != null) {
                icon = new FlatFileChooserUI.ShortcutIcon(icon, this.iconSize.width, this.iconSize.height);
            }
            JToggleButton button = this.createButton(name, icon);
            button.addActionListener(e -> fc.setCurrentDirectory(file));
            this.add(button);
            this.buttonGroup.add(button);
            this.buttons[i] = button;
        }
        this.directoryChanged(fc.getCurrentDirectory());
    }

    private Dimension getUIDimension(String key, int defaultWidth, int defaultHeight) {
        Dimension size = UIManager.getDimension(key);
        if (size == null) {
            size = new Dimension(defaultWidth, defaultHeight);
        }
        return size;
    }

    protected JToggleButton createButton(String name, Icon icon) {
        JToggleButton button = new JToggleButton(name, icon);
        button.setVerticalTextPosition(3);
        button.setHorizontalTextPosition(0);
        button.setAlignmentX(0.5f);
        button.setIconTextGap(0);
        button.setPreferredSize(this.buttonSize);
        button.setMaximumSize(this.buttonSize);
        return button;
    }

    protected File[] getChooserShortcutPanelFiles(FileSystemView fsv) {
        try {
            if (SystemInfo.isJava_12_orLater) {
                Method m = fsv.getClass().getMethod("getChooserShortcutPanelFiles", new Class[0]);
                File[] files = (File[])m.invoke(fsv, new Object[0]);
                if (files.length == 1 && files[0].equals(new File(System.getProperty("user.home")))) {
                    files = new File[]{};
                }
                return files;
            }
            if (SystemInfo.isWindows) {
                Class<?> cls = Class.forName("sun.awt.shell.ShellFolder");
                Method m = cls.getMethod("get", String.class);
                return (File[])m.invoke(null, "fileChooserShortcutPanelFolders");
            }
        }
        catch (IllegalAccessException cls) {
        }
        catch (Exception ex) {
            LoggingFacade.INSTANCE.logSevere(null, ex);
        }
        return new File[0];
    }

    protected String getDisplayName(FileSystemView fsv, File file) {
        String name;
        if (this.displayNameFunction != null && (name = this.displayNameFunction.apply(file)) != null) {
            return name;
        }
        return fsv.getSystemDisplayName(file);
    }

    protected Icon getIcon(FileSystemView fsv, File file) {
        Icon icon;
        if (this.iconFunction != null && (icon = this.iconFunction.apply(file)) != null) {
            return icon;
        }
        try {
            Class<?> cls;
            if (SystemInfo.isJava_17_orLater) {
                Method m = fsv.getClass().getMethod("getSystemIcon", File.class, Integer.TYPE, Integer.TYPE);
                return (Icon)m.invoke(fsv, file, this.iconSize.width, this.iconSize.height);
            }
            if ((this.iconSize.width > 16 || this.iconSize.height > 16) && (cls = Class.forName("sun.awt.shell.ShellFolder")).isInstance(file)) {
                Method m = file.getClass().getMethod("getIcon", Boolean.TYPE);
                m.setAccessible(true);
                Image image = (Image)m.invoke(file, true);
                if (image != null) {
                    return new ImageIcon(image);
                }
            }
        }
        catch (IllegalAccessException cls) {
        }
        catch (Exception ex) {
            LoggingFacade.INSTANCE.logSevere(null, ex);
        }
        return fsv.getSystemIcon(file);
    }

    protected void directoryChanged(File file) {
        if (file != null) {
            String absolutePath = file.getAbsolutePath();
            for (int i = 0; i < this.files.length; ++i) {
                if (!this.files[i].equals(file) && !this.files[i].getAbsolutePath().equals(absolutePath)) continue;
                this.buttons[i].setSelected(true);
                return;
            }
        }
        this.buttonGroup.clearSelection();
    }

    @Override
    public void propertyChange(PropertyChangeEvent e) {
        switch (e.getPropertyName()) {
            case "directoryChanged": {
                this.directoryChanged(this.fc.getCurrentDirectory());
            }
        }
    }
}
