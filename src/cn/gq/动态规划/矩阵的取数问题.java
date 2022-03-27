package cn.gq.动态规划;

import java.util.Scanner;

/**
 * @author cherry_xx
 * @create 2020/11/14 21:40
 * @update 2020/11/14
 * Description: 一个N*N矩阵中有不同的正整数，经过这个格子，就能获得相应价值的奖励，
 * 从左上走到右下，只能向下向右走，求能够获得的最大价值。
 * 例如：3 * 3的方格。
 * 1 3 3
 * 2 1 3
 * 2 2 1
 * 1.定义状态转化方程 矩阵的行列定义为mn
 * Fij = max{fi-1j,fij-1} +  data[i,j]
 * 分析边界 ：
 * 当 1<=i<m 0<j<n  </m> Fij = max{fi-1j,fij-1} +  data[i,j]
 * 当 1<=i<m j=0 Fij = Fi-1j+data[i,j]
 * 当i=0 0<j<m Fij= fij-1 +data[i,j]
 * 当i=0 j=0 fij = data[i,j]
 * @since 1.0.0
 */
public class 矩阵的取数问题 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        int F[][] = new int[m+1][n+1];
        for (int i = 0; i <=m; i++) {
            F[i][0] = 0;
        }
        for (int j = 0 ; j<=n ; j++) {
            F[0][j] = 0;
        }
        int max = 0;
        for (int i = 1 ; i<=m; i++) {
            for(int j = 1 ; j<=n ; j++){
                int input = in.nextInt();
                F[i][j] = Math.max(F[i - 1][j], F[i][j - 1]) + input;
                if(F[i][j]>max){
                    max = F[i][j];
                }
            }
        }
        System.out.println(max);
    }
}
