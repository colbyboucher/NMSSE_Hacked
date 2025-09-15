/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import java.util.logging.Handler;
import java.util.logging.LogRecord;
import nomanssave.hc;

class hd
extends Handler {
    hd() {
    }

    @Override
    public void publish(LogRecord logRecord) {
        hc.a(logRecord);
    }

    @Override
    public void flush() {
    }

    @Override
    public void close() {
    }
}
