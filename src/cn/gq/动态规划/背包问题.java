package cn.gq.动态规划;

import java.util.Scanner;

/**
 * @author cherry_xx
 * @create 2020/11/14 23:43
 * @update 2020/11/14
 * Description:
 * 定义状态转换方程
 * Fiv 表示背包容量为v 的时候放入前i件物品的最大价值
 * Fiv = max{f[i-1][v],f[i-1][v-w[i]]+p[i] } 这个方程就是 放入还是不放入这件物品
 * <p>
 * 压缩状态转换方程 进行优化 fv = max{fv,f[v-w[i]]+p[i]}
 * @since 1.0.0
 */
public class 背包问题 {
    public static void main(String[] args) {
        System.out.println("输入物品的数量：");
        Scanner scanner = new Scanner(System.in);
        //物品数量
        int m = scanner.nextInt();
        System.out.println("输入背包的容量：");
        int V = scanner.nextInt();
        int[] wight = new int[m + 1];
        int[] p = new int[m + 1];
        int dp[] = new int[V + 1];
        for (int i = 1; i <= m; i++) {
            System.out.println("输第" + i + "件物品的体积：");
            wight[i] = scanner.nextInt();
            System.out.println("输第" + i + "件物品的价值：");
            p[i] = scanner.nextInt();
        }
        for (int i = 1; i <= m; i++) {
            for (int j = V; j> 0; j--) {
                if (j - wight[i]>=0) {
                    dp[j] = Math.max(dp[j], dp[j - wight[i] ]+ p[i] );
                }
            }
        }
        int max = 0;
        for (int i = 0 ; i<=V ; i++) {
            max = max > dp[i] ? max : dp[i];
        }
        System.out.println(max);
    }
}
