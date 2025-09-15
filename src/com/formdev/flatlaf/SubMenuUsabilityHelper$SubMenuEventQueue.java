/*
 * Decompiled with CFR 0.152.
 */
package com.formdev.flatlaf;

import java.awt.AWTEvent;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import javax.swing.Timer;

private class SubMenuUsabilityHelper.SubMenuEventQueue
extends EventQueue {
    private Timer mouseUpdateTimer = new Timer(50, e -> {
        SubMenuUsabilityHelper.this.mouseX = this.newMouseX;
        SubMenuUsabilityHelper.this.mouseY = this.newMouseY;
        if (SubMenuUsabilityHelper.this.safeTrianglePainter != null) {
            SubMenuUsabilityHelper.this.safeTrianglePainter.repaint();
        }
    });
    private Timer timeoutTimer;
    private int newMouseX;
    private int newMouseY;
    private AWTEvent lastMouseEvent;

    SubMenuUsabilityHelper.SubMenuEventQueue() {
        this.mouseUpdateTimer.setRepeats(false);
        this.timeoutTimer = new Timer(200, e -> {
            if (SubMenuUsabilityHelper.this.invokerBounds != null && !SubMenuUsabilityHelper.this.invokerBounds.contains(this.newMouseX, this.newMouseY)) {
                if (this.lastMouseEvent != null) {
                    this.postEvent(this.lastMouseEvent);
                    this.lastMouseEvent = null;
                }
                SubMenuUsabilityHelper.this.uninstallEventQueue();
                return;
            }
        });
        this.timeoutTimer.setRepeats(false);
        Toolkit.getDefaultToolkit().getSystemEventQueue().push(this);
    }

    void uninstall() {
        this.mouseUpdateTimer.stop();
        this.mouseUpdateTimer = null;
        this.timeoutTimer.stop();
        this.timeoutTimer = null;
        this.lastMouseEvent = null;
        super.pop();
    }

    @Override
    protected void dispatchEvent(AWTEvent e) {
        int id = e.getID();
        if (e instanceof MouseEvent && (id == 503 || id == 506)) {
            this.newMouseX = ((MouseEvent)e).getXOnScreen();
            this.newMouseY = ((MouseEvent)e).getYOnScreen();
            if (SubMenuUsabilityHelper.this.safeTrianglePainter != null) {
                SubMenuUsabilityHelper.this.safeTrianglePainter.repaint();
            }
            this.mouseUpdateTimer.stop();
            this.timeoutTimer.stop();
            if (SubMenuUsabilityHelper.this.createSafeTriangle().contains(this.newMouseX, this.newMouseY)) {
                this.mouseUpdateTimer.start();
                this.timeoutTimer.start();
                this.lastMouseEvent = e;
                return;
            }
            SubMenuUsabilityHelper.this.mouseX = this.newMouseX;
            SubMenuUsabilityHelper.this.mouseY = this.newMouseY;
        }
        super.dispatchEvent(e);
    }
}
