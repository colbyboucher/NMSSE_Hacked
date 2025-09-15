/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import nomanssave.Application;
import nomanssave.eV;
import nomanssave.eY;
import nomanssave.gf;
import nomanssave.gh;
import nomanssave.gt;

public class ge {
    private final List gT;
    private final List nh;
    private final List ni;

    public static ge m(eY eY2) {
        return new ge(eY2);
    }

    private static Function ap(int n) {
        return gt2 -> {
            String string = gt2.getName();
            if (string == null || string.length() == 0 || "BLD_STORAGE_NAME".equals(string)) {
                string = "Chest " + n;
            }
            return new String[]{string};
        };
    }

    /*
     * Exception decompiling
     */
    private static Function cB() {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * java.lang.UnsupportedOperationException
         *     at org.benf.cfr.reader.bytecode.analysis.parse.expression.NewAnonymousArray.getDimSize(NewAnonymousArray.java:142)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.LambdaRewriter.isNewArrayLambda(LambdaRewriter.java:455)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.LambdaRewriter.rewriteDynamicExpression(LambdaRewriter.java:409)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.LambdaRewriter.rewriteDynamicExpression(LambdaRewriter.java:167)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.LambdaRewriter.rewriteExpression(LambdaRewriter.java:105)
         *     at org.benf.cfr.reader.bytecode.analysis.structured.statement.StructuredReturn.rewriteExpressions(StructuredReturn.java:99)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op4rewriters.LambdaRewriter.rewrite(LambdaRewriter.java:88)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.rewriteLambdas(Op04StructuredStatement.java:1137)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:912)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:278)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:201)
         *     at org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
         *     at org.benf.cfr.reader.entities.Method.analyse(Method.java:531)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1055)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:942)
         *     at org.benf.cfr.reader.Driver.doClass(Driver.java:84)
         *     at org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:78)
         *     at org.benf.cfr.reader.Main.main(Main.java:54)
         */
        throw new IllegalStateException("Decompilation failed");
    }

    private ge(eY eY2) {
        int n = 8;
        int n2 = 6;
        if (Application.e().D()) {
            n = 10;
            n2 = 8;
        }
        ArrayList<gt> arrayList = new ArrayList<gt>();
        int n3 = 0;
        while (n3 < 10) {
            arrayList.add(new gt(ge.ap(n3), eY2.H("Chest" + (n3 + 1) + "Inventory"), 3584, n, n2, false, false));
            ++n3;
        }
        eY eY3 = eY2.H("CookingIngredientsInventory");
        if (eY3 != null) {
            arrayList.add(new gt(ge.cB(), eY3, 36352, n, n2, false, false));
        }
        this.gT = Collections.unmodifiableList(arrayList);
        ArrayList<gh> arrayList2 = new ArrayList<gh>();
        eV eV2 = eY2.d("NPCWorkers");
        String string = "";
        int n4 = 0;
        while (n4 < eV2.size() && n4 < 5) {
            eY eY4 = eV2.V(n4);
            if (eY4.M("HiredWorker")) {
                switch (n4) {
                    case 0: {
                        string = "Armorer";
                        break;
                    }
                    case 1: {
                        string = "Farmer";
                        break;
                    }
                    case 2: {
                        string = "Overseer";
                        break;
                    }
                    case 3: {
                        string = "Technician";
                        break;
                    }
                    case 4: {
                        string = "Scientist";
                    }
                }
                arrayList2.add(new gh(this, string, eY4, null));
            }
            ++n4;
        }
        this.nh = Collections.unmodifiableList(arrayList2);
        ArrayList<gf> arrayList3 = new ArrayList<gf>();
        eV eV3 = eY2.d("PersistentPlayerBases");
        int n5 = 0;
        while (n5 < eV3.size()) {
            eY eY5 = eV3.V(n5);
            if ("HomePlanetBase".equals(eY5.getValueAsString("BaseType.PersistentBaseTypes")) && eY5.J("BaseVersion") >= 3) {
                arrayList3.add(new gf(this, eY5, null));
            }
            ++n5;
        }
        this.ni = Collections.unmodifiableList(arrayList3);
    }

    public List cC() {
        return this.gT;
    }

    public List cD() {
        return this.nh;
    }

    public List cE() {
        return this.ni;
    }
}
