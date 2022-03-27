package cn.gq.learn.juc;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author cherry_xx
 * @create 2021/3/27 17:57
 * @update 2021/3/27
 * Description:
 * @since 1.0.0
 */
public class LearnCurrentHashMap {
    public static void main(String[] args) {
        ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();
        map.put("123", "test");

    }
}
