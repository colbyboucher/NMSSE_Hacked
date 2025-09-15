/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import nomanssave.aH;
import nomanssave.cy;

class cz
extends ComponentAdapter {
    final /* synthetic */ cy gg;

    cz(cy cy2) {
        this.gg = cy2;
    }

    @Override
    public void componentMoved(ComponentEvent componentEvent) {
        Point point = this.gg.getBounds().getLocation();
        aH.b("JSONEditor.X", point.x);
        aH.b("JSONEditor.Y", point.y);
    }

    @Override
    public void componentResized(ComponentEvent componentEvent) {
        Dimension dimension = this.gg.getBounds().getSize();
        aH.b("JSONEditor.Width", dimension.width);
        aH.b("JSONEditor.Height", dimension.height);
    }
}
