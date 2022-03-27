package cn.gq.leetCode;

import java.util.Arrays;

/**
 * @author cherry_xx
 * @create 2020/12/6 21:51
 * @update 2020/12/6
 * Description:
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。
 * 找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 *示例：
 *
 * 输入：nums = [-1,2,1,-4], target = 1
 * 输出：2
 * 解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
 *  
 *
 * 提示：
 *
 * 3 <= nums.length <= 10^3
 * -10^3 <= nums[i] <= 10^3
 * -10^4 <= target <= 10^4
 *
 * @since 1.0.0
 */
public class 最接近的三数之和 {
    public static void main(String[] args) {
        int nums[] = {11, 2, 1, -4};
        System.out.println(threeSumClosest(nums, 1));
    }
    public static int threeSumClosest(int[] nums, int target) {
      // 首先对数数据进行排序
        // 如果target 和小于target那个需要移动左指针，大于则移动右指针 记录着一趟中和目标数最小的一个
        Arrays.sort(nums);
        int left, right;
        int min = Integer.MAX_VALUE;
        int res;
        int vis = 0 ;
        for (int i = 0 ; i < nums.length ; i++) {
            left = i + 1;
            right = nums.length - 1;
            while (left<right) {
                 res = nums[i] + nums[left] + nums[right];
                 int temp  = Math.abs(target-(nums[i] + nums[left] + nums[right]));
                if(res<target){
                    left++;
                }else if(res==target) {
                    return res;
                }else {
                    right--;
                }
             if(temp<min){
                 min = temp;
                 vis = res;
             }
            }
        }
        return vis ;
    }
}
