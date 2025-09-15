/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import java.io.File;
import javax.swing.filechooser.FileFilter;
import nomanssave.cs;

class cu
extends FileFilter {
    final /* synthetic */ cs fP;

    cu(cs cs2) {
        this.fP = cs2;
    }

    @Override
    public String getDescription() {
        return "Freighter Backup File";
    }

    @Override
    public boolean accept(File file) {
        if (file.isDirectory()) {
            return !file.isHidden();
        }
        return file.getName().endsWith(".fb3");
    }
}
