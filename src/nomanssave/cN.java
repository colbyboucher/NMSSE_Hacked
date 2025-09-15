/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;
import nomanssave.cO;
import nomanssave.cP;
import nomanssave.cQ;
import nomanssave.cR;
import nomanssave.cS;
import nomanssave.gD;

public class cN
extends JComboBox {
    private final boolean gm;
    private final Enum[] gn;
    private final List go;
    private cR gp;
    private Object gq;
    private static final Color gr = Color.RED;
    private static final Color gs = new Color(255, 100, 100);

    public cN(Class clazz) {
        this.gm = gD.class.isAssignableFrom(clazz);
        this.gn = (Enum[])clazz.getEnumConstants();
        this.go = new ArrayList();
        this.setModel(new cO(this, clazz));
        this.setRenderer(new cP(this));
    }

    public void m(String string) {
        Object object = null;
        if (string != null) {
            Enum[] enumArray = this.gn;
            int n = this.gn.length;
            int n2 = 0;
            while (n2 < n) {
                Enum enum_ = enumArray[n2];
                if (this.gm) {
                    if (((gD)((Object)enum_)).K().equals(string)) {
                        object = enum_;
                        break;
                    }
                } else if (enum_.name().equals(string)) {
                    object = enum_;
                    break;
                }
                ++n2;
            }
            if (object == null) {
                int n3 = this.go.indexOf(new cQ(this, string));
                if (n3 >= 0) {
                    object = this.go.get(n3);
                } else {
                    object = this.gm ? new cS(this, string) : string;
                    this.go.add(object);
                }
            }
        }
        this.gq = object;
        this.selectedItemChanged();
        this.updateUI();
    }

    public void a(cR cR2) {
        this.gp = cR2;
    }

    static /* synthetic */ List a(cN cN2) {
        return cN2.go;
    }

    static /* synthetic */ Object b(cN cN2) {
        return cN2.gq;
    }

    static /* synthetic */ void a(cN cN2, Object object) {
        cN2.gq = object;
    }

    static /* synthetic */ cR c(cN cN2) {
        return cN2.gp;
    }

    static /* synthetic */ boolean d(cN cN2) {
        return cN2.gm;
    }

    static /* synthetic */ Enum[] e(cN cN2) {
        return cN2.gn;
    }

    static /* synthetic */ Color ag() {
        return gs;
    }

    static /* synthetic */ Color aB() {
        return gr;
    }
}
