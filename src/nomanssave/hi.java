/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import java.io.EOFException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import nomanssave.eV;
import nomanssave.eY;
import nomanssave.hj;

public class hi {
    private static final String sI = "9710BD8FCF192837DC6DEF6037AB2837";
    private static final HashMap sJ = new HashMap();

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static String h(long l) {
        hj hj2;
        HashMap hashMap = sJ;
        synchronized (hashMap) {
            hj2 = sJ.containsKey(l) ? (hj)sJ.get(l) : new hj(l);
        }
        try {
            hj2.join(500L);
        }
        catch (InterruptedException interruptedException) {
            // empty catch block
        }
        return hj2.sL;
    }

    private static String i(long l) {
        eY eY2 = hi.aC("http://api.steampowered.com/ISteamUser/GetPlayerSummaries/v0002/?key=9710BD8FCF192837DC6DEF6037AB2837&steamids=" + l);
        eV eV2 = eY2.d("response.players");
        if (eV2 == null || eV2.size() == 0) {
            return null;
        }
        int n = 0;
        while (n < eV2.size()) {
            eY eY3 = eV2.V(n);
            if (Long.toString(l).equals(eY3.getValueAsString("steamid"))) {
                return eY3.getValueAsString("personaname");
            }
            ++n;
        }
        return null;
    }

    private static eY aC(String string) {
        int n;
        URLConnection uRLConnection = new URL(string).openConnection();
        int n2 = uRLConnection.getContentLength();
        int n3 = 0;
        InputStream inputStream = uRLConnection.getInputStream();
        byte[] byArray = new byte[n2];
        while ((n = inputStream.read(byArray, n3, n2)) >= 0) {
            n3 += n;
            n2 -= n;
        }
        if (n2 > 0) {
            throw new EOFException();
        }
        String string2 = uRLConnection.getContentEncoding();
        String string3 = new String(byArray, string2 == null ? "UTF-8" : string2);
        return eY.E(string3);
    }

    static /* synthetic */ HashMap ep() {
        return sJ;
    }

    static /* synthetic */ String j(long l) {
        return hi.i(l);
    }
}
