/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import javax.swing.ImageIcon;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import nomanssave.Application;
import nomanssave.eA;
import nomanssave.eB;
import nomanssave.eH;
import nomanssave.eP;
import nomanssave.eQ;
import nomanssave.eR;
import nomanssave.ex;
import nomanssave.fg;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public abstract class ey {
    public static final int jD = 0;
    public static final int jE = 1;
    public static final int jF = 2;
    public static final int jG = 3;
    final String id;
    private static final Pattern jH;
    private static final List jI;
    private static final List jJ;

    static {
        Object object;
        Object object2;
        jH = Pattern.compile("%(\\w+)%");
        Node node = null;
        InputStream inputStream = Application.class.getResourceAsStream("db/items.xml");
        if (inputStream != null) {
            try {
                object2 = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(inputStream);
                node = object2.getDocumentElement();
            }
            catch (ParserConfigurationException parserConfigurationException) {
            }
            catch (SAXException sAXException) {
            }
            catch (IOException iOException) {
                // empty catch block
            }
        }
        object2 = new ArrayList();
        if (node != null) {
            object = node.getChildNodes();
            int n = 0;
            while (n < object.getLength()) {
                Node node2 = object.item(n);
                if (node2 instanceof Element && node2.getNodeName().equals("product-template")) {
                    object2.add(new eA((Element)node2));
                }
                ++n;
            }
        }
        jI = Collections.unmodifiableList(object2);
        object = new ArrayList();
        if (node != null) {
            NodeList nodeList = node.getChildNodes();
            int n = 0;
            while (n < nodeList.getLength()) {
                Node node3 = nodeList.item(n);
                if (node3 instanceof Element && node3.getNodeName().equals("substance")) {
                    object.add(new eP((Element)node3));
                } else if (node3 instanceof Element && node3.getNodeName().equals("product")) {
                    object.add(new eH((Element)node3, false));
                } else if (node3 instanceof Element && node3.getNodeName().equals("procedural-product")) {
                    object.add(new eH((Element)node3, true));
                } else if (node3 instanceof Element && node3.getNodeName().equals("technology")) {
                    object.add(new eQ((Element)node3, false));
                } else if (node3 instanceof Element && node3.getNodeName().equals("procedural-technology")) {
                    object.add(new eQ((Element)node3, true));
                }
                ++n;
            }
        }
        List list = object.stream().filter(ey2 -> ey2 instanceof eQ).map(eQ.class::cast).map(eQ2 -> eQ2.bv()).filter(eR2 -> eR2 != null).collect(Collectors.toList());
        object.addAll(list);
        list.sort((eR2, eR3) -> eR2.getName().compareTo(eR3.getName()));
        jJ = Collections.unmodifiableList(object);
    }

    ey(String string) {
        this.id = string;
    }

    public final String getID() {
        return this.id;
    }

    private static String L(int n) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(Integer.toString(n));
        while (stringBuilder.length() < 5) {
            stringBuilder.insert(0, '0');
        }
        return stringBuilder.toString();
    }

    public Object aZ() {
        if (this.id.length() < 2 || this.id.charAt(0) != '^') {
            throw new RuntimeException("Cannot create ID: invalid string");
        }
        if (this.bb()) {
            int n = (int)Math.floor(Math.random() * 100000.0);
            return String.valueOf(this.id) + "#" + ey.L(n);
        }
        return this.id;
    }

    public Object M(int n) {
        if (this.id.length() < 2 || this.id.charAt(0) != '^') {
            throw new RuntimeException("Cannot create ID: invalid string");
        }
        if (this.bb()) {
            if (n < 0 || n >= 100000) {
                throw new RuntimeException("Cannot create ID: invalid proc");
            }
            return String.valueOf(this.id) + "#" + ey.L(n);
        }
        if (n != 0) {
            throw new RuntimeException("Cannot create ID: invalid proc");
        }
        return this.id;
    }

    public abstract eB ba();

    public abstract boolean bb();

    public abstract String getName();

    public abstract ex bc();

    public abstract boolean bd();

    public abstract boolean be();

    public abstract Integer bf();

    public abstract String bg();

    public abstract boolean bh();

    public abstract String bi();

    public final ImageIcon N(int n) {
        String string = this.bi();
        switch (n) {
            case 0: {
                return string == null ? null : Application.a(string);
            }
            case 3: {
                return string == null ? null : Application.a(string, 20, 20);
            }
            case 1: {
                return string == null ? null : Application.a(string, 40, 40);
            }
            case 2: {
                return string == null ? null : Application.a(string, 80, 80);
            }
        }
        return null;
    }

    public final ImageIcon c(int n, int n2) {
        String string = this.bi();
        return string == null ? null : Application.a(string, n, n2);
    }

    public abstract int bj();

    public abstract String getDescription();

    public abstract List bk();

    public String toString() {
        return this.id;
    }

    static String a(Element element) {
        if (element == null) {
            throw new IllegalArgumentException();
        }
        NodeList nodeList = element.getChildNodes();
        StringBuffer stringBuffer = new StringBuffer();
        boolean bl = false;
        int n = 0;
        while (n < nodeList.getLength()) {
            Node node = nodeList.item(n);
            if (node.getNodeType() == 3) {
                stringBuffer.append(node.getNodeValue());
                bl = true;
            }
            ++n;
        }
        if (!bl) {
            return null;
        }
        return stringBuffer.toString();
    }

    private static List O(int n) {
        boolean bl;
        boolean bl2;
        ArrayList<ex> arrayList = new ArrayList<ex>();
        boolean bl3 = bl2 = (n & 0x4000) == 0;
        if ((n & 4) == 4) {
            arrayList.add(ex.je);
            arrayList.add(ex.js);
            arrayList.add(ex.jv);
            if (bl2) {
                arrayList.add(ex.jw);
            }
        }
        if ((n & 0x40) == 64) {
            arrayList.add(ex.jq);
            arrayList.add(ex.js);
            if (bl2) {
                arrayList.add(ex.jr);
            }
        }
        if ((n & 0x100) == 256) {
            arrayList.add(ex.ju);
            arrayList.add(ex.js);
            arrayList.add(ex.jv);
            if (bl2) {
                arrayList.add(ex.jw);
            }
        }
        if ((n & 2) == 2) {
            arrayList.add(ex.jf);
            if (bl2) {
                arrayList.add(ex.jg);
            }
        }
        if ((n & 1) == 1) {
            arrayList.add(ex.jh);
            if (bl2) {
                arrayList.add(ex.ji);
            }
        }
        if ((n & 8) == 8) {
            arrayList.add(ex.jk);
            if (bl2) {
                arrayList.add(ex.jl);
            }
        }
        if ((n & 0x10) == 16) {
            arrayList.add(ex.jm);
            arrayList.add(ex.jt);
            if (bl2) {
                arrayList.add(ex.jn);
            }
        }
        if ((n & 0x20) == 32) {
            arrayList.add(ex.jo);
            arrayList.add(ex.jt);
            if (bl2) {
                arrayList.add(ex.jp);
            }
        }
        if ((n & 0x80) == 128) {
            arrayList.add(ex.jx);
            arrayList.add(ex.jt);
            if (bl2) {
                arrayList.add(ex.jy);
            }
        }
        boolean bl4 = bl = (n & 0x8000) != 0;
        if ((n & 0x400) == 1024) {
            if (bl) {
                arrayList.add(ex.iL);
                arrayList.add(ex.iP);
                arrayList.add(ex.iQ);
                arrayList.add(ex.iS);
            } else {
                arrayList.add(ex.iL);
                arrayList.add(ex.iM);
                arrayList.add(ex.iN);
                arrayList.add(ex.iO);
                arrayList.add(ex.iP);
                arrayList.add(ex.iQ);
                arrayList.add(ex.iR);
                arrayList.add(ex.iS);
            }
        }
        if ((n & 0x200) == 512) {
            if (bl) {
                arrayList.add(ex.iT);
                arrayList.add(ex.iU);
            } else {
                arrayList.add(ex.iT);
                arrayList.add(ex.iU);
                arrayList.add(ex.iV);
                arrayList.add(ex.iW);
                arrayList.add(ex.iZ);
                arrayList.add(ex.jb);
                if (bl2) {
                    arrayList.add(ex.iY);
                }
                if ((n & 0x2000) == 0) {
                    arrayList.add(ex.jd);
                }
            }
        }
        if ((n & 0x800) == 2048) {
            arrayList.add(ex.jc);
        }
        return arrayList;
    }

    public static List b(int n, String string) {
        String string2 = string.toUpperCase();
        return jJ.stream().filter(ey2 -> ey2.getName().toUpperCase().indexOf(string2) >= 0 && ey.O(n).contains((Object)ey2.bc())).collect(Collectors.toList());
    }

    public static List bl() {
        return jJ.stream().filter(ey2 -> ey2 instanceof eQ && !ey2.bb() && ey2.bc() != ex.jz).collect(Collectors.toList());
    }

    public static List bm() {
        return jJ.stream().filter(ey2 -> ey2 instanceof eH && !ey2.bb()).collect(Collectors.toList());
    }

    public static ey d(Object object) {
        String string = object instanceof fg ? ((fg)object).bP() : object.toString();
        return jJ.stream().filter(ey2 -> {
            if (ey2.bb() || ey2 instanceof eR) {
                return string.startsWith(String.valueOf(ey2.id) + "#");
            }
            return object.equals(ey2.id);
        }).findFirst().orElse(null);
    }

    static eA p(String string) {
        return jI.stream().filter(eA2 -> string.equals(eA2.id)).findFirst().orElse(null);
    }

    static /* synthetic */ Pattern bn() {
        return jH;
    }
}
