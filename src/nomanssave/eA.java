/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import java.util.function.Function;
import java.util.regex.Matcher;
import nomanssave.ey;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

class eA {
    final String id;
    final String name;
    final String jM;
    final String description;

    eA(Element element) {
        this.id = element.getAttribute("id");
        this.name = element.getAttribute("name");
        this.jM = element.getAttribute("subtitle");
        String string = null;
        NodeList nodeList = element.getChildNodes();
        int n = 0;
        while (n < nodeList.getLength()) {
            Node node = nodeList.item(n);
            if (node instanceof Element && (element = (Element)node).getNodeName().equals("description")) {
                string = ey.a(element);
            }
            ++n;
        }
        this.description = string;
    }

    private String a(String string, Function function) {
        StringBuilder stringBuilder = new StringBuilder();
        int n = 0;
        Matcher matcher = ey.bn().matcher(string);
        while (matcher.find()) {
            stringBuilder.append(string.substring(n, matcher.start()));
            stringBuilder.append((String)function.apply(matcher.group(1)));
            n = matcher.end();
        }
        stringBuilder.append(string.substring(n));
        return stringBuilder.toString();
    }

    String a(Function function) {
        return this.a(this.name, function);
    }

    String b(Function function) {
        return this.a(this.jM, function);
    }

    String c(Function function) {
        return this.description == null ? null : this.a(this.description, function);
    }
}
