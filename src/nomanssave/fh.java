/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.function.Predicate;
import nomanssave.eV;
import nomanssave.eX;
import nomanssave.eY;
import nomanssave.fg;
import nomanssave.fi;
import nomanssave.fk;

public class fh {
    public static final int kU = 0;
    public static final int kV = 1;
    public static final int kW = 2;
    public static final int kX = 3;
    public static final int kY = 4;
    static final Predicate kZ = n -> n >= 48 && n <= 57;
    static final Predicate la = n -> n == 46;
    static final Predicate lb = n -> n == 101 || n == 69;
    static final Predicate lc = n -> n >= 48 && n <= 57 || n == 43 || n == 45;
    static final Predicate ld = n -> (n & 0xC0) == 128;
    static final String gc = "0123456789ABCDEFabcdef";

    static boolean a(Class clazz) {
        if (clazz == null) {
            return true;
        }
        if (Boolean.class.isAssignableFrom(clazz)) {
            return true;
        }
        if (BigDecimal.class.isAssignableFrom(clazz)) {
            return true;
        }
        if (Number.class.isAssignableFrom(clazz)) {
            return true;
        }
        if (String.class.isAssignableFrom(clazz)) {
            return true;
        }
        if (eY.class.isAssignableFrom(clazz)) {
            return !fk.class.isAssignableFrom(clazz);
        }
        if (eV.class.isAssignableFrom(clazz)) {
            return true;
        }
        return fg.class.isAssignableFrom(clazz);
    }

    public static String b(Object object, boolean bl) {
        return fh.a(object, bl ? 7 : 0, null);
    }

    public static String a(Object object, int n, Predicate predicate) {
        String string = null;
        if ((n & 3) != 0) {
            switch (n & 3) {
                case 1: {
                    string = "\n";
                    break;
                }
                case 2: {
                    string = "\r\n";
                    break;
                }
                default: {
                    string = System.lineSeparator();
                }
            }
        }
        boolean bl = (n & 4) != 0;
        return fh.a(object, string, bl, predicate);
    }

    static String a(Object object, String string, boolean bl) {
        return fh.a(object, string, bl, null);
    }

    private static String a(Object object, String string, boolean bl, Predicate predicate) {
        if (object == null) {
            return "null";
        }
        if (object instanceof Boolean) {
            return object.toString();
        }
        if (object instanceof BigDecimal) {
            return ((BigDecimal)object).toEngineeringString();
        }
        if (object instanceof Number) {
            return object.toString();
        }
        if (object instanceof String) {
            return fh.b((String)object, predicate);
        }
        if (object instanceof eY) {
            return fh.a((eY)object, string, bl, predicate);
        }
        if (object instanceof eV) {
            return fh.a((eV)object, string, bl, predicate);
        }
        if (object instanceof fg) {
            return fh.b((fg)object);
        }
        throw new RuntimeException("unsupported data type");
    }

    static String a(eV eV2, String string, boolean bl) {
        return fh.a(eV2, string, bl, null);
    }

