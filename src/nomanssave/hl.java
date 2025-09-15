/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import nomanssave.eY;
import nomanssave.fa;

public class hl {
    private static final Pattern sN = Pattern.compile("0x([0-9a-fA-F]{1,16})");
    private static final Pattern sO = Pattern.compile("[0-9a-fA-F]{12}");
    private static final Pattern sP = Pattern.compile("([0-9a-fA-F]{4}):([0-9a-fA-F]{4}):([0-9a-fA-F]{4}):([0-9a-fA-F]{4})");
    private int sQ;
    private int sR;
    private int sS;
    private int sT;
    private int sU;
    private int sV;

    private static long aE(String string) {
        long l = 0L;
        int n = 0;
        while (n < string.length()) {
            char c = string.charAt(n);
            l <<= 4;
            l = c >= 'A' && c <= 'F' ? (l |= (long)(c - 55)) : (c >= 'a' && c <= 'f' ? (l |= (long)(c - 87)) : (l |= (long)(c - 48)));
            ++n;
        }
        return l;
    }

    private static int a(long l, int n) {
        int n2 = -1 >>> 32 - n;
        int n3 = (int)(l & (long)n2);
        int n4 = Integer.MIN_VALUE >>> 32 - n;
        if ((n3 & n4) == n4) {
            n3 |= ~n2;
        }
        return n3;
    }

    private static int b(long l, int n) {
        int n2 = -1 >>> 32 - n;
        return (int)(l & (long)n2);
    }

    public static hl e(String string, int n) {
        Matcher matcher = sP.matcher(string);
        if (matcher.matches()) {
            long l = hl.aE(matcher.group(1)) - 2047L;
            if (l > 2047L) {
                throw new RuntimeException("Invalid galactic coordinates");
            }
            long l2 = hl.aE(matcher.group(2)) - 127L;
            if (l2 > 127L) {
                throw new RuntimeException("Invalid galactic coordinates");
            }
            long l3 = hl.aE(matcher.group(3)) - 2047L;
            if (l3 > 2047L) {
                throw new RuntimeException("Invalid galactic coordinates");
            }
            long l4 = hl.aE(matcher.group(4));
            if (l4 > 65535L) {
                throw new RuntimeException("Invalid galactic coordinates");
            }
            return new hl((int)(l4 >> 12 & 0xFL), (int)(l4 & 0xFFFL), n, (int)l2, (int)l3, (int)l);
        }
        matcher = sO.matcher(string);
        if (matcher.matches()) {
            long l = hl.aE(string);
            int n2 = hl.b(l >> 44, 4);
            int n3 = hl.b(l >> 32, 12);
            int n4 = hl.a(l >> 24, 8);
            int n5 = hl.a(l >> 12, 12);
            int n6 = hl.a(l, 12);
            return new hl(n2, n3, n, n4, n5, n6);
        }
        throw new RuntimeException("Unable to decode value");
    }

    public static hl n(Object object) {
        eY eY2;
        if (object == null) {
            return null;
        }
        if (object instanceof Number) {
            long l = ((Number)object).longValue();
            return new hl(l);
        }
        if (object instanceof String) {
            String string = (String)object;
            Matcher matcher = sN.matcher(string);
            if (matcher.matches()) {
                long l = hl.aE(matcher.group(1));
                return new hl(l);
            }
            return hl.e(string, 0);
        }
        if (object instanceof eY && (eY2 = (eY)object).contains("GalacticAddress")) {
            return new hl((eY)object);
        }
        return null;
    }

    private hl(eY eY2) {
        this.sQ = eY2.c("GalacticAddress.PlanetIndex", 0);
        this.sR = eY2.c("GalacticAddress.SolarSystemIndex", 0);
        this.sS = eY2.c("RealityIndex", 0);
        this.sT = eY2.c("GalacticAddress.VoxelY", 0);
        this.sU = eY2.c("GalacticAddress.VoxelZ", 0);
        this.sV = eY2.c("GalacticAddress.VoxelX", 0);
    }

    public hl(long l) {
        this.sQ = hl.b(l >> 52, 12);
        this.sR = hl.b(l >> 40, 12);
        this.sS = hl.b(l >> 32, 8);
        this.sT = hl.a(l >> 24, 8);
        this.sU = hl.a(l >> 12, 12);
        this.sV = hl.a(l >> 0, 12);
    }

