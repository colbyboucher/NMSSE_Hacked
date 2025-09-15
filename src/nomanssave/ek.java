/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import java.io.File;
import javax.swing.filechooser.FileFilter;
import nomanssave.ej;

class ek
extends FileFilter {
    final /* synthetic */ ej is;

    ek(ej ej2) {
        this.is = ej2;
    }

    @Override
    public String getDescription() {
        return "Saved Game";
    }

    @Override
    public boolean accept(File file) {
        if (file.isDirectory()) {
            return true;
        }
        String string = file.getName();
        if (string.endsWith(".hg") && !string.startsWith("mf_")) {
            return true;
        }
        return string.equals("containers.index");
    }
}