    private static String a(eV eV2, String string, boolean bl, Predicate predicate) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append('[');
        int n = 0;
        while (n < eV2.length) {
            if (n > 0) {
                stringBuilder.append(',');
            }
            if (string != null) {
                stringBuilder.append(String.valueOf(string) + "\t");
            }
            stringBuilder.append(fh.a(eV2.values[n], string == null ? null : String.valueOf(string) + "\t", bl, predicate));
            ++n;
        }
        if (eV2.length > 0) {
            stringBuilder.append(string);
        }
        stringBuilder.append(']');
        return stringBuilder.toString();
    }

    static String a(eY eY2, String string, boolean bl) {
        return fh.a(eY2, string, bl, null);
    }

    private static String a(eY eY2, String string, boolean bl, Predicate predicate) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append('{');
        int n = 0;
        while (n < eY2.length) {
            if (n > 0) {
                stringBuilder.append(',');
            }
            if (string != null) {
                stringBuilder.append(String.valueOf(string) + "\t");
            }
            stringBuilder.append(fh.b(eY2.names[n], predicate));
            stringBuilder.append(':');
            if (bl) {
                stringBuilder.append(' ');
            }
            stringBuilder.append(fh.a(eY2.values[n], string == null ? null : String.valueOf(string) + "\t", bl, predicate));
            ++n;
        }
        if (eY2.length > 0) {
            stringBuilder.append(string);
        }
        stringBuilder.append('}');
        return stringBuilder.toString();
    }

    private static String a(fg fg2) {
        StringBuilder stringBuilder = new StringBuilder();
        byte[] byArray = fg2.toByteArray();
        int n = byArray.length;
        int n2 = 0;
        while (n2 < n) {
            byte by = byArray[n2];
            int n3 = by & 0xFF;
            if (n3 == 13) {
                stringBuilder.append("\\r");
            } else if (n3 == 10) {
                stringBuilder.append("\\n");
            } else if (n3 == 9) {
                stringBuilder.append("\\t");
            } else if (n3 == 12) {
                stringBuilder.append("\\f");
            } else if (n3 == 8) {
                stringBuilder.append("\\b");
            } else if (n3 == 11) {
                stringBuilder.append("\\v");
            } else if (n3 == 0) {
                stringBuilder.append("\\0");
            } else if (n3 == 34) {
                stringBuilder.append("\\\"");
            } else if (n3 == 92) {
                stringBuilder.append("\\\\");
            } else if (n3 < 32 || n3 >= 128) {
                stringBuilder.append("\\x");
                stringBuilder.append(gc.charAt(n3 >> 4 & 0xF));
                stringBuilder.append(gc.charAt(n3 & 0xF));
            } else {
                stringBuilder.append(Character.toString((char)n3));
            }
            ++n2;
        }
        return stringBuilder.toString();
    }

    private static String b(fg fg2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append('\"');
        stringBuilder.append(fh.a(fg2));
        stringBuilder.append('\"');
        return stringBuilder.toString();
    }

    private static String a(String string, Predicate predicate) {
        StringBuilder stringBuilder = new StringBuilder();
        char[] cArray = string.toCharArray();
        int n = cArray.length;
        int n2 = 0;
        while (n2 < n) {
            char c = cArray[n2];
            if (c == '\r') {
                stringBuilder.append("\\r");
            } else if (c == '\n') {
                stringBuilder.append("\\n");
            } else if (c == '\t') {
                stringBuilder.append("\\t");
            } else if (c == '\f') {
                stringBuilder.append("\\f");
            } else if (c == '\b') {
                stringBuilder.append("\\b");
            } else if (c == '\"') {
                stringBuilder.append("\\\"");
            } else if (c == '\\') {
                stringBuilder.append("\\\\");
            } else if (c < ' ' || predicate != null && !predicate.test(Character.valueOf(c))) {
                stringBuilder.append("\\u");
                stringBuilder.append(gc.charAt(c >> 12 & 0xF));
                stringBuilder.append(gc.charAt(c >> 8 & 0xF));
                stringBuilder.append(gc.charAt(c >> 4 & 0xF));
                stringBuilder.append(gc.charAt(c & 0xF));
            } else {
                stringBuilder.append(Character.toString(c));
            }
            ++n2;
        }
        return stringBuilder.toString();
    }

    static String O(String string) {
        return fh.b(string, null);
    }

    private static String b(String string, Predicate predicate) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append('\"');
        stringBuilder.append(fh.a(string, predicate));
        stringBuilder.append('\"');
        return stringBuilder.toString();
    }

    public static Object P(String string) {
        fi fi2 = new fi(string);
        Object object = fh.a(fi2, fi2.bI());
        if (fi2.bI() >= 0) {
            throw new eX("Invalid trailing data", fi2.kF, fi2.kG);
        }
        return object;
    }

    private static Object a(fi fi2, int n) {
        if (n < 0) {
            throw new eX("Short read", fi2.kF, fi2.kG);
        }
        if (n == 123) {
            return fh.a(fi2);
        }
        if (n == 91) {
            return fh.b(fi2);
        }
        if (n == 34) {
            return fh.d(fi2);
        }
        if (n == 102) {
            if (fi2.read() != 97) {
                throw new eX("Invalid token", fi2.kF, fi2.kG);
            }
            if (fi2.read() != 108) {
                throw new eX("Invalid token", fi2.kF, fi2.kG);
            }
            if (fi2.read() != 115) {
                throw new eX("Invalid token", fi2.kF, fi2.kG);
            }
            if (fi2.read() != 101) {
                throw new eX("Invalid token", fi2.kF, fi2.kG);
            }
            return Boolean.FALSE;
        }
        if (n == 116) {
            if (fi2.read() != 114) {
                throw new eX("Invalid token", fi2.kF, fi2.kG);
            }
            if (fi2.read() != 117) {
                throw new eX("Invalid token", fi2.kF, fi2.kG);
            }
            if (fi2.read() != 101) {
                throw new eX("Invalid token", fi2.kF, fi2.kG);
            }
            return Boolean.TRUE;
        }
        if (n == 110) {
            if (fi2.read() != 117) {
                throw new eX("Invalid token", fi2.kF, fi2.kG);
            }
            if (fi2.read() != 108) {
                throw new eX("Invalid token", fi2.kF, fi2.kG);
            }
            if (fi2.read() != 108) {
                throw new eX("Invalid token", fi2.kF, fi2.kG);
            }
            return null;
        }
        if (n == 100) {
            if (fi2.read() != 97) {
                throw new eX("Invalid token", fi2.kF, fi2.kG);
            }
            if (fi2.read() != 116) {
                throw new eX("Invalid token", fi2.kF, fi2.kG);
            }
            if (fi2.read() != 97) {
                throw new eX("Invalid token", fi2.kF, fi2.kG);
            }
            if (fi2.read() != 40) {
                throw new eX("Invalid token", fi2.kF, fi2.kG);
            }
            if (fi2.bI() != 34) {
                throw new eX("Invalid token", fi2.kF, fi2.kG);
            }
            fg fg2 = fh.e(fi2);
            if (fi2.bI() != 41) {
                throw new eX("Invalid token", fi2.kF, fi2.kG);
            }
            return fg2;
        }
        if (n == 45 || n >= 48 && n <= 57) {
            return fh.b(fi2, n);
        }
        throw new eX("Invalid token", fi2.kF, fi2.kG);
    }

    static eY Q(String string) {
        Throwable throwable = null;
        Object var2_3 = null;
        try (fi fi2 = new fi(string);){
            if (fi2.bI() != 123) {
                throw new eX("Invalid object string", fi2.kF, fi2.kG);
            }
            eY eY2 = fh.a(fi2);
            if (fi2.bI() >= 0) {
                throw new eX("Invalid trailing data", fi2.kF, fi2.kG);
            }
            return eY2;
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

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private static eY a(fi fi2) {
        eY eY2 = new eY();
        int n = fi2.bI();
        if (n == 34) {
            do {
                String string = fh.c(fi2);
                if (fi2.bI() != 58) {
                    throw new eX("Invalid token", fi2.kF, fi2.kG);
                }
                Object object = fh.a(fi2, fi2.bI());
                eY2.a(string, object);
                n = fi2.bI();
                if (n == 125) return eY2;
                if (n == 44) continue;
                throw new eX("Invalid token", fi2.kF, fi2.kG);
            } while ((n = fi2.bI()) == 34);
            throw new eX("Invalid token", fi2.kF, fi2.kG);
        }
        if (n == 125) return eY2;
        throw new eX("Invalid token", fi2.kF, fi2.kG);
    }

    static eV R(String string) {
        Throwable throwable = null;
        Object var2_3 = null;
        try (fi fi2 = new fi(string);){
            if (fi2.bI() != 91) {
                throw new eX("Invalid array string", fi2.kF, fi2.kG);
            }
            eV eV2 = fh.b(fi2);
            if (fi2.bI() >= 0) {
                throw new eX("Invalid trailing data", fi2.kF, fi2.kG);
            }
            return eV2;
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

    private static eV b(fi fi2) {
        eV eV2 = new eV();
        int n = fi2.bI();
        if (n != 93) {
            while (true) {
                Object object = fh.a(fi2, n);
                eV2.e(object);
                n = fi2.bI();
                if (n == 93) break;
                if (n != 44) {
                    throw new eX("Invalid token", fi2.kF, fi2.kG);
                }
                n = fi2.bI();
            }
        }
        return eV2;
    }

    static int ae(int n) {
        if (n < 0) {
            throw new IOException("short read");
        }
        if ((n = gc.indexOf((char)n)) < 0) {
            throw new IOException("invalid hex char");
        }
        if (n >= 16) {
            n -= 6;
        }
        return n;
    }

    private static String c(fi fi2) {
        Object object = fh.d(fi2);
        if (object instanceof String) {
            return (String)object;
        }
        throw new eX("Invalid string", fi2.kF, fi2.kG);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static Object d(fi fi2) {
        try {
            int n;
            StringBuilder stringBuilder = new StringBuilder();
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            block14: while ((n = fi2.read()) != 34) {
                if (n < 0) {
                    throw new eX("Short read");
                }
                if (n == 92) {
                    n = fi2.read();
                    if (n < 0) {
                        throw new eX("Short read");
                    }
                    switch (n) {
                        case 114: {
                            n = 13;
                            break;
                        }
                        case 110: {
                            n = 10;
                            break;
                        }
                        case 116: {
                            n = 9;
                            break;
                        }
                        case 102: {
                            n = 12;
                            break;
                        }
                        case 98: {
                            n = 8;
                            break;
                        }
                        case 118: {
                            n = 11;
                            break;
                        }
                        case 48: {
                            n = 0;
                            break;
                        }
                        case 117: {
                            n = fh.ae(fi2.read()) << 12 | fh.ae(fi2.read()) << 8 | fh.ae(fi2.read()) << 4 | fh.ae(fi2.read());
                            if (n <= 255) {
                                if (stringBuilder != null) {
                                    stringBuilder.append((char)n);
                                }
                                if (byteArrayOutputStream == null) continue block14;
                                byteArrayOutputStream.write(n);
                                continue block14;
                            }
                            if (stringBuilder == null) {
                                throw new eX("Mixed encodings detected in string");
                            }
                            byteArrayOutputStream = null;
                            stringBuilder.append((char)n);
                            continue block14;
                        }
                        case 120: {
                            n = fh.ae(fi2.read()) << 4 | fh.ae(fi2.read());
                            if (byteArrayOutputStream == null) {
                                throw new eX("Mixed encodings detected in stringx");
                            }
                            byteArrayOutputStream.write(n);
                            stringBuilder = null;
                            continue block14;
                        }
                    }
                }
                if (stringBuilder != null) {
                    stringBuilder.append((char)n);
                }
                if (byteArrayOutputStream == null) continue;
                byteArrayOutputStream.write(n);
            }
            if (stringBuilder != null) {
                return stringBuilder.toString();
            }
            return new fg(byteArrayOutputStream.toByteArray());
        }
        catch (eX eX2) {
            throw eX2;
        }
        catch (IOException iOException) {
            throw new eX("Invalid string", iOException, fi2.kF, fi2.kG);
        }
    }

    /*
     * Unable to fully structure code
     */
    private static fg e(fi var0) {
        var1_1 = new ByteArrayOutputStream();
        var3_2 = var0.read();
        if (var3_2 != 48) {
            throw new eX("Invalid hex data", var0.kF, var0.kG);
        }
        var3_2 = var0.read();
        if (var3_2 == 120) ** GOTO lbl22
        throw new eX("Invalid hex data", var0.kF, var0.kG);
lbl-1000:
        // 1 sources

        {
            if (var2_3 < 0) {
                throw new eX("Short read", var0.kF, var0.kG);
            }
            var3_2 = var0.read();
            if (var3_2 < 0) {
                throw new eX("Short read", var0.kF, var0.kG);
            }
            if ((var2_3 = "0123456789abcdefABCDEF".indexOf((char)var2_3)) < 0) {
                throw new eX("Invalid hex data", var0.kF, var0.kG);
            }
            if (var2_3 >= 16) {
                var2_3 -= 6;
            }
            if ((var3_2 = "0123456789abcdefABCDEF".indexOf((char)var3_2)) < 0) {
                throw new eX("Invalid hex data", var0.kF, var0.kG);
            }
            if (var3_2 >= 16) {
                var3_2 -= 6;
            }
            var1_1.write(var2_3 << 4 | var3_2);
lbl22:
            // 2 sources

            ** while ((var2_3 = var0.read()) != 34)
        }
lbl23:
        // 1 sources

        return new fg(var1_1.toByteArray());
    }

    private static Number b(fi fi2, int n) {
        int n2;
        boolean bl = false;
        if (n == 45) {
            n = fi.a(fi2, kZ);
            if (n < 0) {
                throw new eX("Invalid token", fi2.kF, fi2.kG);
            }
            bl = true;
        }
        BigDecimal bigDecimal = new BigDecimal(n - 48);
        if (n != 48) {
            while ((n = fi.a(fi2, kZ)) >= 0) {
                bigDecimal = bigDecimal.multiply(BigDecimal.TEN).add(new BigDecimal(n - 48));
            }
        }
        boolean bl2 = true;
        if (fi.a(fi2, la) >= 0) {
            bl2 = false;
            n = fi.a(fi2, kZ);
            if (n < 0) {
                throw new eX("Invalid token", fi2.kF, fi2.kG);
            }
            n2 = 0;
            do {
                bigDecimal = bigDecimal.add(new BigDecimal(n - 48).scaleByPowerOfTen(--n2));
            } while ((n = fi.a(fi2, kZ)) >= 0);
        }
        if (fi.a(fi2, lb) >= 0) {
            bl2 = false;
            n = fi.a(fi2, lc);
            n2 = 0;
            if (n == 43 || n == 45) {
                n2 = n == 45 ? 1 : 0;
                n = fi.a(fi2, kZ);
            }
            if (n < 0) {
                throw new eX("Invalid token", fi2.kF, fi2.kG);
            }
            int n3 = 0;
            do {
                n3 *= 10;
                n3 += n - 48;
            } while ((n = fi.a(fi2, kZ)) >= 0);
            if (n2 != 0) {
                n3 = -n3;
            }
            bigDecimal = bigDecimal.scaleByPowerOfTen(n3);
        }
        if (bl) {
            bigDecimal = bigDecimal.negate();
        }
        if (bl2) {
            try {
                return bigDecimal.intValueExact();
            }
            catch (ArithmeticException arithmeticException) {
                try {
                    return bigDecimal.longValueExact();
                }
                catch (ArithmeticException arithmeticException2) {
                    // empty catch block
                }
            }
        }
        return bigDecimal;
    }

    static void i(Object object) {
        if (object instanceof eY) {
            ((eY)object).kD = null;
        }
        if (object instanceof eV) {
            ((eV)object).kD = null;
        }
    }

    static void a(Object object, Object object2) {
        if (object instanceof eY) {
            ((eY)object).kD = object2;
        }
        if (object instanceof eV) {
            ((eV)object).kD = object2;
        }
    }
}
