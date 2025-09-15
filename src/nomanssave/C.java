/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import nomanssave.Application;
import nomanssave.aH;

class C
extends ComponentAdapter {
    final /* synthetic */ Application aZ;

    C(Application application) {
        this.aZ = application;
    }

    @Override
    public void componentMoved(ComponentEvent componentEvent) {
        Point point = Application.h(this.aZ).getBounds().getLocation();
        aH.b("MainFrame.X", point.x);
        aH.b("MainFrame.Y", point.y);
    }

    @Override
    public void componentResized(ComponentEvent componentEvent) {
        Dimension dimension = Application.h(this.aZ).getBounds().getSize();
        aH.b("MainFrame.Width", dimension.width);
        aH.b("MainFrame.Height", dimension.height);
    }
}
