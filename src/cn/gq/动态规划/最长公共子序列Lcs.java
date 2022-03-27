package cn.gq.动态规划;

/**
 * @author cherry_xx
 * @create 2020/11/22 17:19
 * @update 2020/11/22
 * Description: 最长公共子序列
 * 定义状态转换方程
 * dp[i][j] 表示A串（0-i）和B串（0-j）的最长公共子序列的长度
 * dp[i][j] = max(dp[i-1][j],dp[i][j-1]) dataA[i]!=dataB[j]
 * dp[i][j] = dp[i-1][j-1] + 1 dataA[i] = data[j]
 * @since 1.0.0
 */
public class 最长公共子序列Lcs {
    public static void main(String[] args) {
        String A = "abcicba";
        String B = "abdkscab";
        char[] dataA = A.toCharArray();
        char[] dataB = B.toCharArray();
        int dp[][] = new int[dataA.length + 1][dataB.length+1];
        for (int i = 1 ; i<dataA.length+1 ; i++) {
              for (int j = 1 ; j<dataB.length+1 ; j++) {
                   if(dataA[i-1]==dataB[j-1]) {
                       dp[i][j] = dp[i - 1][j - 1] + 1;
                   }else {
                       dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                   }
              }
        }
        System.out.println(getResultString(dp, dataA, dataB));
    }
    public static String getResultString(int [] [] dp , char[] dataA , char [] dataB ) {
        int lenA = dataA.length;
        int lenB = dataB.length;
        int len = dp[dataA.length][dataB.length];
        StringBuilder res = new StringBuilder();
        while (len>0) {
            if(dp[lenA-1][lenB] == dp[lenA][lenB-1] && dp[lenA][lenB] == (dp[lenA-1][lenB]+1) ){
                res.append(dataA[lenA-1]);
                len--;
                lenA--;
                lenB--;
            }else  {
                // 表示dp[i][j]的所使用的值是来自哪一个字符
                // 因为dp[i][j] 可能等于dp[i-1][j] 或者 dp[i][j-1]
                if(dp[lenA-1][lenB]==dp[lenA][lenB]){
                    lenA--;
                }else {
                    lenB--;
                }
            }
        }
        return res.toString();
    }
}
