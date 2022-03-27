package cn.gq.动态规划;

import com.sun.xml.internal.ws.util.xml.CDATA;

import java.lang.management.ManagementFactory;
import java.util.ArrayList;

/**
 * @author cherry_xx
 * @create 2020/11/15 20:03
 * @update 2020/11/15
 * Description:
 * 最长递增子序列：
 * 定义状态转化方程 dp[i]定义为以I结尾的最长递增子序列那么
 * dp[i] = max{dp[i],dp[j]+1 (0<=j<i && data[j]<data[i])}
 * @since 1.0.0
 */
public class 最长递增子序列 {
    public static void main(String[] args) {
        int[] data = {5,1,6,8,2,4,5,10};
        doResult(data);
    }

    public static int[] getDpData(int[] data) {
        int dp[] = new int[data.length];
        for (int i = 0; i < data.length; i++) {
            // 开始他的最长递增子序列就是自己
            dp[i] = 1;
            for (int j = i; j >= 0; j--) {
                // 找出他之前比他小的最长递增序列+1就是他的递增子序列
                if (data[i] > data[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        return dp;
    }

    public static int getMaxIndex(int[] dp) {
        int maxIndex = 0;
        int max = 0;
        for (int i = 0 ; i<dp.length ; i++) {
            if(max<dp[i]) {
                max = dp[i];
                maxIndex = i;
            }
        }

        return maxIndex;
    }
    public static Integer [] getResult (int maxIndex,int [] data,int [] dp){
        int maxValue = data[maxIndex];
        int len = dp[maxIndex];
        ArrayList<Integer> res = new ArrayList<>();
        res.add(maxValue);
        Integer[] temp = new Integer[len];
        while (len!=1) {
            for (int i = 0; i < data.length ; i++) {
                if(dp[i]==dp[maxIndex]-1&&data[i]<data[maxIndex]){
                    res.add(data[i]);
                    maxIndex = i ;
                    len--;
                    break;
                }

            }
        }
        return res.toArray(temp);
    }
    public static void doResult(int data[]) {
        int[] dpData = getDpData(data);
        int maxIndex = getMaxIndex(dpData);
        Integer[] result = getResult(maxIndex, data, dpData);
        System.out.println();
    }
}
