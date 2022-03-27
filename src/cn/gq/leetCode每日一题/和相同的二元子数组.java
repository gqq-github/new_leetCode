package cn.gq.leetCode每日一题;

import java.util.HashMap;

/**
 * @author cherry_xx
 * @create 2021/7/8 23:21
 * @update 2021/7/8
 * Description:
 * 给你一个二元数组 nums ，和一个整数 goal ，请你统计并返回有多少个和为 goal 的 非空 子数组。
 * <p>
 * 子数组 是数组的一段连续部分。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,0,1,0,1], goal = 2
 * 输出：4
 * 解释：
 * 有 4 个满足题目要求的子数组：[1,0,1]、[1,0,1,0]、[0,1,0,1]、[1,0,1]
 * 示例 2：
 * <p>
 * 输入：nums = [0,0,0,0,0], goal = 0
 * 输出：15
 * @since 1.0.0
 */
public class 和相同的二元子数组 {
    public static void main(String[] args) {
        int[] data = {0,0,0,0,0};
        int [] data2  = {1, 0, 1, 0, 1};
        System.out.println(numSubarraysWithSum(data2,2));
    }

    public static int numSubarraysWithSum(int[] nums, int goal) {
       // 解题的思路
        //1 假设我们给定的区间 i - j  是否和题意的 那么 F(i,j) = sum[i,j] = sum[j] -sum[i] = goal
        //即在符合题意的是时候可有 sum[i] = sum[j]-goal 即我们只要我们能知道 sum[i]-goal的个数 ，得到的
        // 这个个数就是我们的题解
        int n = nums.length;
        if(n==0) {
            return 0;
        }
        HashMap<Integer, Integer> map = new HashMap<>(16);
        int sum = 0;
        int res = 0;
        for (int num:nums) {
            map.put(sum, map.getOrDefault(sum, 0) + 1);
            sum += num;
            res += map.getOrDefault(sum-goal, 0);
        }
        return res;
    }
}
