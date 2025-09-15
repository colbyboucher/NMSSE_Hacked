/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import java.util.ArrayList;
import java.util.List;
import nomanssave.eo;

public class en {
    private static boolean iu = false;
    private static List iv = new ArrayList();

    public static void a(eo eo2) {
        iv.add(eo2);
    }

    public static boolean aS() {
        return iu;
    }

    public static void c(boolean bl) {
        iu = bl;
        for (eo eo2 : iv) {
            eo2.a(bl);
        }
    }
}
