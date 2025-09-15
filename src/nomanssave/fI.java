/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import java.io.IOException;

public class fI {
    private static final int mi = 2001;
    private static final int mj = 2002;
    private static final int mk = 2003;
    private static final int ml = 2004;
    private static final int mm = 6;
    private static final int mn = 2004;
    private static final int mo = 384;
    private final int mp;
    private final int lO;
    private int mq;
    private byte[] data;

    private static final boolean ai(int n) {
        return n == 2001 || n == 2002 || n == 2003 || n == 2004;
    }

    private fI(int n, int n2, int n3, byte[] byArray) {
        this.mp = n;
        this.lO = n2;
        this.mq = n3;
        this.data = byArray;
    }

    public int cc() {
        return this.lO;
    }

    public int cd() {
        return this.mq;
    }

    public boolean ce() {
        if (this.mq == 2001) {
            return false;
        }
        if (this.data.length < 376) {
            byte[] byArray = new byte[376];
            System.arraycopy(this.data, 0, byArray, 0, this.data.length);
            this.data = byArray;
        }
        this.mq = 2004;
        return true;
    }

    public byte[] cf() {
        return this.d(24, 32);
    }

    public void e(byte[] byArray) {
        if (byArray.length != 32) {
            throw new IllegalArgumentException("SHA-256 must be 32 bytes");
        }
        this.setBytes(24, byArray);
    }

    public byte[] cg() {
        return this.d(8, 16);
    }

    public void f(byte[] byArray) {
        if (byArray.length != 16) {
            throw new IllegalArgumentException("SpookyHash must be 16 bytes");
        }
        this.setBytes(8, byArray);
    }

    public int ch() {
        return this.getInt(56);
    }

    public void aj(int n) {
        this.setInt(56, n);
    }

    public int ci() {
        return this.getInt(60);
    }

    public void ak(int n) {
        this.setInt(60, n);
    }

    public int cj() {
        return this.getInt(76);
    }

    public void al(int n) {
        this.setInt(76, n);
    }

    public String ck() {
        switch (this.mq) {
            case 2002: 
            case 2003: 
            case 2004: {
                return this.getString(88);
            }
        }
        return null;
    }

    public void Y(String string) {
        switch (this.mq) {
            case 2002: 
            case 2003: 
            case 2004: {
                this.setString(216, string);
                return;
            }
        }
    }

    public String getDescription() {
        switch (this.mq) {
            case 2002: 
            case 2003: 
            case 2004: {
                return this.getString(88);
            }
        }
        return null;
    }

    public void setDescription(String string) {
        switch (this.mq) {
            case 2002: 
            case 2003: 
            case 2004: {
                this.setString(216, string);
                return;
            }
        }
    }

    public static fI am(int n) {
        return new fI(6, n, 2004, new byte[376]);
    }

    public static fI a(int n, byte[] byArray) {
        return fI.a(n, byArray, 0, byArray.length);
    }

    public static fI a(int n, byte[] byArray, int n2, int n3) {
        if (n3 < 8 || n3 % 4 != 0) {
            throw new IOException("Invalid metadata length: " + n3);
        }
        int n4 = n3 == 104 ? 8 : 6;
        long[] lArray = fI.a(byArray, n2, n3);
        long l = 0L;
        int n5 = 0;
        while (n5 < n4) {
            l += 2654435769L;
            l &= 0xFFFFFFFFL;
            ++n5;
        }
        n5 = lArray.length - 1;
        long l2 = (long)(n + 2) ^ 0x1422CB8CL;
        byte[] byArray2 = "NAESEVADNAYRTNRG".getBytes("US-ASCII");
        long[] lArray2 = fI.g(byArray2);
        lArray2[0] = fI.rotateLeft(l2, 13) * 5L + 3864292196L & 0xFFFFFFFFL;
        int n6 = 0;
        while (n6 < n4) {
            int n7 = (int)(l >>> 2 & 3L);
            long l3 = lArray[0];
            int n8 = n5;
            long l4 = 0L;
            int n9 = n5;
            while (n9 > 0) {
                l4 = l3 >> 3 ^ (lArray[n8 - 1] & 0xFFFFFFFL) << 4;
                l4 += l3 * 4L & 0xFFFFFFFFL ^ lArray[n8 - 1] >> 5;
                lArray[n8] = lArray[n8] - (l4 ^= (lArray[n8 - 1] ^ lArray2[n9 & 3 ^ n7]) + (l3 ^ l)) & 0xFFFFFFFFL;
                l3 = lArray[n8--];
                --n9;
            }
            n8 = n5;
            l4 = l3 >> 3 ^ (lArray[n8] & 0xFFFFFFFL) << 4;
            l4 += l3 * 4L & 0xFFFFFFFFL ^ lArray[n8] >> 5;
            lArray[0] = lArray[0] - (l4 ^= (lArray[n8] ^ lArray2[n7]) + (l3 ^ l)) & 0xFFFFFFFFL;
            l += 1640531527L;
            ++n6;
        }
        if (lArray[0] != 0xEEEEEEBEL) {
            throw new IOException("Invalid metadata header: " + Long.toHexString(lArray[0]));
        }
        n6 = (int)lArray[1];
        if (!fI.ai(n6)) {
            throw new IOException("Invalid or unsupported format in metadata header: " + Integer.toHexString(n6));
        }
        byte[] byArray3 = fI.a(lArray, 2, lArray.length - 2);
        return new fI(n4, n, n6, byArray3);
    }

