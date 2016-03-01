package cn.trinea.android.common.util;

import android.annotation.SuppressLint;
import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Logger
{
    @SuppressLint("SdCardPath")

    private static final String LOGTAG = "App Log";

    public static final boolean debugMode = true;

    public static final boolean fileMode = true;

    public enum SCOPE {
        NETWORK      (0x00000001),
        IMAGE_LOADER (0x00000010),
        PROXY        (0x00000100),
        EXCEPTION    (0x00001000),
        FRAMEWORK    (0x00010000),
        ALL          (0x00011111);

        private int code;

        SCOPE(int i) {
            code = i;
        }

        public int getCode() {
            return code;
        }
    }

    private static DebugScope debugScopes = new DebugScope();

    @SuppressLint("SimpleDateFormat")
    private static SimpleDateFormat logTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");

    private static Date curretTime;

    public static void initDebugLog()
    {
        if (debugMode)
        {
            debugScopes.turnOn(SCOPE.ALL).turnOff(SCOPE.IMAGE_LOADER);
        }
    }

    public static void log(SCOPE scope, String clz, String msg)
    {
        innerPrint(scope, clz, msg);
    }

    public static void log(SCOPE scope, String msg)
    {
        log(scope, null, msg);
    }
    
    public static void log(String clz, String msg)
    {
        log(SCOPE.ALL, clz, msg);
    }

    public static void log(String clz, Throwable e)
    {
        log(SCOPE.EXCEPTION, clz, e.getMessage());
    }

    private static void innerPrint(SCOPE scope, String clz, String msg)
    {
        if (!debugScopes.contains(scope))
            return;
        if (clz == null || clz.trim().length() == 0)
        {
            Log.d(LOGTAG, scope.name() + " :: " + msg);
        }
        else
        {
            Log.d(LOGTAG, scope.name() + " :: " + clz + ": " + msg);
        }
        if (fileMode)
        {
            curretTime = new Date(System.currentTimeMillis());
            String f = logTime.format(curretTime);
            String result = f + " --- " + msg;
        }
    }

    private static class DebugScope {
        private int code = 0;

        public boolean contains(SCOPE scope) {
            return (code & scope.getCode()) != 0;
        }

        public DebugScope turnOn(SCOPE scope) {
            code |= scope.getCode();
            return this;
        }

        public DebugScope turnOff(SCOPE scope) {
            code &= (~scope.getCode() & SCOPE.ALL.getCode());
            return this;
        }
    }
}
