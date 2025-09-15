/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;
import java.awt.Component;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import nomanssave.Application;
import nomanssave.eI;
import nomanssave.eY;
import nomanssave.f;

public class c
extends JPanel {
    private final f c;
    private final f d;
    private final f e;

    c(Application application) {
        GridLayout gridLayout = new GridLayout(2, 3);
        this.setLayout(gridLayout);
        JPanel jPanel = new JPanel();
        this.add(jPanel);
        jPanel.setLayout(new FormLayout(new ColumnSpec[]{FormFactory.LABEL_COMPONENT_GAP_COLSPEC, ColumnSpec.decode("default:grow"), FormFactory.LABEL_COMPONENT_GAP_COLSPEC}, new RowSpec[]{FormFactory.LINE_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC, FormFactory.LINE_GAP_ROWSPEC, RowSpec.decode("200px:grow"), FormFactory.LINE_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC, FormFactory.LINE_GAP_ROWSPEC}));
        JLabel jLabel = new JLabel("Season Rewards");
        jLabel.putClientProperty("FlatLaf.styleClass", "semibold");
        jPanel.add((Component)jLabel, "2, 2");
        JScrollPane jScrollPane = new JScrollPane();
        jPanel.add((Component)jScrollPane, "2, 4, fill, fill");
        this.c = new f(this, application, eI::bq, eI::P);
        jScrollPane.setViewportView(this.c);
        JPanel jPanel2 = new JPanel();
        this.add(jPanel2);
        jPanel2.setLayout(new FormLayout(new ColumnSpec[]{FormFactory.LABEL_COMPONENT_GAP_COLSPEC, ColumnSpec.decode("default:grow"), FormFactory.LABEL_COMPONENT_GAP_COLSPEC}, new RowSpec[]{FormFactory.LINE_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC, FormFactory.LINE_GAP_ROWSPEC, RowSpec.decode("200px:grow"), FormFactory.LINE_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC, FormFactory.DEFAULT_ROWSPEC, FormFactory.LINE_GAP_ROWSPEC}));
        jLabel = new JLabel("Twitch Rewards");
        jLabel.putClientProperty("FlatLaf.styleClass", "semibold");
        jPanel2.add((Component)jLabel, "2, 2");
        JScrollPane jScrollPane2 = new JScrollPane();
        jPanel2.add((Component)jScrollPane2, "2, 4, fill, fill");
        this.d = new f(this, application, eI::br, eI::Q);
        jScrollPane2.setViewportView(this.d);
        jLabel = new JLabel("NOTE: To use twitch drops, you must go offline before you start the game.");
        jPanel2.add((Component)jLabel, "2, 6, fill, fill");
        jLabel = new JLabel("You can claim them at the Synthesis vendor in the Anomaly.");
        jPanel2.add((Component)jLabel, "2, 7, fill, fill");
        JPanel jPanel3 = new JPanel();
        this.add(jPanel3);
        jPanel3.setLayout(new FormLayout(new ColumnSpec[]{FormFactory.LABEL_COMPONENT_GAP_COLSPEC, ColumnSpec.decode("default:grow"), FormFactory.LABEL_COMPONENT_GAP_COLSPEC}, new RowSpec[]{FormFactory.LINE_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC, FormFactory.LINE_GAP_ROWSPEC, RowSpec.decode("200px:grow"), FormFactory.LINE_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC, FormFactory.LINE_GAP_ROWSPEC}));
        jLabel = new JLabel("Platform Rewards");
        jLabel.putClientProperty("FlatLaf.styleClass", "semibold");
        jPanel3.add((Component)jLabel, "2, 2");
        JScrollPane jScrollPane3 = new JScrollPane();
        jPanel3.add((Component)jScrollPane3, "2, 4, fill, fill");
        this.e = new f(this, application, eI::bs, eI::R);
        jScrollPane3.setViewportView(this.e);
        JPanel jPanel4 = new JPanel();
        this.add(jPanel4);
        jPanel4 = new JPanel();
        this.add(jPanel4);
        jPanel4 = new JPanel();
        this.add(jPanel4);
    }

    void a(eY eY2) {
        if (eY2 == null) {
            this.c.a(null);
            this.d.a(null);
            this.e.a(null);
        } else {
            this.c.a(eY2.d("UserSettingsData.UnlockedSeasonRewards"));
            this.d.a(eY2.d("UserSettingsData.UnlockedTwitchRewards"));
            this.e.a(eY2.d("UserSettingsData.UnlockedPlatformRewards"));
        }
        this.updateUI();
    }
}
