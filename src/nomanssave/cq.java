/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import java.io.File;
import javax.swing.Icon;
import javax.swing.filechooser.FileView;
import nomanssave.cp;

class cq
extends FileView {
    final /* synthetic */ cp fM;

    cq(cp cp2) {
        this.fM = cp2;
    }

    @Override
    public Icon getIcon(File file) {
        String string = file.getName();
        if (string.endsWith(".pet")) {
            return cp.as();
        }
        if (string.endsWith(".egg")) {
            return cp.au();
        }
        return super.getIcon(file);
    }

    @Override
    public String getName(File file) {
        String string = file.getName();
        if (string.endsWith(".pet")) {
            return string.substring(0, string.length() - 4);
        }
        if (string.endsWith(".egg")) {
            return string.substring(0, string.length() - 4);
        }
        return string;
    }
}
