/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import java.io.File;
import javax.swing.filechooser.FileFilter;
import nomanssave.cv;

class cx
extends FileFilter {
    final /* synthetic */ cv fR;

    cx(cv cv2) {
        this.fR = cv2;
    }

    @Override
    public String getDescription() {
        return "Weapon Export File";
    }

    @Override
    public boolean accept(File file) {
        if (file.isDirectory()) {
            return !file.isHidden();
        }
        return file.getName().endsWith(".wp0");
    }
}
