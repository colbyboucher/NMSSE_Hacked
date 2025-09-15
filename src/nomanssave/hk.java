/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class hk {
    private static final String sM = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/";

    public static String k(byte[] byArray) {
        int n;
        StringBuilder stringBuilder = new StringBuilder();
        int n2 = 0;
        while (n2 + 3 <= byArray.length) {
            n = (0xFF & byArray[n2]) << 16 | (0xFF & byArray[n2 + 1]) << 8 | 0xFF & byArray[n2 + 2];
            stringBuilder.append(sM.charAt((0xFC0000 & n) >> 18));
            stringBuilder.append(sM.charAt((0x3F000 & n) >> 12));
            stringBuilder.append(sM.charAt((0xFC0 & n) >> 6));
            stringBuilder.append(sM.charAt(0x3F & n));
            n2 += 3;
        }
        if (n2 + 2 == byArray.length) {
            n = (0xFF & byArray[n2]) << 16 | (0xFF & byArray[n2 + 1]) << 8;
            stringBuilder.append(sM.charAt((0xFC0000 & n) >> 18));
            stringBuilder.append(sM.charAt((0x3F000 & n) >> 12));
            stringBuilder.append(sM.charAt((0xFC0 & n) >> 6));
        }
        if (n2 + 1 == byArray.length) {
            n = (0xFF & byArray[n2]) << 16;
            stringBuilder.append(sM.charAt((0xFC0000 & n) >> 18));
            stringBuilder.append(sM.charAt((0x3F000 & n) >> 12));
        }
        return stringBuilder.toString();
    }

    public static byte[] aD(String string) {
        int n;
        int n2;
        int n3;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int n4 = 0;
        while (n4 + 4 <= string.length()) {
            n3 = sM.indexOf(string.charAt(n4));
            n2 = sM.indexOf(string.charAt(n4 + 1));
            n = sM.indexOf(string.charAt(n4 + 2));
            int n5 = sM.indexOf(string.charAt(n4 + 3));
            if (n3 < 0 || n2 < 0 || n < 0 || n5 < 0) {
                throw new RuntimeException("Invalid base64 character");
            }
            byteArrayOutputStream.write(n3 << 2 | n2 >> 4);
            byteArrayOutputStream.write((0xF & n2) << 4 | n >> 2);
            byteArrayOutputStream.write((3 & n) << 6 | n5);
            n4 += 4;
        }
        if (n4 + 3 == string.length()) {
            n3 = sM.indexOf(string.charAt(n4));
            n2 = sM.indexOf(string.charAt(n4 + 1));
            n = sM.indexOf(string.charAt(n4 + 2));
            if (n3 < 0 || n2 < 0 || n < 0) {
                throw new RuntimeException("Invalid base64 character");
            }
            byteArrayOutputStream.write(n3 << 2 | n2 >> 4);
            byteArrayOutputStream.write((0xF & n2) << 4 | n >> 2);
        }
        if (n4 + 2 == string.length()) {
            n3 = sM.indexOf(string.charAt(n4));
            n2 = sM.indexOf(string.charAt(n4 + 1));
            if (n3 < 0 || n2 < 0) {
                throw new RuntimeException("Invalid base64 character");
            }
            byteArrayOutputStream.write(n3 << 2 | n2 >> 4);
        }
        if (n4 + 1 == string.length()) {
            throw new RuntimeException("Unfinished base64 data");
        }
        return byteArrayOutputStream.toByteArray();
    }

    public static int readInt(InputStream inputStream) {
        byte[] byArray = new byte[4];
        hk.readFully(inputStream, byArray);
        return (0xFF & byArray[3]) << 24 | (0xFF & byArray[2]) << 16 | (0xFF & byArray[1]) << 8 | 0xFF & byArray[0];
    }

    public static void a(OutputStream outputStream, int n) {
        outputStream.write(0xFF & n);
        outputStream.write(0xFF & n >> 8);
        outputStream.write(0xFF & n >> 16);
        outputStream.write(0xFF & n >> 24);
    }

    public static long f(InputStream inputStream) {
        byte[] byArray = new byte[8];
        hk.readFully(inputStream, byArray);
        return (0xFFL & (long)byArray[7]) << 56 | (0xFFL & (long)byArray[6]) << 48 | (0xFFL & (long)byArray[5]) << 40 | (0xFFL & (long)byArray[4]) << 32 | (0xFFL & (long)byArray[3]) << 24 | (0xFFL & (long)byArray[2]) << 16 | (0xFFL & (long)byArray[1]) << 8 | 0xFFL & (long)byArray[0];
    }

    public static void b(OutputStream outputStream, long l) {
        outputStream.write((int)(0xFFL & l));
        outputStream.write((int)(0xFFL & l >> 8));
        outputStream.write((int)(0xFFL & l >> 16));
        outputStream.write((int)(0xFFL & l >> 24));
        outputStream.write((int)(0xFFL & l >> 32));
        outputStream.write((int)(0xFFL & l >> 40));
        outputStream.write((int)(0xFFL & l >> 48));
        outputStream.write((int)(0xFFL & l >> 56));
    }

    public static byte[] l(File file) {
        try (FileInputStream fileInputStream = new FileInputStream(file);){
            byte[] byArray = hk.g(fileInputStream);
            return byArray;
        }
    }

    public static byte[] g(InputStream inputStream) {
        int n;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] byArray = new byte[4096];
        while ((n = inputStream.read(byArray)) >= 0) {
            byteArrayOutputStream.write(byArray, 0, n);
        }
        return byteArrayOutputStream.toByteArray();
    }

    public static void readFully(InputStream inputStream, byte[] byArray) {
        hk.readFully(inputStream, byArray, 0, byArray.length);
    }

    public static void readFully(InputStream inputStream, byte[] byArray, int n, int n2) {
        int n3;
        while (n2 > 0 && (n3 = inputStream.read(byArray, n, n2)) > 0) {
            n += n3;
            n2 -= n3;
        }
        if (n2 != 0) {
            throw new IOException("short read");
        }
    }
}
