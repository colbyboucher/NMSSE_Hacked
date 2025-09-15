/*
 * Decompiled with CFR 0.152.
 */
package com.formdev.flatlaf.ui;

import java.util.Map;
import javax.swing.JComponent;

public static interface FlatStylingSupport.StyleableUI {
    public Map<String, Class<?>> getStyleableInfos(JComponent var1);

    public Object getStyleableValue(JComponent var1, String var2);
}
