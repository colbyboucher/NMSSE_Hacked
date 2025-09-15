/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import java.io.File;
import javax.swing.filechooser.FileFilter;
import nomanssave.cl;

class cn
extends FileFilter {
    final /* synthetic */ cl fI;

    cn(cl cl2) {
        this.fI = cl2;
    }

    @Override
    public String getDescription() {
        return "Planetary Base Backup File";
    }

    @Override
    public boolean accept(File file) {
        if (file.isDirectory()) {
            return !file.isHidden();
        }
        return file.getName().endsWith(".pb3");
    }
}
