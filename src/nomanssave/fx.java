/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import nomanssave.eG;
import nomanssave.eY;
import nomanssave.ff;
import nomanssave.fj;
import nomanssave.fn;
import nomanssave.fs;
import nomanssave.fu;
import nomanssave.fw;

class fx
implements fs {
    final fw lI;
    final /* synthetic */ fu lJ;

    fx(fu fu2, fw fw2) {
        this.lJ = fu2;
        this.lI = fw2;
    }

    @Override
    public String K() {
        return "savedata" + this.lI.lO;
    }

    @Override
    public fn L() {
        return this.lI.be;
    }

    @Override
    public eY M() {
        byte[] byArray = this.lI.ca();
        Throwable throwable = null;
        Object var3_4 = null;
        try (ff ff2 = new ff(new ByteArrayInputStream(byArray), 2);){
            return ff2.a(eG.jV);
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

    @Override
    public String b(eY eY2) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        Throwable throwable = null;
        Object var4_5 = null;
        try (fj fj2 = new fj(byteArrayOutputStream, 2);){
            fj2.h(eY2);
        }
        catch (Throwable throwable2) {
            if (throwable == null) {
                throwable = throwable2;
            } else if (throwable != throwable2) {
                throwable.addSuppressed(throwable2);
            }
            throw throwable;
        }
        this.lI.d(byteArrayOutputStream.toByteArray());
        return this.K();
    }

    @Override
    public long lastModified() {
        return this.lI.bd;
    }

    public String toString() {
        return this.K();
    }
}
