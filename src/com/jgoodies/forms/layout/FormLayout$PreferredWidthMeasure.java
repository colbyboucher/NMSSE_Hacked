/*
 * Decompiled with CFR 0.152.
 */
package com.jgoodies.forms.layout;

import com.jgoodies.forms.layout.FormLayout;
import java.awt.Component;

private static final class FormLayout.PreferredWidthMeasure
extends FormLayout.CachingMeasure {
    private FormLayout.PreferredWidthMeasure(FormLayout.ComponentSizeCache cache) {
        super(cache, null);
    }

    public int sizeOf(Component c) {
        return this.cache.getPreferredSize((Component)c).width;
    }
}
