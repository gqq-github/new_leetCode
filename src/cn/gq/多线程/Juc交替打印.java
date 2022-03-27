package cn.gq.多线程;

/**
 * @author cherry_xx
 * @create 2021/3/28 16:45
 * @update 2021/3/28
 * Description: 实现线程的交替打印
 * N 比较大时候存在问题 会超时
 * @since 1.0.0
 */
public class Juc交替打印 {
}

class FooBar {
    private int n;

    public FooBar(int n) {
        this.n = n;
    }

    private volatile boolean flag = true;
    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            while (flag) {
                Thread.yield();
            }
            // printFoo.run() outputs "foo". Do not change or remove this line.
            printFoo.run();
            flag = false;
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            while (!flag) {
                Thread.yield();
            }
            // printBar.run() outputs "bar". Do not change or remove this line.
            printBar.run();
            flag = true;
        }
    }
}
