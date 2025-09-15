/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

public class gW {
    public static void i(byte[] byArray) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Data: " + byArray.length);
        stringBuilder.append(System.lineSeparator());
        stringBuilder.append("  ");
        StringBuilder stringBuilder2 = new StringBuilder();
        int n = 0;
        while (n < byArray.length) {
            stringBuilder.append(Integer.toString((byArray[n] & 0xF0) >> 4, 16));
            stringBuilder.append(Integer.toString(byArray[n] & 0xF, 16));
            if (byArray[n] >= 32 && byArray[n] < 127) {
                stringBuilder2.append((char)(byArray[n] & 0xFF));
            } else {
                stringBuilder2.append('?');
            }
            if (n % 16 == 15) {
                stringBuilder.append("  ");
                stringBuilder.append((CharSequence)stringBuilder2);
                stringBuilder.append(System.lineSeparator());
                stringBuilder.append("  ");
                stringBuilder2 = new StringBuilder();
            }
            ++n;
        }
        if (stringBuilder2.length() > 0) {
            while (stringBuilder2.length() < 16) {
                stringBuilder.append("  ");
                stringBuilder2.append(" ");
            }
            stringBuilder.append("  ");
            stringBuilder.append((CharSequence)stringBuilder2);
        }
        System.out.println(stringBuilder.toString());
    }

    public static void a(long[] lArray) {
        byte[] byArray = new byte[lArray.length * 4];
        int n = 0;
        while (n < lArray.length) {
            byArray[n * 4 + 3] = (byte)(lArray[n] >> 24 & 0xFFL);
            byArray[n * 4 + 2] = (byte)(lArray[n] >> 16 & 0xFFL);
            byArray[n * 4 + 1] = (byte)(lArray[n] >> 8 & 0xFFL);
            byArray[n * 4] = (byte)(lArray[n] & 0xFFL);
            ++n;
        }
        gW.i(byArray);
    }
}
