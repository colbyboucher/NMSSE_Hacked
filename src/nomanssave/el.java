/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import java.io.File;
import javax.swing.Icon;
import javax.swing.filechooser.FileView;
import nomanssave.ej;

class el
extends FileView {
    final /* synthetic */ ej is;

    el(ej ej2) {
        this.is = ej2;
    }

    @Override
    public Icon getIcon(File file) {
        if (file.isFile()) {
            String string = file.getName();
            if (string.endsWith(".hg") && !string.startsWith("mf_")) {
                return ej.as();
            }
            if (string.equals("containers.index")) {
                return ej.au();
            }
            return null;
        }
        String string = ej.a(this.is, file);
        if (string == null) {
            return null;
        }
        return ej.aR();
    }

    @Override
    public String getName(File file) {
        if (file.isFile()) {
            return file.getName();
        }
        String string = ej.a(this.is, file);
        if (string == null) {
            return file.getName();
        }
        return "[" + string + "] " + file.getName();
    }
}
