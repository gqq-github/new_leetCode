package cn.gq.多线程;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author cherry_xx
 * @create 2021/3/28 15:37
 * @update 2021/3/28
 * Description: 多线程并发打印有序输出
 * 使用
 * @since 1.0.0
 */
public class JucPrint2 {
    public static void main(String[] args) {

    }
}

class Foo2 {

    public Foo2() {

    }

    private final Object obj = new Object();
    private int flag = 1;

    public void first(Runnable printFirst) throws InterruptedException {
        synchronized (obj) {
            while (flag != 1) {
                obj.wait();
            }
            printFirst.run();
            flag = 2;
            obj.notifyAll();
        }


    }

    public void second(Runnable printSecond) throws InterruptedException {
        synchronized (obj) {
            while (flag != 2) {
                obj.wait();
            }
            printSecond.run();
            flag = 3;
            obj.notifyAll();
        }


    }

    public void third(Runnable printThird) throws InterruptedException {
        synchronized (obj) {
            while (flag != 3) {
                obj.wait();
            }
            printThird.run();
            obj.notifyAll();
            flag = 1;
        }

    }
}
