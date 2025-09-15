/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.InputStream;
import java.math.BigDecimal;
import java.nio.ByteBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CodingErrorAction;
import java.nio.charset.StandardCharsets;
import java.util.function.Predicate;
import nomanssave.eC;
import nomanssave.eG;
import nomanssave.eV;
import nomanssave.eX;
import nomanssave.eY;
import nomanssave.fg;
import nomanssave.fh;
import nomanssave.fk;

public class ff
implements Closeable {
    public static final int kO = 1;
    public static final int kP = 2;
    public static final int kQ = 4;
    private final InputStream in;
    private final int flags;
    private int kR;
    private final CharsetDecoder kS;

    public static Object a(byte[] byArray) {
        Throwable throwable = null;
        Object var2_3 = null;
        try (ff ff2 = new ff(new ByteArrayInputStream(byArray), 0);){
            return ff2.bJ();
        }
        catch (Throwable throwable2) {
            if (throwable == null) {
                throwable = throwable2;
            } else if (throwable != throwable2) {
                throwable.addSuppressed(throwable2);
            }
            throw throwable;
        }
    }

    public static eY b(byte[] byArray) {
        Throwable throwable = null;
        Object var2_3 = null;
        try (ff ff2 = new ff(new ByteArrayInputStream(byArray), 0);){
            return ff2.bK();
        }
        catch (Throwable throwable2) {
            if (throwable == null) {
                throwable = throwable2;
            } else if (throwable != throwable2) {
                throwable.addSuppressed(throwable2);
            }
            throw throwable;
        }
    }

    public static eV c(byte[] byArray) {
        Throwable throwable = null;
        Object var2_3 = null;
        try (ff ff2 = new ff(new ByteArrayInputStream(byArray), 0);){
            return ff2.bL();
        }
        catch (Throwable throwable2) {
            if (throwable == null) {
                throwable = throwable2;
            } else if (throwable != throwable2) {
                throwable.addSuppressed(throwable2);
            }
            throw throwable;
        }
    }

    public ff(InputStream inputStream) {
        this(inputStream, 0);
    }

    public ff(InputStream inputStream, int n) {
        this.in = inputStream;
        this.flags = n;
        this.kR = -1;
        this.kS = StandardCharsets.UTF_8.newDecoder().onMalformedInput(CodingErrorAction.REPORT).onUnmappableCharacter(CodingErrorAction.REPORT);
    }

    private int read() {
        if (this.kR >= 0) {
            int n = this.kR;
            this.kR = -1;
            return n;
        }
        return this.in.read();
    }

    private int a(Predicate predicate) {
        if (this.kR < 0) {
            this.kR = this.in.read();
        }
        if (this.kR >= 0 && predicate.test(this.kR)) {
            int n = this.kR;
            this.kR = -1;
            return n;
        }
        return -1;
    }

    private int bI() {
        if ((this.flags & 1) != 0) {
            return this.read();
        }
        if (this.kR < 0) {
            this.kR = this.in.read();
        }
        while (this.kR == 32 || this.kR == 13 || this.kR == 10 || this.kR == 9) {
            this.kR = this.in.read();
        }
        if (this.kR >= 0) {
            int n = this.kR;
            this.kR = -1;
            return n;
        }
        return -1;
    }

    @Override
    public void close() {
        try {
            if (this.kR < 0) {
                this.kR = this.in.read();
            }
            if ((this.flags & 1) == 0) {
                while (this.kR == 32 || this.kR == 13 || this.kR == 10 || this.kR == 9) {
                    this.kR = this.in.read();
                }
            }
            if ((this.flags & 2) != 0) {
                if (this.kR != 0) {
                    throw new eX("Missing null terminator");
                }
                this.kR = -1;
            }
            if (this.kR >= 0) {
                throw new eX("Unexpected termination: " + this.kR);
            }
        }
        finally {
            if ((this.flags & 4) == 0) {
                this.in.close();
            }
        }
    }

    public Object bJ() {
        return this.a(this.bI(), null);
    }

    public eY bK() {
        int n = this.bI();
        if (n < 0) {
            throw new eX("Short read");
        }
        if (n != 123) {
            throw new eX("Unexpected token");
        }
        return this.a((eC)null);
    }

    /*
     * Enabled aggressive block sorting
     */
    public eY a(eG eG2) {
        eY eY3;
        block11: {
            int n = this.bI();
            if (n < 0) {
                throw new eX("Short read");
            }
            if (n != 123) {
                throw new eX("Unexpected token");
            }
            eY3 = null;
            eC eC2 = null;
            int n2 = this.bI();
            if (n2 != 34) {
                if (n2 != 125) {
                    throw new eX("Invalid token");
                }
            } else {
                do {
                    String string = this.bN();
                    if (eY3 == null) {
                        eY3 = eG2 != null && (eC2 = eC.a(eG2, string)) != null ? new fk(eC2) : new eY();
                    }
                    if (eC2 != null) {
                        string = eC2.q(string);
                    }
                    if (this.bI() != 58) {
                        throw new eX("Invalid token");
                    }
                    Object object = this.a(this.bI(), eC2);
                    eY3.a(string, object);
                    n2 = this.bI();
                    if (n2 == 125) break block11;
                    if (n2 == 44) continue;
                    throw new eX("Invalid token");
                } while ((n2 = this.bI()) == 34);
                throw new eX("Invalid token");
            }
        }
        if (eY3 == null) {
            eY3 = new eY();
        }
        if (eY3.H("PlayerStateData") == null) {
            eY3.b("PlayerStateData", eY2 -> {
                String string = eY2.getValueAsString("ActiveContext");
                if ("Main".equals(string) && eY2.H("BaseContext.PlayerStateData") != null) {
                    return "BaseContext.PlayerStateData";
                }
                if ("Season".equals(string) && eY2.H("ExpeditionContext.PlayerStateData") != null) {
                    return "ExpeditionContext.PlayerStateData";
                }
                return "PlayerStateData";
            });
        }
        return eY3;
    }

    public eV bL() {
        int n = this.bI();
        if (n < 0) {
            throw new eX("Short read");
        }
        if (n != 91) {
            throw new eX("Unexpected token");
        }
        return this.b(null);
    }

    private Object a(int n, eC eC2) {
        if (n < 0) {
            throw new eX("Short read");
        }
        if (n == 123) {
            return this.a(eC2);
        }
        if (n == 91) {
            return this.b(eC2);
        }
        if (n == 34) {
            return this.bO();
        }
        if (n == 116) {
            if (this.read() != 114) {
                throw new eX("Invalid token");
            }
            if (this.read() != 117) {
                throw new eX("Invalid token");
            }
            if (this.read() != 101) {
                throw new eX("Invalid token");
            }
            return Boolean.TRUE;
        }
        if (n == 102) {
            if (this.read() != 97) {
                throw new eX("Invalid token");
            }
            if (this.read() != 108) {
                throw new eX("Invalid token");
            }
            if (this.read() != 115) {
                throw new eX("Invalid token");
            }
            if (this.read() != 101) {
                throw new eX("Invalid token");
            }
            return Boolean.FALSE;
        }
        if (n == 110) {
            if (this.read() != 117) {
                throw new eX("Invalid token");
            }
            if (this.read() != 108) {
                throw new eX("Invalid token");
            }
            if (this.read() != 108) {
                throw new eX("Invalid token");
            }
            return null;
        }
        if (n == 45 || n >= 48 && n <= 57) {
            return this.ad(n);
        }
        throw new eX("Invalid token");
    }

    private Number ad(int n) {
        int n2;
        boolean bl = false;
        if (n == 45) {
            n = this.a(fh.kZ);
            if (n < 0) {
                throw new eX("Invalid token");
            }
            bl = true;
        }
        BigDecimal bigDecimal = new BigDecimal(n - 48);
        if (n != 48) {
            while ((n = this.a(fh.kZ)) >= 0) {
                bigDecimal = bigDecimal.multiply(BigDecimal.TEN).add(new BigDecimal(n - 48));
            }
        }
        boolean bl2 = true;
        if (this.a(fh.la) >= 0) {
            bl2 = false;
            n = this.a(fh.kZ);
            if (n < 0) {
                throw new eX("Invalid token");
            }
            n2 = 0;
            do {
                bigDecimal = bigDecimal.add(new BigDecimal(n - 48).scaleByPowerOfTen(--n2));
            } while ((n = this.a(fh.kZ)) >= 0);
        }
        if (this.a(fh.lb) >= 0) {
            bl2 = false;
            n = this.a(fh.lc);
            n2 = 0;
            if (n == 43 || n == 45) {
                n2 = n == 45 ? 1 : 0;
                n = this.a(fh.kZ);
            }
            if (n < 0) {
                throw new eX("Invalid token");
            }
            int n3 = 0;
            do {
                n3 *= 10;
                n3 += n - 48;
            } while ((n = this.a(fh.kZ)) >= 0);
            if (n2 != 0) {
                n3 = -n3;
            }
            bigDecimal = bigDecimal.scaleByPowerOfTen(n3);
        }
        if (bl) {
            bigDecimal = bigDecimal.negate();
        }
        if (bl2) {
            try {
                return bigDecimal.intValueExact();
            }
            catch (ArithmeticException arithmeticException) {
                try {
                    return bigDecimal.longValueExact();
                }
                catch (ArithmeticException arithmeticException2) {
                    // empty catch block
                }
            }
        }
        return bigDecimal;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private eY a(eC eC2) {
        eY eY2 = new eY();
        int n = this.bI();
        if (n == 34) {
            do {
                String string = this.bN();
                if (eC2 != null) {
                    string = eC2.q(string);
                }
                if (this.bI() != 58) {
                    throw new eX("Invalid token");
                }
                Object object = this.a(this.bI(), eC2);
                eY2.a(string, object);
                n = this.bI();
                if (n == 125) return eY2;
                if (n == 44) continue;
                throw new eX("Invalid token");
            } while ((n = this.bI()) == 34);
            throw new eX("Invalid token");
        }
        if (n == 125) return eY2;
        throw new eX("Invalid token");
    }

    private eV b(eC eC2) {
        eV eV2 = new eV();
        int n = this.bI();
        if (n != 93) {
            while (true) {
                Object object = this.a(n, eC2);
                eV2.e(object);
                n = this.bI();
                if (n == 93) break;
                if (n != 44) {
                    throw new eX("Invalid token");
                }
                n = this.bI();
            }
        }
        return eV2;
    }

    private byte[] bM() {
        int n;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        while ((n = this.read()) != 34) {
            if (n < 0) {
                throw new eX("Short read");
            }
            if (n == 92) {
                n = this.read();
                if (n < 0) {
                    throw new eX("Short read");
                }
                switch (n) {
                    case 114: {
                        n = 13;
                        break;
                    }
                    case 110: {
                        n = 10;
                        break;
                    }
                    case 116: {
                        n = 9;
                        break;
                    }
                    case 102: {
                        n = 12;
                        break;
                    }
                    case 98: {
                        n = 8;
                        break;
                    }
                    case 117: {
                        n = fh.ae(this.read()) << 12 | fh.ae(this.read()) << 8 | fh.ae(this.read()) << 4 | fh.ae(this.read());
                        if (n <= 255) break;
                        throw new eX("Unexpected unicode escape: " + n);
                    }
                }
            }
            byteArrayOutputStream.write(n);
        }
        return byteArrayOutputStream.toByteArray();
    }

    private String bN() {
        byte[] byArray = this.bM();
        try {
            return this.kS.decode(ByteBuffer.wrap(byArray)).toString();
        }
        catch (CharacterCodingException characterCodingException) {
            throw new eX("Invalid string");
        }
    }

    private Object bO() {
        byte[] byArray = this.bM();
        try {
            return this.kS.decode(ByteBuffer.wrap(byArray)).toString();
        }
        catch (CharacterCodingException characterCodingException) {
            return new fg(byArray);
        }
    }
}
