/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import nomanssave.Application;
import nomanssave.eJ;
import nomanssave.eK;
import nomanssave.eL;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class eI {
    public static final int kf = 0;
    public static final int kg = 1;
    public static final int kh = 2;
    final int type;
    final String id;
    final String name;
    private static final List ki = new ArrayList();
    private static final List kj = new ArrayList();
    private static final List kk = new ArrayList();

    static {
        InputStream inputStream = Application.class.getResourceAsStream("db/rewards.xml");
        if (inputStream != null) {
            try {
                Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(inputStream);
                Element element = document.getDocumentElement();
                NodeList nodeList = element.getChildNodes();
                int n = 0;
                while (n < nodeList.getLength()) {
                    Node node = nodeList.item(n);
                    if (node instanceof Element && node.getNodeName().equals("season")) {
                        ki.add(new eI((Element)node, 0));
                    }
                    if (node instanceof Element && node.getNodeName().equals("twitch")) {
                        kj.add(new eI((Element)node, 1));
                    }
                    if (node instanceof Element && node.getNodeName().equals("platform")) {
                        kk.add(new eI((Element)node, 2));
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
        ki.sort(new eJ());
        kj.sort(new eK());
        kk.sort(new eL());
    }

    private eI(Element element, int n) {
        this.type = n;
        this.id = element.getAttribute("id");
        this.name = element.getAttribute("name");
    }

    public String getID() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public static int bq() {
        return ki.size();
    }

    public static eI P(int n) {
        return (eI)ki.get(n);
    }

    public static int br() {
        return kj.size();
    }

    public static eI Q(int n) {
        return (eI)kj.get(n);
    }

    public static int bs() {
        return kk.size();
    }

    public static eI R(int n) {
        return (eI)kk.get(n);
    }

    public static Iterable bt() {
        return Collections.unmodifiableList(ki);
    }

    public static Iterable bu() {
        return Collections.unmodifiableList(kj);
    }
}
