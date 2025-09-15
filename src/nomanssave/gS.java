/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.Key;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Collections;
import java.util.Map;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import nomanssave.eV;
import nomanssave.eY;
import nomanssave.ff;
import nomanssave.fj;
import nomanssave.gT;
import nomanssave.hk;

public class gS {
    private static byte[] lA = new byte[]{78, 77, 83, 66};
    private static byte[] rS = new byte[]{50, -99, -78, -55, 92, 88, -34, 74, -57, 17, 57, -108, -94, 127, 97, -79};

    private static double[] a(eY eY2, String string) {
        eV eV2 = eY2.d(string);
        if (eV2.size() != 3) {
            throw new RuntimeException("Invalid " + string + " coordinates");
        }
        return new double[]{eV2.aa(0), eV2.aa(1), eV2.aa(2)};
    }

    private static void a(eY eY2, String string, double[] dArray) {
        eY2.b(string, new eV(new Double(Double.isNaN(dArray[0]) ? 0.0 : dArray[0]), new Double(Double.isNaN(dArray[1]) ? 0.0 : dArray[1]), new Double(Double.isNaN(dArray[2]) ? 0.0 : dArray[2])));
    }

    public static void d(eY eY2, File file) {
        gS.a(eY2, Collections.emptyMap(), file);
    }

    public static void a(eY eY2, Map map, File file) {
        Object[] objectArray;
        Object object;
        Object object2;
        Object object3;
        Object object4;
        int n = eY2.J("BaseVersion");
        eV eV2 = eY2.d("Objects").bA();
        if (n < 3) {
            double[] dArray = gS.a(eY2, "Position");
            object4 = gS.a(eY2, "Forward");
            object3 = new gT(dArray, (double[])object4);
            int n2 = 0;
            while (n2 < eV2.size()) {
                object2 = eV2.V(n2);
                object = gS.a((eY)object2, "Position");
                objectArray = gS.a((eY)object2, "Up");
                double[] object5 = gS.a((eY)object2, "At");
                gS.a((eY)object2, "Position", ((gT)object3).d((double[])object));
                gS.a((eY)object2, "Up", ((gT)object3).d((double[])objectArray));
                gS.a((eY)object2, "At", ((gT)object3).d(object5));
                ++n2;
            }
        }
        int n3 = eY2.J("UserData");
        object4 = new SecretKeySpec(rS, "AES");
        object3 = new byte[16];
        new SecureRandom().nextBytes((byte[])object3);
        IvParameterSpec ivParameterSpec = new IvParameterSpec((byte[])object3);
        object2 = Cipher.getInstance("AES/CBC/PKCS5Padding");
        ((Cipher)object2).init(1, (Key)object4, ivParameterSpec);
        object = new FileOutputStream(file);
        try {
            ((OutputStream)object).write(lA);
            byte[] byArray = new byte[4];
            byArray[1] = 5;
            ((OutputStream)object).write(byArray);
            ((OutputStream)object).write((byte[])object3);
            object = new CipherOutputStream((OutputStream)object, (Cipher)object2);
            ((OutputStream)object).write(new byte[]{84, 82, 85, 69});
            hk.a((OutputStream)object, n3);
            objectArray = fj.b(eV2);
            hk.a((OutputStream)object, objectArray.length);
            ((OutputStream)object).write((byte[])objectArray);
            for (Map.Entry entry : map.entrySet()) {
                objectArray = ((String)entry.getKey()).getBytes();
                if (objectArray.length > 255) continue;
                ((OutputStream)object).write(objectArray.length);
                ((OutputStream)object).write((byte[])objectArray);
                objectArray = fj.j(entry.getValue());
                hk.a((OutputStream)object, objectArray.length);
                ((OutputStream)object).write((byte[])objectArray);
            }
            ((OutputStream)object).flush();
        }
        finally {
            ((OutputStream)object).close();
        }
    }

    public static void e(eY eY2, File file) {
        gS.b(eY2, Collections.emptyMap(), file);
    }

