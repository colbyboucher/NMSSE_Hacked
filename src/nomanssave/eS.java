/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import nomanssave.Application;
import nomanssave.eT;
import nomanssave.eU;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class eS {
    final String id;
    final String text;
    private final HashMap kp;
    private static final List kq = new ArrayList();

    static {
        InputStream inputStream = Application.class.getResourceAsStream("db/words.xml");
        if (inputStream != null) {
            try {
                Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(inputStream);
                Element element = document.getDocumentElement();
                NodeList nodeList = element.getChildNodes();
                int n = 0;
                while (n < nodeList.getLength()) {
                    Node node = nodeList.item(n);
                    if (node instanceof Element && node.getNodeName().equals("word")) {
                        kq.add(new eS((Element)node));
                    }
                    ++n;
                }
            }
            catch (ParserConfigurationException parserConfigurationException) {
            }
            catch (SAXException sAXException) {
            }
            catch (IOException iOException) {
                // empty catch block
            }
        }
        kq.sort(new eT());
    }

    private eS(Element element) {
        this.id = element.getAttribute("id");
        this.text = element.getAttribute("text");
        this.kp = new HashMap();
        NodeList nodeList = element.getElementsByTagName("group");
        int n = 0;
        while (n < nodeList.getLength()) {
            Element element2 = (Element)nodeList.item(n);
            String string = element2.getAttribute("group");
            eU eU2 = eU.C(element2.getAttribute("race"));
            if (eU2 != null) {
                this.kp.put(string, eU2);
            }
            ++n;
        }
    }

    public String getID() {
        return this.id;
    }

    public String getText() {
        return this.text;
    }

    public Iterable bw() {
        return Collections.unmodifiableSet(this.kp.keySet());
    }

    public eU z(String string) {
        return (eU)((Object)this.kp.get(string));
    }

    public boolean a(eU eU2) {
        return this.kp.containsValue((Object)eU2);
    }

    public static eS A(String string) {
        for (eS eS2 : kq) {
            if (!eS2.id.equals(string)) continue;
            return eS2;
        }
        return null;
    }

    public static eS B(String string) {
        for (eS eS2 : kq) {
            if (!eS2.kp.containsKey(string)) continue;
            return eS2;
        }
        return null;
    }

    public static int bx() {
        return kq.size();
    }

    public static eS T(int n) {
        return (eS)kq.get(n);
    }

    public static Iterable by() {
        return Collections.unmodifiableList(kq);
    }
}
