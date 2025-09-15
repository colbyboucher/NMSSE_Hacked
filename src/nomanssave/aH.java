/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import com.formdev.flatlaf.FlatDarculaLaf;
import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatIntelliJLaf;
import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.FlatLightLaf;
import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import com.formdev.flatlaf.themes.FlatMacLightLaf;
import java.awt.Canvas;
import java.awt.Font;
import java.awt.FontMetrics;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Array;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.Properties;
import java.util.stream.Stream;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import nomanssave.Application;
import nomanssave.aI;
import nomanssave.eV;
import nomanssave.eY;
import nomanssave.fh;
import nomanssave.hc;
import nomanssave.hk;

public class aH {
    private static File cC;
    public static File cD;
    public static File cE;
    public static File cF;
    public static File cG;
    public static int cH;
    public static int cI;
    public static int cJ;
    private static eY cK;
    private static boolean cL;

    public static String getProperty(String string) {
        return cK.getValueAsString(string);
    }

    public static void setProperty(String string, String string2) {
        if (string2 == null) {
            cK.N(string);
        } else {
            cK.c(string, string2);
        }
        cL = true;
    }

    public static int j(String string) {
        return cK.J(string);
    }

    public static int a(String string, int n) {
        return cK.c(string, n);
    }

    public static void b(String string, int n) {
        cK.c(string, (Object)n);
        cL = true;
    }

    public static double a(String string, double d) {
        return cK.c(string, d);
    }

    public static void b(String string, double d) {
        cK.c(string, (Object)d);
        cL = true;
    }

    public static Object[] a(String string, Class clazz) {
        eV eV2 = cK.d(string);
        if (eV2 == null) {
            return (Object[])Array.newInstance(clazz, 0);
        }
        Object object = Array.newInstance(clazz, eV2.size());
        int n = 0;
        while (n < eV2.size()) {
            Array.set(object, n, clazz.cast(eV2.getValue(n)));
            ++n;
        }
        return (Object[])object;
    }

    public static void a(String string, Object[] objectArray) {
        eV eV2 = new eV();
        int n = 0;
        while (n < objectArray.length) {
            eV2.f(objectArray[n]);
            ++n;
        }
        cK.c(string, eV2);
        cL = true;
    }

    static boolean T() {
        return cL;
    }

    static void U() {
        String string = fh.b(cK, true);
        try {
            Throwable throwable = null;
            Object var2_4 = null;
            try (FileOutputStream fileOutputStream = new FileOutputStream(cC);){
                fileOutputStream.write(string.getBytes("UTF-8"));
                cL = false;
            }
            catch (Throwable throwable2) {
                if (throwable == null) {
                    throwable = throwable2;
                } else if (throwable != throwable2) {
                    throwable.addSuppressed(throwable2);
                }
                throw throwable;
            }
        }
        catch (IOException iOException) {
            hc.error("Could not save configuration file", iOException);
        }
    }

