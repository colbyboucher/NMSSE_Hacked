/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import java.util.Arrays;
import java.util.stream.Stream;
import nomanssave.eY;
import nomanssave.fg;
import nomanssave.fh;

public class eV {
    private static final int kB = 10;
    private static final int kC = 10;
    int length;
    Object[] values;
    Object kD;

    public static eV D(String string) {
        return fh.R(string);
    }

    public eV() {
        this.length = 0;
        this.values = new Object[10];
    }

    public eV(Object ... objectArray) {
        this.length = objectArray.length;
        this.values = new Object[objectArray.length];
        int n = 0;
        while (n < this.length) {
            if (objectArray[n] != null && !fh.a(objectArray[n].getClass())) {
                throw new RuntimeException("Unsupported type: " + objectArray[n].getClass().getSimpleName());
            }
            this.values[n] = objectArray[n];
            fh.a(objectArray[n], this);
            ++n;
        }
    }

    void e(Object object) {
        if (this.values.length == this.length) {
            Object[] objectArray = new Object[this.length + 10];
            System.arraycopy(this.values, 0, objectArray, 0, this.length);
            this.values = objectArray;
        }
        this.values[this.length] = object;
        fh.a(object, this);
        ++this.length;
    }

    Object U(int n) {
        return this.values[n];
    }

    public String bz() {
        return fh.a(this, System.lineSeparator(), true);
    }

    public String toString() {
        return fh.a(this, null, false);
    }

    public eV bA() {
        eV eV2 = new eV();
        eV2.values = new Object[this.values.length];
        int n = 0;
        while (n < this.length) {
            if (this.values[n] instanceof eY) {
                eV2.values[n] = ((eY)this.values[n]).bE();
                fh.a(eV2.values[n], eV2);
            } else if (this.values[n] instanceof eV) {
                eV2.values[n] = ((eV)this.values[n]).bA();
                fh.a(eV2.values[n], eV2);
            } else {
                eV2.values[n] = this.values[n];
            }
            ++n;
        }
        eV2.length = this.length;
        return eV2;
    }

    public int size() {
        return this.length;
    }

    public int indexOf(Object object) {
        if (object == null) {
            throw new NullPointerException();
        }
        int n = 0;
        while (n < this.length) {
            if (object.equals(this.values[n])) {
                return n;
            }
            ++n;
        }
        return -1;
    }

    public Object get(int n) {
        if (n < 0 || n >= this.length) {
            throw new IndexOutOfBoundsException();
        }
        return this.values[n];
    }

    public Object set(int n, Object object) {
        if (n < 0 || n >= this.length) {
            throw new IndexOutOfBoundsException();
        }
        if (object != null && !fh.a(object.getClass())) {
            throw new RuntimeException("Unsupported type: " + object.getClass().getSimpleName());
        }
        Object object2 = this.values[n];
        fh.i(object2);
        this.values[n] = object;
        fh.a(object, this);
        this.firePropertyChange("[" + n + "]", object2, object);
        return object2;
    }

    public void add(Object object) {
        if (object != null && !fh.a(object.getClass())) {
            throw new RuntimeException("Unsupported type: " + object.getClass().getSimpleName());
        }
        eV eV2 = new eV();
        if (this.values.length == this.length) {
            eV2.values = this.values;
            eV2.length = this.length;
            Object[] objectArray = new Object[this.length + 10];
            System.arraycopy(this.values, 0, objectArray, 0, this.length);
            this.values = objectArray;
        } else {
            eV2.values = new Object[this.values.length];
            System.arraycopy(this.values, 0, eV2.values, 0, this.length);
            eV2.length = this.length;
        }
        this.values[this.length] = object;
        fh.a(object, this);
        ++this.length;
        this.firePropertyChange("", eV2, this);
    }

