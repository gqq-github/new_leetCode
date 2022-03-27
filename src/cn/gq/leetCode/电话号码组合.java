package cn.gq.leetCode;

import java.util.*;

/**
 * @author cherry_xx
 * @create 2020/12/6 22:51
 * @update 2020/12/6
 * Description:
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 * <p>
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * @since 1.0.0
 */
public class 电话号码组合 {
    public static void main(String[] args) {
        System.out.println(letterCombinations(""));
    }

    //使用回溯法解决问题
    public static List<String> letterCombinations(String digits) {

        List<String> res = new ArrayList<>();
        if(digits.equals("")){
            return res;
        }
        HashMap<Character, String> map = new HashMap<>(16);
        map.put('1', "");
        map.put('0', "");
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        backtrack(res, digits.toCharArray(), 0, new StringBuilder(), map);
        return res;
    }

    /**
     * @param res   记录解空间
     * @param digit 数如的数字字符
     * @param index 当前遍历到的数字字符
     * @param bd    记录一个解
     */
    public static void backtrack(List<String> res, char[] digit, Integer index, StringBuilder bd, Map<Character, String> map) {
        if (index == digit.length) {
            res.add(bd.toString());
        } else {
            String letter = map.get(digit[index]);
            for (int i = 0; i < letter.length(); i++) {
                bd.append(letter.charAt(i));
                backtrack(res, digit, index+1, bd, map);
                bd.deleteCharAt(index);
            }
        }
    }
}
