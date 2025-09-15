/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import java.io.File;
import javax.swing.filechooser.FileFilter;
import nomanssave.cK;

class cM
extends FileFilter {
    final /* synthetic */ cK gl;

    cM(cK cK2) {
        this.gl = cK2;
    }

    @Override
    public String getDescription() {
        return "JSON File";
    }

    @Override
    public boolean accept(File file) {
        if (file.isDirectory()) {
            return !file.isHidden();
        }
        return file.getName().endsWith(".json");
    }
}
