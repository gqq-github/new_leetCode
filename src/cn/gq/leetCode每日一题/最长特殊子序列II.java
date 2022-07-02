package cn.gq.leetCode每日一题;

/**
 * @author cherry_xx
 * @create 2022/6/27 23:31
 * @update 2022/6/27
 * Description:
 * <p>
 * 给定字符串列表 strs ，返回其中 最长的特殊序列 。如果最长特殊序列不存在，返回 -1 。
 * <p>
 * 特殊序列 定义如下：该序列为某字符串 独有的子序列（即不能是其他字符串的子序列）。
 * <p>
 *  s 的 子序列可以通过删去字符串 s 中的某些字符实现。
 * <p>
 * 例如，"abc" 是 "aebdc" 的子序列，因为您可以删除"aebdc"中的下划线字符来得到 "abc" 。"aebdc"的子序列还包括"aebdc"、 "aeb" 和 "" (空字符串)。
 * <p>
 * 题解 ：
 * 题目要求 比较数组的字符串 是否在另一个字符串当中出现过 ，如果出现过那么就换另外一个 字符串进行匹配
 * @since 1.0.0
 */
public class 最长特殊子序列II {
    public static void main(String[] args) {
        String[] data = {"aabbcc", "aabbcc","cb"};
        System.out.println(findLUSlength(data));
    }

    public static int findLUSlength(String[] strs) {
        int maxLength = -1;
        boolean check;
        for (int i = 0; i < strs.length; i++) {
            check = true;
            for (int j = 0; j < strs.length; j++) {
                if (i != j && isSubString(strs[i], strs[j])) {
                    check = false;
                    break;
                }
            }
            if (check)
                maxLength = Math.max(maxLength, strs[i].length());
        }
        return maxLength;
    }

    /**
     * 目标串是不是 比较串的字串
     *
     * @param t1 目标串
     * @param t2 比较串
     * @return 比较完之后 pts1 == t1.length() t1 是t2的 子序列当然其 就是不是题目中要求的特殊子序列
     */
    public static boolean isSubString(String t1, String t2) {
        int pts1 = 0, pts2 = 0;
        while (pts1 < t1.length() && pts2 < t2.length()) {
            if (t1.charAt(pts1) == t2.charAt(pts2)) {
                pts1++;
            }
            pts2++;
        }
        return pts1 == t1.length();
    }
}
