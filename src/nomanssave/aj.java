/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.util.Arrays;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.border.LineBorder;
import nomanssave.Application;
import nomanssave.ak;
import nomanssave.al;
import nomanssave.am;
import nomanssave.an;
import nomanssave.ao;
import nomanssave.hl;

public class aj
extends JDialog {
    private static final List bW = Arrays.asList("Euclid", "Hilbert Dimension", "Calypso", "Hesperius Dimension", "Hyades", "Ickjamatew", "Budullangr", "Kikolgallr", "Eltiensleen", "Eissentam", "Elkupalos", "Aptarkaba", "Ontiniangp", "Odiwagiri", "Ogtialabi", "Muhacksonto", "Hitonskyer", "Rerasmutul", "Isdoraijung", "Doctinawyra", "Loychazinq", "Zukasizawa", "Ekwathore", "Yeberhahne", "Twerbetek", "Sivarates", "Eajerandal", "Aldukesci", "Wotyarogii", "Sudzerbal", "Maupenzhay", "Sugueziume", "Brogoweldian", "Ehbogdenbu", "Ijsenufryos", "Nipikulha", "Autsurabin", "Lusontrygiamh", "Rewmanawa", "Ethiophodhe", "Urastrykle", "Xobeurindj", "Oniijialdu", "Wucetosucc", "Ebyeloofdud", "Odyavanta", "Milekistri", "Waferganh", "Agnusopwit", "Teyaypilny", "Zalienkosm", "Ladgudiraf", "Mushonponte", "Amsentisz", "Fladiselm", "Laanawemb", "Ilkerloor", "Davanossi", "Ploehrliou", "Corpinyaya", "Leckandmeram", "Quulngais", "Nokokipsechl", "Rinblodesa", "Loydporpen", "Ibtrevskip", "Elkowaldb", "Heholhofsko", "Yebrilowisod", "Husalvangewi", "Ovna'uesed", "Bahibusey", "Nuybeliaure", "Doshawchuc", "Ruckinarkh", "Thorettac", "Nuponoparau", "Moglaschil", "Uiweupose", "Nasmilete", "Ekdaluskin", "Hakapanasy", "Dimonimba", "Cajaccari", "Olonerovo", "Umlanswick", "Henayliszm", "Utzenmate", "Umirpaiya", "Paholiang", "Iaereznika", "Yudukagath", "Boealalosnj", "Yaevarcko", "Coellosipp", "Wayndohalou", "Smoduraykl", "Apmaneessu", "Hicanpaav", "Akvasanta", "Tuychelisaor", "Rivskimbe", "Daksanquix", "Kissonlin", "Aediabiel", "Ulosaginyik", "Roclaytonycar", "Kichiaroa", "Irceauffey", "Nudquathsenfe", "Getaizakaal", "Hansolmien", "Bloytisagra", "Ladsenlay", "Luyugoslasr", "Ubredhatk", "Cidoniana", "Jasinessa", "Torweierf", "Saffneckm", "Thnistner", "Dotusingg", "Luleukous", "Jelmandan", "Otimanaso", "Enjaxusanto", "Sezviktorew", "Zikehpm", "Bephembah", "Broomerrai", "Meximicka", "Venessika", "Gaiteseling", "Zosakasiro", "Drajayanes", "Ooibekuar", "Urckiansi", "Dozivadido", "Emiekereks", "Meykinunukur", "Kimycuristh", "Roansfien", "Isgarmeso", "Daitibeli", "Gucuttarik", "Enlaythie", "Drewweste", "Akbulkabi", "Homskiw", "Zavainlani", "Jewijkmas", "Itlhotagra", "Podalicess", "Hiviusauer", "Halsebenk", "Puikitoac", "Gaybakuaria", "Grbodubhe", "Rycempler", "Indjalala", "Fontenikk", "Pasycihelwhee", "Ikbaksmit", "Telicianses", "Oyleyzhan", "Uagerosat", "Impoxectin", "Twoodmand", "Hilfsesorbs", "Ezdaranit", "Wiensanshe", "Ewheelonc", "Litzmantufa", "Emarmatosi", "Mufimbomacvi", "Wongquarum", "Hapirajua", "Igbinduina", "Wepaitvas", "Sthatigudi", "Yekathsebehn", "Ebedeagurst", "Nolisonia", "Ulexovitab", "Iodhinxois", "Irroswitzs", "Bifredait", "Beiraghedwe", "Yeonatlak", "Cugnatachh", "Nozoryenki", "Ebralduri", "Evcickcandj", "Ziybosswin", "Heperclait", "Sugiuniam", "Aaseertush", "Uglyestemaa", "Horeroedsh", "Drundemiso", "Ityanianat", "Purneyrine", "Dokiessmat", "Nupiacheh", "Dihewsonj", "Rudrailhik", "Tweretnort", "Snatreetze", "Iwunddaracos", "Digarlewena", "Erquagsta", "Logovoloin", "Boyaghosganh", "Kuolungau", "Pehneldept", "Yevettiiqidcon", "Sahliacabru", "Noggalterpor", "Chmageaki", "Veticueca", "Vittesbursul", "Nootanore", "Innebdjerah", "Kisvarcini", "Cuzcogipper", "Pamanhermonsu", "Brotoghek", "Mibittara", "Huruahili", "Raldwicarn", "Ezdartlic", "Badesclema", "Isenkeyan", "Iadoitesu", "Yagrovoisi", "Ewcomechio", "Inunnunnoda", "Dischiutun", "Yuwarugha", "Ialmendra", "Reponudrle", "Rinjanagrbo", "Zeziceloh", "Oeileutasc", "Zicniijinis", "Dugnowarilda", "Neuxoisan", "Ilmenhorn", "Rukwatsuku", "Nepitzaspru", "Chcehoemig", "Haffneyrin", "Uliciawai", "Tuhgrespod", "Iousongola", "Odyalutai", "Yilsrussimil");
    private JComboBox bX;
    private JTextField bY;
    private JTextField bZ;
    private JLabel[] ca;
    private JTextField m;
    private ImageIcon[] cb;
    private hl cc = null;
    private boolean cd = false;
    private static final String ce = "0123456789ABCDEF";
    private static aj cf = null;

    private aj(Frame frame) {
        super(frame);
        this.setResizable(false);
        this.setModalExclusionType(Dialog.ModalExclusionType.APPLICATION_EXCLUDE);
        this.setTitle("Coordinate Viewer");
        this.setModal(true);
        JPanel jPanel = new JPanel();
        this.setContentPane(jPanel);
        jPanel.setLayout(new BorderLayout(0, 0));
        JPanel jPanel2 = new JPanel();
        jPanel2.setLayout(new FormLayout(new ColumnSpec[]{FormFactory.LABEL_COMPONENT_GAP_COLSPEC, ColumnSpec.decode("100px"), FormFactory.LABEL_COMPONENT_GAP_COLSPEC, ColumnSpec.decode("default:grow"), FormFactory.LABEL_COMPONENT_GAP_COLSPEC, ColumnSpec.decode("100px"), FormFactory.LABEL_COMPONENT_GAP_COLSPEC}, new RowSpec[]{FormFactory.LINE_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC, FormFactory.LINE_GAP_ROWSPEC, RowSpec.decode("bottom:10px"), FormFactory.LINE_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC, FormFactory.LINE_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC, FormFactory.LINE_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC, FormFactory.LINE_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC, FormFactory.LINE_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC, FormFactory.LINE_GAP_ROWSPEC}));
        JLabel jLabel = new JLabel("Search:");
        jLabel.putClientProperty("FlatLaf.styleClass", "semibold");
        jPanel2.add((Component)jLabel, "2, 2, left, center");
        this.m = new JTextField();
        jPanel2.add((Component)this.m, "4, 2, fill, default");
        JButton jButton = new JButton("Search");
        jButton.addActionListener(new ak(this));
        jPanel2.add((Component)jButton, "6, 2, fill, fill");
        JLabel jLabel2 = new JLabel("Coordinate Location:");
        jLabel2.putClientProperty("FlatLaf.styleClass", "semibold");
        jPanel2.add((Component)jLabel2, "2, 6, 5, 1, left, center");
        JLabel jLabel3 = new JLabel("Galaxy:");
        jPanel2.add((Component)jLabel3, "2, 8, left, center");
        this.bX = new JComboBox();
        this.bX.setModel(new al(this));
        jPanel2.add((Component)this.bX, "4, 8, 3, 1, fill, default");
        JLabel jLabel4 = new JLabel("Galactic Addr:");
        jPanel2.add((Component)jLabel4, "2, 10, left, center");
        this.bY = new JTextField();
        this.bY.setEditable(false);
        jPanel2.add((Component)this.bY, "4, 10, 3, 1, fill, default");
        JLabel jLabel5 = new JLabel("Portal Addr:");
        jPanel2.add((Component)jLabel5, "2, 12, left, center");
        this.bZ = new JTextField();
        this.bZ.setEditable(false);
        jPanel2.add((Component)this.bZ, "4, 12, 3, 1, fill, default");
        JPanel jPanel3 = new JPanel();
        jPanel3.setBackground(Color.GRAY);
        jPanel3.setBorder(new LineBorder(Color.DARK_GRAY));
        jPanel3.setLayout(new FlowLayout(1, 5, 5));
        jPanel3.setMinimumSize(new Dimension(449, 42));
        this.cb = new ImageIcon[16];
        int n = 0;
        while (n < 16) {
            this.cb[n] = Application.a("UI-GLYPH" + (n + 1) + ".PNG");
            ++n;
        }
        this.ca = new JLabel[12];
        n = 0;
        while (n < 12) {
            this.ca[n] = new JLabel(this.cb[0]);
            jPanel3.add(this.ca[n]);
            ++n;
        }
        jPanel2.add((Component)jPanel3, "2, 14, 5, 1, fill, fill");
        jPanel.add(jPanel2);
        JPanel jPanel4 = new JPanel();
        jPanel4.setLayout(new FlowLayout(2));
        jPanel.add((Component)jPanel4, "South");
        JButton jButton2 = new JButton("Save / Warp");
        jButton2.addActionListener(new am(this));
        jPanel4.add(jButton2);
        this.getRootPane().setDefaultButton(jButton2);
        JButton jButton3 = new JButton("Cancel");
        jButton3.addActionListener(new an(this));
        jPanel4.add(jButton3);
        this.getRootPane().registerKeyboardAction(new ao(this), KeyStroke.getKeyStroke(27, 0), 2);
        this.pack();
    }

    private void P() {
        this.bX.setSelectedIndex(this.cc.es() >= bW.size() ? -1 : this.cc.es());
        this.bX.updateUI();
        this.bY.setText(this.cc.ez());
        String string = this.cc.ey();
        this.bZ.setText(string);
        int n = 0;
        while (n < 12) {
            int n2 = ce.indexOf(string.charAt(n));
            this.ca[n].setIcon(n2 < 0 ? null : this.cb[n2]);
            ++n;
        }
    }

    private hl a(hl hl2) {
        this.cc = hl2;
        this.m.setText("");
        this.P();
        this.cd = false;
        this.setLocationRelativeTo(this.getParent());
        this.setVisible(true);
        return this.cd ? this.cc : null;
    }

    public static hl a(Container container, hl hl2) {
        if (cf == null) {
            Frame frame = JOptionPane.getFrameForComponent(container);
            cf = new aj(frame);
        }
        return cf.a(hl2);
    }

    static /* synthetic */ JTextField a(aj aj2) {
        return aj2.m;
    }

    static /* synthetic */ JComboBox b(aj aj2) {
        return aj2.bX;
    }

    static /* synthetic */ void a(aj aj2, hl hl2) {
        aj2.cc = hl2;
    }

    static /* synthetic */ void c(aj aj2) {
        aj2.P();
    }

    static /* synthetic */ List Q() {
        return bW;
    }

    static /* synthetic */ void a(aj aj2, boolean bl) {
        aj2.cd = bl;
    }
}
