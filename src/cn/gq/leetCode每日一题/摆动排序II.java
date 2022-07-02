package cn.gq.leetCode每日一题;

import java.util.Arrays;

/**
 * @author cherry_xx
 * @create 2022/6/29 23:19
 * @update 2022/6/29
 * Description:
 * <p>
 * 给你一个整数数组 nums，将它重新排列成 nums[0] < nums[1] > nums[2] < nums[3]... 的顺序。
 * <p>
 * 你可以假设所有输入数组都可以得到满足题目要求的结果。
 * <p>
 * 解题思路
 * 拷贝一个数组，对其进行排序
 * 排序之后 将 对应的 序列 按照题目要求放置到对应的数组里面
 * @since 1.0.0
 */
public class 摆动排序II {
    public static void main(String[] args) {
        int[] data = {1,1,2,1,2,2,1};
        wiggleSort(data);
        System.out.println();
    }

    public static void wiggleSort(int[] nums) {
        int[] ints = Arrays.copyOf(nums, nums.length);
        Arrays.sort(ints);
        int mid = (nums.length+1) >> 1;
        for (int i = 0 , f = mid-1 , l = nums.length-1 ; i < nums.length; i += 2) {
            nums[i] = ints[f--];
            if (i + 1 < nums.length) {
                nums[i + 1] = ints[l--];
            }
        }

    }
}
