package cn.gq.动态规划;

import java.util.ArrayList;

/**
 * @author cherry_xx
 * @create 2020/11/22 16:41
 * @update 2020/11/22
 * Description: 最大字段之和
 * @since 1.0.0
 */
public class 最大字段和 {
    public static void main(String [] args) {
        int[] data = {-2,11,-4,13,-5,-2};
        int i = maxValue(data);
        System.out.println(i);
    }

    /**
     * 状态转化方程
     * maxValue = dp [n] n = data.length
     * dp[i] = max(dp[i-1],dp[i-1]+data[i])
     * @param data 入参数据
     * @return
     */
    public  static  int maxValue(int data [] ) {
        int n = data.length;
        int max = 0;
        int now = 0;
        ArrayList<Integer> integers = new ArrayList<>();
        for (int i= 0 ; i < n  ; i++) {
            now = now + data[i];
            if(max<now){
                max = now;
                integers.add(i);
            }
            if(now<0){
                now = 0;
            }
        }
        return max;
    }
}
