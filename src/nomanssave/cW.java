/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.Point;
import java.awt.Rectangle;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.HashMap;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.AttributeSet;
import javax.swing.text.Element;
import javax.swing.text.JTextComponent;
import javax.swing.text.StyleConstants;
import javax.swing.text.Utilities;
import nomanssave.cX;

public class cW
extends JPanel
implements PropertyChangeListener,
CaretListener,
DocumentListener {
    public static final float gx = 0.0f;
    public static final float gy = 0.5f;
    public static final float gz = 1.0f;
    private static final Border gA = new MatteBorder(0, 0, 0, 2, Color.GRAY);
    private static final int HEIGHT = 2146483647;
    private JTextComponent gB;
    private boolean gC;
    private int gD;
    private Color gE;
    private float gF;
    private int gG;
    private int gH;
    private int gI;
    private int gJ;
    private HashMap gK;

    public cW(JTextComponent jTextComponent) {
        this(jTextComponent, 3);
    }

    public cW(JTextComponent jTextComponent, int n) {
        this.gB = jTextComponent;
        this.setFont(jTextComponent.getFont());
        this.y(5);
        this.a(Color.RED);
        this.a(1.0f);
        this.z(n);
        jTextComponent.getDocument().addDocumentListener(this);
        jTextComponent.addCaretListener(this);
        jTextComponent.addPropertyChangeListener("font", this);
    }

    public boolean aD() {
        return this.gC;
    }

    public void b(boolean bl) {
        this.gC = bl;
    }

    public int aE() {
        return this.gD;
    }

    public void y(int n) {
        this.gD = n;
        EmptyBorder emptyBorder = new EmptyBorder(0, n, 0, n);
        this.setBorder(new CompoundBorder(gA, emptyBorder));
        this.gH = 0;
        this.aI();
    }

    public Color aF() {
        return this.gE == null ? this.getForeground() : this.gE;
    }

    public void a(Color color) {
        this.gE = color;
    }

    public float aG() {
        return this.gF;
    }

    public void a(float f) {
        this.gF = f > 1.0f ? 1.0f : (f < 0.0f ? -1.0f : f);
    }

    public int aH() {
        return this.gG;
    }

    public void z(int n) {
        this.gG = n;
        this.aI();
    }

    private void aI() {
        Element element = this.gB.getDocument().getDefaultRootElement();
        int n = element.getElementCount();
        int n2 = Math.max(String.valueOf(n).length(), this.gG);
        if (this.gH != n2) {
            this.gH = n2;
            FontMetrics fontMetrics = this.getFontMetrics(this.getFont());
            int n3 = fontMetrics.charWidth('0') * n2;
            Insets insets = this.getInsets();
            int n4 = insets.left + insets.right + n3;
            Dimension dimension = this.getPreferredSize();
            dimension.setSize(n4, 2146483647);
            this.setPreferredSize(dimension);
            this.setSize(dimension);
        }
    }

    @Override
    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        FontMetrics fontMetrics = this.gB.getFontMetrics(this.gB.getFont());
        Insets insets = this.getInsets();
        int n = this.getSize().width - insets.left - insets.right;
        Rectangle rectangle = graphics.getClipBounds();
        int n2 = this.gB.viewToModel(new Point(0, rectangle.y));
        int n3 = this.gB.viewToModel(new Point(0, rectangle.y + rectangle.height));
        while (n2 <= n3) {
            try {
                if (this.A(n2)) {
                    graphics.setColor(this.aF());
                } else {
                    graphics.setColor(this.getForeground());
                }
                String string = this.B(n2);
                int n4 = fontMetrics.stringWidth(string);
                int n5 = this.b(n, n4) + insets.left;
                int n6 = this.a(n2, fontMetrics);
                graphics.drawString(string, n5, n6);
                n2 = Utilities.getRowEnd(this.gB, n2) + 1;
            }
            catch (Exception exception) {
                break;
            }
        }
    }

    private boolean A(int n) {
        int n2 = this.gB.getCaretPosition();
        Element element = this.gB.getDocument().getDefaultRootElement();
        return element.getElementIndex(n) == element.getElementIndex(n2);
    }

    protected String B(int n) {
        int n2;
        Element element = this.gB.getDocument().getDefaultRootElement();
        Element element2 = element.getElement(n2 = element.getElementIndex(n));
        if (element2.getStartOffset() == n) {
            return String.valueOf(n2 + 1);
        }
        return "";
    }

    private int b(int n, int n2) {
        return (int)((float)(n - n2) * this.gF);
    }

    private int a(int n, FontMetrics fontMetrics) {
        Rectangle rectangle = this.gB.modelToView(n);
        int n2 = fontMetrics.getHeight();
        int n3 = rectangle.y + rectangle.height;
        int n4 = 0;
        if (rectangle.height == n2) {
            n4 = fontMetrics.getDescent();
        } else {
            if (this.gK == null) {
                this.gK = new HashMap();
            }
            Element element = this.gB.getDocument().getDefaultRootElement();
            int n5 = element.getElementIndex(n);
            Element element2 = element.getElement(n5);
            int n6 = 0;
            while (n6 < element2.getElementCount()) {
                Element element3 = element2.getElement(n6);
                AttributeSet attributeSet = element3.getAttributes();
                String string = (String)attributeSet.getAttribute(StyleConstants.FontFamily);
                Integer n7 = (Integer)attributeSet.getAttribute(StyleConstants.FontSize);
                String string2 = String.valueOf(string) + n7;
                FontMetrics fontMetrics2 = (FontMetrics)this.gK.get(string2);
                if (fontMetrics2 == null) {
                    Font font = new Font(string, 0, n7);
                    fontMetrics2 = this.gB.getFontMetrics(font);
                    this.gK.put(string2, fontMetrics2);
                }
                n4 = Math.max(n4, fontMetrics2.getDescent());
                ++n6;
            }
        }
        return n3 - n4;
    }

    @Override
    public void caretUpdate(CaretEvent caretEvent) {
        int n = this.gB.getCaretPosition();
        Element element = this.gB.getDocument().getDefaultRootElement();
        int n2 = element.getElementIndex(n);
        if (this.gJ != n2) {
            this.repaint();
            this.gJ = n2;
        }
    }

    @Override
    public void changedUpdate(DocumentEvent documentEvent) {
        this.aJ();
    }

    @Override
    public void insertUpdate(DocumentEvent documentEvent) {
        this.aJ();
    }

    @Override
    public void removeUpdate(DocumentEvent documentEvent) {
        this.aJ();
    }

    private void aJ() {
        SwingUtilities.invokeLater(new cX(this));
    }

    @Override
    public void propertyChange(PropertyChangeEvent propertyChangeEvent) {
        if (propertyChangeEvent.getNewValue() instanceof Font) {
            if (this.gC) {
                Font font = (Font)propertyChangeEvent.getNewValue();
                this.setFont(font);
                this.gH = 0;
                this.aI();
            } else {
                this.repaint();
            }
        }
    }

    static /* synthetic */ JTextComponent a(cW cW2) {
        return cW2.gB;
    }

    static /* synthetic */ int b(cW cW2) {
        return cW2.gI;
    }

    static /* synthetic */ void c(cW cW2) {
        cW2.aI();
    }

    static /* synthetic */ void a(cW cW2, int n) {
        cW2.gI = n;
    }
}
