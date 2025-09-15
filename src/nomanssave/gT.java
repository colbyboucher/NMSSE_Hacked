/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import java.math.BigDecimal;
import java.math.RoundingMode;
import nomanssave.gU;

public class gT {
    static final int rT = 12;
    private static final double rU = 0.1;
    private final double[] rV;
    private final double[] rW;
    private final double[] rX;

    private static double[] b(double[] dArray) {
        double d = Math.sqrt(dArray[0] * dArray[0] + dArray[1] * dArray[1] + dArray[2] * dArray[2]);
        if (d < 0.1) {
            throw new RuntimeException("vector cannot be normalized");
        }
        return new double[]{dArray[0] / d, dArray[1] / d, dArray[2] / d};
    }

    public gT() {
        this.rX = new double[]{0.0, 0.0, 1.0};
        this.rW = new double[]{0.0, 1.0, 0.0};
        this.rV = new double[]{1.0, 0.0, 0.0};
    }

    public gT(double[] dArray, double[] dArray2) {
        double d = Math.sqrt(dArray[0] * dArray[0] + dArray[1] * dArray[1] + dArray[2] * dArray[2]);
        if (d < 0.1) {
            if (dArray2[0] != 0.0 || dArray2[1] != 0.0 || dArray2[2] != 1.0) {
                throw new RuntimeException("Unable to calculate base structures");
            }
            this.rX = new double[]{0.0, 0.0, 1.0};
            this.rW = new double[]{0.0, 1.0, 0.0};
            this.rV = new double[]{1.0, 0.0, 0.0};
        } else {
            dArray = new double[]{dArray[0] / d, dArray[1] / d, dArray[2] / d};
            dArray2 = gT.b(dArray2);
            double d2 = dArray2[0] * dArray[0] + dArray2[1] * dArray[1] + dArray2[2] * dArray[2];
            this.rX = dArray2;
            this.rW = gT.b(new double[]{dArray[0] - d2 * dArray2[0], dArray[1] - d2 * dArray2[1], dArray[2] - d2 * dArray2[2]});
            this.rV = gT.b(new double[]{this.rW[1] * dArray2[2] - this.rW[2] * dArray2[1], this.rW[2] * dArray2[0] - this.rW[0] * dArray2[2], this.rW[0] * dArray2[1] - this.rW[1] * dArray2[0]});
        }
    }

    private static double[] a(double d, double[] dArray, double[] dArray2) {
        double d2 = Math.cos(d);
        double d3 = -Math.sin(d);
        double d4 = dArray2[0];
        double d5 = dArray2[1];
        double d6 = dArray2[2];
        double[][] dArray3 = new double[3][3];
        dArray3[0][0] = d4 * d4 * (1.0 - d2) + d2;
        dArray3[0][1] = d4 * d5 * (1.0 - d2) + d6 * d3;
        dArray3[0][2] = d4 * d6 * (1.0 - d2) - d5 * d3;
        dArray3[1][0] = d4 * d5 * (1.0 - d2) - d6 * d3;
        dArray3[1][1] = d5 * d5 * (1.0 - d2) + d2;
        dArray3[1][2] = d5 * d6 * (1.0 - d2) + d4 * d3;
        dArray3[2][0] = d4 * d6 * (1.0 - d2) + d5 * d3;
        dArray3[2][1] = d5 * d6 * (1.0 - d2) - d4 * d3;
        dArray3[2][2] = d6 * d6 * (1.0 - d2) + d2;
        double d7 = dArray[0] * dArray3[0][0] + dArray[1] * dArray3[1][0] + dArray[2] * dArray3[2][0];
        double d8 = dArray[0] * dArray3[0][1] + dArray[1] * dArray3[1][1] + dArray[2] * dArray3[2][1];
        double d9 = dArray[0] * dArray3[0][2] + dArray[1] * dArray3[1][2] + dArray[2] * dArray3[2][2];
        double d10 = Math.sqrt(d7 * d7 + d8 * d8 + d9 * d9);
        return new double[]{d7 / d10, d8 / d10, d9 / d10};
    }

    public double[] a(gU gU2) {
        if (gU2.rY.equals("fr")) {
            return gT.a(gU2.rZ, this.rX, this.rV);
        }
        if (gU2.rY.equals("fu")) {
            return gT.a(gU2.rZ, this.rX, this.rW);
        }
        if (gU2.rY.equals("ur")) {
            return gT.a(gU2.rZ, this.rW, this.rV);
        }
        if (gU2.rY.equals("uf")) {
            return gT.a(gU2.rZ, this.rW, this.rX);
        }
        if (gU2.rY.equals("ru")) {
            return gT.a(gU2.rZ, this.rV, this.rW);
        }
        if (gU2.rY.equals("rf")) {
            return gT.a(gU2.rZ, this.rV, this.rX);
        }
        throw new RuntimeException("Unsupported rotation axis");
    }

    public double[] c(double[] dArray) {
        double d = dArray[0] * this.rV[0] + dArray[1] * this.rW[0] + dArray[2] * this.rX[0];
        double d2 = dArray[0] * this.rV[1] + dArray[1] * this.rW[1] + dArray[2] * this.rX[1];
        double d3 = dArray[0] * this.rV[2] + dArray[1] * this.rW[2] + dArray[2] * this.rX[2];
        return new double[]{d, d2, d3};
    }

