/*
 * Decompiled with CFR 0.152.
 */
package com.formdev.flatlaf.ui;

import com.formdev.flatlaf.ui.FlatInternalFrameTitlePane;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import javax.swing.plaf.basic.BasicInternalFrameUI;

protected class FlatInternalFrameUI.FlatBorderListener
extends BasicInternalFrameUI.BorderListener {
    protected FlatInternalFrameUI.FlatBorderListener() {
        super(FlatInternalFrameUI.this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        Rectangle iconBounds;
        if (e.getClickCount() == 2 && !FlatInternalFrameUI.this.frame.isIcon() && e.getSource() instanceof FlatInternalFrameTitlePane && (iconBounds = ((FlatInternalFrameTitlePane)e.getSource()).getFrameIconBounds()) != null && iconBounds.contains(e.getX(), e.getY())) {
            if (FlatInternalFrameUI.this.frame.isClosable()) {
                FlatInternalFrameUI.this.frame.doDefaultCloseAction();
            }
            return;
        }
        super.mouseClicked(e);
    }
}
