/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import java.nio.charset.Charset;

public class fg {
    private static final Charset kT = Charset.forName("Windows-1252");
    final byte[] bytes;

    public fg(byte[] byArray) {
        this.bytes = byArray;
    }

    byte[] toByteArray() {
        byte[] byArray = new byte[this.bytes.length];
        System.arraycopy(this.bytes, 0, byArray, 0, this.bytes.length);
        return byArray;
    }

    public int indexOf(int n) {
        return this.indexOf(n, 0);
    }

    public int indexOf(int n, int n2) {
        int n3 = n2;
        while (n3 < this.bytes.length) {
            if (n == (this.bytes[n3] & 0xFF)) {
                return n3;
            }
            ++n3;
        }
        return -1;
    }

    public String substring(int n) {
        return this.substring(n, this.bytes.length - n);
    }

    public String substring(int n, int n2) {
        return new String(this.bytes, n, n2, kT);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public String bP() {
        StringBuilder stringBuilder = new StringBuilder();
        boolean bl = false;
        int n = 0;
        while (n < this.bytes.length) {
            int n2 = this.bytes[n] & 0xFF;
            if (n == 0) {
                if (n2 != 94) return this.toString();
                stringBuilder.append('^');
            } else if (n2 == 35) {
                stringBuilder.append('#');
                bl = true;
            } else if (bl) {
                stringBuilder.append((char)n2);
            } else {
                stringBuilder.append("0123456789ABCDEFabcdef".charAt((this.bytes[n] & 0xF0) >> 4));
                stringBuilder.append("0123456789ABCDEFabcdef".charAt(this.bytes[n] & 0xF));
            }
            ++n;
        }
        return stringBuilder.toString();
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (object instanceof fg) {
            fg fg2 = (fg)object;
            if (this.bytes.length != fg2.bytes.length) {
                return false;
            }
            int n = 0;
            while (n < this.bytes.length) {
                if (this.bytes[n] != fg2.bytes[n]) {
                    return false;
                }
                ++n;
            }
            return true;
        }
        return false;
    }

    public String toString() {
        return new String(this.bytes, kT);
    }
}
