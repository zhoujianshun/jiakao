package top.imono.jk.common.utils;

public class Debugs {
    public static final boolean DEBUG = true;
    public static void run(Runnable runnable){
        if(!DEBUG || runnable == null) return;
        runnable.run();
    }
}
