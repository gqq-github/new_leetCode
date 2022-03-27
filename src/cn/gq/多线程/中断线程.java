package cn.gq.多线程;

/**
 * @author cherry_xx
 * @create 2021/4/5 21:00
 * @update 2021/4/5
 * Description: 测试终端线程
 * Thread.interrupted() 调用的是
 *  currentThread().isInterrupted(true); 只有线程中断之后 执行这个方法才会更新状态
 *  所以线程中断的时候可以根据上述方法在执行线程的内部判断，抛出异常，实现。
 * @since 1.0.0
 */
public class 中断线程 {
    public static void main(String[] args) {
        Thread thread = new Thread(new myThread());
        thread.start();
      // thread.interrupt();
    }
}
class myThread implements  Runnable {

    @Override
    public void run() {
        worker();
    }
    public void  worker () {
        for (int i = 0; i < 10000 ; i++) {
            System.out.println(Thread.currentThread().getName()+i);
            // 主线程执行中断的操作设置
            if(Thread.currentThread().interrupted()) {

                System.out.println("接收到线程的终端标识"+Thread.currentThread().isInterrupted());
          }
        }
    }
}
