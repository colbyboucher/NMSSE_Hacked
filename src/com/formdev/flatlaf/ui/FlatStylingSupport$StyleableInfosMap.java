/*
 * Decompiled with CFR 0.152.
 */
package com.formdev.flatlaf.ui;

import java.util.LinkedHashMap;
import java.util.Map;

static class FlatStylingSupport.StyleableInfosMap<K, V>
extends LinkedHashMap<K, V> {
    FlatStylingSupport.StyleableInfosMap() {
    }

    @Override
    public V put(K key, V value) {
        V oldValue = super.put(key, value);
        if (oldValue != null) {
            throw new IllegalArgumentException("duplicate key '" + key + "'");
        }
        return oldValue;
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {
        for (Map.Entry<K, V> e : m.entrySet()) {
            this.put(e.getKey(), e.getValue());
        }
    }
}
