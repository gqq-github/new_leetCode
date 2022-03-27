package cn.gq.多线程;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author cherry_xx
 * @create 2021/3/28 16:45
 * @update 2021/3/28
 * Description: 实现线程的交替打印
 * 使用Lock+Volatile 实现
 * @since 1.0.0
 */
public class Juc交替打印2 {
}

class FooBar2 {
    private int n;

    public FooBar2(int n) {
        this.n = n;
    }

    private volatile boolean flag = true;
    private Lock lock = new ReentrantLock(true);
    public void foo(Runnable printFoo) throws InterruptedException {
        for (int i = 0; i < n; ) {
            lock.lock();
            try {
                if(flag) {
                    printFoo.run();
                    flag = false;
                    i++;
                }else {
                    Thread.yield();
                }

            } catch (Exception e) {

            }finally {
              lock.unlock();
            }


        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; ) {
            lock.lock();
            try {
               if(!flag) {
                   printBar.run();
                   flag = true;
                   i++;
               }else {
                   Thread.yield();
               }
            }catch ( Exception e) {

            }finally {
                lock.unlock();
            }
        }
    }
}
