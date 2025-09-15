/*
 * Decompiled with CFR 0.152.
 */
package com.formdev.flatlaf.ui;

import com.formdev.flatlaf.ui.FlatArrowButton;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import javax.swing.JButton;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JViewport;
import javax.swing.MenuElement;
import javax.swing.MenuSelectionManager;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.event.MenuKeyEvent;
import javax.swing.event.MenuKeyListener;
import javax.swing.event.PopupMenuEvent;
import javax.swing.event.PopupMenuListener;
import javax.swing.plaf.ButtonUI;
import javax.swing.plaf.basic.BasicMenuItemUI;

private class FlatPopupMenuUI.FlatPopupScroller
extends JPanel
implements MouseWheelListener,
PopupMenuListener,
MenuKeyListener {
    private final JPopupMenu popup;
    private final JScrollPane scrollPane;
    private final JButton scrollUpButton;
    private final JButton scrollDownButton;
    private int unitIncrement;

    FlatPopupMenuUI.FlatPopupScroller(JPopupMenu popup) {
        super(new BorderLayout());
        this.popup = popup;
        JPanel view = new JPanel(new BorderLayout());
        view.add((Component)popup, "Center");
        this.scrollPane = new JScrollPane(view, 21, 31);
        this.scrollPane.setBorder(null);
        this.scrollUpButton = new ArrowButton(1);
        this.scrollDownButton = new ArrowButton(5);
        this.add((Component)this.scrollPane, "Center");
        this.add((Component)this.scrollUpButton, "North");
        this.add((Component)this.scrollDownButton, "South");
        this.setBackground(popup.getBackground());
        this.setBorder(popup.getBorder());
        popup.setBorder(null);
        popup.addPopupMenuListener(this);
        popup.addMouseWheelListener(this);
        popup.addMenuKeyListener(this);
        this.updateArrowButtons();
        this.putClientProperty("Popup.borderCornerRadius", UIManager.getInt("PopupMenu.borderCornerRadius"));
    }

    void scroll(int unitsToScroll) {
        if (this.unitIncrement == 0) {
            this.unitIncrement = new JMenuItem((String)"X").getPreferredSize().height;
        }
        JViewport viewport = this.scrollPane.getViewport();
        Point viewPosition = viewport.getViewPosition();
        int newY = viewPosition.y + this.unitIncrement * unitsToScroll;
        newY = newY < 0 ? 0 : Math.min(newY, viewport.getViewSize().height - viewport.getExtentSize().height);
        viewport.setViewPosition(new Point(viewPosition.x, newY));
        this.updateArrowButtons();
    }

    void updateArrowButtons() {
        JViewport viewport = this.scrollPane.getViewport();
        Point viewPosition = viewport.getViewPosition();
        this.scrollUpButton.setVisible(viewPosition.y > 0);
        this.scrollDownButton.setVisible(viewPosition.y < viewport.getViewSize().height - viewport.getExtentSize().height);
    }

    @Override
    public void popupMenuWillBecomeInvisible(PopupMenuEvent e) {
        this.popup.setBorder(this.getBorder());
        this.popup.removePopupMenuListener(this);
        this.popup.removeMouseWheelListener(this);
        this.popup.removeMenuKeyListener(this);
    }

    @Override
    public void popupMenuWillBecomeVisible(PopupMenuEvent e) {
    }

    @Override
    public void popupMenuCanceled(PopupMenuEvent e) {
    }

    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {
        ButtonUI ui;
        Point mouseLocation = SwingUtilities.convertPoint((Component)e.getSource(), e.getPoint(), this);
        this.scroll(e.getUnitsToScroll());
        Component c = SwingUtilities.getDeepestComponentAt(this, mouseLocation.x, mouseLocation.y);
        if (c instanceof JMenuItem && (ui = ((JMenuItem)c).getUI()) instanceof BasicMenuItemUI) {
            MenuSelectionManager.defaultManager().setSelectedPath(((BasicMenuItemUI)ui).getPath());
        }
        e.consume();
    }

    @Override
    public void menuKeyPressed(MenuKeyEvent e) {
        EventQueue.invokeLater(() -> {
            if (!this.isDisplayable()) {
                return;
            }
            MenuElement[] path = MenuSelectionManager.defaultManager().getSelectedPath();
            if (path.length == 0) {
                return;
            }
            Component c = path[path.length - 1].getComponent();
            JViewport viewport = this.scrollPane.getViewport();
            Point pt = SwingUtilities.convertPoint(c, 0, 0, viewport);
            viewport.scrollRectToVisible(new Rectangle(pt, c.getSize()));
            boolean upVisible = this.scrollUpButton.isVisible();
            this.updateArrowButtons();
            if (!upVisible && this.scrollUpButton.isVisible()) {
                Point viewPosition = viewport.getViewPosition();
                int newY = viewPosition.y + this.scrollUpButton.getPreferredSize().height;
                viewport.setViewPosition(new Point(viewPosition.x, newY));
            }
        });
    }

    @Override
    public void menuKeyTyped(MenuKeyEvent e) {
    }

    @Override
    public void menuKeyReleased(MenuKeyEvent e) {
    }

    private class ArrowButton
    extends FlatArrowButton
    implements MouseListener,
    ActionListener {
        private Timer timer;

        ArrowButton(int direction) {
            super(direction, FlatPopupMenuUI.this.arrowType, FlatPopupMenuUI.this.scrollArrowColor, null, null, FlatPopupMenuUI.this.hoverScrollArrowBackground, null, null);
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
}
