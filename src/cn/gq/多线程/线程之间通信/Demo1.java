package cn.gq.多线程.线程之间通信;

/**
 * @author cherry_xx
 * @create 2021/4/18 19:23
 * @update 2021/4/18
 * Description: 测试线程之间的通信
 * @since 1.0.0
 */
public class Demo1 {
    public static void main(String[] args) throws InterruptedException {
        Object o = new Object();
        new Thread(new Thread1(o)).start();
        //Thread.sleep(3000);
        new Thread(new Thread2(o)).start();
        Thread thread = new Thread();
        thread.join();
    }
}

class Thread1 implements Runnable{
    private Object lock;
    public Thread1(Object lock) {
        this.lock = lock;
    }
    @Override
    public void run() {
        synchronized (lock){
            System.out.println("线程1获取到了锁资源");
            int i = 1 / 0;
//            try {
//                lock.wait();
//            } catch (InterruptedException e) {
//
//            }
            System.out.println("线程1被唤醒");
        }
    }
}

class Thread2 implements Runnable{
    private Object lock;
    public Thread2(Object lock) {
        this.lock = lock;
    }
    @Override
    public void run() {
        synchronized (lock){
            System.out.println("线程2获取到了锁资源");
            lock.notify();
            System.out.println("线程2唤醒等待中的线程");
        }
    }
}
