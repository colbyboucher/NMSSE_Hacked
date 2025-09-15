/*
 * Decompiled with CFR 0.152.
 */
package com.formdev.flatlaf.ui;

import java.util.Map;

public static interface FlatStylingSupport.StyleableBorder {
    public Object applyStyleProperty(String var1, Object var2);

    public Map<String, Class<?>> getStyleableInfos();

    public Object getStyleableValue(String var1);
}
