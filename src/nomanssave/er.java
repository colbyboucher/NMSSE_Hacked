/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import nomanssave.Application;
import nomanssave.es;
import nomanssave.et;
import nomanssave.gq;
import nomanssave.gr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class er {
    final String id;
    final String name;
    final gq iB;
    final int iC;
    final gr iD;
    final boolean iE;
    final gr[] iF;
    private static final List iG = new ArrayList();

    static {
        InputStream inputStream = Application.class.getResourceAsStream("db/frigates.xml");
        if (inputStream != null) {
            try {
                Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(inputStream);
                Element element = document.getDocumentElement();
                NodeList nodeList = element.getChildNodes();
                int n = 0;
                while (n < nodeList.getLength()) {
                    Node node = nodeList.item(n);
                    if (node instanceof Element && node.getNodeName().equals("trait")) {
                        iG.add(new er((Element)node));
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
        iG.sort(new es());
    }

    private er(Element element) {
        this.id = element.getAttribute("id");
        this.name = element.getAttribute("name");
        String string = element.getAttribute("type");
        this.iB = string == null ? null : gq.valueOf(string);
        this.iC = Integer.parseInt(element.getAttribute("strength"));
        string = element.getAttribute("primary");
        this.iD = string == null ? null : gr.an(string);
        this.iE = Boolean.parseBoolean(element.getAttribute("beneficial"));
        this.iF = er.n(element.getAttribute("secondary"));
    }

    private static gr[] n(String string) {
        ArrayList<gr> arrayList = new ArrayList<gr>();
        int n = 0;
        while (n < string.length()) {
            gr gr2;
            int n2 = string.indexOf(",", n);
            if (n2 >= 0) {
                gr2 = gr.an(string.substring(n, n2));
                n = n2 + 1;
            } else {
                gr2 = gr.an(string.substring(n));
                n = string.length();
            }
            if (gr2 == null) continue;
            arrayList.add(gr2);
        }
        return arrayList.toArray(new gr[0]);
    }

    public String getID() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public gq aU() {
        return this.iB;
    }

    public int aV() {
        return this.iC * this.iB.di();
    }

    public boolean aW() {
        return this.iE;
    }

    public String toString() {
        String string = String.valueOf(this.iC > 0 ? "+" : "") + this.iC + (this.iB == gq.oY ? "%" : "");
        return String.valueOf(this.name) + " (" + string + " " + (Object)((Object)this.iB) + ")";
    }

    public static er[] a(gr gr2) {
        return (er[])iG.stream().filter(er2 -> er2.iD == gr2).toArray(er[]::new);
    }

    public static er[] b(gr gr2) {
        return (er[])iG.stream().filter(er2 -> Arrays.stream(er2.iF).anyMatch(gr3 -> gr3 == gr2)).toArray(er[]::new);
    }

    public static er o(String string) {
        int n = iG.indexOf(new et(string));
        if (n >= 0) {
            return (er)iG.get(n);
        }
        return null;
    }
}
