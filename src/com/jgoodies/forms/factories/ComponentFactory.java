/*
 * Decompiled with CFR 0.152.
 */
package com.jgoodies.forms.factories;

import javax.swing.JComponent;
import javax.swing.JLabel;

public interface ComponentFactory {
    public JLabel createLabel(String var1);

    public JLabel createTitle(String var1);

    public JComponent createSeparator(String var1, int var2);
}
