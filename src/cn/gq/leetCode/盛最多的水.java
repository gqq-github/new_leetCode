package cn.gq.leetCode;

/**
 * @author cherry_xx
 * @create 2020/11/29 18:14
 * @update 2020/11/29
 * Description: 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。
 * 在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0) 。找出其中的两条线，
 * 使得它们与 x 轴共同构成的容器可以容纳最多的水。  说明：你不能倾斜容器。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/container-with-most-water
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @since 1.0.0
 * <temp>输入：[1,8,6,2,5,4,8,3,7]
 * 输出：49
 * 解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，
 * 容器能够容纳水（表示为蓝色部分）的最大值为 49。
 * <temp/>
 */
public class 盛最多的水 {
    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        System.out.println(getMaxArea(height));
    }
    public static int  getMaxArea ( int height []) {
         //1.暴力解法俩层循环 来找出最大的范围
        if(!validate(height)){
            return -1;
        }
        int max = 0 ;
        for (int i = 0 ; i<height.length ; i++) {

            for (int j = i+1 ; j<height.length; j++) {
                int min = Math.min(height[i], height[j]);
                max = Math.max(max, min * (j - i));
            }
        }
        return max;
    }
    public static  boolean validate(int height []) {
        if(height.length==0) {
            return false;
        }
        return true;
    }
}
