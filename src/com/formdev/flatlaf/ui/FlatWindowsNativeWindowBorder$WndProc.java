/*
 * Decompiled with CFR 0.152.
 */
package com.formdev.flatlaf.ui;

import java.awt.Color;
import java.awt.GraphicsConfiguration;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Window;
import java.awt.geom.AffineTransform;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.JFrame;

private class FlatWindowsNativeWindowBorder.WndProc
implements PropertyChangeListener {
    private static final int HTCLIENT = 1;
    private static final int HTCAPTION = 2;
    private static final int HTSYSMENU = 3;
    private static final int HTMINBUTTON = 8;
    private static final int HTMAXBUTTON = 9;
    private static final int HTTOP = 12;
    private static final int HTCLOSE = 20;
    private Window window;
    private final long hwnd;
    private int titleBarHeight;
    private Rectangle[] hitTestSpots;
    private Rectangle appIconBounds;
    private Rectangle minimizeButtonBounds;
    private Rectangle maximizeButtonBounds;
    private Rectangle closeButtonBounds;

    FlatWindowsNativeWindowBorder.WndProc(Window window) {
        this.window = window;
        this.hwnd = this.installImpl(window);
        if (this.hwnd == 0L) {
            return;
        }
        this.updateFrame(this.hwnd, window instanceof JFrame ? ((JFrame)window).getExtendedState() : 0);
        this.updateWindowBackground();
        window.addPropertyChangeListener("background", this);
    }

    void uninstall() {
        this.window.removePropertyChangeListener("background", this);
        this.uninstallImpl(this.hwnd);
        this.window = null;
    }

    @Override
    public void propertyChange(PropertyChangeEvent e) {
        this.updateWindowBackground();
    }

    private void updateWindowBackground() {
        Color bg = this.window.getBackground();
        if (bg != null) {
            this.setWindowBackground(this.hwnd, bg.getRed(), bg.getGreen(), bg.getBlue());
        }
    }

    private native long installImpl(Window var1);

    private native void uninstallImpl(long var1);

    private native void updateFrame(long var1, int var3);

    private native void setWindowBackground(long var1, int var3, int var4, int var5);

    private native void showWindow(long var1, int var3);

    private int onNcHitTest(int x, int y, boolean isOnResizeBorder) {
        boolean isOnTitleBar;
        Point pt = this.scaleDown(x, y);
        int sx = pt.x;
        int sy = pt.y;
        if (this.contains(this.appIconBounds, sx, sy)) {
            return 3;
        }
        if (this.contains(this.minimizeButtonBounds, sx, sy)) {
            return 8;
        }
        if (this.contains(this.maximizeButtonBounds, sx, sy)) {
            return 9;
        }
        if (this.contains(this.closeButtonBounds, sx, sy)) {
            return 20;
        }
        boolean bl = isOnTitleBar = sy < this.titleBarHeight;
        if (isOnTitleBar) {
            Rectangle[] hitTestSpots2;
            for (Rectangle spot : hitTestSpots2 = this.hitTestSpots) {
                if (!spot.contains(sx, sy)) continue;
                return 1;
            }
            return isOnResizeBorder ? 12 : 2;
        }
        return isOnResizeBorder ? 12 : 1;
    }

    private boolean contains(Rectangle rect, int x, int y) {
        return rect != null && rect.contains(x, y);
    }

    private Point scaleDown(int x, int y) {
        GraphicsConfiguration gc = this.window.getGraphicsConfiguration();
        if (gc == null) {
            return new Point(x, y);
        }
        AffineTransform t = gc.getDefaultTransform();
        return new Point(this.clipRound((double)x / t.getScaleX()), this.clipRound((double)y / t.getScaleY()));
    }

    private int clipRound(double value) {
        if ((value -= 0.5) < -2.147483648E9) {
            return Integer.MIN_VALUE;
        }
        if (value > 2.147483647E9) {
            return Integer.MAX_VALUE;
        }
        return (int)Math.ceil(value);
    }

    private boolean isFullscreen() {
        GraphicsConfiguration gc = this.window.getGraphicsConfiguration();
        if (gc == null) {
            return false;
        }
        return gc.getDevice().getFullScreenWindow() == this.window;
    }

    private void fireStateChangedLaterOnce() {
        FlatWindowsNativeWindowBorder.this.fireStateChangedLaterOnce();
    }

    static /* synthetic */ long access$000(FlatWindowsNativeWindowBorder.WndProc x0) {
        return x0.hwnd;
    }

    static /* synthetic */ int access$102(FlatWindowsNativeWindowBorder.WndProc x0, int x1) {
        x0.titleBarHeight = x1;
        return x0.titleBarHeight;
    }

    static /* synthetic */ Rectangle[] access$202(FlatWindowsNativeWindowBorder.WndProc x0, Rectangle[] x1) {
        x0.hitTestSpots = x1;
        return x1;
    }

    static /* synthetic */ Rectangle access$302(FlatWindowsNativeWindowBorder.WndProc x0, Rectangle x1) {
        x0.appIconBounds = x1;
        return x0.appIconBounds;
    }

    static /* synthetic */ Rectangle access$402(FlatWindowsNativeWindowBorder.WndProc x0, Rectangle x1) {
        x0.minimizeButtonBounds = x1;
        return x0.minimizeButtonBounds;
    }

    static /* synthetic */ Rectangle access$502(FlatWindowsNativeWindowBorder.WndProc x0, Rectangle x1) {
        x0.maximizeButtonBounds = x1;
        return x0.maximizeButtonBounds;
    }

    static /* synthetic */ Rectangle access$602(FlatWindowsNativeWindowBorder.WndProc x0, Rectangle x1) {
        x0.closeButtonBounds = x1;
        return x0.closeButtonBounds;
    }

    static /* synthetic */ void access$700(FlatWindowsNativeWindowBorder.WndProc x0, long x1, int x2) {
        x0.showWindow(x1, x2);
    }
}
