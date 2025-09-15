/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import java.io.File;
import javax.swing.filechooser.FileFilter;
import nomanssave.cp;

class cr
extends FileFilter {
    final /* synthetic */ cp fM;

    cr(cp cp2) {
        this.fM = cp2;
    }

    @Override
    public String getDescription() {
        return "Companion Export File";
    }

    @Override
    public boolean accept(File file) {
        if (file.isDirectory()) {
            return !file.isHidden();
        }
        return file.getName().endsWith(".pet") || file.getName().endsWith(".egg");
    }
}
