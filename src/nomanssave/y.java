/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import javax.swing.JOptionPane;
import nomanssave.Application;
import nomanssave.hc;
import nomanssave.x;

class y
implements Runnable {
    final /* synthetic */ x bb;
    private final /* synthetic */ boolean ba;

    y(x x2, boolean bl) {
        this.bb = x2;
        this.ba = bl;
    }

    @Override
    public void run() {
        String string = "A newer version of the save editor is available.\n";
        if (!this.ba) {
            string = String.valueOf(string) + "Please visit https://github.com/goatfungus/NMSSaveEditor to download the latest release.";
            JOptionPane.showOptionDialog(Application.h(x.a(this.bb)), string, "New Version Available", 0, 1, null, new Object[]{"OK"}, null);
        } else {
            string = String.valueOf(string) + "Would you like to download and install? (will require app restart)";
            int n = JOptionPane.showConfirmDialog(Application.h(x.a(this.bb)), string, "New Version Available", 0);
            if (n == 0) {
                Application.h(x.a(this.bb)).dispose();
                hc.info("Starting download...");
                File file = new File("~NMSSaveEditor.dl");
                try {
                    URL uRL = new URL("https://github.com/goatfungus/NMSSaveEditor/raw/master/NMSSaveEditor.jar");
                    URLConnection uRLConnection = uRL.openConnection();
                    int n2 = uRLConnection.getContentLength();
                    InputStream inputStream = uRLConnection.getInputStream();
                    try (FileOutputStream fileOutputStream = new FileOutputStream(file);){
                        int n3;
                        byte[] byArray = new byte[4096];
                        while ((n3 = inputStream.read(byArray)) > 0) {
                            fileOutputStream.write(byArray, 0, n3);
                            n2 -= n3;
                        }
                        if (n2 != 0) {
                            throw new IOException("invalid file size");
                        }
                    }
                    hc.info("Restarting editor...");
                    System.exit(2);
                }
                catch (IOException iOException) {
                    iOException.printStackTrace();
                    file.delete();
                    System.exit(1);
                }
            }
        }
    }
}
