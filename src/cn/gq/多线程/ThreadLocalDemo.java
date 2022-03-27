package cn.gq.多线程;

/**
 * @author cherry_xx
 * @create 2021/4/24 21:51
 * @update 2021/4/24
 * Description: 测试他threadLocal
 * @since 1.0.0
 */
public class ThreadLocalDemo {
    public static ThreadLocal<String> local = new ThreadLocal<>();
    public static ThreadLocal<String> local2 = new ThreadLocal<>();

    public static void main(String[] args) {
      new Thread(()-> {
          local.set(Thread.currentThread().getName()+"1");
          local2.set(Thread.currentThread().getName()+"2");

          System.out.println(local.get());
          local.remove();
      }) .start();

        new Thread(()-> {
            local.set(Thread.currentThread().getName()+"1");
            System.out.println(local.get());
        }) .start();
    }
}
