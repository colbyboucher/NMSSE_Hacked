/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import nomanssave.eB;
import nomanssave.eR;
import nomanssave.ex;
import nomanssave.ey;
import nomanssave.ez;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class eQ
extends ey {
    private static final String gc = "0123456789ABCDEFabcdef";
    final boolean jY;
    final String name;
    final ex jZ;
    final boolean special;
    final Integer ka;
    final String jM;
    final String kc;
    final int kd;
    final String description;
    final List ke;
    final eR km;

    eQ(Element element, boolean bl) {
        super(element.getAttribute("id"));
        this.jY = bl;
        this.name = element.getAttribute("name");
        try {
            this.jZ = bl ? ex.valueOf("PROC_" + element.getAttribute("category")) : ex.valueOf(element.getAttribute("category"));
        }
        catch (IllegalArgumentException illegalArgumentException) {
            throw new RuntimeException("Error in tech: " + this.id, illegalArgumentException);
        }
        this.special = element.hasAttribute("special") ? Boolean.valueOf(element.getAttribute("special")) : false;
        this.ka = element.hasAttribute("chargeable") ? new Integer(element.getAttribute("chargeable")) : null;
        this.jM = element.getAttribute("subtitle");
        this.kc = element.hasAttribute("icon") ? element.getAttribute("icon") : null;
        this.kd = element.hasAttribute("multiplier") ? Integer.parseInt(element.getAttribute("multiplier")) : 0;
        String string = null;
        ArrayList<ez> arrayList = new ArrayList<ez>();
        eR eR2 = null;
        NodeList nodeList = element.getChildNodes();
        int n = 0;
        while (n < nodeList.getLength()) {
            Node node = nodeList.item(n);
            if (node instanceof Element) {
                Element element2 = (Element)node;
                if (element2.getNodeName().equals("description")) {
                    string = eQ.a(element2);
                } else if (element2.getNodeName().equals("requirement")) {
                    arrayList.add(new ez(this, element2));
                } else if (element2.getNodeName().equals("techbox")) {
                    eR2 = new eR(this, element2);
                }
            }
            ++n;
        }
        this.description = string;
        this.ke = Collections.unmodifiableList(arrayList);
        this.km = eR2;
    }

    @Override
    public eB ba() {
        return eB.jN;
    }

    @Override
    public boolean bb() {
        return this.jY;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public ex bc() {
        return this.jZ;
    }

    @Override
    public boolean bd() {
        return !this.jY && this.jZ != ex.ja && this.jZ != ex.iZ;
    }

    @Override
    public boolean be() {
        return !this.jY && this.special;
    }

    @Override
    public Integer bf() {
        return this.ka;
    }

    @Override
    public String bg() {
        return this.jM;
    }

    @Override
    public boolean bh() {
        return false;
    }

    @Override
    public String bi() {
        return this.kc;
    }

    @Override
    public int bj() {
        return this.kd;
    }

    @Override
    public String getDescription() {
        return this.description;
    }

    @Override
    public List bk() {
        return this.ke;
    }

    public eR bv() {
        return this.km;
    }

    @Override
    public String toString() {
        return this.name.length() == 0 ? this.id : this.name;
    }
}
