/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import java.io.File;
import javax.swing.Icon;
import javax.swing.filechooser.FileView;
import nomanssave.cl;

class cm
extends FileView {
    final /* synthetic */ cl fI;

    cm(cl cl2) {
        this.fI = cl2;
    }

    @Override
    public Icon getIcon(File file) {
        String string = file.getName();
        if (string.endsWith(".pb3") || string.endsWith(".pb0")) {
            return cl.as();
        }
        return super.getIcon(file);
    }

    @Override
    public String getName(File file) {
        String string = file.getName();
        if (string.endsWith(".pb3") || string.endsWith(".pb0")) {
            return string.substring(0, string.length() - 4);
        }
        return string;
    }
}