    private hl(int n, int n2, int n3, int n4, int n5, int n6) {
        this.sQ = n;
        this.sR = n2;
        this.sS = n3;
        this.sT = n4;
        this.sU = n5;
        this.sV = n6;
    }

    public int eq() {
        return this.sQ;
    }

    public void aL(int n) {
        if (n < 0 || n > 15) {
            throw new RuntimeException("Invalid planet index: " + n);
        }
        this.sQ = n;
    }

    public int er() {
        return this.sR;
    }

    public void aM(int n) {
        if (n < 0 || n > 4095) {
            throw new RuntimeException("Invalid solar system index: " + n);
        }
        this.sR = n;
    }

    public int es() {
        return this.sS;
    }

    public void aN(int n) {
        if (n < 0 || n > 255) {
            throw new RuntimeException("Invalid reality index: " + n);
        }
        this.sS = n;
    }

    public int et() {
        return this.sT;
    }

    public void aO(int n) {
        if (n < -127 || n > 127) {
            throw new RuntimeException("Invalid voxelY coordinate: " + n);
        }
        this.sT = n;
    }

    public int eu() {
        return this.sU;
    }

    public void aP(int n) {
        if (n < -2047 || n > 2047) {
            throw new RuntimeException("Invalid voxelZ coordinate: " + n);
        }
        this.sU = n;
    }

    public int ev() {
        return this.sV;
    }

    public void aQ(int n) {
        if (n < -2047 || n > 2047) {
            throw new RuntimeException("Invalid voxelX coordinate: " + n);
        }
        this.sV = n;
    }

    public eY ew() {
        return new fa().d("RealityIndex", this.sS).d("GalacticAddress", new fa().d("VoxelX", this.sV).d("VoxelY", this.sT).d("VoxelZ", this.sU).d("SolarSystemIndex", this.sR).d("PlanetIndex", this.sQ).bH()).bH();
    }

    public long ex() {
        return ((long)this.sQ & 0xFL) << 52 | ((long)this.sR & 0xFFFL) << 40 | ((long)this.sS & 0xFFL) << 32 | ((long)this.sT & 0xFFL) << 24 | ((long)this.sU & 0xFFFL) << 12 | (long)this.sV & 0xFFFL;
    }

    public String ey() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(Integer.toString(this.sQ & 0xF, 16));
        stringBuilder.append(Integer.toString(this.sR & 0xFFF, 16));
        while (stringBuilder.length() < 4) {
            stringBuilder.insert(1, '0');
        }
        stringBuilder.append(Integer.toString(this.sT & 0xFF, 16));
        while (stringBuilder.length() < 6) {
            stringBuilder.insert(4, '0');
        }
        stringBuilder.append(Integer.toString(this.sU & 0xFFF, 16));
        while (stringBuilder.length() < 9) {
            stringBuilder.insert(6, '0');
        }
        stringBuilder.append(Integer.toString(this.sV & 0xFFF, 16));
        while (stringBuilder.length() < 12) {
            stringBuilder.insert(9, '0');
        }
        return stringBuilder.toString().toUpperCase();
    }

    public String ez() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(Integer.toString(this.sV + 2047, 16));
        while (stringBuilder.length() < 4) {
            stringBuilder.insert(0, '0');
        }
        stringBuilder.append(':');
        stringBuilder.append(Integer.toString(this.sT + 127, 16));
        while (stringBuilder.length() < 9) {
            stringBuilder.insert(5, '0');
        }
        stringBuilder.append(':');
        stringBuilder.append(Integer.toString(this.sU + 2047, 16));
        while (stringBuilder.length() < 14) {
            stringBuilder.insert(10, '0');
        }
        stringBuilder.append(':');
        stringBuilder.append(Integer.toString(this.sQ << 12 | this.sR, 16));
        while (stringBuilder.length() < 19) {
            stringBuilder.insert(15, '0');
        }
        return stringBuilder.toString().toUpperCase();
    }

    public boolean equals(Object object) {
        if (object instanceof hl) {
            hl hl2 = (hl)object;
            if (this.sQ != hl2.sQ) {
                return false;
            }
            if (this.sR != hl2.sR) {
                return false;
            }
            if (this.sS != hl2.sS) {
                return false;
            }
            if (this.sT != hl2.sT) {
                return false;
            }
            if (this.sU != hl2.sU) {
                return false;
            }
            return this.sV == hl2.sV;
        }
        return false;
    }

    public int hashCode() {
        return (int)this.ex();
    }

    public String toString() {
        return "0x" + Long.toString(this.ex(), 16);
    }
}
