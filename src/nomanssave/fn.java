/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import nomanssave.eY;

public enum fn {
    lm,
    ln,
    lo,
    lp,
    lq,
    lr,
    ls,
    lt;

    private static final Pattern lu;
    private static final Pattern lv;
    private static final Pattern lw;
    private static final Pattern lx;

    static {
        lu = Pattern.compile("\"((?:XTp)|(?:ActiveContext))\":\"([^\"]+)\",");
        lv = Pattern.compile("\"((?:vLc)|(?:BaseContext))\":\\{\"((?:idA)|(?:GameMode))\":(\\d+)");
        lw = Pattern.compile("\"((?:2YS)|(?:ExpeditionContext))\":\\{\"((?:idA)|(?:GameMode))\":(\\d+)");
        lx = Pattern.compile("\"((?:7ND)|(?:DifficultyPresetType))\":\"(\\w+)\"");
    }

    private static fn S(String string) {
        fn[] fnArray = fn.values();
        int n = fnArray.length;
        int n2 = 0;
        while (n2 < n) {
            fn fn2 = fnArray[n2];
            if (string.equalsIgnoreCase(fn2.name())) {
                return fn2;
            }
            ++n2;
        }
        return null;
    }

    public static fn T(String string) {
        Matcher matcher = lu.matcher(string);
        if (matcher.find()) {
            int n;
            String string2 = matcher.group(2);
            if ("Main".equals(string2)) {
                matcher = lv.matcher(string);
            } else if ("Season".equals(string2)) {
                matcher = lw.matcher(string);
            }
            if (matcher.find() && (n = Integer.parseInt(matcher.group(3))) > 0 && n <= fn.values().length) {
                return fn.values()[n - 1];
            }
        }
        if ((matcher = lx.matcher(string)).find()) {
            return fn.S(matcher.group(2));
        }
        return null;
    }

    public static fn i(eY eY2) {
        int n;
        String string = eY2.getValueAsString("ActiveContext");
        if ("Main".equals(string) ? (n = eY2.J("BaseContext.GameMode")) > 0 && n <= fn.values().length : "Season".equals(string) && (n = eY2.J("ExpeditionContext.GameMode")) > 0 && n <= fn.values().length) {
            return fn.values()[n - 1];
        }
        String string2 = eY2.getValueAsString("PlayerStateData.DifficultyState.Preset.DifficultyPresetType");
        if (string2 != null) {
            return fn.S(string2);
        }
        return null;
    }
}
