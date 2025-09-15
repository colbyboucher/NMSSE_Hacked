/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import nomanssave.eV;
import nomanssave.eY;
import nomanssave.fc;
import nomanssave.fd;

class eZ
extends fc {
    final int index;
    final /* synthetic */ eY kL;

    eZ(eY eY2, int n, fc fc2) {
        this.kL = eY2;
        super(eY2, fc2);
        this.index = n;
    }

    @Override
    Object a(Class clazz, boolean bl) {
        if (this.kN == null) {
            throw new RuntimeException("Unexpected path");
        }
        eV eV2 = (eV)this.kN.a(eV.class, bl);
        if (this.index < 0 || this.index > eV2.length) {
            throw new RuntimeException("Array index out of bounds");
        }
        if (this.index == eV2.length) {
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
            eV2.add(t);
            return t;
        }
        if (clazz.isInstance(eV2.values[this.index])) {
            return clazz.cast(eV2.values[this.index]);
        }
        throw new RuntimeException("Unexpected path");
    }

    @Override
    Object getValue() {
        if (this.kN == null) {
            throw new RuntimeException("Unexpected path");
        }
        eV eV2 = (eV)this.kN.a(eV.class, false);
        return eV2.get(this.index);
    }

    @Override
    Object a(Object object, boolean bl) {
        if (this.kN == null) {
            throw new RuntimeException("Unexpected path");
        }
        eV eV2 = (eV)this.kN.a(eV.class, bl);
        if (this.index == eV2.length) {
            eV2.add(object);
            return null;
        }
        return eV2.set(this.index, object);
    }

    @Override
    Object bG() {
        if (this.kN == null) {
            throw new RuntimeException("Unexpected path");
        }
        eV eV2 = (eV)this.kN.a(eV.class, false);
        return eV2.remove(this.index);
    }

    @Override
    eY e(eY eY2) {
        if (this.kN == null) {
            throw new RuntimeException("Unexpected path");
        }
        eV eV2 = (eV)this.kN.a(eV.class, false);
        Object object = eV2.get(this.index);
        if (object == null) {
            eV2.set(this.index, eY2);
            return null;
        }
        if (object instanceof eY) {
            ((eY)object).c(eY2);
            return (eY)object;
        }
        throw new RuntimeException("Unsupported type: " + object.getClass().getSimpleName());
    }
}
