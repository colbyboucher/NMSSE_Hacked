/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import nomanssave.fg;

public interface gQ {
    public String getType();

    public Object dz();

    default public String ei() {
        Object object = this.dz();
        return object instanceof fg ? ((fg)object).bP() : object.toString();
    }

    public void m(Object var1);

    public int dA();

    public void aA(int var1);

    public int dB();
}
