/*
 * Decompiled with CFR 0.152.
 */
package net.jpountz.util;

import java.io.File;
import java.io.FilenameFilter;

static final class Native.1
implements FilenameFilter {
    private final String searchPattern = "liblz4-java-";

    Native.1() {
    }

    @Override
    public boolean accept(File dir, String name) {
        return name.startsWith("liblz4-java-") && !name.endsWith(".lck");
    }
}
