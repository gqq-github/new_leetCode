package cn.gq.learn.juc;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author cherry_xx
 * @create 2021/3/27 11:00
 * @update 2021/3/27
 * Description: 学习ArrayList
 * <p>
 * throw ConcurrentModificationException
 * 造成这个异常的原因
 * @since 1.0.0
 */
public class LearnArrayList {
    public static void main(String[] args) {
        // 使用ArrayList 并发的进行写操作
//        ArrayList list = new ArrayList<>();
        //
        // List<Object> list = Collections.synchronizedList(new ArrayList<>());
        // 使用集合synchronizedList方法  实际是对加入的new ArrayList 进行了封装
        // 然后使用当前的new的ArrayList对象做为锁对象 然后实现线程安全

//        List<String>  list  =new Vector<>(); // 在方法上面添加Synchronized 关键字实现的实现线程安全 锁对象还是list
        List<String> list = new CopyOnWriteArrayList<>();


        list.add("dasda");
        for (int i = 1; i < 10; i++) {
            new Thread(() -> {
                String substring = UUID.randomUUID().toString().substring(0, 5);
                list.add(substring);
                System.out.println("<" + substring + ">" + Thread.currentThread().getName() + list.toString());
            }, String.valueOf(i)).start();
        }
        for (String s : list) {
            System.out.println("开始删除线程");
            list.remove(s);
        }
        System.out.println(list.toString());
    }

    static class testDelList {
        public static void main(String[] args) {
            List<String> list = Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9", "10");
            // 返回的ArrayList是其内部的静态类对象，这个静态类对象没有实现add和remove的方法
            list = new ArrayList<>(list);
            for (int i = 0; i < list.size(); i++) {
                list.remove(i);
            }
        }

    }
}
