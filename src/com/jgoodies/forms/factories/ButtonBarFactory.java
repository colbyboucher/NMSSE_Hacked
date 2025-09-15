/*
 * Decompiled with CFR 0.152.
 */
package com.jgoodies.forms.factories;

import com.jgoodies.forms.builder.ButtonBarBuilder2;
import com.jgoodies.forms.factories.CC;
import java.awt.Component;
import javax.swing.JButton;
import javax.swing.JPanel;

public final class ButtonBarFactory {
    private ButtonBarFactory() {
    }

    public static JPanel buildLeftAlignedBar(JButton button1) {
        return ButtonBarFactory.buildLeftAlignedBar(new JButton[]{button1});
    }

    public static JPanel buildLeftAlignedBar(JButton button1, JButton button2) {
        return ButtonBarFactory.buildLeftAlignedBar(new JButton[]{button1, button2}, true);
    }

    public static JPanel buildLeftAlignedBar(JButton button1, JButton button2, JButton button3) {
        return ButtonBarFactory.buildLeftAlignedBar(new JButton[]{button1, button2, button3}, true);
    }

    public static JPanel buildLeftAlignedBar(JButton button1, JButton button2, JButton button3, JButton button4) {
        return ButtonBarFactory.buildLeftAlignedBar(new JButton[]{button1, button2, button3, button4}, true);
    }

    public static JPanel buildLeftAlignedBar(JButton button1, JButton button2, JButton button3, JButton button4, JButton button5) {
        return ButtonBarFactory.buildLeftAlignedBar(new JButton[]{button1, button2, button3, button4, button5}, true);
    }

    public static JPanel buildLeftAlignedBar(JButton[] buttons) {
        ButtonBarBuilder2 builder = new ButtonBarBuilder2();
        builder.addButton(buttons);
        builder.addGlue();
        return builder.getPanel();
    }

    public static JPanel buildLeftAlignedBar(JButton[] buttons, boolean leftToRightButtonOrder) {
        ButtonBarBuilder2 builder = new ButtonBarBuilder2();
        builder.setLeftToRightButtonOrder(leftToRightButtonOrder);
        builder.addButton(buttons);
        builder.addGlue();
        return builder.getPanel();
    }

    public static JPanel buildCenteredBar(JButton button1) {
        return ButtonBarFactory.buildCenteredBar(new JButton[]{button1});
    }

    public static JPanel buildCenteredBar(JButton button1, JButton button2) {
        return ButtonBarFactory.buildCenteredBar(new JButton[]{button1, button2});
    }

    public static JPanel buildCenteredBar(JButton button1, JButton button2, JButton button3) {
        return ButtonBarFactory.buildCenteredBar(new JButton[]{button1, button2, button3});
    }

    public static JPanel buildCenteredBar(JButton button1, JButton button2, JButton button3, JButton button4) {
        return ButtonBarFactory.buildCenteredBar(new JButton[]{button1, button2, button3, button4});
    }

    public static JPanel buildCenteredBar(JButton button1, JButton button2, JButton button3, JButton button4, JButton button5) {
        return ButtonBarFactory.buildCenteredBar(new JButton[]{button1, button2, button3, button4, button5});
    }

    public static JPanel buildCenteredBar(JButton[] buttons) {
        ButtonBarBuilder2 builder = new ButtonBarBuilder2();
        builder.addGlue();
        builder.addButton(buttons);
        builder.addGlue();
        return builder.getPanel();
    }

    public static JPanel buildGrowingBar(JButton button1) {
        return ButtonBarFactory.buildGrowingBar(new JButton[]{button1});
    }

    public static JPanel buildGrowingBar(JButton button1, JButton button2) {
        return ButtonBarFactory.buildGrowingBar(new JButton[]{button1, button2});
    }

    public static JPanel buildGrowingBar(JButton button1, JButton button2, JButton button3) {
        return ButtonBarFactory.buildGrowingBar(new JButton[]{button1, button2, button3});
    }

    public static JPanel buildGrowingBar(JButton button1, JButton button2, JButton button3, JButton button4) {
        return ButtonBarFactory.buildGrowingBar(new JButton[]{button1, button2, button3, button4});
    }

