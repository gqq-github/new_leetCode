package cn.gq.多线程;

import java.util.concurrent.Semaphore;

/**
 * @author cherry_xx
 * @create 2021/3/28 16:45
 * @update 2021/3/28
 * Description: 实现线程的交替打印
 * 信号量机制
 * @since 1.0.0
 */
public class Juc交替打印3 {
}

class FooBar3 {
    private int n;

    public FooBar3(int n) {
        this.n = n;
    }


    private Semaphore semaphore1 = new Semaphore(1);
    private Semaphore semaphore2 = new Semaphore(0);
    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
             semaphore1.acquire();
            // printFoo.run() outputs "foo". Do not change or remove this line.
            printFoo.run();
            semaphore2.release();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            // printBar.run() outputs "bar". Do not change or remove this line.
            semaphore2.acquire();
            printBar.run();
            semaphore1.release();
        }
    }
}
