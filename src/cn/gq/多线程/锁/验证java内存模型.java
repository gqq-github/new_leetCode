package cn.gq.多线程.锁;

/**
 * @author cherry_xx
 * @create 2021/4/10 22:49
 * @update 2021/4/10
 * Description:
 * @since 1.0.0
 */
public class 验证java内存模型 {
    public static void main(String[] args) throws InterruptedException {
        ThreadA threadA = new ThreadA();
        threadA.setName("线程1");
        threadA.start();
//        Thread.sleep(1000);
//        System.out.println("开始修改线程里面值");
//        threadA.setCont(false);

        Thread.sleep(1000);
        new Thread(()->{
           threadA.setCont(false);
            System.out.println("我想终止线程A");
        },"线程2").start();
    }

}
class ThreadA extends Thread {
    private boolean isCont = true;
    public  void doPrint() throws InterruptedException {
        while (isCont) {
           System.out.println(Thread.currentThread().getName()+"run");
//         sleep(1000);
        }
    }

    @Override
    public void run() {
        super.run();
        try {
            doPrint();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public boolean isCont() {
        return isCont;
    }

    public void setCont(boolean cont) {
        isCont = cont;
    }
}