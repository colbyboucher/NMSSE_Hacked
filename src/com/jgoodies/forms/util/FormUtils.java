/*
 * Decompiled with CFR 0.152.
 */
package com.jgoodies.forms.util;

import com.jgoodies.forms.util.DefaultUnitConverter;
import javax.swing.LookAndFeel;
import javax.swing.UIManager;

public final class FormUtils {
    private static LookAndFeel cachedLookAndFeel;
    private static Boolean cachedIsLafAqua;

    private FormUtils() {
    }

    public static void assertNotBlank(String text, String description) {
        if (text == null) {
            throw new NullPointerException("The " + description + " must not be null.");
        }
        if (FormUtils.isBlank(text)) {
            throw new IllegalArgumentException("The " + description + " must not be empty, or whitespace. " + "See FormUtils.isBlank(String)");
        }
    }

    public static void assertNotNull(Object object, String description) {
        if (object == null) {
            throw new NullPointerException("The " + description + " must not be null.");
        }
    }

    public static boolean equals(Object o1, Object o2) {
        return o1 != null && o2 != null && o1.equals(o2) || o1 == null && o2 == null;
    }

    public static boolean isBlank(String str) {
        int length;
        if (str == null || (length = str.length()) == 0) {
            return true;
        }
        for (int i = length - 1; i >= 0; --i) {
            if (Character.isWhitespace(str.charAt(i))) continue;
            return false;
        }
        return true;
    }

    public static boolean isNotBlank(String str) {
        int length;
        if (str == null || (length = str.length()) == 0) {
            return false;
        }
        for (int i = length - 1; i >= 0; --i) {
            if (Character.isWhitespace(str.charAt(i))) continue;
            return true;
        }
        return false;
    }

    public static boolean isLafAqua() {
        FormUtils.ensureValidCache();
        if (cachedIsLafAqua == null) {
            cachedIsLafAqua = FormUtils.computeIsLafAqua();
        }
        return cachedIsLafAqua;
    }

    public static void clearLookAndFeelBasedCaches() {
        cachedIsLafAqua = null;
        DefaultUnitConverter.getInstance().clearCache();
    }

    private static boolean computeIsLafAqua() {
        return UIManager.getLookAndFeel().getID().equals("Aqua");
    }

    static void ensureValidCache() {
        LookAndFeel currentLookAndFeel = UIManager.getLookAndFeel();
        if (currentLookAndFeel != cachedLookAndFeel) {
            FormUtils.clearLookAndFeelBasedCaches();
            cachedLookAndFeel = currentLookAndFeel;
        }
    }
}
