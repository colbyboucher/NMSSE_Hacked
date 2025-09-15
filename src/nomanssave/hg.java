/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import java.security.SecureRandom;

public class hg {
    private static final SecureRandom sv = new SecureRandom();
    private final long sw;

    public static hg aB(String string) {
        if (!(string = string.trim()).startsWith("0x")) {
            throw new RuntimeException("Invalid seed: " + string);
        }
        long l = Long.parseUnsignedLong(string.substring(2), 16);
        return new hg(l);
    }

    public static hg eo() {
        return new hg(sv.nextLong());
    }

    public hg(long l) {
        this.sw = l;
    }

    public String toString() {
        return "0x" + Long.toHexString(this.sw).toUpperCase();
    }
}