    public static JPanel buildGrowingBar(JButton button1, JButton button2, JButton button3, JButton button4, JButton button5) {
        return ButtonBarFactory.buildGrowingBar(new JButton[]{button1, button2, button3, button4, button5});
    }

    public static JPanel buildGrowingBar(JButton[] buttons) {
        ButtonBarBuilder2 builder = new ButtonBarBuilder2();
        builder.addGrowing(buttons);
        return builder.getPanel();
    }

    public static JPanel buildRightAlignedBar(JButton button1) {
        return ButtonBarFactory.buildRightAlignedBar(new JButton[]{button1});
    }

    public static JPanel buildRightAlignedBar(JButton button1, JButton button2) {
        return ButtonBarFactory.buildRightAlignedBar(new JButton[]{button1, button2}, true);
    }

    public static JPanel buildRightAlignedBar(JButton button1, JButton button2, JButton button3) {
        return ButtonBarFactory.buildRightAlignedBar(new JButton[]{button1, button2, button3}, true);
    }

    public static JPanel buildRightAlignedBar(JButton button1, JButton button2, JButton button3, JButton button4) {
        return ButtonBarFactory.buildRightAlignedBar(new JButton[]{button1, button2, button3, button4}, true);
    }

    public static JPanel buildRightAlignedBar(JButton button1, JButton button2, JButton button3, JButton button4, JButton button5) {
        return ButtonBarFactory.buildRightAlignedBar(new JButton[]{button1, button2, button3, button4, button5}, true);
    }

    public static JPanel buildRightAlignedBar(JButton[] buttons) {
        ButtonBarBuilder2 builder = new ButtonBarBuilder2();
        builder.addGlue();
        builder.addButton(buttons);
        return builder.getPanel();
    }

    public static JPanel buildRightAlignedBar(JButton[] buttons, boolean leftToRightButtonOrder) {
        ButtonBarBuilder2 builder = new ButtonBarBuilder2();
        builder.setLeftToRightButtonOrder(leftToRightButtonOrder);
        builder.addGlue();
        builder.addButton(buttons);
        return builder.getPanel();
    }

    public static JPanel buildHelpBar(JButton help, JButton button1) {
        return ButtonBarFactory.buildHelpBar(help, new JButton[]{button1});
    }

    public static JPanel buildHelpBar(JButton help, JButton button1, JButton button2) {
        return ButtonBarFactory.buildHelpBar(help, new JButton[]{button1, button2});
    }

    public static JPanel buildHelpBar(JButton help, JButton button1, JButton button2, JButton button3) {
        return ButtonBarFactory.buildHelpBar(help, new JButton[]{button1, button2, button3});
    }

    public static JPanel buildHelpBar(JButton help, JButton button1, JButton button2, JButton button3, JButton button4) {
        return ButtonBarFactory.buildHelpBar(help, new JButton[]{button1, button2, button3, button4});
    }

    public static JPanel buildHelpBar(JButton help, JButton[] buttons) {
        ButtonBarBuilder2 builder = new ButtonBarBuilder2();
        builder.addButton(help);
        builder.addUnrelatedGap();
        builder.addGlue();
        builder.addButton(buttons);
        return builder.getPanel();
    }

    public static JPanel buildCloseBar(JButton close) {
        return ButtonBarFactory.buildRightAlignedBar(close);
    }

    public static JPanel buildOKBar(JButton ok) {
        return ButtonBarFactory.buildRightAlignedBar(ok);
    }

    public static JPanel buildOKCancelBar(JButton ok, JButton cancel) {
        return ButtonBarFactory.buildRightAlignedBar(new JButton[]{ok, cancel});
    }

    public static JPanel buildOKCancelApplyBar(JButton ok, JButton cancel, JButton apply) {
        return ButtonBarFactory.buildRightAlignedBar(new JButton[]{ok, cancel, apply});
    }

    public static JPanel buildHelpCloseBar(JButton help, JButton close) {
        return ButtonBarFactory.buildHelpBar(help, close);
    }

    public static JPanel buildHelpOKBar(JButton help, JButton ok) {
        return ButtonBarFactory.buildHelpBar(help, ok);
    }

    public static JPanel buildHelpOKCancelBar(JButton help, JButton ok, JButton cancel) {
        return ButtonBarFactory.buildHelpBar(help, ok, cancel);
    }

