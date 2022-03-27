package cn.gq.leetCode每日一题;

/**
 * @author cherry_xx
 * @create 2021/7/11 22:50
 * @update 2021/7/11
 * Description:
 * 面试题 17.10. 主要元素
 * 数组中占比超过一半的元素称之为主要元素。给你一个 整数 数组，找出其中的主要元素。若没有，返回 -1 。请设计时间复杂度为 O(N) 、空间复杂度为 O(1) 的解决方案。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：[1,2,5,9,5,9,5,5,5]
 * 输出：5
 * 示例 2：
 * <p>
 * 输入：[3,2]
 * 输出：-1
 * 示例 3：
 * <p>
 * 输入：[2,2,1,1,1,2,2]
 * 输出：2
 * @since 1.0.0
 */
public class 主要元素 {
    public static void main(String[] args) {
        int[] data = {3, 2, 3,2,3,2,1,3,3};
        System.out.println(majorityElement(data));
    }

    public static int majorityElement(int[] nums) {
        // 记录数字出现的频率
        int times = 0;
        int currentNum = nums[0];
        for (int num : nums) {
            if (num == currentNum) {
                times++;
            } else {
                times--;
                if (times <= 0) {
                    currentNum = num;
                    times++;
                }
            }
        }
        times = 0;
        for (int num : nums) {
            if (num == currentNum) {
                times++;
            }
        }
        return times > nums.length / 2 ? currentNum : -1;
    }
}
