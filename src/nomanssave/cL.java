/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import java.io.File;
import javax.swing.filechooser.FileView;
import nomanssave.cK;

class cL
extends FileView {
    final /* synthetic */ cK gl;

    cL(cK cK2) {
        this.gl = cK2;
    }

    @Override
    public String getName(File file) {
        String string = file.getName();
        if (string.endsWith(".json")) {
            return string.substring(0, string.length() - 5);
        }
        return string;
    }
}
