/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

public class hf {
    public static int b(String string, int n, int n2) {
        if ((string = string.trim()).length() == 0) {
            throw new RuntimeException("No digits found");
        }
        long l = 0L;
        int n3 = 0;
        while (n3 < string.length()) {
            l *= 10L;
            char c = string.charAt(n3);
            if (c < '0' || c > '9') {
                throw new RuntimeException("Invalid digit: " + c);
            }
            if ((l += (long)(c - 48)) > (long)n2) {
                return n2;
            }
            ++n3;
        }
        if (l < (long)n) {
            return n;
        }
        return (int)l;
    }

    public static long a(String string, long l, long l2) {
        if ((string = string.trim()).length() == 0) {
            throw new RuntimeException("No digits found");
        }
        long l3 = 0L;
        int n = 0;
        while (n < string.length()) {
            l3 *= 10L;
            char c = string.charAt(n);
            if (c < '0' || c > '9') {
                throw new RuntimeException("Invalid digit: " + c);
            }
            if ((l3 += (long)(c - 48)) > l2) {
                return l2;
            }
            ++n;
        }
        if (l3 < l) {
            return l;
        }
        return l3;
    }

    public static double a(String string, double d, double d2) {
        double d3 = Double.parseDouble(string = string.trim());
        if (d3 < d) {
            return d;
        }
        if (d3 > d2) {
            return d2;
        }
        return d3;
    }
}
