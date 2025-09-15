/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import java.io.File;
import javax.swing.Icon;
import javax.swing.filechooser.FileView;
import nomanssave.cs;

class ct
extends FileView {
    final /* synthetic */ cs fP;

    ct(cs cs2) {
        this.fP = cs2;
    }

    @Override
    public Icon getIcon(File file) {
        String string = file.getName();
        if (string.endsWith(".fb3")) {
            return cs.as();
        }
        return super.getIcon(file);
    }

    @Override
    public String getName(File file) {
        String string = file.getName();
        if (string.endsWith(".fb3")) {
            return string.substring(0, string.length() - 4);
        }
        return string;
    }
}
