/*
 * Decompiled with CFR 0.152.
 */
package com.formdev.flatlaf.ui;

public static class FlatStylingSupport.UnknownStyleException
extends IllegalArgumentException {
    public FlatStylingSupport.UnknownStyleException(String key) {
        super(key);
    }

    @Override
    public String getMessage() {
        return "unknown style '" + super.getMessage() + "'";
    }
}
