package com.jye.devkit.base.log;

/**
 * @author jye
 * @since 1.0
 */
public class LogItem {
    private final long timeMillis;
    private final int level;
    private final String tag;
    private final String content;
    private final int pid;
    private final int tid;
    private final Thread thread;
    private final StackTraceElement[] stackTrace;

    public LogItem(int level, String tag, String content, int pid, int tid, Thread thread, StackTraceElement[] stackTrace) {
        this.timeMillis = System.currentTimeMillis();
        this.level = level;
        this.tag = tag;
        this.content = content;
        this.pid = pid;
        this.tid = tid;
        this.thread = thread;
        this.stackTrace = stackTrace;
    }

    public long getTimeMillis() {
        return timeMillis;
    }

    public int getLevel() {
        return level;
    }

    public String getTag() {
        return tag;
    }

    public String getContent() {
        return content;
    }

    public int getPid() {
        return pid;
    }

    public int getTid() {
        return tid;
    }

    public Thread getThread() {
        return thread;
    }

    public StackTraceElement[] getStackTrace() {
        return stackTrace;
    }
}
