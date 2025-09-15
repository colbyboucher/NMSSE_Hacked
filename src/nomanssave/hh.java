/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

public class hh {
    private static final long sx = 255L;
    private static final int sy = 12;
    private static final int sz = 96;
    private static final int sA = 48;
    private static final int sB = 12;
    private static final int sC = 192;
    private static final int sD = 96;
    private static final int sE = 24;
    private static final long sF = -2401053088876216593L;
    private final long sG;
    private final long sH;

    private static long a(byte[] byArray, int n) {
        return ((long)byArray[n + 7] & 0xFFL) << 56 | ((long)byArray[n + 6] & 0xFFL) << 48 | ((long)byArray[n + 5] & 0xFFL) << 40 | ((long)byArray[n + 4] & 0xFFL) << 32 | ((long)byArray[n + 3] & 0xFFL) << 24 | ((long)byArray[n + 2] & 0xFFL) << 16 | ((long)byArray[n + 1] & 0xFFL) << 8 | (long)byArray[n] & 0xFFL;
    }

    private static long b(byte[] byArray, int n, int n2) {
        long l = 0L;
        switch (n2) {
            case 7: {
                l += ((long)byArray[n + 6] & 0xFFL) << 48;
            }
            case 6: {
                l += ((long)byArray[n + 5] & 0xFFL) << 40;
            }
            case 5: {
                l += ((long)byArray[n + 4] & 0xFFL) << 32;
            }
            case 4: {
                l += ((long)byArray[n + 3] & 0xFFL) << 24;
            }
            case 3: {
                l += ((long)byArray[n + 2] & 0xFFL) << 16;
            }
            case 2: {
                l += ((long)byArray[n + 1] & 0xFFL) << 8;
            }
            case 1: {
                l += (long)byArray[n] & 0xFFL;
            }
        }
        return l;
    }

    private static void a(byte[] byArray, int n, int n2, long[] lArray) {
        long l = lArray[0];
        long l2 = lArray[1];
        long l3 = -2401053088876216593L;
        long l4 = -2401053088876216593L;
        int n3 = n2;
        int n4 = n;
        while (n3 >= 32) {
            l3 += hh.a(byArray, n4);
            l3 = l3 << 50 | l3 >>> 14;
            l ^= (l3 += (l4 += hh.a(byArray, n4 + 8)));
            l4 = l4 << 52 | l4 >>> 12;
            l2 ^= (l4 += l);
            l = l << 30 | l >>> 34;
            l3 ^= (l += l2);
            l2 = l2 << 41 | l2 >>> 23;
            l4 ^= (l2 += l3);
            l3 = l3 << 54 | l3 >>> 10;
            l ^= (l3 += l4);
            l4 = l4 << 48 | l4 >>> 16;
            l2 ^= (l4 += l);
            l = l << 38 | l >>> 26;
            l3 ^= (l += l2);
            l2 = l2 << 37 | l2 >>> 27;
            l4 ^= (l2 += l3);
            l3 = l3 << 62 | l3 >>> 2;
            l ^= (l3 += l4);
            l4 = l4 << 34 | l4 >>> 30;
            l2 ^= (l4 += l);
            l = l << 5 | l >>> 59;
            l3 ^= (l += l2);
            l2 = l2 << 36 | l2 >>> 28;
            l4 ^= (l2 += l3);
            l += hh.a(byArray, n4 + 16);
            l2 += hh.a(byArray, n4 + 24);
            n4 += 32;
            n3 -= 32;
        }
        if (n3 >= 16) {
            l3 += hh.a(byArray, n4);
            l4 += hh.a(byArray, n4 + 8);
            n4 += 16;
            n3 -= 16;
            l3 = l3 << 50 | l3 >>> 14;
            l ^= (l3 += l4);
            l4 = l4 << 52 | l4 >>> 12;
            l2 ^= (l4 += l);
            l = l << 30 | l >>> 34;
            l3 ^= (l += l2);
            l2 = l2 << 41 | l2 >>> 23;
            l4 ^= (l2 += l3);
            l3 = l3 << 54 | l3 >>> 10;
            l ^= (l3 += l4);
            l4 = l4 << 48 | l4 >>> 16;
            l2 ^= (l4 += l);
            l = l << 38 | l >>> 26;
            l3 ^= (l += l2);
            l2 = l2 << 37 | l2 >>> 27;
            l4 ^= (l2 += l3);
            l3 = l3 << 62 | l3 >>> 2;
            l ^= (l3 += l4);
            l4 = l4 << 34 | l4 >>> 30;
            l2 ^= (l4 += l);
            l = l << 5 | l >>> 59;
            l3 ^= (l += l2);
            l2 = l2 << 36 | l2 >>> 28;
            l4 ^= (l2 += l3);
        }
        l4 += (long)n2 << 56;
        if (n3 >= 8) {
            l3 += hh.a(byArray, n4);
            n4 += 8;
            if ((n3 -= 8) > 0) {
                l4 += hh.b(byArray, n4, n3);
            }
        } else if (n3 > 0) {
            l3 += hh.b(byArray, n4, n3);
        } else {
            l3 += -2401053088876216593L;
            l4 += -2401053088876216593L;
        }
        l4 ^= l3;
        l3 = l3 << 15 | l3 >>> 49;
        l ^= (l4 += l3);
        l4 = l4 << 52 | l4 >>> 12;
        l2 ^= (l += l4);
        l = l << 26 | l >>> 38;
        l3 ^= (l2 += l);
        l2 = l2 << 51 | l2 >>> 13;
        l4 ^= (l3 += l2);
        l3 = l3 << 28 | l3 >>> 36;
        l ^= (l4 += l3);
        l4 = l4 << 9 | l4 >>> 55;
        l2 ^= (l += l4);
        l = l << 47 | l >>> 17;
        l3 ^= (l2 += l);
        l2 = l2 << 54 | l2 >>> 10;
        l4 ^= (l3 += l2);
        l3 = l3 << 32 | l3 >>> 32;
        l ^= (l4 += l3);
        l4 = l4 << 25 | l4 >>> 39;
        l2 ^= (l += l4);
        l = l << 63 | l >>> 1;
        lArray[0] = l;
        lArray[1] = l2 += l;
    }

