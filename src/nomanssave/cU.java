/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import java.io.File;
import javax.swing.Icon;
import javax.swing.filechooser.FileView;
import nomanssave.cT;

class cU
extends FileView {
    final /* synthetic */ cT gw;

    cU(cT cT2) {
        this.gw = cT2;
    }

    @Override
    public Icon getIcon(File file) {
        String string = file.getName();
        if (string.endsWith(".sh0")) {
            return cT.as();
        }
        return super.getIcon(file);
    }

    @Override
    public String getName(File file) {
        String string = file.getName();
        if (string.endsWith(".sh0")) {
            return string.substring(0, string.length() - 4);
        }
        return string;
    }
}
