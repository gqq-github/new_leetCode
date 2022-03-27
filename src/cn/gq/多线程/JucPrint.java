package cn.gq.多线程;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author cherry_xx
 * @create 2021/3/28 15:37
 * @update 2021/3/28
 * Description: 多线程并发打印有序输出
 * @since 1.0.0
 */
public class JucPrint {
    public static void main(String[] args) {

    }
}

class Foo {

    public Foo() {

    }

    private Lock lock = new ReentrantLock();
    private final Condition condition = lock.newCondition();
    private volatile int  flag = 1;

    public void first(Runnable printFirst) throws InterruptedException {
        lock.lock();
        try {
            while (flag != 1) {
                condition.await();
            }
            printFirst.run();
            condition.signalAll();
            flag = 2;
        } catch (Exception e) {

        } finally {
            lock.unlock();
        }

    }

    public void second(Runnable printSecond) throws InterruptedException {
        lock.lock();
        try {
            while (flag != 2) {
                condition.await();
            }
            // printSecond.run() outputs "second". Do not change or remove this line.
            printSecond.run();
            condition.signalAll();
            flag = 3;
        } catch (Exception e) {

        } finally {
            lock.unlock();
        }


    }

    public void third(Runnable printThird) throws InterruptedException {

        lock.lock();
        try {
            while (flag != 3) {
                condition.await();
            }
            // printThird.run() outputs "third". Do not change or remove this line.
            printThird.run();
            condition.signalAll();
            flag = 1;
        } catch (Exception e) {

        } finally {
            lock.unlock();
        }

    }
}