    public static long b(byte[] byArray, int n, int n2, long[] lArray) {
        long l;
        long l2;
        if (n2 < 192) {
            hh.a(byArray, n, n2, lArray);
            return lArray[0];
        }
        long l3 = l2 = lArray[0];
        long l4 = l2;
        long l5 = l2;
        long l6 = l = lArray[1];
        long l7 = l;
        long l8 = l;
        long l9 = -2401053088876216593L;
        long l10 = -2401053088876216593L;
        long l11 = -2401053088876216593L;
        long l12 = -2401053088876216593L;
        int n3 = n2;
        int n4 = n;
        while (n3 >= 96) {
            l12 ^= l;
            l9 ^= (l5 += hh.a(byArray, n4));
            l5 = l5 << 11 | l5 >>> 53;
            l9 += l8;
            l4 ^= l9;
            l5 ^= (l8 += hh.a(byArray, n4 + 8));
            l8 = l8 << 32 | l8 >>> 32;
            l5 += l12;
            l7 ^= l5;
            l8 ^= (l12 += hh.a(byArray, n4 + 16));
            l12 = l12 << 43 | l12 >>> 21;
            l8 += l4;
            l11 ^= l8;
            l12 ^= (l4 += hh.a(byArray, n4 + 24));
            l4 = l4 << 31 | l4 >>> 33;
            l12 += l7;
            l3 ^= l12;
            l4 ^= (l7 += hh.a(byArray, n4 + 32));
            l7 = l7 << 17 | l7 >>> 47;
            l4 += l11;
            l6 ^= l4;
            l7 ^= (l11 += hh.a(byArray, n4 + 40));
            l11 = l11 << 28 | l11 >>> 36;
            l7 += l3;
            l10 ^= l7;
            l11 ^= (l3 += hh.a(byArray, n4 + 48));
            l3 = l3 << 39 | l3 >>> 25;
            l11 += l6;
            l2 ^= l11;
            l3 ^= (l6 += hh.a(byArray, n4 + 56));
            l6 = l6 << 57 | l6 >>> 7;
            l3 += l10;
            l ^= l3;
            l6 ^= (l10 += hh.a(byArray, n4 + 64));
            l10 = l10 << 55 | l10 >>> 9;
            l6 += l2;
            l9 ^= l6;
            l10 ^= (l2 += hh.a(byArray, n4 + 72));
            l2 = l2 << 54 | l2 >>> 10;
            l10 += l;
            l5 ^= l10;
            l2 ^= (l += hh.a(byArray, n4 + 80));
            l = l << 22 | l >>> 42;
            l2 += l9;
            l8 ^= l2;
            l ^= (l9 += hh.a(byArray, n4 + 88));
            l9 = l9 << 46 | l9 >>> 18;
            l += l5;
            n3 -= 96;
            n4 += 96;
        }
        int n5 = n3 & 7;
        int n6 = n3 >>> 3;
        if (n5 > 0) {
            long l13 = hh.b(byArray, n4 + (n6 << 3), n5);
            switch (n6) {
                case 0: {
                    l5 += l13;
                    break;
                }
                case 1: {
                    l8 += l13;
                    break;
                }
                case 2: {
                    l12 += l13;
                    break;
                }
                case 3: {
                    l4 += l13;
                    break;
                }
                case 4: {
                    l7 += l13;
                    break;
                }
                case 5: {
                    l11 += l13;
                    break;
                }
                case 6: {
                    l3 += l13;
                    break;
                }
                case 7: {
                    l6 += l13;
                    break;
                }
                case 8: {
                    l10 += l13;
                    break;
                }
                case 9: {
                    l2 += l13;
                    break;
                }
                case 10: {
                    l += l13;
                    break;
                }
                case 11: {
                    l9 += l13;
                }
            }
        }
        switch (n6) {
            case 11: {
                l += hh.a(byArray, n4 + 80);
            }
            case 10: {
                l2 += hh.a(byArray, n4 + 72);
            }
            case 9: {
                l10 += hh.a(byArray, n4 + 64);
            }
            case 8: {
                l6 += hh.a(byArray, n4 + 56);
            }
            case 7: {
                l3 += hh.a(byArray, n4 + 48);
            }
            case 6: {
                l11 += hh.a(byArray, n4 + 40);
            }
            case 5: {
                l7 += hh.a(byArray, n4 + 32);
            }
            case 4: {
                l4 += hh.a(byArray, n4 + 24);
            }
            case 3: {
                l12 += hh.a(byArray, n4 + 16);
            }
            case 2: {
                l8 += hh.a(byArray, n4 + 8);
            }
            case 1: {
                l5 += hh.a(byArray, n4);
            }
        }
        l9 += (long)n3 << 56;
        int n7 = 0;
        while (n7 < 3) {
            l12 ^= (l9 += l8);
            l8 = l8 << 44 | l8 >>> 20;
            l4 ^= (l5 += l12);
            l12 = l12 << 15 | l12 >>> 49;
            l7 ^= (l8 += l4);
            l4 = l4 << 34 | l4 >>> 30;
            l11 ^= (l12 += l7);
            l7 = l7 << 21 | l7 >>> 43;
            l3 ^= (l4 += l11);
            l11 = l11 << 38 | l11 >>> 26;
            l6 ^= (l7 += l3);
            l3 = l3 << 33 | l3 >>> 31;
            l10 ^= (l11 += l6);
            l6 = l6 << 10 | l6 >>> 54;
            l2 ^= (l3 += l10);
            l10 = l10 << 13 | l10 >>> 51;
            l ^= (l6 += l2);
            l2 = l2 << 38 | l2 >>> 26;
            l9 ^= (l10 += l);
            l = l << 53 | l >>> 11;
            l5 ^= (l2 += l9);
            l9 = l9 << 42 | l9 >>> 22;
            l8 ^= (l += l5);
            l5 = l5 << 54 | l5 >>> 10;
            ++n7;
        }
        lArray[0] = l5;
        lArray[1] = l8;
        return l5;
    }

