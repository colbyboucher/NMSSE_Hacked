/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import nomanssave.aH;
import nomanssave.eY;
import nomanssave.fS;
import nomanssave.fT;
import nomanssave.fW;
import nomanssave.fY;
import nomanssave.fn;
import nomanssave.fs;
import nomanssave.hc;

class fV
implements fs {
    final fW mO;
    final int mb;
    final File mc;
    final String mP;
    final fS mQ;
    final String mR;
    final String mS;
    final fn be;
    final /* synthetic */ fT mN;

    fV(fT fT2, String string, int n) {
        this.mN = fT2;
        this.mb = n;
        this.mc = new File(aH.cG, string);
        try (ZipFile zipFile = new ZipFile(this.mc);){
            try {
                ZipEntry zipEntry = zipFile.getEntry("saveinfo.txt");
                if (zipEntry == null) {
                    throw new IOException("Invalid backup file");
                }
                Properties properties = new Properties();
                properties.load(zipFile.getInputStream(zipEntry));
                this.mP = properties.getProperty("MetaFile");
                this.mR = properties.getProperty("DataFile");
                this.mS = properties.getProperty("ContainerFile");
                String string2 = properties.getProperty("IndexData");
                if (this.mP == null || this.mR == null || this.mS == null || string2 == null) {
                    throw new IOException("Invalid backup file");
                }
                String string3 = properties.getProperty("GameMode");
                this.be = string3 == null ? null : fn.valueOf(string3);
                this.mO = new fW(fT2, string2);
                zipEntry = zipFile.getEntry(this.mP);
                if (zipEntry == null) {
                    throw new IOException("Invalid backup file");
                }
                this.mQ = new fS(null);
                this.mQ.read(zipFile.getInputStream(zipEntry));
            }
            catch (NumberFormatException numberFormatException) {
                throw new IOException("Invalid backup file");
            }
        }
    }

    void a(FileOutputStream fileOutputStream) {
        try (ZipFile zipFile = new ZipFile(this.mc);){
            ZipEntry zipEntry = zipFile.getEntry(this.mS);
            if (zipEntry == null) {
                throw new IOException("Invalid backup file");
            }
            try (InputStream inputStream = zipFile.getInputStream(zipEntry);){
                int n;
                byte[] byArray = new byte[1024];
                while ((n = inputStream.read(byArray)) > 0) {
                    fileOutputStream.write(byArray, 0, n);
                }
            }
        }
    }

    @Override
    public String K() {
        return this.mO.filename;
    }

    @Override
    public fn L() {
        return this.be;
    }

    /*
     * Exception decompiling
     */
    @Override
    public eY M() {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [3[TRYBLOCK]], but top level block is 4[TRYBLOCK]
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.processEndingBlocks(Op04StructuredStatement.java:435)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:484)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:736)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:850)
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

    @Override
    public String b(eY eY2) {
        String string;
        hc.info("Writing new save file...");
        if (fT.b(this.mN)[this.mb] != null) {
            fT.b((fT)this.mN)[this.mb].mZ.a(this.mQ);
            string = fT.b(this.mN)[this.mb].b(eY2);
        } else {
            fT.b((fT)this.mN)[this.mb] = new fY(this.mN, this, eY2);
            string = fT.b(this.mN)[this.mb].K();
        }
        hc.info("Finished.");
        return string;
    }

    @Override
    public long lastModified() {
        return this.mO.timestamp;
    }

    public String toString() {
        return this.mc.getName();
    }

    @Override
    public String getName() {
        return this.mQ.getName();
    }

    @Override
    public String getDescription() {
        return this.mQ.getDescription();
    }
}
