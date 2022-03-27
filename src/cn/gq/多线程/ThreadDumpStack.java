package cn.gq.多线程;

/**
 * @author cherry_xx
 * @create 2021/4/5 20:27
 * @update 2021/4/5
 * Description: 测试Thread的dumpStack
 * 实际上new了一个Exception 然后打印到了System.err
 * @since 1.0.0
 */
public class ThreadDumpStack {
    public static void main(String[] args) {
       Thread.dumpStack();
    }
}