    private static long a(CharSequence charSequence, int n) {
        return (long)charSequence.charAt(n + 3) << 48 | (long)charSequence.charAt(n + 2) << 32 | (long)charSequence.charAt(n + 1) << 16 | (long)charSequence.charAt(n);
    }

    private static long a(CharSequence charSequence, int n, int n2) {
        long l = 0L;
        switch (n2) {
            case 3: {
                l += (long)charSequence.charAt(n + 2) << 32;
            }
            case 2: {
                l += (long)charSequence.charAt(n + 1) << 16;
            }
            case 1: {
                l += (long)charSequence.charAt(n);
            }
        }
        return l;
    }

    private static void a(CharSequence charSequence, int n, int n2, long[] lArray) {
        long l = lArray[0];
        long l2 = lArray[1];
        long l3 = -2401053088876216593L;
        long l4 = -2401053088876216593L;
        int n3 = n2;
        int n4 = n;
        while (n3 >= 16) {
            l3 += hh.a(charSequence, n4);
            l3 = l3 << 50 | l3 >>> 14;
            l ^= (l3 += (l4 += hh.a(charSequence, n4 + 4)));
            l4 = l4 << 52 | l4 >>> 12;
            l2 ^= (l4 += l);
            l = l << 30 | l >>> 34;
            l3 ^= (l += l2);
            l2 = l2 << 41 | l2 >>> 23;
            l4 ^= (l2 += l3);
            l3 = l3 << 54 | l3 >>> 10;
            l ^= (l3 += l4);
            l4 = l4 << 48 | l4 >>> 16;
            l2 ^= (l4 += l);
            l = l << 38 | l >>> 26;
            l3 ^= (l += l2);
            l2 = l2 << 37 | l2 >>> 27;
            l4 ^= (l2 += l3);
            l3 = l3 << 62 | l3 >>> 2;
            l ^= (l3 += l4);
            l4 = l4 << 34 | l4 >>> 30;
            l2 ^= (l4 += l);
            l = l << 5 | l >>> 59;
            l3 ^= (l += l2);
            l2 = l2 << 36 | l2 >>> 28;
            l4 ^= (l2 += l3);
            l += hh.a(charSequence, n4 + 8);
            l2 += hh.a(charSequence, n4 + 12);
            n4 += 16;
            n3 -= 16;
        }
        if (n3 >= 8) {
            l3 += hh.a(charSequence, n4);
            l4 += hh.a(charSequence, n4 + 4);
            n4 += 8;
            n3 -= 8;
            l3 = l3 << 50 | l3 >>> 14;
            l ^= (l3 += l4);
            l4 = l4 << 52 | l4 >>> 12;
            l2 ^= (l4 += l);
            l = l << 30 | l >>> 34;
            l3 ^= (l += l2);
            l2 = l2 << 41 | l2 >>> 23;
            l4 ^= (l2 += l3);
            l3 = l3 << 54 | l3 >>> 10;
            l ^= (l3 += l4);
            l4 = l4 << 48 | l4 >>> 16;
            l2 ^= (l4 += l);
            l = l << 38 | l >>> 26;
            l3 ^= (l += l2);
            l2 = l2 << 37 | l2 >>> 27;
            l4 ^= (l2 += l3);
            l3 = l3 << 62 | l3 >>> 2;
            l ^= (l3 += l4);
            l4 = l4 << 34 | l4 >>> 30;
            l2 ^= (l4 += l);
            l = l << 5 | l >>> 59;
            l3 ^= (l += l2);
            l2 = l2 << 36 | l2 >>> 28;
            l4 ^= (l2 += l3);
        }
        l4 += (long)(n2 << 1) << 56;
        if (n3 >= 4) {
            l3 += hh.a(charSequence, n4);
            n4 += 4;
            if ((n3 -= 4) > 0) {
                l4 += hh.a(charSequence, n4, n3);
            }
        } else if (n3 > 0) {
            l3 += hh.a(charSequence, n4, n3);
        } else {
            l3 += -2401053088876216593L;
            l4 += -2401053088876216593L;
        }
        l4 ^= l3;
        l3 = l3 << 15 | l3 >>> 49;
        l ^= (l4 += l3);
        l4 = l4 << 52 | l4 >>> 12;
        l2 ^= (l += l4);
        l = l << 26 | l >>> 38;
        l3 ^= (l2 += l);
        l2 = l2 << 51 | l2 >>> 13;
        l4 ^= (l3 += l2);
        l3 = l3 << 28 | l3 >>> 36;
        l ^= (l4 += l3);
        l4 = l4 << 9 | l4 >>> 55;
        l2 ^= (l += l4);
        l = l << 47 | l >>> 17;
        l3 ^= (l2 += l);
        l2 = l2 << 54 | l2 >>> 10;
        l4 ^= (l3 += l2);
        l3 = l3 << 32 | l3 >>> 32;
        l ^= (l4 += l3);
        l4 = l4 << 25 | l4 >>> 39;
        l2 ^= (l += l4);
        l = l << 63 | l >>> 1;
        lArray[0] = l;
        lArray[1] = l2 += l;
    }