    public void add(int n, Object object) {
        if (n < 0 || n > this.length) {
            throw new IndexOutOfBoundsException();
        }
        if (object != null && !fh.a(object.getClass())) {
            throw new RuntimeException("Unsupported type: " + object.getClass().getSimpleName());
        }
        eV eV2 = new eV();
        if (this.values.length == this.length) {
            eV2.values = this.values;
            eV2.length = this.length;
            Object[] objectArray = new Object[this.length + 10];
            System.arraycopy(this.values, 0, objectArray, 0, this.length);
            this.values = objectArray;
        } else {
            eV2.values = new Object[this.values.length];
            System.arraycopy(this.values, 0, eV2.values, 0, this.length);
            eV2.length = this.length;
        }
        int n2 = this.length;
        while (n2 > n) {
            this.values[n2] = this.values[n2 - 1];
            ++n2;
        }
        this.values[n] = object;
        fh.a(object, this);
        ++this.length;
        this.firePropertyChange("", eV2, this);
    }

    public Object remove(int n) {
        if (n < 0 || n >= this.length) {
            throw new IndexOutOfBoundsException();
        }
        eV eV2 = new eV();
        eV2.values = new Object[this.values.length];
        System.arraycopy(this.values, 0, eV2.values, 0, this.length);
        eV2.length = this.length;
        Object object = this.values[n];
        fh.i(object);
        int n2 = n;
        while (n2 < this.length - 1) {
            this.values[n2] = this.values[n2 + 1];
            ++n2;
        }
        --this.length;
        this.firePropertyChange("", eV2, this);
        return object;
    }

    public void clear() {
        eV eV2 = new eV();
        eV2.values = new Object[this.values.length];
        System.arraycopy(this.values, 0, eV2.values, 0, this.length);
        eV2.length = this.length;
        int n = 0;
        while (n < this.length) {
            fh.i(this.values[n]);
            ++n;
        }
        this.length = 0;
        this.firePropertyChange("", eV2, this);
    }

    void a(Object object, String string, Object object2, Object object3) {
        int n = 0;
        while (n < this.length) {
            if (object == this.values[n]) {
                this.firePropertyChange("[" + n + "]" + string, object2, object3);
                return;
            }
            ++n;
        }
    }

    private void firePropertyChange(String string, Object object, Object object2) {
        if (this.kD instanceof eY) {
            ((eY)this.kD).a(this, string, object, object2);
        }
        if (this.kD instanceof eV) {
            ((eV)this.kD).a(this, string, object, object2);
        }
    }

    public Object getValue(int n) {
        return this.get(n);
    }

    public eY V(int n) {
        return (eY)this.getValue(n);
    }

    public eV W(int n) {
        return (eV)this.getValue(n);
    }

    public String X(int n) {
        Object object = this.getValue(n);
        if (object instanceof fg) {
            return object.toString();
        }
        return (String)object;
    }

    public int Y(int n) {
        Object object = this.getValue(n);
        if (object == null) {
            return 0;
        }
        return ((Number)object).intValue();
    }

    public long Z(int n) {
        Object object = this.getValue(n);
        if (object == null) {
            return 0L;
        }
        return ((Number)object).longValue();
    }

    public double aa(int n) {
        Object object = this.getValue(n);
        if (object == null) {
            return 0.0;
        }
        return ((Number)object).doubleValue();
    }

    public boolean ab(int n) {
        Object object = this.getValue(n);
        if (object == null) {
            return false;
        }
        return (Boolean)object;
    }

    public void a(int n, Object object) {
        this.set(n, object);
    }

    public void f(Object object) {
        this.add(object);
    }

    public boolean hasValue(Object object) {
        return this.indexOf(object) >= 0;
    }

    public boolean ac(int n) {
        this.remove(n);
        return true;
    }

    public boolean g(Object object) {
        int n = this.indexOf(object);
        if (n < 0) {
            return false;
        }
        this.remove(n);
        return true;
    }

    public Stream bB() {
        eY[] eYArray = new eY[this.length];
        int n = 0;
        int n2 = 0;
        while (n2 < this.length) {
            if (this.values[n2] instanceof eY) {
                eYArray[n++] = (eY)this.values[n2];
            }
            ++n2;
        }
        return Arrays.stream(eYArray, 0, n);
    }

    public /* synthetic */ Object clone() {
        return this.bA();
    }
}
