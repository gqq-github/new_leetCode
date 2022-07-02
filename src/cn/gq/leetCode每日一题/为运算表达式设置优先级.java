package cn.gq.leetCode每日一题;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cherry_xx
 * @create 2022/7/1 21:18
 * @update 2022/7/1
 * Description:
 * <p>
 * 给你一个由数字和运算符组成的字符串 expression ，按不同优先级组合数字和运算符，计算并返回所有可能组合的结果。你可以 按任意顺序 返回答案。
 * <p>
 * 生成的测试用例满足其对应输出值符合 32 位整数范围，不同结果的数量不超过 104 。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：expression = "2-1-1"
 * 输出：[0,2]
 * 解释：
 * ((2-1)-1) = 0
 * (2-(1-1)) = 2
 * 示例 2：
 * <p>
 * 输入：expression = "2*3-4*5"
 * 输出：[-34,-14,-10,-10,10]
 * 解释：
 * (2*(3-(4*5))) = -34
 * ((2*3)-(4*5)) = -14
 * ((2*(3-4))*5) = -10
 * (2*((3-4)*5)) = -10
 * (((2*3)-4)*5) = 10
 * @since 1.0.0
 */
public class 为运算表达式设置优先级 {
    public static void main(String[] args) {
        System.out.println(diffWaysToCompute("2*3-4*5"));
    }
    public static int optionCompute(char option, int leftNum, int rightNum) {
        int res = 0;
        switch (option) {
            case '+':
                res = leftNum + rightNum;
                break;
            case '-':
                res = leftNum - rightNum;
                break;
            case '*':
                res = leftNum * rightNum;
                break;
            default:
                return res;
        }
        return res;
    }

    public static List<Integer> diffWaysToCompute(String expression) {
        return DFSdoCompute(expression);
    }

    public static boolean isOption(char a) {
        return a == '+' || a == '-' || a == '*';
    }

    public static List<Integer> DFSdoCompute(String str) {
        if (str == null || str.length() == 0) {
            return new ArrayList<>();
        }
        char[] chars = str.toCharArray();
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < chars.length; i++) {
            if (isOption(chars[i])) {
                List<Integer> left = DFSdoCompute(str.substring(0, i));
                List<Integer> right = DFSdoCompute(str.substring(i + 1));
                for (Integer lt : left) {
                    for (Integer rt : right) {
                        res.add(optionCompute(chars[i], lt , rt));
                    }
                }
            }
        }
        if (res.isEmpty()) {
            res.add(Integer.valueOf(str));
        }
        return res;
    }
}