    public static long b(CharSequence charSequence, int n, int n2, long[] lArray) {
        long l;
        long l2;
        if (n2 < 96) {
            hh.a(charSequence, n, n2, lArray);
            return lArray[0];
        }
        long l3 = l2 = lArray[0];
        long l4 = l2;
        long l5 = l2;
        long l6 = l = lArray[1];
        long l7 = l;
        long l8 = l;
        long l9 = -2401053088876216593L;
        long l10 = -2401053088876216593L;
        long l11 = -2401053088876216593L;
        long l12 = -2401053088876216593L;
        int n3 = n2;
        int n4 = n;
        while (n3 >= 48) {
            l12 ^= l;
            l9 ^= (l5 += hh.a(charSequence, n4));
            l5 = l5 << 11 | l5 >>> 53;
            l9 += l8;
            l4 ^= l9;
            l5 ^= (l8 += hh.a(charSequence, n4 + 4));
            l8 = l8 << 32 | l8 >>> 32;
            l5 += l12;
            l7 ^= l5;
            l8 ^= (l12 += hh.a(charSequence, n4 + 8));
            l12 = l12 << 43 | l12 >>> 21;
            l8 += l4;
            l11 ^= l8;
            l12 ^= (l4 += hh.a(charSequence, n4 + 12));
            l4 = l4 << 31 | l4 >>> 33;
            l12 += l7;
            l3 ^= l12;
            l4 ^= (l7 += hh.a(charSequence, n4 + 16));
            l7 = l7 << 17 | l7 >>> 47;
            l4 += l11;
            l6 ^= l4;
            l7 ^= (l11 += hh.a(charSequence, n4 + 20));
            l11 = l11 << 28 | l11 >>> 36;
            l7 += l3;
            l10 ^= l7;
            l11 ^= (l3 += hh.a(charSequence, n4 + 24));
            l3 = l3 << 39 | l3 >>> 25;
            l11 += l6;
            l2 ^= l11;
            l3 ^= (l6 += hh.a(charSequence, n4 + 28));
            l6 = l6 << 57 | l6 >>> 7;
            l3 += l10;
            l ^= l3;
            l6 ^= (l10 += hh.a(charSequence, n4 + 32));
            l10 = l10 << 55 | l10 >>> 9;
            l6 += l2;
            l9 ^= l6;
            l10 ^= (l2 += hh.a(charSequence, n4 + 36));
            l2 = l2 << 54 | l2 >>> 10;
            l10 += l;
            l5 ^= l10;
            l2 ^= (l += hh.a(charSequence, n4 + 40));
            l = l << 22 | l >>> 42;
            l2 += l9;
            l8 ^= l2;
            l ^= (l9 += hh.a(charSequence, n4 + 44));
            l9 = l9 << 46 | l9 >>> 18;
            l += l5;
            n3 -= 48;
            n4 += 48;
        }
        int n5 = n3 & 3;
        int n6 = n3 >> 2;
        if (n5 > 0) {
            long l13 = hh.a(charSequence, n4 + (n6 << 2), n5);
            switch (n6) {
                case 0: {
                    l5 += l13;
                    break;
                }
                case 1: {
                    l8 += l13;
                    break;
                }
                case 2: {
                    l12 += l13;
                    break;
                }
                case 3: {
                    l4 += l13;
                    break;
                }
                case 4: {
                    l7 += l13;
                    break;
                }
                case 5: {
                    l11 += l13;
                    break;
                }
                case 6: {
                    l3 += l13;
                    break;
                }
                case 7: {
                    l6 += l13;
                    break;
                }
                case 8: {
                    l10 += l13;
                    break;
                }
                case 9: {
                    l2 += l13;
                    break;
                }
                case 10: {
                    l += l13;
                    break;
                }
                case 11: {
                    l9 += l13;
                }
            }
        }
        switch (n6) {
            case 11: {
                l += hh.a(charSequence, n4 + 40);
            }
            case 10: {
                l2 += hh.a(charSequence, n4 + 36);
            }
            case 9: {
                l10 += hh.a(charSequence, n4 + 32);
            }
            case 8: {
                l6 += hh.a(charSequence, n4 + 28);
            }
            case 7: {
                l3 += hh.a(charSequence, n4 + 24);
            }
            case 6: {
                l11 += hh.a(charSequence, n4 + 20);
            }
            case 5: {
                l7 += hh.a(charSequence, n4 + 16);
            }
            case 4: {
                l4 += hh.a(charSequence, n4 + 12);
            }
            case 3: {
                l12 += hh.a(charSequence, n4 + 8);
            }
            case 2: {
                l8 += hh.a(charSequence, n4 + 4);
            }
            case 1: {
                l5 += hh.a(charSequence, n4);
            }
        }
        l9 += (long)n3 << 1 << 56;
        int n7 = 0;
        while (n7 < 3) {
            l12 ^= (l9 += l8);
            l8 = l8 << 44 | l8 >>> 20;
            l4 ^= (l5 += l12);
            l12 = l12 << 15 | l12 >>> 49;
            l7 ^= (l8 += l4);
            l4 = l4 << 34 | l4 >>> 30;
            l11 ^= (l12 += l7);
            l7 = l7 << 21 | l7 >>> 43;
            l3 ^= (l4 += l11);
            l11 = l11 << 38 | l11 >>> 26;
            l6 ^= (l7 += l3);
            l3 = l3 << 33 | l3 >>> 31;
            l10 ^= (l11 += l6);
            l6 = l6 << 10 | l6 >>> 54;
            l2 ^= (l3 += l10);
            l10 = l10 << 13 | l10 >>> 51;
            l ^= (l6 += l2);
            l2 = l2 << 38 | l2 >>> 26;
            l9 ^= (l10 += l);
            l = l << 53 | l >>> 11;
            l5 ^= (l2 += l9);
            l9 = l9 << 42 | l9 >>> 22;
            l8 ^= (l += l5);
            l5 = l5 << 54 | l5 >>> 10;
            ++n7;
        }
        lArray[0] = l5;
        lArray[1] = l8;
        return l5;
    }

