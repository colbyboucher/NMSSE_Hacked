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
import nomanssave.eN;
import nomanssave.eO;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class eM {
    final String id;
    final String name;
    final String description;
    final boolean iE;
    final boolean jY;
    private static final List kl = new ArrayList();

    static {
        InputStream inputStream = Application.class.getResourceAsStream("db/settlements.xml");
        if (inputStream != null) {
            try {
                Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(inputStream);
                Element element = document.getDocumentElement();
                NodeList nodeList = element.getChildNodes();
                int n = 0;
                while (n < nodeList.getLength()) {
                    Node node = nodeList.item(n);
                    if (node instanceof Element && node.getNodeName().equals("perk")) {
                        kl.add(new eM((Element)node));
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
        kl.sort(new eN());
    }

    private eM(Element element) {
        this.id = element.getAttribute("id");
        this.name = element.getAttribute("name");
        this.description = element.getAttribute("description");
        this.iE = Boolean.parseBoolean(element.getAttribute("beneficial"));
        this.jY = Boolean.parseBoolean(element.getAttribute("procedural"));
    }

    public String getID() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    public boolean aW() {
        return this.iE;
    }

    public boolean bb() {
        return this.jY;
    }

    public boolean equals(Object object) {
        if (object instanceof String) {
            if (this.jY) {
                return ((String)object).startsWith(String.valueOf(this.id) + "#");
            }
            return ((String)object).equals(this.id);
        }
        return super.equals(object);
    }

    public String toString() {
        return this.name;
    }

    public static int getCount() {
        return kl.size();
    }

    public static eM S(int n) {
        return (eM)kl.get(n);
    }

    public static int w(String string) {
        return kl.indexOf(new eO(string));
    }

    public static eM x(String string) {
        int n = kl.indexOf(new eO(string));
        if (n >= 0) {
            return (eM)kl.get(n);
        }
        return null;
    }
}
