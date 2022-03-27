package cn.gq.面试1;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author cherry_xx
 * @create 2022/3/22 19:27
 * @update 2022/3/22
 * Description:
 * 有一整形变量a初始值为0, 开两个线程并发对变量a进行自增操作, a达到200后停止，每次操作过程中需输出线程号以及操作后的值。
 * @since 1.0.0
 */
public class ThreadInCreate {
    volatile static boolean  flag = true;
    public static AtomicInteger a = new AtomicInteger(0);
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(2);
        new Thread(() -> {
          while(flag){
              System.out.println(Thread.currentThread().getName()+"----"+inc());
          }
          countDownLatch.countDown();
        }).start();
        new Thread(() -> {
            while (flag) {
                System.out.println(Thread.currentThread().getName()+"----"+inc());
            }
            countDownLatch.countDown();
        }).start();
        countDownLatch.await();
        System.out.println(a);

    }
    public static int inc ()  {
        int i1 = a.incrementAndGet();
        if( i1==200) {
            flag = false;
        }
        return i1;
    }
}
