/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.regex.Pattern;
import nomanssave.eY;
import nomanssave.fA;
import nomanssave.fJ;
import nomanssave.fR;
import nomanssave.fT;
import nomanssave.fr;
import nomanssave.ft;
import nomanssave.hc;

public interface fq {
    public static final int lz = 15;

    public static String c(long l) {
        int n = (int)(l % 60L);
        int n2 = (int)((l /= 60L) % 60L);
        int n3 = (int)(l /= 60L);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(n3);
        stringBuilder.append(':');
        if (n2 < 10) {
            stringBuilder.append(0);
        }
        stringBuilder.append(n2);
        return stringBuilder.toString();
    }

    public static String c(fq fq2) {
        if (fq2 instanceof fJ) {
            return "Steam";
        }
        if (fq2 instanceof fT) {
            return "Xbox Game Pass";
        }
        if (fq2 instanceof fA) {
            return "PS4 - Save Wizard";
        }
        return null;
    }

    public static fq a(File file2, fR fR2) {
        if (!file2.exists()) {
            return null;
        }
        try {
            if (file2.isDirectory()) {
                if (file2.listFiles(file -> file.getName().equalsIgnoreCase("containers.index")).length > 0) {
                    return new fT(file2, fR2);
                }
                if (file2.listFiles(file -> file.getName().equalsIgnoreCase("accountdata.hg") || Pattern.matches("save\\d*.hg", file.getName().toLowerCase())).length > 0) {
                    return new fJ(file2, fR2);
                }
                if (file2.listFiles(file -> Pattern.matches("savedata\\d{2}.hg", file.getName().toLowerCase())).length > 0) {
                    return new fA(file2, fR2);
                }
            } else {
                if (file2.getName().equalsIgnoreCase("containers.index")) {
                    return new fT(file2.getParentFile(), fR2);
                }
                if (file2.getName().equalsIgnoreCase("accountdata.hg") || Pattern.matches("save\\d*.hg", file2.getName().toLowerCase())) {
                    return new fJ(file2.getParentFile(), fR2);
                }
                if (Pattern.matches("savedata\\d{2}.hg", file2.getName().toLowerCase())) {
                    return new fA(file2.getParentFile(), fR2);
                }
            }
        }
        catch (IOException iOException) {
            hc.error("cannot load storage", iOException);
        }
        return null;
    }

    public static fq a(String string, File file, fR fR2) {
        if (!file.exists()) {
            return null;
        }
        if (string == null) {
            return fq.a(file, fR2);
        }
        try {
            if ("Steam".equals(string)) {
                return new fJ(file, fR2);
            }
            if ("Xbox Game Pass".equals(string)) {
                return new fT(file, fR2);
            }
            if ("PS4 - Save Wizard".equals(string)) {
                return new fA(file, fR2);
            }
        }
        catch (IOException iOException) {
            hc.error("cannot load storage", iOException);
        }
        return null;
    }

    public File bS();

    public fr bT();

    public ft[] bU();

    default public ft[] bV() {
        return (ft[])Arrays.asList(this.bU()).stream().filter(ft2 -> !ft2.isEmpty()).toArray(ft[]::new);
    }

    public int W(String var1);

    default public boolean bW() {
        return false;
    }

    default public String a(int n, eY eY2) {
        throw new IOException("cannot create slot " + (n + 1));
    }

    public void X(String var1);
}