    public byte[] encode() {
        long l = (long)(this.lO + 2) ^ 0x1422CB8CL;
        byte[] byArray = "NAESEVADNAYRTNRG".getBytes("US-ASCII");
        long[] lArray = fI.g(byArray);
        lArray[0] = fI.rotateLeft(l, 13) * 5L + 3864292196L & 0xFFFFFFFFL;
        long[] lArray2 = fI.g(this.data);
        long[] lArray3 = new long[2 + lArray2.length];
        lArray3[0] = 0xEEEEEEBEL;
        lArray3[1] = this.mq;
        System.arraycopy(lArray2, 0, lArray3, 2, lArray2.length);
        int n = lArray3.length - 1;
        long l2 = 0L;
        long l3 = 0L;
        int n2 = 0;
        while (n2 < this.mp) {
            int n3 = (int)((l2 += -1640531527L) >> 2 & 3L);
            int n4 = 0;
            long l4 = 0L;
            int n5 = 0;
            while (n5 < n) {
                l4 = lArray3[n4 + 1] >> 3 ^ (l3 & 0xFFFFFFFL) << 4;
                l4 += lArray3[n4 + 1] * 4L & 0xFFFFFFFFL ^ l3 >> 5;
                lArray3[n4] = lArray3[n4] + (l4 ^= (l3 ^ lArray[n5 & 3 ^ n3]) + (lArray3[n4 + 1] ^ l2)) & 0xFFFFFFFFL;
                l3 = lArray3[n4];
                ++n5;
                ++n4;
            }
            l4 = lArray3[0] >> 3 ^ (l3 & 0xFFFFFFFL) << 4;
            l4 += lArray3[0] * 4L & 0xFFFFFFFFL ^ l3 >> 5;
            lArray3[n] = lArray3[n] + (l4 ^= (l3 ^ lArray[n & 3 ^ n3]) + (lArray3[0] ^ l2)) & 0xFFFFFFFFL;
            l3 = lArray3[n];
            ++n2;
        }
        return fI.a(lArray3, 0, lArray3.length);
    }

    private int getInt(int n) {
        if (n < 8 || n % 4 != 0) {
            throw new IllegalArgumentException("Invalid offset: " + n);
        }
        return this.data[n -= 8] & 0xFF | (this.data[n + 1] & 0xFF) << 8 | (this.data[n + 2] & 0xFF) << 16 | (this.data[n + 3] & 0xFF) << 24;
    }

    private void setInt(int n, int n2) {
        if (n < 8 || n % 4 != 0) {
            throw new IllegalArgumentException("Invalid offset: " + n);
        }
        this.data[n -= 8] = (byte)(n2 & 0xFF);
        this.data[n + 1] = (byte)(n2 >> 8 & 0xFF);
        this.data[n + 2] = (byte)(n2 >> 16 & 0xFF);
        this.data[n + 3] = (byte)(n2 >> 24 & 0xFF);
    }

    private String getString(int n) {
        if (n < 8 || n % 4 != 0) {
            throw new IllegalArgumentException("Invalid offset: " + n);
        }
        int n2 = n -= 8;
        while (n2 < this.data.length) {
            if (this.data[n2] == 0) {
                return new String(this.data, n, n2 - n);
            }
            ++n2;
        }
        return "";
    }

