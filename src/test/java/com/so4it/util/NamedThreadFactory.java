package com.so4it.util;

import java.util.Objects;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class NamedThreadFactory implements ThreadFactory {

    private final static String NAMED_PATTERN = "%S-%S";
    private final ThreadGroup group;
    private final AtomicInteger threadNumber = new AtomicInteger(1);
    private final String namePrefix;
    private boolean daemon ;

    public NamedThreadFactory(String namePrefix) {
        this.namePrefix = Objects.requireNonNull(namePrefix,"namePrefix can't be null");
        group = getThreadGroup();
        daemon = true ;
    }

//    public NamedThreadFactory(String namePrefix, boolean daemon) {
//        super(Objects.requireNonNull(namePrefix));
//        this.daemon = daemon;
//    }

    private ThreadGroup getThreadGroup(){
        // Done in the same way as java.util.concurrent.Executors.DefaultThreadFactory.
        SecurityManager s = System.getSecurityManager();
        return (s != null) ? s.getThreadGroup() :
                Thread.currentThread().getThreadGroup();
    }

    @Override
    public Thread newThread(Runnable runnable) {
        Thread t = new Thread(group,runnable,String.format(NAMED_PATTERN,namePrefix,threadNumber.getAndIncrement()));
        return t;
    }
}
