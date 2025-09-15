/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import java.awt.EventQueue;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import nomanssave.eV;
import nomanssave.eX;
import nomanssave.eZ;
import nomanssave.fb;
import nomanssave.fc;
import nomanssave.fd;
import nomanssave.fe;
import nomanssave.fg;
import nomanssave.fh;
import nomanssave.hc;
import nomanssave.hk;

public class eY {
    private static final int kB = 10;
    private static final int kC = 10;
    private static final Pattern kH = Pattern.compile("[^\"\\.\\[\\]]+");
    int length = 0;
    String[] names = new String[10];
    Object[] values = new Object[10];
    Object kD;
    fe kI;
    Map kJ = new HashMap();
    private static final Pattern kK = Pattern.compile("([^\\.\\[\\]]+)|(?:\\.([^\\.\\[\\]]+))|(?:\\[(\\d+)\\])");

    public static eY E(String string) {
        return fh.Q(string);
    }

    public void b(String string, Function function) {
        this.kJ.put(string, function);
    }

    void a(String string, Object object) {
        int n = 0;
        while (n < this.length) {
            if (this.names[n].equals(string)) {
                throw new RuntimeException("duplicate key: " + string);
            }
            ++n;
        }
        if (this.values.length == this.length) {
            String[] stringArray = new String[this.length + 10];
            Object[] objectArray = new Object[this.length + 10];
            System.arraycopy(this.names, 0, stringArray, 0, this.length);
            System.arraycopy(this.values, 0, objectArray, 0, this.length);
            this.names = stringArray;
            this.values = objectArray;
        }
        this.names[this.length] = string;
        this.values[this.length] = object;
        fh.a(object, this);
        ++this.length;
    }

    public String bz() {
        return fh.a(this, System.lineSeparator(), true);
    }

    public String toString() {
        return fh.a(this, null, false);
    }

    public eY bE() {
        eY eY2 = new eY();
        eY2.names = new String[this.values.length];
        eY2.values = new Object[this.values.length];
        System.arraycopy(this.names, 0, eY2.names, 0, this.length);
        int n = 0;
        while (n < this.length) {
            if (this.values[n] instanceof eY) {
                eY2.values[n] = ((eY)this.values[n]).bE();
                fh.a(eY2.values[n], eY2);
            } else if (this.values[n] instanceof eV) {
                eY2.values[n] = ((eV)this.values[n]).bA();
                fh.a(eY2.values[n], eY2);
            } else {
                eY2.values[n] = this.values[n];
            }
            ++n;
        }
        eY2.length = this.length;
        return eY2;
    }

    public int size() {
        return this.length;
    }

    public List names() {
        String[] stringArray = new String[this.length];
        System.arraycopy(this.names, 0, stringArray, 0, this.length);
        return Arrays.asList(stringArray);
    }

    public boolean contains(String string) {
        if (string == null) {
            throw new NullPointerException();
        }
        if (!kH.matcher(string).matches()) {
            throw new RuntimeException("Invalid name: " + string);
        }
        int n = 0;
        while (n < this.length) {
            if (string.equals(this.names[n])) {
                return true;
            }
            ++n;
        }
        return false;
    }

    public Object get(String string) {
        if (string == null) {
            throw new NullPointerException();
        }
        if (!kH.matcher(string).matches()) {
            throw new RuntimeException("Invalid name: " + string);
        }
        int n = 0;
        while (n < this.length) {
            if (string.equals(this.names[n])) {
                return this.values[n];
            }
            ++n;
        }
        return null;
    }