    private static void a(long[] lArray, int n, int n2, long[] lArray2) {
        long l = lArray2[0];
        long l2 = lArray2[1];
        long l3 = -2401053088876216593L;
        long l4 = -2401053088876216593L;
        int n3 = n2;
        int n4 = n;
        while (n3 >= 4) {
            l3 += lArray[n4];
            l3 = l3 << 50 | l3 >>> 14;
            l ^= (l3 += (l4 += lArray[n4 + 1]));
            l4 = l4 << 52 | l4 >>> 12;
            l2 ^= (l4 += l);
            l = l << 30 | l >>> 34;
            l3 ^= (l += l2);
            l2 = l2 << 41 | l2 >>> 23;
            l4 ^= (l2 += l3);
            l3 = l3 << 54 | l3 >>> 10;
            l ^= (l3 += l4);
            l4 = l4 << 48 | l4 >>> 16;
            l2 ^= (l4 += l);
            l = l << 38 | l >>> 26;
            l3 ^= (l += l2);
            l2 = l2 << 37 | l2 >>> 27;
            l4 ^= (l2 += l3);
            l3 = l3 << 62 | l3 >>> 2;
            l ^= (l3 += l4);
            l4 = l4 << 34 | l4 >>> 30;
            l2 ^= (l4 += l);
            l = l << 5 | l >>> 59;
            l3 ^= (l += l2);
            l2 = l2 << 36 | l2 >>> 28;
            l4 ^= (l2 += l3);
            l += lArray[n4 + 2];
            l2 += lArray[n4 + 3];
            n4 += 4;
            n3 -= 4;
        }
        if (n3 >= 2) {
            l3 += lArray[n4];
            l4 += lArray[n4 + 1];
            n4 += 2;
            n3 -= 2;
            l3 = l3 << 50 | l3 >>> 14;
            l ^= (l3 += l4);
            l4 = l4 << 52 | l4 >>> 12;
            l2 ^= (l4 += l);
            l = l << 30 | l >>> 34;
            l3 ^= (l += l2);
            l2 = l2 << 41 | l2 >>> 23;
            l4 ^= (l2 += l3);
            l3 = l3 << 54 | l3 >>> 10;
            l ^= (l3 += l4);
            l4 = l4 << 48 | l4 >>> 16;
            l2 ^= (l4 += l);
            l = l << 38 | l >>> 26;
            l3 ^= (l += l2);
            l2 = l2 << 37 | l2 >>> 27;
            l4 ^= (l2 += l3);
            l3 = l3 << 62 | l3 >>> 2;
            l ^= (l3 += l4);
            l4 = l4 << 34 | l4 >>> 30;
            l2 ^= (l4 += l);
            l = l << 5 | l >>> 59;
            l3 ^= (l += l2);
            l2 = l2 << 36 | l2 >>> 28;
            l4 ^= (l2 += l3);
        }
        l4 += (long)(n2 << 3) << 56;
        if (n3 > 0) {
            l3 += lArray[n4];
        } else {
            l3 += -2401053088876216593L;
            l4 += -2401053088876216593L;
        }
        l4 ^= l3;
        l3 = l3 << 15 | l3 >>> 49;
        l ^= (l4 += l3);
        l4 = l4 << 52 | l4 >>> 12;
        l2 ^= (l += l4);
        l = l << 26 | l >>> 38;
        l3 ^= (l2 += l);
        l2 = l2 << 51 | l2 >>> 13;
        l4 ^= (l3 += l2);
        l3 = l3 << 28 | l3 >>> 36;
        l ^= (l4 += l3);
        l4 = l4 << 9 | l4 >>> 55;
        l2 ^= (l += l4);
        l = l << 47 | l >>> 17;
        l3 ^= (l2 += l);
        l2 = l2 << 54 | l2 >>> 10;
        l4 ^= (l3 += l2);
        l3 = l3 << 32 | l3 >>> 32;
        l ^= (l4 += l3);
        l4 = l4 << 25 | l4 >>> 39;
        l2 ^= (l += l4);
        l = l << 63 | l >>> 1;
        lArray2[0] = l;
        lArray2[1] = l2 += l;
    }

