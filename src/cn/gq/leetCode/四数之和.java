package cn.gq.leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author cherry_xx
 * @create 2021/3/30 22:13
 * @update 2021/3/30
 * Description:
 * 给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
 * <p>
 * 注意：答案中不可以包含重复的四元组。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/4sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @since 1.0.0
 */
public class 四数之和 {
    public static void main(String[] args) {
        int[] data = {-2,-1,-1,1,1,2,2};
        System.out.println(fourSum(data, 0));
    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        // 使用双指针的方法实现
        List<List<Integer>> result = new ArrayList<>();
        int length = nums.length;
        if (length < 4) {
            return result ;
        }

        Arrays.sort(nums);
        // 确定第一个数据
        for (int i = 0; i < length - 3; i++) {
            // 如果当前按序执行累加时候，发现是大于我们的目标值那么数组中之和是没有响应的target的值
            if (nums[i] + nums[i + 1]*3>target) {
                break;
            }
            if (nums[i] + nums[nums.length - 1] * 3 < target) {
                continue;
            }
            // 去重操作
            if (i>0&&nums[i] == nums[i-1]) {
                continue;
            }
            // 确定第二个数字
            for (int j = i + 1; j < length-2; j++) {
                if(j!=i+1&&nums[j-1]==nums[j]) continue;
                int left = j + 1;
                int right = length - 1;
                while (left < right) {
                    int res = nums[i] + nums[j] + nums[left] + nums[right];
                    if (res > target) {
                        while (left<right&&nums[right-1]==nums[right]) {
                            right--;
                        }
                        right--;
                    } else if (res < target) {
                        while (left<right&&nums[left+1]==nums[left]){
                            left++;
                        }
                        left++;
                    } else {
                        List<Integer> data = new ArrayList<>();
                        data.add(nums[i]);
                        data.add(nums[j]);
                        data.add(nums[left]);
                        data.add(nums[right]);
                        result.add(data);
                        while (left<right&&nums[right-1]==nums[right]){
                            right--;
                        }while (left<right&&nums[left+1]==nums[left]){
                            left++;
                        }

                        left++;
                        right--;

                    }
                }
            }
        }
        return result;
    }
}
