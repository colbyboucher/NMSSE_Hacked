/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import nomanssave.fT;
import nomanssave.fV;
import nomanssave.fZ;
import nomanssave.hc;

class ga
implements FileFilter {
    final /* synthetic */ fZ nb;
    private final /* synthetic */ ArrayList mg;

    ga(fZ fZ2, ArrayList arrayList) {
        this.nb = fZ2;
        this.mg = arrayList;
    }

    @Override
    public boolean accept(File file) {
        Matcher matcher = fT.cu().matcher(file.getName());
        if (matcher.matches()) {
            int n;
            int n2 = n = matcher.group(1).length() == 0 ? 0 : Integer.parseInt(matcher.group(1)) - 1;
            if (n / 2 == this.nb.lT) {
                try {
                    this.mg.add(new fV(fZ.a(this.nb), file.getName(), n));
                }
                catch (IOException iOException) {
                    hc.a("Cannot load " + file.getName(), iOException);
                }
            }
        }
        return false;
    }
}
