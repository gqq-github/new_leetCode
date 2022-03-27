package cn.gq.多线程;

/**
 * @author cherry_xx
 * @create 2021/3/28 15:37
 * @update 2021/3/28
 * Description: 多线程并发打印有序输出
 * 使用 volatile 实现线程同步
 * @since 1.0.0
 */
public class JucPrint3 {
    public static void main(String[] args) {

    }
}

class Foo3 {

    public Foo3() {

    }

    private volatile int flag = 1;

    public void first(Runnable printFirst) throws InterruptedException {
        while (flag != 1) {

        }
        printFirst.run();
        flag = 2;


    }

    public void second(Runnable printSecond) throws InterruptedException {
            while (flag !=2 ) {

            }
            printSecond.run();
            flag = 3;

    }

    public void third(Runnable printThird) throws InterruptedException {
             while (flag!=3) {

             }
            printThird.run();


    }
}
