/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import nomanssave.eV;
import nomanssave.eY;
import nomanssave.gT;
import nomanssave.hc;

public class gV {
    private static double[] a(eY eY2, String string) {
        eV eV2 = eY2.d(string);
        if (eV2.size() != 3) {
            throw new RuntimeException("Invalid " + string + " coordinates");
        }
        return new double[]{eV2.aa(0), eV2.aa(1), eV2.aa(2)};
    }

    private static void a(eY eY2, String string, double[] dArray) {
        eY2.b(string, new eV(new Double(Double.isNaN(dArray[0]) ? 0.0 : dArray[0]), new Double(Double.isNaN(dArray[1]) ? 0.0 : dArray[1]), new Double(Double.isNaN(dArray[2]) ? 0.0 : dArray[2])));
    }

    public static boolean F(eY eY2) {
        return gV.b(eY2, "^BUILDSIGNAL");
    }

    /*
     * Enabled aggressive block sorting
     */
    public static boolean b(eY eY2, String string) {
        eV eV2 = eY2.d("Objects");
        eY eY3 = null;
        eY eY4 = null;
        int n = 0;
        while (n < eV2.size()) {
            eY eY5 = eV2.V(n);
            if ("^BASE_FLAG".equals(eY5.getValueAsString("ObjectID"))) {
                if (eY3 != null) {
                    hc.warn("  multiple base computers found");
                    return false;
                }
                eY3 = eY5;
            } else if (string.equals(eY5.getValueAsString("ObjectID"))) {
                if (eY4 != null) {
                    hc.warn("  multiple " + string + " objects found");
                    return false;
                }
                eY4 = eY5;
            }
            ++n;
        }
        if (eY3 == null) {
            hc.warn("  no base computer found");
            return false;
        }
        if (eY4 == null) {
            hc.warn("  no " + string + " object found");
            return false;
        }
        gV.a(eY2, eY3, eY4);
        return true;
    }

    public static List G(eY eY2) {
        ArrayList<eY> arrayList = new ArrayList<eY>();
        boolean bl = false;
        eV eV2 = eY2.d("Objects");
        int n = 0;
        while (n < eV2.size()) {
            eY eY3 = eV2.V(n);
            String string = eY3.getValueAsString("ObjectID");
            if ("^BASE_FLAG".equals(eY3.getValueAsString("ObjectID"))) {
                bl = true;
            } else if ("^BUILDSIGNAL".equals(string)) {
                arrayList.add(eY3);
            } else if ("^BP_ANALYSER".equals(string)) {
                arrayList.add(eY3);
            } else if ("^BUILDBEACON".equals(string)) {
                arrayList.add(eY3);
            }
            ++n;
        }
        return bl ? arrayList : Collections.emptyList();
    }

    /*
     * Enabled aggressive block sorting
     */
    public static boolean a(eY eY2, eY eY3) {
        eV eV2 = eY2.d("Objects");
        boolean bl = false;
        eY eY4 = null;
        int n = 0;
        while (n < eV2.size()) {
            eY eY5 = eV2.V(n);
            if ("^BASE_FLAG".equals(eY5.getValueAsString("ObjectID"))) {
                if (eY4 != null) {
                    hc.warn("  multiple base computers found");
                    return false;
                }
                eY4 = eY5;
            } else if (eY5 == eY3) {
                bl = true;
            }
            ++n;
        }
        if (eY4 == null) {
            hc.warn("  no base computer found");
            return false;
        }
        if (!bl) {
            hc.warn("  replacement object found");
            return false;
        }
        gV.a(eY2, eY4, eY3);
        return true;
    }

    private static void a(eY eY2, eY eY3, eY eY4) {
        double[] dArray = gV.a(eY2, "Position");
        double[] dArray2 = gV.a(eY2, "Forward");
        double[] dArray3 = gV.a(eY4, "Position");
        gT gT2 = new gT(dArray, dArray2);
        double[] dArray4 = gT2.c(dArray3);
        dArray4[0] = dArray4[0] + dArray[0];
        dArray4[1] = dArray4[1] + dArray[1];
        dArray4[2] = dArray4[2] + dArray[2];
        gV.a(eY2, "Position", dArray4);
        dArray4 = gV.a(eY3, "At");
        double[] dArray5 = gV.a(eY4, "At");
        gV.a(eY3, "At", dArray5);
        gV.a(eY4, "At", dArray4);
        dArray4 = new double[]{-dArray3[0], -dArray3[1], -dArray3[2]};
        gV.a(eY4, "Position", dArray4);
        eV eV2 = eY2.d("Objects");
        int n = 0;
        while (n < eV2.size()) {
            eY eY5 = eV2.V(n);
            if (eY5 != eY3 && eY5 != eY4) {
                dArray4 = gV.a(eY5, "Position");
                dArray4[0] = dArray4[0] - dArray3[0];
                dArray4[1] = dArray4[1] - dArray3[1];
                dArray4[2] = dArray4[2] - dArray3[2];
                gV.a(eY5, "Position", dArray4);
            }
            ++n;
        }
    }
}