    public Object put(String string, Object object) {
        if (string == null) {
            throw new NullPointerException();
        }
        if (!kH.matcher(string).matches()) {
            throw new RuntimeException("Invalid name: " + string);
        }
        if (object != null && !fh.a(object.getClass())) {
            throw new RuntimeException("Unsupported type: " + object.getClass().getSimpleName());
        }
        int n = 0;
        while (n < this.length) {
            if (string.equals(this.names[n])) {
                Object object2 = this.values[n];
                fh.i(object2);
                this.values[n] = object;
                fh.a(object, this);
                this.firePropertyChange(string, object2, object);
                return object2;
            }
            ++n;
        }
        if (this.values.length == this.length) {
            String[] stringArray = new String[this.length + 10];
            Object[] objectArray = new Object[this.length + 10];
            System.arraycopy(this.names, 0, stringArray, 0, this.length);
            System.arraycopy(this.values, 0, objectArray, 0, this.length);
            this.names = stringArray;
            this.values = objectArray;
        }
        this.names[this.length] = string;
        this.values[this.length] = object;
        fh.a(object, this);
        ++this.length;
        this.firePropertyChange(string, null, object);
        return null;
    }

    public Object F(String string) {
        if (string == null) {
            throw new NullPointerException();
        }
        if (!kH.matcher(string).matches()) {
            throw new RuntimeException("Invalid name: " + string);
        }
        int n = 0;
        while (n < this.length) {
            if (string.equals(this.names[n])) {
                Object object = this.values[n];
                fh.i(object);
                ++n;
                while (n < this.length) {
                    this.names[n - 1] = this.names[n];
                    this.values[n - 1] = this.values[n];
                    ++n;
                }
                --this.length;
                this.firePropertyChange(string, object, null);
                return object;
            }
            ++n;
        }
        return null;
    }

    public void c(eY eY2) {
        if (eY2 == null) {
            throw new NullPointerException();
        }
        int n = 0;
        while (n < eY2.length) {
            Object[] objectArray;
            boolean bl = false;
            int n2 = 0;
            while (n2 < this.length) {
                if (eY2.names[n].equals(this.names[n2])) {
                    objectArray = this.values[n2];
                    fh.i(objectArray);
                    if (objectArray instanceof eY && eY2.values[n] instanceof eY) {
                        ((eY)objectArray).c((eY)eY2.values[n]);
                        this.values[n2] = objectArray;
                    } else {
                        this.values[n2] = eY2.values[n];
                    }
                    fh.a(this.values[n2], this);
                    bl = true;
                }
                ++n2;
            }
            if (!bl) {
                if (this.values.length == this.length) {
                    String[] stringArray = new String[this.length + 10];
                    objectArray = new Object[this.length + 10];
                    System.arraycopy(this.names, 0, stringArray, 0, this.length);
                    System.arraycopy(this.values, 0, objectArray, 0, this.length);
                    this.names = stringArray;
                    this.values = objectArray;
                }
                this.names[this.length] = eY2.names[n];
                this.values[this.length] = eY2.values[n];
                fh.a(this.values[this.length], this);
                ++this.length;
            }
            ++n;
        }
        this.firePropertyChange("", null, this);
    }

    int indexOf(String string) {
        int n = 0;
        while (n < this.length) {
            if (string.equals(this.names[n])) {
                return n;
            }
            ++n;
        }
        return -1;
    }

    Object set(int n, Object object) {
        Object object2 = this.values[n];
        fh.i(object2);
        this.values[n] = object;
        fh.a(object, this);
        this.firePropertyChange(this.names[n], object2, null);
        return object2;
    }

    Object remove(int n) {
        String string = this.names[n];
        Object object = this.values[n];
        fh.i(object);
        int n2 = n + 1;
        while (n2 < this.length) {
            this.names[n2 - 1] = this.names[n2];
            this.values[n2 - 1] = this.values[n2];
            ++n2;
        }
        --this.length;
        this.firePropertyChange(string, object, null);
        return object;
    }

    public void clear() {
        int n = 0;
        while (n < this.length) {
            fh.i(this.values[n]);
            this.firePropertyChange(this.names[n], this.values[n], null);
            ++n;
        }
        this.length = 0;
    }

    public void a(fe fe2) {
        this.kI = fe2;
    }

