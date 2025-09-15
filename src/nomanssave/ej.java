/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import nomanssave.Application;
import nomanssave.ek;
import nomanssave.el;
import nomanssave.hi;

public class ej
extends JFileChooser {
    private static final ImageIcon im = Application.a("UI-FILEICON.PNG", 16, 16);
    private static final ImageIcon io = Application.a("UI-GAMEPASS.PNG", 16, 16);
    private static final ImageIcon ip = Application.a("UI-STEAMLOGO.PNG", 16, 16);
    private static final Pattern iq = Pattern.compile("st_(\\d*)");
    private static ej ir = null;

    private ej() {
        this.setFileSelectionMode(2);
        this.setAcceptAllFileFilterUsed(false);
        this.setFileFilter(new ek(this));
        this.setFileView(new el(this));
        this.setDialogTitle("Choose Save Path");
        UIManager.addPropertyChangeListener(propertyChangeEvent -> {
            if ("lookAndFeel".equals(propertyChangeEvent.getPropertyName())) {
                SwingUtilities.updateComponentTreeUI(this);
            }
        });
    }

    private String a(File file) {
        Matcher matcher = iq.matcher(file.getName());
        if (matcher.matches()) {
            long l = Long.parseLong(matcher.group(1));
            return hi.h(l);
        }
        return null;
    }

    public static File b(File file) {
        if (ir == null) {
            ir = new ej();
        }
        if (file != null && file.exists()) {
            if (file.isFile()) {
                file = file.getParentFile();
            }
            ir.setCurrentDirectory(file);
        } else {
            File file2 = new File(System.getProperty("user.home"));
            File file3 = new File(file2, "AppData\\Roaming\\HelloGames\\NMS");
            File file4 = new File(file2, "AppData\\Local\\Packages\\HelloGames.NoMansSky_bs190hzg1sesy\\SystemAppData");
            if (file3.isDirectory()) {
                ir.setCurrentDirectory(file3);
            } else if (file4.isDirectory()) {
                ir.setCurrentDirectory(file4);
            } else {
                ir.setCurrentDirectory(file2);
            }
        }
        if (ir.showOpenDialog(null) == 0) {
            return ir.getSelectedFile();
        }
        return null;
    }

    static /* synthetic */ ImageIcon as() {
        return im;
    }

    static /* synthetic */ ImageIcon au() {
        return io;
    }

    static /* synthetic */ String a(ej ej2, File file) {
        return ej2.a(file);
    }

    static /* synthetic */ ImageIcon aR() {
        return ip;
    }
}
