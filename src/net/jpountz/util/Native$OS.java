/*
 * Decompiled with CFR 0.152.
 */
package net.jpountz.util;

private static enum Native.OS {
    WINDOWS("win32", "so"),
    LINUX("linux", "so"),
    MAC("darwin", "dylib"),
    SOLARIS("solaris", "so");

    public final String name;
    public final String libExtension;

    private Native.OS(String name, String libExtension) {
        this.name = name;
        this.libExtension = libExtension;
    }
}
