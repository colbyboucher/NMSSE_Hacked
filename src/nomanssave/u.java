/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import nomanssave.Application;
import nomanssave.fR;
import nomanssave.fq;

class u
implements fR {
    final /* synthetic */ Application aZ;

    u(Application application) {
        this.aZ = application;
    }

    @Override
    public void a(fq fq2) {
        if (!Application.a(this.aZ) || Application.b(this.aZ) != fq2) {
            return;
        }
        Application.a(this.aZ, true);
    }

    @Override
    public void a(fq fq2, int n, String string) {
        if (!Application.a(this.aZ) || Application.b(this.aZ) != fq2) {
            return;
        }
        Application.b(this.aZ, true);
        if (Application.c(this.aZ) >= 0 && Application.d(this.aZ)[Application.c(this.aZ)].getIndex() == n) {
            Application.c(this.aZ, true);
            if (Application.e(this.aZ) >= 0 && Application.f(this.aZ)[Application.e(this.aZ)].K().equals(string)) {
                Application.d(this.aZ, true);
            }
        }
    }
}
