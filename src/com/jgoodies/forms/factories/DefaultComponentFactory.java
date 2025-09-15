/*
 * Decompiled with CFR 0.152.
 */
package com.jgoodies.forms.factories;

import com.jgoodies.forms.factories.ComponentFactory2;
import com.jgoodies.forms.layout.Sizes;
import com.jgoodies.forms.util.FormUtils;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Insets;
import java.awt.LayoutManager;
import javax.accessibility.AccessibleContext;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.UIManager;

public class DefaultComponentFactory
implements ComponentFactory2 {
    private static final DefaultComponentFactory INSTANCE = new DefaultComponentFactory();
    private static final char MNEMONIC_MARKER = '&';

    public static DefaultComponentFactory getInstance() {
        return INSTANCE;
    }

    public JLabel createLabel(String textWithMnemonic) {
        FormsLabel label = new FormsLabel();
        DefaultComponentFactory.setTextAndMnemonic(label, textWithMnemonic);
        return label;
    }

    public JLabel createReadOnlyLabel(String textWithMnemonic) {
        ReadOnlyLabel label = new ReadOnlyLabel();
        DefaultComponentFactory.setTextAndMnemonic(label, textWithMnemonic);
        return label;
    }

    public JLabel createTitle(String textWithMnemonic) {
        TitleLabel label = new TitleLabel();
        DefaultComponentFactory.setTextAndMnemonic(label, textWithMnemonic);
        label.setVerticalAlignment(0);
        return label;
    }

    public JComponent createSeparator(String textWithMnemonic) {
        return this.createSeparator(textWithMnemonic, 2);
    }

    public JComponent createSeparator(String textWithMnemonic, int alignment) {
        if (textWithMnemonic == null || textWithMnemonic.length() == 0) {
            return new JSeparator();
        }
        JLabel title = this.createTitle(textWithMnemonic);
        title.setHorizontalAlignment(alignment);
        return this.createSeparator(title);
    }

    public JComponent createSeparator(JLabel label) {
        if (label == null) {
            throw new NullPointerException("The label must not be null.");
        }
        int horizontalAlignment = label.getHorizontalAlignment();
        if (horizontalAlignment != 2 && horizontalAlignment != 0 && horizontalAlignment != 4) {
            throw new IllegalArgumentException("The label's horizontal alignment must be one of: LEFT, CENTER, RIGHT.");
        }
        JPanel panel = new JPanel(new TitledSeparatorLayout(!FormUtils.isLafAqua()));
        panel.setOpaque(false);
        panel.add(label);
        panel.add(new JSeparator());
        if (horizontalAlignment == 0) {
            panel.add(new JSeparator());
        }
        return panel;
    }

    public static void setTextAndMnemonic(JLabel label, String textWithMnemonic) {
        int end;
        int markerIndex = textWithMnemonic.indexOf(38);
        if (markerIndex == -1) {
            label.setText(textWithMnemonic);
            return;
        }
        int mnemonicIndex = -1;
        int begin = 0;
        int length = textWithMnemonic.length();
        int quotedMarkers = 0;
        StringBuffer buffer = new StringBuffer();
        do {
            if (markerIndex + 1 < length && textWithMnemonic.charAt(markerIndex + 1) == '&') {
                end = markerIndex + 1;
                ++quotedMarkers;
            } else {
                end = markerIndex;
                if (mnemonicIndex == -1) {
                    mnemonicIndex = markerIndex - quotedMarkers;
                }
            }
            buffer.append(textWithMnemonic.substring(begin, end));
        } while ((markerIndex = (begin = end + 1) < length ? textWithMnemonic.indexOf(38, begin) : -1) != -1);
        buffer.append(textWithMnemonic.substring(begin));
        String text = buffer.toString();
        label.setText(text);
        if (mnemonicIndex != -1 && mnemonicIndex < text.length()) {
            label.setDisplayedMnemonic(text.charAt(mnemonicIndex));
            label.setDisplayedMnemonicIndex(mnemonicIndex);
        }
    }

    private static class FormsLabel
    extends JLabel {
        private FormsLabel() {
        }

        public AccessibleContext getAccessibleContext() {
            if (this.accessibleContext == null) {
                this.accessibleContext = new AccessibleFormsLabel();
            }
            return this.accessibleContext;
        }

        private final class AccessibleFormsLabel
        extends JLabel.AccessibleJLabel {
            private AccessibleFormsLabel() {
                super(FormsLabel.this);
            }

            public String getAccessibleName() {
                if (this.accessibleName != null) {
                    return this.accessibleName;
                }
                String text = FormsLabel.this.getText();
                if (text == null) {
                    return super.getAccessibleName();
                }
                return text.endsWith(":") ? text.substring(0, text.length() - 1) : text;
            }
        }
    }

    private static final class ReadOnlyLabel
    extends FormsLabel {
        private static final String[] UIMANAGER_KEYS = new String[]{"Label.disabledForeground", "Label.disabledText", "Label[Disabled].textForeground", "textInactiveText"};

        private ReadOnlyLabel() {
        }

        public void updateUI() {
            super.updateUI();
            this.setForeground(this.getDisabledForeground());
        }

        private Color getDisabledForeground() {
            for (int i = 0; i < UIMANAGER_KEYS.length; ++i) {
                String key = UIMANAGER_KEYS[i];
                Color foreground = UIManager.getColor(key);
                if (foreground == null) continue;
                return foreground;
            }
            return null;
        }
    }

    private static final class TitleLabel
    extends FormsLabel {
        private TitleLabel() {
        }

        public void updateUI() {
            super.updateUI();
            Color foreground = this.getTitleColor();
            if (foreground != null) {
                this.setForeground(foreground);
            }
            this.setFont(this.getTitleFont());
        }

        private Color getTitleColor() {
            return UIManager.getColor("TitledBorder.titleColor");
        }

        private Font getTitleFont() {
            return FormUtils.isLafAqua() ? UIManager.getFont("Label.font").deriveFont(1) : UIManager.getFont("TitledBorder.font");
        }
    }

    private static final class TitledSeparatorLayout
    implements LayoutManager {
        private final boolean centerSeparators;

        private TitledSeparatorLayout(boolean centerSeparators) {
            this.centerSeparators = centerSeparators;
        }

        public void addLayoutComponent(String name, Component comp) {
        }

        public void removeLayoutComponent(Component comp) {
        }

        public Dimension minimumLayoutSize(Container parent) {
            return this.preferredLayoutSize(parent);
        }

        public Dimension preferredLayoutSize(Container parent) {
            JLabel label = this.getLabel(parent);
            Dimension labelSize = ((Component)label).getPreferredSize();
            Insets insets = parent.getInsets();
            int width = labelSize.width + insets.left + insets.right;
            int height = labelSize.height + insets.top + insets.bottom;
            return new Dimension(width, height);
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public void layoutContainer(Container parent) {
            Object object = parent.getTreeLock();
            synchronized (object) {
                Dimension size = parent.getSize();
                Insets insets = parent.getInsets();
                int width = size.width - insets.left - insets.right;
                JLabel label = this.getLabel(parent);
                Dimension labelSize = label.getPreferredSize();
                int labelWidth = labelSize.width;
                int labelHeight = labelSize.height;
                Component separator1 = parent.getComponent(1);
                int separatorHeight = separator1.getPreferredSize().height;
                FontMetrics metrics = label.getFontMetrics(label.getFont());
                int ascent = metrics.getMaxAscent();
                int hGapDlu = this.centerSeparators ? 3 : 1;
                int hGap = Sizes.dialogUnitXAsPixel(hGapDlu, label);
                int vOffset = this.centerSeparators ? 1 + (labelHeight - separatorHeight) / 2 : ascent - separatorHeight / 2;
                int alignment = label.getHorizontalAlignment();
                int y = insets.top;
                if (alignment == 2) {
                    int x = insets.left;
                    label.setBounds(x, y, labelWidth, labelHeight);
                    x += labelWidth;
                    int separatorWidth = size.width - insets.right - (x += hGap);
                    separator1.setBounds(x, y + vOffset, separatorWidth, separatorHeight);
                } else if (alignment == 4) {
                    int x = insets.left + width - labelWidth;
                    label.setBounds(x, y, labelWidth, labelHeight);
                    x -= hGap;
                    int separatorWidth = --x - insets.left;
                    separator1.setBounds(insets.left, y + vOffset, separatorWidth, separatorHeight);
                } else {
                    int xOffset = (width - labelWidth - 2 * hGap) / 2;
                    int x = insets.left;
                    separator1.setBounds(x, y + vOffset, xOffset - 1, separatorHeight);
                    x += xOffset;
                    label.setBounds(x += hGap, y, labelWidth, labelHeight);
                    x += labelWidth;
                    Component separator2 = parent.getComponent(2);
                    int separatorWidth = size.width - insets.right - (x += hGap);
                    separator2.setBounds(x, y + vOffset, separatorWidth, separatorHeight);
                }
            }
        }

        private JLabel getLabel(Container parent) {
            return (JLabel)parent.getComponent(0);
        }
    }
}
