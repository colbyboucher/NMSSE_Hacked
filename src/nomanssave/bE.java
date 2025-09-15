/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import java.awt.Component;
import java.awt.GridLayout;
import javax.swing.JPanel;
import nomanssave.Application;
import nomanssave.bF;
import nomanssave.bG;
import nomanssave.bH;
import nomanssave.bI;
import nomanssave.bJ;
import nomanssave.bL;
import nomanssave.bN;
import nomanssave.gs;
import nomanssave.gz;

public class bE
extends JPanel {
    private static final int ew = 0;
    private static final int TYPE_DOUBLE = 1;
    private final bN[] ex = new bN[3];
    private gz cp;

    bE(Application application) {
        GridLayout gridLayout = new GridLayout(1, 3, 10, 0);
        this.setLayout(gridLayout);
        this.ex[0] = new bN(this);
        this.add(this.ex[0]);
        this.ex[1] = new bN(this);
        this.add(this.ex[1]);
        this.ex[2] = new bN(this);
        this.add(this.ex[2]);
        this.ex[0].a("Milestones", Application.a("UI-MILESTONES.PNG", 32, 32));
        this.ex[0].a("On Foot Exploration", gs.pN);
        this.ex[0].a("Alien Colonist Encounters", gs.pO);
        this.ex[0].a("Words Collected", gs.pP, false, "See Discovery tab for more details");
        this.ex[0].a("Most Units Accrued", gs.pQ);
        this.ex[0].a("Ships Destroyed", gs.pR, false, "See Kills section for more details");
        this.ex[0].a("Sentinels Destroyed", gs.pS, false, "See Kills section for more details");
        this.ex[0].a("Extreme Survival", new bF(this));
        this.ex[0].a("Space Exploration (Warps)", gs.pT);
        this.ex[0].a("Planet Zoology Scanned", gs.pU);
        this.ex[0].a("Kills", Application.a("UI-CREATURES.PNG", 32, 32));
        this.ex[0].a("Predators", gs.pH);
        this.ex[0].a("Sentinel Drones", gs.pI);
        this.ex[0].a("Sentinel Quads", gs.pK);
        this.ex[0].a("Sentinel Walkers", gs.pJ);
        this.ex[0].a("Pirates", gs.pL);
        this.ex[0].a("Police", gs.pM);
        this.ex[1].a("Gek", Application.a("UI-GEK.PNG", 32, 32));
        this.ex[1].a("Standing", gs.pq);
        this.ex[1].a("Missions Completed", gs.pr);
        this.ex[1].a("Words Learned", new bG(this), false, "See Discovery tab for more details");
        this.ex[1].a("Systems Visited", gs.ps);
        this.ex[1].a("Vy'keen", Application.a("UI-VYKEEN.PNG", 32, 32));
        this.ex[1].a("Standing", gs.pw);
        this.ex[1].a("Missions Completed", gs.px);
        this.ex[1].a("Words Learned", new bH(this), false, "See Discovery tab for more details");
        this.ex[1].a("Systems Visited", gs.py);
        this.ex[1].a("Korvax", Application.a("UI-KORVAX.PNG", 32, 32));
        this.ex[1].a("Standing", gs.pB);
        this.ex[1].a("Missions Completed", gs.pC);
        this.ex[1].a("Words Learned", new bI(this), false, "See Discovery tab for more details");
        this.ex[1].a("Systems Visited", gs.pD);
        this.ex[2].a("Traders", Application.a("UI-TRADERS.PNG", 32, 32));
        this.ex[2].a("Standing", gs.pt);
        this.ex[2].a("Missions Completed", gs.pu);
        this.ex[2].a("Plants Farmed", gs.pv);
        this.ex[2].a("Units Earned", gs.pQ, false, "See Milestones section for more details");
        this.ex[2].a("Warriors", Application.a("UI-WARRIORS.PNG", 32, 32));
        this.ex[2].a("Standing", gs.pz);
        this.ex[2].a("Missions Completed", gs.pA);
        this.ex[2].a("Sentinels Destroyed", gs.pS, false, "See Kills section for more details");
        this.ex[2].a("Pirates Killed", gs.pR, false, "See Kills section for more details");
        this.ex[2].a("Explorers", Application.a("UI-EXPLORERS.PNG", 32, 32));
        this.ex[2].a("Standing", gs.pE);
        this.ex[2].a("Missions Completed", gs.pF);
        this.ex[2].a("Rare Creatures Scanned", gs.pG);
        this.ex[2].a("Distance Warped", gs.pT, false, "See Milestones section for more details");
    }

    void B() {
        int n = this.cp.bx();
        this.cp.a(gs.pP, n);
        this.a(gs.pP, Integer.toString(n));
    }

    void C() {
        long l = this.cp.dJ();
        int n = this.cp.a(gs.pQ);
        if ((long)n < l) {
            n = (int)Math.min(l, Integer.MAX_VALUE);
            this.cp.a(gs.pQ, n);
            this.a(gs.pQ, Integer.toString(n));
        }
    }

    void aa() {
        int n = 0;
        while (n < this.ex.length) {
            int n2 = 0;
            while (n2 < this.ex[n].getComponentCount()) {
                Component component = this.ex[n].getComponent(n2);
                if (component instanceof bL && ((bL)component).eB.isSpecial()) {
                    ((bL)component).ac();
                }
                ++n2;
            }
            ++n;
        }
    }

    private void a(gs gs2, String string) {
        int n = 0;
        while (n < this.ex.length) {
            int n2 = 0;
            while (n2 < this.ex[n].getComponentCount()) {
                Component component = this.ex[n].getComponent(n2);
                if (component instanceof bJ && ((bJ)component).ez == gs2) {
                    ((bJ)component).setText(string);
                }
                ++n2;
            }
            ++n;
        }
    }

    void a(gz gz2) {
        this.cp = gz2;
        int n = 0;
        while (n < this.ex.length) {
            int n2 = 0;
            while (n2 < this.ex[n].getComponentCount()) {
                Component component = this.ex[n].getComponent(n2);
                if (component instanceof bJ) {
                    ((bJ)component).ac();
                } else if (component instanceof bL) {
                    ((bL)component).ac();
                }
                ++n2;
            }
            ++n;
        }
    }

    static /* synthetic */ gz a(bE bE2) {
        return bE2.cp;
    }

    static /* synthetic */ void a(bE bE2, gs gs2, String string) {
        bE2.a(gs2, string);
    }
}
