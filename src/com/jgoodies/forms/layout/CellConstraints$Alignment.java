/*
 * Decompiled with CFR 0.152.
 */
package com.jgoodies.forms.layout;

import java.io.Serializable;
import java.util.Locale;

public static final class CellConstraints.Alignment
implements Serializable {
    private static final int HORIZONTAL = 0;
    private static final int VERTICAL = 1;
    private static final int BOTH = 2;
    private final transient String name;
    private final transient int orientation;
    private static int nextOrdinal = 0;
    private final int ordinal = nextOrdinal++;

    private CellConstraints.Alignment(String name, int orientation) {
        this.name = name;
        this.orientation = orientation;
    }

    static CellConstraints.Alignment valueOf(String nameOrAbbreviation) {
        String str = nameOrAbbreviation.toLowerCase(Locale.ENGLISH);
        if (str.equals("d") || str.equals("default")) {
            return DEFAULT;
        }
        if (str.equals("f") || str.equals("fill")) {
            return FILL;
        }
        if (str.equals("c") || str.equals("center")) {
            return CENTER;
        }
        if (str.equals("l") || str.equals("left")) {
            return LEFT;
        }
        if (str.equals("r") || str.equals("right")) {
            return RIGHT;
        }
        if (str.equals("t") || str.equals("top")) {
            return TOP;
        }
        if (str.equals("b") || str.equals("bottom")) {
            return BOTTOM;
        }
        throw new IllegalArgumentException("Invalid alignment " + nameOrAbbreviation + ". Must be one of: left, center, right, top, bottom, " + "fill, default, l, c, r, t, b, f, d.");
    }

    public String toString() {
        return this.name;
    }

    public char abbreviation() {
        return this.name.charAt(0);
    }

    private boolean isHorizontal() {
        return this.orientation != 1;
    }

    private boolean isVertical() {
        return this.orientation != 0;
    }

    private Object readResolve() {
        return VALUES[this.ordinal];
    }

    static /* synthetic */ boolean access$100(CellConstraints.Alignment x0) {
        return x0.isHorizontal();
    }

    static /* synthetic */ boolean access$200(CellConstraints.Alignment x0) {
        return x0.isVertical();
    }
}