    public double[] d(double[] dArray) {
        double d = dArray[0] * this.rV[0] + dArray[1] * this.rV[1] + dArray[2] * this.rV[2];
        double d2 = dArray[0] * this.rW[0] + dArray[1] * this.rW[1] + dArray[2] * this.rW[2];
        double d3 = dArray[0] * this.rX[0] + dArray[1] * this.rX[1] + dArray[2] * this.rX[2];
        return new double[]{d, d2, d3};
    }

    private void a(double[] dArray, StringBuffer stringBuffer, StringBuffer stringBuffer2, StringBuffer stringBuffer3, int n) {
        int n2 = stringBuffer.length();
        stringBuffer.append(gT.a(dArray[0], n));
        stringBuffer2.append(gT.a(dArray[1], n));
        stringBuffer3.append(gT.a(dArray[2], n));
        int n3 = Math.max(Math.max(stringBuffer.length(), stringBuffer2.length()), stringBuffer3.length());
        while (stringBuffer.length() < n3) {
            stringBuffer.insert(n2, ' ');
        }
        while (stringBuffer2.length() < n3) {
            stringBuffer2.insert(n2, ' ');
        }
        while (stringBuffer3.length() < n3) {
            stringBuffer3.insert(n2, ' ');
        }
    }

    private void a(StringBuffer stringBuffer, StringBuffer stringBuffer2, StringBuffer stringBuffer3, int n) {
        int n2 = Math.max(Math.max(stringBuffer.length(), stringBuffer2.length()), stringBuffer3.length());
        while (stringBuffer.length() < n2) {
            stringBuffer.append(' ');
        }
        while (stringBuffer2.length() < n2) {
            stringBuffer2.append(' ');
        }
        while (stringBuffer3.length() < n2) {
            stringBuffer3.append(' ');
        }
        stringBuffer.append("| ");
        stringBuffer2.append("| ");
        stringBuffer3.append("| ");
        this.a(this.rV, stringBuffer, stringBuffer2, stringBuffer3, n);
        stringBuffer.append(' ');
        stringBuffer2.append(' ');
        stringBuffer3.append(' ');
        this.a(this.rW, stringBuffer, stringBuffer2, stringBuffer3, n);
        stringBuffer.append(' ');
        stringBuffer2.append(' ');
        stringBuffer3.append(' ');
        this.a(this.rX, stringBuffer, stringBuffer2, stringBuffer3, n);
        stringBuffer.append(" |");
        stringBuffer2.append(" |");
        stringBuffer3.append(" |");
    }

    public String toString() {
        return this.toString(12);
    }

    public String toString(int n) {
        StringBuffer stringBuffer = new StringBuffer();
        StringBuffer stringBuffer2 = new StringBuffer();
        StringBuffer stringBuffer3 = new StringBuffer();
        this.a(stringBuffer, stringBuffer2, stringBuffer3, n);
        StringBuffer stringBuffer4 = new StringBuffer();
        stringBuffer4.append(stringBuffer).append("\n");
        stringBuffer4.append(stringBuffer2).append("\n");
        stringBuffer4.append(stringBuffer3).append("\n");
        return stringBuffer4.toString();
    }

    static String e(double[] dArray) {
        return gT.a(dArray, 12);
    }

    static String a(double[] dArray, int n) {
        return "[ " + gT.b(dArray[0], n) + " , " + gT.b(dArray[1], n) + " , " + gT.b(dArray[2], n) + " ]";
    }

    static String f(double[] dArray) {
        return gT.b(dArray, 12);
    }

    static String b(double[] dArray, int n) {
        return "[ " + gT.b(dArray[0], n) + " , " + gT.b(dArray[1], n) + " , " + gT.b(dArray[2], n) + " , " + gT.b(dArray[3], n) + " ]";
    }

    static String a(double d, int n) {
        if (Double.isInfinite(d)) {
            return "Infinite";
        }
        if (Double.isNaN(d)) {
            return "NaN";
        }
        BigDecimal bigDecimal = new BigDecimal(d);
        bigDecimal = bigDecimal.setScale(n, RoundingMode.HALF_UP);
        return bigDecimal.toPlainString();
    }

    /*
     * Unable to fully structure code
     */
    static String b(double var0, int var2_1) {
        if (Double.isInfinite(var0)) {
            return "Infinite";
        }
        if (Double.isNaN(var0)) {
            return "NaN";
        }
        var3_2 = new BigDecimal(var0);
        var3_2 = var3_2.setScale(var2_1, RoundingMode.HALF_UP);
        var4_3 = var3_2.toPlainString();
        if (var2_1 > 0) ** GOTO lbl11
        return var4_3;
lbl-1000:
        // 1 sources

        {
            var4_3 = var4_3.substring(0, var4_3.length() - 1);
lbl11:
            // 2 sources

            ** while (var4_3.endsWith((String)"0") && !var4_3.endsWith((String)".0"))
        }
lbl12:
        // 1 sources

        return var4_3;
    }
}
