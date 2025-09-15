/*
 * Decompiled with CFR 0.152.
 */
package com.formdev.flatlaf.ui;

import java.awt.Color;
import java.awt.Rectangle;
import java.awt.Window;
import java.util.List;
import javax.swing.event.ChangeListener;

public static interface FlatNativeWindowBorder.Provider {
    public static final int SW_MAXIMIZE = 3;
    public static final int SW_MINIMIZE = 6;
    public static final int SW_RESTORE = 9;

    public boolean hasCustomDecoration(Window var1);

    public void setHasCustomDecoration(Window var1, boolean var2);

    public void updateTitleBarInfo(Window var1, int var2, List<Rectangle> var3, Rectangle var4, Rectangle var5, Rectangle var6, Rectangle var7);

    public boolean showWindow(Window var1, int var2);

    public boolean isColorizationColorAffectsBorders();

    public Color getColorizationColor();

    public int getColorizationColorBalance();

    public void addChangeListener(ChangeListener var1);

    public void removeChangeListener(ChangeListener var1);
}
