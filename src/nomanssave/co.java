/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import java.io.File;
import javax.swing.filechooser.FileFilter;
import nomanssave.cl;

class co
extends FileFilter {
    final /* synthetic */ cl fI;

    co(cl cl2) {
        this.fI = cl2;
    }

    @Override
    public String getDescription() {
        return "All Base Backup Files";
    }

    @Override
    public boolean accept(File file) {
        if (file.isDirectory()) {
            return !file.isHidden();
        }
        String string = file.getName();
        return string.endsWith(".pb3") || string.endsWith(".pb0");
    }
}
