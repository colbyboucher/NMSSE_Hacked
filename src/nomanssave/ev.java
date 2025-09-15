/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import java.util.ArrayList;
import nomanssave.ew;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

class ev
extends ArrayList {
    final String id;

    ev(Element element) {
        this.id = element.getAttribute("id");
        NodeList nodeList = element.getChildNodes();
        int n = 0;
        while (n < nodeList.getLength()) {
            Node node = nodeList.item(n);
            if (node instanceof Element && node.getNodeName().equals("stacksize")) {
                this.add(new ew((Element)node));
            }
            ++n;
        }
    }
}
