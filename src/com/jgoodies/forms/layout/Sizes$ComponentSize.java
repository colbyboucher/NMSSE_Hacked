/*
 * Decompiled with CFR 0.152.
 */
package com.jgoodies.forms.layout;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.Size;
import java.awt.Component;
import java.awt.Container;
import java.io.Serializable;
import java.util.Iterator;
import java.util.List;

static final class Sizes.ComponentSize
implements Size,
Serializable {
    private final transient String name;
    private static int nextOrdinal = 0;
    private final int ordinal = nextOrdinal++;

    private Sizes.ComponentSize(String name) {
        this.name = name;
    }

    static Sizes.ComponentSize valueOf(String str) {
        if (str.equals("m") || str.equals("min")) {
            return MINIMUM;
        }
        if (str.equals("p") || str.equals("pref")) {
            return PREFERRED;
        }
        if (str.equals("d") || str.equals("default")) {
            return DEFAULT;
        }
        return null;
    }

    public int maximumSize(Container container, List components, FormLayout.Measure minMeasure, FormLayout.Measure prefMeasure, FormLayout.Measure defaultMeasure) {
        FormLayout.Measure measure = this == MINIMUM ? minMeasure : (this == PREFERRED ? prefMeasure : defaultMeasure);
        int maximum = 0;
        Iterator i = components.iterator();
        while (i.hasNext()) {
            Component c = (Component)i.next();
            maximum = Math.max(maximum, measure.sizeOf(c));
        }
        return maximum;
    }

    public boolean compressible() {
        return this == DEFAULT;
    }

    public String toString() {
        return this.encode();
    }

    public String encode() {
        return this.name.substring(0, 1);
    }

    private Object readResolve() {
        return VALUES[this.ordinal];
    }
}
