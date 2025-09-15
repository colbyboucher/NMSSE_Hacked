/*
 * Decompiled with CFR 0.152.
 */
package com.formdev.flatlaf;

import java.util.List;
import java.util.Locale;
import java.util.function.Function;
import javax.swing.UIDefaults;

private class FlatLaf.FlatUIDefaults
extends UIDefaults {
    FlatLaf.FlatUIDefaults(int initialCapacity, float loadFactor) {
        super(initialCapacity, loadFactor);
    }

    @Override
    public Object get(Object key) {
        Object value = this.getValue(key);
        return value != null ? (value != NULL_VALUE ? value : null) : super.get(key);
    }

    @Override
    public Object get(Object key, Locale l) {
        Object value = this.getValue(key);
        return value != null ? (value != NULL_VALUE ? value : null) : super.get(key, l);
    }

    private Object getValue(Object key) {
        List uiDefaultsGetters = FlatLaf.this.uiDefaultsGetters;
        if (uiDefaultsGetters == null) {
            return null;
        }
        for (int i = uiDefaultsGetters.size() - 1; i >= 0; --i) {
            Object value = ((Function)uiDefaultsGetters.get(i)).apply(key);
            if (value == null) continue;
            return value;
        }
        return null;
    }
}