    public static void init(boolean bl) {
        Object object;
        block23: {
            System.out.println("Initializing environment...");
            File file = null;
            try {
                object = Application.class.getProtectionDomain().getCodeSource().getLocation();
                file = bl && ((URL)object).getFile().endsWith(".jar") ? Paths.get(((URL)object).toURI()).toFile().getParentFile() : new File(".").getCanonicalFile();
            }
            catch (URISyntaxException uRISyntaxException) {
                System.out.println("Error: cannot find working directory");
                uRISyntaxException.printStackTrace();
                System.exit(1);
            }
            catch (IOException iOException) {
                System.out.println("Error: cannot find working directory");
                iOException.printStackTrace();
                System.exit(1);
            }
            if (!file.isDirectory()) {
                System.out.println("Error: working directory error: " + file.getAbsolutePath());
                System.exit(1);
            }
            cD = file;
            cC = new File(file, "NMSSaveEditor.conf");
            cE = new File(file, "bases");
            cF = new File(file, "exported");
            cG = new File(file, "backups");
            if (!cG.exists() && !cG.mkdir()) {
                System.out.println("Error: cannot create backups folder");
                System.exit(1);
            }
            hc.k(new File(file, "NMSSaveEditor.log"));
            hc.debug("Java Vendor: " + System.getProperty("java.vendor"));
            hc.debug("Java Version: " + System.getProperty("java.version"));
            hc.debug("Java Architecture: " + System.getProperty("os.arch"));
            hc.debug("Operating System: " + System.getProperty("os.name"));
            hc.debug("Working Dir: " + file.getAbsolutePath());
            cK = new eY();
            cL = false;
            if (cC.exists()) {
                try {
                    object = hk.l(cC);
                    if (((Object)object).length > 0 && object[0] == 123) {
                        cK = eY.E(new String((byte[])object, "UTF-8"));
                        break block23;
                    }
                    Properties properties = new Properties();
                    try (FileInputStream fileInputStream = new FileInputStream(cC);){
                        properties.load(fileInputStream);
                    }
                    eV eV2 = new eV();
                    for (String string : properties.stringPropertyNames()) {
                        try {
                            int n;
                            int n2;
                            int n3;
                            String string2 = properties.getProperty(string);
                            if (string.equals("InventoryFontScale")) continue;
                            if (string.equals("InventoryScaling")) {
                                cK.b("InventoryScaling", Double.parseDouble(string2));
                                continue;
                            }
                            if (string.equals("FontScaling")) {
                                cK.b("FontScaling", Double.parseDouble(string2));
                                continue;
                            }
                            if (string.endsWith(".Location")) {
                                string = string.substring(0, string.lastIndexOf("."));
                                n3 = string2.indexOf(44);
                                if (n3 <= 0) continue;
                                n2 = Integer.parseInt(string2.substring(0, n3));
                                n = Integer.parseInt(string2.substring(n3 + 1));
                                cK.c(String.valueOf(string) + ".X", (Object)n2);
                                cK.c(String.valueOf(string) + ".Y", (Object)n);
                                continue;
                            }
                            if (string.endsWith(".Size")) {
                                string = string.substring(0, string.lastIndexOf("."));
                                n3 = string2.indexOf(44);
                                if (n3 <= 0) continue;
                                n2 = Integer.parseInt(string2.substring(0, n3));
                                n = Integer.parseInt(string2.substring(n3 + 1));
                                cK.c(String.valueOf(string) + ".Width", (Object)n2);
                                cK.c(String.valueOf(string) + ".Height", (Object)n);
                                continue;
                            }
                            if (string.equals("JSONEditor.Divider")) {
                                n2 = Integer.parseInt(string2);
                                cK.c(string, (Object)n2);
                                continue;
                            }
                            if (string.startsWith("SteamID.")) {
                                string = string.substring(8);
                                eV2.f(Long.parseLong(string));
                                cK.c("KnownPlayers." + string, string2);
                                continue;
                            }
                            cK.c(string, string2);
                        }
                        catch (NumberFormatException numberFormatException) {
                            // empty catch block
                        }
                    }
                    if (eV2.size() > 0) {
                        cK.b("SteamIDs", eV2);
                    }
                    cL = true;
                }
                catch (IOException iOException) {
                    hc.a("Could not load configuration file", iOException);
                }
            }
        }
        if ((object = cK.getValueAsString("LogLevel")) != null) {
            hc.aA((String)object);
        }
        FlatLaf.registerCustomDefaultsSource("nomanssave");
        aH.V();
    }

    public static void V() {
        String string = cK.getValueAsString("LookAndFeel");
        aI aI3 = Stream.of(aI.values()).filter(aI2 -> aI2.name().equalsIgnoreCase(string)).findFirst().orElse(aI.cN);
        try {
            FlatLaf flatLaf;
            switch (aI3) {
                default: {
                    flatLaf = new FlatLightLaf();
                    break;
                }
                case cO: {
                    flatLaf = new FlatDarkLaf();
                    break;
                }
                case cP: {
                    flatLaf = new FlatIntelliJLaf();
                    break;
                }
                case cQ: {
                    flatLaf = new FlatDarculaLaf();
                    break;
                }
                case cS: {
                    flatLaf = new FlatMacDarkLaf();
                    break;
                }
                case cR: {
                    flatLaf = new FlatMacLightLaf();
                }
            }
            UIManager.setLookAndFeel(flatLaf);
        }
        catch (UnsupportedLookAndFeelException unsupportedLookAndFeelException) {
            hc.a("Could not set look and feel: " + (Object)((Object)aI3), unsupportedLookAndFeelException);
            return;
        }
        hc.debug("Look and Feel: " + UIManager.getLookAndFeel().getName());
        Font font = UIManager.getFont("Label.font");
        if (font == null) {
            cH = 120;
            cI = 350;
            cJ = 200;
            UIManager.put("Inventory.font", null);
            UIManager.put("Inventory.gridSize", 200);
            UIManager.put("Inventory.iconSize", 64);
        } else {
            double d = cK.L("InventoryScaling");
            if (d <= 0.0) {
                d = 1.0;
                cK.b("InventoryScaling", d);
                cL = true;
            }
            int n = (int)Math.round((double)font.getSize() * d);
            Font font2 = new Font(font.getName(), 0, n);
            Canvas canvas = new Canvas();
            FontMetrics fontMetrics = canvas.getFontMetrics(font);
            cH = fontMetrics.stringWidth("MMMMMMMMMM");
            cI = fontMetrics.stringWidth("MMMMMMMMMMMMMMMMMMMMMMMMMMMMM");
            cJ = fontMetrics.stringWidth("MMMMMMMMMMMMMMMMM");
            fontMetrics = canvas.getFontMetrics(font2);
            int n2 = fontMetrics.stringWidth("MMMMMMMMMMM");
            int n3 = n2 - (fontMetrics.getHeight() * 2 + 8);
            int n4 = 16;
            while (n4 * 2 <= n3) {
                n4 *= 2;
            }
            if ((double)n4 * 1.5 <= (double)n3) {
                n4 = (int)((double)n4 * 1.5);
            }
            UIManager.put("Inventory.font", font2);
            UIManager.put("Inventory.gridSize", n2);
            UIManager.put("Inventory.iconSize", n4);
        }
    }
}
