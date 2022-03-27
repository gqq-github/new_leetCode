package cn.gq.动态规划;

import java.util.Scanner;

/**
 * @author cherry_xx
 * @create 2020/11/10 23:16
 * @update 2020/11/10
 * Description: 动态规划-最短编辑距离
 * @since 1.0.0
 */
public class Dp最短编辑距离 {
    public static void main(String[] args) {
       Scanner in = new Scanner(System.in);
       // 字符串A转化为字符串b
       String a = in.nextLine() ;
       String b = in.nextLine();
        int[][] f = new int[a.length() + 1][b.length() + 1];
        // f[i][j] 表示在字符串a的i之前转化为Bj之前的需要操作次数
        // 因为标取的是1开始所以 00 的时候操作次数就是0
        for (int i = 0; i <a.length()+1 ; i++) {
            f[i][0] = i;
        }
        for (int j = 0 ; j<b.length()+1; j++){
            f[0][j] = j;
        }
        // 上面的初始化实际上就是当前对应字符转化为另外一个字符串的次数

        for (int i = 1 ; i< a.length()+1 ; i++) {
            for (int j = 1 ; j<b.length()+1;j++) {
                if(a.charAt(i-1)==b.charAt(j-1)){
                    // 表示俩个字符相等那么操作次数就为前面操作次数
                    f[i][j] = f[i-1][j-1];
                }else {
                    f[i][j] = Math.min(f[i-1][j-1],Math.min(f[i-1][j],f[i][j-1]))+1;
                }
            }
        }
        System.out.println(f[a.length()][b.length()]);
    }
}
