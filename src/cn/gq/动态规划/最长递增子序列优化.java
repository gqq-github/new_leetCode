package cn.gq.动态规划;

/**
 * @author cherry_xx
 * @create 2020/11/16 22:23
 * @update 2020/11/16
 * Description:
 * 使用二分法的思想进行优化Dp[]数组的生成
 * @since 1.0.0
 */
public class 最长递增子序列优化 {
    public static void main(String[] args) {
        int[] data = {5, 1, 6, 8, 2, 4, 5, 10};
        int[] dpData1 = getDpData(data);
        int[] dpData = 最长递增子序列.getDpData(data);
        System.out.println();
    }

    /**
     * 使用一个临时数组来记录区间小值和最大值所记录
     *
     * @param data
     * @return
     */
    public static int[] getDpData(int data[]) {
        //分析： 首先如数据本身就是递增的序列那么这个记录的数组最大长度就是数据的长度
        int n = data.length;
        int[] dp = new int[n];
        int[] vis = new int[n];
        vis[0] = data[0];
        int l, r;
        int mid = 0;
        int len = 1;
        for (int i = 0; i < data.length; i++) {
            l = 0;r = len;
            while (l <= r) {
                mid = (l + r) >> 1;
                if (data[i] > vis[mid]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
            vis[l] = data[i];
            len = Math.max(l, r);
            dp[i] = l + 1;
        }
        System.out.println();
        return dp;
    }
}
