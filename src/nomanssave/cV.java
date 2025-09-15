/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import java.io.File;
import javax.swing.filechooser.FileFilter;
import nomanssave.cT;

class cV
extends FileFilter {
    final /* synthetic */ cT gw;

    cV(cT cT2) {
        this.gw = cT2;
    }

    @Override
    public String getDescription() {
        return "Ship Export File";
    }

    @Override
    public boolean accept(File file) {
        if (file.isDirectory()) {
            return !file.isHidden();
        }
        return file.getName().endsWith(".sh0");
    }
}
