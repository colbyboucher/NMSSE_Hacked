/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import nomanssave.ey;
import org.w3c.dom.Element;

public class ez {
    final String id;
    final int jK;
    final /* synthetic */ ey jL;

    ez(ey ey2, Element element) {
        this.jL = ey2;
        this.id = element.getAttribute("id");
        this.jK = Integer.parseInt(element.getAttribute("quantity"));
    }

    public String getID() {
        return this.id;
    }

    public int bo() {
        return this.jK;
    }
}
