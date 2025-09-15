/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import nomanssave.eC;
import nomanssave.eV;
import nomanssave.eY;
import nomanssave.fg;
import nomanssave.fh;
import nomanssave.fk;

public class fj
implements Closeable {
    public static final int kP = 2;
    public static final int kQ = 8;
    private static final byte[] le = "null".getBytes();
    private static final byte[] lf = "true".getBytes();
    private static final byte[] lg = "false".getBytes();
    private final OutputStream lh;
    private final int flags;

    public static byte[] j(Object object) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        Throwable throwable = null;
        Object var3_4 = null;
        try (fj fj2 = new fj(byteArrayOutputStream, 0);){
            fj2.k(object);
        }
        catch (Throwable throwable2) {
            if (throwable == null) {
                throwable = throwable2;
            } else if (throwable != throwable2) {
                throwable.addSuppressed(throwable2);
            }
            throw throwable;
        }
        return byteArrayOutputStream.toByteArray();
    }

    public static byte[] g(eY eY2) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        Throwable throwable = null;
        Object var3_4 = null;
        try (fj fj2 = new fj(byteArrayOutputStream, 0);){
            fj2.h(eY2);
        }
        catch (Throwable throwable2) {
            if (throwable == null) {
                throwable = throwable2;
            } else if (throwable != throwable2) {
                throwable.addSuppressed(throwable2);
            }
            throw throwable;
        }
        return byteArrayOutputStream.toByteArray();
    }

    public static byte[] b(eV eV2) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        Throwable throwable = null;
        Object var3_4 = null;
        try (fj fj2 = new fj(byteArrayOutputStream, 0);){
            fj2.c(eV2);
        }
        catch (Throwable throwable2) {
            if (throwable == null) {
                throwable = throwable2;
            } else if (throwable != throwable2) {
                throwable.addSuppressed(throwable2);
            }
            throw throwable;
        }
        return byteArrayOutputStream.toByteArray();
    }

    public fj(OutputStream outputStream) {
        this(outputStream, 0);
    }

    public fj(OutputStream outputStream, int n) {
        this.lh = outputStream;
        this.flags = n;
    }

    public void k(Object object) {
        if (object == null) {
            this.lh.write(le);
        } else if (object.equals(Boolean.TRUE)) {
            this.lh.write(lf);
        } else if (object.equals(Boolean.FALSE)) {
            this.lh.write(lg);
        } else if (object instanceof String) {
            this.writeString((String)object);
        } else if (object instanceof fg) {
            this.c((fg)object);
        } else if (object instanceof fk) {
            this.a((eY)object, ((fk)object).li);
        } else if (object instanceof eY) {
            this.a((eY)object, null);
        } else if (object instanceof eV) {
            this.a((eV)object, null);
        } else if (object instanceof Number) {
            this.a((Number)object);
        } else {
            throw new IOException("Cannot write value");
        }
    }

    private void a(Object object, eC eC2) {
        if (object == null) {
            this.lh.write(le);
        } else if (object.equals(Boolean.TRUE)) {
            this.lh.write(lf);
        } else if (object.equals(Boolean.FALSE)) {
            this.lh.write(lg);
        } else if (object instanceof String) {
            this.writeString((String)object);
        } else if (object instanceof fg) {
            this.c((fg)object);
        } else if (object instanceof eY) {
            this.a((eY)object, eC2);
        } else if (object instanceof eV) {
            this.a((eV)object, eC2);
        } else if (object instanceof Number) {
            this.a((Number)object);
        } else {
            throw new IOException("Cannot write value");
        }
    }

    private void writeString(String string) {
        this.lh.write(fh.O(string).getBytes(StandardCharsets.UTF_8));
    }

    private void c(fg fg2) {
        this.lh.write(34);
        byte[] byArray = fg2.toByteArray();
        int n = byArray.length;
        int n2 = 0;
        while (n2 < n) {
            byte by = byArray[n2];
            int n3 = by & 0xFF;
            if (n3 == 13) {
                this.lh.write("\\r".getBytes(StandardCharsets.UTF_8));
            } else if (n3 == 10) {
                this.lh.write("\\n".getBytes(StandardCharsets.UTF_8));
            } else if (n3 == 9) {
                this.lh.write("\\t".getBytes(StandardCharsets.UTF_8));
            } else if (n3 == 12) {
                this.lh.write("\\f".getBytes(StandardCharsets.UTF_8));
            } else if (n3 == 8) {
                this.lh.write("\\b".getBytes(StandardCharsets.UTF_8));
            } else if (n3 == 34) {
                this.lh.write("\\\"".getBytes(StandardCharsets.UTF_8));
            } else if (n3 == 92) {
                this.lh.write("\\\\".getBytes(StandardCharsets.UTF_8));
            } else if (n3 >= 32) {
                this.lh.write(n3);
            } else {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("\\u00");
                stringBuffer.append("0123456789ABCDEFabcdef".charAt(n3 >> 4 & 0xF));
                stringBuffer.append("0123456789ABCDEFabcdef".charAt(n3 & 0xF));
                this.lh.write(stringBuffer.toString().getBytes(StandardCharsets.UTF_8));
            }
            ++n2;
        }
        this.lh.write(34);
    }

    public void h(eY eY2) {
        this.a(eY2, eY2 instanceof fk ? ((fk)eY2).li : null);
    }

    private void a(eY eY2, eC eC2) {
        this.lh.write(123);
        if (eY2.length > 0) {
            int n = 0;
            while (n < eY2.length) {
                if (n > 0) {
                    this.lh.write(44);
                }
                this.writeString(eC2 == null ? eY2.names[n] : eC2.r(eY2.names[n]));
                this.lh.write(58);
                this.a(eY2.values[n], eC2);
                ++n;
            }
        }
        this.lh.write(125);
    }

    public void c(eV eV2) {
        this.a(eV2, null);
    }

    private void a(eV eV2, eC eC2) {
        this.lh.write(91);
        if (eV2.length > 0) {
            int n = 0;
            while (n < eV2.length) {
                if (n > 0) {
                    this.lh.write(44);
                }
                this.a(eV2.values[n], eC2);
                ++n;
            }
        }
        this.lh.write(93);
    }

    private void a(Number number) {
        if (number instanceof BigDecimal) {
            this.lh.write(((BigDecimal)number).toString().replace('E', 'e').getBytes(StandardCharsets.UTF_8));
        } else {
            this.lh.write(number.toString().getBytes(StandardCharsets.UTF_8));
        }
    }

    @Override
    public void close() {
        try {
            if ((this.flags & 2) != 0) {
                this.lh.write(0);
            }
        }
        finally {
            if ((this.flags & 8) == 0) {
                this.lh.close();
            }
        }
    }
}
