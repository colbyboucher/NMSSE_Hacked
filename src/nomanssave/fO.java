/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import nomanssave.fJ;
import nomanssave.fL;
import nomanssave.fN;
import nomanssave.hc;

class fO
implements FileFilter {
    final /* synthetic */ fN mw;
    private final /* synthetic */ ArrayList mg;

    fO(fN fN2, ArrayList arrayList) {
        this.mw = fN2;
        this.mg = arrayList;
    }

    @Override
    public boolean accept(File file) {
        Matcher matcher = fJ.cl().matcher(file.getName());
        if (matcher.matches()) {
            int n;
            int n2 = n = matcher.group(1).length() == 0 ? 0 : Integer.parseInt(matcher.group(1)) - 1;
            if (n / 2 == this.mw.lT) {
                try {
                    this.mg.add(new fL(fN.a(this.mw), file.getName(), n));
                }
                catch (IOException iOException) {
                    hc.a("Cannot load " + file.getName(), iOException);
                }
            }
        }
        return false;
    }
}
