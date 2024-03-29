package cn.gq.leetCode每日一题;

import java.util.Map;

/**
 * @author cherry_xx
 * @create 2022/6/30 23:24
 * @update 2022/6/30
 * Description:
 * 请你帮忙给从 1 到 n 的数设计排列方案，使得所有的「质数」都应该被放在「质数索引」（索引从 1 开始）上；你需要返回可能的方案总数。
 * <p>
 * 让我们一起来回顾一下「质数」：质数一定是大于 1 的，并且不能用两个小于它的正整数的乘积来表示。
 * <p>
 * 由于答案可能会很大，所以请你返回答案 模 mod 10^9 + 7 之后的结果即可。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 5
 * 输出：12
 * 解释：举个例子，[1,2,5,4,3] 是一个有效的排列，但 [5,2,3,4,1] 不是，因为在第二种情况里质数 5 被错误地放在索引为 1 的位置上。
 * 示例 2：
 * <p>
 * 输入：n = 100
 * 输出：682289015
 * @since 1.0.0
 * 解题思路 ：
 * 找出质数 的个数 m
 * m 的排列 mod 10^9+7 * n-m 的排列 mod 10^9 + 7  mod 10^9 +7
 */
public class 质数排列 {
    public static final int mod = (int) (Math.pow(10, 9) + 7);

    public static void main(String[] args) {
        System.out.println(numPrimeArrangements(100));
    }

    public static int numPrimeArrangements(int n) {
        int num = 0;
        for (int i = 1; i <= n; i++) {
            if (isPrime(i)) {
                num++;
            }
        }
        return (int) (factorial(num) * factorial(n - num) % mod);
    }

    public static long factorial(int nums) {
        long res = 1;
        for (int i = 1; i <= nums; i++) {
            res *= i;
            res %= mod;
        }
        return  res;
    }

    public static boolean isPrime(int n) {
        if (n == 1) {
            return false;
        }
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
