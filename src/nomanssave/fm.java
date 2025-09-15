/*
 * Decompiled with CFR 0.152.
 */
package nomanssave;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.TimeUnit;
import nomanssave.fl;
import nomanssave.fq;
import nomanssave.hc;

class fm
extends Thread {
    final WatchService lk = FileSystems.getDefault().newWatchService();
    final Map ll = new WeakHashMap();

    fm() {
        this.setDaemon(true);
        this.start();
    }

    void a(fq fq2, File file) {
        WatchKey watchKey = file.toPath().register(this.lk, StandardWatchEventKinds.ENTRY_CREATE, StandardWatchEventKinds.ENTRY_DELETE, StandardWatchEventKinds.ENTRY_MODIFY);
        this.ll.put(fq2, watchKey);
    }

    void b(fq fq2) {
        WatchKey watchKey = (WatchKey)this.ll.remove(fq2);
        if (watchKey != null) {
            watchKey.cancel();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void run() {
        try {
            try {
                HashMap<WatchKey, List<String>> hashMap = new HashMap<WatchKey, List<String>>();
                while (true) {
                    WatchEvent.Kind<?> kind;
                    WatchEvent<?> watchEvent22;
                    List<String> list;
                    WatchKey watchKey = this.lk.take();
                    do {
                        if (hashMap.containsKey(watchKey)) {
                            list = (List)hashMap.get(watchKey);
                        } else {
                            list = new ArrayList();
                            hashMap.put(watchKey, list);
                        }
                        for (WatchEvent<?> watchEvent22 : watchKey.pollEvents()) {
                            String string;
                            kind = watchEvent22.kind();
                            if (kind == StandardWatchEventKinds.OVERFLOW || list.contains(string = watchEvent22.context().toString())) continue;
                            list.add(string);
                        }
                    } while (watchKey.reset() && (watchKey = this.lk.poll(500L, TimeUnit.MILLISECONDS)) != null);
                    watchEvent22 = fl.bQ();
                    synchronized (watchEvent22) {
                        boolean bl = false;
                        for (Map.Entry entry : hashMap.entrySet()) {
                            watchKey = (WatchKey)entry.getKey();
                            list = (List)entry.getValue();
                            bl = false;
                            for (Map.Entry entry2 : this.ll.entrySet()) {
                                if (entry2.getValue() != watchKey || (kind = (fq)entry2.getKey()) == null) continue;
                                bl = true;
                                for (String string : list) {
                                    kind.X(string);
                                }
                            }
                            if (bl) continue;
                            watchKey.cancel();
                        }
                        kind = null;
                    }
                    hashMap.clear();
                }
            }
            catch (Throwable throwable) {
                this.lk.close();
                throw throwable;
            }
        }
        catch (InterruptedException interruptedException) {
        }
        catch (IOException iOException) {
            hc.error("File watcher service error", iOException);
        }
    }
}
