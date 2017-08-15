package com.xwy.slog;

import android.support.annotation.NonNull;
import android.util.Log;

import com.orhanobut.logger.Logger;

/**
 * Created by xwy on 2017/8/14.
 */

public class SLog {
    public static boolean logFlag = true;

    private static final String defTag = "SLog";
    public static int logLevel = Log.VERBOSE;

    private String mClassName;

    private static SLog logger;

    private SLog(String name) {
        mClassName = name;
        Logger.init(name);
    }



    public static void setTag(String tag) {
        if (logger != null) {
            logger.mClassName = tag;
            Logger.init(tag);
        }
    }

    public static void setDefTag() {
        if (logger != null) {
            logger.mClassName = defTag;
            Logger.init(defTag);
        }
    }

    public static SLog getUtils(String Tag) {
        if (logger == null) {
            logger = new SLog(Tag);
        }
        return logger;
    }

    public static SLog getUtils() {
        if (logger == null) {
            logger = new SLog(defTag);
        }
        return logger;
    }

    /**
     * Info 级别日志
     *
     * @param str
     */
    public void i(@NonNull Object str) {
        if (logFlag) {
            if (logLevel <= Log.INFO) {
                Logger.i(str.toString());
            }
        }

    }

    /**
     * Debug 级别日志
     *
     * @param str
     */
    public void d(@NonNull Object str) {
        if (logFlag) {
            if (logLevel <= Log.DEBUG) {
                Logger.d(str.toString());
            }
        }
    }

    /**
     * Verbose 级别日志
     *
     * @param str
     */
    public void v(@NonNull Object str) {
        if (logFlag) {
            if (logLevel <= Log.VERBOSE) {
                Logger.v(str.toString());
            }
        }
    }

    /**
     * Warn 级别日志
     *
     * @param str
     */
    public void w(@NonNull Object str) {
        if (logFlag) {
            if (logLevel <= Log.WARN) {
                Logger.w(str.toString());
            }
        }
    }

    /**
     * Error 级别日志
     *
     * @param o
     */
    public void e(@NonNull Object o) {
        if (o != null && logFlag && logLevel <= Log.ERROR) {
            Logger.e(o.toString());
        }
    }

    /**
     * Error 异常信息日志
     *
     * @param ex
     */
    public void e(Exception ex) {
        if (ex != null && logFlag && logLevel <= Log.ERROR) {
            Logger.e(ex, null);
        }
    }

    /**
     * Error 异常信息日志
     *
     * @param log
     * @param tr
     */
    public void e(String log, Throwable tr) {
        if (log != null && tr != null && logFlag && logLevel <= Log.ERROR) {
            Logger.e(tr, log);
        }
    }

    public void json(String json) {
        if (json != null && logFlag) {
            Logger.json(json);
        }
    }

    public void xml(String xml) {
        if (xml != null && logFlag) {
            Logger.xml(xml);
        }
    }
}