    private void setString(int n, String string) {
        if (n < 8 || n % 4 != 0) {
            throw new IllegalArgumentException("Invalid offset: " + n);
        }
        byte[] byArray = string.getBytes();
        System.arraycopy(byArray, 0, this.data, n -= 8, byArray.length);
        n += byArray.length;
        int n2 = 4 - byArray.length % 4;
        while (n2 > 0) {
            this.data[n++] = 0;
            --n2;
        }
    }

    private byte[] d(int n, int n2) {
        if (n < 8 || n % 4 != 0) {
            throw new IllegalArgumentException("Invalid offset: " + n);
        }
        if (n2 % 4 != 0) {
            throw new IllegalArgumentException("Invalid length: " + n2);
        }
        byte[] byArray = new byte[n2];
        System.arraycopy(this.data, n -= 8, byArray, 0, n2);
        return byArray;
    }

    private void setBytes(int n, byte[] byArray) {
        if (n < 8 || n % 4 != 0) {
            throw new IllegalArgumentException("Invalid offset: " + n);
        }
        if (byArray.length % 4 != 0) {
            throw new IllegalArgumentException("Invalid length: " + byArray.length);
        }
        System.arraycopy(byArray, 0, this.data, n -= 8, byArray.length);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("00000000    ");
        stringBuilder.append("## ## ## ## ## ## ## ## ");
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("########");
        int n = 8;
        int n2 = 0;
        while (n2 < this.data.length) {
            if ((n2 + n) % 16 == 0) {
                stringBuilder.append(System.lineSeparator());
                String string = String.valueOf(Integer.toString((n2 + 1 + n) / 16, 16)) + "0";
                while (string.length() < 8) {
                    string = "0" + string;
                }
                stringBuilder.append(String.valueOf(string) + "    ");
            }
            stringBuilder.append(Integer.toString((this.data[n2] & 0xF0) >> 4, 16));
            stringBuilder.append(Integer.toString(this.data[n2] & 0xF, 16));
            stringBuilder.append(' ');
            if (this.data[n2] == 32) {
                stringBuilder2.append('.');
            } else if (this.data[n2] >= 32 && this.data[n2] < 127) {
                stringBuilder2.append((char)(this.data[n2] & 0xFF));
            } else {
                stringBuilder2.append('?');
            }
            if ((n2 + n) % 16 == 15) {
                stringBuilder.append("   ");
                stringBuilder.append((CharSequence)stringBuilder2);
                stringBuilder2 = new StringBuilder();
            }
            ++n2;
        }
        if (stringBuilder2.length() > 0) {
            while (stringBuilder2.length() < 16) {
                stringBuilder.append("   ");
                stringBuilder2.append(" ");
            }
            stringBuilder.append("   ");
            stringBuilder.append((CharSequence)stringBuilder2);
        }
        return stringBuilder.toString();
    }

    private static long rotateLeft(long l, int n) {
        long l2 = (long)Math.pow(2.0, 32 - n) - 1L;
        return (l & l2) << n | l >>> 32 - n;
    }

    private static byte[] a(long[] lArray, int n, int n2) {
        byte[] byArray = new byte[n2 * 4];
        int n3 = 0;
        while (n3 < n2) {
            byArray[n3 * 4] = (byte)(lArray[n + n3] & 0xFFL);
            byArray[n3 * 4 + 1] = (byte)(lArray[n + n3] >> 8 & 0xFFL);
            byArray[n3 * 4 + 2] = (byte)(lArray[n + n3] >> 16 & 0xFFL);
            byArray[n3 * 4 + 3] = (byte)(lArray[n + n3] >> 24 & 0xFFL);
            ++n3;
        }
        return byArray;
    }

    private static long[] g(byte[] byArray) {
        return fI.a(byArray, 0, byArray.length);
    }

    private static long[] a(byte[] byArray, int n, int n2) {
        long[] lArray = new long[n2 / 4];
        int n3 = 0;
        while (n3 < n2) {
            lArray[n3 / 4] = (long)byArray[n + n3] & 0xFFL | ((long)byArray[n + n3 + 1] & 0xFFL) << 8 | ((long)byArray[n + n3 + 2] & 0xFFL) << 16 | ((long)byArray[n + n3 + 3] & 0xFFL) << 24;
            n3 += 4;
        }
        return lArray;
    }
}
