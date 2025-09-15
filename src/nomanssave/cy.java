/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dialog;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.ClipboardOwner;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.JTree;
import javax.swing.KeyStroke;
import javax.swing.UIManager;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;
import nomanssave.Application;
import nomanssave.aH;
import nomanssave.cA;
import nomanssave.cB;
import nomanssave.cC;
import nomanssave.cD;
import nomanssave.cE;
import nomanssave.cF;
import nomanssave.cG;
import nomanssave.cH;
import nomanssave.cI;
import nomanssave.cJ;
import nomanssave.cW;
import nomanssave.cz;
import nomanssave.eX;
import nomanssave.eY;
import nomanssave.hc;

public class cy
extends JDialog
implements TreeSelectionListener {
    private String fS;
    private eY fT = null;
    private JButton fU;
    private JTree fV;
    private JScrollPane fW;
    private JTextArea fX;
    private JScrollPane fY;
    private cJ fZ;
    private boolean ga;
    private boolean gb;
    private static final String gc = "0123456789ABCDEFabcdef";
    private static cy gd = null;
    private boolean ge = true;
    private String gf = "";

    private cy(Application application) {
        super(application.g());
        Rectangle rectangle = new Rectangle(100, 100, 1000, 700);
        Point point = application.g().getLocation();
        rectangle.x = aH.a("JSONEditor.X", point.x + 10);
        rectangle.y = aH.a("JSONEditor.Y", point.y + 10);
        rectangle.width = aH.a("JSONEditor.Width", 1000);
        rectangle.height = aH.a("JSONEditor.Height", 700);
        this.setBounds(rectangle);
        this.setDefaultCloseOperation(0);
        this.setModalExclusionType(Dialog.ModalExclusionType.APPLICATION_EXCLUDE);
        this.setTitle("JSON Editor (Advanced Users Only)");
        this.setModal(true);
        this.addComponentListener(new cz(this));
        this.fV = new JTree();
        this.fV.setModel(new cI(this, null));
        this.fV.setCellRenderer(new cA(this));
        this.fV.addTreeSelectionListener(this);
        this.fW = new JScrollPane();
        this.fW.setViewportView(this.fV);
        this.fX = new JTextArea();
        this.fX.putClientProperty("FlatLaf.styleClass", "monospaced");
        this.fX.setEditable(false);
        this.fX.setTabSize(4);
        this.fX.getActionMap().put("copy-to-clipboard", new cG(this));
        this.fX.getActionMap().put("paste-from-clipboard", new cH(this));
        this.fX.getDocument().addDocumentListener(new cB(this));
        this.fY = new JScrollPane();
        this.fY.setRowHeaderView(new cW(this.fX));
        this.fY.setViewportView(this.fX);
        JPanel jPanel = new JPanel();
        jPanel.setLayout(new BorderLayout());
        this.fU = new JButton("Validate");
        this.fU.addActionListener(new cC(this));
        jPanel.add((Component)this.fU, "North");
        jPanel.add((Component)this.fW, "Center");
        JSplitPane jSplitPane = new JSplitPane(1, jPanel, this.fY);
        jSplitPane.setDividerLocation(aH.a("JSONEditor.Divider", 280));
        jSplitPane.addPropertyChangeListener("dividerLocation", new cD(this));
        this.setContentPane(jSplitPane);
        this.addWindowListener(new cE(this));
        cF cF2 = new cF(this);
        this.fV.getInputMap().put(KeyStroke.getKeyStroke(70, 2), "find");
        this.fV.getActionMap().put("find", cF2);
        this.fX.getInputMap().put(KeyStroke.getKeyStroke(70, 2), "find");
        this.fX.getActionMap().put("find", cF2);
    }

    private boolean a(String string, eY eY2) {
        this.setTitle("JSON Editor (Advanced Users Only)");
        this.fS = string;
        this.fT = eY2;
        this.fX.setText("");
        this.ga = false;
        this.fZ = null;
        this.fV.updateUI();
        int n = 0;
        int n2 = 0;
        for (String string2 : eY2.names()) {
            ++n2;
            if (!(eY2.get(string2) instanceof eY)) continue;
            n = n2;
            break;
        }
        this.fV.setSelectionRow(n);
        this.gb = false;
        this.fV.setVisible(true);
        this.fU.setVisible(false);
        this.setVisible(true);
        return this.gb;
    }

    private static String ay() {
        String string;
        try {
            string = (String)Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor);
        }
        catch (UnsupportedFlavorException | IOException exception) {
            hc.error("Could not retrieve clipboard contents", exception);
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        char[] cArray = string.toCharArray();
        int n = 0;
        while (n < cArray.length) {
            if (cArray[n] == '\r' || cArray[n] == '\n' || cArray[n] == '\t') {
                stringBuffer.append(cArray[n]);
            } else if (cArray[n] == '\f') {
                stringBuffer.append("\\f");
            } else if (cArray[n] == '\b') {
                stringBuffer.append("\\b");
            } else if (cArray[n] == '\u000b') {
                stringBuffer.append("\\v");
            } else if (cArray[n] == '\u0000') {
                stringBuffer.append("\\0");
            } else if (cArray[n] < ' ' || cArray[n] >= '\u0080') {
                stringBuffer.append("\\u");
                stringBuffer.append(gc.charAt(cArray[n] >> 12 & 0xF));
                stringBuffer.append(gc.charAt(cArray[n] >> 8 & 0xF));
                stringBuffer.append(gc.charAt(cArray[n] >> 4 & 0xF));
                stringBuffer.append(gc.charAt(cArray[n] & 0xF));
            } else {
                stringBuffer.append(cArray[n]);
            }
            ++n;
        }
        return stringBuffer.toString();
    }

    private static int a(char c) {
        int n = gc.indexOf(c);
        if (n < 0) {
            throw new RuntimeException("Error decoding hex");
        }
        if (n >= 16) {
            n -= 6;
        }
        return n;
    }

    private static void a(String string, ClipboardOwner clipboardOwner) {
        StringBuffer stringBuffer = new StringBuffer();
        char[] cArray = string.toCharArray();
        int n = 0;
        while (n < cArray.length) {
            if (cArray[n] == '\\' && n + 5 < cArray.length && cArray[n + 1] == 'u') {
                try {
                    int n2 = cy.a(cArray[n + 2]) << 12 | cy.a(cArray[n + 3]) << 8 | cy.a(cArray[n + 4]) << 4 | cy.a(cArray[n + 5]);
                    if (n2 < 32) {
                        stringBuffer.append(cArray[n]);
                        stringBuffer.append(cArray[n + 1]);
                        stringBuffer.append(cArray[n + 2]);
                        stringBuffer.append(cArray[n + 3]);
                        stringBuffer.append(cArray[n + 4]);
                        stringBuffer.append(cArray[n + 5]);
                    } else {
                        stringBuffer.append((char)n2);
                    }
                    n += 5;
                }
                catch (RuntimeException runtimeException) {}
            } else {
                stringBuffer.append(cArray[n]);
            }
            ++n;
        }
        StringSelection stringSelection = new StringSelection(stringBuffer.toString());
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection, clipboardOwner);
    }

    public static boolean a(Application application, String string, eY eY2) {
        if (gd == null) {
            gd = new cy(application);
        }
        return gd.a(string, eY2);
    }

    @Override
    public void valueChanged(TreeSelectionEvent treeSelectionEvent) {
        if (!this.ge) {
            return;
        }
        if (this.ga && this.fZ != null) {
            try {
                String string = this.fX.getText().trim();
                if (string.length() == 0 && JOptionPane.showConfirmDialog(this, "The JSON data has been deleted, do you wish to apply these changes to the save file?", this.getTitle(), 0) == 0) {
                    this.fZ.remove();
                    ((cI)this.fV.getModel()).a(this.fZ.gi);
                } else if (JOptionPane.showConfirmDialog(this, "The JSON data has changed, do you wish to apply these changes to the save file?", this.getTitle(), 0) == 0) {
                    this.fZ.setText(string);
                    ((cI)this.fV.getModel()).a(this.fZ);
                }
            }
            catch (eX eX2) {
                JOptionPane.showOptionDialog(this, "Error on line #" + eX2.getLineNumber() + ": " + eX2.getMessage(), "Error", 0, 0, null, new Object[]{"Cancel"}, null);
                this.fX.setCaretPosition(eX2.bD());
                this.fX.requestFocus();
                return;
            }
        }
        this.fZ = (cJ)this.fV.getLastSelectedPathComponent();
        if (this.fZ == null) {
            this.fX.setText("");
            this.fX.setEditable(false);
        } else {
            this.fX.setText(this.fZ.getText());
            this.fX.setEditable(true);
        }
        this.ga = false;
        this.fX.setCaretPosition(0);
        this.fX.requestFocus();
    }

    void a(String string, boolean bl, boolean bl2, boolean bl3) {
        String string2 = this.fX.getText();
        if (!this.gf.equals(string)) {
            Highlighter highlighter = this.fX.getHighlighter();
            highlighter.removeAllHighlights();
            Color color = UIManager.getColor("JSONEditor.hiliteColor");
            DefaultHighlighter.DefaultHighlightPainter defaultHighlightPainter = new DefaultHighlighter.DefaultHighlightPainter(color);
            int n = -1;
            while ((n = string2.indexOf(string, n + 1)) >= 0) {
                try {
                    highlighter.addHighlight(n, n + string.length(), defaultHighlightPainter);
                }
                catch (BadLocationException badLocationException) {
                    // empty catch block
                }
            }
        }
        if (!bl2) {
            string2 = string2.toUpperCase();
            string = string.toUpperCase();
        }
        int n = this.fX.getCaretPosition();
        int n2 = -1;
        if (bl) {
            if (n > string.length()) {
                n2 = string2.lastIndexOf(string, n - string.length() - 1);
            }
            if (n2 < 0 && bl3) {
                n2 = string2.lastIndexOf(string);
            }
        } else {
            if (n < string2.length() - 1) {
                n2 = string2.indexOf(string, n + 1);
            }
            if (n2 < 0 && bl3) {
                n2 = string2.indexOf(string);
            }
        }
        if (n2 < 0) {
            JOptionPane.showMessageDialog(this, "Text not found!");
        } else {
            this.fX.setCaretPosition(n2);
            this.fX.setSelectionStart(n2);
            this.fX.setSelectionEnd(n2 + string.length());
        }
    }

    static /* synthetic */ String az() {
        return cy.ay();
    }

    static /* synthetic */ void b(String string, ClipboardOwner clipboardOwner) {
        cy.a(string, clipboardOwner);
    }

    static /* synthetic */ String a(cy cy2) {
        return cy2.fS;
    }

    static /* synthetic */ eY b(cy cy2) {
        return cy2.fT;
    }

    static /* synthetic */ void a(cy cy2, boolean bl) {
        cy2.ga = bl;
    }

    static /* synthetic */ void b(cy cy2, boolean bl) {
        cy2.gb = bl;
    }

    static /* synthetic */ JTextArea c(cy cy2) {
        return cy2.fX;
    }

    static /* synthetic */ cJ d(cy cy2) {
        return cy2.fZ;
    }

    static /* synthetic */ JTree e(cy cy2) {
        return cy2.fV;
    }

    static /* synthetic */ JButton f(cy cy2) {
        return cy2.fU;
    }

    static /* synthetic */ boolean g(cy cy2) {
        return cy2.ga;
    }
}
