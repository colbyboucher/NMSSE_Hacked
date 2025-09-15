/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.stream.Collectors;
import nomanssave.Application;
import nomanssave.eD;
import nomanssave.eE;
import nomanssave.eF;
import nomanssave.eG;
import nomanssave.hc;
import nomanssave.hh;

public class eC {
    private static eD[] jS = new eD[2];
    private final eD jT;
    private final eE jU;

    static {
        eC.jS[0] = eC.c("db/jsonmap.txt", "NMS 5.21 (savegame)");
        eC.jS[1] = eC.c("db/jsonmapac.txt", "NMS 5.21 (account)");
    }

    public static void main(String[] stringArray) {
        int n = 0;
        while (n < jS.length) {
            if (jS[n] != null) {
                for (eF eF2 : jS[n]) {
                    String string = eC.hashName(eF2.name);
                    if (eF2.key.equals(string)) continue;
                    System.out.println(String.valueOf(eF2.name) + " = " + eF2.key + " incorrect, should be " + string);
                }
            }
            ++n;
        }
    }

    private static String hashName(String string) {
        long[] lArray = new long[]{8268756125562466087L, 8268756125562466087L};
        hh.a(string.getBytes("UTF-8"), lArray);
        String string2 = "0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxy";
        long l = 0xFFFFFFFFL & lArray[0] >> 32;
        l = l % 68L << 32 | 0xFFFFFFFFL & lArray[0];
        int n = (int)(l % 68L);
        int n2 = (int)((0x7FFFFFFFFFFL & lArray[0] >> 21) % 68L);
        int n3 = (int)((0x3FFFFFL & lArray[0] >> 42) % 68L);
        return new String(new char[]{string2.charAt(n), string2.charAt(n2), string2.charAt(n3)});
    }

    public static eC a(eG eG2, String string) {
        eD eD2 = jS[eG2.ordinal()];
        if (eD2 != null && eD2.s(string)) {
            return new eC(eD2);
        }
        return null;
    }

    private static eD c(String string, String string2) {
        InputStream inputStream = Application.class.getResourceAsStream(string);
        if (inputStream == null) {
            return null;
        }
        try {
            return new eD(inputStream, string2, null);
        }
        catch (IOException iOException) {
            hc.error("Could not load key mapping file: " + string, iOException);
            return null;
        }
    }

    private eC(eD eD2) {
        this.jT = eD2;
        this.jU = new eE(null, null);
    }

    public Map bp() {
        return this.jU.stream().collect(Collectors.toMap(eF2 -> eF2.key, eF2 -> eF2.name));
    }

    public String q(String string) {
        String string2;
        eF eF2 = this.jU.t(string);
        if (eF2 != null) {
            string2 = eF2.name;
        } else {
            eF2 = this.jT.t(string);
            if (eF2 != null) {
                string2 = eF2.name;
            } else {
                eF2 = this.jT.v(string);
                if (eF2 != null) {
                    string2 = eF2.name;
                } else {
                    hc.warn("  name mapping not found: " + string);
                    string2 = string;
                }
                this.jU.add(string, string2);
            }
        }
        return string2;
    }

    public String r(String string) {
        String string2;
        eF eF2 = this.jU.u(string);
        if (eF2 != null) {
            string2 = eF2.key;
        } else {
            eF2 = this.jT.u(string);
            if (eF2 != null) {
                string2 = eF2.key;
            } else {
                string2 = string;
                if (this.jT.t(string2) == null) {
                    hc.warn("  reverse mapping not found: " + string);
                }
            }
        }
        return string2;
    }

    public String toString() {
        return this.jT.toString();
    }
}
