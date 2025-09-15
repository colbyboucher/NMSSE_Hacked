/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import nomanssave.Application;
import nomanssave.eY;
import nomanssave.ff;
import nomanssave.hc;
import nomanssave.hk;

public class gR {
    private static Map rR = new HashMap();

    public static eY az(String string) {
        eY eY2 = null;
        if (rR.containsKey(string)) {
            eY2 = (eY)rR.get(string);
        } else {
            InputStream inputStream = Application.class.getResourceAsStream("templates/" + string + ".json");
            if (inputStream != null) {
                try {
                    byte[] byArray = hk.g(inputStream);
                    eY2 = ff.b(byArray);
                }
                catch (IOException iOException) {
                    hc.a("Cannot load template: " + string, iOException);
                }
            }
            rR.put(string, eY2);
        }
        return eY2 == null ? null : eY2.bE();
    }
}