    void a(Object object, String string, Object object2, Object object3) {
        int n = 0;
        while (n < this.length) {
            if (object == this.values[n]) {
                this.firePropertyChange(String.valueOf(this.names[n]) + string, object2, object3);
                return;
            }
            ++n;
        }
    }

    private void firePropertyChange(String string, Object object, Object object2) {
        String string2;
        if (this.kI != null) {
            EventQueue.invokeLater(() -> this.kI.propertyChanged(string, object, object2));
        }
        String string3 = string2 = string.length() == 0 ? "" : "." + string;
        if (this.kD instanceof eY) {
            ((eY)this.kD).a(this, string2, object, object2);
        }
        if (this.kD instanceof eV) {
            ((eV)this.kD).a(this, string2, object, object2);
        }
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     */
    private fc G(String string) {
        Map.Entry entry2;
        for (Map.Entry entry2 : this.kJ.entrySet()) {
            if (string.equals(entry2.getKey())) {
                string = (String)((Function)entry2.getValue()).apply(this);
                break;
            }
            if (!string.startsWith(String.valueOf((String)entry2.getKey()) + ".") && !string.startsWith(String.valueOf((String)entry2.getKey()) + "[")) continue;
            string = String.valueOf((String)((Function)entry2.getValue()).apply(this)) + string.substring(((String)entry2.getKey()).length());
            break;
        }
        entry2 = kK.matcher(string);
        if (((Matcher)((Object)entry2)).find() && ((Matcher)((Object)entry2)).start() == 0) {
            void var4_7;
            int n = ((Matcher)((Object)entry2)).end();
            if (((Matcher)((Object)entry2)).group(1) != null) {
                fb fb2 = new fb(this, ((Matcher)((Object)entry2)).group(1), null);
            } else {
                if (((Matcher)((Object)entry2)).group(3) == null) {
                    throw new RuntimeException("Invalid path");
                }
                eZ eZ2 = new eZ(this, Integer.parseInt(((Matcher)((Object)entry2)).group(3)), null);
            }
            while (((Matcher)((Object)entry2)).find() && ((Matcher)((Object)entry2)).start() == n) {
                n = ((Matcher)((Object)entry2)).end();
                if (((Matcher)((Object)entry2)).group(2) != null) {
                    fb fb3 = new fb(this, ((Matcher)((Object)entry2)).group(2), (fc)var4_7);
                    continue;
                }
                if (((Matcher)((Object)entry2)).group(3) == null) {
                    throw new RuntimeException("Invalid path");
                }
                eZ eZ3 = new eZ(this, Integer.parseInt(((Matcher)((Object)entry2)).group(3)), (fc)var4_7);
            }
            if (((Matcher)((Object)entry2)).hitEnd()) {
                return var4_7;
            }
        }
        throw new RuntimeException("Invalid path");
    }

    public Object getValue(String string) {
        try {
            return this.G(string).getValue();
        }
        catch (fd fd2) {
            hc.debug("Path not found: " + string);
            return null;
        }
        catch (RuntimeException runtimeException) {
            hc.warn("Error getting value: " + string + ", " + runtimeException.getMessage());
            return null;
        }
    }

    public eY H(String string) {
        return (eY)this.getValue(string);
    }

    public eV d(String string) {
        return (eV)this.getValue(string);
    }

    public String getValueAsString(String string) {
        Object object = this.getValue(string);
        if (object instanceof fg) {
            return object.toString();
        }
        return (String)object;
    }

    public String I(String string) {
        Object object = this.getValue(string);
        if (object == null) {
            return "";
        }
        if (object instanceof Number) {
            String string2 = Long.toHexString(((Number)object).longValue());
            while (string2.length() < 16) {
                string2 = "0" + string2;
            }
            return "0x" + string2.toUpperCase();
        }
        return (String)this.getValue(string);
    }

    public int J(String string) {
        Object object = this.getValue(string);
        if (object == null) {
            return 0;
        }
        return ((Number)object).intValue();
    }

    public int c(String string, int n) {
        Object object = this.getValue(string);
        if (object == null) {
            return n;
        }
        return ((Number)object).intValue();
    }

    public long K(String string) {
        Object object = this.getValue(string);
        if (object == null) {
            return 0L;
        }
        return ((Number)object).longValue();
    }

    public long a(String string, long l) {
        Object object = this.getValue(string);
        if (object == null) {
            return l;
        }
        return ((Number)object).longValue();
    }

    public double L(String string) {
        Object object = this.getValue(string);
        if (object == null) {
            return 0.0;
        }
        return ((Number)object).doubleValue();
    }

    public double c(String string, double d) {
        Object object = this.getValue(string);
        if (object == null) {
            return d;
        }
        return ((Number)object).doubleValue();
    }

    public boolean M(String string) {
        Object object = this.getValue(string);
        if (object == null) {
            return false;
        }
        return (Boolean)object;
    }

    public boolean a(String string, boolean bl) {
        Object object = this.getValue(string);
        if (object == null) {
            return bl;
        }
        return (Boolean)object;
    }

    public Object b(String string, Object object) {
        return this.G(string).a(object, false);
    }

    public Object c(String string, Object object) {
        return this.G(string).a(object, true);
    }

    public Object N(String string) {
        try {
            return this.G(string).bG();
        }
        catch (fd fd2) {
            hc.debug("Path not found: " + string);
            return null;
        }
        catch (RuntimeException runtimeException) {
            hc.warn("Error getting value: " + string + ", " + runtimeException.getMessage());
            return null;
        }
    }

    public eY b(String string, eY eY2) {
        return this.G(string).e(eY2);
    }

    public void d(eY eY2) {
        if (eY2 == null) {
            throw new NullPointerException();
        }
        if (eY2.kD != null) {
            throw new RuntimeException("Object must not have a parent");
        }
        this.clear();
        this.length = eY2.length;
        this.names = new String[eY2.length];
        this.values = new Object[eY2.length];
        System.arraycopy(eY2.names, 0, this.names, 0, this.length);
        int n = 0;
        while (n < this.length) {
            if (eY2.values[n] instanceof eY) {
                this.values[n] = ((eY)eY2.values[n]).bE();
                fh.a(this.values[n], this);
            } else if (eY2.values[n] instanceof eV) {
                this.values[n] = ((eV)eY2.values[n]).bA();
                fh.a(this.values[n], this);
            } else {
                this.values[n] = eY2.values[n];
            }
            this.firePropertyChange(this.names[n], null, this.values[n]);
            ++n;
        }
    }

    public void c(File file) {
        Throwable throwable = null;
        Object var3_4 = null;
        try (FileOutputStream fileOutputStream = new FileOutputStream(file);){
            String string = fh.b(this, true);
            fileOutputStream.write(string.getBytes(StandardCharsets.UTF_8));
        }
        catch (Throwable throwable2) {
            if (throwable == null) {
                throwable = throwable2;
            } else if (throwable != throwable2) {
                throwable.addSuppressed(throwable2);
            }
            throw throwable;
        }
    }

    public void d(File file) {
        block10: {
            Throwable throwable = null;
            Object var3_4 = null;
            try (FileInputStream fileInputStream = new FileInputStream(file);){
                String string = new String(hk.g(fileInputStream), StandardCharsets.UTF_8);
                Object object = fh.P(string);
                if (object instanceof eY) {
                    this.d((eY)object);
                    break block10;
                }
                throw new eX("Object expected", 0, 0);
            }
            catch (Throwable throwable2) {
                if (throwable == null) {
                    throwable = throwable2;
                } else if (throwable != throwable2) {
                    throwable.addSuppressed(throwable2);
                }
                throw throwable;
            }
        }
    }

    public /* synthetic */ Object clone() {
        return this.bE();
    }

    static /* synthetic */ Pattern bF() {
        return kH;
    }
}
