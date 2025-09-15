/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import java.io.File;
import javax.swing.Icon;
import javax.swing.filechooser.FileView;
import nomanssave.cv;

class cw
extends FileView {
    final /* synthetic */ cv fR;

    cw(cv cv2) {
        this.fR = cv2;
    }

    @Override
    public Icon getIcon(File file) {
        String string = file.getName();
        if (string.endsWith(".wp0")) {
            return cv.as();
        }
        return super.getIcon(file);
    }

    @Override
    public String getName(File file) {
        String string = file.getName();
        if (string.endsWith(".wp0")) {
            return string.substring(0, string.length() - 4);
        }
        return string;
    }
}
