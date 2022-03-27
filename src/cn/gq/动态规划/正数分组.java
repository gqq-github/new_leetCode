package cn.gq.动态规划;

import java.util.Scanner;

/**
 * @author cherry_xx
 * @create 2020/11/22 22:56
 * @update 2020/11/22
 * Description: 正数分组使其得到的分组之差最小
 * 分析 极限的条件下俩个数组的差为0 sumA = (sum)/2 (sumA == sumB)
 *  只要尽可能的保证 数据叫起来接近 （sum）/2 就一定能保证得到的数组之差最小
 *  类似于背包问题 就是往里面添加尽可能多的数字
 *  dp[i] = max{dp[i],dp[i-data[j]]+data[j]} (j<i) (i == (sum)/2)
 *
 *  @since 1.0.0
 */
public class 正数分组 {
    public static void main(String[] args) {
        System.out.println(getMinSub());
    }
    public static int getMinSub () {
        System.out.println("输入数组的长度");
         Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int data[] = new int[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            data[i] = in.nextInt();
            sum += data[i];
        }
        int dp[] = new int[(sum >> 1) + 1];
        for (int i = 0; i <n; i++) {
            for (int j = dp.length-1 ; j>0 ; j--) {
                if(j>=data[i]){
                    dp[j] = Math.max(dp[j], dp[j - data[i]] + data[i]);
                }
            }
        }
        int max = 0;
        for (int value : dp) {
            max = Math.max(max, value);
        }
        return Math.abs(sum - 2*max);
    }
}
