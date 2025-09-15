/*
 * Decompiled with CFR 0.152.
 */
package com.formdev.flatlaf.ui;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(value={ElementType.FIELD})
@Retention(value=RetentionPolicy.RUNTIME)
public static @interface FlatStylingSupport.Styleable {
    public boolean dot() default false;

    public Class<?> type() default Void.class;
}
