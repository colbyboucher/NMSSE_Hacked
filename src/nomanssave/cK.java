/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import javax.swing.JFileChooser;
import nomanssave.cL;
import nomanssave.cM;

public class cK
extends JFileChooser {
    private static cK gk = null;
    private static final String name = "JSON File";

    public static cK aA() {
        if (gk == null) {
            gk = new cK();
        }
        return gk;
    }

    private cK() {
        this.setFileSelectionMode(0);
        this.setAcceptAllFileFilterUsed(false);
        this.setFileView(new cL(this));
        this.setFileFilter(new cM(this));
        this.setDialogTitle("Choose JSON File");
    }
}
