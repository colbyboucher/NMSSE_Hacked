/*
 * Decompiled with CFR 0.152.
 */
package com.jgoodies.forms.layout;

import com.jgoodies.forms.layout.FormLayout;
import java.awt.Component;

private static final class FormLayout.MinimumWidthMeasure
extends FormLayout.CachingMeasure {
    private FormLayout.MinimumWidthMeasure(FormLayout.ComponentSizeCache cache) {
        super(cache, null);
    }

    public int sizeOf(Component c) {
        return this.cache.getMinimumSize((Component)c).width;
    }
}
