/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dialog;
import java.awt.Frame;
import javax.swing.BorderFactory;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import javax.swing.KeyStroke;
import javax.swing.text.BadLocationException;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import nomanssave.b;

public class a
extends JDialog {
    private static a a = null;

    private a(Frame frame) {
        super(frame);
        this.setResizable(false);
        this.setModalExclusionType(Dialog.ModalExclusionType.APPLICATION_EXCLUDE);
        this.setTitle("About Save Editor");
        this.setModal(true);
        JTextPane jTextPane = new JTextPane();
        jTextPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        jTextPane.setOpaque(false);
        try {
            StyledDocument styledDocument = (StyledDocument)jTextPane.getDocument();
            SimpleAttributeSet simpleAttributeSet = new SimpleAttributeSet();
            StyleConstants.setBold(simpleAttributeSet, true);
            SimpleAttributeSet simpleAttributeSet2 = new SimpleAttributeSet();
            styledDocument.insertString(styledDocument.getLength(), "No Man's Sky Save Editor\n\n", simpleAttributeSet);
            styledDocument.insertString(styledDocument.getLength(), "Version: 1.19.0\n", simpleAttributeSet2);
            styledDocument.insertString(styledDocument.getLength(), "by GoatFungus\n\n", simpleAttributeSet2);
            styledDocument.insertString(styledDocument.getLength(), "For further information visit:\n", simpleAttributeSet2);
            styledDocument.insertString(styledDocument.getLength(), "https://github.com/goatfungus/NMSSaveEditor", simpleAttributeSet2);
        }
        catch (BadLocationException badLocationException) {
            jTextPane.setText("No Man's Sky Save Editor\r\n\r\nVersion: 1.19.0\r\nby GoatFungus\r\n\r\nFor further information visit:\r\nhttps://github.com/goatfungus/NMSSaveEditor");
        }
        jTextPane.setEditable(false);
        this.getContentPane().add((Component)jTextPane, "Center");
        this.getRootPane().registerKeyboardAction(new b(this), KeyStroke.getKeyStroke(27, 0), 2);
        this.pack();
    }

    public static void a(Container container) {
        if (a == null) {
            Frame frame = JOptionPane.getFrameForComponent(container);
            a = new a(frame);
        }
        a.setLocationRelativeTo(a.getParent());
        a.setVisible(true);
    }
}
