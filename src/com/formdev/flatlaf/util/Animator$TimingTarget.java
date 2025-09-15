/*
 * Decompiled with CFR 0.152.
 */
package com.formdev.flatlaf.util;

@FunctionalInterface
public static interface Animator.TimingTarget {
    public void timingEvent(float var1);

    default public void begin() {
    }

    default public void end() {
    }
}
