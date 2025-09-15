/*
 * Decompiled with CFR 0.152.
 */
package com.formdev.flatlaf.ui;

import com.formdev.flatlaf.ui.FlatNativeLinuxLibrary;
import com.formdev.flatlaf.ui.FlatNativeWindowBorder;
import com.formdev.flatlaf.util.SystemInfo;
import java.awt.Frame;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.SwingUtilities;

protected class FlatTitlePane.Handler
extends WindowAdapter
implements PropertyChangeListener,
MouseListener,
MouseMotionListener,
ComponentListener {
    private Point dragOffset;
    private boolean linuxNativeMove;
    private long lastSingleClickWhen;

    protected FlatTitlePane.Handler() {
    }

    @Override
    public void propertyChange(PropertyChangeEvent e) {
        switch (e.getPropertyName()) {
            case "title": {
                FlatTitlePane.this.titleLabel.setText(FlatTitlePane.this.getWindowTitle());
                break;
            }
            case "resizable": {
                if (!(FlatTitlePane.this.window instanceof Frame)) break;
                FlatTitlePane.this.frameStateChanged();
                break;
            }
            case "iconImage": {
                FlatTitlePane.this.updateIcon();
                break;
            }
            case "componentOrientation": {
                FlatTitlePane.this.updateNativeTitleBarHeightAndHitTestSpotsLater();
            }
        }
    }

    @Override
    public void windowActivated(WindowEvent e) {
        FlatTitlePane.this.activeChanged(true);
        FlatTitlePane.this.updateNativeTitleBarHeightAndHitTestSpots();
        if (!SystemInfo.isWindows_11_orLater && FlatTitlePane.this.hasNativeCustomDecoration()) {
            FlatNativeWindowBorder.WindowTopBorder.getInstance().repaintBorder(FlatTitlePane.this);
        }
        FlatTitlePane.this.repaintWindowBorder();
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
        FlatTitlePane.this.activeChanged(false);
        FlatTitlePane.this.updateNativeTitleBarHeightAndHitTestSpots();
        if (!SystemInfo.isWindows_11_orLater && FlatTitlePane.this.hasNativeCustomDecoration()) {
            FlatNativeWindowBorder.WindowTopBorder.getInstance().repaintBorder(FlatTitlePane.this);
        }
        FlatTitlePane.this.repaintWindowBorder();
    }

    @Override
    public void windowStateChanged(WindowEvent e) {
        FlatTitlePane.this.frameStateChanged();
        FlatTitlePane.this.updateNativeTitleBarHeightAndHitTestSpots();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (this.linuxNativeMove && SystemInfo.isLinux && FlatNativeLinuxLibrary.isWMUtilsSupported(FlatTitlePane.this.window)) {
            if (this.lastSingleClickWhen != 0L && e.getWhen() - this.lastSingleClickWhen <= (long)this.getMultiClickInterval()) {
                this.lastSingleClickWhen = 0L;
                FlatTitlePane.this.maximizeOrRestore();
            }
            return;
        }
        if (e.getClickCount() == 2 && SwingUtilities.isLeftMouseButton(e)) {
            if (e.getSource() == FlatTitlePane.this.iconLabel) {
                FlatTitlePane.this.close();
            } else if (!FlatTitlePane.this.hasNativeCustomDecoration()) {
                FlatTitlePane.this.maximizeOrRestore();
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (FlatTitlePane.this.window == null) {
            return;
        }
        if (SwingUtilities.isRightMouseButton(e) && SystemInfo.isLinux && FlatNativeLinuxLibrary.isWMUtilsSupported(FlatTitlePane.this.window)) {
            e.consume();
            FlatNativeLinuxLibrary.showWindowMenu(FlatTitlePane.this.window, e);
            return;
        }
        if (!SwingUtilities.isLeftMouseButton(e)) {
            return;
        }
        this.dragOffset = SwingUtilities.convertPoint(FlatTitlePane.this, e.getPoint(), FlatTitlePane.this.window);
        this.linuxNativeMove = false;
        if (SystemInfo.isLinux && FlatNativeLinuxLibrary.isWMUtilsSupported(FlatTitlePane.this.window)) {
            int clickCount = e.getClickCount();
            if (clickCount == 1 && this.lastSingleClickWhen != 0L && e.getWhen() - this.lastSingleClickWhen <= (long)this.getMultiClickInterval()) {
                clickCount = 2;
            }
            switch (clickCount) {
                case 1: {
                    e.consume();
                    this.linuxNativeMove = FlatNativeLinuxLibrary.moveOrResizeWindow(FlatTitlePane.this.window, e, 8);
                    this.lastSingleClickWhen = e.getWhen();
                    break;
                }
                case 2: {
                    this.lastSingleClickWhen = 0L;
                    FlatTitlePane.this.maximizeOrRestore();
                }
            }
        }
    }

    private int getMultiClickInterval() {
        Object value = Toolkit.getDefaultToolkit().getDesktopProperty("awt.multiClickInterval");
        return value instanceof Integer ? (Integer)value : 500;
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        Frame frame;
        int state;
        if (FlatTitlePane.this.window == null || this.dragOffset == null) {
            return;
        }
        if (this.linuxNativeMove) {
            return;
        }
        if (!SwingUtilities.isLeftMouseButton(e)) {
            return;
        }
        if (FlatTitlePane.this.hasNativeCustomDecoration()) {
            return;
        }
        if (FlatTitlePane.this.window instanceof Frame && ((state = (frame = (Frame)FlatTitlePane.this.window).getExtendedState()) & 6) != 0) {
            int maximizedWidth = FlatTitlePane.this.window.getWidth();
            frame.setExtendedState(state & 0xFFFFFFF9);
            int restoredWidth = FlatTitlePane.this.window.getWidth();
            int center = restoredWidth / 2;
            if (this.dragOffset.x > center) {
                this.dragOffset.x = this.dragOffset.x > maximizedWidth - center ? restoredWidth - (maximizedWidth - this.dragOffset.x) : center;
            }
        }
        int newX = e.getXOnScreen() - this.dragOffset.x;
        int newY = e.getYOnScreen() - this.dragOffset.y;
        if (newX == FlatTitlePane.this.window.getX() && newY == FlatTitlePane.this.window.getY()) {
            return;
        }
        FlatTitlePane.this.window.setLocation(newX, newY);
    }

    @Override
    public void mouseMoved(MouseEvent e) {
    }

    @Override
    public void componentResized(ComponentEvent e) {
        FlatTitlePane.this.updateNativeTitleBarHeightAndHitTestSpotsLater();
    }

    @Override
    public void componentShown(ComponentEvent e) {
        FlatTitlePane.this.frameStateChanged();
    }

    @Override
    public void componentMoved(ComponentEvent e) {
    }

    @Override
    public void componentHidden(ComponentEvent e) {
    }
}
