/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import java.util.ArrayList;
import javax.swing.event.TreeModelEvent;
import javax.swing.event.TreeModelListener;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;
import nomanssave.cJ;
import nomanssave.cy;

class cI
implements TreeModel {
    private ArrayList gh = new ArrayList();
    final /* synthetic */ cy gg;

    private cI(cy cy2) {
        this.gg = cy2;
    }

    @Override
    public Object getRoot() {
        return new cJ(this.gg, null, 0, cy.a(this.gg), cy.b(this.gg));
    }

    @Override
    public Object getChild(Object object, int n) {
        return ((cJ)object).x(n);
    }

    @Override
    public int getChildCount(Object object) {
        return ((cJ)object).getChildCount();
    }

    @Override
    public boolean isLeaf(Object object) {
        return ((cJ)object).isLeaf();
    }

    @Override
    public void valueForPathChanged(TreePath treePath, Object object) {
    }

    @Override
    public int getIndexOfChild(Object object, Object object2) {
        return ((cJ)object).indexOf(object2);
    }

    @Override
    public void addTreeModelListener(TreeModelListener treeModelListener) {
        this.gh.add(treeModelListener);
    }

    @Override
    public void removeTreeModelListener(TreeModelListener treeModelListener) {
        this.gh.remove(treeModelListener);
    }

    public void a(cJ cJ2) {
        ArrayList<cJ> arrayList = new ArrayList<cJ>();
        arrayList.add(cJ2);
        while ((cJ2 = cJ2.gi) != null) {
            arrayList.add(0, cJ2);
        }
        TreeModelEvent treeModelEvent = new TreeModelEvent((Object)this, arrayList.toArray());
        for (TreeModelListener treeModelListener : this.gh) {
            treeModelListener.treeStructureChanged(treeModelEvent);
        }
    }

    /* synthetic */ cI(cy cy2, cI cI2) {
        this(cy2);
    }
}