    public static JPanel buildHelpOKCancelApplyBar(JButton help, JButton ok, JButton cancel, JButton apply) {
        return ButtonBarFactory.buildHelpBar(help, ok, cancel, apply);
    }

    public static JPanel buildCloseHelpBar(JButton close, JButton help) {
        return ButtonBarFactory.buildRightAlignedBar(new JButton[]{close, help});
    }

    public static JPanel buildOKHelpBar(JButton ok, JButton help) {
        return ButtonBarFactory.buildRightAlignedBar(new JButton[]{ok, help});
    }

    public static JPanel buildOKCancelHelpBar(JButton ok, JButton cancel, JButton help) {
        return ButtonBarFactory.buildRightAlignedBar(new JButton[]{ok, cancel, help});
    }

    public static JPanel buildOKCancelApplyHelpBar(JButton ok, JButton cancel, JButton apply, JButton help) {
        return ButtonBarFactory.buildRightAlignedBar(new JButton[]{ok, cancel, apply, help});
    }

    public static JPanel buildAddRemoveLeftBar(JButton add, JButton remove) {
        return ButtonBarFactory.buildLeftAlignedBar(add, remove);
    }

    public static JPanel buildAddRemoveBar(JButton add, JButton remove) {
        return ButtonBarFactory.buildGrowingBar(add, remove);
    }

    public static JPanel buildAddRemoveRightBar(JButton add, JButton remove) {
        return ButtonBarFactory.buildRightAlignedBar(add, remove);
    }

    public static JPanel buildAddRemovePropertiesLeftBar(JButton add, JButton remove, JButton properties) {
        return ButtonBarFactory.buildLeftAlignedBar(add, remove, properties);
    }

    public static JPanel buildAddRemovePropertiesBar(JButton add, JButton remove, JButton properties) {
        ButtonBarBuilder2 builder = new ButtonBarBuilder2();
        builder.addButton(add);
        builder.addRelatedGap();
        builder.addButton(remove);
        builder.addRelatedGap();
        builder.addButton(properties);
        return builder.getPanel();
    }

    public static JPanel buildAddRemovePropertiesRightBar(JButton add, JButton remove, JButton properties) {
        return ButtonBarFactory.buildRightAlignedBar(add, remove, properties);
    }

    public static JPanel buildWizardBar(JButton back, JButton next, JButton finish, JButton cancel) {
        return ButtonBarFactory.buildWizardBar(back, next, new JButton[]{finish, cancel});
    }

    public static JPanel buildWizardBar(JButton help, JButton back, JButton next, JButton finish, JButton cancel) {
        return ButtonBarFactory.buildWizardBar(new JButton[]{help}, back, next, new JButton[]{finish, cancel});
    }

    public static JPanel buildWizardBar(JButton back, JButton next, JButton[] rightAlignedButtons) {
        return ButtonBarFactory.buildWizardBar(null, back, next, rightAlignedButtons);
    }

    public static JPanel buildWizardBar(JButton[] leftAlignedButtons, JButton back, JButton next, JButton[] rightAlignedButtons) {
        return ButtonBarFactory.buildWizardBar(leftAlignedButtons, back, next, null, rightAlignedButtons);
    }

    public static JPanel buildWizardBar(JButton[] leftAlignedButtons, JButton back, JButton next, JButton overlaidFinish, JButton[] rightAlignedButtons) {
        MyButtonBarBuilder2 builder = new MyButtonBarBuilder2();
        if (leftAlignedButtons != null) {
            builder.addButton(leftAlignedButtons);
            builder.addRelatedGap();
        }
        builder.addGlue();
        builder.addButton(back);
        builder.addButton(next);
        if (overlaidFinish != null) {
            builder.getPanel().add((Component)overlaidFinish, CC.xy(builder.getColumn(), 1));
        }
        if (rightAlignedButtons != null) {
            builder.addRelatedGap();
            builder.addButton(rightAlignedButtons);
        }
        return builder.getPanel();
    }

    private static final class MyButtonBarBuilder2
    extends ButtonBarBuilder2 {
        private MyButtonBarBuilder2() {
        }

        public int getColumn() {
            return super.getColumn();
        }
    }
}
