package cn.gq.ThreadPoll;

import com.sun.org.apache.xpath.internal.objects.XNull;

import java.util.concurrent.*;

/**
 * @author cherry_xx
 * @create 2022/3/20 13:15
 * @update 2022/3/20
 * Description:
 * @since 1.0.0
 */
public class ThreadPollExcuterDemo {

    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10,10,30, TimeUnit.SECONDS,new ArrayBlockingQueue<>(10));
      System.gc();
    }

    static class MyThreadFactory implements ThreadFactory {

        private Thread.UncaughtExceptionHandler uncaughtExceptionHandler;
        private final static ThreadFactory threadFactory =Executors.defaultThreadFactory();

        MyThreadFactory(Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
            this.uncaughtExceptionHandler = uncaughtExceptionHandler;
        }

        @Override
        public Thread newThread(Runnable r) {
            Thread thread = threadFactory.newThread(r);
            thread.setUncaughtExceptionHandler(uncaughtExceptionHandler);
            return thread;
        }
    }
    static class DealThreadException implements Thread.UncaughtExceptionHandler {

        @Override
        public void uncaughtException(Thread t, Throwable e) {

        }
    }
}

