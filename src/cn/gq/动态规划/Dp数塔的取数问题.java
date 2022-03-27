package cn.gq.动态规划;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author cherry_xx
 * @create 2020/11/10 21:11
 * @update 2020/11/10
 * Description: 数塔的取数问题
 *
 * 一个高度为N的由正整数组成的三角形，从上走到下，求经过的数字和的最大值。
 * 每次只能走到下一层相邻的数上，例如从第3层的6向下走，只能走到第4层的2或9上。
 * 该三角形第n层有n个数字，例如：
 * 第一层有一个数字：5
 * 第二层有两个数字：8 4
 * 第三层有三个数字：3 6 9
 * 第四层有四个数字：7 2 9 5
 * 最优方案是：5 + 8 + 6 + 9 = 28
 * 注意:上面应该是排列成一个三角形的样子不是竖向对应的，排版问题没有显示成三角形。
 * 状态定义: Fi，j是第i行j列项最大取数和，求第n行Fn，m（0 < m < n）中最大值。
 * 状态转移方程：Fi，j = max{Fi-1,j-1,Fi-1,j}+Ai,jt
 *
 * 问题的状态转化方程
 *
 * dp[i][j] = dp[i-1][j]+data[i][j] 当j=0
 * dp[i][j] = max { dp[i-1][j-1] ,dp[i-1][j]} + data[i][j] 0<j<=i 的时候
 * @since 1.0.0
 */
public class Dp数塔的取数问题 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入三角形的层数");
        int cen = scanner.nextInt();
     // 输入记录dp的时候上层的数据实际上可知的
        int[][] dp = new int[cen][cen];
        System.out.println("输入第一层的数据");
        ArrayList<String> vis = new ArrayList<>();
        dp[0][0] = scanner.nextInt();
        int max = 0;
        vis.add("(" + 1 + "," + 0 + ")");
        for (int i = 1; i < cen ; i++) {
            System.out.println("输入"+(i+1)+"的数据");
            int preMax = 0;
             for (int j= 0 ; j<=i ; j++) {
                int num = scanner.nextInt();
                if(j==0) {
                    dp[i][j] = dp[i - 1][j] + num;
                }else {
                    dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]) + num;
                }

                 if(max<dp[i][j]){
                    max = dp[i][j];
                     preMax = j;
                }
            }
            vis.add("(" + (i+1) + "," + preMax + ")");

        }
        System.out.println("该数塔的最大值为"+max);
        StringBuilder stringBuffer = new StringBuilder();
        vis.forEach(s -> {
            stringBuffer.append(s).append("--->");
        });
        stringBuffer.delete(stringBuffer.lastIndexOf("-")-2, stringBuffer.length());
        System.out.println(stringBuffer.toString());
    }

}
