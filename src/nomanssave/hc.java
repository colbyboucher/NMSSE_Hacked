/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.LogRecord;
import java.util.logging.Logger;
import nomanssave.hd;
import nomanssave.he;

public class hc {
    private static final Handler sn = new hd();
    private static final PrintStream so;
    private static final PrintStream sp;
    private static PrintStream sq;
    private static int sr;

    static {
        Logger logger = LogManager.getLogManager().getLogger("");
        Handler[] handlerArray = logger.getHandlers();
        int n = 0;
        while (n < handlerArray.length) {
            logger.removeHandler(handlerArray[0]);
            ++n;
        }
        logger.setLevel(Level.ALL);
        logger.addHandler(sn);
        hc.em();
        so = System.out;
        sp = System.err;
        sr = Level.INFO.intValue();
    }

    private static void em() {
        try {
            Class<?> clazz = Class.forName("sun.misc.Unsafe");
            Field field = clazz.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            Object object = field.get(null);
            Method method = clazz.getDeclaredMethod("putObjectVolatile", Object.class, Long.TYPE, Object.class);
            Method method2 = clazz.getDeclaredMethod("staticFieldOffset", Field.class);
            Class<?> clazz2 = Class.forName("jdk.internal.module.IllegalAccessLogger");
            Field field2 = clazz2.getDeclaredField("logger");
            Long l = (Long)method2.invoke(object, field2);
            method.invoke(object, clazz2, l, null);
        }
        catch (Throwable throwable) {
            // empty catch block
        }
    }

    public static void k(File file) {
        FileOutputStream fileOutputStream;
        try {
            fileOutputStream = new FileOutputStream(file);
            Runtime.getRuntime().addShutdownHook(new Thread(() -> hc.close()));
            System.setOut(new PrintStream(new he(so, "[STDOUT] ")));
            System.setErr(new PrintStream(new he(sp, "[STDERR] ")));
        }
        catch (FileNotFoundException fileNotFoundException) {
            fileOutputStream = null;
        }
        sq = fileOutputStream == null ? null : new PrintStream(fileOutputStream, true);
    }

    public static void aA(String string) {
        try {
            Level level = Level.parse(string);
            sr = level.intValue();
            hc.info("Set LogLevel: " + string);
        }
        catch (IllegalArgumentException illegalArgumentException) {
            hc.warn("Invalid LogLevel: " + string);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void debug(String string) {
        if (sq != null) {
            PrintStream printStream = sq;
            synchronized (printStream) {
                sq.println("[DEBUG] " + string.trim());
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void debug(String string, Throwable throwable) {
        if (sq != null) {
            PrintStream printStream = sq;
            synchronized (printStream) {
                sq.println("[DEBUG] " + string.trim());
                if (throwable != null) {
                    sq.print("[DEBUG] ");
                    throwable.printStackTrace(sq);
                }
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void info(String string) {
        so.println(string);
        if (sq != null) {
            PrintStream printStream = sq;
            synchronized (printStream) {
                sq.println("[INFO] " + string.trim());
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void info(String string, Throwable throwable) {
        so.println(string);
        if (sq != null) {
            PrintStream printStream = sq;
            synchronized (printStream) {
                sq.println("[INFO] " + string.trim());
                if (throwable != null) {
                    sq.print("[INFO] ");
                    throwable.printStackTrace(sq);
                }
            }
        }
    }

    private static String d(String string, String string2) {
        int n = 0;
        while (n < string.length()) {
            if (!Character.isWhitespace(string.charAt(n))) {
                return String.valueOf(string.substring(0, n)) + string2 + string.substring(n);
            }
            ++n;
        }
        return "";
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void warn(String string) {
        so.println(hc.d(string, "WARNING: "));
        if (sq != null) {
            PrintStream printStream = sq;
            synchronized (printStream) {
                sq.println("[WARNING] " + string.trim());
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void a(String string, Throwable throwable) {
        so.println(hc.d(string, "WARNING: "));
        if (sq != null) {
            PrintStream printStream = sq;
            synchronized (printStream) {
                sq.println("[WARNING] " + string.trim());
                if (throwable != null) {
                    sq.print("[WARNING] ");
                    throwable.printStackTrace(sq);
                }
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void error(String string, Throwable throwable) {
        sp.println(hc.d(string, "ERROR: "));
        if (sq != null) {
            PrintStream printStream = sq;
            synchronized (printStream) {
                sq.println("[ERROR] " + string.trim());
                if (throwable != null) {
                    sq.print("[ERROR] ");
                    throwable.printStackTrace(sq);
                }
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private static void log(LogRecord logRecord) {
        PrintStream printStream;
        String string;
        Level level = logRecord.getLevel();
        if (level.intValue() < sr) {
            return;
        }
        String string2 = logRecord.getLoggerName();
        string2 = string2 == null ? "" : String.valueOf(string2) + ": ";
        string2 = String.valueOf(string2) + logRecord.getMessage();
        if (level.intValue() >= Level.SEVERE.intValue()) {
            string = "SEVERE";
            printStream = sp;
        } else if (level.intValue() >= Level.WARNING.intValue()) {
            string = "WARNING";
            printStream = sp;
        } else if (level.intValue() >= Level.INFO.intValue()) {
            string = "INFO";
            printStream = so;
        } else if (level.intValue() >= Level.CONFIG.intValue()) {
            string = "CONFIG";
            printStream = so;
        } else if (level.intValue() >= Level.FINE.intValue()) {
            string = "FINE";
            printStream = so;
        } else if (level.intValue() >= Level.FINER.intValue()) {
            string = "FINER";
            printStream = so;
        } else if (level.intValue() >= Level.FINEST.intValue()) {
            string = "FINEST";
            printStream = so;
        } else {
            string = "DEBUG";
            printStream = so;
        }
        if (level.intValue() >= Level.INFO.intValue()) {
            printStream.println(hc.d(string2, String.valueOf(string) + ": "));
        }
        if (sq != null) {
            PrintStream printStream2 = sq;
            synchronized (printStream2) {
                sq.println("[" + string + "] " + string2.trim());
                if (logRecord.getThrown() != null) {
                    sq.print("[" + string + "] ");
                    logRecord.getThrown().printStackTrace(sq);
                }
            }
        }
    }

    private static void close() {
        sq.close();
    }

    static /* synthetic */ void a(LogRecord logRecord) {
        hc.log(logRecord);
    }

    static /* synthetic */ PrintStream en() {
        return sq;
    }
}
