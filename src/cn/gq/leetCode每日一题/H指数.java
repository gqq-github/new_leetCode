package cn.gq.leetCode每日一题;

import java.util.Arrays;

/**
 * @author cherry_xx
 * @create 2021/7/11 23:09
 * @update 2021/7/11
 * Description:
 * 给定一位研究者论文被引用次数的数组（被引用次数是非负整数）。编写一个方法，计算出研究者的 h 指数。
 *
 * h 指数的定义：h 代表“高引用次数”（high citations），一名科研人员的 h 指数是指他（她）的 （N 篇论文中）总共有 h 篇论文分别被引用了至少 h 次。且其余的 N - h 篇论文每篇被引用次数 不超过 h 次。
 *
 * 例如：某人的 h 指数是 20，这表示他已发表的论文中，每篇被引用了至少 20 次的论文总共有 20 篇。
 *
 *  
 * 输入：citations = [3,0,6,1,5]
 * 输出：3
 * 解释：给定数组表示研究者总共有 5 篇论文，每篇论文相应的被引用了 3, 0, 6, 1, 5 次。
 *      由于研究者有 3 篇论文每篇 至少 被引用了 3 次，其余两篇论文每篇被引用 不多于 3 次，所以她的 h 指数是 3。
 *  
 *
 * 提示：如果 h 有多种可能的值，h 指数是其中最大的那个。

 * @since 1.0.0
 */
public class H指数 {

    public static void main(String[] args) {
        int[] dat = {0, 2, 6,40, 1, 5};
        System.out.println(hIndex(dat));
        System.out.println(findH(dat));
    }

    public static  int hIndex(int[] citations) {
        // 实现的思路 排序之后 从大到小比较，当引用的次数和引用的篇数相等的时候
        Arrays.sort(citations);
        int time = 0 ;
        for (int i = citations.length-1;i>=0;i--) {
            if(time<citations[i]){
                time++;
            }
        }
        return time;
    }
    // 优化的思路使用二分查找来优化
    public static int findH(int [] citations ) {
        int left = 0 ;
        int n = citations.length;
        int right = n-1;
        if(right<0) {
            return -1;
        }
        if(right==0) {
            return 1;
        }
        int mid = 0;
        while (left<right) {
           mid = (left + right) >> 1;
            if(citations[mid]< n - mid){
                left = mid + 1;
            }else {
                right = mid;
            }
        }
        return n - left ;
    }

}