    public static void b(eY eY2, Map map, File file) {
        eV eV2;
        Object object;
        Object object2;
        int n;
        try (InputStream inputStream = new FileInputStream(file);){
            int n2;
            byte[] byArray = new byte[8];
            if (inputStream.read(byArray) != 8) {
                throw new IOException("short read");
            }
            if (byArray[0] != lA[0] || byArray[1] != lA[1] || byArray[2] != lA[2] || byArray[3] != lA[3]) {
                throw new IOException("invalid base file");
            }
            n = (byArray[4] & 0xFF) << 8 | byArray[5] & 0xFF;
            switch (n) {
                case 2: {
                    throw new IOException("unsupported base file");
                }
                case 3: 
                case 4: 
                case 5: {
                    break;
                }
                default: {
                    throw new IOException("invalid base file");
                }
            }
            byte[] byArray2 = new byte[16];
            if (inputStream.read(byArray2) != 16) {
                throw new IOException("short read");
            }
            SecretKeySpec secretKeySpec = new SecretKeySpec(rS, "AES");
            object2 = new IvParameterSpec(byArray2);
            object = Cipher.getInstance("AES/CBC/PKCS5Padding");
            ((Cipher)object).init(2, (Key)secretKeySpec, (AlgorithmParameterSpec)object2);
            inputStream = new CipherInputStream(inputStream, (Cipher)object);
            if (inputStream.read(byArray, 0, 4) != 4) {
                throw new IOException("short read");
            }
            if (byArray[0] != 84 || byArray[1] != 82 || byArray[2] != 85 || byArray[3] != 69) {
                throw new IOException("invalid base file");
            }
            if (n < 5) {
                int n3;
                n2 = inputStream.read();
                if (n2 < 0) {
                    throw new IOException("short read");
                }
                int n4 = inputStream.read();
                if (n4 < 0) {
                    throw new IOException("short read");
                }
                int n5 = inputStream.read();
                if (n5 < 0) {
                    throw new IOException("short read");
                }
                int n6 = inputStream.read();
                if (n6 < 0) {
                    throw new IOException("short read");
                }
                eY2.b("UserData", n2 << 24 | n4 << 16 | n5 << 8 | n6);
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                byte[] byArray3 = new byte[8096];
                while ((n3 = inputStream.read(byArray3)) >= 0) {
                    byteArrayOutputStream.write(byArray3, 0, n3);
                }
                eV2 = ff.c(byteArrayOutputStream.toByteArray());
            } else {
                eY2.b("UserData", hk.readInt(inputStream));
                n2 = hk.readInt(inputStream);
                byte[] byArray4 = new byte[n2];
                hk.readFully(inputStream, byArray4);
                eV2 = ff.c(byArray4);
                while ((n2 = inputStream.read()) >= 0) {
                    byArray4 = new byte[n2];
                    hk.readFully(inputStream, byArray4);
                    String string = new String(byArray4);
                    n2 = hk.readInt(inputStream);
                    byArray4 = new byte[n2];
                    hk.readFully(inputStream, byArray4);
                    Object object3 = ff.a(byArray4);
                    map.put(string, object3);
                }
            }
        }
        long l = eY2.K("LastUpdateTimestamp");
        int n7 = 0;
        while (n7 < eV2.size()) {
            object2 = eV2.V(n7);
            ((eY)object2).put("Timestamp", new Long(l));
            ++n7;
        }
        if (n == 3) {
            n7 = 0;
            while (n7 < eV2.size()) {
                object2 = eV2.V(n7);
                Object object4 = object = (Object)gS.a((eY)object2, "Position");
                object4[0] = object4[0] + 3.0;
                Object object5 = object;
                object5[2] = object5[2] + 3.0;
                gS.a((double[])object);
                gS.a((eY)object2, "Position", (double[])object);
                double[] dArray = gS.a((eY)object2, "Up");
                gS.a(dArray);
                gS.a((eY)object2, "Up", dArray);
                double[] dArray2 = gS.a((eY)object2, "At");
                gS.a(dArray2);
                gS.a((eY)object2, "At", dArray2);
                ++n7;
            }
            n7 = eY2.J("UserData");
            eV2.add(0, gS.a("^BASE_FLAG", l, n7, new double[]{0.0, 0.0, 0.0}, new double[]{0.0, 1.0, 0.0}, new double[]{0.0, 0.0, 1.0}));
            eV2.add(1, gS.a("^MAINROOM", l, n7, new double[]{-3.0, 0.0, 3.0}, new double[]{0.0, 1.0, 0.0}, new double[]{0.0, 0.0, -1.0}));
            eV2.add(2, gS.a("^TELEPORTER", l, n7, new double[]{0.0, 0.0, 6.0}, new double[]{0.0, 1.0, 0.0}, new double[]{-0.7071069478988647, 0.0, -0.7071067094802856}));
            eV2.add(3, gS.a("^BUILDDOOR", l, n7, new double[]{-9.005859375, 0.2421875, 2.98828125}, new double[]{0.0, 1.0, 0.0}, new double[]{-1.0, 0.0, 0.0}));
            eV2.add(4, gS.a("^BUILDRAMP", l, n7, new double[]{-10.724609375, 0.296875, 2.98828125}, new double[]{-0.2588191032409668, 0.965926f, 2.9802322387695312E-8}, new double[]{-0.9659258127212524, -0.2588191628456116, -3.2782554626464844E-7}));
            eV2.add(5, gS.a("^BUILDWINDOW", l, n7, new double[]{-7.248046875, 0.5, -1.25}, new double[]{0.0, 1.0, 0.0}, new double[]{-0.7071069478988647, 0.0, -0.7071067094802856}));
            eV2.add(6, gS.a("^BUILDWINDOW", l, n7, new double[]{-7.248046875, 0.5, 7.25}, new double[]{0.0, 1.0, 0.0}, new double[]{-0.7071069478988647, 0.0, 0.7071067094802856}));
            eV2.add(7, gS.a("^BUILDWINDOW", l, n7, new double[]{1.248046875, 0.5, -1.25}, new double[]{0.0, 1.0, 0.0}, new double[]{0.7071069478988647, 0.0, -0.7071067094802856}));
        }
        if (n < 5) {
            eY2.b("BaseVersion", 3);
        }
        eY2.b("Objects", eV2);
    }

    private static void a(double[] dArray) {
        double d = dArray[0];
        dArray[0] = -dArray[2];
        dArray[2] = d;
    }

    private static eY a(String string, long l, int n, double[] dArray, double[] dArray2, double[] dArray3) {
        eY eY2 = new eY();
        eY2.put("Timestamp", new Long(l));
        eY2.put("ObjectID", string);
        eY2.put("UserData", n);
        eY2.put("Position", new eV(new Double(dArray[0]), new Double(dArray[1]), new Double(dArray[2])));
        eY2.put("Up", new eV(new Double(dArray2[0]), new Double(dArray2[1]), new Double(dArray2[2])));
        eY2.put("At", new eV(new Double(dArray3[0]), new Double(dArray3[1]), new Double(dArray3[2])));
        eY2.put("Message", "");
        return eY2;
    }
}
