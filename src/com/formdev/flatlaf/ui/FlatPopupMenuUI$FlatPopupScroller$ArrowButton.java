/*
 * Decompiled with CFR 0.152.
 */
package com.formdev.flatlaf.ui;

import com.formdev.flatlaf.ui.FlatArrowButton;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.Timer;

private class FlatPopupMenuUI.FlatPopupScroller.ArrowButton
extends FlatArrowButton
implements MouseListener,
ActionListener {
    private Timer timer;

    FlatPopupMenuUI.FlatPopupScroller.ArrowButton(int direction) {
        super(direction, FlatPopupScroller.this.this$0.arrowType, FlatPopupScroller.this.this$0.scrollArrowColor, null, null, FlatPopupScroller.this.this$0.hoverScrollArrowBackground, null, null);
        this.addMouseListener(this);
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(FlatPopupScroller.this.popup.getBackground());
        g.fillRect(0, 0, this.getWidth(), this.getHeight());
        super.paint(g);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if (this.timer == null) {
            this.timer = new Timer(50, this);
        }
        this.timer.start();
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (this.timer != null) {
            this.timer.stop();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (this.timer != null && !this.isDisplayable()) {
            this.timer.stop();
            return;
        }
        FlatPopupScroller.this.scroll(this.direction == 1 ? -1 : 1);
    }
}
