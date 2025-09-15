/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import nomanssave.eY;
import nomanssave.fn;

public interface fs {
    public String K();

    public fn L();

    public eY M();

    public String b(eY var1);

    public long lastModified();

    default public String getName() {
        return null;
    }

    default public String getDescription() {
        return null;
    }
}
