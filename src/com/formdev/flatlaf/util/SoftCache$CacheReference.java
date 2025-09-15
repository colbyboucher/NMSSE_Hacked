/*
 * Decompiled with CFR 0.152.
 */
package com.formdev.flatlaf.util;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;

private static class SoftCache.CacheReference<K, V>
extends SoftReference<V> {
    final K key;

    SoftCache.CacheReference(K key, V value, ReferenceQueue<? super V> queue) {
        super(value, queue);
        this.key = key;
    }
}
