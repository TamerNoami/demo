package com.so4it.util;

import java.util.Objects;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.logging.Logger;

public class RecurringBlockingTask<T> implements AutoCloseable {


    private static final Logger LOGGER= Logger.getLogger("RunningTask");
    private Thread thread;
    private SingleDrainRunnable taskRunnable;
    private BlockingQueue<T> queue;

    public RecurringBlockingTask(ThreadFactory threadFactory, BlockingQueue<T> queue) {
        this.taskRunnable = new SingleDrainRunnable(this);
        this.thread = Objects.requireNonNull(threadFactory,"threadFactory can't be null").newThread(this.taskRunnable);
        this.queue = Objects.requireNonNull(queue,"queue can't be null");
    }

    @Override
    public void close() throws Exception {

    }







    private static class SingleDrainRunnable implements Runnable{


        private volatile boolean running = false;
        private RecurringBlockingTask<T> recurringrTask;

        public SingleDrainRunnable(RecurringBlockingTask<T> recurringrTask) {
            this.recurringrTask = recurringrTask;
        }
        public void setRunning(boolean running){
            this.running = running ;
        }

        public boolean isRunning(){
            return running;
        }

        @Override
        public void run() {
            T t = null;
            while (!Thread.currentThread().isInterrupted() && this.running){
                try{
                    //t = RecurringBlockingTask.this.
                }catch (Throwable e){

                }
            }
        }
    }


}
