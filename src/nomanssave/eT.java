/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import java.util.Comparator;
import nomanssave.eS;

class eT
implements Comparator {
    eT() {
    }

    public int a(eS eS2, eS eS3) {
        return eS2.text.compareTo(eS3.text);
    }

    public /* synthetic */ int compare(Object object, Object object2) {
        return this.a((eS)object, (eS)object2);
    }
}
