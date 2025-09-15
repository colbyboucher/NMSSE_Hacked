/*
 * Decompiled with CFR 0.152.
 */
package com.formdev.flatlaf.ui;

import com.formdev.flatlaf.util.UIScale;
import java.awt.Dimension;
import javax.swing.JPanel;

class FlatTitlePane.4
extends JPanel {
    FlatTitlePane.4() {
    }

    @Override
    public Dimension getPreferredSize() {
        Dimension size = super.getPreferredSize();
        if (FlatTitlePane.this.buttonMaximizedHeight > 0 && FlatTitlePane.this.isWindowMaximized() && !FlatTitlePane.this.hasVisibleEmbeddedMenuBar(FlatTitlePane.this.rootPane.getJMenuBar())) {
            size = new Dimension(size.width, Math.min(size.height, UIScale.scale(FlatTitlePane.this.buttonMaximizedHeight)));
        }
        return size;
    }
}