    public static long b(long[] lArray, int n, int n2, long[] lArray2) {
        long l;
        long l2;
        if (n2 < 24) {
            hh.a(lArray, n, n2, lArray2);
            return lArray2[0];
        }
        long l3 = l2 = lArray2[0];
        long l4 = l2;
        long l5 = l2;
        long l6 = l = lArray2[1];
        long l7 = l;
        long l8 = l;
        long l9 = -2401053088876216593L;
        long l10 = -2401053088876216593L;
        long l11 = -2401053088876216593L;
        long l12 = -2401053088876216593L;
        int n3 = n;
        int n4 = n2;
        while (n4 >= 12) {
            l12 ^= l;
            l9 ^= (l5 += lArray[n3]);
            l5 = l5 << 11 | l5 >>> 53;
            l9 += l8;
            l4 ^= l9;
            l5 ^= (l8 += lArray[n3 + 1]);
            l8 = l8 << 32 | l8 >>> 32;
            l5 += l12;
            l7 ^= l5;
            l8 ^= (l12 += lArray[n3 + 2]);
            l12 = l12 << 43 | l12 >>> 21;
            l8 += l4;
            l11 ^= l8;
            l12 ^= (l4 += lArray[n3 + 3]);
            l4 = l4 << 31 | l4 >>> 33;
            l12 += l7;
            l3 ^= l12;
            l4 ^= (l7 += lArray[n3 + 4]);
            l7 = l7 << 17 | l7 >>> 47;
            l4 += l11;
            l6 ^= l4;
            l7 ^= (l11 += lArray[n3 + 5]);
            l11 = l11 << 28 | l11 >>> 36;
            l7 += l3;
            l10 ^= l7;
            l11 ^= (l3 += lArray[n3 + 6]);
            l3 = l3 << 39 | l3 >>> 25;
            l11 += l6;
            l2 ^= l11;
            l3 ^= (l6 += lArray[n3 + 7]);
            l6 = l6 << 57 | l6 >>> 7;
            l3 += l10;
            l ^= l3;
            l6 ^= (l10 += lArray[n3 + 8]);
            l10 = l10 << 55 | l10 >>> 9;
            l6 += l2;
            l9 ^= l6;
            l10 ^= (l2 += lArray[n3 + 9]);
            l2 = l2 << 54 | l2 >>> 10;
            l10 += l;
            l5 ^= l10;
            l2 ^= (l += lArray[n3 + 10]);
            l = l << 22 | l >>> 42;
            l2 += l9;
            l8 ^= l2;
            l ^= (l9 += lArray[n3 + 11]);
            l9 = l9 << 46 | l9 >>> 18;
            l += l5;
            n3 += 12;
            n4 -= 12;
        }
        switch (n4) {
            case 11: {
                l += lArray[n3 + 10];
            }
            case 10: {
                l2 += lArray[n3 + 9];
            }
            case 9: {
                l10 += lArray[n3 + 8];
            }
            case 8: {
                l6 += lArray[n3 + 7];
            }
            case 7: {
                l3 += lArray[n3 + 6];
            }
            case 6: {
                l11 += lArray[n3 + 5];
            }
            case 5: {
                l7 += lArray[n3 + 4];
            }
            case 4: {
                l4 += lArray[n3 + 3];
            }
            case 3: {
                l12 += lArray[n3 + 2];
            }
            case 2: {
                l8 += lArray[n3 + 1];
            }
            case 1: {
                l5 += lArray[n3];
            }
        }
        l9 += (long)(n4 << 3) << 56;
        int n5 = 0;
        while (n5 < 3) {
            l12 ^= (l9 += l8);
            l8 = l8 << 44 | l8 >>> 20;
            l4 ^= (l5 += l12);
            l12 = l12 << 15 | l12 >>> 49;
            l7 ^= (l8 += l4);
            l4 = l4 << 34 | l4 >>> 30;
            l11 ^= (l12 += l7);
            l7 = l7 << 21 | l7 >>> 43;
            l3 ^= (l4 += l11);
            l11 = l11 << 38 | l11 >>> 26;
            l6 ^= (l7 += l3);
            l3 = l3 << 33 | l3 >>> 31;
            l10 ^= (l11 += l6);
            l6 = l6 << 10 | l6 >>> 54;
            l2 ^= (l3 += l10);
            l10 = l10 << 13 | l10 >>> 51;
            l ^= (l6 += l2);
            l2 = l2 << 38 | l2 >>> 26;
            l9 ^= (l10 += l);
            l = l << 53 | l >>> 11;
            l5 ^= (l2 += l9);
            l9 = l9 << 42 | l9 >>> 22;
            l8 ^= (l += l5);
            l5 = l5 << 54 | l5 >>> 10;
            ++n5;
        }
        lArray2[0] = l5;
        lArray2[1] = l8;
        return l5;
    }

