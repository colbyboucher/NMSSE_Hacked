/*
 * Decompiled with CFR 0.152.
 */
package com.jgoodies.forms.layout;

import com.jgoodies.forms.layout.FormLayout;
import java.io.Serializable;

private static abstract class FormLayout.CachingMeasure
implements FormLayout.Measure,
Serializable {
    protected final FormLayout.ComponentSizeCache cache;

    private FormLayout.CachingMeasure(FormLayout.ComponentSizeCache cache) {
        this.cache = cache;
    }
}
