package cn.gq.多线程;

import java.util.concurrent.CountDownLatch;

/**
 * @author cherry_xx
 * @create 2021/4/24 20:14
 * @update 2021/4/24
 * Description: 测试缓存行对程序的优化
 * @since 1.0.0
 */
public class CacheLineTest {
    public static long count = 1000010000L;

    public static class data {
        private  long p1,p2,p3,p4,p5,p6, p7;
        public long x = 0L;
        private  long pa,pb,pc,pd,pe,pf, pg;
    }

    public static data[] datas = new data[2];

    static {
        datas[0] = new data();
        datas[1] = new data();
    }

    public static void main(String[] args) throws InterruptedException {
    //    CacheLineTest cacheLineTest = new CacheLineTest();
        CountDownLatch latch = new CountDownLatch(2);
        Thread thread = new Thread(() -> {
            for (long i = 0; i < count ; i++) {
                datas[0].x = i;
            }
            latch.countDown();
        });
        Thread thread2 = new Thread(() -> {
            for (long i = 0; i < count ; i++) {
                datas[1].x = i;
            }
            latch.countDown();
        });
        long l = System.currentTimeMillis();
        thread.start();
        thread2.start();
         latch.await();
        System.out.println(System.currentTimeMillis()-l);
    }
}
