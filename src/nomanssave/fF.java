/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import nomanssave.fA;
import nomanssave.fC;
import nomanssave.fE;
import nomanssave.hc;

class fF
implements FileFilter {
    final /* synthetic */ fE mf;
    private final /* synthetic */ ArrayList mg;

    fF(fE fE2, ArrayList arrayList) {
        this.mf = fE2;
        this.mg = arrayList;
    }

    @Override
    public boolean accept(File file) {
        Matcher matcher = fA.cb().matcher(file.getName());
        if (matcher.matches()) {
            int n;
            int n2 = n = matcher.group(1).length() == 0 ? 0 : Integer.parseInt(matcher.group(1)) - 1;
            if (n / 2 == this.mf.lT) {
                try {
                    this.mg.add(new fC(fE.a(this.mf), file.getName(), n));
                }
                catch (IOException iOException) {
                    hc.a("Cannot load " + file.getName(), iOException);
                }
            }
        }
        return false;
    }
}
