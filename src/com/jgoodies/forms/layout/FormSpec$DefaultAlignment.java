/*
 * Decompiled with CFR 0.152.
 */
package com.jgoodies.forms.layout;

import java.io.Serializable;

public static final class FormSpec.DefaultAlignment
implements Serializable {
    private final transient String name;
    private static int nextOrdinal = 0;
    private final int ordinal = nextOrdinal++;

    private FormSpec.DefaultAlignment(String name) {
        this.name = name;
    }

    private static FormSpec.DefaultAlignment valueOf(String str, boolean isHorizontal) {
        if (str.equals("f") || str.equals("fill")) {
            return FILL_ALIGN;
        }
        if (str.equals("c") || str.equals("center")) {
            return CENTER_ALIGN;
        }
        if (isHorizontal) {
            if (str.equals("r") || str.equals("right")) {
                return RIGHT_ALIGN;
            }
            if (str.equals("l") || str.equals("left")) {
                return LEFT_ALIGN;
            }
            return null;
        }
        if (str.equals("t") || str.equals("top")) {
            return TOP_ALIGN;
        }
        if (str.equals("b") || str.equals("bottom")) {
            return BOTTOM_ALIGN;
        }
        return null;
    }

    public String toString() {
        return this.name;
    }

    public char abbreviation() {
        return this.name.charAt(0);
    }

    private Object readResolve() {
        return VALUES[this.ordinal];
    }

    static /* synthetic */ FormSpec.DefaultAlignment access$100(String x0, boolean x1) {
        return FormSpec.DefaultAlignment.valueOf(x0, x1);
    }
}
