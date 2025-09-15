/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.SecureRandom;
import nomanssave.hk;

public class gc {
    private static final long nc = -11644473600000L;

    public static String a(InputStream inputStream) {
        byte[] byArray = new byte[16];
        hk.readFully(inputStream, byArray);
        return gc.h(byArray);
    }

    public static String cA() {
        byte[] byArray = new byte[16];
        new SecureRandom().nextBytes(byArray);
        return gc.h(byArray);
    }

    private static String h(byte[] byArray) {
        StringBuilder stringBuilder = new StringBuilder();
        gc.a(byArray[3], stringBuilder);
        gc.a(byArray[2], stringBuilder);
        gc.a(byArray[1], stringBuilder);
        gc.a(byArray[0], stringBuilder);
        gc.a(byArray[5], stringBuilder);
        gc.a(byArray[4], stringBuilder);
        gc.a(byArray[7], stringBuilder);
        gc.a(byArray[6], stringBuilder);
        gc.a(byArray[8], stringBuilder);
        gc.a(byArray[9], stringBuilder);
        gc.a(byArray[10], stringBuilder);
        gc.a(byArray[11], stringBuilder);
        gc.a(byArray[12], stringBuilder);
        gc.a(byArray[13], stringBuilder);
        gc.a(byArray[14], stringBuilder);
        gc.a(byArray[15], stringBuilder);
        return stringBuilder.toString();
    }

    private static void a(byte by, StringBuilder stringBuilder) {
        int n = (0xF0 & by) >> 4;
        int n2 = 0xF & by;
        stringBuilder.append("0123456789ABCDEF".charAt(n));
        stringBuilder.append("0123456789ABCDEF".charAt(n2));
    }

    /*
     * Unable to fully structure code
     */
    public static void a(OutputStream var0, String var1_1) {
        if (var1_1.length() <= 32) ** GOTO lbl4
        throw new IOException("invalid container path");
lbl-1000:
        // 1 sources

        {
            var1_1 = "0" + var1_1;
lbl4:
            // 2 sources

            ** while (var1_1.length() < 32)
        }
lbl5:
        // 1 sources

        var1_1 = var1_1.toLowerCase();
        var2_2 = new byte[16];
        var2_2[3] = (byte)Integer.parseInt(var1_1.substring(0, 2), 16);
        var2_2[2] = (byte)Integer.parseInt(var1_1.substring(2, 4), 16);
        var2_2[1] = (byte)Integer.parseInt(var1_1.substring(4, 6), 16);
        var2_2[0] = (byte)Integer.parseInt(var1_1.substring(6, 8), 16);
        var2_2[5] = (byte)Integer.parseInt(var1_1.substring(8, 10), 16);
        var2_2[4] = (byte)Integer.parseInt(var1_1.substring(10, 12), 16);
        var2_2[7] = (byte)Integer.parseInt(var1_1.substring(12, 14), 16);
        var2_2[6] = (byte)Integer.parseInt(var1_1.substring(14, 16), 16);
        var2_2[8] = (byte)Integer.parseInt(var1_1.substring(16, 18), 16);
        var2_2[9] = (byte)Integer.parseInt(var1_1.substring(18, 20), 16);
        var2_2[10] = (byte)Integer.parseInt(var1_1.substring(20, 22), 16);
        var2_2[11] = (byte)Integer.parseInt(var1_1.substring(22, 24), 16);
        var2_2[12] = (byte)Integer.parseInt(var1_1.substring(24, 26), 16);
        var2_2[13] = (byte)Integer.parseInt(var1_1.substring(26, 28), 16);
        var2_2[14] = (byte)Integer.parseInt(var1_1.substring(28, 30), 16);
        var2_2[15] = (byte)Integer.parseInt(var1_1.substring(30, 32), 16);
        var0.write(var2_2);
    }

    public static long b(InputStream inputStream) {
        return hk.f(inputStream) / 10000L + -11644473600000L;
    }

    public static void a(OutputStream outputStream, long l) {
        hk.b(outputStream, (l - -11644473600000L) * 10000L);
    }

    public static String c(InputStream inputStream) {
        int n = hk.readInt(inputStream);
        if (n < 0) {
            throw new IOException("negative length");
        }
        byte[] byArray = new byte[n * 2];
        hk.readFully(inputStream, byArray);
        return new String(byArray, "UTF-16LE");
    }

    public static void b(OutputStream outputStream, String string) {
        hk.a(outputStream, string.length());
        outputStream.write(string.getBytes("UTF-16LE"));
    }

    public static String d(InputStream inputStream) {
        byte[] byArray = new byte[128];
        hk.readFully(inputStream, byArray);
        int n = 0;
        while (n < byArray.length) {
            if (byArray[n] == 0 && byArray[n + 1] == 0) break;
            n += 2;
        }
        return new String(byArray, 0, n, "UTF-16LE");
    }

    public static String e(InputStream inputStream) {
        byte[] byArray = new byte[128];
        hk.readFully(inputStream, byArray);
        int n = 0;
        while (n < byArray.length) {
            if (byArray[n] == 0) break;
            ++n;
        }
        return new String(byArray, 0, n, "UTF-8");
    }

    public static void c(OutputStream outputStream, String string) {
        byte[] byArray = string.getBytes("UTF-8");
        if (byArray.length < 128) {
            byte[] byArray2 = new byte[128];
            System.arraycopy(byArray, 0, byArray2, 0, byArray.length);
            byArray2[byArray.length] = 0;
            byArray = byArray2;
        }
        outputStream.write(byArray, 0, 128);
    }
}
