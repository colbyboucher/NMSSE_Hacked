/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import nomanssave.cy;
import nomanssave.eV;
import nomanssave.eY;
import nomanssave.fh;

class cJ {
    final cJ gi;
    final int gj;
    final String name;
    Object value;
    final /* synthetic */ cy gg;

    cJ(cy cy2, cJ cJ2, int n, String string, Object object) {
        this.gg = cy2;
        this.gi = cJ2;
        this.value = object;
        this.name = string;
        this.gj = n;
    }

    boolean isLeaf() {
        if (this.value == null) {
            return true;
        }
        if (this.value instanceof eY) {
            return false;
        }
        return !(this.value instanceof eV);
    }

    int getChildCount() {
        if (this.value == null) {
            return 0;
        }
        if (this.value instanceof eY) {
            return ((eY)this.value).names().size();
        }
        if (this.value instanceof eV) {
            return ((eV)this.value).size();
        }
        return 0;
    }

    Object x(int n) {
        if (this.value == null) {
            throw new RuntimeException("No children for null");
        }
        if (this.value instanceof eY) {
            String string = (String)((eY)this.value).names().get(n);
            Object object = ((eY)this.value).getValue(string);
            return new cJ(this.gg, this, n, string, object);
        }
        if (this.value instanceof eV) {
            Object object = ((eV)this.value).getValue(n);
            return new cJ(this.gg, this, n, "[" + n + "]", object);
        }
        throw new RuntimeException("No children for " + this.value.getClass().getName());
    }

    int indexOf(Object object) {
        if (object instanceof cJ && ((cJ)object).gi == this) {
            return ((cJ)object).gj;
        }
        return -1;
    }

    public String toString() {
        return this.name;
    }

    public String getText() {
        return fh.a(this.value, 1, c -> c.charValue() < '\u0080');
    }

    public void setText(String string) {
        if (this.gi == null) {
            this.value = eY.E(string);
            cy.b(this.gg).d((eY)this.value);
        } else {
            this.value = fh.P(string);
            if (this.gi.value instanceof eY) {
                ((eY)this.gi.value).b(this.name, this.value);
            } else if (this.gi.value instanceof eV) {
                ((eV)this.gi.value).a(this.gj, this.value);
            }
        }
        cy.a(this.gg, false);
        cy.b(this.gg, true);
    }

    public void remove() {
        if (this.gi == null) {
            throw new RuntimeException("Cannot remove root node");
        }
        this.value = null;
        if (this.gi.value instanceof eY) {
            ((eY)this.gi.value).N(this.name);
        } else if (this.gi.value instanceof eV) {
            ((eV)this.gi.value).ac(this.gj);
        }
        cy.a(this.gg, false);
        cy.b(this.gg, true);
    }
}
