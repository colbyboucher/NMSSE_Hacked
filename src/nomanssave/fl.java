/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import java.io.File;
import java.io.IOException;
import nomanssave.fm;
import nomanssave.fq;
import nomanssave.hc;

public class fl {
    private static final Object lock = new Object();
    private static fm lj;

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void a(fq fq2, File file) {
        Object object = lock;
        synchronized (object) {
            try {
                if (lj == null) {
                    lj = new fm();
                }
                lj.a(fq2, file);
            }
            catch (IOException iOException) {
                hc.a("Unable to register storage", iOException);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void b(fq fq2) {
        Object object = lock;
        synchronized (object) {
            try {
                if (lj != null) {
                    lj.b(fq2);
                }
            }
            catch (IOException iOException) {
                hc.a("Unable to unregister storage", iOException);
            }
        }
    }

    static /* synthetic */ Object bQ() {
        return lock;
    }
}
