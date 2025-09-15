/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import nomanssave.eY;
import nomanssave.fc;
import nomanssave.fd;

class fb
extends fc {
    final String name;
    final /* synthetic */ eY kL;

    fb(eY eY2, String string, fc fc2) {
        this.kL = eY2;
        super(eY2, fc2);
        this.name = string;
    }

    @Override
    Object a(Class clazz, boolean bl) {
        eY eY2 = this.kN == null ? this.kL : (eY)this.kN.a(eY.class, bl);
        int n = eY2.indexOf(this.name);
        if (n < 0) {
            Object t;
            if (!bl) {
                throw new fd(null);
            }
            try {
                t = clazz.newInstance();
            }
            catch (IllegalAccessException | InstantiationException reflectiveOperationException) {
                throw new RuntimeException("Unexpected error", reflectiveOperationException);
            }
            eY2.put(this.name, t);
            return t;
        }
        if (clazz.isInstance(eY2.values[n])) {
            return clazz.cast(eY2.values[n]);
        }
        throw new RuntimeException("Unexpected path");
    }

    @Override
    Object getValue() {
        eY eY2 = this.kN == null ? this.kL : (eY)this.kN.a(eY.class, false);
        return eY2.get(this.name);
    }

    @Override
    Object a(Object object, boolean bl) {
        eY eY2 = this.kN == null ? this.kL : (eY)this.kN.a(eY.class, bl);
        return eY2.put(this.name, object);
    }

    @Override
    Object bG() {
        eY eY2 = this.kN == null ? this.kL : (eY)this.kN.a(eY.class, false);
        return eY2.F(this.name);
    }

    @Override
    eY e(eY eY2) {
        eY eY3 = this.kN == null ? this.kL : (eY)this.kN.a(eY.class, false);
        Object object = eY3.get(this.name);
        if (object == null) {
            eY3.put(this.name, eY2);
            return null;
        }
        if (object instanceof eY) {
            ((eY)object).c(eY2);
            return (eY)object;
        }
        throw new RuntimeException("Unsupported type: " + object.getClass().getSimpleName());
    }
}
