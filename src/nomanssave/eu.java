/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import nomanssave.Application;
import nomanssave.ev;
import nomanssave.ew;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class eu {
    private static List iH = new ArrayList();

    static {
        InputStream inputStream = Application.class.getResourceAsStream("db/inventory.xml");
        if (inputStream != null) {
            try {
                Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(inputStream);
                Element element = document.getDocumentElement();
                NodeList nodeList = element.getChildNodes();
                int n = 0;
                while (n < nodeList.getLength()) {
                    Node node = nodeList.item(n);
                    if (node instanceof Element && node.getNodeName().equals("difficulty")) {
                        iH.add(new ev((Element)node));
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
    }

    public static ew b(String string, String string2) {
        for (ev ev2 : iH) {
            if (!ev2.id.equals(string)) continue;
            for (ew ew2 : ev2) {
                if (!ew2.iI.equals(string2)) continue;
                return ew2;
            }
        }
        return null;
    }
}
