/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import nomanssave.eB;
import nomanssave.ex;
import nomanssave.ey;
import nomanssave.ez;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class eH
extends ey {
    final boolean jY;
    final String name;
    final ex jZ;
    final boolean special;
    final Integer ka;
    final String jM;
    final boolean kb;
    final String kc;
    final int kd;
    final String description;
    final List ke;

    eH(Element element, boolean bl) {
        super(element.getAttribute("id"));
        this.jY = bl;
        this.name = element.getAttribute("name");
        this.jZ = bl ? ex.iY : ex.valueOf(element.getAttribute("category"));
        this.special = element.hasAttribute("special") ? Boolean.valueOf(element.getAttribute("special")) : false;
        this.ka = element.hasAttribute("chargeable") ? new Integer(element.getAttribute("chargeable")) : null;
        this.jM = element.getAttribute("subtitle");
        this.kb = element.hasAttribute("cooking") ? Boolean.valueOf(element.getAttribute("cooking")) : false;
        this.kc = element.hasAttribute("icon") ? element.getAttribute("icon") : null;
        this.kd = element.hasAttribute("multiplier") ? Integer.parseInt(element.getAttribute("multiplier")) : 0;
        String string = null;
        NodeList nodeList = element.getChildNodes();
        ArrayList<ez> arrayList = new ArrayList<ez>();
        int n = 0;
        while (n < nodeList.getLength()) {
            Node node = nodeList.item(n);
            if (node instanceof Element) {
                element = (Element)node;
                if (element.getNodeName().equals("description")) {
                    string = eH.a(element);
                } else if (element.getNodeName().equals("requirement")) {
                    arrayList.add(new ez(this, element));
                }
            }
            ++n;
        }
        this.description = string;
        this.ke = Collections.unmodifiableList(arrayList);
    }

    @Override
    public eB ba() {
        return eB.jO;
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
        return this.kb;
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

    @Override
    public String toString() {
        return this.name.length() == 0 ? this.id : this.name;
    }
}
