/*
 * Decompiled with CFR 0.152.
 */
package com.jgoodies.forms.layout;

import com.jgoodies.forms.layout.Sizes;
import java.io.Serializable;

public static final class ConstantSize.Unit
implements Serializable {
    private final transient String name;
    private final transient String abbreviation;
    private final transient String parseAbbreviation;
    final transient boolean requiresIntegers;
    private static int nextOrdinal = 0;
    private final int ordinal = nextOrdinal++;

    private ConstantSize.Unit(String name, String abbreviation, String parseAbbreviation, boolean requiresIntegers) {
        this.name = name;
        this.abbreviation = abbreviation;
        this.parseAbbreviation = parseAbbreviation;
        this.requiresIntegers = requiresIntegers;
    }

    static ConstantSize.Unit valueOf(String name, boolean horizontal) {
        if (name.length() == 0) {
            ConstantSize.Unit defaultUnit = Sizes.getDefaultUnit();
            if (defaultUnit != null) {
                return defaultUnit;
            }
            return horizontal ? DIALOG_UNITS_X : DIALOG_UNITS_Y;
        }
        if (name.equals("px")) {
            return PIXEL;
        }
        if (name.equals("dlu")) {
            return horizontal ? DIALOG_UNITS_X : DIALOG_UNITS_Y;
        }
        if (name.equals("pt")) {
            return POINT;
        }
        if (name.equals("in")) {
            return INCH;
        }
        if (name.equals("mm")) {
            return MILLIMETER;
        }
        if (name.equals("cm")) {
            return CENTIMETER;
        }
        throw new IllegalArgumentException("Invalid unit name '" + name + "'. Must be one of: " + "px, dlu, pt, mm, cm, in");
    }

    public String toString() {
        return this.name;
    }

    public String encode() {
        return this.parseAbbreviation != null ? this.parseAbbreviation : this.abbreviation;
    }

    public String abbreviation() {
        return this.abbreviation;
    }

    private Object readResolve() {
        return VALUES[this.ordinal];
    }
}
