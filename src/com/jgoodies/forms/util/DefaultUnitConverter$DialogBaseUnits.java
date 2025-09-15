/*
 * Decompiled with CFR 0.152.
 */
package com.jgoodies.forms.util;

private static final class DefaultUnitConverter.DialogBaseUnits {
    final double x;
    final double y;

    DefaultUnitConverter.DialogBaseUnits(double dialogBaseUnitsX, double dialogBaseUnitsY) {
        this.x = dialogBaseUnitsX;
        this.y = dialogBaseUnitsY;
    }

    public String toString() {
        return "DBU(x=" + this.x + "; y=" + this.y + ")";
    }
}
