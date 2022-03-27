package cn.gq.多线程;

import java.util.concurrent.Semaphore;

/**
 * @author cherry_xx
 * @create 2021/3/28 16:45
 * @update 2021/3/28
 * Description: 实现线程的交替打印
 *  使用 Volatile
 * @since 1.0.0
 */
public class Juc交替打印4 {
}

class FooBar4 {
    private int n;

    public FooBar4(int n) {
        this.n = n;
    }


    private volatile boolean flag = true;
    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n;) {
            if(flag) {
                printFoo.run();
                flag = false;
                i++;
            }else {
                Thread.yield();
            }
            // printFoo.run() outputs "foo". Do not change or remove this line.

        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n;) {
            // printBar.run() outputs "bar". Do not change or remove this line.
          if(!flag) {
            printBar.run();
              i++;
              flag = true;
          }else  {
              Thread.yield();
          }

        }
    }
}
