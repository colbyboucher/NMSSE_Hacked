/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import java.awt.EventQueue;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import nomanssave.Application;
import nomanssave.hc;
import nomanssave.y;

class x
extends Thread {
    final /* synthetic */ Application aZ;
    private final /* synthetic */ boolean ba;

    x(Application application, boolean bl) {
        this.aZ = application;
        this.ba = bl;
    }

    @Override
    public void run() {
        try {
            int n;
            long l = Math.round((double)Runtime.getRuntime().totalMemory() / 1000000.0);
            long l2 = Math.round((double)Runtime.getRuntime().maxMemory() / 1000000.0);
            hc.debug("Mem Usage: " + l + "/" + l2 + " MB");
            URL uRL = new URL("https://github.com/goatfungus/NMSSaveEditor/raw/master/VERSION.txt");
            URLConnection uRLConnection = uRL.openConnection();
            int n2 = uRLConnection.getContentLength();
            InputStream inputStream = uRLConnection.getInputStream();
            byte[] byArray = new byte[n2];
            int n3 = 0;
            while ((n = inputStream.read(byArray, n3, n2)) > 0) {
                n3 += n;
                n2 -= n;
            }
            if (n2 > 0) {
                throw new IOException("short read");
            }
            String string = new String(byArray, 0, byArray.length);
            if (string.endsWith("\r\n")) {
                string = string.substring(0, string.length() - 2);
            } else if (string.endsWith("\n")) {
                string = string.substring(0, string.length() - 1);
            }
            hc.debug("Latest version: \"" + string + "\"");
            hc.debug("Current version: \"1.19.0\"");
            if (!"1.19.0".equals(string)) {
                EventQueue.invokeLater(new y(this, this.ba));
            }
        }
        catch (IOException iOException) {
            // empty catch block
        }
    }

    static /* synthetic */ Application a(x x2) {
        return x2.aZ;
    }
}
