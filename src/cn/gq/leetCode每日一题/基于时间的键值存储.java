package cn.gq.leetCode每日一题;

import java.util.*;

/**
 * @author cherry_xx
 * @create 2021/7/11 20:43
 * @update 2021/7/11
 * Description:
 * 创建一个基于时间的键值存储类 TimeMap，它支持下面两个操作：
 *
 * 1. set(string key, string value, int timestamp)
 *
 * 存储键 key、值 value，以及给定的时间戳 timestamp。
 * 2. get(string key, int timestamp)
 *
 * 返回先前调用 set(key, value, timestamp_prev) 所存储的值，其中 timestamp_prev <= timestamp。
 * 如果有多个这样的值，则返回对应最大的  timestamp_prev 的那个值。
 * 如果没有值，则返回空字符串（""）。
  题目的描述就是
  插入的时间是递增的
 */
public class 基于时间的键值存储 {
    public static void main(String[] args) {
        TimeMap timeMap = new TimeMap();
        timeMap.set("foo", "bar", 1);

        System.out.println(timeMap.get("foo", 1));
        System.out.println(timeMap.get("foo", 1));
        timeMap.set("foo", "bar2", 4);
        System.out.println(timeMap.get("foo", 4));
        System.out.println(timeMap.get("foo", 5));


        System.out.println((char)127+"");
    }

}


class TimeMap {
    public static Map<String, List<Value>> map = new HashMap<>();

    /**
     * Initialize your data structure here.
     */
    public TimeMap() {

    }

    public void set(String key, String value, int timestamp) {
        if (map.containsKey(key)) {
            List<Value> values = map.get(key);
            values.add(new Value(value, timestamp));
        } else {
            List<Value> values = new LinkedList<>();
            map.put(key, values);
            values.add(new Value(value, timestamp));
        }

    }

    public String get(String key, int timestamp) {
        List<Value> values = map.get(key);
        if (null == values) {
            return "";
        }
        int i = binarySearch(values, new Value((char)127+"", timestamp));
        if (i <= 0) {
            return "";
        }
        return values.get(i - 1).value;
    }

    private int binarySearch(List<Value> pairs, Value target) {
        int low = 0, high = pairs.size() - 1;
        if (high < 0 || pairs.get(high).compareTo(target) <= 0) {
            return high + 1;
        }
        while (low < high) {
            int mid = (high + low) >>> 1;
            Value pair = pairs.get(mid);
            if (pair.compareTo(target) <= 0) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    public static class Value implements Comparable<Value> {
        private String value;
        private int timeStamp;

        public Value(String value, int timeStamp) {
            this.value = value;
            this.timeStamp = timeStamp;
        }

        @Override
        public int compareTo(Value o) {
            if (this.timeStamp != o.timeStamp) {
                return this.timeStamp - o.timeStamp;
            } else {
                return this.value.compareTo(o.value);
            }
        }
    }
}

