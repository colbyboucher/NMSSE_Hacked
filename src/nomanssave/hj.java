/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import nomanssave.aH;
import nomanssave.hc;
import nomanssave.hi;

class hj
extends Thread {
    final long sK;
    String sL;

    hj(long l) {
        this.sK = l;
        this.sL = aH.getProperty("KnownPlayers." + l);
        hi.ep().put(l, this);
        this.start();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void run() {
        String string;
        try {
            string = hi.j(this.sK);
        }
        catch (IOException iOException) {
            hc.a("Steam lookup error", iOException);
            string = null;
        }
        HashMap hashMap = hi.ep();
        synchronized (hashMap) {
            if (string != null) {
                Long[] longArray = (Long[])aH.a("SteamIDs", Long.class);
                boolean bl = Arrays.asList(longArray).stream().anyMatch(l -> l.equals(this.sK));
                if (!bl) {
                    Object[] objectArray = new Long[longArray.length + 1];
                    System.arraycopy(longArray, 0, objectArray, 0, longArray.length);
                    objectArray[longArray.length] = this.sK;
                    aH.a("SteamIDs", objectArray);
                }
                if (!string.equals(this.sL)) {
                    aH.setProperty("KnownPlayers." + this.sK, string);
                    this.sL = string;
                }
            }
        }
    }
}
