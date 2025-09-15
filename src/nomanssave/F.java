/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import java.io.IOException;
import nomanssave.Application;
import nomanssave.eY;
import nomanssave.fn;
import nomanssave.fs;

class F
implements fs {
    final String filename;
    final long bd;
    final fn be;
    final eY bf;
    final /* synthetic */ Application aZ;

    public F(Application application, String string, long l, fn fn2, eY eY2) {
        this.aZ = application;
        this.filename = string;
        this.bd = l;
        this.be = fn2;
        this.bf = eY2;
    }

    @Override
    public String K() {
        return this.filename;
    }

    @Override
    public fn L() {
        return this.be;
    }

    @Override
    public long lastModified() {
        return this.bd;
    }

    @Override
    public eY M() {
        return this.bf;
    }

    @Override
    public String b(eY eY2) {
        throw new IOException("Save not supported!");
    }

    public String toString() {
        return this.filename;
    }
}
