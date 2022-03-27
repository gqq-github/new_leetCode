package cn.gq.leetCode;

/**
 * @author cherry_xx
 * @create 2020/11/29 19:25
 * @update 2020/11/29
 * Description: 使用双指针的形式进行代码的优化
 * // 能够优化的前提：
 *  当最俩个指针所指的那个值小那么他就是限制盛最大值的界限，所以应该找到值较大的
 *  移动指针
 * @since 1.0.0
 */
public class 盛最多的水优化 {
    public static void main(String[] args) {
        int height[] = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(getMaxArea(height));
    }
    public static int getMaxArea (int height [] ) {
         if(height.length==0) {
             return -1;
         }
        int left = 0;
        int right = height.length - 1;
        int max = 0;
        while (left!=right) {
            max = Math.max(max, Math.min(height[left], height[right])*(right-left));
            if(height[left]>height[right]){
                right--;
            }else  {
                left++;
            }
        }
        return max;
    }
}
