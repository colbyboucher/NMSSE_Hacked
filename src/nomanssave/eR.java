/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import java.io.ByteArrayOutputStream;
import java.util.List;
import nomanssave.eA;
import nomanssave.eB;
import nomanssave.eQ;
import nomanssave.ex;
import nomanssave.ey;
import nomanssave.fg;
import org.w3c.dom.Element;

public class eR
extends ey {
    final String kc;
    final eA kn;
    final /* synthetic */ eQ ko;

    eR(eQ eQ2, Element element) {
        this.ko = eQ2;
        super(element.getAttribute("id"));
        this.kc = element.hasAttribute("icon") ? element.getAttribute("icon") : null;
        this.kn = ey.p(element.getAttribute("template"));
    }

    @Override
    public Object aZ() {
        return this.M(this.ko.jY ? (int)Math.floor(Math.random() * 100000.0) : 0);
    }

    @Override
    public Object M(int n) {
        int n2;
        if (this.id.length() != 13 || this.id.charAt(0) != '^') {
            throw new RuntimeException("Cannot create ID: invalid string");
        }
        if (n < 0 || n >= 100000) {
            throw new RuntimeException("Cannot create ID: invalid proc");
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byteArrayOutputStream.write(94);
        int n3 = 0;
        while (n3 < 6) {
            n2 = "0123456789ABCDEFabcdef".indexOf(this.id.charAt(n3 * 2 + 1));
            int n4 = "0123456789ABCDEFabcdef".indexOf(this.id.charAt(n3 * 2 + 2));
            if (n2 < 0 || n4 < 0) {
                throw new RuntimeException("Cannot create ID: invalid hex");
            }
            if (n2 >= 16) {
                n2 -= 6;
            }
            if (n4 >= 16) {
                n4 -= 6;
            }
            byteArrayOutputStream.write(n2 << 4 | n4);
            ++n3;
        }
        byteArrayOutputStream.write(35);
        n3 = 100000;
        while (n3 > 1) {
            n2 = n * 10 / n3 % 10;
            byteArrayOutputStream.write("0123456789ABCDEFabcdef".charAt(n2));
            n3 /= 10;
        }
        return new fg(byteArrayOutputStream.toByteArray());
    }

    @Override
    public eB ba() {
        return eB.jO;
    }

    @Override
    public boolean bb() {
        return this.ko.jY;
    }

    private String y(String string) {
        if ("NAME".equals(string)) {
            return this.ko.name;
        }
        if ("TECH_DESC".equals(string)) {
            return this.ko.description;
        }
        return string;
    }

    @Override
    public String getName() {
        return this.kn.a(this::y);
    }

    @Override
    public ex bc() {
        return ex.jd;
    }

    @Override
    public boolean bd() {
        return false;
    }

    @Override
    public boolean be() {
        return false;
    }

    @Override
    public Integer bf() {
        return null;
    }

    @Override
    public String bg() {
        return this.kn.b(this::y);
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
        return 0;
    }

    @Override
    public String getDescription() {
        return this.kn.c(this::y);
    }

    @Override
    public List bk() {
        return this.ko.ke;
    }

    @Override
    public String toString() {
        return this.ko.name.length() == 0 ? this.id : this.ko.name;
    }
}
