package cn.gq.leetCode每日一题;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @author cherry_xx
 * @create 2022/6/28 0:03
 * @update 2022/6/28
 * Description:
 * 给定一个整数 n 和一个 无重复 黑名单整数数组 blacklist 。设计一种算法，从 [0, n - 1] 范围内的任意整数中选取一个 未加入 黑名单 blacklist 的整数。任何在上述范围内且不在黑名单 blacklist 中的整数都应该有 同等的可能性 被返回。
 * <p>
 * 优化你的算法，使它最小化调用语言 内置 随机函数的次数。
 * <p>
 * 实现 Solution 类:
 * <p>
 * Solution(int n, int[] blacklist) 初始化整数 n 和被加入黑名单 blacklist 的整数
 * int pick() 返回一个范围为 [0, n - 1] 且不在黑名单 blacklist 中的随机整数
 * <p>
 * 因为blackList 不能重复 并且 blackList[i] < n   0 <= blacklist[i] < n
 * 我们设 blackList.length() = m
 * 我们将 blackList 中的元素放到 n-m 的序列当中
 * 我们使用随机数的时候 如果取到对应blackList 中的元素 我们就将其 {[n-m],m} 的序列当中
 * 实际上就是 当 blackList[i] > n-m 位置不变， 否则就映射到 n-m -到 n 里面非黑名单的位置
 * @since 1.0.0
 */
public class 黑名单中的随机数 {
    public static void main(String[] args) {
        Solution solution = new Solution(4, new int[]{0, 1});
        System.out.println(solution.pick());
        System.out.println(solution.pick());
        System.out.println(solution.pick());
        System.out.println(solution.pick());
        System.out.println(solution.pick());
        System.out.println(solution.pick());
        System.out.println(solution.pick());
    }
}

class Solution {
    private final Random random = new Random();
    private int n;
    private int[] blackList;
    private Map<Integer, Integer> mapRelation = new HashMap<>();
    private int pos;

    public Solution(int n, int[] blacklist) {
        this.n = n;
        this.blackList = blacklist;
        this.pos = n - blacklist.length-1 ;
        initMapRelation();
    }

    public void initMapRelation() {
        int weightL = n - blackList.length;
        for (int i = 0; i < blackList.length; i++) {
            // -1 表示需要映射
            mapRelation.put(blackList[i], blackList[i] > weightL ? blackList[i] : -1);
        }

        for (int i = 0; i < blackList.length; i++) {
            if (mapRelation.getOrDefault(blackList[i], 0) == -1) {
                // 需要映射
                mapRelation.put(blackList[i], findPos());
            }
        }
    }

    public int findPos() {
        pos++;
        while (mapRelation.containsKey(pos) && pos < n) {
            pos++;
        }
        return pos;
    }

    public int pick() {
        int i = random.nextInt(n - blackList.length);
        return mapRelation.getOrDefault(i, i);
    }
}

