package cn.gq.多线程.实现线程安全;

/**
 * @author cherry_xx
 * @create 2021/4/5 21:50
 * @update 2021/4/5
 * Description: 加锁之后类的字节码文件
 * @since 1.0.0
 */
public class SynThread {
    public synchronized static  void test () {

    }
    public static void main(String[] args) {
        test();
    }
}