    public hh() {
        this(0L, 0L);
    }

    public hh(long l, long l2) {
        this.sG = l;
        this.sH = l2;
    }

    public static long a(byte[] byArray, long[] lArray) {
        return hh.b(byArray, 0, byArray.length, lArray);
    }

    public long[] c(byte[] byArray, int n, int n2) {
        long[] lArray = new long[]{this.sG, this.sH};
        hh.b(byArray, n, n2, lArray);
        return lArray;
    }

    public long[] j(byte[] byArray) {
        return this.c(byArray, 0, byArray.length);
    }

    public static long a(CharSequence charSequence, long[] lArray) {
        return hh.b(charSequence, 0, charSequence.length(), lArray);
    }

    public long[] b(CharSequence charSequence, int n, int n2) {
        long[] lArray = new long[]{this.sG, this.sH};
        hh.b(charSequence, n, n2, lArray);
        return lArray;
    }

    public long[] a(CharSequence charSequence) {
        return this.b(charSequence, 0, charSequence.length());
    }

    public static long a(long[] lArray, long[] lArray2) {
        return hh.b(lArray, 0, lArray.length, lArray2);
    }

    public long[] b(long[] lArray, int n, int n2) {
        long[] lArray2 = new long[]{this.sG, this.sH};
        hh.b(lArray, n, n2, lArray2);
        return lArray2;
    }

    public long[] b(long[] lArray) {
        return this.b(lArray, 0, lArray.length);
    }
}
