package cn.gq.leetCode;

import java.util.Arrays;

/**
 * @author cherry_xx
 * @create 2021/3/2 23:30
 * @update 2021/3/2
 * Description:
 * 给你一个用字符数组 tasks 表示的 CPU 需要执行的任务列表。其中每个字母表示一种不同种类的任务。任务可以以任意顺序执行，并且每个任务都可以在 1 个单位时间内执行完。在任何一个单位时间，CPU 可以完成一个任务，或者处于待命状态。
 *
 * 然而，两个 相同种类 的任务之间必须有长度为整数 n 的冷却时间，因此至少有连续 n 个单位时间内 CPU 在执行不同的任务，或者在待命状态。
 *
 * 你需要计算完成所有任务所需要的 最短时间 。
 *
 *  执行的任务
 *      B  A  待定   N = 2
 *      B   待定
 *  思路 首先最多任务的优先执行
 *
 */
public class 任务调度器 {

    public static int leastInterval(char[] tasks, int n) {
      // 首先获取最多任务
        int[] task = new int[26];
        for (int i = 0; i < tasks.length; i++) {
            task[tasks[i] - 'A']++;
        }
        Arrays.sort(task);
        // 表示执行第一个任务
        int maxCount = 0;
        for (int i = 25; i>=0; i--) {
            if(task[i]==task[25]) {
                maxCount++;
            }
        }
        int res = (n + 1) * (task[25] - 1) + maxCount;
        // 因为存在一个任务里面都是不同的任务，此时任务任务最短时间就是任务数组的长度
        return Math.max(res, tasks.length);
    }

    public static void main(String[] args) {
        char[] data = {'A', 'A', 'A', 'B', 'B', 'B'};
        System.out.println(leastInterval(data, 3));
    }
}
